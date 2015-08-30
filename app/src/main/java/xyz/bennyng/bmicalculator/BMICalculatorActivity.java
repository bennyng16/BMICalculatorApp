package xyz.bennyng.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        Button calculateBMIButton = (Button) findViewById(R.id.calculateBMIButton);
        final TextView bmiValue = (TextView) findViewById(R.id.bmiValue);
        final EditText weight = (EditText) findViewById(R.id.weight);
        final EditText heightInFeet = (EditText) findViewById(R.id.heightInFeet);
        final EditText heightInInches = (EditText) findViewById(R.id.heightInInches);

        final BMICalculator BMICalc = new BMICalculator();

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weight.getText().toString().isEmpty() ||
                        heightInFeet.getText().toString().isEmpty() ||
                        heightInInches.getText().toString().isEmpty()) {
                    return;
                }


                BMICalc.setMass(Double.parseDouble(weight.getText().toString()));
                BMICalc.setHeight(Double.parseDouble(heightInInches.getText().toString())
                        + (Double.parseDouble(heightInFeet.getText().toString()) * 12));

                // set bmiValue to bmi
                bmiValue.setText(BMICalc.getBMI() + "");
            }
        };

        calculateBMIButton.setOnClickListener(buttonListener);
    }
}
