package com.example.farmmartmobile;

import android.app.ComponentCaller;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.farmmartmobile.model.User;
import com.example.farmmartmobile.model.UserType;
import com.example.farmmartmobile.viewmodel.UserViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

public class Register_Activity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    String imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button pickImgBtn = findViewById(R.id.button);
        Button registerBtn = findViewById(R.id.button2);
        pickImgBtn.setOnClickListener(v ->{
            openGallery();
        });

        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        registerBtn.setOnClickListener(v -> {
            TextInputEditText firstName = findViewById(R.id.firstName);
            TextInputEditText lastName = findViewById(R.id.lastName);
            TextInputEditText email = findViewById(R.id.email);
            TextInputEditText phone = findViewById(R.id.phone);
            TextInputEditText password = findViewById(R.id.password);

            User user = new User(-1, imageUrl, UserType.BUYER, firstName.getText().toString(),
                    lastName.getText().toString(), email.getText().toString(), phone.getText().toString(),
                    password.getText().toString(), LocalDateTime.now(), LocalDateTime.now());

            userViewModel.register(user);
            finish();
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && data != null && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            imageUrl = getPathFromUri(selectedImageUri);
            ImageView imageView = findViewById(R.id.imageView);
            Glide.with(this).load(imageUrl).into(imageView);
        }
    }

    private String getPathFromUri(Uri uri) {
        try {
            // Create a unique name for the image
            String fileName = "upload_" + System.currentTimeMillis() + ".jpg";

            // This points to /data/user/0/com.example.app/files/
            File file = new File(getFilesDir(), fileName);

            InputStream inputStream = getContentResolver().openInputStream(uri);
            OutputStream outputStream = new FileOutputStream(file);

            byte[] decodeBuffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(decodeBuffer)) != -1) {
                outputStream.write(decodeBuffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            // Return the absolute string path
            return file.getAbsolutePath();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}