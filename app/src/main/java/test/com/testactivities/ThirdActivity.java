package test.com.testactivities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class ThirdActivity extends Activity {

    final String TAG = "THIRD_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    public void onClickButton3(View view) {

        Log.d(TAG, "onclickButton3: calling Dialer");
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);

    }

    public void onClickButton4(View view) {

        Log.d(TAG, "onclickButton4: calling Map");

//        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
//        if (mapIntent.resolveActivity(getPackageManager()) != null) {
//
//            Log.d(TAG, "onclickButton4: calling San Francisco Map");
//
//            startActivity(mapIntent);
//        }

        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:37.7749,-122.4194"));
        startActivity(mapIntent);

        Log.d(TAG, "onclickButton4: calling Map End");
    }


    public void onClickButton5(View view) {

        Log.d(TAG, "onclickButton5: calling Thread start");

        final Runnable runnableSleep = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "onclickButton5: Inside Thread start");

                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    Log.d(TAG, "onclickButton5: Error when sleeping");
                    e.printStackTrace();
                }

                // After finishing send a message to UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Thread finished", Toast.LENGTH_LONG).show();
                    }
                });
            }
        };
        new Thread(runnableSleep).start();

    }


    public void onClickButton6(View view) {

        Log.d(TAG, "onclickButton6: calling Thread start 2");

        final Runnable runnableSleep = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "onclickButton6: Inside Thread start 2");

                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    Log.d(TAG, "onclickButton6: Error when sleeping");
                    e.printStackTrace();
                }

                // After finishing send a message to UI
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Thread finished 2", Toast.LENGTH_LONG).show();
                    }
                });

            }
        };
        new Thread(runnableSleep).start();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third, menu);
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


}
