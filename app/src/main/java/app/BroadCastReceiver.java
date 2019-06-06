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

public class BroadCastReceiver extends BroadcastReceiver {
    private NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadCastReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if(noConnectivity){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }

        }
    }
    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(context, "Channel2")
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("No Connection")
                .setContentText("No connectivity, please turn on the wifi")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }
    private void DisplayNotification2() {
        Notification notification = new NotificationCompat.Builder(context, "Channel2")
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Connected")
                .setContentText("You have been connected to wifi network")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}
