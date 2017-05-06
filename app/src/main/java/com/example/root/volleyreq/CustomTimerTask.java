package com.example.root.volleyreq;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.util.TimerTask;

/**
 * Created by root on 6/5/17.
 */
public class CustomTimerTask extends TimerTask {


    private Context context;
    private Handler mHandler = new Handler();

    public CustomTimerTask(Context con) {
        this.context = con;
    }



    @Override
    public void run() {
        new Thread(new Runnable() {

            public void run() {

                mHandler.post(new Runnable() {
                    public void run() {


                        new AsyncLogin().execute("prateek", "gupta");

                    }
                });
            }
        }).start();

    }

}
