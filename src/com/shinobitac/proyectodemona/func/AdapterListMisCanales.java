package com.shinobitac.proyectodemona.func;

import com.shinobitac.proyectodemona.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterListMisCanales extends BaseAdapter {
	Context context;
	LayoutInflater inf;
	String[] noticia;
	String[] titulonoticia;

	public AdapterListMisCanales(Context context, String[] titulonoticia,
			String[] noticia) {
		this.context = context;
		this.titulonoticia = titulonoticia;
		this.noticia = noticia;
		inf = LayoutInflater.from(context);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return noticia.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;

		if (convertView == null) {
			convertView = inf.inflate(R.layout.miscanales_listacontenido, null);
			holder = new ViewHolder();
			holder.noticia = (TextView) convertView
					.findViewById(R.id.tv_principal_contenido_miscanales_noticiacontenido);
			holder.titulonoticia = (TextView) convertView
					.findViewById(R.id.tv_principal_contenido_miscanales_titulocontenido);
			convertView.setTag(holder);
		} else {

			holder = (ViewHolder) convertView.getTag();
		}// fin del else
		holder.noticia.setText(fitStringLenght(noticia[position], 20));
		holder.titulonoticia.setText(fitStringLenght(titulonoticia[position],
				20));

		return convertView;
	}// fin de getview

	class ViewHolder {
		TextView noticia;
		TextView titulonoticia;

	}// fin del viewholder

	public String fitStringLenght(String cadena, int length) {
		if (cadena.length() > length) {
			cadena = cadena.substring(0, length) + "...";
		}
		return cadena;
	}
}// fin de adapter