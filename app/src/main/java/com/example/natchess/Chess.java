package com.example.natchess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

//        die = new Dialog(this);
//        die.setContentView(R.layout.pop);
//        die.setCanceledOnTouchOutside(false);
//        die.show();
////        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                die.dismiss();
//                System.out.println("alec");
//            }
//        });


        mRoot = new Firebase("https://natchess-d50b2.firebaseio.com/Test/");


//        b = findViewById(R.id.rock);

        Firebase p1bb = mRoot.child("p1b");
        final Firebase p1b = p1bb.child("position");
        p1b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1b.position =dataSnapshot.getValue(String.class);
                    if(dataSnapshot.getValue(String.class).equals("A1") || dataSnapshot.getValue(String.class).equals("B1") || dataSnapshot.getValue(String.class).equals("D1")){
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



        Firebase p2bb = mRoot.child("p2b");
        Firebase p2b = p2bb.child("position");
        p2b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2b.position =dataSnapshot.getValue(String.class);
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




        Firebase p3bb = mRoot.child("p3b");
        Firebase p3b = p3bb.child("position");
        p3b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3b.position =dataSnapshot.getValue(String.class);
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




        Firebase p4bb = mRoot.child("p4b");
        Firebase p4b = p4bb.child("position");
        p4b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4b.position =dataSnapshot.getValue(String.class);
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




        Firebase p5bb = mRoot.child("p5b");
        Firebase p5b = p5bb.child("position");
        p5b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5b.position =dataSnapshot.getValue(String.class);
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





        Firebase p6bb = mRoot.child("p6b");
        Firebase p6b = p6bb.child("position");
        p6b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6b.position =dataSnapshot.getValue(String.class);
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





        Firebase p7bb = mRoot.child("p7b");
        Firebase p7b = p7bb.child("position");
        p7b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7b.position =dataSnapshot.getValue(String.class);
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




        Firebase p8bb = mRoot.child("p8b");
        Firebase p8b = p8bb.child("position");
        p8b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8b.position =dataSnapshot.getValue(String.class);
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


        Firebase p2wb = mRoot.child("p2w");
        Firebase p2w = p2wb.child("position");
        p2w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p2w.position =dataSnapshot.getValue(String.class);
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


        Firebase p3wb = mRoot.child("p3w");
        Firebase p3w = p3wb.child("position");
        p3w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p3w.position =dataSnapshot.getValue(String.class);
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

        Firebase p4wb = mRoot.child("p4w");
        Firebase p4w = p4wb.child("position");
        p4w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p4w.position =dataSnapshot.getValue(String.class);
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



        Firebase p5wb = mRoot.child("p5w");
        Firebase p5w = p5wb.child("position");
        p5w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p5w.position =dataSnapshot.getValue(String.class);
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

        Firebase p6wb = mRoot.child("p6w");
        Firebase p6w = p6wb.child("position");
        p6w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p6w.position =dataSnapshot.getValue(String.class);
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



        Firebase p7wb = mRoot.child("p7w");
        Firebase p7w = p7wb.child("position");
        p7w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p7w.position =dataSnapshot.getValue(String.class);
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


        Firebase p8wb = mRoot.child("p8w");
        Firebase p8w = p8wb.child("position");
        p8w.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p8w.position =dataSnapshot.getValue(String.class);
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


    }




}
