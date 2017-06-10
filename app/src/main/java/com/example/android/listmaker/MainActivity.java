package com.example.android.listmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    ArrayList<String> list = new ArrayList<String>();

    public void addListItem(View view){
        EditText et = (EditText) findViewById(R.id.edit_text);
        list.add(et.getText().toString());
        et.setText("");


    }/** above function called when ADD button is clicked, copies the listitem from EditText to list*/

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

    ListView listView = (ListView) findViewById(R.id.list);

     listView.setAdapter(arrayAdapter);

    listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(ListView listView,View view,int pos,long id){
            // Create a new intent to open the {@link SelectedListItem activity}
            Intent numbersIntent = new Intent(MainActivity.this, SelectedListItem.class);
            numbersIntent.putExtra("blah",list.get(pos));

            // Start the new activity
            startActivity(numbersIntent);
        }
    });


}
