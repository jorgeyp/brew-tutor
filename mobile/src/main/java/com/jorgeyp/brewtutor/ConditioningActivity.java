package com.jorgeyp.brewtutor;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jorgeyp.brewtutor.model.Beer;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ConditioningActivity extends Activity {
    Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditioning);

        Intent intent = getIntent();
        beer = (Beer) intent.getSerializableExtra("beer");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conditioning, menu);
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
        date.add(Calendar.SECOND, (int) beer.getConditioningTime() / 1000);

        setNotification(date);

        Intent reminderIntent = new Intent(Intent.ACTION_INSERT);
        reminderIntent.setType("vnd.android.cursor.item/event");
        reminderIntent.putExtra(CalendarContract.Events.TITLE, getString(R.string.beer_ready));
        reminderIntent.putExtra(CalendarContract.Events.DESCRIPTION, getString(R.string.can_taste) + beer.getName());
        reminderIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        reminderIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                date.getTimeInMillis());
        reminderIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                date.getTimeInMillis());

        reminderIntent.setData(CalendarContract.Events.CONTENT_URI);
        startActivity(reminderIntent);

    }

    private void setNotification(GregorianCalendar date) {
        Log.d("Conditioning", "calling ready");
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        Intent intent = new Intent(this, ReminderService.class);
        intent.putExtra("beer", beer);
        intent.putExtra("title", getString(R.string.beer_ready));
        intent.putExtra("description", getString(R.string.can_taste) + beer.getName());
        intent.putExtra("next", "done");
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC, date.getTimeInMillis(), pendingIntent);
    }
}
