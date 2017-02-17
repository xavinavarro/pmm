package com.example.xavin.miproyectoxavinavarro;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Dinamico extends Fragment {

    Integer[] id;
    private OnFragmentInteractionListener mListener;

    Button aceptar,cancelar,comprar;
    Activity activity;
    RelativeLayout layout;
    TextView titulo,genero,precio,caja,radio;
    BDClients cliBDh;

    public Fragment_Dinamico() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.f_dinamico, container, false);

        aceptar=(Button)view.findViewById(R.id.confirmar_compra);
        cancelar=(Button)view.findViewById(R.id.cancelar_compra);
        comprar=(Button)view.findViewById(R.id.boton_comprar);
        layout=(RelativeLayout)view.findViewById(R.id.layout_fragment);

        titulo=(TextView)view.findViewById(R.id.titulojuego);
        genero=(TextView)view.findViewById(R.id.genero);
        precio=(TextView)view.findViewById(R.id.precio);
        caja=(TextView)view.findViewById(R.id.cajajuego);
        radio=(TextView)view.findViewById(R.id.pago);

        final EditText usuario=(EditText)view.findViewById(R.id.ver_user);

        final Bundle mibundle=this.getArguments();
        final Juegos juego = (Juegos) mibundle.getSerializable("informacion");

        titulo.setText("Titulo: "+juego.getTitulo());
        genero.setText("Genero: "+juego.getGenero());
        precio.setText("Precio: "+juego.getPrecio()+" €/Unidad");
        caja.setText("Plataformas: ");

        if (this.getArguments().getBoolean("boolean1")==true){
            caja.setText(caja.getText()+this.getArguments().getString("pc"));
        }
        if (this.getArguments().getBoolean("boolean2")==true){
            caja.setText(caja.getText()+"  "+this.getArguments().getString("playstation"));
        }
        if (this.getArguments().getBoolean("boolean3")==true){
            caja.setText(caja.getText()+"  "+this.getArguments().getString("xbox"));
        }

        radio.setText(this.getArguments().getString("grupo"));


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity=getActivity();
                Toast.makeText(activity,"Gracias por la compra",Toast.LENGTH_LONG).show();
                layout.setVisibility(View.INVISIBLE);

                cliBDh = new BDClients(getActivity().getApplicationContext(), "Usuarios", null, 1);

                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                Cursor cursor = bd.rawQuery("SELECT id FROM Usuarios where usuario= '" +mibundle.getString("usuario")+ "';", null);

                id = new Integer[cursor.getCount()];

                if(cursor.moveToFirst()) {
                    do {
                        String ids = cursor.getString(0);
                        id[0] = Integer.parseInt(ids);
                    } while (cursor.moveToNext());
                    try {
                        bd.execSQL("INSERT INTO Ventas (usuarios,Titulo,Genero,Precio,Plataforma,Forma_pago) VALUES" +
                                " ('"+id[0]+"','" + juego.getTitulo() + "','" + juego.getGenero() + "','" + juego.getPrecio() + "','" + caja.getText() + "','" + radio.getText() + "')");

                        Toast.makeText(getActivity().getApplicationContext(), "REGISTRO COMPLETADO", Toast.LENGTH_LONG).show();

                    }catch (Exception e){
                        e.getMessage();

                    }
                }
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
        void onFragmentInteraction(Uri uri);
    }
}
