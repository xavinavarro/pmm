package com.example.xavin.miproyectoxavinavarro;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FDinamico extends Fragment {

    private OnFragmentInteractionListener mListener;

    Button aceptar,cancelar,comprar;
    Activity activity;
    RelativeLayout layout;
    TextView titulo,genero,precio,caja,radio;

    public FDinamico() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.f_dinamico, container, false);

        aceptar=(Button)view.findViewById(R.id.confirmar_compra);
        cancelar=(Button)view.findViewById(R.id.cancelar_compra);
        comprar=(Button)view.findViewById(R.id.boton_comprar);
        layout=(RelativeLayout)view.findViewById(R.id.layout_fragment);

        titulo=(TextView)view.findViewById(R.id.juego_titulo);
        genero=(TextView)view.findViewById(R.id.juego_genero);
        precio=(TextView)view.findViewById(R.id.juego_precio);
        caja=(TextView)view.findViewById(R.id.resultado_caja);
        radio=(TextView)view.findViewById(R.id.resultado_pago);

        Bundle mibundle=this.getArguments();
        Juegos juego = (Juegos) mibundle.getSerializable("informacion");

        titulo.setText("Titulo: "+juego.getTitulo());
        genero.setText("Genero: "+juego.getGenero());
        precio.setText("Precio: "+juego.getPrecio()+" €/Unidad");
        caja.setText("Plataformas: ");

        if (this.getArguments().getBoolean("boolean1")==true){
            caja.setText(caja.getText()+this.getArguments().getString("caja_pc"));
        }
        if (this.getArguments().getBoolean("boolean2")==true){
            caja.setText(caja.getText()+"  "+this.getArguments().getString("caja_play"));
        }
        if (this.getArguments().getBoolean("boolean3")==true){
            caja.setText(caja.getText()+"  "+this.getArguments().getString("caja_xbox"));
        }

        radio.setText(this.getArguments().getString("grupo"));
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity=getActivity();
                Toast.makeText(activity,"GRACIAS POR LA COMPRA",Toast.LENGTH_LONG).show();
                layout.setVisibility(View.INVISIBLE);
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.INVISIBLE);
            }
        });
        return view;
    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}