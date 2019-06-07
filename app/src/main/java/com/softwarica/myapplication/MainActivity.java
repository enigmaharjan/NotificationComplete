package com.softwarica.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import createChannel.CreateChannel;

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo;
    NotificationManagerCompat notificationManagerCompat;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });
    }


    private void DisplayNotification2() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CreateChannel.Channel_1)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("First Message")
                .setContentText("Hello from the other side")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(1, builder.build());

    }

    private void DisplayNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CreateChannel.Channel_2)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Hello from the other side2")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(2, builder.build());
    }
}
