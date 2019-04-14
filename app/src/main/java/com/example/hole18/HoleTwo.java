package com.example.hole18;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class HoleTwo extends AppCompatActivity {

    private int tPar = 0;
    private TextView tParNum;
    private int tStroke = 0;
    private TextView tStrokeNum;
    private int hStroke = 0;
    private TextView sCount;
    private int dStroke = 0;
    private TextView diffStroke;
    private int oldPar = 0;
    private int oldStroke = 0;
    private int oldDiff = 0;
    private int cPar = 0;
    private int cStroke = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole_two);
        Intent intent = getIntent();
        String parVal = intent.getStringExtra(MainActivity.EXTRA_PAR);
        String tSVal = intent.getStringExtra(MainActivity.EXTRA_TOTAL);
        String diffVal = intent.getStringExtra(MainActivity.EXTRA_DIFF);
        TextView tParNum = findViewById(R.id.par_number);
        TextView tStrokeNum = findViewById(R.id.total_strokes_number);
        TextView diffStroke = findViewById(R.id.par_stroke_compare);
        tParNum.setText(parVal);
        tStrokeNum.setText(tSVal);
        diffStroke.setText(diffVal);
        oldPar = Integer.parseInt(parVal);
        oldStroke = Integer.parseInt(tSVal);
        oldDiff = Integer.parseInt(diffVal);

    }

    public void strokeDiff() {
        tParNum = findViewById(R.id.par_number);
        tStrokeNum = findViewById(R.id.total_strokes_number);
        String currentP = tParNum.getText().toString();
        cPar = Integer.parseInt(currentP);
        String currentS = tStrokeNum.getText().toString();
        cStroke = Integer.parseInt(currentS);

        dStroke = cStroke - cPar;
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
        tStrokeNum.setText(Integer.toString(oldStroke + tStroke));
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
            tStrokeNum.setText(Integer.toString(oldStroke + tStroke));
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
                tParNum.setText(Integer.toString(oldPar + tPar));
                strokeDiff();
                break;
            case R.id.radio_par3:
                if (checked)
                    tPar = 3;
                tParNum = findViewById(R.id.par_number);
                tParNum.setText(Integer.toString(oldPar + tPar));
                strokeDiff();
                break;
            case R.id.radio_par4:
                if (checked)
                    tPar = 4;
                tParNum = findViewById(R.id.par_number);
                tParNum.setText(Integer.toString(oldPar + tPar));
                strokeDiff();
                break;
        }

    }

    public void previousHole(View view) {

    }
}
