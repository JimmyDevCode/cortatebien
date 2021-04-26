package jmacedo.a.cortatebien.Fragments;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import jmacedo.a.cortatebien.Adaptadores.LocalesAdapter;
import jmacedo.a.cortatebien.Entidades.Local;
import jmacedo.a.cortatebien.R;
import jmacedo.a.cortatebien.Utilidades.ConexionSQLiteHelper;
import jmacedo.a.cortatebien.Utilidades.ConexionUtilidades;


/**
 * A simple {@link Fragment} subclass.
 */
public class Peluqueria extends Fragment {

    RecyclerView recyclerViewLocales;
    ArrayList<Local> listaLocal;
    ConexionSQLiteHelper con = new ConexionSQLiteHelper(getContext());

    public Peluqueria() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_peluqueria, container, false);
        listaLocal = new ArrayList<>();
        recyclerViewLocales = (RecyclerView) vista.findViewById(R.id.recyclerIdP);
        recyclerViewLocales.setLayoutManager(new LinearLayoutManager(getContext()));

        //creamos el adaptador
        /*llenarLista();*/
        consultarLocales();

        LocalesAdapter adapter = new LocalesAdapter(listaLocal);
        recyclerViewLocales.setAdapter(adapter);
        return vista;
    }

    private void consultarLocales() {
        con = new ConexionSQLiteHelper(getContext());
        SQLiteDatabase db = con.getReadableDatabase();
        Local local = null;
        Cursor cursor = db.rawQuery("SELECT "
                + ConexionUtilidades.CAMPO_NOMBRE + ","
                +ConexionUtilidades.CAMPO_ID+","
                +ConexionUtilidades.CAMPO_HORARIO+","
                +ConexionUtilidades.CAMPO_DIAS+","
                +ConexionUtilidades.CAMPO_DIRECCION+","
                +ConexionUtilidades.CAMPO_CONTACTO+","
                + ConexionUtilidades.CAMPO_URL_IMAGEN + ","
                +ConexionUtilidades.CAMPO_DISTRITO+"" +
                "  FROM " + ConexionUtilidades.TABLA_LOCAL + " WHERE "
                + ConexionUtilidades.CAMPO_CATEGORIA + "='Peluqueria'", null);
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


}



