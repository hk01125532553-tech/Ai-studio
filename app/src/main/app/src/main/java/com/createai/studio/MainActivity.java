package com.createai.studio;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    String selected = "Image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(com.createai.studio.R.layout.activity_main);

        GridLayout grid = findViewById(com.createai.studio.R.id.modeGrid);

        String[] modes = {
                "🖼️ Image",
                "🎬 Video",
                "🔄 Image → Video",
                "👤 Character",
                "🎤 Voice",
                "🗂️ Gallery"
        };

        for (String mode : modes) {

            Button button = new Button(this);

            button.setText(mode);
            button.setTextColor(Color.WHITE);
            button.setAllCaps(false);

            button.setOnClickListener(v -> {
                selected = mode;

                Toast.makeText(
                        MainActivity.this,
                        mode + " selected",
                        Toast.LENGTH_SHORT
                ).show();
            });

            GridLayout.LayoutParams params =
                    new GridLayout.LayoutParams();

            params.width = 0;
            params.height = 70;
            params.columnSpec =
                    GridLayout.spec(GridLayout.UNDEFINED, 1f);

            params.setMargins(4, 4, 4, 4);

            button.setLayoutParams(params);

            grid.addView(button);
        }

        Button generate =
                findViewById(com.createai.studio.R.id.generate);

        generate.setOnClickListener(v -> {

            EditText prompt =
                    findViewById(com.createai.studio.R.id.prompt);

            String text =
                    prompt.getText().toString().trim();

            if (text.isEmpty()) {

                Toast.makeText(
                        MainActivity.this,
                        "Enter a prompt first.",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Toast.makeText(
                        MainActivity.this,
                        "Request ready: " + selected,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
                              }
