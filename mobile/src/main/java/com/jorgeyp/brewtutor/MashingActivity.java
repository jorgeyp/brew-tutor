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
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgeyp.brewtutor.model.Beer;


public class MashingActivity extends Activity implements View.OnClickListener {
//    private Chronometer chronometer;
    private TextView timerText;
    private Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mashing);

        Intent intent = getIntent();
        beer = (Beer) intent.getSerializableExtra("beer");
//        Toast.makeText(getApplicationContext(), beer.toString(), Toast.LENGTH_LONG).show();

        TextView temperatureText = (TextView) findViewById(R.id.mashingTempText);
        temperatureText.setText(String.valueOf(beer.getMashTemp()) + getString(R.string.temp_units));

        timerText = (TextView) findViewById(R.id.timer);

//        chronometer = (Chronometer) findViewById(R.id.chronometer);
        ((Button) findViewById(R.id.startButton)).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mashing, menu);
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
//        Log.d("onclick", v.toString());
        switch(v.getId()) {
            case R.id.startButton:
//                chronometer.setBase(SystemClock.elapsedRealtime());
//                chronometer.start();
                CountDownTimer timer = new CountDownTimer((long) beer.getMashTime(), 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long second = (millisUntilFinished / 1000) % 60;
                        long minute = (millisUntilFinished / (1000 * 60)) % 60;

                        timerText.setText(String.format("%02d:%02d", minute, second));
                    }

                    @Override
                    public void onFinish() {
                        timerText.setText("Mashing done!");
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
                        .setContentTitle(getString(R.string.mashing_done))
                        .setContentText(getString(R.string.do_boil))
                        .setPriority(Notification.PRIORITY_MAX)
                        .setSound(sound);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, BoilingActivity.class);
        resultIntent.putExtra("beer", beer);
//        startActivity(intent);



        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MashingActivity.class);
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

    public void nextStep(View view) {

        Intent resultIntent = new Intent(this, BoilingActivity.class);
        resultIntent.putExtra("beer", beer);
        startActivity(resultIntent);
    }
}
