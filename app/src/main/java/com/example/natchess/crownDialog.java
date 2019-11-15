package com.example.natchess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.firebase.client.Firebase;

public class crownDialog extends AppCompatDialogFragment {

    public static final String DEFAULT = "N/A";
    private Firebase mRoot;
    Button buttonRook;
    Button buttonQueen;
    Button buttonKnight;
    Button buttonBishop;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mRoot = new Firebase("https://natchess-d50b2.firebaseio.com/Test/");



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.pop,null);

        buttonRook = view.findViewById(R.id.rook);
        buttonQueen = view.findViewById(R.id.Queen);
        buttonKnight = view.findViewById(R.id.Knight);
        buttonBishop = view.findViewById(R.id.Bishop);

        builder.setView(view);
//                .setTitle("Alec Mbanga");


        setCancelable(false);

        SharedPreferences sharedPreferences = super.getContext().getSharedPreferences("MyData",Context.MODE_PRIVATE);
        final String Pos = sharedPreferences.getString("position",DEFAULT);
        final String Code = sharedPreferences.getString("onlineCodeName",DEFAULT);

        buttonRook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Mbanga is awesome Pos "+ Pos);
                System.out.println("Mbanga is awesome Code "+ Code);

                if(Code.equals("p1b")){
                    mRoot.child("p1bRook").child("position").setValue(Pos);
                    mRoot.child("p1b").child("position").setValue("null");
                }else if(Code.equals("p2b")){
                    mRoot.child("p2bRook").child("position").setValue(Pos);
                    mRoot.child("p2b").child("position").setValue("null");
                }else if(Code.equals("p3b")) {
                    mRoot.child("p3bRook").child("position").setValue(Pos);
                    mRoot.child("p3b").child("position").setValue("null");
                }else if(Code.equals("p4b")) {
                    mRoot.child("p4bRook").child("position").setValue(Pos);
                    mRoot.child("p4b").child("position").setValue("null");
                }else if(Code.equals("p5b")) {
                    mRoot.child("p5bRook").child("position").setValue(Pos);
                    mRoot.child("p5b").child("position").setValue("null");
                }else if(Code.equals("p6b")) {
                    mRoot.child("p6bRook").child("position").setValue(Pos);
                    mRoot.child("p6b").child("position").setValue("null");
                }else if(Code.equals("p7b")) {
                    mRoot.child("p7bRook").child("position").setValue(Pos);
                    mRoot.child("p7b").child("position").setValue("null");
                }else if(Code.equals("p8b")) {
                    mRoot.child("p8bRook").child("position").setValue(Pos);
                    mRoot.child("p8b").child("position").setValue("null");
                }else if(Code.equals("p1w")){
                    mRoot.child("p1wRook").child("position").setValue(Pos);
                    mRoot.child("p1w").child("position").setValue("null");
                }else if(Code.equals("p2w")){
                    mRoot.child("p2wRook").child("position").setValue(Pos);
                    mRoot.child("p2w").child("position").setValue("null");
                }else if(Code.equals("p3w")){
                    mRoot.child("p3wRook").child("position").setValue(Pos);
                    mRoot.child("p3w").child("position").setValue("null");
                }else if(Code.equals("p4w")){
                    mRoot.child("p4wRook").child("position").setValue(Pos);
                    mRoot.child("p4w").child("position").setValue("null");
                }else if(Code.equals("p5w")){
                    mRoot.child("p5wRook").child("position").setValue(Pos);
                    mRoot.child("p5w").child("position").setValue("null");
                }else if(Code.equals("p6w")){
                    mRoot.child("p6wRook").child("position").setValue(Pos);
                    mRoot.child("p6w").child("position").setValue("null");
                }else if(Code.equals("p7w")){
                    mRoot.child("p7wRook").child("position").setValue(Pos);
                    mRoot.child("p7w").child("position").setValue("null");
                }else if(Code.equals("p8w")){
                    mRoot.child("p8wRook").child("position").setValue(Pos);
                    mRoot.child("p8w").child("position").setValue("null");
                }else{
                    System.out.println("Mbanga is awesome and nothing "+ Pos);
                }

                dismiss();
            }
        });


        buttonKnight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Mbanga is awesome Pos "+ Pos);
                System.out.println("Mbanga is awesome Code "+ Code);

                if(Code.equals("p1b")){
                    mRoot.child("p1bKnight").child("position").setValue(Pos);
                    mRoot.child("p1b").child("position").setValue("null");
                }else if(Code.equals("p2b")){
                    mRoot.child("p2bKnight").child("position").setValue(Pos);
                    mRoot.child("p2b").child("position").setValue("null");
                }else if(Code.equals("p3b")) {
                    mRoot.child("p3bKnight").child("position").setValue(Pos);
                    mRoot.child("p3b").child("position").setValue("null");
                }else if(Code.equals("p4b")) {
                    mRoot.child("p4bKnight").child("position").setValue(Pos);
                    mRoot.child("p4b").child("position").setValue("null");
                }else if(Code.equals("p5b")) {
                    mRoot.child("p5bKnight").child("position").setValue(Pos);
                    mRoot.child("p5b").child("position").setValue("null");
                }else if(Code.equals("p6b")) {
                    mRoot.child("p6bKnight").child("position").setValue(Pos);
                    mRoot.child("p6b").child("position").setValue("null");
                }else if(Code.equals("p7b")) {
                    mRoot.child("p7bKnight").child("position").setValue(Pos);
                    mRoot.child("p7b").child("position").setValue("null");
                }else if(Code.equals("p8b")) {
                    mRoot.child("p8bKnight").child("position").setValue(Pos);
                    mRoot.child("p8b").child("position").setValue("null");
                }else if(Code.equals("p1w")){
                    mRoot.child("p1wKnight").child("position").setValue(Pos);
                    mRoot.child("p1w").child("position").setValue("null");
                }else if(Code.equals("p2w")){
                    mRoot.child("p2wKnight").child("position").setValue(Pos);
                    mRoot.child("p2w").child("position").setValue("null");
                }else if(Code.equals("p3w")){
                    mRoot.child("p3wKnight").child("position").setValue(Pos);
                    mRoot.child("p3w").child("position").setValue("null");
                }else if(Code.equals("p4w")){
                    mRoot.child("p4wKnight").child("position").setValue(Pos);
                    mRoot.child("p4w").child("position").setValue("null");
                }else if(Code.equals("p5w")){
                    mRoot.child("p5wKnight").child("position").setValue(Pos);
                    mRoot.child("p5w").child("position").setValue("null");
                }else if(Code.equals("p6w")){
                    mRoot.child("p6wKnight").child("position").setValue(Pos);
                    mRoot.child("p6w").child("position").setValue("null");
                }else if(Code.equals("p7w")){
                    mRoot.child("p7wKnight").child("position").setValue(Pos);
                    mRoot.child("p7w").child("position").setValue("null");
                }else if(Code.equals("p8w")){
                    mRoot.child("p8wKnight").child("position").setValue(Pos);
                    mRoot.child("p8w").child("position").setValue("null");
                }else{
                    System.out.println("Mbanga is awesome and nothing "+ Pos);
                }

                dismiss();
            }
        });

        buttonBishop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Mbanga is awesome Pos "+ Pos);
                System.out.println("Mbanga is awesome Code "+ Code);

                if(Code.equals("p1b")){
                    mRoot.child("p1bBishop").child("position").setValue(Pos);
                    mRoot.child("p1b").child("position").setValue("null");
                }else if(Code.equals("p2b")){
                    mRoot.child("p2bBishop").child("position").setValue(Pos);
                    mRoot.child("p2b").child("position").setValue("null");
                }else if(Code.equals("p3b")) {
                    mRoot.child("p3bBishop").child("position").setValue(Pos);
                    mRoot.child("p3b").child("position").setValue("null");
                }else if(Code.equals("p4b")) {
                    mRoot.child("p4bBishop").child("position").setValue(Pos);
                    mRoot.child("p4b").child("position").setValue("null");
                }else if(Code.equals("p5b")) {
                    mRoot.child("p5bBishop").child("position").setValue(Pos);
                    mRoot.child("p5b").child("position").setValue("null");
                }else if(Code.equals("p6b")) {
                    mRoot.child("p6bBishop").child("position").setValue(Pos);
                    mRoot.child("p6b").child("position").setValue("null");
                }else if(Code.equals("p7b")) {
                    mRoot.child("p7bBishop").child("position").setValue(Pos);
                    mRoot.child("p7b").child("position").setValue("null");
                }else if(Code.equals("p8b")) {
                    mRoot.child("p8bBishop").child("position").setValue(Pos);
                    mRoot.child("p8b").child("position").setValue("null");
                }else if(Code.equals("p1w")){
                    mRoot.child("p1wBishop").child("position").setValue(Pos);
                    mRoot.child("p1w").child("position").setValue("null");
                }else if(Code.equals("p2w")){
                    mRoot.child("p2wBishop").child("position").setValue(Pos);
                    mRoot.child("p2w").child("position").setValue("null");
                }else if(Code.equals("p3w")){
                    mRoot.child("p3wBishop").child("position").setValue(Pos);
                    mRoot.child("p3w").child("position").setValue("null");
                }else if(Code.equals("p4w")){
                    mRoot.child("p4wBishop").child("position").setValue(Pos);
                    mRoot.child("p4w").child("position").setValue("null");
                }else if(Code.equals("p5w")){
                    mRoot.child("p5wBishop").child("position").setValue(Pos);
                    mRoot.child("p5w").child("position").setValue("null");
                }else if(Code.equals("p6w")){
                    mRoot.child("p6wBishop").child("position").setValue(Pos);
                    mRoot.child("p6w").child("position").setValue("null");
                }else if(Code.equals("p7w")){
                    mRoot.child("p7wBishop").child("position").setValue(Pos);
                    mRoot.child("p7w").child("position").setValue("null");
                }else if(Code.equals("p8w")){
                    mRoot.child("p8wBishop").child("position").setValue(Pos);
                    mRoot.child("p8w").child("position").setValue("null");
                }else{
                    System.out.println("Mbanga is awesome and nothing "+ Pos);
                }

                dismiss();
            }
        });

        buttonQueen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Mbanga is awesome Pos "+ Pos);
                System.out.println("Mbanga is awesome Code "+ Code);

                if(Code.equals("p1b")){
                    mRoot.child("p1bQueen").child("position").setValue(Pos);
                    mRoot.child("p1b").child("position").setValue("null");
                }else if(Code.equals("p2b")){
                    mRoot.child("p2bQueen").child("position").setValue(Pos);
                    mRoot.child("p2b").child("position").setValue("null");
                }else if(Code.equals("p3b")) {
                    mRoot.child("p3bQueen").child("position").setValue(Pos);
                    mRoot.child("p3b").child("position").setValue("null");
                }else if(Code.equals("p4b")) {
                    mRoot.child("p4bQueen").child("position").setValue(Pos);
                    mRoot.child("p4b").child("position").setValue("null");
                }else if(Code.equals("p5b")) {
                    mRoot.child("p5bQueen").child("position").setValue(Pos);
                    mRoot.child("p5b").child("position").setValue("null");
                }else if(Code.equals("p6b")) {
                    mRoot.child("p6bQueen").child("position").setValue(Pos);
                    mRoot.child("p6b").child("position").setValue("null");
                }else if(Code.equals("p7b")) {
                    mRoot.child("p7bQueen").child("position").setValue(Pos);
                    mRoot.child("p7b").child("position").setValue("null");
                }else if(Code.equals("p8b")) {
                    mRoot.child("p8bQueen").child("position").setValue(Pos);
                    mRoot.child("p8b").child("position").setValue("null");
                }else if(Code.equals("p1w")){
                    mRoot.child("p1wQueen").child("position").setValue(Pos);
                    mRoot.child("p1w").child("position").setValue("null");
                }else if(Code.equals("p2w")){
                    mRoot.child("p2wQueen").child("position").setValue(Pos);
                    mRoot.child("p2w").child("position").setValue("null");
                }else if(Code.equals("p3w")){
                    mRoot.child("p3wQueen").child("position").setValue(Pos);
                    mRoot.child("p3w").child("position").setValue("null");
                }else if(Code.equals("p4w")){
                    mRoot.child("p4wQueen").child("position").setValue(Pos);
                    mRoot.child("p4w").child("position").setValue("null");
                }else if(Code.equals("p5w")){
                    mRoot.child("p5wQueen").child("position").setValue(Pos);
                    mRoot.child("p5w").child("position").setValue("null");
                }else if(Code.equals("p6w")){
                    mRoot.child("p6wQueen").child("position").setValue(Pos);
                    mRoot.child("p6w").child("position").setValue("null");
                }else if(Code.equals("p7w")){
                    mRoot.child("p7wQueen").child("position").setValue(Pos);
                    mRoot.child("p7w").child("position").setValue("null");
                }else if(Code.equals("p8w")){
                    mRoot.child("p8wQueen").child("position").setValue(Pos);
                    mRoot.child("p8w").child("position").setValue("null");
                }else{
                    System.out.println("Mbanga is awesome and nothing "+ Pos);
                }

                dismiss();
            }
        });

        return builder.create();
    }
}
