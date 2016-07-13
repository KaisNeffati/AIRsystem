package com.example.kaisneffati.airsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class Facture_Energ extends AppCompatActivity {
    private Button btn_fact_elec,btn_fact_fioul,btn_fact_bois,calculer_fact_energ;
    private Switch switch_elect;
    private EditText result_gaz,fact_energ,fact_elect,fact_chauf,montant_elec,mois_elec,result_elec,result_fioul,prix_littre,nbl,bois_ckeckbox_val,granule_checkbox_val,prix_granule_val,insert_checkbix_val,prix_insert_val,result_bois;
    private RadioGroup gr_elec;
    private LinearLayout lay_sur_elec,lay_montant_mois_elec;
    private double i=0.0,j=0.0,f1=0.0,f2=0.0,f=0.0;
    private CheckBox bois,fioul,gaz,electricite,checkbox_bois,checkbox_granule,checkbox_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture__energ);
        initspinner();
        fact_energ=(EditText)findViewById(R.id.fact_energ);
        fact_chauf=(EditText)findViewById(R.id.fact_chauf);
        fact_elect=(EditText)findViewById(R.id.fact_elect);
        result_gaz=(EditText)findViewById(R.id.result_gaz);
        bois = (CheckBox)findViewById(R.id.Bois);
        fioul=(CheckBox)findViewById(R.id.fioul);
        gaz=(CheckBox)findViewById(R.id.gaz);
        electricite=(CheckBox)findViewById(R.id.electricite);
        calculer_fact_energ=(Button)findViewById(R.id.calculer_fact_energ);
        calculer_fact_energ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bois.isChecked())
                {
                    if(result_bois.getText().toString().trim().length()!=0)
                    {
                        f1+=Double.parseDouble(result_bois.getText().toString());
                    }
                }

                if(fioul.isChecked())
                {
                    if(result_fioul.getText().toString().trim().length()!=0)
                    {
                        f1+=Double.parseDouble(result_fioul.getText().toString());
                    }
                }

                if(electricite.isChecked())
                {
                    if(result_elec.getText().toString().trim().length()!=0)
                    {
                        f2+=Double.parseDouble(result_elec.getText().toString());
                    }
                }

                if(gaz.isChecked())
                {
                    if(result_gaz.getText().toString().trim().length()!=0)
                    {
                        f1+=Double.parseDouble(result_gaz.getText().toString());
                    }
                }
                f=f1+f2;
                fact_elect.setText(String.valueOf(f2));
                fact_chauf.setText(String.valueOf(f1));
                fact_energ.setText(String.valueOf(f));
                f1=0;f2=0;f=0;
            }
        });
        insert_checkbix_val=(EditText)findViewById(R.id.insert_checkbix_val);
        prix_insert_val=(EditText)findViewById(R.id.prix_insert_val);
        result_bois=(EditText)findViewById(R.id.result_bois);
        prix_granule_val=(EditText)findViewById(R.id.prix_granule_val);
        granule_checkbox_val=(EditText)findViewById(R.id.granule_checkbox_val);
        bois_ckeckbox_val=(EditText)findViewById(R.id.bois_ckeckbox_val);
        checkbox_bois=(CheckBox)findViewById(R.id.checkbox_bois);
        checkbox_granule=(CheckBox)findViewById(R.id.checkbox_granule);
        checkbox_insert=(CheckBox)findViewById(R.id.checkbox_insert);
        btn_fact_bois=(Button)findViewById(R.id.btn_fact_bois);
        btn_fact_bois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox_bois.isChecked()){

                    if(bois_ckeckbox_val.getText().toString().trim().length()!=0){
                    j+=Double.parseDouble(bois_ckeckbox_val.getText().toString());
                    }
                }
                if(checkbox_granule.isChecked()){
                    if(prix_granule_val.getText().toString().trim().length()!=0||granule_checkbox_val.getText().toString().trim().length()!=0) {
                        j += Double.parseDouble(prix_granule_val.getText().toString()) * Double.parseDouble(granule_checkbox_val.getText().toString());
                    }
                }
                if(checkbox_insert.isChecked()){
                    if(prix_insert_val.getText().toString().trim().length()!=0||insert_checkbix_val.getText().toString().trim().length()!=0) {
                        j += Double.parseDouble(prix_insert_val.getText().toString()) * Double.parseDouble(insert_checkbix_val.getText().toString());
                    }
                }
                String s=String.valueOf(j);
                result_bois.setText(s);
                j=0;
            }
        });
        nbl=(EditText)findViewById(R.id.nbl);
        prix_littre=(EditText)findViewById(R.id.prix_littre);
        result_fioul=(EditText)findViewById(R.id.result_fioul);
        btn_fact_fioul=(Button)findViewById(R.id.btn_fact_fioul);
        result_elec=(EditText)findViewById(R.id.result_elec);
        lay_sur_elec=(LinearLayout)findViewById(R.id.lay_sur_elec);
        lay_montant_mois_elec=(LinearLayout)findViewById(R.id.lay_montant_mois_elec);
        montant_elec =(EditText)findViewById(R.id.montant_elec);
        mois_elec=(EditText)findViewById(R.id.mois_elec);
        gr_elec=(RadioGroup)findViewById(R.id.gr_elec);
        switch_elect=(Switch)findViewById(R.id.switch_elect);
        btn_fact_elec=(Button)findViewById(R.id.btn_fact_elec);

        lay_montant_mois_elec.setVisibility(View.GONE);
        lay_sur_elec.setVisibility(View.GONE);
        switch_elect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lay_montant_mois_elec.setVisibility(View.VISIBLE);
                    lay_sur_elec.setVisibility(View.VISIBLE);
                } else {
                    lay_montant_mois_elec.setVisibility(View.GONE);
                    lay_sur_elec.setVisibility(View.GONE);
                }
            }
        });
        gr_elec.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.sur10:
                        i=10;
                        break;
                    case R.id.sur11:
                        i=11;
                        break;
                    case R.id.sur12:
                        i=12;
                        break;
                }
            }
        });
        btn_fact_elec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_elect.isChecked()) {
                    String s = String.valueOf((double) (i / Double.parseDouble(mois_elec.getText().toString())) * Double.parseDouble(montant_elec.getText().toString()));
                    result_elec.setText(s);
                } else {
                    result_elec.setText("0");
                }
            }
        });
        btn_fact_fioul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prix_littre.getText().toString().trim().length()!=0||nbl.getText().toString().trim().length()!=0){
                String s= String.valueOf(Double.parseDouble(nbl.getText().toString()) * Double.parseDouble(prix_littre.getText().toString()));
                result_fioul.setText(s);}
                else{
                    result_fioul.setText("0");
                }
            }
        });
    }
    public void initspinner(){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinnergaz = (Spinner) findViewById(R.id.spinnergaz);
        Spinner spinnerbois = (Spinner) findViewById(R.id.spinnerbois);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptergaz = ArrayAdapter.createFromResource(this,
                R.array.spinnergaz, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterbois = ArrayAdapter.createFromResource(this,
                R.array.spinnerbois, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptergaz.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterbois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinnergaz.setAdapter(adaptergaz);
        spinnerbois.setAdapter(adapterbois);

    }

}
