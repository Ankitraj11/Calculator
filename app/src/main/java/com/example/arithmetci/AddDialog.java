package com.example.arithmetci;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddDialog extends AppCompatDialogFragment {
    private EditText firstno;
    private EditText secondno;
    private Add listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.arithmetic_number, null);

        builder.setView(view)
                .setTitle("Enter two number")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String first = firstno.getText().toString();
                        String second = secondno.getText().toString();
                         listener.addNumber(first,second);
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        firstno = view.findViewById(R.id.first);
        secondno = view.findViewById(R.id.second);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener=(Add)context;

        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+ "must implment listener");
        }

    }

    public interface Add {
        void addNumber(String first, String second);

    }
}