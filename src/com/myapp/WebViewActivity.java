package com.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);

		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		//webView.loadUrl("http://www.google.com");

		String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
		//webView.loadData(customHtml, "text/html", "UTF-8");
		//webView.loadData("http://www.google.com", "text/html", "UTF-8");
		 final Activity activity = this;

		
		webView.setWebChromeClient(new WebChromeClient() {
			   public void onProgressChanged(WebView view, int progress) {
			     // Activities and WebViews measure progress with different scales.
			     // The progress meter will automatically disappear when we reach 100%
			     activity.setProgress(progress * 1000);
			   }
			 });
		webView.setWebViewClient(new WebViewClient() {
			   public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			     Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
			   }
			 });

			 
		webView.loadUrl("http://www.google.co.uk");
		
		Log.d("com","webview containing coffee" +webView.getTitle());
	}

}