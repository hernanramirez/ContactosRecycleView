package info.hernanramirez.miscontactos.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import info.hernanramirez.miscontactos.DetalleContacto;
import info.hernanramirez.miscontactos.R;
import info.hernanramirez.miscontactos.models.Contacto;

/**
 * Created by hernanr on 3/28/18.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }



    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflar el layout y lo pasara al viewHolder para que lo obtenga los view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        // Asicia cada elemento en la lista con cada view

        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCardView.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCardView.setText(contacto.getTelefono());


        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono", contacto.getTelefono());
                intent.putExtra("Email", contacto.getEmail());

                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a: " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() { // cantidad de elemento que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCardView;
        private TextView tvTelefonoCardView;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCardView = (TextView) itemView.findViewById(R.id.tvNombreCardView);
            tvTelefonoCardView = (TextView) itemView.findViewById(R.id.tvTelefonoCardView);
            tvTelefonoCardView = (TextView) itemView.findViewById(R.id.tvTelefonoCardView);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
