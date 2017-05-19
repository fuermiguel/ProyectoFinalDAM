package com.example.fuerm.gestionoficinatecnica.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fuerm.gestionoficinatecnica.R;


/**
 * Created by fuerm on 19/05/2017.
 */

public class AdaptadorDeProyectos extends BaseAdapter {
    private Context context;

    public AdaptadorDeProyectos(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Proyecto.Proyectos.length;
    }

    @Override
    public Object getItem(int position) {
        return Proyecto.Proyectos[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_proyecto, parent, false);
        }

        ImageView imagenCoche = (ImageView) convertView.findViewById(R.id.imagen_proyecto);
        TextView nombreCoche = (TextView) convertView.findViewById(R.id.nombre_proyecto);

        final Proyecto item = (Proyecto) getItem(position);
        imagenCoche.setImageResource(item.getIdDrawable());
        nombreCoche.setText(item.getNombre());

        return convertView;
    }
}
