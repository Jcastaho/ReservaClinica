package com.straccion.reservahotel.fragmentos_agendar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.straccion.reservahotel.AdminBD;
import com.straccion.reservahotel.Contenedor;
import com.straccion.reservahotel.R;
import com.straccion.reservahotel.perfil.perfilUsuario;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ingresarReserva#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ingresarReserva extends Fragment {
    View mview;
    AdminBD adminBD;
    CircleImageView circleImagenPerfil;
    TextView txtnombreUs;
    File ImageFile;
    int idUser;
    String imagen;
    String nombreUsuario;

    CardView cardCrearCita, cardModificarCita, cardConsultarCentros ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ingresarReserva() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ingresarReserva.
     */
    // TODO: Rename and change types and number of parameters
    public static ingresarReserva newInstance(String param1, String param2) {
        ingresarReserva fragment = new ingresarReserva();
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

        Bundle args = getArguments();
        if (args != null){
            idUser = args.getInt("idUser",0);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_ingresar_reserva, container, false);
        cardCrearCita = mview.findViewById(R.id.cardCrearCita);
        cardConsultarCentros = mview.findViewById(R.id.cardConsultarCentros);
        cardModificarCita = mview.findViewById(R.id.cardModificarCita);
        circleImagenPerfil = mview.findViewById(R.id.circleImagenPerfil);
        txtnombreUs = mview.findViewById(R.id.txtnombreUs);


        adminBD = new AdminBD(getContext());



        circleImagenPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), perfilUsuario.class);
                intent.putExtra("idUser",idUser);
                startActivity(intent);
            }
        });
        cardCrearCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCita(2);
            }
        });
        cardModificarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCita(6);
            }
        });
        cardConsultarCentros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCita(4);
            }
        });
        mostrarImagenPerfilyNombre();
        return mview;
    }

    public void abrirCita(int abrirVentana){
        Intent intent = new Intent(getContext(), Contenedor.class);
        int ventana = abrirVentana;
        intent.putExtra("abrir_Contenedor", ventana);
        intent.putExtra("idUser", idUser);
        startActivity(intent);
    }

    public void mostrarImagenPerfilyNombre(){
        if (idUser != -1){
            imagen = adminBD.mostrarImagen(idUser);
            nombreUsuario = adminBD.saberNombre(idUser);
            if (imagen != null){
                ImageFile = new File(imagen);
                circleImagenPerfil.setImageBitmap(BitmapFactory.decodeFile(ImageFile.getAbsolutePath()));
            }
            if (!nombreUsuario.isEmpty()){
                txtnombreUs.setText("Bienvenido: " + nombreUsuario.toUpperCase());
            }

        }
    }

}