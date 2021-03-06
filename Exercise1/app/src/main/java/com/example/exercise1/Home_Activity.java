package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.icu.text.Edits;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;
    private ListViewAdapter adapter;
    SearchView searchView;
    String[] listNama;
    ArrayAdapter<String> arrayAdapter;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    String namakontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        searchView = findViewById(R.id.search);
        listNama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina", "Gita", "Vian", "Luthfi"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, listNama);
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();
        for (int i = 0; i < listNama.length; i++) {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
            adapter = new ListViewAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    namakontak = classNamaArrayList.get(position).getNama();
                    bundle.putString("a", namakontak.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(Home_Activity.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();
                }
            });


            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Home_Activity.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Home_Activity.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnView:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor = namakontak.trim();
                String isinomor = "";
                if (nomor == "Inayah"){
                    isinomor = "082208220822";
                }
                else if (nomor == "Ilham"){
                    isinomor = "082222222222";
                }
                else if (nomor == "Eris"){
                    isinomor = "082222222223";
                }
                else if (nomor == "Fikri"){
                    isinomor = "082222222224";
                }
                else if (nomor == "Maul"){
                    isinomor = "082222222225";
                }
                else if (nomor == "Intan"){
                    isinomor = "082222222226";
                }
                else if (nomor == "Vina"){
                    isinomor = "082222222227";
                }
                else if (nomor == "Gita"){
                    isinomor = "082222222228";
                }
                else if (nomor == "Vian"){
                    isinomor = "082222222229";
                }
                else if (nomor == "Luthfi"){
                    isinomor = "082222222220";
                }

                Toast.makeText(getApplicationContext(), isinomor,
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

}