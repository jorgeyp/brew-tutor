package com.jorgeyp.brewtutor;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import com.jorgeyp.brewtutor.model.Beer;

public class ReminderService extends IntentService {
    private static final int NOTIF_ID = 1;
    Beer beer;
    String title;
    String description;
    String next;

    public ReminderService(){
        super("ReminderService");
        Log.d("Reminder service", "created");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("Reminder service", "onHandleIntent");
        beer = (Beer) intent.getSerializableExtra("beer");
        title = intent.getStringExtra("title");
        description = intent.getStringExtra("description");
        next = intent.getStringExtra("next");
        Log.d("Reminder service", beer.getName());

        showNotification();
    }

    private void showNotification() {
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification.Builder mBuilder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle(title)
                        .setContentText(description)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setSound(sound);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent;
        if (next.equals("done")) {
            resultIntent = new Intent(this, MainActivity.class);

        } else {
            resultIntent = new Intent(this, ConditioningActivity.class);

        }
        resultIntent.putExtra("beer", beer);
//        startActivity(intent);



        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
//        stackBuilder.addParentStack(ReminderService.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        int mId = 0;
        mNotificationManager.notify(mId, mBuilder.build());
    }

}
