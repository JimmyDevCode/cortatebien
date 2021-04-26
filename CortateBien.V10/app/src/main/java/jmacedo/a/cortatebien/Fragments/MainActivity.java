package jmacedo.a.cortatebien.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;

public class MainActivity extends AppCompatActivity {

    private EditText etiUsuario;
    private EditText etiContraseña;
    private TextView txtIdUsuarioLogin;
    private Button btnIngresar;
    private Button btnRegistrar;

    ConexionSQLiteHelper con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiUsuario = (EditText) findViewById(R.id.usuarioLogin);
        etiContraseña = (EditText) findViewById(R.id.contraseñaLogin);
        txtIdUsuarioLogin = (TextView) findViewById(R.id.txtIdUsuarioLogin);
        btnIngresar = (Button) findViewById(R.id.btnLogin);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

    }

   /* public void getLogin() {

        if (mUsuario.getText().toString().trim().length() == 0 && mContraseña.getText().toString().trim().length() == 0) {

            Toast.makeText(MainActivity.this, "Los campos están vacíos", Toast.LENGTH_SHORT).show();
        } else {
            if (mUsuario.getText().toString().trim().equals(usuario)
                    && mContraseña.getText().toString().trim().equals(contraseña)) {
                Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(intent);


            } else {
                Toast.makeText(MainActivity.this, "Los campos son incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    public void getIrRegistro() {

        Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(intent);
    }

    public void OnClick(View view) {

        if (view.getId() == R.id.btnLogin) {
            guardarUsuarioShared();
            Ingresar();
        } else if (view.getId() == R.id.btnRegistrar) {
            getIrRegistro();
        }

    }

    public void Ingresar() {
        con = new ConexionSQLiteHelper(getApplicationContext());
        Boolean validar = con.validarUsuario(etiUsuario.getText().toString().trim())
                && con.validarContraseña(etiContraseña.getText().toString().trim());
        if (validar == true) {
            mostrarUsuarioId();
            Toast.makeText(MainActivity.this, "Inicio exitoso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Los campos son incorrectos", Toast.LENGTH_SHORT).show();

        }
        etiUsuario.setText("");
        etiContraseña.setText("");
    }


    /*public boolean consultarUsuarios (String usuCorreo){
        con = new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db = con.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ConexionUtilidades.TABLA_USUARIO+
                        " WHERE "+ConexionUtilidades.CAMPO_USUARIO+"=?",
                new String[]{usuCorreo});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }*/
    /*private void guardarUsuarioShared() {

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuarioPreferencia = etiUsuario.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", usuarioPreferencia);

        editor.commit();
    }*/
    private void guardarUsuarioShared() {

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuarioPreferencia = etiUsuario.getText().toString();
        String correoPreferencia = etiContraseña.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", usuarioPreferencia);
        editor.putString("password", correoPreferencia);
        editor.commit();
    }
    private void guardarIdLoginShared() {

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String idUsuario = txtIdUsuarioLogin.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("idUsuario", idUsuario);
        editor.commit();
    }
    public void mostrarUsuarioId() {

        con = new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db = con.getReadableDatabase();
        String[] columns = {ConexionUtilidades.CAMPO_ID_USUARIO};
        String selection = ConexionUtilidades.CAMPO_USUARIO + "=?";
        String[] arguments = {etiUsuario.getText().toString()};
        try {
            Cursor cursor = db.query(ConexionUtilidades.TABLA_USUARIO, columns, selection, arguments,
                    null,
                    null,
                    null,
                    null);
            cursor.moveToFirst();
            txtIdUsuarioLogin.setText(cursor.getString(0));
            guardarIdLoginShared();
            cursor.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No se puede encontrar" + e, Toast.LENGTH_LONG).show();
        }
    }
}






