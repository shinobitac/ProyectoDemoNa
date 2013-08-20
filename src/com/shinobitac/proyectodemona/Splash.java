package com.shinobitac.proyectodemona;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class Splash extends Activity {

	private static final long SPLASH_DISPLAY_LENGTH = 3000;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Handler handler = new Handler();
		handler.postDelayed(getRunnableStartApp(), SPLASH_DISPLAY_LENGTH);
	}

	private Runnable getRunnableStartApp() {
		Runnable runnable = new Runnable() {
			public void run() {
				Intent intent = new Intent(Splash.this, Login.class);
				startActivity(intent);
				finish();
			}
		};
		return runnable;
	}
}
