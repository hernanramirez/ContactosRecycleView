package info.hernanramirez.miscontactos.fragments;

import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import info.hernanramirez.miscontactos.R;
import info.hernanramirez.miscontactos.adapters.ContactoAdaptador;
import info.hernanramirez.miscontactos.models.Contacto;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;
    RecyclerView listaContactos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(llm);
        inicializarListaContatos();
        inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador =  new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContatos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Hernan Ramirez","555444", "nan@nan.com", R.drawable.barnana));
        contactos.add(new Contacto("Sebastian Ramirez","555444", "nan@nan.com", R.drawable.man));
        contactos.add(new Contacto("Maria Jose Ramirez","555444", "nan@nan.com", R.drawable.mujer));
        contactos.add(new Contacto("Marianella Alvarado","555444","nan@nan.com", R.drawable.candy));


    }
}
