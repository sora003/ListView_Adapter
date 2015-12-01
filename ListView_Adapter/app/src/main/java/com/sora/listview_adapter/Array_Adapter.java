package com.sora.listview_adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Sora on 2015/12/1.
 */
public class Array_Adapter extends Activity{

    private  ArrayAdapter<String> arrayAdapter;
    private  ListView listView;
    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter);
        listView = (ListView) findViewById(R.id.listView);
        String[] data={"我好方","我也很方","我也方了","大家一起方"};
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
