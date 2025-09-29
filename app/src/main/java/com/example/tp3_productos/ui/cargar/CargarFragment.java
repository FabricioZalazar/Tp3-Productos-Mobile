package com.example.tp3_productos.ui.cargar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.tp3_productos.R;
import com.example.tp3_productos.databinding.FragmentCargarBinding;


public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mv= new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvMensajeCargar.setText(s);
            }
        });

        binding.btCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = binding.etCodigoCargar.getText().toString();
                String descripcion = binding.etDescripcionCargar.getText().toString();
                String precio = binding.etPrecioCargar.getText().toString();
                mv.cargarProducto(codigo,descripcion,precio);
            }
        });






        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.tvMensajeCargar.setText("");
        binding.etCodigoCargar.setText("");
        binding.etDescripcionCargar.setText("");
        binding.etPrecioCargar.setText("");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}