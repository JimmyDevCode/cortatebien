package jmacedo.a.cortatebien.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

import jmacedo.a.cortatebien.Entidades.Reserva;
import jmacedo.a.cortatebien.Fragments.Generar_reserva;
import jmacedo.a.cortatebien.R;

public class ReservasAdapter extends RecyclerView.Adapter<ReservasAdapter.ViewHolderReservas> {

    ArrayList<Reserva> listaReservas;

    public ReservasAdapter(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @NonNull
    @Override
    public ViewHolderReservas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reservas, null, false);

        return new ViewHolderReservas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderReservas holder, int position) {

        holder.txtNombreEmpresa.setText(listaReservas.get(position).getEmpresaR());
        holder.txtNombreUsuario.setText(listaReservas.get(position).getUsuarioR());
        holder.txtDireccion.setText(listaReservas.get(position).getDireccionR());
        holder.txtDistrito.setText(listaReservas.get(position).getDistritoR());
        holder.txtServicio.setText(listaReservas.get(position).getServicioR());
        holder.txtDescripcion.setText(listaReservas.get(position).getDescripcionR());
        holder.txtPrecio.setText(String.format(Locale.getDefault(), "%d",listaReservas.get(position).getPrecioR()));
        holder.txtFecha.setText(listaReservas.get(position).getFecha());
        holder.txtHora.setText(listaReservas.get(position).getHora());
        Picasso.with(holder.imagenReservaUsuario.getContext()).load(listaReservas.get(position).getImagenReservaServicio()).into(holder.imagenReservaUsuario);


    }

    @Override
    public int getItemCount() {
        return listaReservas.size();
    }

    public class ViewHolderReservas extends RecyclerView.ViewHolder {

        TextView txtNombreEmpresa;
        TextView txtNombreUsuario;
        TextView txtDireccion;
        TextView txtDistrito;
        TextView txtServicio;
        TextView txtDescripcion;
        TextView txtPrecio;
        TextView txtFecha;
        TextView txtHora;
        ImageView imagenReservaUsuario;


        public ViewHolderReservas(@NonNull View itemView) {
            super(itemView);

            txtNombreEmpresa = (TextView) itemView.findViewById(R.id.miReservaEmpresa);
            txtDireccion = (TextView) itemView.findViewById(R.id.miReservaDireccion);
            txtNombreUsuario = (TextView) itemView.findViewById(R.id.miReservaUsuario);
            txtDistrito = (TextView) itemView.findViewById(R.id.miReservaDistrito);
            txtServicio = (TextView) itemView.findViewById(R.id.miReservaServicio);
            txtDescripcion = (TextView) itemView.findViewById(R.id.miReservaDescripcion);
            txtPrecio = (TextView) itemView.findViewById(R.id.miReservaPrecio);
            txtFecha = (TextView) itemView.findViewById(R.id.miReservaFecha);
            txtHora = (TextView) itemView.findViewById(R.id.miReservaHora);
            imagenReservaUsuario = (ImageView) itemView.findViewById(R.id.imagenReservaUsuario);
        }
    }
}
