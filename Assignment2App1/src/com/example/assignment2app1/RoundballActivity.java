package com.example.assignment2app1;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class RoundballActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView roundballWebView = (WebView) findViewById(R.id.webView1);
		roundballWebView.getSettings().setJavaScriptEnabled(true);
		roundballWebView.getSettings().setDomStorageEnabled(true);
		roundballWebView.loadUrl("file:///android_asset/webcontent/roundball/roundball.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.roundball, menu);
		return true;
	}

}
