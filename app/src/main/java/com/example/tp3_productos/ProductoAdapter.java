package com.example.tp3_productos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3_productos.model.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProducto> {
private List<Producto>listado;
private Context context;
private LayoutInflater li;

    public ProductoAdapter(List<Producto> listado, Context context, LayoutInflater li) {
        this.listado = listado;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=li.inflate(R.layout.item,parent,false);
        return new ViewHolderProducto(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        List<Producto> listaOrdenada = new ArrayList<>(MainActivity.listaProductos);
        Collections.sort(listaOrdenada, (p1, p2) ->
                p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion())
        );
        Producto productoActual = listaOrdenada.get(position);
        holder.codigo.setText("El codigo es: "+productoActual.getCodigo());
        holder.descripcion.setText("Descripcion: "+productoActual.getDescripcion());
        holder.precio.setText("Precio $"+(int)productoActual.getPrecio());
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder{
        TextView codigo,descripcion,precio;
        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            codigo=itemView.findViewById(R.id.tvCodigoLista);
            descripcion=itemView.findViewById(R.id.tvDescripcionLista);
            precio=itemView.findViewById(R.id.tvPrecioLista);
        }
    }

}
