package com.bob.viccalculatortinapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTri, btnRec;

        tvResult = findViewById(R.id.txPreviewMain);

        tvResult.setText("");

        btnTri = findViewById(R.id.btnTriangle);
        btnRec = findViewById(R.id.btnRectangle);

        btnTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), TriangleActivity.class);

                startActivityForResult(i, 1);
            }
        });

        btnRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), RectangleActivity.class);

                startActivityForResult(i, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){

            if (resultCode == 1) {

                String oldText = tvResult.getText().toString();
                double newText = data.getDoubleExtra("triangle_activity", 0);
                tvResult.setText(oldText + "\n" + "Triangle : " + newText);
            }
            else if (resultCode == 2) {

                String oldText = tvResult.getText().toString();

                int base = data.getIntExtra("triangle_base", 0);
                int height = data.getIntExtra("triangle_height", 0);

                tvResult.setText(oldText + "\n" + "Triangle ,B : " + base + " ,H : " + height);
            }
        }
        else if (requestCode == 2){

            if (resultCode == 3) {

                String oldText = tvResult.getText().toString();
                int newText = data.getIntExtra("rectangle_activity", 0);
                tvResult.setText(oldText + "\n" + "Rectangle : " + newText);
            }
            else if (resultCode == 4) {

                String oldText = tvResult.getText().toString();

                int width = data.getIntExtra("rectangle_width", 0);
                int height = data.getIntExtra("rectangle_height", 0);

                tvResult.setText(oldText + "\n" + "Rectangle ,W : " + width + " ,H : " + height);
            }
        }
    }
}