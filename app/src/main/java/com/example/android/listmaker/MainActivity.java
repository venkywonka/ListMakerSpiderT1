package com.example.android.listmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addListItem(View view){
        EditText et = (EditText) findViewById(R.id.edit_text);
        list.add(et.getText().toString());
        et.setText("");

        final ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(itemsAdapter);

        listView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Create a new intent to open the {@link SelectedListItem activity}
                Intent numbersIntent = new Intent(MainActivity.this, SelectedListItem.class);
                TextView t = (TextView) listView.getSelectedItem();
                String msg = t.getText().toString();
                numbersIntent.putExtra("blah",msg);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });
    }/** above function called when ADD button is clicked, copies the listitem from EditText to list*/



}
