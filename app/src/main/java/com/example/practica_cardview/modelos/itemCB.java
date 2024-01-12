package com.example.practica_cardview.modelos;

public class itemCB {
    int ID;
    String Descripcion;
public toString(){return ;}
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public itemCB(int ID, String descripcion) {
        this.ID = ID;
        Descripcion = descripcion;
    }
}
