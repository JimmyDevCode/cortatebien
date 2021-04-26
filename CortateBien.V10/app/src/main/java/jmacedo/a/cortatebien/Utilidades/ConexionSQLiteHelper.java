package jmacedo.a.cortatebien.Utilidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jmacedo.a.cortatebien.Entidades.Usuarios;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(Context context) {
        super(context, ConexionUtilidades.DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //genera las tablas

        db.execSQL(ConexionUtilidades.CREAR_TABLA_LOCAL);
        db.execSQL(ConexionUtilidades.CREAR_TABLA_SERVICIO);
        db.execSQL(ConexionUtilidades.CREAR_TABLA_USUARIO);
        db.execSQL(ConexionUtilidades.CREAR_TABLA_DETALLE_SERVICIO);
        db.execSQL(ConexionUtilidades.CREAR_TABLA_RESERVA);

        /* *****************POBLANDO SERVICIOS********************************************* */
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Skin Fade', 23, 'Cero a los costados y nivel tres arriba', 'https://cortesdecabellohombre.com/wp-content/uploads/2018/02/High-skin-fade.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Jelly roll', 20, 'Corte con un degradado alto a los lados', 'https://i.pinimg.com/236x/42/bc/3c/42bc3c5f35b5e86568544793a24fce94--jelly-roll-man-bun.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Slicked', 30, 'Degradado bajo con el copete hacia atrás', 'https://i.pinimg.com/originals/0b/1d/47/0b1d47e13f910614ec6dfda5305332f3.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Blurry Fade', 25, 'Degradado alto con raya hacia el costado', 'https://i.pinimg.com/originals/53/1e/0b/531e0b9d6b0a4fe07b0c22ef49eaa3fe.jpg')");

        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Skin Fade', 15, 'Cero a los costados y nivel tres arriba', 'https://i.pinimg.com/originals/48/fb/12/48fb12fc7767936369e663a796bfe7da.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Jelly roll', 10, 'Corte con un degradado alto a los lados', 'http://www.madridoldschool.es/wp-content/uploads/2015/10/Boston-nape.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Slicked', 20, 'Degradado bajo con el copete hacia atrás', 'https://i.pinimg.com/originals/3f/0f/5c/3f0f5cd1db011bb11837f7a127b4e5e7.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Blurry Fade', 15, 'Degradado alto con raya hacia el costado', 'https://cortesdecabellohombre.com/wp-content/uploads/2017/09/Peinado-Lateral-con-Degradado-300x300.jpg')");

        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Skin Fade', 35, 'Cero a los costados y nivel tres arriba', 'https://www.notyourfathersbarber.com/wp-content/uploads/2019/08/o.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Jelly roll', 30, 'Corte con un degradado alto a los lados', 'https://i.pinimg.com/236x/42/bc/3c/42bc3c5f35b5e86568544793a24fce94--jelly-roll-man-bun.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Slicked', 40, 'Degradado bajo con el copete hacia atrás', 'https://i.pinimg.com/originals/de/3e/ee/de3eeee5b82140054a3e40d8a35933e9.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Blurry Fade', 40, 'Degradado alto con raya hacia el costado', 'https://i.pinimg.com/originals/61/76/54/61765443a1643b71490b7e5bae2befe6.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Burst Taper', 30, 'Degradado medio. Arriba al nivel dos con la frente marcada', 'https://i.pinimg.com/originals/af/69/2c/af692cb883c75e8781d946d5886c32c6.jpg')");

        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Laceado Brasilero', 80, 'Se hace un laceado con los mejores insumos', 'https://img.clasf.pe/2019/07/15/Mes-Del-Laceado-con-El-80-Descuento-20190715021149.6766450015.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Decoloración', 30, 'Color que el cliente elija', 'https://http2.mlstatic.com/exclusivo-kit-o-plex-individualde-30ml-decoloracion-sin-dano-D_NQ_NP_953305-MLC20857671987_082016-F.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Mechas y rayos platinados', 55, 'Iluminación del cabello a base de color', 'http://www.mujeresfemeninas.com/imagenes/belleza/mechas-platinadas-paso-a-paso.jpg')");

        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Laceado Japonés', 120, 'Se hace un laceado con los mejores insumos', 'https://botoxcapilar.org/wp-content/uploads/2019/08/alisado-japones-en-pelo-corto.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Decoloración', 50, 'Color que el cliente elija', 'https://curiositemujer.com/wp-content/uploads/2019/10/rosegold-cabello-decoloraci%C3%B3n-1000x667.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Mechas y rayos', 60, 'Iluminación del cabello a base de color', 'https://i.pinimg.com/236x/06/11/14/061114afb80858b329f15823de1baa66.jpg')");
        db.execSQL("INSERT INTO Servicios (nombreServicio, precioServicio, descripcionServicio, urlImagenServicio) " +
                "VALUES ('Trenza francesa', 30, 'Es un estilo de trenza que te hará ver más joven', 'https://assets.afcdn.com/breves/acc2_video_625361/acc1257x1257a959218.jpg')");

        /* *****************POBLANDO DETALLE SERVICIO********************************************* */
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (1, 9)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (1, 10)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (1, 11)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (1, 12)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (1, 13)");

        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (2, 1)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (2, 2)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (2, 3)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (2, 4)");

        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (5, 5)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (5, 6)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (5, 7)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (5, 8)");

        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (4, 14)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (4, 15)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (4, 16)");

        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (3, 17)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (3, 18)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (3, 19)");
        db.execSQL("INSERT INTO detalleServicio (idLocal, idServicio)" +
                "VALUES (3, 20)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {

        //verifica ya si existe una versión antigua de la base de datos
        db.execSQL("DROP TABLE IF EXISTS " + ConexionUtilidades.TABLA_LOCAL);
        db.execSQL("DROP TABLE IF EXISTS " + ConexionUtilidades.TABLA_SERVICIO);
        db.execSQL("DROP TABLE IF EXISTS " + ConexionUtilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + ConexionUtilidades.TABLA_DETALLE_SERVICIO);
        db.execSQL("DROP TABLE IF EXISTS " + ConexionUtilidades.TABLA_RESERVA );
        onCreate(db);
    }

    /* public Cursor consultarUsuarios(String usu, String password) throws SQLException{
         Cursor mcursor = null;
         SQLiteDatabase db = getReadableDatabase();
         mcursor=db.query("USUARIOS", new String []{"idUsuario", "nombreUsuario", "password", "correo"},
                 "nombreUsuario like '"+usu+"' " + "and password like '"+password+"'",
                 null,null, null, null);
         return mcursor;
     }*/
    public boolean validarUsuario(String usuCorreo){
        String [] columns = {ConexionUtilidades.CAMPO_ID_USUARIO};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = ConexionUtilidades.CAMPO_USUARIO + "=?";

        String [] arguments = {usuCorreo};

        Cursor cursor = db.query(ConexionUtilidades.TABLA_USUARIO,
                columns,
                selection,
                arguments,
                null,
                null,
                null,
                null);
        int cursorCount =  cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0 ){
            return true;
        }
        return false;
    }
    public boolean validarContraseña(String password){
        String [] columns = {ConexionUtilidades.CAMPO_ID_USUARIO};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = ConexionUtilidades.CAMPO_CONTRASEÑA + "=?";

        String [] arguments = {password};

        Cursor cursor = db.query(ConexionUtilidades.TABLA_USUARIO,
                columns,
                selection,
                arguments,
                null,
                null,
                null,
                null);
        int cursorCount =  cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0 ){
            return true;
        }
        return false;
    }
    public boolean validarCorreo(String correo){
        String [] columns = {ConexionUtilidades.CAMPO_CORREO};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = ConexionUtilidades.CAMPO_CORREO + "=?";

        String [] arguments = {correo};

        Cursor cursor = db.query(ConexionUtilidades.TABLA_USUARIO,
                columns,
                selection,
                arguments,
                null,
                null,
                null,
                null);
        int cursorCount =  cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0 ){
            return true;
        }
        return false;
    }
    public boolean validarReservaDisponible(String horaReserva){
        String [] columns = {ConexionUtilidades.CAMPO_HORARESERVA};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = ConexionUtilidades.CAMPO_HORARESERVA + "=?";

        String [] arguments = {horaReserva};

        Cursor cursor = db.query(ConexionUtilidades.TABLA_RESERVA,
                columns,
                selection,
                arguments,
                null,
                null,
                null,
                null);
        int cursorCount =  cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0 ){
            return true;
        }
        return false;
    }

}



