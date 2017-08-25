package com.chx.piechartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {


    private EditText editText;
    private Button btn;
    private MyView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myView = (MyView) findViewById(R.id.myview);

        editText = (EditText) findViewById(R.id.edit);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString().trim())) {
                    myView.aDDEntry(editText.getText().toString().trim());
                }
            }
        });


    }
}
