package com.example.zoomcontroler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    ZoomControls simpleZoomControls;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        simpleZoomControls = (ZoomControls) findViewById(R.id.simpleZoomControl); // initiate a ZoomControls
        simpleZoomControls.hide();
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                simpleZoomControls.show();
                return false;
            }
        });

        simpleZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float x = image.getScaleX();
                float y = image.getScaleY();
                image.setScaleX((float) (x + 1));
                image.setScaleY((float) (y + 1));

                //Toast.makeText(getApplicationContext(), "Zoom In", Toast.LENGTH_SHORT).show();

                simpleZoomControls.hide();
            }
        });
        simpleZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = image.getScaleX();
                float y = image.getScaleY();
                image.setScaleX((float) (x - 1));
                image.setScaleY((float) (y - 1));
                //Toast.makeText(getApplicationContext(), "Zoom Out", Toast.LENGTH_SHORT).show();
                simpleZoomControls.hide();
            }
        });
    }
}