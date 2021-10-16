package com.iuhaynad.java_crossesandnulls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_Return,
            btn_cell00, btn_cell10, btn_cell20,
            btn_cell01, btn_cell11, btn_cell21,
            btn_cell02, btn_cell12, btn_cell22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Checkers.setGameStatus((byte)1); // default - raw
        Checkers.setIsCross(true); // default - cross is first
        // if nulls are walk first - change to false

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn_Return = findViewById(R.id.btn_Return);
        btn_Return.setOnClickListener(this);
        //cell
        // first column
        btn_cell00 = findViewById(R.id.btn_cell00);
        btn_cell00.setOnClickListener(this);
        btn_cell01 = findViewById(R.id.btn_cell01);
        btn_cell01.setOnClickListener(this);
        btn_cell02 = findViewById(R.id.btn_cell02);
        btn_cell02.setOnClickListener(this);
        // second column
        btn_cell10 = findViewById(R.id.btn_cell10);
        btn_cell10.setOnClickListener(this);
        btn_cell11 = findViewById(R.id.btn_cell11);
        btn_cell11.setOnClickListener(this);
        btn_cell12 = findViewById(R.id.btn_cell12);
        btn_cell12.setOnClickListener(this);
        // third column
        btn_cell20 = findViewById(R.id.btn_cell20);
        btn_cell20.setOnClickListener(this);
        btn_cell21 = findViewById(R.id.btn_cell21);
        btn_cell21.setOnClickListener(this);
        btn_cell22 = findViewById(R.id.btn_cell22);
        btn_cell22.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_Return) {
            Intent intent = new Intent(this,
                    MainActivity.class);
            startActivity(intent);
        } else {
            Button buf = findViewById(v.getId());
            buf.setOnClickListener(this);
            if (buf.getText() == "") {
                if (Checkers.getIsCross()) {
                    buf.setText(getResources().getString(R.string.cross));
                    Checkers.setIsCross(false);
                }
                else {
                    buf.setText(getResources().getString(R.string.nul));
                    Checkers.setIsCross(true);
                }
            }
            if (!btn_cell00.getText().toString().equals("")) {
                if ((btn_cell00.getText().toString().
                        equals(btn_cell01.getText().toString())) &&
                        (btn_cell01.getText().toString().
                                equals(btn_cell02.getText().toString()))) {
                    if (btn_cell02.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte)3);
                    else Checkers.setGameStatus((byte)2);
                } else if ((btn_cell00.getText().toString().
                        equals(btn_cell11.getText().toString())) &&
                        (btn_cell11.getText().toString().
                                equals(btn_cell22.getText().toString()))) {
                    if (btn_cell22.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte)3);
                    else Checkers.setGameStatus((byte)2);
                } else if ((btn_cell00.getText().toString().
                        equals(btn_cell10.getText().toString())) &&
                        (btn_cell10.getText().toString().
                                equals(btn_cell20.getText().toString()))) {
                    if (btn_cell20.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte)3);
                    else Checkers.setGameStatus((byte)2);
                }
            }
            if (!btn_cell22.getText().toString().equals("")) {
                if ((btn_cell22.getText().toString().
                        equals(btn_cell21.getText().toString())) &&
                        (btn_cell21.getText().toString().
                                equals(btn_cell20.getText().toString()))) {
                    if (btn_cell20.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte)3);
                    else Checkers.setGameStatus((byte)2);
                } else if ((btn_cell22.getText().toString().
                        equals(btn_cell12.getText().toString())) &&
                        (btn_cell12.getText().toString().
                                equals(btn_cell02.getText().toString()))) {
                    if (btn_cell02.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte)3);
                    else Checkers.setGameStatus((byte)2);
                }
            }
            if (!btn_cell11.getText().toString().equals("")) {
                if ((btn_cell01.getText().toString().
                        equals(btn_cell11.getText().toString())) &&
                        (btn_cell11.getText().toString().
                                equals(btn_cell21.getText().toString()))) {
                    if (btn_cell21.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte) 3);
                    else Checkers.setGameStatus((byte) 2);
                } else if ((btn_cell20.getText().toString().
                        equals(btn_cell11.getText().toString())) &&
                        (btn_cell11.getText().toString().
                                equals(btn_cell02.getText().toString()))) {
                    if (btn_cell02.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte)3);
                    else Checkers.setGameStatus((byte)2);
                } else if ((btn_cell10.getText().toString().
                        equals(btn_cell11.getText().toString())) &&
                        (btn_cell11.getText().toString().
                                equals(btn_cell12.getText().toString()))) {
                    if (btn_cell12.getText().toString().
                            equals(getResources().getString(R.string.nul)))
                        Checkers.setGameStatus((byte)3);
                    else Checkers.setGameStatus((byte)2);
                }
                if (!btn_cell00.getText().toString().equals("") &&
                        !btn_cell01.getText().toString().equals("") &&
                        !btn_cell02.getText().toString().equals("") &&
                        !btn_cell10.getText().toString().equals("") &&
                        !btn_cell11.getText().toString().equals("") &&
                        !btn_cell12.getText().toString().equals("") &&
                        !btn_cell20.getText().toString().equals("") &&
                        !btn_cell21.getText().toString().equals("") &&
                        !btn_cell22.getText().toString().equals("")) {
                    if (Checkers.getGameStatus() == 1) {
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
            if (Checkers.getGameStatus() != 1) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}