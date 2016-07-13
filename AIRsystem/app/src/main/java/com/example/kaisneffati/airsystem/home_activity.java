package com.example.kaisneffati.airsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class home_activity extends AppCompatActivity {
EditText editText1,editText2,editText3,editText4;
   int rav;
    TextView elig;
    RadioGroup gr;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        editText1 = (EditText)findViewById(R.id.revenu);
        editText2 = (EditText)findViewById(R.id.credit);
        editText3 = (EditText)findViewById(R.id.nbenfant);
        editText4 = (EditText)findViewById(R.id.RAV);
        elig = (TextView)findViewById(R.id.eligible);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b=Integer.parseInt(editText1.getText().toString());
                int c=Integer.parseInt(editText2.getText().toString());
                int d=Integer.parseInt(editText3.getText().toString());
               String s= String.valueOf(b - (c + d * 150));
                rav =b - (c + d * 150);
                editText4.setText(s);

            }
        });
        RadioGroup rg = (RadioGroup) findViewById(R.id.gr);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.couple:
                        // TODO Something
                    if ( rav>=2000)
                    {
                            elig.setText("Cible");}
                        else {elig.setText("Hors Cible");

                    }
                        break;
                    case R.id.celib:
                        // TODO Something
                        if ( rav>=1300)
                        {
                            elig.setText("Cible");}
                        else {elig.setText("Hors Cible");

                        }
                        break;
                    case R.id.celib_R:
                        // TODO Something
                        if ( rav>=1100)
                        {
                            elig.setText("Cible");}
                        else {elig.setText("Hors Cible");

                        }
                        break;
                }
            }
        });



    }

}
