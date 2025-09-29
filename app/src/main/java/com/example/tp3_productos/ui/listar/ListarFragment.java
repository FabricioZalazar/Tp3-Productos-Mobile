package com.example.tp3_productos.ui.listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.tp3_productos.ProductoAdapter;
import com.example.tp3_productos.databinding.FragmentListarBinding;
import com.example.tp3_productos.model.Producto;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mv=new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getMLista().observe(getViewLifecycleOwner(), new Observer<ArrayList<Producto>>() {
            @Override
            public void onChanged(ArrayList<Producto> productos) {
                ProductoAdapter la= new ProductoAdapter(productos,getContext(),getLayoutInflater());
                GridLayoutManager grl = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
                binding.rvLista.setLayoutManager(grl);
                binding.rvLista.setAdapter(la);
            }
        });

        mv.cargarLista();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}