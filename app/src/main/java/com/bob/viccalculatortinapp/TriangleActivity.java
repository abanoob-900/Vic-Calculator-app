package com.bob.viccalculatortinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        EditText edBase, edHeight;

        Button btnCalc;

        edBase = findViewById(R.id.edBaseTriangle);
        edHeight = findViewById(R.id.edHeightTriangle);

        btnCalc = findViewById(R.id.btnCalcTri);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double base = Double.parseDouble(edBase.getText().toString());
                double height = Double.parseDouble(edHeight.getText().toString());

                double area = 0.5 * base * height;

                Intent i = new Intent();

                if (area < 0) {

                    i.putExtra("triangle_base", base);
                    i.putExtra("triangle_height", height);
                    setResult(2, i);
                }
                else {

                    i.putExtra("triangle_activity", area);
                    setResult(1, i);
                }

                finish();
            }
        });
    }
}