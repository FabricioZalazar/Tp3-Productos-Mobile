package com.example.tp3_productos.ui.buscar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp3_productos.R;
import com.example.tp3_productos.databinding.FragmentListarBinding;
import com.example.tp3_productos.databinding.FragmentResultadoBuscarBinding;
import com.example.tp3_productos.model.Producto;
import com.example.tp3_productos.ui.listar.ListarViewModel;

public class ResultadoBuscarFragment extends Fragment {

    private FragmentResultadoBuscarBinding binding;
    private ResultadoBuscarViewModel mv;

    public static ResultadoBuscarFragment newInstance() {
        return new ResultadoBuscarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv=new ViewModelProvider(this).get(ResultadoBuscarViewModel.class);
        binding = FragmentResultadoBuscarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getMProducto().observe(getViewLifecycleOwner(), new Observer<Producto>() {
            @Override
            public void onChanged(Producto producto) {
                binding.tvCodigoResultado.setText(producto.getCodigo()+"");
                binding.tvDescripcionResultado.setText(producto.getDescripcion());
                binding.tvPrecioResultado.setText(producto.getPrecio()+"");
            }
        });

        mv.cargarProducto(getArguments());

        return root;
    }



}