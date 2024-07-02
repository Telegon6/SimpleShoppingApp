package com.chessytrooper.simpleshoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderSuccessActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        Button buttonReturn = findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(v -> navigateBackToMainActivity());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // This will handle the default back button action
        navigateBackToMainActivity();
    }
    private void navigateBackToMainActivity() {
        Intent intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Finish this activity to prevent it from staying in the back stack
    }


}
