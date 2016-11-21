package com.example.mati.pexamen;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


public class Dialogo_AcercaDe extends DialogFragment
{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Acerca de")
                .setMessage("Version 1.0\nHecho por Jorge Coello \n 2 - DAM")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"¡Gracias por ver mi aplicación!",Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
