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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.NumCo.numberconverter.Cipher.CipherDialogs.ImageDialog;
import com.NumCo.numberconverter.Cipher.CipherDialogs.PreferencesDialog;
import com.NumCo.numberconverter.Cipher.ImageCreator;
import com.NumCo.numberconverter.Database.Queries;
import com.NumCo.numberconverter.History.HistoryCommands;
import com.NumCo.numberconverter.History.HistoryDialog;
import com.NumCo.numberconverter.Numerals.Binary;
import com.NumCo.numberconverter.Numerals.Decimal;
import com.NumCo.numberconverter.Numerals.Hexadecimal;
import com.NumCo.numberconverter.Numerals.Numeral;
import com.NumCo.numberconverter.Numerals.Octal;
import com.NumCo.numberconverter.Numerals.RomanNumeral;
import com.NumCo.numberconverter.ObjectPainter.Status;
import com.NumCo.numberconverter.Objects.HISTORY;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter extends AppCompatActivity implements Notify, HistoryCommands {

    private static final ConversionList conversionList = new ConversionList();
    private static final String[] inputConversionList = conversionList.inputConversionList;
    private static final String[] outputConversionList = conversionList.outputConversionList;

    private static String inputOption = "";
    private static String outputOption = "";

    private static Numeral numeral;
    private TextInputLayout displayOutput;
    private TextInputLayout displayInput;
    private AutoCompleteTextView inputConversionAutoText = null;
    private TextInputLayout outputConversionLayout = null;
    private AutoCompleteTextView outputConversionAutoText = null;
    private ScrollView parentLayout = null;
    private SharedPreferences sharedPreferences;

    private Context context;
    private short cipherPreferencesDialogCounter = 0, cipherImageDialogCounter = 0, viewHistoryCounter = 0;
    private PreferencesDialog cipherPreferencesDialog;
    private ImageDialog cipherImageDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        context = this;

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
            Snackbar.make(parentLayout, event.getAction() + ", " + keyCode, Snackbar.LENGTH_SHORT).setBackgroundTint(Status.ERROR.color).show();

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
            makeSnackBar("Cannot Interchange Options", Status.OUTPUT.color);
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

            new Queries().addHistory(new HISTORY(inputOption,
                    numeral.value,
                    outputOption,
                    Objects.requireNonNull(displayOutput.getEditText()).getText().toString()), this);

        } catch (Exception e) {
            if (inputOption.equals(outputOption))
                makeSnackBar("Invalid Output Selection", Status.ERROR.color);
            else if (displayInput.getEditText().getText().toString().trim().equals(""))
                makeSnackBar("Input Empty", Status.ERROR.color);
            else
                makeSnackBar("Invalid Input", Status.ERROR.color);
        }
    }

    public void copyOutput(View v) {

        String output = Objects.requireNonNull(displayOutput.getEditText()).getText().toString();

        if (!output.trim().isEmpty()) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText(outputOption, output);
            clipboardManager.setPrimaryClip(clipData);
            makeSnackBar("Output Copied to Clipboard", Status.NORMAL.color);
        } else
            makeSnackBar("Output is Empty", Status.INPUT.color);
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
                cipherPreferencesDialog = new PreferencesDialog(this, getSupportFragmentManager(), getLifecycle());
                cipherPreferencesDialog.setOnDismissListener(dialog -> cipherPreferencesDialogCounter = 0);
                cipherPreferencesDialog.show();
            });
        }
    }

    public void cipherImageDialog(View v) {
        if (++cipherImageDialogCounter == 1) {

            setNumeralObject(Objects.requireNonNull(displayInput.getEditText()).getText().toString().trim());

            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                try {

                    if (inputOption.equals(outputOption))
                        throw new IllegalStateException();

                    String zeroes = "";
                    Matcher matcher = Pattern.compile("^(0*)(\\w*)$", Pattern.MULTILINE)
                            .matcher(Objects.requireNonNull(displayInput.getEditText()).getText()
                                    .toString().trim());
                    if (matcher.find()) {
                        if (matcher.group(1) != null)
                            zeroes = matcher.group(1);
                        numeral.setValue(matcher.group(2));
                    }

                    ImageCreator cipherImageCreator = new ImageCreator(zeroes + numeral.toDec(), this);

                    cipherImageDialog = new ImageDialog(this, cipherImageCreator.generate(), this);
                    cipherImageDialog.setOnDismissListener(dialog -> cipherImageDialogCounter = 0);
                    cipherImageDialog.show();

                } catch (Exception e) {
                    if (inputOption.equals(outputOption))
                        makeSnackBar("Invalid Output Selection", Status.ERROR.color);
                    else if (Objects.requireNonNull(displayInput.getEditText()).getText().toString().trim().equals(""))
                        makeSnackBar("Input Empty", Status.ERROR.color);
                    else
                        makeSnackBar("Invalid Input", Status.ERROR.color);
                }
                cipherImageDialogCounter = 0;
            });
        }
    }

    public void viewHistoryDialog(View view) {
        if (++viewHistoryCounter == 1) {
            HistoryDialog historyDialog = new HistoryDialog(this, this);
            historyDialog.setOnDismissListener(dialog -> viewHistoryCounter = 0);
            historyDialog.show();
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

    public void makeSnackBar(String msg, int color) {
        final Snackbar snackbar = Snackbar.make(parentLayout, msg, Snackbar.LENGTH_SHORT).setBackgroundTint(color);
        snackbar.setAction(R.string.close, v -> snackbar.dismiss()).setActionTextColor(Color.WHITE).show();
    }

    @Override
    public void makeSnackBar(String msg, int color, @StringRes int resId, Runnable runnable) {
        final Snackbar snackbar = Snackbar.make(parentLayout, msg, Snackbar.LENGTH_SHORT).setBackgroundTint(color);
        snackbar.setAction(resId, v -> {
            if (runnable != null) {
                runnable.run();
            } else {
                snackbar.dismiss();
            }
        }).setActionTextColor(Color.WHITE).show();
    }

    @Override
    public void setHistoryValue(HISTORY history) {
        inputConversionAutoText.setText(history.INPUT_TYPE, false);
        outputConversionAutoText.setText(history.OUTPUT_TYPE, false);

        Objects.requireNonNull(displayInput.getEditText()).setText(history.INPUT);
        Objects.requireNonNull(displayOutput.getEditText()).setText(history.OUTPUT);

        makeSnackBar("History Copied", Status.PLACEHOLDER.color);
    }
}