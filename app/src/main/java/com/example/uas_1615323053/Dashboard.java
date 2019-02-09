package com.example.uas_1615323053;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listview;
    private GridView gridView;
    private ListViewArrayAdapter listViewArrayAdapter;
    private GridViewArrayAdapter gridViewArrayAdapter;
    private List<Artikel> artikelList;
    private int currentViewMode;
    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        stubGrid = (ViewStub) findViewById(R.id.stubgrid);
        stubList = (ViewStub) findViewById(R.id.stublist);

        stubList.inflate();
        stubGrid.inflate();

        listview = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.grid_view);

        getArtikelList();

        SharedPreferences sharedPreferences=getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);

        listview.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        SwitchMode();
    }

    private void SwitchMode() {
        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        } else {
            stubGrid.setVisibility(View.VISIBLE);
            stubList.setVisibility(View.GONE);
        } setAdapterList();
    }

    private void setAdapterList() {
        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewArrayAdapter = new ListViewArrayAdapter(this,R.layout.list_,artikelList);
            listview.setAdapter(listViewArrayAdapter);
        }else {
            gridViewArrayAdapter = new GridViewArrayAdapter(this,R.layout.grid_,artikelList);
            gridView.setAdapter(gridViewArrayAdapter);
        }
    }

    private List<Artikel> getArtikelList() {
        artikelList = new ArrayList<>();

        artikelList.add(new Artikel(R.drawable.mob,"Title 1","1 hours ago","Descriptions of text 1"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 2","1 hours ago","Descriptions of text 2"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 3","1 hours ago","Descriptions of text 3"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 4","1 hours ago","Descriptions of text 4"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 5","1 hours ago","Descriptions of text 5"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 6","1 hours ago","Descriptions of text 6"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 7","1 hours ago","Descriptions of text 7"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 8","1 hours ago","Descriptions of text 8"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 9","1 hours ago","Descriptions of text 9"));
        artikelList.add(new Artikel(R.drawable.mob,"Title 10","1 hours ago","Descriptions of text 10"));

        return artikelList;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
       Database storage = Database.getInstance();
        boolean allowSwitch = false;

        if(!storage.isAuthenticated()) {
            Toast.makeText(getApplicationContext(), "Silahkan login untuk mengubah tampilan", Toast.LENGTH_SHORT).show();
            allowSwitch = false;
        } else {
            switch (item.getItemId()) {
                case R.id.menu_list:
                    if (VIEW_MODE_LISTVIEW == currentViewMode) {
                        currentViewMode = VIEW_MODE_GRIDVIEW;
                    } else {
                        currentViewMode = VIEW_MODE_LISTVIEW;
                    }

                    SwitchMode();
                    SharedPreferences sharedPreferences=getSharedPreferences("ViewMode",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putInt("currentViewMode",currentViewMode);
                    editor.commit();

                    break;
            }

            allowSwitch = true;
        }

        return allowSwitch;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(),artikelList.get(position).getImageId(),Toast.LENGTH_SHORT);
        }
    };

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }
}
