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

public class SubtractDialog extends AppCompatDialogFragment {
private EditText first;
private EditText second;
private  Subtract listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.arithmetic_number,null);
        builder.setView(view)
                .setTitle("enter two number")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           String firstno=first.getText().toString();
           String secondno=second.getText().toString();
                   listener.subtractno(firstno,secondno);

            }
        });

        first=view.findViewById(R.id.first);
         second=view.findViewById(R.id.second);




        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener=(Subtract)context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException( context.toString()+ "implments the listener");

        }


    }

    public  interface  Subtract{
        void subtractno(String first,String second);

}

}
