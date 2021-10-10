package com.iuhaynad.java_crossesandnulls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView_Help;
    Button btn_Control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Control = findViewById(R.id.btn_Control);
        if (!Checkers.getFirstOpening())
            btn_Control.setText(getResources().
                    getString(R.string.replay));
        else Checkers.setFirstOpening(false);

        textView_Help = findViewById(R.id.textView_Help);
        switch (Checkers.getGameStatus()) {
            case 1:
                textView_Help.setText(getResources().
                        getString(R.string.row));
                break;
            case 2:
                textView_Help.setText(getResources().
                        getString(R.string.crossesWin));
                break;
            case 3:
                textView_Help.setText(getResources().
                        getString(R.string.nullsWin));
                break;
        }
        btn_Control = findViewById(R.id.btn_Control);
        btn_Control.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,
                GameActivity.class);
        startActivity(intent);
    }
}