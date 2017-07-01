package com.example.faiz.coinflipapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_flip;
    ImageView iv_coin;
    Random r;

    int coins_side;//0 heads and 1 tails

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_flip = (Button) findViewById(R.id.b_flip);
        iv_coin = (ImageView) findViewById(R.id.iv_coin);
        r = new Random();
        b_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coins_side = r.nextInt(2);
                if (coins_side == 0) {
                    iv_coin.setImageResource(R.drawable.head);
                  //  addNotification1();
                NotificationGenerator1.openActivtyNotification(getApplicationContext());
                    Toast.makeText(MainActivity.this, "Heads!", Toast.LENGTH_LONG).show();
                } else if (coins_side == 1) {
                    iv_coin.setImageResource(R.drawable.tail);
                    addNotification2();
                    Toast.makeText(MainActivity.this, "Tails!", Toast.LENGTH_LONG).show();

                }
                RotateAnimation rotate = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(1000);
                iv_coin.startAnimation(rotate);
            }
        });
    }

    private void addNotification1() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.abc);
        builder.setContentTitle("Flip app notification");
        builder.setContentText("It's Head's");
        builder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(8, notification);
    }
    private void addNotification2() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.abc);
        builder.setContentTitle("Flip app notification");
        builder.setContentText("It's Tail's");
        Notification notification = builder.build();
      builder.setVibrate(new long[] {1000, 1000, 1000, 1000, 1000 });
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(8, notification);
    }
}
