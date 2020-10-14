package com.example.pregunta2_plataformas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    EditText name;
    EditText lastName;
    EditText CUI;
    Button ok,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        name = (EditText)findViewById(R.id.editText_name);
        lastName = (EditText) findViewById(R.id.editText_lastName);
        CUI = (EditText)findViewById(R.id.editText_CUI);
        ok = (Button)findViewById(R.id.button_ok);
        cancel = (Button)findViewById(R.id.button_cancel);

        ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_name = name.getText().toString();
                String s_lastName = lastName.getText().toString();
                String s_CUI = CUI.getText().toString();
                Intent intent= new Intent();
                intent.putExtra("NAME",s_name);
                intent.putExtra("LASTNAME",s_lastName);
                intent.putExtra("CUI",s_CUI);
                setResult(1,intent);
                finish();
            }
        });
        cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
