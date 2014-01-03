package in.nikhilbhardwaj.luckyseven;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private NumberPicker numberPicker;
	private ImageView diceImage1, diceImage2;
	private Button button;
	private static Dice [] die = new NaiveDice[2];
	
	static {
		die[0] = new NaiveDice();
		die[1] = new NaiveDice();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeUIComponents();
		// Set up the event handling
		// Using an anonymous inner class in this case is probably ok
		// but for something more complex its better to implement this in a separate class
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int dice1 = die[0].roll();
				int dice2 = die[1].roll();
				int guess = numberPicker.getValue();
				
				// Set the two die on the screen
				diceImage1.setImageDrawable(getImageForDice(dice1));
				diceImage2.setImageDrawable(getImageForDice(dice2));
				
				if(guess == (dice1 + dice2)) {
					Toast.makeText(getApplicationContext(), "You Win!",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "You Lost, Please Try Again.",
							Toast.LENGTH_SHORT).show();
				}	
			}
		});
	}

	// Initialize the number picker
	private void initializeUIComponents() {
		numberPicker = (NumberPicker) findViewById(R.id.numberPicker1);
		// Set the min and max values possible with two die 
		numberPicker.setMinValue(2);
		numberPicker.setMaxValue(12);
		diceImage1 = (ImageView) findViewById(R.id.imageView1);
		diceImage2 = (ImageView) findViewById(R.id.imageView2);
		button = (Button) findViewById(R.id.button1);
	}
	
	// Helper Method to return the correct image corresponding to the dice
	private Drawable getImageForDice(int number) {
		int imageResource = getResources().getIdentifier("img_" + number, 
				"drawable", getPackageName());
		return getResources().getDrawable(imageResource);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
