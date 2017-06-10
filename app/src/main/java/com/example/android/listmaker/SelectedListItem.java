package com.example.android.listmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SelectedListItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_list_item);

        Intent intent = getIntent();
        String message = intent.getStringExtra("blah");

        TextView t = (TextView) findViewById(R.id.text);
        t.setText(message);
    }
}
