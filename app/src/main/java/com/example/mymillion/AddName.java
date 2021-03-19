package com.example.mymillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        TextInputEditText name = (TextInputEditText) findViewById(R.id.name);
        TextInputEditText surname = (TextInputEditText) findViewById(R.id.surname);
        Button ok = (Button) findViewById(R.id.submit);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() && !surname.getText().toString().isEmpty()) {
                    Intent answerIntent = new Intent();
                    String mName = name.getText().toString();
                    String mSurname = surname.getText().toString();
                    answerIntent.putExtra("name", mName);
                    answerIntent.putExtra("surname", mSurname);
                    setResult(RESULT_OK, answerIntent);
                    finish();
                }else {
                    Toast.makeText(getBaseContext(), "Enter data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}