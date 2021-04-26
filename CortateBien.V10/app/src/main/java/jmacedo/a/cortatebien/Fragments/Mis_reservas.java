package jmacedo.a.cortatebien.Fragments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import jmacedo.a.cortatebien.Adaptadores.ReservasAdapter;
import jmacedo.a.cortatebien.Entidades.Reserva;
import jmacedo.a.cortatebien.Entidades.Servicios;
import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;

public class Mis_reservas extends AppCompatActivity {

    ConexionSQLiteHelper con;
    ArrayList<Reserva> listaReserva;
    RecyclerView recyclerViewReservas;
    TextView txtIdUsuarioMiReserva;
    FloatingActionButton botonFlotante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reservas);

        listaReserva = new ArrayList<>();
        recyclerViewReservas = (RecyclerView) findViewById(R.id.recyclerMisReservas);
        recyclerViewReservas.setLayoutManager(new LinearLayoutManager(this));

        ReservasAdapter reservasAdapter = new ReservasAdapter(listaReserva);
        recyclerViewReservas.setAdapter(reservasAdapter);
        cargarEmpresaShared();
        consultarReservas();

    }

    private void consultarReservas() {

        int id = Integer.parseInt(txtIdUsuarioMiReserva.getText().toString());
        con = new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db = con.getReadableDatabase();
        Reserva reservas = null;

        try {
            Cursor cursor = db.rawQuery("SELECT "
                    + ConexionUtilidades.CAMPO_NOMBRE + ","
                    + ConexionUtilidades.CAMPO_DIRECCION + ","
                    + ConexionUtilidades.CAMPO_DISTRITO + ","
                    + ConexionUtilidades.CAMPO_NOMBRE_SERVICIO + ","
                    + ConexionUtilidades.CAMPO_DESCRIPCION_SERVICIO + ","
                    + ConexionUtilidades.CAMPO_PRECIO_SERVICIO + ","
                    + ConexionUtilidades.CAMPO_FECHARESERVA + ","
                    + ConexionUtilidades.CAMPO_HORARESERVA + ","
                    + ConexionUtilidades.CAMPO_SERVICIO_IMAGEN + "" +
                    "  FROM " + ConexionUtilidades.TABLA_RESERVA +
                    " JOIN detalleServicio ON detalleServicio.idDetalleServicio = RESERVA.idDetalleServicio" +
                    " JOIN LOCALES ON LOCALES.idLocal = detalleServicio.idLocal"+
                    " JOIN SERVICIOS ON SERVICIOS.idServicio = detalleServicio.idServicio"+
                    " WHERE " +ConexionUtilidades.CAMPO_ID_USUARIO+"= "+ id, null);
            while (cursor.moveToNext()) {

                reservas = new Reserva();
                reservas.setEmpresaR(cursor.getString(0));
                reservas.setDireccionR(cursor.getString(1));
                reservas.setDistritoR(cursor.getString(2));
                reservas.setServicioR(cursor.getString(3));
                reservas.setDescripcionR(cursor.getString(4));
                reservas.setPrecioR(cursor.getInt(5));
                reservas.setFecha(cursor.getString(6));
                reservas.setHora(cursor.getString(7));
                reservas.setImagenReservaServicio(cursor.getString(8));
                listaReserva.add(reservas);
            }
        } catch (SQLException e) {
            Toast.makeText(this, "No se puede encontrar" + e, Toast.LENGTH_LONG).show();
        }
    }

    private void cargarEmpresaShared(){
        txtIdUsuarioMiReserva = (TextView) findViewById(R.id.idUsuarioMiReserva);
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String idUsuarioMiReserva = preferences.getString("idUsuario", "null");
        txtIdUsuarioMiReserva.setText(idUsuarioMiReserva);
    }
    private void retrocesoIcono(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
