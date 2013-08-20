package com.shinobitac.proyectodemona;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import com.shinobitac.proyectodemona.func.AdapterListMisCanales;

public class MisCanales extends Activity {
	Context ctx;
	ImageView imgv_masmenos;
	ImageView imgv_menus;
	ListView lv_miscanales;
	String[] titulonoticias, noticias;
	ProgressDialog pd;
	SlidingDrawer sld;
	int tamañonoticias = 20;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.miscanales);
		ctx = this;
		refillCanales();
		sld = ((SlidingDrawer) findViewById(R.id.sd_masopciones));
		imgv_masmenos = ((ImageView) findViewById(R.id.imgv_masopciones));
		lv_miscanales = ((ListView) findViewById(R.id.lv_principal_miscanales));

		sld.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
			public void onDrawerOpened() {
				imgv_masmenos.setImageDrawable(getResources().getDrawable(
						R.drawable.btnmenos));
			}
		});
		sld.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
			public void onDrawerClosed() {
				imgv_masmenos.setImageDrawable(getResources().getDrawable(
						R.drawable.btnmas));
			}
		});
	}

	private void refillCanales() {

		titulonoticias = new String[tamañonoticias];
		noticias = new String[tamañonoticias];
		pd = ProgressDialog.show(ctx,
				getResources().getString(R.string.app_name),
				"Obteniendo noticias, por favor espera...", true, false);
		pd.setMax(100);
		Thread thread = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < titulonoticias.length; i++) {
					titulonoticias[i] = ("titulo noticia " + i);
					noticias[i] = ("La noticia número " + i);
					Log.w("titulonoticias[" + i + "]", "" + titulonoticias[i]);
					Log.w("noticias[" + i + "]", "" + noticias[i]);
				}
				runOnUiThread(new Runnable() {
					public void run() {

						if (pd.isShowing()) {
							lv_miscanales.setAdapter(new AdapterListMisCanales(
									ctx, titulonoticias, noticias));
							pd.dismiss();
						}
					}
				});

			}
		});
		thread.start();
	}
}
