package com.example.htmltest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HtmlActivity extends Activity {

	protected String htmlPage;
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_html);
		
		Bundle extras = getIntent().getExtras();
		htmlPage = extras.getString("htmlPage");

		getActionBar().hide();

		// Prepare the webview
		webView = (WebView) findViewById(R.id.webViewHtml);
		webView.setInitialScale(1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAllowFileAccess(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		//webView.addJavascriptInterface(this, "PlayPresentationAct");
		webView.loadUrl("file:///android_asset/" + htmlPage);

		setupWebViewClient();
	}
	
	private void setupWebViewClient() {
	    webView.setWebViewClient(new WebViewClient() {
	        private int running = 0; // Could be public if you want a timer to check.

	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {
	            running++;
	            webView.loadUrl(urlNewString);
	            return true;
	        }

	        @Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
	        	running = Math.max(running, 1); // First request move it to 1.
				super.onPageStarted(view, url, favicon);
			}

			@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
			@Override
	        public void onPageFinished(WebView view, String url) {
	            if(--running == 0) { // just "running--;" if you add a timer.
	                // Call the javascript and pass data
	            	Point viewSize = new Point();
	            	try {
						webView.getDisplay().getSize(viewSize);
					} catch (Exception e) {
						e.printStackTrace();
					}
	            }
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
