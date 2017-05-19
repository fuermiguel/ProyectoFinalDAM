package com.example.fuerm.gestionoficinatecnica.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
        return Proyecto.proyectos.length;
    }

    @Override
    public Object getItem(int position) {
        return Proyecto.proyectos[position];
    }

    @Override
    public long getItemId(int position) {
        return Proyecto.proyectos[position].getIdDrawable();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_proyecto, parent, false);
        }

        ImageView imagenProyecto = (ImageView) convertView.findViewById(R.id.imagen_proyecto);
        TextView nombreProyecto = (TextView) convertView.findViewById(R.id.nombre_proyecto);

        final Proyecto item = (Proyecto) getItem(position);
        Glide.with(imagenProyecto.getContext())
                .load(Proyecto.proyectos[position].getIdDrawable())
                .into(imagenProyecto);

        nombreProyecto.setText(item.getNombre());

        return convertView;
    }
}
