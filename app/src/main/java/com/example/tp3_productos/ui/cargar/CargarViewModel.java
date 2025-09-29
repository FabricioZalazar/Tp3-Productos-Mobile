package com.example.tp3_productos.ui.cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3_productos.MainActivity;
import com.example.tp3_productos.model.Producto;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutableMensaje;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensaje() {
        if(mutableMensaje == null){
            mutableMensaje = new MutableLiveData<>();
        }
        return mutableMensaje;
    }

    public void cargarProducto(String codigoStr, String descripcion, String precioStr) {
        if (codigoStr == null || codigoStr.trim().isEmpty() ||
                descripcion == null || descripcion.trim().isEmpty() ||
                precioStr == null || precioStr.trim().isEmpty()) {
            mutableMensaje.setValue("No dejes campos vacíos");
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(codigoStr);
        } catch (NumberFormatException e) {
            mutableMensaje.setValue("El código debe ser un número válido");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            mutableMensaje.setValue("El precio debe ser un número válido");
            return;
        }

        if (precio < 0) {
            mutableMensaje.setValue("El precio no puede ser negativo");
            return;
        }

        for (Producto p : MainActivity.listaProductos) {
            if (p.getCodigo() == codigo) {
                mutableMensaje.setValue("El código ya existe");
                return;
            }
        }

        MainActivity.listaProductos.add(new Producto(precio, descripcion, codigo));
        mutableMensaje.setValue("Producto cargado con éxito");
    }

}