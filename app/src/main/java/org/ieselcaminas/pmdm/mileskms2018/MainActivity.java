package org.ieselcaminas.pmdm.mileskms2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    public static final float CONVERSION_RATE = 1.60934f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);



        final EditText editText = (EditText) findViewById(R.id.editText);
        //editText.setFocusableInTouchMode(false);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                float f = 0f;
                if (!editText.getText().toString().isEmpty())
                    f = Float.parseFloat(charSequence.toString());
                if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonToKm) {
                    float kms = f * CONVERSION_RATE;
                    textView.setText(f + " Miles are " + kms + " Kilometers");
                } else {
                    if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonToMiles) {
                        float miles = f / CONVERSION_RATE;
                        textView.setText(f + " Kilometers are " + miles + " Miles");
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                editText.setText(editText.getText().toString());
            }
        });
    }

    /* @Override
    public boolean dispatchTouchEvent (MotionEvent ev) {
        System.out.println("dispatchTouchEvent");
        return true;
    } */

}

