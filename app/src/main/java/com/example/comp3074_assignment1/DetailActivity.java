package com.example.comp3074_assignment1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ListView list = findViewById(R.id.listPayments);
        TextView empty = findViewById(R.id.emptyView);
        list.setEmptyView(empty);

        ArrayAdapter<Payment> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                PaymentRepo.PAYMENTS
        );
        list.setAdapter(adapter);
    }
}