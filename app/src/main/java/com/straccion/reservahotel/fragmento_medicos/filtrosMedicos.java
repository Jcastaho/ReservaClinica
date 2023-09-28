package com.straccion.reservahotel.fragmento_medicos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.straccion.reservahotel.Contenedor;
import com.straccion.reservahotel.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link filtrosMedicos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class filtrosMedicos extends Fragment {

    View mView;
    Button btnConsultarMedico;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public filtrosMedicos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment filtrosMedicos.
     */
    // TODO: Rename and change types and number of parameters
    public static filtrosMedicos newInstance(String param1, String param2) {
        filtrosMedicos fragment = new filtrosMedicos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_filtros_medicos, container, false);
        btnConsultarMedico = mView.findViewById(R.id.btnConsultarMedico);

        btnConsultarMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar(5);
            }
        });
        return mView;
    }
    public void consultar(int abrirventana){
        Intent intent = new Intent(getContext(), Contenedor.class);
        int ventana = abrirventana;
        intent.putExtra("abrir_Contenedor", ventana);
        startActivity(intent);
    }
}