package com.example.modernartui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.*;

public class MainActivity extends Activity {

	private SeekBar seekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		seekBar = (SeekBar) findViewById(R.id.seekBar);
		seekBar.setMax(15);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int prog;
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				int difference = seekBar.getProgress() - prog;
				prog = seekBar.getProgress();
				System.out.println("seekBar Progress ="+seekBar.getProgress());
				getNewColor(difference, prog);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				System.out.println("start");
				prog = seekBar.getProgress();

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				System.out.println("end");
				prog = seekBar.getProgress();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.more_information) {
			
		}
		return super.onOptionsItemSelected(item);
	}

	private void getNewColor(int difference, int progress) {

		ColorDrawable square = (ColorDrawable) findViewById(R.id.viewRed).getBackground();
		Integer color = square.getColor();
		String colorHex = Integer.toHexString(color).substring(2);
		findViewById(R.id.viewRed).setBackgroundColor(changeColorSquare(colorHex,"red",difference, progress));

		square = (ColorDrawable) findViewById(R.id.viewGreen).getBackground();
		color = square.getColor();
		colorHex = Integer.toHexString(color).substring(2);
		findViewById(R.id.viewGreen).setBackgroundColor(changeColorSquare(colorHex,"green",difference, progress));

		square = (ColorDrawable) findViewById(R.id.viewBlue).getBackground();
		color = square.getColor();
		colorHex = Integer.toHexString(color).substring(2);
		findViewById(R.id.viewBlue).setBackgroundColor(changeColorSquare(colorHex,"blue",difference, progress));

	}

	private int changeColorSquare(String colorHex, String color,int difference, int progress) {
		if (color.equals("red") ) {

			return Color.rgb(255, progress * 16 , 0);

		} else if (color.equals("blue")){
			
			return Color.rgb(0, progress * 16 , 255);
			
		} else {

			return Color.rgb(0, 255, progress * 16);

		} 

	}

}
