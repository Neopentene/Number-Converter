package com.NumCo.numberconverter;

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
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.NumCo.numberconverter.CipherCreation.CipherConstantObjectBitmaps;
import com.NumCo.numberconverter.CipherCreation.CipherImageCreator;
import com.NumCo.numberconverter.CipherCreation.CipherImageDialog;
import com.NumCo.numberconverter.CipherCreation.CipherObjectBitmaps;
import com.NumCo.numberconverter.CipherCreation.CipherPreferencesDialog;
import com.NumCo.numberconverter.Numerals.Binary;
import com.NumCo.numberconverter.Numerals.Decimal;
import com.NumCo.numberconverter.Numerals.Hexadecimal;
import com.NumCo.numberconverter.Numerals.Numeral;
import com.NumCo.numberconverter.Numerals.Octal;
import com.NumCo.numberconverter.Numerals.RomanNumeral;
import com.NumCo.numberconverter.ObjectPainter.ObjectBitmapStatus;
import com.example.numberconverter.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter extends AppCompatActivity {

    private static final ConversionList conversionList = new ConversionList();
    private static final String[] inputConversionList = conversionList.inputConversionList;
    private static final String[] outputConversionList = conversionList.outputConversionList;

    private static String inputOption = "";
    private static String outputOption = "";

    private static Numeral numeral;
    private TextInputLayout displayOutput;
    private TextInputLayout displayInput;
    private AutoCompleteTextView inputConversionAutoText = null;
    private TextInputLayout inputConversionLayout = null;
    private TextInputLayout outputConversionLayout = null;
    private AutoCompleteTextView outputConversionAutoText = null;
    private ScrollView parentLayout = null;
    private SharedPreferences sharedPreferences;

    private Context context;
    private short cipherPreferencesDialogCounter = 0, cipherImageDialogCounter = 0;
    private CipherPreferencesDialog cipherPreferencesDialog;
    private CipherImageDialog cipherImageDialog;

    private CipherObjectBitmaps cipherObjectBitmaps;
    private CipherConstantObjectBitmaps cipherConstantObjectBitmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        context = this;

        cipherObjectBitmaps = new CipherObjectBitmaps();
        cipherConstantObjectBitmaps = new CipherConstantObjectBitmaps();

        inputConversionLayout = findViewById(R.id.InputConversion);
        inputConversionAutoText = findViewById(R.id.InputConversionDropdown);
        outputConversionLayout = findViewById(R.id.OutputConversion);
        outputConversionAutoText = findViewById(R.id.OutputConversionDropdown);
        parentLayout = findViewById(R.id.parentScrollViewConvertor);

        displayInput = findViewById(R.id.InputIn);
        displayOutput = findViewById(R.id.OutputOut);

        sharedPreferences = context.getSharedPreferences("saved-options", MODE_PRIVATE);

        inputOption = sharedPreferences.getString("input", "DEC");
        setInputAdapter();

        outputOption = sharedPreferences.getString("output", "HEX");
        changeOutputAdapter(inputOption);

        setInputOnChangeListener();
        setOutputOnChangeListener();
        setOnKeyListeners();

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

                setNumeralObject(Objects.requireNonNull(displayInput.getEditText()).getText().toString());

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

    private void setOnKeyListeners() {
        inputConversionAutoText.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == 66) {
                Objects.requireNonNull(displayInput.getEditText()).requestFocus();
                return true;
            }
            return false;
        });

        outputConversionAutoText.setOnKeyListener((v, keyCode, event) -> {
            Snackbar.make(parentLayout, event.getAction() + ", " + keyCode, Snackbar.LENGTH_SHORT).setBackgroundTint(ObjectBitmapStatus.ERROR.color).show();

            if (keyCode == 66) {
                Objects.requireNonNull(displayInput.getEditText()).requestFocus();
                return true;
            }
            return false;
        });

        Objects.requireNonNull(displayInput.getEditText()).setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == 66) {
                convert();
                return true;
            }
            return false;
        });
    }

    private void setNumeralObject(String value) throws NullPointerException {
        switch (inputOption) {
            case "DEC":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
                numeral = new Decimal(value);
                break;
            case "HEX":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_FLAG_SIGNED);
                numeral = new Hexadecimal(value);
                break;
            case "OCT":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
                numeral = new Octal(value);
                break;
            case "BIN":
                Objects.requireNonNull(displayInput.getEditText()).setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
                numeral = new Binary(value);
                break;
        }
    }

    private void changeOutputAdapter(String value) {
        outputConversionAutoText.setAdapter(new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, removeStringArrayItem(outputConversionList, value)));
    }

    private void setInputAdapter() {
        inputConversionAutoText.setAdapter(new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, inputConversionList));
    }

    public void exchangeInputOutput(View v) {
        if (!outputOption.equals("ROM")) {
            String temp = inputOption;
            inputOption = outputOption;
            outputOption = temp;
            outputConversionAutoText.setText(temp, false);
            inputConversionAutoText.setText(inputOption, false);
        } else
            makeSnackBar("Cannot Interchange Options", ObjectBitmapStatus.ACTIVE_OUTPUT.color);
    }

    public void convert(View v) {
        convert();
    }

    private void convert() {
        setNumeralObject(Objects.requireNonNull(displayInput.getEditText()).getText().toString().trim());
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
            if (inputOption.equals(outputOption))
                makeSnackBar("Invalid Output Selection", ObjectBitmapStatus.ERROR.color);
            else if (displayInput.getEditText().getText().toString().trim().equals(""))
                makeSnackBar("Input Empty", ObjectBitmapStatus.ERROR.color);
            else
                makeSnackBar("Invalid Input", ObjectBitmapStatus.ERROR.color);
        }
    }

    public void copyOutput(View v) {

        String output = Objects.requireNonNull(displayOutput.getEditText()).getText().toString();

        if (!output.trim().isEmpty()) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText(outputOption, output);
            clipboardManager.setPrimaryClip(clipData);
            makeSnackBar("Output Copied to Clipboard", ObjectBitmapStatus.THEME.color);
        } else
            makeSnackBar("Output is Empty", ObjectBitmapStatus.ACTIVE_INPUT.color);
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
                cipherPreferencesDialog = new CipherPreferencesDialog(cipherObjectBitmaps,
                        cipherConstantObjectBitmaps, this,
                        getSupportFragmentManager(), getLifecycle());
                cipherPreferencesDialog.setOnDismissListener(dialog -> cipherPreferencesDialogCounter = 0);
                cipherPreferencesDialog.show();
            });
        }
    }

    public void cipherImageDialog(View v) {
        if (++cipherImageDialogCounter == 1) {

            setNumeralObject(Objects.requireNonNull(displayInput.getEditText()).getText().toString().trim());
            if (inputOption.equals(outputOption))
                throw new IllegalStateException();

            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                try {
                    String zeroes = "";
                    Matcher matcher = Pattern.compile("^(0*)(\\w*)$", Pattern.MULTILINE)
                            .matcher(Objects.requireNonNull(displayInput.getEditText()).getText()
                                    .toString().trim());
                    if (matcher.find()) {
                        if (matcher.group(1) != null)
                            zeroes = matcher.group(1);
                        numeral.setValue(matcher.group(2));
                    }
                    CipherImageCreator cipherImageCreator = new CipherImageCreator(zeroes + numeral.toDec(), new CipherObjectBitmaps(), this);
                    cipherImageDialog = new CipherImageDialog(this, cipherImageCreator.generate());
                    cipherImageDialog.setOnDismissListener(dialog -> cipherImageDialogCounter = 0);
                    cipherImageDialog.show();
                } catch (Exception e) {
                    if (inputOption.equals(outputOption))
                        makeSnackBar("Invalid Output Selection", ObjectBitmapStatus.ERROR.color);
                    else if (Objects.requireNonNull(displayInput.getEditText()).getText().toString().trim().equals(""))
                        makeSnackBar("Input Empty", ObjectBitmapStatus.ERROR.color);
                    else
                        makeSnackBar("Invalid Input", ObjectBitmapStatus.ERROR.color);
                }
                cipherImageDialogCounter = 0;
            });
        }
    }

    private static String[] removeStringArrayItem(String[] list, String item) {
        boolean itemFound = false;
        int listItem = -1;
        String[] newList = new String[list.length - 1];

        for (String s : list) {
            if (s.equals(item)) {
                itemFound = true;
            } else {
                if (listItem + 1 == newList.length)
                    break;
                newList[++listItem] = s;
            }
        }

        if (itemFound) {
            return newList;
        }
        return list;
    }

    private void makeSnackBar(String msg, int color) {
        final Snackbar snackbar = Snackbar.make(parentLayout, msg, Snackbar.LENGTH_SHORT).setBackgroundTint(color);
        snackbar.setAction(R.string.close, v -> snackbar.dismiss()).setActionTextColor(Color.WHITE).show();
    }
}