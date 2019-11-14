package com.example.natchess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.firebase.client.Firebase;

public class crownDialog extends AppCompatDialogFragment {

    private Firebase mRoot;
    Button buttonRook;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mRoot = new Firebase("https://natchess-d50b2.firebaseio.com/Test/");


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.pop,null);

        buttonRook = view.findViewById(R.id.rook);

        builder.setView(view);
//                .setTitle("Alec Mbanga");


        setCancelable(false);

        buttonRook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Mbanga is awesom");
                mRoot.child("p1b").child("position").setValue("null");
                dismiss();
            }
        });

        return builder.create();
    }
}
