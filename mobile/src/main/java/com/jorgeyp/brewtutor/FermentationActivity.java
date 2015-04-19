package com.jorgeyp.brewtutor;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgeyp.brewtutor.model.Beer;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class FermentationActivity extends Activity {
    private Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fermentation);

        Intent intent = getIntent();
        beer = (Beer) intent.getSerializableExtra("beer");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fermentation, menu);
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

    public void buttonSetReminderPressed(View view) {
        GregorianCalendar date = new GregorianCalendar();
        date.add(Calendar.SECOND, (int) beer.getFermentationTime() / 1000);

        setNotification(date);



        Intent reminderIntent = new Intent(Intent.ACTION_INSERT);
        reminderIntent.setType("vnd.android.cursor.item/event");
        reminderIntent.putExtra(Events.TITLE, "Beer racking time!");
        reminderIntent.putExtra(Events.DESCRIPTION, "Your " + beer.getName() + " is ready to be racked in bottles.");
        reminderIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        reminderIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                date.getTimeInMillis());
        reminderIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                date.getTimeInMillis());

        reminderIntent.setData(Events.CONTENT_URI);
        startActivity(reminderIntent);

    }

    private void setNotification(GregorianCalendar date) {
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(getBaseContext().ALARM_SERVICE);
        Intent intent = new Intent(this, Receiver.class);
        intent.putExtra("beer", beer);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 3, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, date.getTimeInMillis(), pendingIntent);
    }
}
