package com.example.tp3_productos.ui.buscar;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.tp3_productos.MainActivity;
import com.example.tp3_productos.R;
import com.example.tp3_productos.model.Producto;

public class BuscarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutableMensaje;
    public BuscarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensaje() {
        if(mutableMensaje == null){
            mutableMensaje = new MutableLiveData<>();
        }
        return mutableMensaje;
    }

    public void buscarProducto(String codigoStr){
        if (codigoStr == null || codigoStr.trim().isEmpty()){
            Toast.makeText(getApplication(), "No el campo vacío", Toast.LENGTH_LONG).show();
            return;
        }

        int codigo;

        try {
            codigo = Integer.parseInt(codigoStr);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplication(), "El código debe ser un número válido", Toast.LENGTH_LONG).show();
            return;
        }

        for (Producto p : MainActivity.listaProductos) {
            if (p.getCodigo() == codigo) {
                Toast.makeText(getApplication(), "Producto Encontrado", Toast.LENGTH_LONG).show();
                mutableMensaje.setValue(String.valueOf(codigo));
                return;
            }

        }

    }

}