package com.example.volley;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {
    private ArrayList<Usuario> users;
    private Context context;
    static final String EXTRA = "com.exaple.volley";
    public MiAdaptador(ArrayList<Usuario> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.hijo,parent,false);
        }
        TextView row =  convertView.findViewById(R.id.txv);
        String registroUser = "Id : " + users.get(position).getId() +" Title "+users.get(position).getTitle();
        row.setText(registroUser);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, UsuarioDetalleActivity.class);
                Log.d("MILOG",users.get(position).toString());
                i.putExtra(EXTRA, users.get(position));
                context.startActivity(i);
            }
        });
        return convertView;
    }

}
