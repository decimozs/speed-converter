package com.example.speedconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String c1Unit = "";
    String c2Unit = "";
    Spinner conversionMenu;
    Spinner conversionMenu2;
    EditText userInput;
    TextView result;
    TextView unit1Lbl;
    TextView unit2Lbl;
    public static TextView resultHeader;
    TextView resultConvertedUnits;
    Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversionMenu = findViewById(R.id.conversion_drop_down_btn);
        conversionMenu2 = findViewById(R.id.conversion_drop_down_btn2);
        userInput = findViewById(R.id.input1);
        result = findViewById(R.id.result);
        convertBtn = findViewById(R.id.convert_btn);
        unit1Lbl = findViewById(R.id.unit1_label);
        unit2Lbl = findViewById(R.id.unit2_label);
        resultHeader = findViewById(R.id.result_header);
        resultConvertedUnits = findViewById(R.id.result_converted_units);

        String[] items = getResources().getStringArray(R.array.conversion_units);
        String[] items2 = getResources().getStringArray(R.array.conversion_unit2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items);
        conversionMenu.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items2);
        conversionMenu2.setAdapter(adapter2);

        conversionMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c1Unit = parent.getItemAtPosition(position).toString();
                unit1Lbl.setText(Utils.unitsTextConversion(c1Unit));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        conversionMenu2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c2Unit = parent.getItemAtPosition(position).toString();
                unit2Lbl.setText(Utils.unitsTextConversion(c2Unit));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInputString = userInput.getText().toString();
                double value = Double.parseDouble(userInputString);
                double output = Utils.computation(value,c1Unit,c2Unit);
                resultConvertedUnits.setText(Utils.getConversionResult(c1Unit, c2Unit));
                String formattedOutput = String.format("%.4f", output);
                result.setText(formattedOutput);
            }
        });
    }
}