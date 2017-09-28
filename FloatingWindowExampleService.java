package com.darktornado.test;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DarkTornado on 2017-09-28.
 */

public class FloatingWindowExampleService extends Service {

    FloatingWindow window = null;

    @Override
    public void onCreate(){
        super.onCreate();
        startForeground(1, new Notification());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            window = new FloatingWindow(this);
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(1);
            TextView title = new TextView(this);
            title.setText("Example\n");
            title.setTextSize(23);
            title.setTextColor(Color.WHITE);
            title.setGravity(Gravity.CENTER);
            layout.addView(title);
            Button[] btns = new Button[10];
            for (int n = 0; n < 10; n++) {
                btns[n] = new Button(this);
                btns[n].setText("Button " + n);
                layout.addView(btns[n]);
            }
            int pad = dip2px(5);
            layout.setPadding(pad, pad, pad, pad);
            ScrollView scroll = new ScrollView(this);
            scroll.addView(layout);
            scroll.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            window.setContentView(scroll);
            window.setBackgroundColor(Color.BLACK);
            window.setWidth(this.getResources().getDisplayMetrics().widthPixels / 3);
            window.setHeight(this.getResources().getDisplayMetrics().heightPixels);
            window.setPosition(Gravity.RIGHT, 0, 0);
            window.show();
        } catch (Exception e) {
            toast(e.toString());
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(window!=null){
            window.dismiss();
            window = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private int dip2px(int dips){
        return (int)Math.ceil(dips*this.getResources().getDisplayMetrics().density);
    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
