package com.example.hole18;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_PAR = "com.example.android.hole18.extra.PAR";
    public static final String EXTRA_TOTAL = "com.example.android.hole18.extra.STROKE";
    public static final String EXTRA_DIFF = "com.example.android.hole18.extra.DIFF";
    private int tPar = 0;
    private TextView tParNum;
    private int tStroke = 0;
    private TextView tStrokeNum;
    private int hStroke = 0;
    private TextView sCount;
    private int dStroke = 0;
    private TextView diffStroke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diffStroke = findViewById(R.id.par_stroke_compare);
        tStrokeNum = findViewById(R.id.total_strokes_number);
        tParNum = findViewById(R.id.par_number);
    }

    public void strokeDiff() {
        dStroke = tStroke - tPar;
        diffStroke = findViewById(R.id.par_stroke_compare);
        diffStroke.setText(Integer.toString(dStroke));
        if (dStroke <= 0) {
            diffStroke.setTextColor(Color.rgb(1, 156, 1));
        }
        if (dStroke > 0) {
            diffStroke.setTextColor(Color.rgb(170, 27, 27));
        }
    }

    public void addStroke(View view) {
        sCount = findViewById(R.id.text_strokes);
        hStroke++;
        tStroke++;
        if (sCount != null) {
            sCount.setText(Integer.toString(hStroke));
        }
        tStrokeNum = findViewById(R.id.total_strokes_number);
        tStrokeNum.setText(Integer.toString(tStroke));
        strokeDiff();

    }

    public void minusStroke(View view) {
        if (hStroke > 0) {
            sCount = findViewById(R.id.text_strokes);
            hStroke = hStroke - 1;
            tStroke = tStroke - 1;
            if (sCount != null) {
                sCount.setText(Integer.toString(hStroke));
            }
            tStrokeNum = findViewById(R.id.total_strokes_number);
            tStrokeNum.setText(Integer.toString(tStroke));
            strokeDiff();
        }

    }

    public void onRadioButtonClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_par2:
                if (checked)
                    tPar = 2;
                tParNum = findViewById(R.id.par_number);
                tParNum.setText(Integer.toString(tPar));
                strokeDiff();
                break;
            case R.id.radio_par3:
                if (checked)
                    tPar = 3;
                tParNum = findViewById(R.id.par_number);
                tParNum.setText(Integer.toString(tPar));
                strokeDiff();
                break;
            case R.id.radio_par4:
                if (checked)
                    tPar = 4;
                tParNum = findViewById(R.id.par_number);
                tParNum.setText(Integer.toString(tPar));
                strokeDiff();
                break;
        }

    }

    public void nextHole(View view) {
        Intent intent = new Intent(this, HoleTwo.class);
        String parVal = tParNum.getText().toString();
        String tSVal = tStrokeNum.getText().toString();
        String diffVal = diffStroke.getText().toString();
        intent.putExtra(EXTRA_PAR, parVal);
        intent.putExtra(EXTRA_TOTAL, tSVal);
        intent.putExtra(EXTRA_DIFF, diffVal);
        startActivity(intent);
    }
}
