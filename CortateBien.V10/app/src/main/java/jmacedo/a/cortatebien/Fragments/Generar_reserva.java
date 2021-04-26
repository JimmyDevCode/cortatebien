package jmacedo.a.cortatebien.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;

public class Generar_reserva extends AppCompatActivity {

    TextView etinomnbreEmpresa;
    TextView txtNombreUsuarioGR;
    TextView txtIdUsuarioGR;
    TextView txtIdEmpresa;
    TextView txtNombreServicio;
    TextView etiDescripcion;
    TextView txtPrecioServicio;
    TextView txtIdServicioEmpresaGR;
    EditText txtFecha;
    EditText txtHora;
    Button btnFecha;
    Button btnHora;
    Button btnReservarGR;
    ConexionSQLiteHelper con;
    SQLiteQueryBuilder builder;
    Context context = this;

    private int dia, mes, año, hora, minutos;
    private static final int TIPO_DIALOGO=0;
    private static final int TIPO_DIAL_HOUR=1;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    private static TimePickerDialog.OnTimeSetListener oyenteSelectorHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_reserva);
        txtIdUsuarioGR = (TextView) findViewById(R.id.idUsuarioGR);

        metodoFechaHora();
        cargarServicioShared();
        cargarEmpresaShared();
    }

    private void metodoFechaHora(){
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtHora = (EditText) findViewById(R.id.txtHora);
        btnFecha = (Button) findViewById(R.id.btnFecha);
        btnHora = (Button) findViewById(R.id.btnHora);
        Calendar calendar = Calendar.getInstance();
        año = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        /*-------------------------------------------------------------------------------*/
        oyenteSelectorFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año = year;
                mes = month + 1;
                dia = dayOfMonth;
                mostrarFecha();
            }
        };
        /*-------------------------------------------------------------------------------*/
        hora = calendar.get(Calendar.HOUR_OF_DAY);
        minutos = calendar.get(Calendar.MINUTE);

        oyenteSelectorHora = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hora = hourOfDay;
                minutos = minute;
                mostrarHora();
            }
        };
    }
    public void mostrarFecha(){
        txtFecha.setText(dia+"/"+mes+"/"+año);
    }
    public void mostrarHora(){
        txtHora.setText(hora+":"+minutos);
    }
    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id){
            case 0:
                return new DatePickerDialog(this,oyenteSelectorFecha, año, mes, dia);
            case 1:
                return  new TimePickerDialog(this, oyenteSelectorHora, hora, minutos,false);
        }
        return null;
    }
    public void mostrarCalendario(View v){
        showDialog(TIPO_DIALOGO);
    }

    public void mostrarHora(View v){
        showDialog(TIPO_DIAL_HOUR);
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

    private void cargarServicioShared() {

        txtNombreServicio = (EditText) findViewById(R.id.etiServicioEmpresa);
        etiDescripcion = (TextView) findViewById(R.id.etiDescripcionGR);
        txtPrecioServicio = (TextView) findViewById(R.id.txtPrecioGR);
        txtIdServicioEmpresaGR = (TextView) findViewById(R.id.idServicioGR);
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String servicio = preferences.getString("nombreServicio", "Elija un servicio");
        String descripcion = preferences.getString("descripcionServicio", "null");
        String precio = preferences.getString("precioServicio", "null");
        String idServicioEmpresaGR = preferences.getString("idServicioEmpresaGR", "null");
        txtNombreServicio.setText(servicio);
        etiDescripcion.setText(descripcion);
        txtPrecioServicio.setText(precio);
        txtIdServicioEmpresaGR.setText(idServicioEmpresaGR);

    }
    private void cargarEmpresaShared(){
        etinomnbreEmpresa = (TextView) findViewById(R.id.nombreEmpresaGR);
        txtIdEmpresa = (TextView) findViewById(R.id.idEmpresaReserva);
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String empresa = preferences.getString("nombreEmpresa", "null");
        String idEmpresa = preferences.getString("idEmpresa", "null");
        String idUsuario = preferences.getString("idUsuario", "null");
        etinomnbreEmpresa.setText(empresa);
        txtIdEmpresa.setText(idEmpresa);
        txtIdUsuarioGR.setText(idUsuario);

    }

    private void elegirOpcionDialogo(){

        btnReservarGR = (Button) findViewById(R.id.btnReservarGR);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage("¿Estás seguro que deseas reservar este servicio?")
                .setCancelable(false)
                .setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        putReserva();

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }

    public void OnClick(View view) {

        if (view.getId() == R.id.btnReservarGR) {
            //mostrarUsuarioId();
            validaciónRegistro();


        }
    }
    /*public void mostrarUsuarioId() {

        con = new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db = con.getReadableDatabase();
        String[] columns = {ConexionUtilidades.CAMPO_ID_USUARIO};
        String selection = ConexionUtilidades.CAMPO_USUARIO + "=?";
        String[] arguments = {txtNombreUsuarioGR.getText().toString()};
        try {
            Cursor cursor = db.query(ConexionUtilidades.TABLA_USUARIO, columns, selection, arguments,
                    null,
                    null,
                    null,
                    null);
            cursor.moveToFirst();
            txtIdUsuarioGR.setText(cursor.getString(0));
            guardarIdUsuario();
            cursor.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No se puede encontrar" + e, Toast.LENGTH_LONG).show();
        }
    }*/
    private void validaciónRegistro(){

        con = new ConexionSQLiteHelper(getApplicationContext());
        Boolean validarReservaDisponible = con.validarReservaDisponible(txtHora.getText().toString().trim());
        if (txtFecha.getText().toString().trim().length() == 0 && txtHora.getText().toString().trim().length() == 0) {

            Toast.makeText(this, "Es importante que elija una fecha y una hora", Toast.LENGTH_SHORT).show();
        } else if(txtFecha.getText().toString().trim().length() == 0 ) {
            Toast.makeText(this, "Le falta elegir una fecha ", Toast.LENGTH_SHORT).show();
        }else if(txtHora.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Le falta elegir una hora ", Toast.LENGTH_SHORT).show();
        }else if(validarReservaDisponible == true){
                Toast.makeText(this, "Horario no disponible. Elija otro por favor", Toast.LENGTH_SHORT).show();
        }else {
            elegirOpcionDialogo();
        }
    }
    public void putReserva() {
        con = new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db = con.getWritableDatabase();
        if (db != null) {
            ContentValues cv = new ContentValues();
            cv.put(ConexionUtilidades.CAMPO_FK_USUARIO, txtIdUsuarioGR.getText().toString().trim());
            cv.put(ConexionUtilidades.CAMPO_FK_DETALLE_SERVICIO, txtIdServicioEmpresaGR.getText().toString().trim());
            cv.put(ConexionUtilidades.CAMPO_FECHARESERVA, txtFecha.getText().toString().trim());
            cv.put(ConexionUtilidades.CAMPO_HORARESERVA, txtHora.getText().toString().trim());
            long inser = db.insert(ConexionUtilidades.TABLA_RESERVA, null, cv);
            if (inser == -1) {
                Toast.makeText(this, "No se pudo reservar", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Reserva exitosa", Toast.LENGTH_SHORT).show();
                db.close();
                Intent intent = new Intent(this, Mis_reservas.class);
                startActivity(intent);
            }
        }
    }
        public void guardarIdUsuario() {
            SharedPreferences preferences = context.getSharedPreferences("credencialesIdUsuario", Context.MODE_PRIVATE);
            String idUsuario = txtIdUsuarioGR.getText().toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("idUsuarioReserva", idUsuario);
            editor.commit();
    }
}


