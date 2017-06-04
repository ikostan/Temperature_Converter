package com.example.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtTemp;
    private RadioGroup radioGroup;
    private Button btnCalc;
    private RadioButton convertFtoC, convertCtoF;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setViews();

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    Log.d("txtTemp", txtTemp.getText().toString());
                    if(txtTemp.getText().toString() != ""){

                        double celcius, farenheit;
                        double tempData = Double.parseDouble(txtTemp.getText().toString());

                        if(convertFtoC.isChecked()){

                            Log.d("convertFtoC", "convertFtoC");
                            celcius = ((tempData - 32.0) * 5.0) /9.0;
                            txtResult.setText(String.format("Temerature in C: %.2f", celcius));
                        }
                        else if(convertCtoF.isChecked()){

                            Log.d("convertCtoF", "convertCtoF");
                            farenheit = ((tempData * 9.0) / 5.0) + 32.0;
                            txtResult.setText(String.format("Temerature in F: %.2f", farenheit));
                        }
                        else{

                            Log.d("Nothing is checked", "Nothing is checked");
                            Toast.makeText(getApplicationContext(), "Please select the unit conversion first", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{

                        Toast.makeText(getApplicationContext(), "Please add temperature value", Toast.LENGTH_LONG).show();
                    }


                }
                catch(Exception ex){

                    Toast.makeText(getApplicationContext(), "Temperature value must be a number", Toast.LENGTH_LONG).show();
                    Log.d("ERROR: ", ex.getMessage());
                }

            }
        });
    }

    private void setViews(){

        txtTemp = (EditText)findViewById(R.id.txtTemp);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        btnCalc = (Button)findViewById(R.id.btnCalc);
        convertFtoC = (RadioButton)findViewById(R.id.convertFtoC);
        convertCtoF = (RadioButton)findViewById(R.id.convertCtoF);
        txtResult = (TextView)findViewById(R.id.txtResult);
    }
}
