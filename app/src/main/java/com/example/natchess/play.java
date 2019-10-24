package com.example.natchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.natchess.views.CustomView;
import com.firebase.client.Firebase;

public class play extends AppCompatActivity {

    private Firebase mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        mRoot = new Firebase("https://natchess-d50b2.firebaseio.com/Test/");

        final CustomView customView = new CustomView(this);

        Button btnReset = findViewById(R.id.btn_reset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//            Firebase mChild = mRoot.child("Name");
//            mChild.setValue("Alec");

                reset();
            }
        });
    }


    private void reset(){
        System.out.println("Alec reset");
        String alive = "alive";
        String first = "true";
        Firebase b1b = mRoot.child("b1b");
        Firebase b1bPosition = b1b.child("position");
        b1bPosition.setValue("C8");
        Firebase b1bStatus = b1b.child("status");
        b1bStatus.setValue(alive);
        Firebase b1bFirst = b1b.child("firstMove");
        b1bFirst.setValue(first);
        Firebase b1w = mRoot.child("b1w");
        Firebase b1wPosition = b1w.child("position");
        b1wPosition.setValue("C1");
        Firebase b1wStatus = b1w.child("status");
        b1wStatus.setValue(alive);
        Firebase b1wFirst = b1w.child("firstMove");
        b1wFirst.setValue(first);
        Firebase b2b = mRoot.child("b2b");
        Firebase b2bPosition = b2b.child("position");
        b2bPosition.setValue("F8");
        Firebase b2bStatus = b2b.child("status");
        b2bStatus.setValue(alive);
        Firebase b2bFirst = b2b.child("firstMove");
        b2bFirst.setValue(first);
        Firebase b2w = mRoot.child("b2w");
        Firebase b2wPosition = b2w.child("position");
        b2wPosition.setValue("F1");
        Firebase b2wStatus = b2w.child("status");
        b2wStatus.setValue(alive);
        Firebase b2wFirst = b2w.child("firstMove");
        b2wFirst.setValue(first);

        Firebase k1b = mRoot.child("k1b");
        Firebase k1bPosition = k1b.child("position");
        k1bPosition.setValue("B8");
        Firebase k1bStatus = k1b.child("status");
        k1bStatus.setValue(alive);
        Firebase k1bFirst = k1b.child("firstMove");
        k1bFirst.setValue(first);
        Firebase k1w = mRoot.child("k1w");
        Firebase k1wPosition = k1w.child("position");
        k1wPosition.setValue("B1");
        Firebase k1wStatus = k1w.child("status");
        k1wStatus.setValue(alive);
        Firebase k1wFirst = k1w.child("firstMove");
        k1wFirst.setValue(first);
        Firebase k2b = mRoot.child("k2b");
        Firebase k2bPosition = k2b.child("position");
        k2bPosition.setValue("G8");
        Firebase k2bStatus = k2b.child("status");
        k2bStatus.setValue(alive);
        Firebase k2bFirst = k2b.child("firstMove");
        k2bFirst.setValue(first);
        Firebase k2w = mRoot.child("k2w");
        Firebase k2wPosition = k2w.child("position");
        k2wPosition.setValue("G1");
        Firebase k2wStatus = k2w.child("status");
        k2wStatus.setValue(alive);
        Firebase k2wFirst = k2w.child("firstMove");
        k2wFirst.setValue(first);

        Firebase r1b = mRoot.child("r1b");
        Firebase r1bPosition = r1b.child("position");
        r1bPosition.setValue("A8");
        Firebase r1bStatus = r1b.child("status");
        r1bStatus.setValue(alive);
        Firebase r1bFirst = r1b.child("firstMove");
        r1bFirst.setValue(first);
        Firebase r1w = mRoot.child("r1w");
        Firebase r1wPosition = r1w.child("position");
        r1wPosition.setValue("A1");
        Firebase r1wStatus = r1w.child("status");
        r1wStatus.setValue(alive);
        Firebase r1wFirst = r1w.child("firstMove");
        r1wFirst.setValue(first);
        Firebase r2b = mRoot.child("r2b");
        Firebase r2bPosition = r2b.child("position");
        r2bPosition.setValue("H8");
        Firebase r2bStatus = r2b.child("status");
        r2bStatus.setValue(alive);
        Firebase r2bFirst = r2b.child("firstMove");
        r2bFirst.setValue(first);
        Firebase r2w = mRoot.child("r2w");
        Firebase r2wPosition = r2w.child("position");
        r2wPosition.setValue("H1");
        Firebase r2wStatus = r2w.child("status");
        r2wStatus.setValue(alive);
        Firebase r2wFirst = r2w.child("firstMove");
        r2wFirst.setValue(first);

        Firebase kb = mRoot.child("kb");
        Firebase kbPosition = kb.child("position");
        kbPosition.setValue("E8");
        Firebase kbStatus = kb.child("status");
        kbStatus.setValue(alive);
        Firebase kbFirst = kb.child("firstMove");
        kbFirst.setValue(first);
        Firebase kw = mRoot.child("kw");
        Firebase kwPosition = kw.child("position");
        kwPosition.setValue("E1");
        Firebase kwStatus = kw.child("status");
        kwStatus.setValue(alive);
        Firebase kwFirst = kw.child("firstMove");
        kwFirst.setValue(first);

        Firebase qb = mRoot.child("qb");
        Firebase qbPosition = qb.child("position");
        qbPosition.setValue("D8");
        Firebase qbStatus = qb.child("status");
        qbStatus.setValue(alive);
        Firebase qbFirst = qb.child("firstMove");
        qbFirst.setValue(first);
        Firebase qw = mRoot.child("qw");
        Firebase qwPosition = qw.child("position");
        qwPosition.setValue("D1");
        Firebase qwStatus = qw.child("status");
        qwStatus.setValue(alive);
        Firebase qwFirst = qw.child("firstMove");
        qwFirst.setValue(first);

        Firebase p1b = mRoot.child("p1b");
        Firebase p1bPosition = p1b.child("position");
        p1bPosition.setValue("A7");
        Firebase p1bStatus = p1b.child("status");
        p1bStatus.setValue(alive);
        Firebase p1bFirst = p1b.child("firstMove");
        p1bFirst.setValue(first);
        Firebase p2b = mRoot.child("p2b");
        Firebase p2bPosition = p2b.child("position");
        p2bPosition.setValue("B7");
        Firebase p2bStatus = p2b.child("status");
        p2bStatus.setValue(alive);
        Firebase p2bFirst = p2b.child("firstMove");
        p2bFirst.setValue(first);
        Firebase p3b = mRoot.child("p3b");
        Firebase p3bPosition = p3b.child("position");
        p3bPosition.setValue("C7");
        Firebase p3bStatus = p3b.child("status");
        p3bStatus.setValue(alive);
        Firebase p3bFirst = p3b.child("firstMove");
        p3bFirst.setValue(first);
        Firebase p4b = mRoot.child("p4b");
        Firebase p4bPosition = p4b.child("position");
        p4bPosition.setValue("D7");
        Firebase p4bStatus = p4b.child("status");
        p4bStatus.setValue(alive);
        Firebase p4bFirst = p4b.child("firstMove");
        p4bFirst.setValue(first);
        Firebase p5b = mRoot.child("p5b");
        Firebase p5bPosition = p5b.child("position");
        p5bPosition.setValue("E7");
        Firebase p5bStatus = p5b.child("status");
        p5bStatus.setValue(alive);
        Firebase p5bFirst = p5b.child("firstMove");
        p5bFirst.setValue(first);
        Firebase p6b = mRoot.child("p6b");
        Firebase p6bPosition = p6b.child("position");
        p6bPosition.setValue("F7");
        Firebase p6bStatus = p6b.child("status");
        p6bStatus.setValue(alive);
        Firebase p6First = p6b.child("firstMove");
        p6First.setValue(first);
        Firebase p7b = mRoot.child("p7b");
        Firebase p7bPosition = p7b.child("position");
        p7bPosition.setValue("G7");
        Firebase p7bStatus = p7b.child("status");
        p7bStatus.setValue(alive);
        Firebase p7bFirst = p7b.child("firstMove");
        p7bFirst.setValue(first);
        Firebase p8b = mRoot.child("p8b");
        Firebase p8bPosition = p8b.child("position");
        p8bPosition.setValue("H7");
        Firebase p8bStatus = p8b.child("status");
        p8bStatus.setValue(alive);
        Firebase p8bFirst = p8b.child("firstMove");
        p8bFirst.setValue(first);

        Firebase p1w = mRoot.child("p1w");
        Firebase p1wPosition = p1w.child("position");
        p1wPosition.setValue("A2");
        Firebase p1wStatus = p1w.child("status");
        p1wStatus.setValue(alive);
        Firebase p1wFirst = p1w.child("firstMove");
        p1wFirst.setValue(first);
        Firebase p2w = mRoot.child("p2w");
        Firebase p2wPosition = p2w.child("position");
        p2wPosition.setValue("B2");
        Firebase p2wStatus = p2w.child("status");
        p2wStatus.setValue(alive);
        Firebase p2wFirst = p2w.child("firstMove");
        p2wFirst.setValue(first);
        Firebase p3w = mRoot.child("p3w");
        Firebase p3wPosition = p3w.child("position");
        p3wPosition.setValue("C2");
        Firebase p3wStatus = p3w.child("status");
        p3wStatus.setValue(alive);
        Firebase p3wFirst = p3w.child("firstMove");
        p3wFirst.setValue(first);
        Firebase p4w = mRoot.child("p4w");
        Firebase p4wPosition = p4w.child("position");
        p4wPosition.setValue("D2");
        Firebase p4wStatus = p4w.child("status");
        p4wStatus.setValue(alive);
        Firebase p4wFirst = p4w.child("firstMove");
        p4wFirst.setValue(first);
        Firebase p5w = mRoot.child("p5w");
        Firebase p5wPosition = p5w.child("position");
        p5wPosition.setValue("E2");
        Firebase p5wStatus = p5w.child("status");
        p5wStatus.setValue(alive);
        Firebase p5wFirst = p5w.child("firstMove");
        p5wFirst.setValue(first);
        Firebase p6w = mRoot.child("p6w");
        Firebase p6wPosition = p6w.child("position");
        p6wPosition.setValue("F2");
        Firebase p6wStatus = p6w.child("status");
        p6wStatus.setValue(alive);
        Firebase p6wFirst = p6w.child("firstMove");
        p6wFirst.setValue(first);
        Firebase p7w = mRoot.child("p7w");
        Firebase p7wPosition = p7w.child("position");
        p7wPosition.setValue("G2");
        Firebase p7wStatus = p7w.child("status");
        p7wStatus.setValue(alive);
        Firebase p7wFirst = p7w.child("firstMove");
        p7wFirst.setValue(first);
        Firebase p8w = mRoot.child("p8w");
        Firebase p8wPosition = p8w.child("position");
        p8wPosition.setValue("H2");
        Firebase p8wStatus = p8w.child("status");
        p8wStatus.setValue(alive);
        Firebase p8wFirst = p8w.child("firstMove");
        p8bFirst.setValue(first);

    }
}
