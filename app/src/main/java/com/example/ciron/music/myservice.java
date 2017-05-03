package com.example.ciron.music;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by ciron on 3/5/17.
 */

public class myservice extends Service implements MediaPlayer.OnCompletionListener {
    static MediaPlayer mp1;
    int index;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

   @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       mp1 = new MediaPlayer();
      mp1.setOnCompletionListener(this);
       index = intent.getExtras().getInt("songIndex");
       playSong1(index);
       return START_STICKY;
    }
    public void  playSong1(int songIndex){
        // Play song
        try {
            mp1.reset();
            mp1.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp1.setDataSource(MainActivity.songsList.get(songIndex).get("songPath"));
            mp1.prepare();
            mp1.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onCompletion(MediaPlayer arg0) {

        // check for repeat is ON or OFF
        if(MainActivity.isRepeat){
            // repeat is on play same song again
            playSong1(MainActivity.currentSongIndex);
//            Toast.makeText(this, "Repeatcalled", Toast.LENGTH_SHORT).show();
        } else if(MainActivity.isShuffle){
            // shuffle is on - play a random song
            Random rand = new Random();
            MainActivity.currentSongIndex = rand.nextInt((MainActivity.songsList.size() - 1) - 0 + 1) + 0;
            playSong1(MainActivity.currentSongIndex);
//            Toast.makeText(this, "Shufflecalled", Toast.LENGTH_SHORT).show();
        } else{
            // no repeat or shuffle ON - play next song
            if(MainActivity.currentSongIndex < (MainActivity.songsList.size() - 1)){
                playSong1(MainActivity.currentSongIndex + 1);
                MainActivity.currentSongIndex = MainActivity.currentSongIndex + 1;
            }else{
                // play first song
                playSong1(0);
                MainActivity.currentSongIndex = 0;
            }
        }
    }
    @Override
    public void onDestroy(){

        myservice.mp1.release();
        super.onDestroy();
    }
    }
