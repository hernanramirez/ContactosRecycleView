package info.hernanramirez.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import info.hernanramirez.miscontactos.models.Contacto;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Hernan Ramirez","555444", "nan@nan.com"));
        contactos.add(new Contacto("Sebastian Ramirez","555444", "nan@nan.com"));
        contactos.add(new Contacto("Maria Jose Ramirez","555444", "nan@nan.com"));
        contactos.add(new Contacto("Marianella Alvarado","555444","nan@nan.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto: contactos){
            nombresContacto.add(contacto.getNombre());

        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.cnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.cemail), contactos.get(position).getEmail());
                intent.putExtra(getResources().getString(R.string.ctelefono), contactos.get(position).getTelefono());
                startActivity(intent);
                finish();
            }
        });

    }
}
