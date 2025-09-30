package com.example.tp3_productos.ui.buscar;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3_productos.MainActivity;
import com.example.tp3_productos.model.Producto;

public class ResultadoBuscarViewModel extends ViewModel {
    private MutableLiveData<Producto> mProducto;

    public LiveData<Producto> getMProducto() {
        if (mProducto == null) {
            mProducto = new MutableLiveData<>();
        }
        return mProducto;
    }

    public void cargarProducto(Bundle bundle) {
        int codigo = Integer.parseInt(bundle.getString("codigo"));
        for (Producto p : MainActivity.listaProductos) {
            if (p.getCodigo() == codigo) {
                mProducto.setValue(p);
                return;
            }
        }
    }
}