package com.example.android.listmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<String>();
    ListView listView;
    ArrayAdapter<String> itemsAdapter;


    public void addListItem(View view){

        EditText et = (EditText) findViewById(R.id.edit_text);
        list.add(et.getText().toString());
        et.setText("");



    }/** above function called when ADD button is clicked, copies the listitem from EditText to list*/

    public void deleteListItem(View view){
        EditText ed = (EditText) findViewById(R.id.delete);
        int position = Integer.parseInt(ed.getText().toString());
        ed.setText("");
        if(position<=0){Toast.makeText(getApplicationContext(),"positions are positive integers -_-",Toast.LENGTH_SHORT
        ).show();}
        else if(position>list.size()){
            Toast.makeText(getApplicationContext(),"no element to delete daw",Toast.LENGTH_SHORT).show();}
        else{ list.remove(position-1);
              listView.setAdapter(itemsAdapter);
        }

    } /**above function to delete element*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         listView = (ListView) findViewById(R.id.list_view);
        itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int pos, long id){
                // Create a new intent to open the {@link SelectedListItem activity}
                Intent numbersIntent = new Intent(MainActivity.this, SelectedListItem.class);
                String msg = listView.getItemAtPosition(pos).toString();
                numbersIntent.putExtra("blah",msg);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });
    }







}
