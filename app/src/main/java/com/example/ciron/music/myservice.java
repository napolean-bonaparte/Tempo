/*package com.example.ciron.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by ciron on 3/5/17.
 */

/*public class myservice extends Service implements MediaPlayer.OnCompletionListener {
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

   @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       mp = new MediaPlayer();
       mp.setOnCompletionListener(this);
       playSong(MainActivity.indexofSong);

        return START_STICKY;
    }
    public void  playSong(int songIndex){
        // Play song
        try {
            mp.reset();
            mp.setDataSource(MainActivity.songsList.get(songIndex).get("songPath"));
            mp.prepare();
            mp.start();
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
            playSong(MainActivity.currentSongIndex);
        } else if(MainActivity.isShuffle){
            // shuffle is on - play a random song
            Random rand = new Random();
            MainActivity.currentSongIndex = rand.nextInt((MainActivity.songsList.size() - 1) - 0 + 1) + 0;
            playSong(MainActivity.currentSongIndex);
        } else{
            // no repeat or shuffle ON - play next song
            if(MainActivity.currentSongIndex < (MainActivity.songsList.size() - 1)){
                playSong(MainActivity.currentSongIndex + 1);
                MainActivity.currentSongIndex = MainActivity.currentSongIndex + 1;
            }else{
                // play first song
                playSong(0);
                MainActivity.currentSongIndex = 0;
            }
        }
    }
    }
*/