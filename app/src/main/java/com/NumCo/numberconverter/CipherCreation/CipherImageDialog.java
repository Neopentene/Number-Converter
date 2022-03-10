package com.NumCo.numberconverter.CipherCreation;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.numberconverter.R;
import com.google.android.material.button.MaterialButton;

public class CipherImageDialog extends Dialog {
    private Bitmap bitmap;

    public CipherImageDialog(@NonNull Context context, Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cipher_image_dialog);
        ImageView imageView = findViewById(R.id.cipherImage);
        imageView.setImageBitmap(bitmap);

        MaterialButton backButton = findViewById(R.id.cipherBackButton);
        backButton.setText(R.string.back);
        backButton.setOnClickListener(v -> dismiss());

        MaterialButton saveButton = findViewById(R.id.cipherSaveButton);
        saveButton.setText(R.string.save);
        saveButton.setOnClickListener(v -> dismiss());

        TextView title = findViewById(R.id.cipherTitle);
        title.setTextColor(getContext().getResources().getColor(R.color.dark_blue));
        title.setTypeface(null, Typeface.BOLD);
        title.setTextSize(20);

        getWindow().setBackgroundDrawableResource(R.drawable.transparent_dialog_inset_10_30);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;

        getWindow().setAttributes(params);
    }

    @Override
    public void show() {
        super.show();
    }
}
