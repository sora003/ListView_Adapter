package com.sora.listview_adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sora on 2015/12/1.
 */
public class Simple_Adapter extends Activity {

    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> datalist;
    private Button bt3;
    private int add_text=0;
//    Context mcontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter);
//        mcontext = this;
        datalist = new ArrayList<Map<String,Object>>();
        listView = (ListView) findViewById(R.id.listView);
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.simpleadapter,new String[]{"imageView","editText"},new int[]{R.id.imageView,R.id.editText});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = listView.getItemAtPosition(position)+"";
                Toast.makeText(getApplicationContext(),"position="+position+" text="+text,Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_FLING:
                        Map<String, Object>map = new HashMap<String, Object>();
                        map.put("imageView",R.mipmap.ic_launcher);
                        map.put("editText","大家一起方*"+add_text);
                        add_text++;
                        datalist.add(map);
                        simpleAdapter.notifyDataSetChanged();
                        break;
                    case SCROLL_STATE_IDLE:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    private List<Map<String,Object>> getData(){
        for (int i=0;i<20;i++){
            Map<String,Object> map =new HashMap<String,Object>();
            map.put("imageView",R.mipmap.ic_launcher);
            map.put("editText","我好方*"+i);
            datalist.add(map);
        }
        return datalist;
    }
}
