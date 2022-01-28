package com.example.numberconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numberconverter.Numerals.Binary;
import com.example.numberconverter.Numerals.Decimal;
import com.example.numberconverter.Numerals.Hexadecimal;
import com.example.numberconverter.Numerals.Numeral;
import com.example.numberconverter.Numerals.Octal;
import com.example.numberconverter.Numerals.RomanNumeral;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class Converter extends AppCompatActivity {

    private static final String[] inputConversionList = {"DEC", "HEX", "OCT", "BIN"};
    private static final String[] outputConversionList = {"ROM", "DEC", "HEX", "OCT", "BIN"};

    private static String inputOption = "";
    private static String outputOption = "";

    private static Numeral numeral;

    TextInputLayout inputConversionLayout;
    AutoCompleteTextView inputConversionAutoText;
    TextInputLayout outputConversionLayout;
    AutoCompleteTextView outputConversionAutoText;

    TextInputLayout displayOutput;
    TextInputLayout displayInput;

    private SharedPreferences sharedPreferences;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        context = this;

        inputConversionLayout = findViewById(R.id.InputConversion);
        inputConversionAutoText = findViewById(R.id.InputConversionDropdown);
        outputConversionLayout = findViewById(R.id.OutputConversion);
        outputConversionAutoText = findViewById(R.id.OutputConversionDropdown);

        displayInput = findViewById(R.id.InputIn);
        displayOutput = findViewById(R.id.OutputOut);

        sharedPreferences = context.getSharedPreferences("saved-options", MODE_PRIVATE);

        inputOption = sharedPreferences.getString("input", "DEC");
        changeInputAdapter();

        outputOption = sharedPreferences.getString("output", "HEX");
        changeOutputAdapter();

        setInputOnChangeListener();
        setOutputOnChangeListener();

        inputConversionAutoText.setText(inputOption, false);
        outputConversionAutoText.setText(outputOption, false);

    }

    private void setInputOnChangeListener() throws NullPointerException {
        inputConversionAutoText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputOption = s.toString();

                if (inputOption.equals(outputOption)) {
                    Toast.makeText(context, "Invalid Output Selection", Toast.LENGTH_SHORT).show();
                    outputConversionAutoText.setText(outputConversionList[0], false);
                    outputConversionLayout.setErrorEnabled(true);
                    outputConversionLayout.setError("Invalid");
                }
                else{
                    outputConversionLayout.setErrorEnabled(false);
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("input", inputOption);
                editor.apply();

                setNumsObject(displayInput.getEditText().getText().toString());

                changeOutputAdapter();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setOutputOnChangeListener() {
        outputConversionAutoText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (inputOption.equals(s.toString())) {
                    Toast.makeText(context, "Invalid Output Selection", Toast.LENGTH_SHORT).show();
                    outputConversionLayout.setErrorEnabled(true);
                    outputConversionLayout.setError("Invalid");
                }
                else{
                    outputConversionLayout.setErrorEnabled(false);

                    outputOption = s.toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("output", outputOption);
                    editor.apply();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setNumsObject(String value) throws NullPointerException {
        switch (inputOption) {
            case "DEC":
                displayInput.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
                numeral = new Decimal(value);
                break;
            case "HEX":
                displayInput.getEditText().setInputType(InputType.TYPE_CLASS_TEXT);
                numeral = new Hexadecimal(value);
                break;
            case "OCT":
                displayInput.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
                numeral = new Octal(value);
                break;
            case "BIN":
                displayInput.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
                numeral = new Binary(value);
                break;
        }
    }

    private void changeOutputAdapter() {
        outputConversionAutoText.setAdapter(new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, removeListItem(outputConversionList, inputOption)));
    }

    private void changeInputAdapter() {
        inputConversionAutoText.setAdapter(new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, removeListItem(inputConversionList, outputOption)));
    }

    private String[] removeListItem(String[] list, String item) {
        boolean itemFound = false;
        int listItem = 0;
        String[] newList = list;

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                itemFound = true;
                break;
            }
        }

        if (itemFound) {
            newList = new String[list.length - 1];
            for (int i = 0; i < list.length; i++) {
                if (!list[i].equals(item)) {
                    newList[listItem] = list[i];
                    listItem++;
                }
            }
        }
        return newList;
    }

    public void convert(View v) {
        setNumsObject(displayInput.getEditText().getText().toString().trim());
        try {
            if(inputOption.equals(outputOption))
                throw new IllegalStateException();

            switch (outputOption) {
                case "ROM":
                    displayOutput.getEditText().setText(new RomanNumeral(numeral.toDec()).toRmn().toUpperCase());
                    break;
                case "DEC":
                    displayOutput.getEditText().setText(numeral.toDec().toUpperCase());
                    break;
                case "HEX":
                    displayOutput.getEditText().setText(numeral.toHex().toUpperCase());
                    break;
                case "OCT":
                    displayOutput.getEditText().setText(numeral.toOct().toUpperCase());
                    break;
                case "BIN":
                    displayOutput.getEditText().setText(numeral.toBin().toUpperCase());
                    break;
            }
        } catch (Exception e) {
            if (displayInput.getEditText().getText().toString().trim().equals(""))
                Toast.makeText(context, "Input Empty", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }

    public void copyOutput(View v) {

        String output = displayOutput.getEditText().getText().toString();

        if (!output.trim().isEmpty()) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("Output Copied", output);
            clipboardManager.setPrimaryClip(clipData);

            Toast.makeText(context, "Output Copied to Clipboard", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(context, "Output is Empty", Toast.LENGTH_LONG).show();
        }
    }

    public void aboutUsDialog(View v){
        View aboutUsDialog = getLayoutInflater().inflate(R.layout.about_us_dialog_layout, null);
        TextView title = aboutUsDialog.findViewById(R.id.Title);
        TextView description = aboutUsDialog.findViewById(R.id.Description);
        MaterialButton actionButton = aboutUsDialog.findViewById(R.id.actionButton);

        View one= aboutUsDialog.findViewById(R.id.titleDivider);
        //one.setVisibility(View.INVISIBLE);

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

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}