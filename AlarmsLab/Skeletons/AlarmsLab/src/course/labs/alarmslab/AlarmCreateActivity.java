package course.labs.alarmslab;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AlarmCreateActivity extends Activity {

	public static final String TWEET_STRING = "TWEET";
	private AlarmManager mAlarmManager;

	private static final String TAG = "AlarmCreateActivity";
	private EditText mTweetTextView, mDelayTextView;
	private int mID = 13;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//TODO - Set up an AlarmManager
		mAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

		mTweetTextView = (EditText) findViewById(R.id.text);
		mDelayTextView = (EditText) findViewById(R.id.time);

	}

	public void set(View v) {
		String tweetText = mTweetTextView.getText().toString();
		Long delay = Integer.parseInt(mDelayTextView.getText().toString()) * 1000L;

		//TODO - Create an Intent to start the AlarmTweetService
		Intent startTweetIntent = new Intent(AlarmCreateActivity.this, AlarmTweetService.class);

		//TODO - Add the tweet as an extra to the Intent
		startTweetIntent.putExtra(TWEET_STRING, tweetText);

		//TODO - Create a PendingIntent that will use the Intent above to start the
		// AlarmTweetService. Use PendingIntent.getService().

		// Pass in a unique value for the request code. Otherwise, your
		// pendingIntent will be overridden if there are two or more at any one time.

		// Pass in PendingIntent.FLAG_ONE_SHOT as a flag, which will make
		// sure that your PendingIntent is only used once.
		PendingIntent startTweetPending = PendingIntent.getService(AlarmCreateActivity.this, mID, 
				startTweetIntent, PendingIntent.FLAG_ONE_SHOT);

		Log.d(TAG, "Tweet sent to AlarmTweetService");

		
		//TODO - Use the AlarmManager set method to set the Alarm
		mAlarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + delay, startTweetPending);

	}

	public void clear(View v) {
		mTweetTextView.setText("");
		mDelayTextView.setText("");

	}
}
