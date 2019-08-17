package com.joe.iva.apliti;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class OpePro extends AppCompatActivity  {
 Button btnScan,btnAgregar,btnConsul;
public  static EditText txtCodi;
       EditText txtNombre,txtDescripcion,txtPrecio,txtProveedor,txtStock,txtMinimo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ope_pro);
        txtCodi=(EditText)findViewById(R.id.txtCodi);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtCodi.setEnabled(false);
        txtDescripcion=(EditText)findViewById(R.id.txtDescripcion);
        btnConsul=(Button)findViewById(R.id.btnConsul);
        btnConsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarSql();
            }
        });
        txtPrecio=(EditText)findViewById(R.id.txtPrecio);
        txtProveedor=(EditText)findViewById(R.id.txtProveedor);
        txtStock=(EditText)findViewById(R.id.txtStock);
        txtMinimo=(EditText)findViewById(R.id.txtMinimo);
        btnScan=(Button)findViewById(R.id.btnEscan);
        btnAgregar=(Button)findViewById(R.id.btnAgregar);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cam= new Intent(OpePro.this,ScanCodeActivity2.class);
                startActivity(cam);




            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


AgregarP();

            }
        });



    }
    private void AgregarP(){
        BData conn=new BData(getApplicationContext(),"bd_productos",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();
        if(txtCodi.getText().toString().isEmpty()|| txtNombre.getText().toString().isEmpty() || txtDescripcion.getText().toString().isEmpty() || txtPrecio.getText().toString().isEmpty() || txtProveedor.getText().toString().isEmpty() || txtStock.getText().toString().isEmpty() || txtMinimo.getText().toString().isEmpty()){
            Toast.makeText(OpePro.this, "Por favor ingresa los datos faltantes", Toast.LENGTH_SHORT).show();
        }else{
            conn.AgregarProductos(txtCodi.getText().toString(),txtNombre.getText().toString(),txtDescripcion.getText().toString(),txtPrecio.getText().toString(),txtProveedor.getText().toString(),txtStock.getText().toString(),txtMinimo.getText().toString());
            txtCodi.setText("");
            txtDescripcion.setText("");
            txtNombre.setText("");
            txtMinimo.setText("");
            txtStock.setText("");
            txtProveedor.setText("");
            txtPrecio.setText("");
            Toast.makeText(this, "Producto Agregado correctamente", Toast.LENGTH_SHORT).show();
        }





        db.close();
    }
    private void consultarSql() {
        BData conn2=new BData(getApplicationContext(),"bd_productos",null,1);

        SQLiteDatabase db=conn2.getWritableDatabase();
        String parametros=txtCodi.getText().toString();

        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT * FROM PRODUCTOS WHERE CODIGO=('"+ parametros+"');",null);

            cursor.moveToFirst();
            txtNombre.setText(cursor.getString(1));
            txtDescripcion.setText(cursor.getString(2));
            txtPrecio.setText(cursor.getString(3));
            txtProveedor.setText(cursor.getString(4));
            txtStock.setText(cursor.getString(5));
            txtMinimo.setText(cursor.getString(6));
            Toast.makeText(this,"Este producto ya existe",Toast.LENGTH_LONG).show();
            txtPrecio.setEnabled(false);
            txtStock.setEnabled(false);
            txtMinimo.setEnabled(false);

        }catch (Exception e){
            Toast.makeText(this,"Este producto no existe",Toast.LENGTH_LONG).show();
//                limpiar();
        }

    }




}
