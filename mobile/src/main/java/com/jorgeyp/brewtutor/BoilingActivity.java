package com.jorgeyp.brewtutor;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jorgeyp.brewtutor.model.Beer;


public class BoilingActivity extends Activity implements View.OnClickListener {
    private TextView timerText;
    private Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boiling);

        Intent intent = getIntent();
        beer = (Beer) intent.getSerializableExtra("beer");

        timerText = (TextView) findViewById(R.id.timer);

        ((Button) findViewById(R.id.startBoiling)).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_boiling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.startBoiling:
                CountDownTimer timer = new CountDownTimer((long) beer.getBoilTime(), 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long second = (millisUntilFinished / 1000) % 60;
                        long minute = (millisUntilFinished / (1000 * 60)) % 60;

                        timerText.setText(String.format("%02d:%02d", minute, second));
                    }

                    @Override
                    public void onFinish() {
                        timerText.setText("Boil done!");
                        timerText.setTextSize(50);
                        showNotification();
                    }
                }.start();

                break;
        }
    }

    private void showNotification() {
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification.Builder mBuilder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Boiling done!")
                        .setContentText("Proceed to fermentation.")
                        .setPriority(Notification.PRIORITY_MAX)
                        .setSound(sound);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, FermentationActivity.class);
        resultIntent.putExtra("beer", beer);


        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(BoilingActivity.class);
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
        int mId = 1;
        mNotificationManager.notify(mId, mBuilder.build());
    }
}
