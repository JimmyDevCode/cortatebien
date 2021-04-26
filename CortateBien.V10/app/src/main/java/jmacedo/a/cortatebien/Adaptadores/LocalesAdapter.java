package jmacedo.a.cortatebien.Adaptadores;

import android.content.Context;
import android.content.Intent;
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

import jmacedo.a.cortatebien.Entidades.Local;
import jmacedo.a.cortatebien.Fragments.Servicios_empresa;
import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;

public class LocalesAdapter extends RecyclerView.Adapter<LocalesAdapter.ViewHolderLocales> {

    ArrayList<Local> listaLocales;
    //genero el constructor para recibir la lista


    public LocalesAdapter(ArrayList<Local> listaLocales) {
        this.listaLocales = listaLocales;
    }

    @NonNull
    @Override
    public ViewHolderLocales onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_negocios, null, false);
        //retornamos un nuevo viewHolder
        return new ViewHolderLocales(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLocales holder, int position) {

        //utilizamos el objeto holder para llenar
        holder.etinombre.setText(listaLocales.get(position).getNombre());
        holder.etiIdEmpresa.setText(String.format(Locale.getDefault(), "%d",listaLocales.get(position).getIdLocal()));
        holder.etiHorario.setText(listaLocales.get(position).getHorario());
        holder.etiDias.setText(listaLocales.get(position).getDias());
        holder.etiDireccion.setText(listaLocales.get(position).getDireccion());
        holder.etiContacto.setText(listaLocales.get(position).getContacto());
        //holder.foto.setImageResource(listaLocales.get(position).getUrlImagen());
        Picasso.with(holder.foto.getContext()).load(listaLocales.get(position).getUrlImagen()).into(holder.foto);
        holder.etidistrito.setText(listaLocales.get(position).getDistrito());
        //--------------------------------------------------------------------
        holder.setOnClickListener();

    }

    @Override
    public int getItemCount() {
        //los elementos tienen una lista de posiciones
        //retornamos el tamaño de la lista

        return listaLocales.size();
    }

    public class ViewHolderLocales extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        //se referencia a los elementos que tengamos
        TextView etinombre;
        TextView etiIdEmpresa;
        TextView etiContacto;
        TextView etiDireccion;
        TextView etiHorario;
        TextView etiDias;
        TextView etidistrito;
        ImageView foto;
        Button btnServicicios;

        public ViewHolderLocales(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            etinombre = (TextView) itemView.findViewById(R.id.nombre);
            etiIdEmpresa = (TextView) itemView.findViewById(R.id.txtIdEmpresa);
            etiHorario = (TextView) itemView.findViewById(R.id.txtHorario);
            etiDias = (TextView) itemView.findViewById(R.id.txtAtencion);
            etiDireccion = (TextView) itemView.findViewById(R.id.txtDireccion);
            etiContacto = (TextView) itemView.findViewById(R.id.txtContacto);
            etidistrito = (TextView) itemView.findViewById(R.id.txtDistrito);
            foto = (ImageView) itemView.findViewById(R.id.imagenNegocios);
            btnServicicios = (Button) itemView.findViewById(R.id.btnVerMas);

        }

        public void setOnClickListener(){

            btnServicicios.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnVerMas:
                    Intent intent = new Intent(context, Servicios_empresa.class);
                    intent.putExtra("nombreEmpresa", etinombre.getText());
                    intent.putExtra("idEmpresa", etiIdEmpresa.getText());
                    context.startActivity(intent);
                    break;
            }
        }
    }
}

