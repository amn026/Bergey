package io.isawesome.albert.dilution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.isawesome.albert.dilution.R.id.etDF;
import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    EditText etC1;
    EditText etV1;
    EditText etC2;
    EditText etV2;
    EditText etDF;

    TextView tvC1;
    TextView tvV1;
    TextView tvC2;
    TextView tvV2;

    Spinner spinC1;
    Spinner spinV1;
    Spinner spinC2;
    Spinner spinV2;

    double c1;
    double v1;
    double c2;
    double v2;

    TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        String[] cArray = getResources().getStringArray(R.array.units_array);
        String[] lArray = getResources().getStringArray(R.array.units_array_2);
        a = Arrays.asList(cArray);
        b = Arrays.asList(lArray);

        ItemAdapter adapterC1 = new ItemAdapter(this, a);
        ItemAdapter adapterC2 = new ItemAdapter(this, a);
        ItemAdapter adapterV1 = new ItemAdapter(this, b);
        ItemAdapter adapterV2 = new ItemAdapter(this, b);

        //Initialize boxes and spinners
        spinC1 = (Spinner)findViewById(R.id.spinC1);
        spinC1.setAdapter(adapterC1);
        spinV1 = (Spinner)findViewById(R.id.spinV1);
        spinV1.setAdapter(adapterV1);
        spinC2 = (Spinner)findViewById(R.id.spinC2);
        spinC2.setAdapter(adapterC2);
        spinV2 = (Spinner)findViewById(R.id.spinV2);
        spinV1.setAdapter(adapterV2);

        etC1 = (EditText)findViewById(R.id.etC1);
        etV1 = (EditText)findViewById(R.id.etV1);
        etC2 = (EditText)findViewById(R.id.etC2);
        etV2 = (EditText)findViewById(R.id.etV2);
        etDF = (EditText)findViewById(R.id.etDF);

        tvAnswer = (TextView)findViewById(R.id.tvAnswer);

    }



    public void onSolve(View v) {
        Unit c1, v1, c2, v2;
        double solveC1;
        double solveV1;
        double solveC2;
        double solveV2;
        double solveDF;

        String testString;
        testString = etC1.getText().toString();
        c1 = Conversion.getUnit(spinC1.getSelectedItemPosition());
        solveC1 = parseDouble(testString);

        testString = etV1.getText().toString();
        v1 = Conversion.getUnit(spinV1.getSelectedItemPosition());
        solveV1 = parseDouble(testString);

        testString = etC2.getText().toString();
        c2 = Conversion.getUnit(spinC2.getSelectedItemPosition());
        solveC2 = parseDouble(testString);

        testString = etV2.getText().toString();
        v2 = Conversion.getUnit(spinV2.getSelectedItemPosition());
        solveV2 = parseDouble(testString);

        testString = etDF.getText().toString();
        solveDF = parseDouble(testString);

        solveC1 = Conversion.convertToBase(c1, solveC1);
        solveV1 = Conversion.convertToBase(v1, solveV1);
        solveC2 = Conversion.convertToBase(c2, solveC2);
        solveV2 = Conversion.convertToBase(v2, solveV2);

        Dilution calculator = new Dilution(solveC1, solveV1, solveC2, solveV2, solveDF, c1,v1,c2,v2);
        calculator.calculate();

        testString = calculator.getOutput();
        tvAnswer.setText(testString);
        //tvAnswer.setText(etC1.getText().toString());
        Log.d("lala",etC1.getText().toString());
    }

    public void onReset(View v) {
        String resetString = "0";

        etC1.setText(resetString);
        etV1.setText(resetString);
        etC2.setText(resetString);
        etV2.setText(resetString);
        etDF.setText(resetString);

        tvAnswer.setText("Your answer here", TextView.BufferType.NORMAL);
    }
}
