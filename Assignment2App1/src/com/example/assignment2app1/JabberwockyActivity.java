package com.example.assignment2app1;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class JabberwockyActivity extends Activity {
	
	private WebView webView;
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		webView = (WebView) findViewById(R.id.webView2);
		webView.loadUrl("file:///android_asset/webcontent/jabberwocky.html");
		mediaPlayer = MediaPlayer.create(this, R.raw.house_of_cards);
		mediaPlayer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}
	
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode)
            {
            case KeyEvent.KEYCODE_BACK:
                if(webView.canGoBack() == true){
                    webView.goBack();
                }else{
                    finish();
                }
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    
	@Override
	protected void onResume() {
		mediaPlayer.start();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		mediaPlayer.pause();
		super.onPause();
	}
	
	public void openWiki(View view) {
		String url = "http://en.wikipedia.org/wiki/Jabberwocky";
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}
	
	public void openPicture(View view) {
		webView.loadUrl("file:///android_asset/webcontent/angraves-highscore6x6.png");
	}
}
