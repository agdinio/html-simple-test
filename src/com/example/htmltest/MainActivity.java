package com.example.htmltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity implements Button.OnClickListener {
	
	private Spinner htmlPage;
	private Button goButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Get controls
		htmlPage = (Spinner) findViewById(R.id.htmlPage);
		ArrayAdapter<HtmlPage> adapterHtmlPage = new ArrayAdapter<HtmlPage>(this, R.layout.spinner_item, HtmlPage.values());
		adapterHtmlPage.setDropDownViewResource(R.layout.spinner_dropdown_item);
		htmlPage.setAdapter(adapterHtmlPage);

		goButton = (Button) findViewById(R.id.goButton);
		goButton.setOnClickListener(this);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Navigate to a webview that shows the image in html
		Log.d("htmltest.MainActivity", "Got a click on the Go button");
		//Toast.makeText(this, "Go Go Go!", Toast.LENGTH_LONG).show();
        Intent htmlActivity = new Intent(MainActivity.this, HtmlActivity.class);
        htmlActivity.putExtra("htmlPage", ((HtmlPage)htmlPage.getSelectedItem()).getPage());
        startActivity(htmlActivity);
	}
}
