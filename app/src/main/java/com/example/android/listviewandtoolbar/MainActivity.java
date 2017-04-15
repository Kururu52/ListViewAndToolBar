package com.example.android.listviewandtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView result_list = (ListView) findViewById(R.id.list_akhir);

        HashMap<String, String> list_mahasiswa = new HashMap<>();
        list_mahasiswa.put("adam", "001");
        list_mahasiswa.put("bayu", "002");
        list_mahasiswa.put("Nina", "003");
        list_mahasiswa.put("Gagah", "004");
        list_mahasiswa.put("alex", "005");
        list_mahasiswa.put("Alan", "006");

        List<HashMap<String, String>> list_item = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, list_item, R.layout.listview, new String[]
                {"First line", "Second line"}, new int[]{R.id.tv1, R.id.tv2});

        Iterator it = list_mahasiswa.entrySet().iterator();
        while (it.hasNext()) {
            HashMap<String, String> resultMap = new HashMap<>();
            Map.Entry pair = (Map.Entry) it.next();
            resultMap.put("First line", pair.getKey().toString());
            resultMap.put("Second line", pair.getValue().toString());
            list_item.add(resultMap);
        }

        result_list.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return super.onCreateOptionsMenu(menu);
    }

}