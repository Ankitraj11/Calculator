package com.example.arithmetci;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DivideDailog extends AppCompatDialogFragment {
private EditText first;
private EditText second;
private Divide listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {



        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.arithmetic_number,null);
        first=view.findViewById(R.id.first);
        second=view.findViewById(R.id.second);

        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setView(view)
                .setTitle("Enter two no")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {




                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String firstno=first.getText().toString();
                String secondno=second.getText().toString();
                listener.divideno(firstno,secondno);
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

       try{
           listener=(Divide)context;

       }
    catch (ClassCastException e)
    {
        throw new ClassCastException(context.toString() +"must implment listener");
    }

    }

    public  interface  Divide{
        void divideno(String first,String second);
    }
}
