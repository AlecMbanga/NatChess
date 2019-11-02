package com.example.natchess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.example.natchess.views.Canvas;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Chess extends AppCompatActivity {

    private Firebase mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Canvas canvas = new Canvas(this);
        setContentView(canvas);

        mRoot = new Firebase("https://natchess-d50b2.firebaseio.com/Test/");


        Firebase p1bb = mRoot.child("p1b");
        Firebase p1b = p1bb.child("position");
        p1b.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getKey().equals("position")) {
                    canvas.p1b.position =dataSnapshot.getValue(String.class);
                    canvas.invalidate();
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


    }




}
