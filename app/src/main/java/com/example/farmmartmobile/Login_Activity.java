package com.example.farmmartmobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.farmmartmobile.viewmodel.UserViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        Button registerBtn = findViewById(R.id.button3);

        registerBtn.setOnClickListener(v ->{
            TextInputEditText email = findViewById(R.id.email);
            TextInputEditText password = findViewById(R.id.password);
            userViewModel.login(email.getText().toString(), password.getText().toString());
            finish();
        });
    }
}