package com.example.tugasproject2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    TextView Hasil;
    EditText diag1,diag2;
    Button Button1;

    AwesomeValidation awesomeValidation;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    Hasil = findViewById(R.id.hasil);
    diag1 = findViewById(R.id.diag1);
    diag2 = findViewById(R.id.diag2);
    Button1 = findViewById(R.id.button1);

    awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);

    awesomeValidation.addValidation(this,R.id.diag1
            ,"\\d*\\.?\\d+",R.string.invalid_number);
        awesomeValidation.addValidation(this,R.id.diag2
                ,"\\d*\\.?\\d+",R.string.invalid_number);

    Button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(awesomeValidation.validate()){
                Toast.makeText(getApplicationContext()
                ,"Validate Successfull",Toast.LENGTH_SHORT).show();
                int a,b,h;
                a = Integer.parseInt(diag1.getText().toString());
                b = Integer.parseInt(diag2.getText().toString());
                h = a/2*b;
                Hasil.setText("HASIL, LUAS = "+h);
            }else{
                Toast.makeText(getApplicationContext()
                ,"Validation Failed.",Toast.LENGTH_SHORT).show();
            }

        }
    });
    }
}
