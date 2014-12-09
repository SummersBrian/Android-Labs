package course.labs.locationlab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceBadgeDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.place_badge_detail);
		
		// TODO - implement the Activity 
		
		// display all the information of the location
		PlaceRecord placeRec = new PlaceRecord(getIntent());
		
		((ImageView) findViewById(R.id.flag)).setImageBitmap(placeRec.getFlagBitmap());
		((TextView) findViewById(R.id.place_name)).setText(placeRec.getPlace());
		((TextView) findViewById(R.id.country_name)).setText(placeRec.getCountryName());
		((TextView)findViewById(R.id.date_visited)).setText(placeRec.getDateVisited().toString());
		((TextView) findViewById(R.id.gps_coordinates)).setText(placeRec.getLocation().getLatitude() + ", "
				+ placeRec.getLocation().getLongitude());
		
		
	}
}
