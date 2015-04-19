package com.jorgeyp.brewtutor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
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
                CountDownTimer timer = new CountDownTimer((long) beer.getMashTime() * 60000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        String v = String.format("%02d", millisUntilFinished / 60000);
                        int va = (int)( (millisUntilFinished%60000)/1000);

                        timerText.setText(v + ":" + String.format("%02d", va));
                    }

                    @Override
                    public void onFinish() {
                        timerText.setText("Mashing done!");
                    }
                }.start();

                break;
        }
    }
}
