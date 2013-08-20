package com.shinobitac.proyectodemona;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuFragment extends ListFragment {
	int imensualidadespagadas;
	int imensualidadestotales;
	String isAutoConf;
	int[] menuSlider_imgicon;
	String[] menuSlider_menutext;

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		LayoutInflater inflater = (LayoutInflater) getActivity()
				.getApplicationContext()
				.getSystemService(
						getActivity().getApplicationContext().LAYOUT_INFLATER_SERVICE);
		;
		View headerview = inflater.inflate(R.layout.header_menuslider, null);
		View footerview = inflater.inflate(R.layout.footer_menuslider, null);

		menuSlider_imgicon = new int[3];
		menuSlider_menutext = new String[3];
		menuSlider_imgicon[0] = R.drawable.soccer;
		menuSlider_menutext[0] = "Deportes";

		menuSlider_imgicon[1] = R.drawable.mascotas;
		menuSlider_menutext[1] = "Mascotas";

		menuSlider_imgicon[2] = R.drawable.cine;
		menuSlider_menutext[2] = "Cine";

		getListView().addHeaderView(headerview);
		getListView().addFooterView(footerview);
		
		setListAdapter(new AdapterSliderMenu(getActivity()
				.getApplicationContext(), menuSlider_imgicon,
				menuSlider_menutext));
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {

		case 0:
			((MenuActivity) getActivity()).getSlideoutHelper().close();
			break;
		case 1:
			((MenuActivity) getActivity()).getSlideoutHelper().close();
			break;

		case 2:
			((MenuActivity) getActivity()).getSlideoutHelper().close();
			break;
		default:
			break;
		}
	}

	public class AdapterSliderMenu extends BaseAdapter {
		Context context;
		int fitStringlength = 10;
		int[] img_icon;
		String[] menu_text;

		LayoutInflater inf;

		public AdapterSliderMenu(Context c, int img_icon[], String[] menu_text) {
			this.context = c;
			this.img_icon = img_icon;
			this.menu_text = menu_text;

			inf = LayoutInflater.from(context);

		}

		public int getCount() {
			return menu_text.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, View convertView,
				ViewGroup parent) {
			final ViewHolder holder;
			if (convertView == null) {
				convertView = inf.inflate(R.layout.contenido_menuslider_menus,
						null);
				holder = new ViewHolder();
				holder.imgicon = (ImageView) convertView
						.findViewById(R.id.imgv_contenido_menuslider_menus_menuimg);
				holder.menutext = (TextView) convertView
						.findViewById(R.id.tv_contenido_menuslider_menus_menutext);

				convertView.setTag(holder);
			} else {

				holder = (ViewHolder) convertView.getTag();
			}

			holder.menutext.setText(menu_text[position]);
			holder.imgicon.setBackgroundResource(img_icon[position]);

			return convertView;
		}

		class ViewHolder {
			ImageView imgicon;
			TextView menutext;
		}

		public String fitStringLenght(String cadena, int length) {
			if (cadena.length() > length) {
				cadena = cadena.substring(0, length) + "...";
			}
			return cadena;
		}

	}
}