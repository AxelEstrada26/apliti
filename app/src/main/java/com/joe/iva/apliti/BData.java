package com.joe.iva.apliti;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BData extends SQLiteOpenHelper {


    private static final String TABLA_PRODUCTOS="CREATE TABLE PRODUCTOS(CODIGO TEXT PRIMARY KEY,NOMBRE TEXT,DESCRIPCION TEXT,PRECIO TEXT,PROVEEDOR TEXT,STOCK TEXT,MINIMO TEXT)";
public BData(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
    super(context, name, factory, version);
}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_PRODUCTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_PRODUCTOS);
        db.execSQL(TABLA_PRODUCTOS);
    }
    public void AgregarProductos(String codigo,String nombre,String descripcion,String precio,String proveedor,String stock,String minimo){
    SQLiteDatabase bd=getWritableDatabase();
    if(bd!=null){
        bd.execSQL("INSERT INTO PRODUCTOS VALUES('"+codigo+"','"+nombre+"','"+descripcion+"','"+precio+"','"+proveedor+"','"+stock+"','"+minimo+"')");
        bd.close();
    }
    }
    public void Mostrar(String codigo,String nombre,String descripcion,String precio,String proveedor,String stock,String minimo){
        SQLiteDatabase bd=getWritableDatabase();

            bd.execSQL("SELECT * FROM PRODUCTOS");
            bd.close();
    }

    public void MostrarCo(String codigo){
        SQLiteDatabase bd=getWritableDatabase();

        bd.execSQL("SELECT * FROM PRODUCTOS WHERE CODIGO='"+codigo+"'");
        bd.close();
    }
}
