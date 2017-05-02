package com.example.ciron.music;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ciron on 17/4/17.
 */

public class PlaylistActivity extends ListActivity {
    public ArrayList<HashMap<String,String>> playlist = new ArrayList<HashMap<String, String>>();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.playlist);
        ArrayList<HashMap<String,String>> playlistData = new ArrayList<HashMap<String, String>>();
        SongManager songlist = new SongManager();
        playlist = songlist.getPlayList();
        for(int i=0;i<playlist.size();i++)
            playlistData.add(playlist.get(i));
        ListAdapter list = new SimpleAdapter(this,playlistData,R.layout.list_item,new String[]{"songTitle"},new int[]{R.id.songTitle});
           setListAdapter(list);
        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                int songIndex = position;
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                in.putExtra("songIndex",songIndex);
                setResult(100,in);
                finish();

            }
        });
    }
}
