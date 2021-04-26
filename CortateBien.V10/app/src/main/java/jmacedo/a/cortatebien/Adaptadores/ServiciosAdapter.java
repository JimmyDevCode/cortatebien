package jmacedo.a.cortatebien.Adaptadores;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

import jmacedo.a.cortatebien.Entidades.Servicios;
import jmacedo.a.cortatebien.Fragments.Generar_reserva;
import jmacedo.a.cortatebien.Fragments.MainActivity;
import jmacedo.a.cortatebien.Fragments.Servicios_empresa;
import jmacedo.a.cortatebien.R;


public class ServiciosAdapter  extends RecyclerView.Adapter<ServiciosAdapter.ViewHolderServicios> {

    ArrayList<Servicios> listaServicios;

    public ServiciosAdapter(ArrayList<Servicios> listaServicios) {
        this.listaServicios = listaServicios;
    }

    @NonNull
    @Override
    public ViewHolderServicios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servicios,null,false);
        return new ViewHolderServicios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderServicios holder, int position) {

        holder.etiNombreServicio.setText(listaServicios.get(position).getNombreServicio());
        holder.txtIdServicioEmpresa.setText(String.format(Locale.getDefault(), "%d",listaServicios.get(position).getIdServicio()));
        holder.etiPrecio.setText(String.format(Locale.getDefault(), "%d",listaServicios.get(position).getPrecio()));
        holder.etiDescripcion.setText(listaServicios.get(position).getDescripcionServicio());
        Picasso.with(holder.imagenServicio.getContext()).load(listaServicios.get(position).getUrlImagenServicio()).into(holder.imagenServicio);

        holder.setOnClickListener();
    }

    @Override
    public int getItemCount()
    {
        return listaServicios.size();
    }

    public class ViewHolderServicios extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        TextView etiNombreServicio;
        TextView etiPrecio;
        TextView txtIdServicioEmpresa;
        TextView etiDescripcion;
        ImageView imagenServicio;
        Button btnElegir;


        public ViewHolderServicios(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            etiNombreServicio = (TextView)  itemView.findViewById(R.id.txtNombreServicio);
            txtIdServicioEmpresa = (TextView) itemView.findViewById(R.id.idServicioEmpresa);
            etiPrecio = (TextView) itemView.findViewById(R.id.txtPrecio);
            etiDescripcion = (TextView) itemView.findViewById(R.id.txtDescripcion);
            btnElegir = (Button)itemView.findViewById(R.id.btnElegir);
            imagenServicio = (ImageView) itemView.findViewById(R.id.imagenServicio);

        }
        public void setOnClickListener(){

            btnElegir.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnElegir:
                    SharedPreferences preferences = context.getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                    String nombreServicio = etiNombreServicio.getText().toString();
                    String descripcionServicio = etiDescripcion.getText().toString();
                    String precioServicio = etiPrecio.getText().toString();
                    String idServicio = txtIdServicioEmpresa.getText().toString();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("nombreServicio", nombreServicio);
                    editor.putString("descripcionServicio", descripcionServicio);
                    editor.putString("precioServicio", precioServicio);
                    editor.putString("idServicioEmpresaGR", idServicio);
                    editor.commit();
                    Intent intent = new Intent(context, Generar_reserva.class);
                    context.startActivity(intent);
                    break;

            }
        }
    }
}
