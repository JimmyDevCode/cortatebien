package jmacedo.a.cortatebien.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;

public class RegistroActivity extends AppCompatActivity {

    private Button btnCancelar;
    private Button btnRegistrar;
    private EditText etiRegistroUsuario;
    private EditText etiRegistroContraseña;
    private EditText etiRegistroCorreo;
    ConexionSQLiteHelper con;

    private static final String TAG = "ConexionSQLITE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        etiRegistroUsuario = (EditText) findViewById(R.id.registroUsuario);
        etiRegistroContraseña = (EditText) findViewById(R.id.registroContraseña);
        etiRegistroCorreo = (EditText) findViewById(R.id.registroCorreo);

    }

    public void getCancelar() {

        Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void OnClick(View view) {

        if (view.getId() == R.id.btnCancelar) {
            getCancelar();
        } else if (view.getId() == R.id.btnRegistrar) {
            registroValidacion();
        }
    }

  /*  public void registrarse() {
        con = new ConexionSQLiteHelper(getApplicationContext());
        Boolean insert = registrarUsuarios(String.valueOf(etiRegistroUsuario).trim(),
                String.valueOf(etiRegistroContraseña), String.valueOf(etiRegistroCorreo).trim());

        if (insert == true) {
            Toast.makeText(this, "se agregó", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "No se puede agregar", Toast.LENGTH_SHORT).show();
        }

    }*/

    /* public boolean registrarUsuarios(String nombreUsuario, String password, String correo) {
         con = new ConexionSQLiteHelper(getApplicationContext());
         SQLiteDatabase db = con.getWritableDatabase();
         ContentValues valores = new ContentValues();
         valores.put(ConexionUtilidades.CAMPO_USUARIO, nombreUsuario);
         valores.put(ConexionUtilidades.CAMPO_CONTRASEÑA, password);
         valores.put(ConexionUtilidades.CAMPO_CORREO, correo);
         long insert = db.insert(ConexionUtilidades.TABLA_USUARIO, null, valores);
         if (insert == -1) {
             return false;
         } else {
             return true;
         }
     }*/
    public void registrarUsuarios() {
        con = new ConexionSQLiteHelper(getApplicationContext());
        Boolean validarCorreo = con.validarCorreo(etiRegistroCorreo.getText().toString().trim());
        Boolean validarUsuario = con.validarUsuario(etiRegistroUsuario.getText().toString().trim());
        SQLiteDatabase db = con.getWritableDatabase();
        if (db != null) {
            ContentValues cv = new ContentValues();
            cv.put(ConexionUtilidades.CAMPO_USUARIO, etiRegistroUsuario.getText().toString().trim());
            cv.put(ConexionUtilidades.CAMPO_CONTRASEÑA, etiRegistroContraseña.getText().toString().trim());
            cv.put(ConexionUtilidades.CAMPO_CORREO, etiRegistroCorreo.getText().toString().trim());
            if (validarCorreo == false && validarUsuario == false) {
                long inser = db.insert(ConexionUtilidades.TABLA_USUARIO, null, cv);
                if (inser == -1) {
                    Toast.makeText(this, "No se agregó", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Se agregó", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                    db.close();
                }
                etiRegistroUsuario.setText("");
                etiRegistroContraseña.setText("");
                etiRegistroCorreo.setText("");
            }
        }
    }

    private void registroValidacion() {

        con = new ConexionSQLiteHelper(getApplicationContext());
        Boolean validarCorreo = con.validarCorreo(etiRegistroCorreo.getText().toString().trim());
        Boolean validarUsuario = con.validarUsuario(etiRegistroUsuario.getText().toString().trim());

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        etiRegistroCorreo.getText().toString().equals("hola@hotmail.com");
        Matcher matcher = pattern.matcher(etiRegistroCorreo.getText().toString());

        if (etiRegistroUsuario.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Debe ingresar un usuario", Toast.LENGTH_SHORT).show();
        } else if (etiRegistroUsuario.getText().toString().trim().length() < 5) {
            Toast.makeText(this, "El usuario debe tener más de cinco carácteres", Toast.LENGTH_SHORT).show();
        } else if (validarUsuario == true) {
                Toast.makeText(this, "¡El usuario ya existe!", Toast.LENGTH_SHORT).show();
        } else if (etiRegistroContraseña.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
        } else if (etiRegistroContraseña.getText().toString().trim().equals(etiRegistroUsuario.getText().toString().trim())) {
            Toast.makeText(this, "La contraseña no puede ser tu nombre de usuario", Toast.LENGTH_LONG).show();
        } else if (etiRegistroContraseña.getText().toString().trim().length() < 5){
            Toast.makeText(this, "La contraseña debe tener más de cinco carácteres", Toast.LENGTH_SHORT).show();
        } else if (etiRegistroCorreo.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Debe ingresar un correo", Toast.LENGTH_SHORT).show();
        }else if (validarCorreo == true) {
            Toast.makeText(this, "¡El correo ya existe!", Toast.LENGTH_SHORT).show();
        }else if (matcher.find() == false) {
            Toast.makeText(this, "¡Ingrese un correo válido!", Toast.LENGTH_SHORT).show();
        }else  {
            registrarUsuarios();
        }
    }
}




