package com.shinobitac.proyectodemona;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.shinobitac.proyectodemona.slideout.SlideoutActivity;
import com.shinobitac.proyectodemona.R;

public class Principal extends TabActivity {
	Context ctx;
	int currenttab;
	ImageView imgv_tabArrow;
	Intent intent;
	TabHost mTabHost;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabmenu);
		ctx = Principal.this;
		mTabHost = ((TabHost) findViewById(android.R.id.tabhost));
		intent = new Intent(ctx, Populares.class);
		setupTab("Populares", intent);
		intent = new Intent(ctx, MisCanales.class);
		setupTab("Mis Canales", intent);
		intent = new Intent(ctx, Recomendaciones.class);
		setupTab("Recomendaciones", intent);
		currenttab = 0;
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String arg0) {
				currenttab = mTabHost.getCurrentTab();
			}
		});
	}

	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		switch (currenttab) {
		case 0:
			menu.clear();
			menuInflater.inflate(R.menu.populares, menu);
			break;
		case 1:
			menu.clear();
			menuInflater.inflate(R.menu.listar_noticias, menu);
			break;
		case 2:
			menu.clear();
			menuInflater.inflate(R.menu.recomendaciones, menu);
			break;
		default:
			menu.clear();
			menuInflater.inflate(R.menu.principal, menu);
			break;
		}
		return true;
	}

	public void showMenus(View v) {
		this.openOptionsMenu();
	}

	public void showSlider(View v) {
		callMenuSlider(Principal.this, MenuActivity.class);
	}

	private void setupTab(final String tag, Intent intent) {
		View tabview = createTabView(mTabHost.getContext(), tag);
		TabSpec setContent = mTabHost.newTabSpec(tag);
		setContent.setIndicator(tabview);
		setContent.setContent(intent);
		mTabHost.addTab(setContent);
	}

	private static View createTabView(final Context context, final String text) {
		View view = LayoutInflater.from(context)
				.inflate(R.layout.tabs_bg, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		return view;
	}

	public void callMenuSlider(Activity actual, Class<?> destino) {
		int width = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 20, getResources()
						.getDisplayMetrics());
		SlideoutActivity.prepare(actual, R.id.imgv_header_slidershow, width);
		startActivity(new Intent(actual, destino));
		overridePendingTransition(0, 0);
	}

}