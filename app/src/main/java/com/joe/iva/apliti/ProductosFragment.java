package com.joe.iva.apliti;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ProductosFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
   public static SearchView searP;
   ListView lstProd;
    Button btnProduc;
    ArrayList<Productos> listaProduc;
    ArrayList<String> listaInformacion;
    public BData conn;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.fragment_productos, container, false);
//        return inflater.inflate(R.layout.fragment_productos,container,false);
        conn=new BData(getActivity(),"bd_productos",null,1);
        lstProd=(ListView)myFragmentView.findViewById(R.id.lstProd);
        consultarProductos();
        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaInformacion);
        lstProd.setAdapter(adapter);
        lstProd.setOnItemClickListener(this);
        btnProduc = (Button) myFragmentView.findViewById(R.id.btnCodBar);
        btnProduc.setOnClickListener(this);
        searP = (SearchView) myFragmentView.findViewById(R.id.searP);
        searP.onActionViewExpanded();








        searP.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }
        });


return myFragmentView;
    }

    private void consultarProductos() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Productos productos=null;
        listaProduc=new ArrayList<Productos>();
        Cursor fila = db.rawQuery("SELECT * FROM PRODUCTOS", null);
        while (fila.moveToNext()){
            productos=new Productos();
            productos.setCodigoP(fila.getString(0));
            productos.setNompreP(fila.getString(1));
            productos.setDescripcionP(fila.getString(2));
            productos.setPrecioP(fila.getString(3));
            productos.setProveedorP(fila.getString(4));
            productos.setStockP(fila.getString(5));
            productos.setMinimoP(fila.getString(6));

            listaProduc.add(productos);
        }
        obtenerLista();

    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaProduc.size();i++){
            listaInformacion.add(listaProduc.get(i).getCodigoP()+" - "
                    +listaProduc.get(i).getDescripcionP());
        }
    }


    @Override
    public void onClick(View v) {
//        Intent op= new Intent(getActivity(),operarAc.class);
//        startActivity(op);
//escaner();

        startActivity(new Intent(getActivity(),ScanCodeActivity.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


//        Toast.makeText(getActivity(), fila2.getString(1), Toast.LENGTH_SHORT).show();


//        Toast.makeText(getActivity(), "Clicked: "+item, Toast.LENGTH_LONG).show();
        String nombre=listaProduc.get(position).getNompreP();
        String descripcion=listaProduc.get(position).getDescripcionP();
        String precio=listaProduc.get(position).getPrecioP();
//        String item = String.valueOf(lstProd.getItemAtPosition(position));
//        BData cone2=new BData(getContext(),"bd_productos",null,1);
//        SQLiteDatabase db2=cone2.getWritableDatabase();
//        Cursor fila2=db2.rawQuery("SELECT NOMBRE FROM PRODUCTOS WHERE CODIGO=('"+item+"');",null);
        StringBuffer b = new StringBuffer();
b.append("Nombre: "+nombre+"\n");
        b.append("Descripción: "+descripcion+"\n");
        b.append("Precio $ "+precio+"\n");


        AlertDialog.Builder a = new AlertDialog.Builder(getActivity());
        a.setCancelable(true);
        a.setTitle("Detalles del producto");
        a.setMessage(b.toString());
        
        a.setIcon(R.drawable.common_google_signin_btn_icon_dark);
        a.show();


    }

//    public void escaner(){
//        IntentIntegrator intent = new IntentIntegrator(getActivity());
//        intent.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
//
//        intent.setPrompt("Escanear Codigo");
//        intent.setCameraId(0);
//        intent.setBeepEnabled(true);
//        intent.setBarcodeImageEnabled(false);
//        intent.initiateScan();
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
//
//        if(result != null){
//            if(result.getContents()== null){
//                Toast.makeText(getActivity(), "Cancelaste el escaneo", Toast.LENGTH_SHORT).show();
//            }else{
////        searB.setOnQueryTextListener(result.getContents().toString());
//
//searP.setText(result.getContents().toString());
//
//            }
//        }else{
//            super.onActivityResult(requestCode,resultCode,data);
//        }
//    }
}
