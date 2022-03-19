package com.NumCo.numberconverter.Cipher.CipherDialogs;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.NumCo.numberconverter.BuildConfig;
import com.NumCo.numberconverter.Converter;
import com.NumCo.numberconverter.Notify;
import com.NumCo.numberconverter.ObjectPainter.Status;
import com.NumCo.numberconverter.R;
import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageDialog extends Dialog {
    private final Bitmap bitmap;
    private final Context context;
    private final Notify notify;
    private final Activity activity;
    private Uri uri;

    public ImageDialog(@NonNull Context context, Bitmap bitmap, Converter activity) {
        super(context);
        this.bitmap = bitmap;
        this.context = context;
        this.activity = activity;
        notify = activity;
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

        saveButton.setOnClickListener(v -> {


            if (!checkForPermissions()) {
                askForPermissions();
            } else {
                if (checkForPermissions()) {
                    if (saveImage(bitmap)) {
                        notify.makeSnackBar("Image Saved", Status.NORMAL.color, R.string.open, () -> {
                            MediaScannerConnection.scanFile(context, new String[]{uri.getPath()}, new String[]{"image/*"},
                                    (path, uri) -> {
                                        Intent intent = new Intent(Intent.ACTION_VIEW);
                                        intent.setDataAndType(this.uri, "image/*");
                                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_ACTIVITY_NO_HISTORY);
                                        context.startActivity(Intent.createChooser(intent, "View Using..."));
                                    });
                        });
                    } else {
                        notify.makeSnackBar("Error While Saving Image", Status.ERROR.color);
                    }
                } else {
                    notify.makeSnackBar("Some Permissions Not Granted", Status.ERROR.color);
                }

                dismiss();
            }
        });

        TextView title = findViewById(R.id.cipherTitle);
        title.setTextColor(getContext().getResources().getColor(R.color.dark_blue));
        title.setTypeface(null, Typeface.BOLD);
        title.setTextSize(20);

        getWindow().setBackgroundDrawableResource(R.drawable.transparent_dialog_inset_10_30);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;

        getWindow().setAttributes(params);
    }

    private boolean saveImage(Bitmap bitmap) {
        boolean success = false;

        String time = SimpleDateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());

        String name = "cipher_" + time.replaceAll("\\W", "_") + ".jpg";

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Cipher");

        try {
            if (file.mkdirs()) {
                file = new File(file, name);
            } else {
                if (file.exists()) {
                    file = new File(file, name);
                } else {
                    throw new IOException("No such file exists or permission denied");
                }
            }

            if (file.createNewFile() || file.exists()) {

                OutputStream outputStream = new FileOutputStream(file);

                success = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

                outputStream.flush();

                outputStream.close();

                uri = Uri.fromFile(file);

                if (Build.VERSION.SDK_INT > 23) {
                    uri = FileProvider.getUriForFile(context,
                            BuildConfig.APPLICATION_ID + ".provider",
                            file);
                }
            }

        } catch (IOException e) {
            Log.e("Error", e.getMessage());
            return false;
        }
        return success;
    }

    private void askForPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
            }
        }
    }

    private boolean checkForPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            return ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    @Override
    public void show() {
        super.show();
    }
}
