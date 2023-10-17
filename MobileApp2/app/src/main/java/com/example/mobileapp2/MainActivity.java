package com.example.mobileapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtBase, edtHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBase = findViewById(R.id.edt_base);
        edtHeight = findViewById(R.id.edt_height);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputBase = edtBase.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            if (!inputBase.isEmpty() && !inputHeight.isEmpty()) {
                double base = Double.parseDouble(inputBase);
                double height = Double.parseDouble(inputHeight);

                double area = 0.5 * base * height;
                double perimeter = base + (2 * Math.sqrt((0.25 * base * base) + (height * height)));

                String result = "Luas: " + area + "\nKeliling: " + perimeter;
                tvResult.setText(result);
            } else {
                tvResult.setText("Masukkan alas dan tinggi segitiga untuk menghitung.");
            }
        }
    }
}
