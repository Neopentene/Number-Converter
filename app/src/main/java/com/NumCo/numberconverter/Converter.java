package com.NumCo.numberconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.NumCo.numberconverter.CipherCreation.CipherObjectBitmaps;
import com.NumCo.numberconverter.CipherCreation.CipherPreferencesDialog;
import com.NumCo.numberconverter.Numerals.Octal;
import com.NumCo.numberconverter.Numerals.RomanNumeral;
import com.NumCo.numberconverter.Numerals.Binary;
import com.NumCo.numberconverter.Numerals.Decimal;
import com.NumCo.numberconverter.Numerals.Hexadecimal;
import com.NumCo.numberconverter.Numerals.Numeral;
import com.example.numberconverter.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Converter extends AppCompatActivity {

    private static final ConversionList conversionList = new ConversionList();
    private static final String[] inputConversionList = conversionList.inputConversionList;
    private static final String[] outputConversionList = conversionList.outputConversionList;

    private static String inputOption = "";
    private static String outputOption = "";

    private static Numeral numeral;

    private AutoCompleteTextView inputConversionAutoText = null;
    private TextInputLayout outputConversionLayout = null;
    private AutoCompleteTextView outputConversionAutoText = null;
    private RelativeLayout parentLayout = null;

    TextInputLayout displayOutput;
    TextInputLayout displayInput;

    private SharedPreferences sharedPreferences;

    private Context context;
    private short cipherPreferencesDialogCounter = 0;
    private CipherPreferencesDialog cipherPreferencesDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        context = this;

        TextInputLayout inputConversionLayout = findViewById(R.id.InputConversion);
        inputConversionAutoText = findViewById(R.id.InputConversionDropdown);
        outputConversionLayout = findViewById(R.id.OutputConversion);
        outputConversionAutoText = findViewById(R.id.OutputConversionDropdown);
        parentLayout = findViewById(R.id.parentRelativeConvertor);

        displayInput = findViewById(R.id.InputIn);
        displayOutput = findViewById(R.id.OutputOut);

        sharedPreferences = context.getSharedPreferences("saved-options", MODE_PRIVATE);

        inputOption = sharedPreferences.getString("input", "DEC");
        setInputAdapter();

        outputOption = sharedPreferences.getString("output", "HEX");
        changeOutputAdapter(inputOption);

        setInputOnChangeListener();
        setOutputOnChangeListener();

        inputConversionAutoText.setText(inputOption, false);
        outputConversionAutoText.setText(outputOption, false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setInputAdapter();
        changeOutputAdapter(inputOption);
    }

    private void setInputOnChangeListener() throws NullPointerException {
        inputConversionAutoText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not Required
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputOption = s.toString();

                if (inputOption.equals(outputOption)) {
                    outputConversionLayout.setError("Invalid");
                } else {
                    outputConversionLayout.setError(null);
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("input", inputOption);
                editor.apply();

                setNumsObject(Objects.requireNonNull(displayInput.getEditText()).getText().toString());

                changeOutputAdapter(inputOption);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not Required
            }
        });
    }

    private void setOutputOnChangeListener() {
        outputConversionAutoText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not Required
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (inputOption.equals(s.toString())) {
                    outputConversionLayout.setError("Invalid");
                } else {
                    outputConversionLayout.setError(null);

                    outputOption = s.toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("output", outputOption);
                    editor.apply();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not Required
            }
        });
    }

    private void setNumsObject(String value) throws NullPointerException {

        switch (inputOption) {
            case "DEC":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_NUMBER);
                numeral = new Decimal(value);
                break;
            case "HEX":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_TEXT);
                numeral = new Hexadecimal(value);
                break;
            case "OCT":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_NUMBER);
                numeral = new Octal(value);
                break;
            case "BIN":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_NUMBER);
                numeral = new Binary(value);
                break;
        }
    }

    private void changeOutputAdapter(String value) {
        outputConversionAutoText.setAdapter(new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, removeListItem(value)));
    }

    private void setInputAdapter() {
        inputConversionAutoText.setAdapter(new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, inputConversionList));
    }

    private String[] removeListItem(String item) {
        boolean itemFound = false;
        int listItem = 0;
        String[] newList = new String[Converter.outputConversionList.length];

        for (String s : Converter.outputConversionList) {
            if (s.equals(item)) {
                itemFound = true;
            } else {
                newList[listItem] = s;
                listItem++;
            }
        }

        if (itemFound) {
            return newList;
        }
        return outputConversionList;
    }

    public void convert(View v) {
        setNumsObject(Objects.requireNonNull(displayInput.getEditText()).getText().toString().trim());
        try {
            if (inputOption.equals(outputOption))
                throw new IllegalStateException();

            switch (outputOption) {
                case "ROM":
                    Objects.requireNonNull(displayOutput.getEditText()).setText(new RomanNumeral(numeral.toDec()).toRmn().toUpperCase());
                    break;
                case "DEC":
                    Objects.requireNonNull(displayOutput.getEditText()).setText(numeral.toDec().toUpperCase());
                    break;
                case "HEX":
                    Objects.requireNonNull(displayOutput.getEditText()).setText(numeral.toHex().toUpperCase());
                    break;
                case "OCT":
                    Objects.requireNonNull(displayOutput.getEditText()).setText(numeral.toOct().toUpperCase());
                    break;
                case "BIN":
                    Objects.requireNonNull(displayOutput.getEditText()).setText(numeral.toBin().toUpperCase());
                    break;
            }
        } catch (Exception e) {
            if (displayInput.getEditText().getText().toString().trim().equals(""))
                Snackbar.make(parentLayout, "Input Empty", Snackbar.LENGTH_SHORT).show();
            else if (inputOption.equals(outputOption))
                Snackbar.make(parentLayout, "Invalid Output Selection", Snackbar.LENGTH_SHORT).show();
            else
                Snackbar.make(parentLayout, "Invalid Input", Snackbar.LENGTH_SHORT).show();
        }
    }

    public void copyOutput(View v) {

        String output = Objects.requireNonNull(displayOutput.getEditText()).getText().toString();

        if (!output.trim().isEmpty()) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("Output Copied", output);
            clipboardManager.setPrimaryClip(clipData);

            Toast.makeText(context, "Output Copied to Clipboard", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(context, "Output is Empty", Toast.LENGTH_LONG).show();
        }
    }

    public void aboutUsDialog(View v) {
        View aboutUsDialog = getLayoutInflater().inflate(R.layout.about_us_dialog_layout, null);
        TextView title = aboutUsDialog.findViewById(R.id.Title);
        TextView description = aboutUsDialog.findViewById(R.id.Description);
        MaterialButton actionButton = aboutUsDialog.findViewById(R.id.actionButton);

        title.setText(R.string.about_us);
        title.setTextColor(getResources().getColor(R.color.dark_blue));
        title.setTypeface(null, Typeface.BOLD);
        title.setTextSize(20);

        description.setText(R.string.made_with);
        description.setTextColor(getResources().getColor(R.color.dark_teal));

        actionButton.setText(R.string.back);

        AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(aboutUsDialog);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.transparent_dialog);
        dialog.show();

        actionButton.setOnClickListener(v1 -> dialog.dismiss());
    }

    public void cipherPreferencesDialog(View v) {
        if (++cipherPreferencesDialogCounter == 1) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                cipherPreferencesDialog = new CipherPreferencesDialog(new CipherObjectBitmaps(Color.GRAY), this, getSupportFragmentManager(), getLifecycle());
                cipherPreferencesDialog.setOnDismissListener(dialog -> cipherPreferencesDialogCounter = 0);
                cipherPreferencesDialog.show();
            });
        }
    }
}