package app;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import com.softwarica.myapplication.BroadCastActivity;
import com.softwarica.myapplication.R;

import createChannel.CreateChannel;

public class BroadCastReceiver extends BroadcastReceiver {
    private NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadCastReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;
        notificationManagerCompat = NotificationManagerCompat.from(context);
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if(noConnectivity){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
                DisplayNotification();
            }
            else{
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                DisplayNotification2();
            }

        }
    }
    int id =1;
    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(context, CreateChannel.Channel_2)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("No Connection")
                .setContentText("No connectivity, please turn on the wifi")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(id, notification);
id++;
    }
    private void DisplayNotification2() {
        Notification notification = new NotificationCompat.Builder(context, CreateChannel.Channel_1)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Connected")
                .setContentText("You have been connected to wifi network")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(id, notification);
        id++;
    }
}
