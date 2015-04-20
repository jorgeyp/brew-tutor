package com.jorgeyp.brewtutor;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import com.jorgeyp.brewtutor.model.Beer;

public class Receiver extends Service {
    Beer beer;
    public Receiver() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d("Receiver", "created");
        Intent intent = new Intent(this, FermentationActivity.class);
//        long[] pattern = {0, 300, 0};
        PendingIntent pi = PendingIntent.getActivity(this, 4, intent, 0);
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification.Builder mBuilder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Mashing done!")
                .setContentText("Proceed to boiling.")
                .setPriority(Notification.PRIORITY_MAX)
                .setSound(sound);

        mBuilder.setContentIntent(pi);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(5, mBuilder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Receiver", "started");
        beer = (Beer) intent.getSerializableExtra("beer");
        Log.d("SERVICE", beer.getName());;
        return START_STICKY;
    }
}
