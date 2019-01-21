package com.example.franklinsierra.labtabstoolbar.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.franklinsierra.labtabstoolbar.Models.Country;
import com.example.franklinsierra.labtabstoolbar.Models.Person;
import com.example.franklinsierra.labtabstoolbar.R;
import com.example.franklinsierra.labtabstoolbar.Util.Util;

import java.util.List;


public class FormFragment extends Fragment {

    //elementos de la UI
    private EditText editTextName;
    private Spinner spinnerCountry;
    private Button btnCreate;

    private List<Country> countries;
    //interfaz
    private onPersonCreated onPersonCreated;

    public FormFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_form, container, false);

        //ubico los elementos de la Ui
        editTextName = (EditText) vista.findViewById(R.id.editTextName);
        spinnerCountry = (Spinner) vista.findViewById(R.id.spinnerCountry);
        btnCreate = (Button) vista.findViewById(R.id.buttonCreate);

        //cuando clickean el boton
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewPerson();
            }
        });


        //  cargo todos los paises, le paso el contexto para cargar el multilenguaje
        countries = Util.getCountries(getContext());


        //  ++++    ADAPTADOR QUE PERMITE DESPLEGAR LOS PAISES  ++++    //

        // Creamos un ArrayAdapter para ser pasado a nuestro Spinner/DropDown/Lista despegable
        // Con un layout integrado en Android para su uso directo, llamado
        // simple_spinner_dropdown_item
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);

        return vista;
    }



    //  metodo para crear personas
    private void createNewPerson() {
        //  verifico que el campo del nombre no venga vacio
        if (!editTextName.getText().toString().isEmpty()) {
            //  Tomo el pais del spinner
            Country country = (Country) spinnerCountry.getSelectedItem();
            Person newPerson = new Person(editTextName.getText().toString(), country);
            onPersonCreated.createPerson(newPerson);
        }
    }

    //interfaz para comunicarme con el activity
    public interface onPersonCreated {
        void createPerson(Person person);
    }

    //evento que enlaza con el activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onPersonCreated) {
            onPersonCreated = (onPersonCreated) context;
        } else {
            throw new RuntimeException(context.toString() + "Must implement onPersonCreated");
        }
    }

    //limpiador de memoria que desenlaza con el activity
    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        onPersonCreated = null;
    }

}
