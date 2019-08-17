package com.joe.iva.apliti;

import java.io.Serializable;

public class Productos implements Serializable {
    String CodigoP;
    String NompreP;
    String DescripcionP;
    String PrecioP;
    String ProveedorP;
    String StockP;
    String MinimoP;

    public Productos(){

    }

    public Productos(String codigoP, String nompreP, String descripcionP, String precioP, String proveedorP, String stockP, String minimoP) {
        CodigoP = codigoP;
        NompreP = nompreP;
        DescripcionP = descripcionP;
        PrecioP = precioP;
        ProveedorP = proveedorP;
        StockP = stockP;
        MinimoP = minimoP;
    }

    public String getCodigoP() {
        return CodigoP;
    }

    public void setCodigoP(String codigoP) {
        CodigoP = codigoP;
    }

    public String getNompreP() {
        return NompreP;
    }

    public void setNompreP(String nompreP) {
        NompreP = nompreP;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        DescripcionP = descripcionP;
    }

    public String getPrecioP() {
        return PrecioP;
    }

    public void setPrecioP(String precioP) {
        PrecioP = precioP;
    }

    public String getProveedorP() {
        return ProveedorP;
    }

    public void setProveedorP(String proveedorP) {
        ProveedorP = proveedorP;
    }

    public String getStockP() {
        return StockP;
    }

    public void setStockP(String stockP) {
        StockP = stockP;
    }

    public String getMinimoP() {
        return MinimoP;
    }

    public void setMinimoP(String minimoP) {
        MinimoP = minimoP;
    }
}
