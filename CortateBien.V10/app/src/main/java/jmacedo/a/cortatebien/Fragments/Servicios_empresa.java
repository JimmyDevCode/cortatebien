package jmacedo.a.cortatebien.Fragments;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import jmacedo.a.cortatebien.Adaptadores.ServiciosAdapter;
import jmacedo.a.cortatebien.Entidades.Local;
import jmacedo.a.cortatebien.Entidades.Servicios;
import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;

public class Servicios_empresa extends AppCompatActivity {

    TextView etinomnbreEmpresa;
    TextView txtNombreServicio;
    TextView txtIdEmpresa;
    RecyclerView recyclerViewServicios;
    ArrayList<Servicios> listaServicios;
    ConexionSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_empresa);
        nombreEmpresa();
        guardarDatosShared();
        listaServicios = new ArrayList<>();
        recyclerViewServicios = (RecyclerView) findViewById(R.id.recyclerServicios);
        recyclerViewServicios.setLayoutManager(new LinearLayoutManager(this));

        ServiciosAdapter adapter = new ServiciosAdapter(listaServicios);
        recyclerViewServicios.setAdapter(adapter);
      consultarServicios();
    }

    public void nombreEmpresa() {

        String nombreEmpresa = "";
        String idEmpresa = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nombreEmpresa = extras.getString("nombreEmpresa");
            idEmpresa = extras.getString("idEmpresa");

        }
        etinomnbreEmpresa = (TextView) findViewById(R.id.nombreEmpresa);
        etinomnbreEmpresa.setText(nombreEmpresa);
        txtIdEmpresa = (TextView) findViewById(R.id.idEmpresaReserva);
        txtIdEmpresa.setText(idEmpresa);
    }
    public void nombreServicio() {

        String nombreServicio = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nombreServicio = extras.getString("nombreServicio");
        }
        txtNombreServicio = (TextView) findViewById(R.id.etiServicioEmpresa);
        txtNombreServicio.setText(nombreServicio);
    }

    private void cargarUsuarioShared() {

        etinomnbreEmpresa = (EditText) findViewById(R.id.etiServicioEmpresa);
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String servicio = preferences.getString("nombreEmpresa", "no existe");
        txtNombreServicio.setText(servicio);
    }

    private void consultarServicios() {
        con = new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db = con.getReadableDatabase();
        Servicios servicios = null;

        try {
            Cursor cursor = db.rawQuery("SELECT "
                    + ConexionUtilidades.CAMPO_NOMBRE_SERVICIO + ","
                    + ConexionUtilidades.CAMPO_ID_DETALLE_SERVICIO + ","
                    + ConexionUtilidades.CAMPO_PRECIO_SERVICIO + ","
                    + ConexionUtilidades.CAMPO_DESCRIPCION_SERVICIO + ","
                    + ConexionUtilidades.CAMPO_SERVICIO_IMAGEN + "" +
                    "  FROM " + ConexionUtilidades.TABLA_DETALLE_SERVICIO +
                    " JOIN SERVICIOS ON SERVICIOS.idServicio = detalleServicio.idServicio"+
                    " WHERE idLocal"+"= "+ txtIdEmpresa.getText().toString(), null);
            while (cursor.moveToNext()) {
                servicios = new Servicios();
                servicios.setNombreServicio(cursor.getString(0));
                servicios.setIdServicio(cursor.getInt(1));
                servicios.setPrecio(cursor.getInt(2));
                servicios.setDescripcionServicio(cursor.getString(3));
                servicios.setUrlImagenServicio(cursor.getString(4));

                listaServicios.add(servicios);
            }
        } catch (SQLException e) {
            Toast.makeText(this, "No se puede encontrar" + e, Toast.LENGTH_LONG).show();
        }
    }
    public void OnClick(View view) {
    }

    private void guardarDatosShared() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String etiNombreEmpresa = etinomnbreEmpresa.getText().toString();
        String idEmpresa = txtIdEmpresa.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nombreEmpresa", etiNombreEmpresa );
        editor.putString("idEmpresa", idEmpresa);

        editor.commit();
    }

}






