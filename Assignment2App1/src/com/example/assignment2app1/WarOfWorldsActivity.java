package com.example.assignment2app1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class WarOfWorldsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView warOfTheWorldsWebView = (WebView) findViewById(R.id.webView1);
		warOfTheWorldsWebView.loadUrl("file:///android_asset/webcontent/waroftheworlds.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.war_of_worlds, menu);
		return true;
	}

}
