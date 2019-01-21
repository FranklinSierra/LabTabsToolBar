package com.example.franklinsierra.labtabstoolbar.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.franklinsierra.labtabstoolbar.Adapters.personAdapter;
import com.example.franklinsierra.labtabstoolbar.Models.Person;
import com.example.franklinsierra.labtabstoolbar.R;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    //atributos
    private List<Person> persons;
    private ListView listView;
    private personAdapter adapter;



    public ListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_list, container, false);
        persons=new ArrayList<Person>();

        listView=(ListView)vista.findViewById(R.id.listViewPerson);
        adapter=new personAdapter(getContext(),persons,R.layout.list_view_item_person);
        listView.setAdapter(adapter);

        return vista;
    }

    //  ++++    Metodo que toma lo que viene de la ruta: FormFragment->activity->ListFragment
    public void addPerson(Person person){
        // lo agrego al ArrayList
        this.persons.add(person);
        //notifico del cambio al adaptador
        adapter.notifyDataSetChanged();
    }
}
