package jmacedo.a.cortatebien.Utilidades;

public class ConexionUtilidades {

    public static final String DATABASE = "bd_proyecto";
    //Constantes campos Locales
    public static final String TABLA_LOCAL = "locales";
    public static final String CAMPO_ID = "idLocal";
    public static final String CAMPO_NOMBRE = "nombreLocal";
    public static final String CAMPO_DIRECCION = "direccion";
    public static final String CAMPO_CONTACTO = "contacto";
    public static final String CAMPO_HORARIO = "horario";
    public static final String CAMPO_DIAS = "fechaAtencion";
    public static final String CAMPO_CATEGORIA = "categoria";
    public static final String CAMPO_DISTRITO = "distrito";
    public static final String CAMPO_URL_IMAGEN = "urlImagen";
    //---------------------------------------------------------
    public static final String CREAR_TABLA_LOCAL = "CREATE TABLE " + TABLA_LOCAL + " ("
            + CAMPO_ID + " INTEGER PRIMARY KEY NOT NULL, "
            + CAMPO_NOMBRE + " TEXT NOT NULL, "
            + CAMPO_DIRECCION + " TEXT NOT NULL, "
            + CAMPO_HORARIO + " TEXT NOT NULL, "
            + CAMPO_DIAS + " TEXT NOT NULL, "
            + CAMPO_CONTACTO + " TEXT NOT NULL, "
            + CAMPO_CATEGORIA + " TEXT NOT NULL, "
            + CAMPO_URL_IMAGEN + " TEX NOT NULL, "
            + CAMPO_DISTRITO + " TEXT NOT NULL)";
    //---------------------------------------------------------------------------------------
    //Constantes campos Servicios
    public static final String TABLA_SERVICIO = "Servicios";
    public static final String CAMPO_ID_SERVICIO = "idServicio";
    public static final String CAMPO_NOMBRE_SERVICIO = "nombreServicio";
    public static final String CAMPO_PRECIO_SERVICIO = "precioServicio";
    public static final String CAMPO_DESCRIPCION_SERVICIO = "descripcionServicio";
    public static final String CAMPO_SERVICIO_IMAGEN = "urlImagenServicio";
    //---------------------------------------------------------------------------------------
    public static final String CREAR_TABLA_SERVICIO = "CREATE TABLE " + TABLA_SERVICIO + " ("
            + CAMPO_ID_SERVICIO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CAMPO_NOMBRE_SERVICIO + " TEXT NOT NULL, "
            + CAMPO_PRECIO_SERVICIO + " INTEGER NOT NULL, "
            + CAMPO_DESCRIPCION_SERVICIO + " TEX NOT NULL, "
            + CAMPO_SERVICIO_IMAGEN + " TEX NOT NULL)";

    //-------------------------------------------------------------------------------------------
    //Constantes campos Usuarios
    public static final String TABLA_USUARIO = "Usuarios";
    public static final String CAMPO_ID_USUARIO = "idUsuario";
    public static final String CAMPO_USUARIO = "nombreUsuario";
    public static final String CAMPO_CONTRASEÑA = "contraseña";
    public static final String CAMPO_CORREO = "correo";
    //---------------------------------------------------------
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + " ("
            + CAMPO_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CAMPO_USUARIO + " TEXT NOT NULL, "
            + CAMPO_CONTRASEÑA + " TEXT NOT NULL, "
            + CAMPO_CORREO + " TEXT NOT NULL)";
    //---------------------------------------------------------------------------------------
    //Constantes campos Detalle Servicio
    public static final String TABLA_DETALLE_SERVICIO = "detalleServicio";
    public static final String CAMPO_ID_DETALLE_SERVICIO = "idDetalleServicio";
    public static final String CAMPO_FK_LOCAL = "idLocal";
    public static final String CAMPO_FK_SERVICIO = "idServicio";
    //---------------------------------------------------------------------------------------
    public static final String CREAR_TABLA_DETALLE_SERVICIO = "CREATE TABLE " + TABLA_DETALLE_SERVICIO + " ("
            + CAMPO_ID_DETALLE_SERVICIO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CAMPO_FK_LOCAL + " INTEGER NOT NULL, "
            + CAMPO_FK_SERVICIO + " INTEGER NOT NULL)";
    //-------------------------------------------------------------------------------------------
    //Constantes campos RESERVA
    public static final String TABLA_RESERVA                = "Reserva";
    public static final String CAMPO_ID_RESERVA             = "idReserva";
    public static final String CAMPO_FK_USUARIO             = "idUsuario";
    public static final String CAMPO_FK_DETALLE_SERVICIO    = "idDetalleServicio";
    public static final String CAMPO_FECHARESERVA           = "fechaReserva";
    public static final String CAMPO_HORARESERVA            = "horaReserva";
    //-----------------------------------------------------------------------------------------
    public static final String CREAR_TABLA_RESERVA = "CREATE TABLE " + TABLA_RESERVA + " ("
            + CAMPO_ID_RESERVA+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CAMPO_FK_USUARIO+" INTEGER NOT NULL, "
            + CAMPO_FK_DETALLE_SERVICIO+" INTEGER NOT NULL, "
            + CAMPO_FECHARESERVA+" TEXT NOT NULL, "
            + CAMPO_HORARESERVA+" TEXT NOT NULL)";

}

