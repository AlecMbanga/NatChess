package com.example.natchess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.natchess.views.Canvas;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Chess extends AppCompatActivity {

    private Firebase mRoot;
    private Canvas canvas;

//    Dialog die;
//    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);
//        final Canvas canvas = new Canvas(this);
        canvas = (Canvas)findViewById(R.id.chess_board);
//        setContentView(R.layout.activity_chess);


        mRoot = new Firebase("https://natchess-d50b2.firebaseio.com/Test/");

        Firebase p1bb = mRoot.child("p1b");
        final Firebase p1b = p1bb.child("position");
        p1b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p1b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1bF = p1bb.child("firstMove");
        p1bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1bPrev = p1bb.child("prevPosition");
        p1bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p1b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p2bb = mRoot.child("p2b");
        Firebase p2b = p2bb.child("position");
        p2b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p2b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2bF = p2bb.child("firstMove");
        p2bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p2b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2bPrev = p2bb.child("prevPosition");
        p2bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p2b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase p3bb = mRoot.child("p3b");
        Firebase p3b = p3bb.child("position");
        p3b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p3b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3bF = p3bb.child("firstMove");
        p3bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p3b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3bPrev = p3bb.child("prevPosition");
        p3bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p3b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase p4bb = mRoot.child("p4b");
        Firebase p4b = p4bb.child("position");
        p4b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p4b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4bF = p4bb.child("firstMove");
        p4bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p4b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase p4bPrev = p4bb.child("prevPosition");
        p4bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p4b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase p5bb = mRoot.child("p5b");
        Firebase p5b = p5bb.child("position");
        p5b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p5b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5bF = p5bb.child("firstMove");
        p5bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p5b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5bPrev = p5bb.child("prevPosition");
        p5bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p5b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        Firebase p6bb = mRoot.child("p6b");
        Firebase p6b = p6bb.child("position");
        p6b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p6b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6bF = p6bb.child("firstMove");
        p6bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p6b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6bPrev = p6bb.child("prevPosition");
        p6bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p6b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        Firebase p7bb = mRoot.child("p7b");
        Firebase p7b = p7bb.child("position");
        p7b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p7b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7bF = p7bb.child("firstMove");
        p7bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p7b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7bPrev = p7bb.child("prevPosition");
        p7bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p7b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase p8bb = mRoot.child("p8b");
        Firebase p8b = p8bb.child("position");
        p8b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("C1") || dataSnapshot.getValue(String.class).equals("D1") || dataSnapshot.getValue(String.class).equals("E1") || dataSnapshot.getValue(String.class).equals("F1") || dataSnapshot.getValue(String.class).equals("G1") || dataSnapshot.getValue(String.class).equals("H1")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p8b");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8bF = p8bb.child("firstMove");
        p8bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p8b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8bPrev = p8bb.child("prevPosition");
        p8bPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p8b.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase r1bb = mRoot.child("r1b");
        Firebase r1b = r1bb.child("position");
        r1b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.r1b.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase r1bF = r1bb.child("firstMove");
        r1bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.r1b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.r1b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase r2bb = mRoot.child("r2b");
        Firebase r2b = r2bb.child("position");
        r2b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.r2b.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase r2bF = r2bb.child("firstMove");
        r2bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.r2b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.r2b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase k1bb = mRoot.child("k1b");
        Firebase k1b = k1bb.child("position");
        k1b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.k1b.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase k1bF = k1bb.child("firstMove");
        k1bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.k1b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.k1b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase k2bb = mRoot.child("k2b");
        Firebase k2b = k2bb.child("position");
        k2b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.k2b.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase k2bF = k2bb.child("firstMove");
        k2bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.k2b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.k2b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase b1bb = mRoot.child("b1b");
        Firebase b1b = b1bb.child("position");
        b1b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.b1b.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase b1bF = b1bb.child("firstMove");
        b1bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.b1b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.b1b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase b2bb = mRoot.child("b2b");
        Firebase b2b = b2bb.child("position");
        b2b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.b2b.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase b2bF = b2bb.child("firstMove");
        b2bF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.b2b.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.b2b.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase kbb = mRoot.child("kb");
        Firebase kb = kbb.child("position");
        kb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.kb.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase kbF = kbb.child("firstMove");
        kbF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.kb.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.kb.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase qbb = mRoot.child("qb");
        Firebase qb = qbb.child("position");
        qb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.qb.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase qbF = qbb.child("firstMove");
        qbF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.qb.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.qb.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase p1wb = mRoot.child("p1w");
        Firebase p1w = p1wb.child("position");
        p1w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p1w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1wF = p1wb.child("firstMove");
        p1wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p1w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1wPrev = p1wb.child("prevPosition");
        p1wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p1w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase p2wb = mRoot.child("p2w");
        Firebase p2w = p2wb.child("position");
        p2w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p2w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2wF = p2wb.child("firstMove");
        p2wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p2w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2wPrev = p2wb.child("prevPosition");
        p2wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p2w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p3wb = mRoot.child("p3w");
        Firebase p3w = p3wb.child("position");
        p3w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p3w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3wF = p3wb.child("firstMove");
        p3wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p3w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3wPrev = p3wb.child("prevPosition");
        p3wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p3w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p4wb = mRoot.child("p4w");
        Firebase p4w = p4wb.child("position");
        p4w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p4w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4wF = p4wb.child("firstMove");
        p4wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p4w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4wPrev = p4wb.child("prevPosition");
        p4wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p4w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p5wb = mRoot.child("p5w");
        Firebase p5w = p5wb.child("position");
        p5w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p5w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5wF = p5wb.child("firstMove");
        p5wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p5w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5wPrev = p5wb.child("prevPosition");
        p5wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p5w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        Firebase p6wb = mRoot.child("p6w");
        Firebase p6w = p6wb.child("position");
        p6w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p6w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6wF = p6wb.child("firstMove");
        p6wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p6w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6wPrev = p6wb.child("prevPosition");
        p6wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p6w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        Firebase p7wb = mRoot.child("p7w");
        Firebase p7w = p7wb.child("position");
        p7w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p7w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7wF = p7wb.child("firstMove");
        p7wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p7w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7wPrev = p7wb.child("prevPosition");
        p7wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p7w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        Firebase p8wb = mRoot.child("p8w");
        Firebase p8w = p8wb.child("position");
        p8w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8w.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A8") || dataSnapshot.getValue(String.class).equals("B8") || dataSnapshot.getValue(String.class).equals("C8") || dataSnapshot.getValue(String.class).equals("D8") || dataSnapshot.getValue(String.class).equals("E8") || dataSnapshot.getValue(String.class).equals("F8") || dataSnapshot.getValue(String.class).equals("G8") || dataSnapshot.getValue(String.class).equals("H8")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.putString("position",dataSnapshot.getValue(String.class));
                        editor.putString("onlineCodeName","p8w");
                        editor.apply();
                        crownDialog c = new crownDialog();
                        c.show(getSupportFragmentManager(),"crown Dialog");
                    }
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8wF = p8wb.child("firstMove");
        p8wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.p8w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8wPrev = p8wb.child("prevPosition");
        p8wPrev.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("prevPosition")) {
                    canvas.p8w.prevPosition =dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        Firebase r1wb = mRoot.child("r1w");
        Firebase r1w = r1wb.child("position");
        r1w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.r1w.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase r1wF = r1wb.child("firstMove");
        r1wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.r1w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.r1w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase r2wb = mRoot.child("r2w");
        Firebase r2w = r2wb.child("position");
        r2w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.r2w.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase r2wF = r2wb.child("firstMove");
        r2wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.r2w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.r2w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase k1wb = mRoot.child("k1w");
        Firebase k1w = k1wb.child("position");
        k1w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.k1w.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase k1wF = k1wb.child("firstMove");
        k1wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.k1w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.k1w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase k2wb = mRoot.child("k2w");
        Firebase k2w = k2wb.child("position");
        k2w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.k2w.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase k2wF = k2wb.child("firstMove");
        k2wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.k2w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.k2w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase b1wb = mRoot.child("b1w");
        Firebase b1w = b1wb.child("position");
        b1w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.b1w.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase b1wF = b1wb.child("firstMove");
        b1wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.b1w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.b1w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase b2wb = mRoot.child("b2w");
        Firebase b2w = b2wb.child("position");
        b2w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.b2w.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase b2wF = b2wb.child("firstMove");
        b2wF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.b2w.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.b2w.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase kwb = mRoot.child("kw");
        Firebase kw = kwb.child("position");
        kw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.kw.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase kwF = kwb.child("firstMove");
        kwF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.kw.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.kw.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase qwb = mRoot.child("qw");
        Firebase qw = qwb.child("position");
        qw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.qw.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase qwF = qwb.child("firstMove");
        qwF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();
                    if(value.equals("true")){
                        canvas.qw.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.qw.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        /////
        Firebase p1bbQueen = mRoot.child("p1bQueen");
        final Firebase p1bQueen = p1bbQueen.child("position");
        p1bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1bFQueen = p1bbQueen.child("firstMove");
        p1bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p1bbBishop = mRoot.child("p1bBishop");
        final Firebase p1bBishop = p1bbBishop.child("position");
        p1bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1bFBishop = p1bbBishop.child("firstMove");
        p1bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p1bbKnight = mRoot.child("p1bKnight");
        final Firebase p1bKnight = p1bbKnight.child("position");
        p1bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1bFKnight = p1bbKnight.child("firstMove");
        p1bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p1bbRook = mRoot.child("p1bRook");
        final Firebase p1bRook = p1bbRook.child("position");
        p1bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1bFRook = p1bbRook.child("firstMove");
        p1bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p2bbQueen = mRoot.child("p2bQueen");
        final Firebase p2bQueen = p2bbQueen.child("position");
        p2bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2bFQueen = p2bbQueen.child("firstMove");
        p2bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p2bbBishop = mRoot.child("p2bBishop");
        final Firebase p2bBishop = p2bbBishop.child("position");
        p2bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2bFBishop = p2bbBishop.child("firstMove");
        p2bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p2bbKnight = mRoot.child("p2bKnight");
        final Firebase p2bKnight = p2bbKnight.child("position");
        p2bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2bFKnight = p2bbKnight.child("firstMove");
        p2bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p2bbRook = mRoot.child("p2bRook");
        final Firebase p2bRook = p2bbRook.child("position");
        p2bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2bFRook = p2bbRook.child("firstMove");
        p2bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p3bbQueen = mRoot.child("p3bQueen");
        final Firebase p3bQueen = p3bbQueen.child("position");
        p3bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3bFQueen = p3bbQueen.child("firstMove");
        p3bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p3bbBishop = mRoot.child("p3bBishop");
        final Firebase p3bBishop = p3bbBishop.child("position");
        p3bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3bFBishop = p3bbBishop.child("firstMove");
        p3bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p3bbKnight = mRoot.child("p3bKnight");
        final Firebase p3bKnight = p3bbKnight.child("position");
        p3bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3bFKnight = p3bbKnight.child("firstMove");
        p3bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p3bbRook = mRoot.child("p3bRook");
        final Firebase p3bRook = p3bbRook.child("position");
        p3bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3bFRook = p3bbRook.child("firstMove");
        p3bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p4bbQueen = mRoot.child("p4bQueen");
        final Firebase p4bQueen = p4bbQueen.child("position");
        p4bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4bFQueen = p4bbQueen.child("firstMove");
        p4bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p4bbBishop = mRoot.child("p4bBishop");
        final Firebase p4bBishop = p4bbBishop.child("position");
        p4bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4bFBishop = p4bbBishop.child("firstMove");
        p4bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p4bbKnight = mRoot.child("p4bKnight");
        final Firebase p4bKnight = p4bbKnight.child("position");
        p4bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4bFKnight = p4bbKnight.child("firstMove");
        p4bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p4bbRook = mRoot.child("p4bRook");
        final Firebase p4bRook = p4bbRook.child("position");
        p4bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4bFRook = p4bbRook.child("firstMove");
        p4bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p5bbQueen = mRoot.child("p5bQueen");
        final Firebase p5bQueen = p5bbQueen.child("position");
        p5bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5bFQueen = p5bbQueen.child("firstMove");
        p5bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p5bbBishop = mRoot.child("p5bBishop");
        final Firebase p5bBishop = p5bbBishop.child("position");
        p5bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5bFBishop = p5bbBishop.child("firstMove");
        p5bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p5bbKnight = mRoot.child("p5bKnight");
        final Firebase p5bKnight = p5bbKnight.child("position");
        p5bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5bFKnight = p5bbKnight.child("firstMove");
        p5bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p5bbRook = mRoot.child("p5bRook");
        final Firebase p5bRook = p5bbRook.child("position");
        p5bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5bFRook = p5bbRook.child("firstMove");
        p5bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p6bbQueen = mRoot.child("p6bQueen");
        final Firebase p6bQueen = p6bbQueen.child("position");
        p6bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6bFQueen = p6bbQueen.child("firstMove");
        p6bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p6bbBishop = mRoot.child("p6bBishop");
        final Firebase p6bBishop = p6bbBishop.child("position");
        p6bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6bFBishop = p6bbBishop.child("firstMove");
        p6bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p6bbKnight = mRoot.child("p6bKnight");
        final Firebase p6bKnight = p6bbKnight.child("position");
        p6bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6bFKnight = p6bbKnight.child("firstMove");
        p6bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p6bbRook = mRoot.child("p6bRook");
        final Firebase p6bRook = p6bbRook.child("position");
        p6bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6bFRook = p6bbRook.child("firstMove");
        p6bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p7bbQueen = mRoot.child("p7bQueen");
        final Firebase p7bQueen = p7bbQueen.child("position");
        p7bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7bFQueen = p7bbQueen.child("firstMove");
        p7bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p7bbBishop = mRoot.child("p7bBishop");
        final Firebase p7bBishop = p7bbBishop.child("position");
        p7bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7bFBishop = p7bbBishop.child("firstMove");
        p7bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p7bbKnight = mRoot.child("p7bKnight");
        final Firebase p7bKnight = p7bbKnight.child("position");
        p7bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7bFKnight = p7bbKnight.child("firstMove");
        p7bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p7bbRook = mRoot.child("p7bRook");
        final Firebase p7bRook = p7bbRook.child("position");
        p7bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7bFRook = p7bbRook.child("firstMove");
        p7bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p8bbQueen = mRoot.child("p8bQueen");
        final Firebase p8bQueen = p8bbQueen.child("position");
        p8bQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8bQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8bFQueen = p8bbQueen.child("firstMove");
        p8bFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8bQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8bQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p8bbBishop = mRoot.child("p8bBishop");
        final Firebase p8bBishop = p8bbBishop.child("position");
        p8bBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8bBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8bFBishop = p8bbBishop.child("firstMove");
        p8bFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8bBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8bBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p8bbKnight = mRoot.child("p8bKnight");
        final Firebase p8bKnight = p8bbKnight.child("position");
        p8bKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8bKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8bFKnight = p8bbKnight.child("firstMove");
        p8bFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8bKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8bKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p8bbRook = mRoot.child("p8bRook");
        final Firebase p8bRook = p8bbRook.child("position");
        p8bRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8bRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8bFRook = p8bbRook.child("firstMove");
        p8bFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8bRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8bRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        /////white
        Firebase p1wbQueen = mRoot.child("p1wQueen");
        final Firebase p1wQueen = p1wbQueen.child("position");
        p1wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1wFQueen = p1wbQueen.child("firstMove");
        p1wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p1wbBishop = mRoot.child("p1wBishop");
        final Firebase p1wBishop = p1wbBishop.child("position");
        p1wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1wFBishop = p1wbBishop.child("firstMove");
        p1wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p1wbKnight = mRoot.child("p1wKnight");
        final Firebase p1wKnight = p1wbKnight.child("position");
        p1wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1wFKnight = p1wbKnight.child("firstMove");
        p1wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p1wbRook = mRoot.child("p1wRook");
        final Firebase p1wRook = p1wbRook.child("position");
        p1wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p1wFRook = p1wbRook.child("firstMove");
        p1wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p1wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p1wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p2wbQueen = mRoot.child("p2wQueen");
        final Firebase p2wQueen = p2wbQueen.child("position");
        p2wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2wFQueen = p2wbQueen.child("firstMove");
        p2wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p2wbBishop = mRoot.child("p2wBishop");
        final Firebase p2wBishop = p2wbBishop.child("position");
        p2wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2wFBishop = p2wbBishop.child("firstMove");
        p2wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p2wbKnight = mRoot.child("p2wKnight");
        final Firebase p2wKnight = p2wbKnight.child("position");
        p2wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2wFKnight = p2wbKnight.child("firstMove");
        p2wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p2wbRook = mRoot.child("p2wRook");
        final Firebase p2wRook = p2wbRook.child("position");
        p2wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p2wFRook = p2wbRook.child("firstMove");
        p2wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p2wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p2wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p3wbQueen = mRoot.child("p3wQueen");
        final Firebase p3wQueen = p3wbQueen.child("position");
        p3wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3wFQueen = p3wbQueen.child("firstMove");
        p3wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p3wbBishop = mRoot.child("p3wBishop");
        final Firebase p3wBishop = p3wbBishop.child("position");
        p3wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3wFBishop = p3wbBishop.child("firstMove");
        p3wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p3wbKnight = mRoot.child("p3wKnight");
        final Firebase p3wKnight = p3wbKnight.child("position");
        p3wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3wFKnight = p3wbKnight.child("firstMove");
        p3wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p3wbRook = mRoot.child("p3wRook");
        final Firebase p3wRook = p3wbRook.child("position");
        p3wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p3wFRook = p3wbRook.child("firstMove");
        p3wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p3wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p3wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p4wbQueen = mRoot.child("p4wQueen");
        final Firebase p4wQueen = p4wbQueen.child("position");
        p4wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4wFQueen = p4wbQueen.child("firstMove");
        p4wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p4wbBishop = mRoot.child("p4wBishop");
        final Firebase p4wBishop = p4wbBishop.child("position");
        p4wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4wFBishop = p4wbBishop.child("firstMove");
        p4wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p4wbKnight = mRoot.child("p4wKnight");
        final Firebase p4wKnight = p4wbKnight.child("position");
        p4wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4wFKnight = p4wbKnight.child("firstMove");
        p4wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p4wbRook = mRoot.child("p4wRook");
        final Firebase p4wRook = p4wbRook.child("position");
        p4wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p4wFRook = p4wbRook.child("firstMove");
        p4wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p4wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p4wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p5wbQueen = mRoot.child("p5wQueen");
        final Firebase p5wQueen = p5wbQueen.child("position");
        p5wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5wFQueen = p5wbQueen.child("firstMove");
        p5wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p5wbBishop = mRoot.child("p5wBishop");
        final Firebase p5wBishop = p5wbBishop.child("position");
        p5wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5wFBishop = p5wbBishop.child("firstMove");
        p5wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p5wbKnight = mRoot.child("p5wKnight");
        final Firebase p5wKnight = p5wbKnight.child("position");
        p5wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5wFKnight = p5wbKnight.child("firstMove");
        p5wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p5wbRook = mRoot.child("p5wRook");
        final Firebase p5wRook = p5wbRook.child("position");
        p5wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p5wFRook = p5wbRook.child("firstMove");
        p5wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p5wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p5wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p6wbQueen = mRoot.child("p6wQueen");
        final Firebase p6wQueen = p6wbQueen.child("position");
        p6wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6wFQueen = p6wbQueen.child("firstMove");
        p6wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p6wbBishop = mRoot.child("p6wBishop");
        final Firebase p6wBishop = p6wbBishop.child("position");
        p6wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6wFBishop = p6wbBishop.child("firstMove");
        p6wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p6wbKnight = mRoot.child("p6wKnight");
        final Firebase p6wKnight = p6wbKnight.child("position");
        p6wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6wFKnight = p6wbKnight.child("firstMove");
        p6wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p6wbRook = mRoot.child("p6wRook");
        final Firebase p6wRook = p6wbRook.child("position");
        p6wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p6wFRook = p6wbRook.child("firstMove");
        p6wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p6wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p6wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p7wbQueen = mRoot.child("p7wQueen");
        final Firebase p7wQueen = p7wbQueen.child("position");
        p7wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7wFQueen = p7wbQueen.child("firstMove");
        p7wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p7wbBishop = mRoot.child("p7wBishop");
        final Firebase p7wBishop = p7wbBishop.child("position");
        p7wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7wFBishop = p7wbBishop.child("firstMove");
        p7wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p7wbKnight = mRoot.child("p7wKnight");
        final Firebase p7wKnight = p7wbKnight.child("position");
        p7wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7wFKnight = p7wbKnight.child("firstMove");
        p7wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p7wbRook = mRoot.child("p7wRook");
        final Firebase p7wRook = p7wbRook.child("position");
        p7wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p7wFRook = p7wbRook.child("firstMove");
        p7wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p7wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p7wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        Firebase p8wbQueen = mRoot.child("p8wQueen");
        final Firebase p8wQueen = p8wbQueen.child("position");
        p8wQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8wQueen.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8wFQueen = p8wbQueen.child("firstMove");
        p8wFQueen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8wQueen.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8wQueen.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p8wbBishop = mRoot.child("p8wBishop");
        final Firebase p8wBishop = p8wbBishop.child("position");
        p8wBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8wBishop.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8wFBishop = p8wbBishop.child("firstMove");
        p8wFBishop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8wBishop.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8wBishop.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p8wbKnight = mRoot.child("p8wKnight");
        final Firebase p8wKnight = p8wbKnight.child("position");
        p8wKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8wKnight.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8wFKnight = p8wbKnight.child("firstMove");
        p8wFKnight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8wKnight.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8wKnight.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        Firebase p8wbRook = mRoot.child("p8wRook");
        final Firebase p8wRook = p8wbRook.child("position");
        p8wRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8wRook.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Firebase p8wFRook = p8wbRook.child("firstMove");
        p8wFRook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getKey().equals("firstMove")) {
                    String value = dataSnapshot.getValue().toString();

                    if(value.equals("true")){
                        canvas.p8wRook.firstMove = true;
                    }else if(value.equals("false")){
                        canvas.p8wRook.firstMove = false;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        ////







    }




}
