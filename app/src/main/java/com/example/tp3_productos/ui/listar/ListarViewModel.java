package com.example.tp3_productos.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3_productos.MainActivity;
import com.example.tp3_productos.ProductoAdapter;
import com.example.tp3_productos.model.Producto;

import java.util.ArrayList;

public class ListarViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Producto>> mlista;


    public LiveData<ArrayList<Producto>> getMLista() {
        if (mlista==null){
            mlista=new MutableLiveData<>();
        }
        return mlista;
    }

    public void cargarLista(){
        mlista.setValue(MainActivity.listaProductos);
    }
}