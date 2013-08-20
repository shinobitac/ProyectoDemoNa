package com.shinobitac.proyectodemona;

import com.shinobitac.proyectodemona.slideout.SlideoutHelper;
import com.shinobitac.proyectodemona.MenuFragment;
import com.shinobitac.proyectodemona.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

public class MenuActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mSlideoutHelper = new SlideoutHelper(this);
		mSlideoutHelper.activate();
		getSupportFragmentManager().beginTransaction()
				.add(R.id.slideout_placeholder, new MenuFragment(), "menu")
				.commit();
		mSlideoutHelper.open();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			mSlideoutHelper.close();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public SlideoutHelper getSlideoutHelper() {
		return mSlideoutHelper;
	}

	private SlideoutHelper mSlideoutHelper;
}

// aqui editas tus propios metodos para poder moverse entre actividades ya
// que el MenuFragment no puede responder como actividad y con el metodo
// closeActivityActual cerramos la actividad donde estemos para que no se
// acumule y sea cerrada al momento de pasar a otra

