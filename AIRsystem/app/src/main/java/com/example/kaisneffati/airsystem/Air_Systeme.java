package com.example.kaisneffati.airsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Air_Systeme extends AppCompatActivity {
Button Rev,FactEnr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airsysteme);
        Rev =(Button)findViewById(R.id.Rev);
        FactEnr =(Button)findViewById(R.id.FactEnr);
        Rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Air_Systeme.this,home_activity.class);
                startActivity(intent);
            }
        });
        FactEnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Air_Systeme.this,Facture_Energ.class);
                startActivity(intent);
            }
        });

    }
}
