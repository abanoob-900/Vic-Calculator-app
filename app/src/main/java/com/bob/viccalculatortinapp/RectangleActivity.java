package com.bob.viccalculatortinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RectangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        EditText edWidth, edHeight;

        Button btnCalc;

        edWidth = findViewById(R.id.edWidthRectangle);
        edHeight = findViewById(R.id.edHeightRectangle);

        btnCalc = findViewById(R.id.btnCalcRec);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int width = Integer.parseInt(edWidth.getText().toString());
                int height = Integer.parseInt(edHeight.getText().toString());

                int area = width * height;

                Intent i = new Intent();

                if (area < 0) {

                    i.putExtra("rectangle_width", width);
                    i.putExtra("rectangle_height", height);
                    setResult(4, i);
                }
                else {

                    i.putExtra("rectangle_activity", area);
                    setResult(3, i);
                }

                finish();
            }
        });
    }
}