package com.example.franklinsierra.labtabstoolbar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franklinsierra.labtabstoolbar.Models.Person;
import com.example.franklinsierra.labtabstoolbar.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class personAdapter extends BaseAdapter {

    //atributos
    private Context context;
    private List<Person> persons;
    private int layout;

    public personAdapter(Context context, List<Person> persons, int layout) {
        this.context = context;
        this.persons = persons;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(layout,null);
            vh=new ViewHolder();
            vh.imageViewCountry=convertView.findViewById(R.id.imageFlag);
            vh.textViewCountry=convertView.findViewById(R.id.textViewPersonCountry);
            vh.textViewName=convertView.findViewById(R.id.textViewPersonName);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder)convertView.getTag();

        }

        Person currentPerson=persons.get(position);
        vh.textViewName.setText(currentPerson.getName());
        vh.textViewCountry.setText(currentPerson.getCountry().getName());

        String url=currentPerson.getCountry().getFlagUrl();
        //      FALTA CARGAR LA IMAGEN CON PICASSO
        Picasso.get().load(url).into(vh.imageViewCountry);



        return convertView;
    }

    private class ViewHolder{
        //elementos de la UI que van en el Fragment List
        TextView textViewName;
        TextView textViewCountry;
        ImageView imageViewCountry;
    }
}
