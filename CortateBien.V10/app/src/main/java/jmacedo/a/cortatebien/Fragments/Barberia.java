package jmacedo.a.cortatebien.Fragments;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import jmacedo.a.cortatebien.Adaptadores.LocalesAdapter;
import jmacedo.a.cortatebien.Entidades.Local;
import jmacedo.a.cortatebien.Entidades.Usuarios;
import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;


/**
 * A simple {@link Fragment} subclass.
 */
public class Barberia extends Fragment {

    private TextView etiUsuarioParametro;
    private TextView etiUsuarioLogin;

    RecyclerView recyclerViewLocales;
    ArrayList<Local> listaLocal;
    ConexionSQLiteHelper con;

    public Barberia() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_barberia, container, false);
        listaLocal = new ArrayList<>();
        recyclerViewLocales = (RecyclerView) vista.findViewById(R.id.recyclerIdB);
        recyclerViewLocales.setLayoutManager(new LinearLayoutManager(getContext()));
        etiUsuarioLogin = (TextView) vista.findViewById(R.id.usuarioLogin);
        registrarLocales();
        consultarLocales();
        //registrarServicios();
        //creamos el adaptador
        LocalesAdapter adapter = new LocalesAdapter(listaLocal);
        recyclerViewLocales.setAdapter(adapter);
        return vista;
    }

    private void consultarLocales() {
        SQLiteDatabase db = con.getReadableDatabase();
        Local local = null;
        Cursor cursor = db.rawQuery("SELECT "
                + ConexionUtilidades.CAMPO_NOMBRE + ","
                + ConexionUtilidades.CAMPO_ID + ","
                + ConexionUtilidades.CAMPO_HORARIO + ","
                + ConexionUtilidades.CAMPO_DIAS + ","
                + ConexionUtilidades.CAMPO_DIRECCION + ","
                + ConexionUtilidades.CAMPO_CONTACTO + ","
                + ConexionUtilidades.CAMPO_URL_IMAGEN + ","
                + ConexionUtilidades.CAMPO_DISTRITO + "" +
                "  FROM " + ConexionUtilidades.TABLA_LOCAL + " WHERE "
                + ConexionUtilidades.CAMPO_CATEGORIA + "='Barberia'", null);
        while (cursor.moveToNext()) {

            local = new Local();
            local.setNombre(cursor.getString(0));
            local.setIdLocal(cursor.getInt(1));
            local.setHorario(cursor.getString(2));
            local.setDias(cursor.getString(3));
            local.setDireccion(cursor.getString(4));
            local.setContacto(cursor.getString(5));
            local.setUrlImagen(cursor.getString(6));
            local.setDistrito(cursor.getString(7));

            listaLocal.add(local);
        }
    }

    public void registrarLocales() {

        con = new ConexionSQLiteHelper(getContext());
        SQLiteDatabase db = con.getWritableDatabase();
        if (db != null) {
            ContentValues cv = new ContentValues();
            cv.put(ConexionUtilidades.CAMPO_ID, 1);
            cv.put(ConexionUtilidades.CAMPO_NOMBRE, "Montalvo for MEN");
            cv.put(ConexionUtilidades.CAMPO_DIRECCION, "Av. Izaguirre #2389");
            cv.put(ConexionUtilidades.CAMPO_HORARIO, "08:00 AM - 10:00 PM");
            cv.put(ConexionUtilidades.CAMPO_DIAS, "Lunes a Domingo");
            cv.put(ConexionUtilidades.CAMPO_CONTACTO, "(01) 689234");
            cv.put(ConexionUtilidades.CAMPO_DISTRITO, "Los Olivos");
            cv.put(ConexionUtilidades.CAMPO_CATEGORIA, "Barberia");
            cv.put(ConexionUtilidades.CAMPO_URL_IMAGEN, "https://www.mallplaza.com.pe/media/stores/montalvo-for-men/gallery/store_mall_5b35460c049ad.jpg");
            db.insert(ConexionUtilidades.TABLA_LOCAL, null, cv);

            //---------
            cv.put(ConexionUtilidades.CAMPO_ID, 2);
            cv.put(ConexionUtilidades.CAMPO_NOMBRE, "Stilo Fino");
            cv.put(ConexionUtilidades.CAMPO_DIRECCION, "Av. Perú #1398");
            cv.put(ConexionUtilidades.CAMPO_HORARIO, "08:00 AM - 10:00 PM");
            cv.put(ConexionUtilidades.CAMPO_DIAS, "Lunes a Domingo");
            cv.put(ConexionUtilidades.CAMPO_CONTACTO, "96789032");
            cv.put(ConexionUtilidades.CAMPO_DISTRITO, "San Martin de Porres");
            cv.put(ConexionUtilidades.CAMPO_CATEGORIA, "Barberia");
            cv.put(ConexionUtilidades.CAMPO_URL_IMAGEN, "https://quedilema401.files.wordpress.com/2016/06/img_8702.jpg");
            db.insert(ConexionUtilidades.TABLA_LOCAL, null, cv);

            //---------
            cv.put(ConexionUtilidades.CAMPO_ID, 3);
            cv.put(ConexionUtilidades.CAMPO_NOMBRE, "Bell Salon y SPA");
            cv.put(ConexionUtilidades.CAMPO_DIRECCION, "Av. Tupas #2789");
            cv.put(ConexionUtilidades.CAMPO_HORARIO, "08:00 AM - 10:00 PM");
            cv.put(ConexionUtilidades.CAMPO_DIAS, "Lunes a Domingo");
            cv.put(ConexionUtilidades.CAMPO_CONTACTO, "(01) 4567832");
            cv.put(ConexionUtilidades.CAMPO_DISTRITO, "Los Olivos");
            cv.put(ConexionUtilidades.CAMPO_CATEGORIA, "Peluqueria");
            cv.put(ConexionUtilidades.CAMPO_URL_IMAGEN, "https://d20ga1agp72kf9.cloudfront.net/mx/venues/3b6bfa6e818eb5078b633569f083d4d0.JPG");
            db.insert(ConexionUtilidades.TABLA_LOCAL, null, cv);

            //---------
            cv.put(ConexionUtilidades.CAMPO_ID, 4);
            cv.put(ConexionUtilidades.CAMPO_NOMBRE, "Belleza y Glamour");
            cv.put(ConexionUtilidades.CAMPO_DIRECCION, "Av. Industrial #2309");
            cv.put(ConexionUtilidades.CAMPO_HORARIO, "08:00 AM - 11:00 PM");
            cv.put(ConexionUtilidades.CAMPO_DIAS, "Lunes a Domingo");
            cv.put(ConexionUtilidades.CAMPO_CONTACTO, "(01) 689234");
            cv.put(ConexionUtilidades.CAMPO_DISTRITO, "San Juan de Lurigancho");
            cv.put(ConexionUtilidades.CAMPO_CATEGORIA, "Peluqueria");
            cv.put(ConexionUtilidades.CAMPO_URL_IMAGEN, "https://d20ga1agp72kf9.cloudfront.net/mx/venues/36bda1b5b333f500ba66dc23dbe8f09b.jpg");
            db.insert(ConexionUtilidades.TABLA_LOCAL, null, cv);
            //---------
            cv.put(ConexionUtilidades.CAMPO_ID, 5);
            cv.put(ConexionUtilidades.CAMPO_NOMBRE, "Barberos Unidos");
            cv.put(ConexionUtilidades.CAMPO_DIRECCION, "Av. Universitaria #1502");
            cv.put(ConexionUtilidades.CAMPO_HORARIO, "10:00 AM - 10:00 PM");
            cv.put(ConexionUtilidades.CAMPO_DIAS, "Lunes a Domingo");
            cv.put(ConexionUtilidades.CAMPO_CONTACTO, "(01) 785422");
            cv.put(ConexionUtilidades.CAMPO_DISTRITO, "San Martin de Porres");
            cv.put(ConexionUtilidades.CAMPO_CATEGORIA, "Barberia");
            cv.put(ConexionUtilidades.CAMPO_URL_IMAGEN, "https://cdn.cuponidad.pe/images/Deals/labarberiasanmiguel.jpg");
            db.insert(ConexionUtilidades.TABLA_LOCAL, null, cv);

        }
    }
}
