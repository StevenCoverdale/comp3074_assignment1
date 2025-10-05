package com.example.comp3074_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editHours, editRate;
    TextView textPay, textOvertime, textTotal, textTax;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHours = findViewById(R.id.editHours);
        editRate = findViewById(R.id.editRate);
        textPay = findViewById(R.id.textPay);
        textOvertime = findViewById(R.id.textOvertime);
        textTotal = findViewById(R.id.textTotal);
        textTax = findViewById(R.id.textTax);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> calculatePay());
    }

    private void calculatePay() {
        try {
            double hours = Double.parseDouble(editHours.getText().toString());
            double rate = Double.parseDouble(editRate.getText().toString());

            double pay, overtime = 0, total, tax;
            if (hours <= 40) {
                pay = hours * rate;
            } else {
                overtime = (hours - 40) * rate * 1.5;
                pay = 40 * rate;
            }
            total = pay + overtime;
            tax = total * 0.18;

            textPay.setText("Pay: $" + pay);
            textOvertime.setText("Overtime: $" + overtime);
            textTotal.setText("Total: $" + total);
            textTax.setText("Tax: $" + tax);

            Toast.makeText(this, "Calculation successful", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_detail) {
            startActivity(new Intent(this, DetailActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}