package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoBatch;
    String[] batch = {"22", "23", "24", "25", "26"};
    Button btnSave;
    EditText etFullname;
    RadioGroup rgpGender;
    RadioButton radioButton;
    TextView txtFullName, txtGender, txtBatch, txtCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding
        btnSave = findViewById(R.id.btnSave);
        rgpGender = findViewById(R.id.rgpGender);
        etFullname = findViewById(R.id.etfullName);
        txtFullName = findViewById(R.id.txtFullName);
        txtGender = findViewById(R.id.txtGender);
        txtBatch = findViewById(R.id.txtBatch);
        txtCountry = findViewById(R.id.txtCountry);

        //spinner (Dropdown)
        final Spinner dropdown = findViewById(R.id.spnCountry);
        String[] countries = new String[]{"Nepal", "India", "China", "Bangladesh", "Afganistan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        dropdown.setAdapter(adapter);

        //auto complete
        autoBatch = findViewById(R.id.autoBatch);
        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, batch);
        autoBatch.setAdapter(languageAdapter);
        autoBatch.setThreshold(1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etFullname.length() == 0) {
                    etFullname.requestFocus();
                    etFullname.setError("FIELD CANNOT BE EMPTY");
                    return;
                }
                if (rgpGender.getCheckedRadioButtonId() == -1) {
                    rgpGender.requestFocus();
                    Toast.makeText(getApplicationContext(), "Please select gender", Toast.LENGTH_LONG).show();
                    return;
                }

                if (autoBatch.length() == 0) {
                    autoBatch.requestFocus();
                    autoBatch.setError("FIELD CANNOT BE EMPTY");
                    return;
                }


                txtFullName.setText("  " + etFullname.getText());
                radioButton = findViewById(rgpGender.getCheckedRadioButtonId());
                txtGender.setText("  " + radioButton.getText());
                txtBatch.setText("  " + autoBatch.getText());
                txtCountry.setText("  " + dropdown.getSelectedItem().toString());
            }
        });

    }
}
