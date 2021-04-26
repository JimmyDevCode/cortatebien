package jmacedo.a.cortatebien.Fragments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jmacedo.a.cortatebien.Entidades.Usuarios;
import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;

public class Mi_perfil extends AppCompatActivity {

    TextView nombreUsuarioPerfil;
    TextView correoUsuarioPerfil;
    TextView txtIdUsuario;
    Button btnVolver;
    ConexionSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi__perfil);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        nombreUsuarioPerfil = (TextView) findViewById(R.id.nombreUsuarioPerfil);
        correoUsuarioPerfil = (TextView) findViewById(R.id.correoUsuarioPerfil);
        // cargarUsuarioShared();
        cargarIdUsuario();
        mostrarDatosUsuario();
    }

    /*private void cargarUsuarioShared() {

        nombreUsuarioPerfil = (TextView) findViewById(R.id.nombreUsuarioPerfil);
        correoUsuarioPerfil = (TextView) findViewById(R.id.correoUsuarioPerfil);
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String user = preferences.getString("user", "no existe");
        String correo = preferences.getString("password", "no existe");

        nombreUsuarioPerfil.setText(user);
        correoUsuarioPerfil.setText(correo);

    }*/

    public void mostrarDatosUsuario() {

        con = new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db = con.getReadableDatabase();
        String [] columns = {ConexionUtilidades.CAMPO_USUARIO, ConexionUtilidades.CAMPO_CORREO};
        String selection = ConexionUtilidades.CAMPO_ID_USUARIO + "=?";
        String [] arguments = {txtIdUsuario.getText().toString()};
        try{
            Cursor cursor = db.query(ConexionUtilidades.TABLA_USUARIO, columns, selection, arguments,
                    null,
                    null,
                    null,
                    null);
            cursor.moveToFirst();
            nombreUsuarioPerfil.setText(cursor.getString( 0));
            correoUsuarioPerfil.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "No se puede encontrar"+e, Toast.LENGTH_LONG).show();
        }

    }

    public void OnClick(View view) {

        if (view.getId() == R.id.btnVolver) {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        }
    }
    private void cargarIdUsuario() {

        txtIdUsuario =(TextView) findViewById(R.id.idUsuario);
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String idUsuario = preferences.getString("idUsuario", "no existe");
        txtIdUsuario.setText(idUsuario);

    }
    private void retrocesoIcono(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
