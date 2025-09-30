package com.example.tp3_productos.ui.buscar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp3_productos.R;
import com.example.tp3_productos.databinding.FragmentBuscarBinding;

import java.io.Console;

public class BuscarFragment extends Fragment {

    private FragmentBuscarBinding binding;
    private BuscarViewModel mv;



    public static BuscarFragment newInstance() {
        return new BuscarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mv= new ViewModelProvider(this).get(BuscarViewModel.class);
        binding = FragmentBuscarBinding.inflate(inflater, container , false);
        View root = binding.getRoot();


        mv.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Bundle bundle = new Bundle();
                bundle.putString("codigo", s);
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.resultadoBuscarFragment,bundle);
            }
        }) ;

        binding.btBuscarBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = binding.etCodigoBuscar.getText().toString();
                mv.buscarProducto(codigo);
                }
        });


        return root;
    }

    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}