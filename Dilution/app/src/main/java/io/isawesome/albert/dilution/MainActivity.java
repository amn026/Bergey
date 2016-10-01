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

public class MainActivity extends AppCompatActivity {
    EditText etC1;
    EditText etV1;
    EditText etC2;
    EditText etV2;

    TextView tvC1;
    TextView tvV1;
    TextView tvC2;
    TextView tvV2;

    Spinner spinC1;
    Spinner spinV1;
    Spinner spinC2;
    Spinner spinV2;



    TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> a = new ArrayList<String>();
        String[] myResArray = getResources().getStringArray(R.array.units_array);
        a = Arrays.asList(myResArray);

        ItemAdapter adapter = new ItemAdapter(this, a);

        spinC1 = (Spinner)findViewById(R.id.spinC1);
        spinC1.setAdapter(adapter);

        etC1 = (EditText)findViewById(R.id.etC1);
        tvAnswer = (TextView)findViewById(R.id.tvAnswer);

    }

    public void onSolve(View v) {
        tvAnswer.setText(etC1.getText().toString());
        Log.d("lala",etC1.getText().toString());
    }
}
