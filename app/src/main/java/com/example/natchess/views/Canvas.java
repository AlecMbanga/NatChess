package com.example.natchess.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


import androidx.annotation.Nullable;

import com.example.natchess.Piece;
import com.example.natchess.R;
import com.firebase.client.Firebase;

import java.util.ArrayList;

public class Canvas extends View {


    public Piece p1b;
    public Piece p2b;
    public Piece p3b;
    public Piece p4b;
    public Piece p5b;
    public Piece p6b;
    public Piece p7b;
    public Piece p8b;
    public Piece r1b;
    public Piece r2b;
    public Piece b1b;
    public Piece b2b;
    public Piece k1b;
    public Piece k2b;
    public Piece kb;
    public Piece qb;
    public Piece p1w;
    public Piece p2w;
    public Piece p3w;
    public Piece p4w;
    public Piece p5w;
    public Piece p6w;
    public Piece p7w;
    public Piece p8w;
    public Piece r1w;
    public Piece r2w;
    public Piece b1w;
    public Piece b2w;
    public Piece k1w;
    public Piece k2w;
    public Piece kw;
    public Piece qw;

    private RectF p1Scale;
    private RectF p2Scale;
    private RectF p3Scale;
    private RectF p4Scale;
    private RectF p5Scale;
    private RectF p6Scale;
    private RectF p7Scale;
    private RectF p8Scale;
    private RectF n1Scale;
    private RectF n2Scale;
    private RectF kScale;
    private RectF qScale;
    private RectF r1Scale;
    private RectF r2Scale;
    private RectF b1Scale;
    private RectF b2Scale;
    private RectF p1wScale;
    private RectF p2wScale;
    private RectF p3wScale;
    private RectF p4wScale;
    private RectF p5wScale;
    private RectF p6wScale;
    private RectF p7wScale;
    private RectF p8wScale;
    private RectF n1wScale;
    private RectF n2wScale;
    private RectF kwScale;
    private RectF qwScale;
    private RectF r1wScale;
    private RectF r2wScale;
    private RectF b1wScale;
    private RectF b2wScale;

    private Paint paintPositionBlock;
    private Paint paintPositionText;
    private Paint paintPositionTextDown;


    private boolean selected;
    private Piece selectedPiece;
    private int moveFromR;
    private int moveFromC;
    private int moveToR;
    private int moveToC;
    private ArrayList<String> legalMoves;
    private ArrayList<String> validMoves = new ArrayList<>();

    private RectF resetRect;
    private Firebase mRoot;
    private Paint[][] arrPaint;
    private RectF[][] arrRect;
    private float color[][] = {{0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0}};


    public Canvas(Context context) {
        super(context);
        init(null);
    }

    private void init(@Nullable AttributeSet set){

        mRoot = new Firebase("https://natchess-d50b2.firebaseio.com/Test/");


        //black
        r1b = new Piece("rook","black","null","alive");
        r1b.onlineCodeName = "r1b";
        r2b = new Piece("rook","black","null","alive");
        r2b.onlineCodeName = "r2b";
        k1b = new Piece("Knight","black","null","alive");
        k1b.onlineCodeName = "k1b";
        k2b = new Piece("Knight","black","null","alive");
        k2b.onlineCodeName = "k2b";
        b1b = new Piece("bishop","black","null","alive");
        b1b.onlineCodeName = "b1b";
        b2b = new Piece("bishop","black","null","alive");
        b2b.onlineCodeName = "b2b";
        qb = new Piece("queen","black","null","alive");
        qb.onlineCodeName = "qb";
        kb = new Piece("king","black","null","alive");
        kb.onlineCodeName = "kb";
        p1b = new Piece("pawn","black","null","alive");
        p1b.onlineCodeName = "p1b";
        p2b = new Piece("pawn","black","null","alive");
        p2b.onlineCodeName = "p2b";
        p3b = new Piece("pawn","black","null","alive");
        p3b.onlineCodeName = "p3b";
        p4b = new Piece("pawn","black","null","alive");
        p4b.onlineCodeName = "p4b";
        p5b = new Piece("pawn","black","null","alive");
        p5b.onlineCodeName = "p5b";
        p6b = new Piece("pawn","black","null","alive");
        p6b.onlineCodeName = "p6b";
        p7b = new Piece("pawn","black","null","alive");
        p7b.onlineCodeName = "p7b";
        p8b = new Piece("pawn","black","null","alive");
        p8b.onlineCodeName = "p8b";

        //white
        r1w = new Piece("rook","white","null","alive");
        r1w.onlineCodeName = "r1w";

        r2w = new Piece("rook","white","null","alive");
        r2w.onlineCodeName = "r2w";

        k1w = new Piece("Knight","white","null","alive");
        k1w.onlineCodeName ="k1w";

        k2w = new Piece("Knight","white","null","alive");
        k2w.onlineCodeName = "k2w";

        b1w = new Piece("bishop","white","null","alive");
        b1w.onlineCodeName ="b1w";

        b2w = new Piece("bishop","white","null","alive");
        b2w.onlineCodeName = "b2w";

        qw = new Piece("queen","white","null","alive");
        qw.onlineCodeName ="qw";

        kw = new Piece("king","white","null","alive");
        kw.onlineCodeName = "kw";

        p1w = new Piece("pawn","white","null","alive");
        p1w.onlineCodeName = "p1w";

        p2w = new Piece("pawn","white","null","alive");
        p2w.onlineCodeName = "p2w";

        p3w = new Piece("pawn","white","null","alive");
        p3w.onlineCodeName = "p3w";

        p4w = new Piece("pawn","white","null","alive");
        p4w.onlineCodeName = "p4w";

        p5w = new Piece("pawn","white","null","alive");
        p5w.onlineCodeName = "p5w";

        p6w = new Piece("pawn","white","null","alive");
        p6w.onlineCodeName = "p6w";

        p7w = new Piece("pawn","white","null","alive");
        p7w.onlineCodeName = "p7w";

        p8w = new Piece("pawn","white","null","alive");
        p8w.onlineCodeName = "p8w";

        InitialiseBoardColors();

    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);

        DrawChessBoard(canvas);
        DrawChessPiece(canvas);

        resetRect = new RectF();
        resetRect.left = canvas.getWidth()/3;
        resetRect.right = (canvas.getWidth()/3)+(canvas.getHeight()/9);
        resetRect.top = (canvas.getHeight()/3) + (canvas.getHeight()/3) + (canvas.getHeight()/9);
        resetRect.bottom = (canvas.getHeight()/3) + (canvas.getHeight()/3) + (canvas.getHeight()/9) + (canvas.getHeight()/9);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawRect(resetRect,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        boolean contains = false;
        int rSelected = 0;
        int cSelected = 0;
        if(arrRect[0][0].contains(event.getX(), event.getY())) {
            paintMove(0, 0, "A8", rSelected, cSelected, contains);

        }else if (arrRect[0][1].contains(event.getX(), event.getY())) {
            paintMove(0, 1, "B8", rSelected, cSelected, contains);

        }else if (arrRect[0][2].contains(event.getX(), event.getY())) {
            paintMove(0, 2, "C8", rSelected, cSelected, contains);

        }else if (arrRect[0][3].contains(event.getX(), event.getY())) {
            paintMove(0, 3, "D8", rSelected, cSelected, contains);

        }else if (arrRect[0][4].contains(event.getX(), event.getY())) {
            paintMove(0, 4, "E8", rSelected, cSelected, contains);

        }else if (arrRect[0][5].contains(event.getX(), event.getY())) {
            paintMove(0, 5, "F8", rSelected, cSelected, contains);

        }else if (arrRect[0][6].contains(event.getX(), event.getY())) {
            paintMove(0, 6, "G8", rSelected, cSelected, contains);

        }else if (arrRect[0][7].contains(event.getX(), event.getY())) {
            paintMove(0, 7, "H8", rSelected, cSelected, contains);

        }else if(arrRect[1][0].contains(event.getX(),event.getY())){
            paintMove(1, 0, "A7", rSelected, cSelected, contains);

        }else if(arrRect[1][1].contains(event.getX(),event.getY())){
            paintMove(1, 1, "B7", rSelected, cSelected, contains);

        }else if(arrRect[1][2].contains(event.getX(),event.getY())){
            paintMove(1, 2, "C7", rSelected, cSelected, contains);

        }else if(arrRect[1][3].contains(event.getX(),event.getY())){
            paintMove(1, 3, "D7", rSelected, cSelected, contains);

        }else if(arrRect[1][4].contains(event.getX(),event.getY())){
            paintMove(1, 4, "E7", rSelected, cSelected, contains);

        }else if(arrRect[1][5].contains(event.getX(),event.getY())){
            paintMove(1, 5, "F7", rSelected, cSelected, contains);

        }else if(arrRect[1][6].contains(event.getX(),event.getY())){
            paintMove(1, 6, "G7", rSelected, cSelected, contains);

        }else if(arrRect[1][7].contains(event.getX(),event.getY())){
            paintMove(1, 7, "H7", rSelected, cSelected, contains);

        }else if(arrRect[2][0].contains(event.getX(),event.getY())) {
            paintMove(2, 0, "A6", rSelected, cSelected, contains);

        }
        else if(arrRect[2][1].contains(event.getX(),event.getY())){
            paintMove(2,1,"B6",rSelected,cSelected, contains);

        }
        else if(arrRect[2][2].contains(event.getX(),event.getY())){
            paintMove(2,2,"C6",rSelected,cSelected, contains);

        }
        else if(arrRect[2][3].contains(event.getX(),event.getY())){
            paintMove(2,3,"D6",rSelected,cSelected, contains);

        }
        else if(arrRect[2][4].contains(event.getX(),event.getY())){
            paintMove(2,4,"E6",rSelected,cSelected, contains);

        }
        else if(arrRect[2][5].contains(event.getX(),event.getY())){
            paintMove(2,5,"F6",rSelected,cSelected, contains);

        }
        else if(arrRect[2][6].contains(event.getX(),event.getY())){
            paintMove(2,6,"G6",rSelected,cSelected, contains);

        }else if(arrRect[2][7].contains(event.getX(),event.getY())){
            paintMove(2,7,"H6",rSelected,cSelected, contains);

        }else if(arrRect[3][0].contains(event.getX(),event.getY())) {
            paintMove(3, 0, "A5", rSelected, cSelected, contains);

        }
        else if(arrRect[3][1].contains(event.getX(),event.getY())){
            paintMove(3,1,"B5",rSelected,cSelected, contains);

        }
        else if(arrRect[3][2].contains(event.getX(),event.getY())){
            paintMove(3,2,"C5",rSelected,cSelected, contains);

        }
        else if(arrRect[3][3].contains(event.getX(),event.getY())){
            paintMove(3,3,"D5",rSelected,cSelected, contains);

        }
        else if(arrRect[3][4].contains(event.getX(),event.getY())){
            paintMove(3,4,"E5",rSelected,cSelected, contains);

        }
        else if(arrRect[3][5].contains(event.getX(),event.getY())){
            paintMove(3,5,"F5",rSelected,cSelected, contains);

        }
        else if(arrRect[3][6].contains(event.getX(),event.getY())){
            paintMove(3,6,"G5",rSelected,cSelected, contains);

        }else if(arrRect[3][7].contains(event.getX(),event.getY())){
            paintMove(3,7,"H5",rSelected,cSelected, contains);

        }else if(arrRect[4][0].contains(event.getX(),event.getY())) {
            paintMove(4, 0, "A4", rSelected, cSelected, contains);

        }
        else if(arrRect[4][1].contains(event.getX(),event.getY())){
            paintMove(4,1,"B4",rSelected,cSelected, contains);

        }
        else if(arrRect[4][2].contains(event.getX(),event.getY())){
            paintMove(4,2,"C4",rSelected,cSelected, contains);

        }
        else if(arrRect[4][3].contains(event.getX(),event.getY())){
            paintMove(4,3,"D4",rSelected,cSelected, contains);

        }
        else if(arrRect[4][4].contains(event.getX(),event.getY())){
            paintMove(4,4,"E4",rSelected,cSelected, contains);

        }
        else if(arrRect[4][5].contains(event.getX(),event.getY())){
            paintMove(4,5,"F4",rSelected,cSelected, contains);

        }
        else if(arrRect[4][6].contains(event.getX(),event.getY())){
            paintMove(4,6,"G4",rSelected,cSelected, contains);

        }else if(arrRect[4][7].contains(event.getX(),event.getY())){
            paintMove(4,7,"H4",rSelected,cSelected, contains);

        }else if(arrRect[5][0].contains(event.getX(),event.getY())) {
            paintMove(5, 0, "A3", rSelected, cSelected, contains);

        }
        else if(arrRect[5][1].contains(event.getX(),event.getY())){
            paintMove(5,1,"B3",rSelected,cSelected, contains);

        }
        else if(arrRect[5][2].contains(event.getX(),event.getY())){
            paintMove(5,2,"C3",rSelected,cSelected, contains);

        }
        else if(arrRect[5][3].contains(event.getX(),event.getY())){
            paintMove(5,3,"D3",rSelected,cSelected, contains);

        }
        else if(arrRect[5][4].contains(event.getX(),event.getY())){
            paintMove(5,4,"E3",rSelected,cSelected, contains);

        }
        else if(arrRect[5][5].contains(event.getX(),event.getY())){
            paintMove(5,5,"F3",rSelected,cSelected, contains);

        }
        else if(arrRect[5][6].contains(event.getX(),event.getY())){
            paintMove(5,6,"G3",rSelected,cSelected, contains);

        }else if(arrRect[5][7].contains(event.getX(),event.getY())){
            paintMove(5,7,"H3",rSelected,cSelected, contains);

        }
        else if(arrRect[6][0].contains(event.getX(),event.getY())) {
            paintMove(6, 0, "A2", rSelected, cSelected, contains);

        }
        else if(arrRect[6][1].contains(event.getX(),event.getY())){
            paintMove(6,1,"B2",rSelected,cSelected, contains);

        }
        else if(arrRect[6][2].contains(event.getX(),event.getY())){
            paintMove(6,2,"C2",rSelected,cSelected, contains);

        }
        else if(arrRect[6][3].contains(event.getX(),event.getY())){
            paintMove(6,3,"D2",rSelected,cSelected, contains);

        }
        else if(arrRect[6][4].contains(event.getX(),event.getY())){
            paintMove(6,4,"E2",rSelected,cSelected, contains);

        }
        else if(arrRect[6][5].contains(event.getX(),event.getY())){
            paintMove(6,5,"F2",rSelected,cSelected, contains);

        }
        else if(arrRect[6][6].contains(event.getX(),event.getY())){
            paintMove(6,6,"G2",rSelected,cSelected, contains);

        }else if(arrRect[6][7].contains(event.getX(),event.getY())){
            paintMove(6,7,"H2",rSelected,cSelected, contains);

        }else if(arrRect[7][0].contains(event.getX(),event.getY())) {
            paintMove(7, 0, "A1", rSelected, cSelected, contains);

        }
        else if(arrRect[7][1].contains(event.getX(),event.getY())){
            paintMove(7,1,"B1",rSelected,cSelected, contains);

        }
        else if(arrRect[7][2].contains(event.getX(),event.getY())){
            paintMove(7,2,"C1",rSelected,cSelected, contains);

        }
        else if(arrRect[7][3].contains(event.getX(),event.getY())){
            paintMove(7,3,"D1",rSelected,cSelected, contains);

        }
        else if(arrRect[7][4].contains(event.getX(),event.getY())){
            paintMove(7,4,"E1",rSelected,cSelected, contains);

        }
        else if(arrRect[7][5].contains(event.getX(),event.getY())){
            paintMove(7,5,"F1",rSelected,cSelected, contains);

        }
        else if(arrRect[7][6].contains(event.getX(),event.getY())){
            paintMove(7,6,"G1",rSelected,cSelected, contains);

        }else if(arrRect[7][7].contains(event.getX(),event.getY())){
            paintMove(7,7,"H1",rSelected,cSelected, contains);

        }









        if(resetRect.contains(event.getX(), event.getY())) {

            mRoot.child("p1b").child("position").setValue("A7");
            mRoot.child("p1b").child("firstMove").setValue("true");
            mRoot.child("p2b").child("position").setValue("B7");
            mRoot.child("p2b").child("firstMove").setValue("true");
            mRoot.child("p3b").child("position").setValue("C7");
            mRoot.child("p3b").child("firstMove").setValue("true");
            mRoot.child("p4b").child("position").setValue("D7");
            mRoot.child("p4b").child("firstMove").setValue("true");
            mRoot.child("p5b").child("position").setValue("E7");
            mRoot.child("p5b").child("firstMove").setValue("true");
            mRoot.child("p6b").child("position").setValue("F7");
            mRoot.child("p6b").child("firstMove").setValue("true");
            mRoot.child("p7b").child("position").setValue("G7");
            mRoot.child("p7b").child("firstMove").setValue("true");
            mRoot.child("p8b").child("position").setValue("H7");
            mRoot.child("p8b").child("firstMove").setValue("true");

            mRoot.child("r1b").child("position").setValue("A8");
            mRoot.child("r1b").child("firstMove").setValue("true");
            mRoot.child("r2b").child("position").setValue("H8");
            mRoot.child("r2b").child("firstMove").setValue("true");
            mRoot.child("k1b").child("position").setValue("B8");
            mRoot.child("k1b").child("firstMove").setValue("true");
            mRoot.child("k2b").child("position").setValue("G8");
            mRoot.child("k2b").child("firstMove").setValue("true");
            mRoot.child("b1b").child("position").setValue("C8");
            mRoot.child("b1b").child("firstMove").setValue("true");
            mRoot.child("b2b").child("position").setValue("F8");
            mRoot.child("b2b").child("firstMove").setValue("true");
            mRoot.child("qb").child("position").setValue("D8");
            mRoot.child("qb").child("firstMove").setValue("true");
            mRoot.child("kb").child("position").setValue("E8");
            mRoot.child("kb").child("firstMove").setValue("true");

            mRoot.child("r1w").child("position").setValue("A1");
            mRoot.child("r1w").child("firstMove").setValue("true");
            mRoot.child("r2w").child("position").setValue("H1");
            mRoot.child("r2w").child("firstMove").setValue("true");
            mRoot.child("k1w").child("position").setValue("B1");
            mRoot.child("k1w").child("firstMove").setValue("true");
            mRoot.child("k2w").child("position").setValue("G1");
            mRoot.child("k2w").child("firstMove").setValue("true");
            mRoot.child("b1w").child("position").setValue("C1");
            mRoot.child("b1w").child("firstMove").setValue("true");
            mRoot.child("b2w").child("position").setValue("F1");
            mRoot.child("b2w").child("firstMove").setValue("true");
            mRoot.child("qw").child("position").setValue("D1");
            mRoot.child("qw").child("firstMove").setValue("true");
            mRoot.child("kw").child("position").setValue("E1");
            mRoot.child("kw").child("firstMove").setValue("true");


            mRoot.child("p1w").child("position").setValue("A2");
            mRoot.child("p1w").child("firstMove").setValue("true");
            mRoot.child("p2w").child("position").setValue("B2");
            mRoot.child("p2w").child("firstMove").setValue("true");
            mRoot.child("p3w").child("position").setValue("C2");
            mRoot.child("p3w").child("firstMove").setValue("true");
            mRoot.child("p4w").child("position").setValue("D2");
            mRoot.child("p4w").child("firstMove").setValue("true");
            mRoot.child("p5w").child("position").setValue("E2");
            mRoot.child("p5w").child("firstMove").setValue("true");
            mRoot.child("p6w").child("position").setValue("F2");
            mRoot.child("p6w").child("firstMove").setValue("true");
            mRoot.child("p7w").child("position").setValue("G2");
            mRoot.child("p7w").child("firstMove").setValue("true");
            mRoot.child("p8w").child("position").setValue("H2");
            mRoot.child("p8w").child("firstMove").setValue("true");

            moveFromR = -1;
            moveFromC = -1;
            moveToR = -1;
            moveToC = -1;

            selected = false;

            validMoves = new ArrayList<>();

            InitialiseBoardColors();


            System.out.println("Alec ayep reset yout shit");
        }

        return value;
    }

    private void DrawChessPiece(android.graphics.Canvas canvas) {

        //black chess pieces
        Bitmap bpawn = BitmapFactory.decodeResource(getResources(), R.mipmap.pb);
        Bitmap brook = BitmapFactory.decodeResource(getResources(), R.mipmap.rb);
        Bitmap bnight = BitmapFactory.decodeResource(getResources(), R.mipmap.nb);
        Bitmap bbishop = BitmapFactory.decodeResource(getResources(), R.mipmap.bb);
        Bitmap bqueen = BitmapFactory.decodeResource(getResources(), R.mipmap.qb);
        Bitmap bking = BitmapFactory.decodeResource(getResources(), R.mipmap.kb);

        //white chess pieces
        Bitmap wpawn = BitmapFactory.decodeResource(getResources(), R.mipmap.pw);
        Bitmap wrook = BitmapFactory.decodeResource(getResources(), R.mipmap.rw);
        Bitmap wnight = BitmapFactory.decodeResource(getResources(), R.mipmap.nw);
        Bitmap wbishop = BitmapFactory.decodeResource(getResources(), R.mipmap.bw);
        Bitmap wqueen = BitmapFactory.decodeResource(getResources(), R.mipmap.qw);
        Bitmap wking = BitmapFactory.decodeResource(getResources(), R.mipmap.kw);


        Bitmap border = BitmapFactory.decodeResource(getResources(), R.mipmap.border);
        for(int i=0;i<validMoves.size();++i){
            float[] PositionBorder = post(validMoves.get(i),canvas);
            if(PositionBorder != null){
                RectF r = new RectF(PositionBorder[0],PositionBorder[1],PositionBorder[2],PositionBorder[3]);
                canvas.drawBitmap(border,null,r,null);
            }
        }



        float[] Positionp1 = post(p1b.position,canvas);
        if(Positionp1 != null){
            p1Scale = new RectF(Positionp1[0],Positionp1[1],Positionp1[2],Positionp1[3]);
            canvas.drawBitmap(bpawn,null,p1Scale,null);
        }

        float[] Positionp2 = post(p2b.position,canvas);
        if(Positionp2 != null){
            p2Scale = new RectF(Positionp2[0],Positionp2[1],Positionp2[2],Positionp2[3]);
            canvas.drawBitmap(bpawn,null,p2Scale,null);
        }

        float[] Positionp3 = post(p3b.position,canvas);
        if(Positionp3 != null){
            p3Scale = new RectF(Positionp3[0],Positionp3[1],Positionp3[2],Positionp3[3]);
            canvas.drawBitmap(bpawn,null,p3Scale,null);
        }


        float[] Positionp4 = post(p4b.position,canvas);
        if(Positionp4!=null){
            p4Scale = new RectF(Positionp4[0],Positionp4[1],Positionp4[2],Positionp4[3]);
            canvas.drawBitmap(bpawn,null,p4Scale,null);
        }

        float[] Positionp5 = post(p5b.position,canvas);
        if(Positionp5!=null){
            p5Scale = new RectF(Positionp5[0],Positionp5[1],Positionp5[2],Positionp5[3]);
            canvas.drawBitmap(bpawn,null,p5Scale,null);
        }


        float[] Positionp6 = post(p6b.position,canvas);
        if(Positionp6!=null){
            p6Scale = new RectF(Positionp6[0],Positionp6[1],Positionp6[2],Positionp6[3]);
            canvas.drawBitmap(bpawn,null,p6Scale,null);
        }


        float[] Positionp7 = post(p7b.position,canvas);
        if(Positionp7!=null){
            p7Scale = new RectF(Positionp7[0],Positionp7[1],Positionp7[2],Positionp7[3]);
            canvas.drawBitmap(bpawn,null,p7Scale,null);
        }


        float[] Positionp8 = post(p8b.position,canvas);
        if(Positionp8!=null){
            p8Scale = new RectF(Positionp8[0],Positionp8[1],Positionp8[2],Positionp8[3]);
            canvas.drawBitmap(bpawn,null,p8Scale,null);
        }

        float[] Positionr1 = post(r1b.position,canvas);
        if(Positionr1!=null){
            r1Scale = new RectF(Positionr1[0],Positionr1[1],Positionr1[2],Positionr1[3]);
            canvas.drawBitmap(brook,null,r1Scale,null);
        }

        float[] Positionr2 = post(r2b.position,canvas);
        if(Positionr2!=null){
            r2Scale = new RectF(Positionr2[0],Positionr2[1],Positionr2[2],Positionr2[3]);
            canvas.drawBitmap(brook,null,r2Scale,null);
        }


        float[] Positionn1 = post(k1b.position,canvas);
        if(Positionn1!=null){
            n1Scale = new RectF(Positionn1[0],Positionn1[1],Positionn1[2],Positionn1[3]);
            canvas.drawBitmap(bnight,null,n1Scale,null);
        }

        float[] Positionn2 = post(k2b.position,canvas);
        if(Positionn2!=null){
            n2Scale = new RectF(Positionn2[0],Positionn2[1],Positionn2[2],Positionn2[3]);
            canvas.drawBitmap(bnight,null,n2Scale,null);
        }


        float[] Positionb2 = post(b1b.position,canvas);
        if(Positionb2!=null){
            b2Scale = new RectF(Positionb2[0],Positionb2[1],Positionb2[2],Positionb2[3]);
            canvas.drawBitmap(bbishop,null,b2Scale,null);
        }


        float[] Positionb1 = post(b2b.position,canvas);
        if(Positionb1!=null){
            b1Scale = new RectF(Positionb1[0],Positionb1[1],Positionb1[2],Positionb1[3]);
            canvas.drawBitmap(bbishop,null,b1Scale,null);
        }

        float[] Positionq = post(qb.position,canvas);
        if(Positionq!=null){
            qScale = new RectF(Positionq[0],Positionq[1],Positionq[2],Positionq[3]);
            canvas.drawBitmap(bqueen,null,qScale,null);
        }


        float[] Positionk = post(kb.position,canvas);
        if(Positionk!=null){
            kScale = new RectF(Positionk[0],Positionk[1],Positionk[2],Positionk[3]);
            canvas.drawBitmap(bking,null,kScale,null);
        }





        //draw all white pieces
        float[] Positionp1w = post(p1w.position,canvas);
        if(Positionp1w!=null){
            p1wScale = new RectF(Positionp1w[0],Positionp1w[1],Positionp1w[2],Positionp1w[3]);
            canvas.drawBitmap(wpawn,null,p1wScale,null);
        }


        float[] Positionp2w = post(p2w.position,canvas);
        if(Positionp2w!=null){
            p2wScale = new RectF(Positionp2w[0],Positionp2w[1],Positionp2w[2],Positionp2w[3]);
            canvas.drawBitmap(wpawn,null,p2wScale,null);

        }

        float[] Positionp3w = post(p3w.position,canvas);
        if(Positionp3w!=null){
            p3wScale = new RectF(Positionp3w[0],Positionp3w[1],Positionp3w[2],Positionp3w[3]);
            canvas.drawBitmap(wpawn,null,p3wScale,null);
        }


        float[] Positionp4w = post(p4w.position,canvas);
        if(Positionp4w!=null){
            p4wScale = new RectF(Positionp4w[0],Positionp4w[1],Positionp4w[2],Positionp4w[3]);
            canvas.drawBitmap(wpawn,null,p4wScale,null);
        }


        float[] Positionp5w = post(p5w.position,canvas);
        if(Positionp5w!=null){
            p5wScale = new RectF(Positionp5w[0],Positionp5w[1],Positionp5w[2],Positionp5w[3]);
            canvas.drawBitmap(wpawn,null,p5wScale,null);
        }

        float[] Positionp6w = post(p6w.position,canvas);
        if(Positionp6w!=null){
            p6wScale = new RectF(Positionp6w[0],Positionp6w[1],Positionp6w[2],Positionp6w[3]);
            canvas.drawBitmap(wpawn,null,p6wScale,null);
        }


        float[] Positionp7w = post(p7w.position,canvas);
        if(Positionp7w!=null){
            p7wScale = new RectF(Positionp7w[0],Positionp7w[1],Positionp7w[2],Positionp7w[3]);
            canvas.drawBitmap(wpawn,null,p7wScale,null);
        }


        float[] Positionp8w = post(p8w.position,canvas);
        if(Positionp8w!=null){
            p8wScale = new RectF(Positionp8w[0],Positionp8w[1],Positionp8w[2],Positionp8w[3]);
            canvas.drawBitmap(wpawn,null,p8wScale,null);
        }


        float[] Positionr1w = post(r1w.position,canvas);
        if(Positionr1w!=null){
            r1wScale = new RectF(Positionr1w[0],Positionr1w[1],Positionr1w[2],Positionr1w[3]);
            canvas.drawBitmap(wrook,null,r1wScale,null);
        }


        float[] Positionr2w = post(r2w.position,canvas);
        if(Positionr2w!=null){
            r2wScale = new RectF(Positionr2w[0],Positionr2w[1],Positionr2w[2],Positionr2w[3]);
            canvas.drawBitmap(wrook,null,r2wScale,null);
        }


        float[] Positionn1w = post(k1w.position,canvas);
        if(Positionn1w!=null){
            n1wScale = new RectF(Positionn1w[0],Positionn1w[1],Positionn1w[2],Positionn1w[3]);
            canvas.drawBitmap(wnight,null,n1wScale,null);
        }


        float[] Positionn2w = post(k2w.position,canvas);
        if(Positionn2w!=null){
            n2wScale = new RectF(Positionn2w[0],Positionn2w[1],Positionn2w[2],Positionn2w[3]);
            canvas.drawBitmap(wnight,null,n2wScale,null);
        }


        float[] Positionb2w = post(b1w.position,canvas);
        if(Positionb2w!=null){
            b2wScale = new RectF(Positionb2w[0],Positionb2w[1],Positionb2w[2],Positionb2w[3]);
            canvas.drawBitmap(wbishop,null,b2wScale,null);
        }


        float[] Positionb1w = post(b2w.position,canvas);
        if(Positionb1w!=null){
            b1wScale = new RectF(Positionb1w[0],Positionb1w[1],Positionb1w[2],Positionb1w[3]);
            canvas.drawBitmap(wbishop,null,b1wScale,null);
        }


        float[] Positionqw = post(qw.position,canvas);
        if(Positionqw!=null){
            qwScale = new RectF(Positionqw[0],Positionqw[1],Positionqw[2],Positionqw[3]);
            canvas.drawBitmap(wqueen,null,qwScale,null);
        }


        float[] Positionkw = post(kw.position,canvas);
        if(Positionkw!=null){
            kwScale = new RectF(Positionkw[0],Positionkw[1],Positionkw[2],Positionkw[3]);
            canvas.drawBitmap(wking,null,kwScale,null);
        }

    }



    private void DrawChessBoard(android.graphics.Canvas canvas){
        arrRect = new RectF[8][8];

        float sideH = (canvas.getWidth()/8)/4;
        float sideW = (((canvas.getHeight()/3) + (canvas.getHeight()/3))/8)/4;


        float height = ((canvas.getHeight()/3) + (canvas.getHeight()/3))-sideW;
        float width = canvas.getWidth()-sideH;

        float topAdd = height/8;
        float bottomAdd = height/8;
        float leftAdd = width/8;
        float rightAdd = width/8;

        float sideHTo = ((height/8)/2);
        float sideHToAdd = ((height/8)/2)*2;

        float sideWto = ((width/8)/2)+sideH;
        float sideWtoAdd = ((width/8)/2)*2;

        paintPositionText.setTextSize(sideH);
        paintPositionTextDown.setTextSize(sideW);

        String[] arr = {"A","B","C","D","E","F","G","H"};

        float top = 0;
        float bottom = height/8;

        for(int r=0;r<8;++r){
            float right = width/8+sideH;
            float left = sideH;
            for(int c=0;c<8;++c){

                if(r==0){
                    //draw down horizontal index position
                    canvas.drawRect(left, (height/8)*8, right, ((height/8)*8)+sideW, paintPositionBlock);
                    canvas.drawText(arr[c], sideWto, ((height/8)*8)+sideW ,paintPositionTextDown);
                    sideWto +=sideWtoAdd;
                }
                RectF rect = new RectF(left,top,right,bottom);
                arrRect[r][c] = rect;
                if(color[r][c]==0){
                    canvas.drawRect(rect,arrPaint[r][c]);
                }else {
                    canvas.drawRect(rect,arrPaint[r][c]);
                }
                left+=leftAdd;
                right+=rightAdd;
            }

            //draw left vertical index positions
            canvas.drawRect(0, top, sideH, bottom, paintPositionBlock);
            canvas.drawText(Integer.toString(8-r), sideH/2, sideHTo,paintPositionText);

            sideHTo += sideHToAdd;

            bottom+=bottomAdd;
            top+=topAdd;
        }

    }

    private void InitialiseBoardColors(){

        paintPositionBlock = new Paint();
        paintPositionBlock.setColor(Color.BLACK);
        paintPositionBlock.setStyle(Paint.Style.FILL);
        paintPositionText= new Paint();
        paintPositionText.setColor(Color.WHITE);
        paintPositionText.setTextAlign(Paint.Align.CENTER);
        paintPositionTextDown= new Paint();
        paintPositionTextDown.setColor(Color.WHITE);
        paintPositionTextDown.setTextAlign(Paint.Align.CENTER);


        arrPaint = new Paint[8][8];
        for(int row=0;row<8;++row){
            for(int col=0;col<8;++col){
                if(color[row][col]==0){
                    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paint1.setColor(Color.rgb(236,217,121));
                    arrPaint[row][col] = paint1;
                }else{
                    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paint2.setColor(Color.rgb(215,162,109));
                    arrPaint[row][col] = paint2;
                }
            }
        }

    }



    public void paintMove(int pr, int pc, String p,int rs, int cs, boolean cont){
        //extracting info of clicked piece

        Piece[][] allPieces = new Piece[4][8];

        allPieces[0][0] = r1b;
        allPieces[0][1] = k1b;
        allPieces[0][2] = b1b;
        allPieces[0][3] = qb;
        allPieces[0][4] = kb;
        allPieces[0][5] = b2b;
        allPieces[0][6] = k2b;
        allPieces[0][7] = r2b;
        allPieces[1][0] = p1b;
        allPieces[1][1] = p2b;
        allPieces[1][2] = p3b;
        allPieces[1][3] = p4b;
        allPieces[1][4] = p5b;
        allPieces[1][5] = p6b;
        allPieces[1][6] = p7b;
        allPieces[1][7] = p8b;

        allPieces[3][0] = r1w;
        allPieces[3][1] = k1w;
        allPieces[3][2] = b1w;
        allPieces[3][3] = qw;
        allPieces[3][4] = kw;
        allPieces[3][5] = b2w;
        allPieces[3][6] = k2w;
        allPieces[3][7] = r2w;
        allPieces[2][0] = p1w;
        allPieces[2][1] = p2w;
        allPieces[2][2] = p3w;
        allPieces[2][3] = p4w;
        allPieces[2][4] = p5w;
        allPieces[2][5] = p6w;
        allPieces[2][6] = p7w;
        allPieces[2][7] = p8w;



        for(int r = 0;r<allPieces.length;++r){
            for(int c = 0;c<allPieces[0].length;++c){
                if(cont) break;
                if(allPieces[r][c].position.equals(p)){
                    cont = true;
                    System.out.println("Alec this block contains a "+ allPieces[r][c].color + " " + allPieces[r][c].name);
                    rs = r;
                    cs = c;
                }
            }
            if(cont) break;
        }

        if (selected == false) {
            if(cont) {
                if (moveToR != -1 && moveToC != -1 && moveFromC != -1 && moveFromR != -1) {
                    if (color[moveFromR][moveFromC] == 0) {
                        arrPaint[moveFromR][moveFromC].setColor(Color.rgb(236, 217, 121));
                    } else {
                        arrPaint[moveFromR][moveFromC].setColor(Color.rgb(215, 162, 109));
                    }

                    if (color[moveToR][moveToC] == 0) {
                        arrPaint[moveToR][moveToC].setColor(Color.rgb(236, 217, 121));
                    } else {
                        arrPaint[moveToR][moveToC].setColor(Color.rgb(215, 162, 109));
                    }
                    moveFromR = -1;
                    moveFromC = -1;
                    moveToR = -1;
                    moveToC = -1;
                    System.out.println("Alec clear grey color of previous move");
                }
                selected = true;
                selectedPiece = allPieces[rs][cs];
                validMoves = selectedPiece.CalculateLegalMoves(allPieces);
                System.out.println();
                for (int i=0;i<validMoves.size();++i) {
                    System.out.print(validMoves.get(i)+", ");
                    int[] selectedPieceIndex = getIndex(validMoves.get(i));
                    arrPaint[selectedPieceIndex[0]][selectedPieceIndex[1]].setColor(Color.rgb(128,128,0));
                }

                System.out.println();
                moveFromR = pr;
                moveFromC = pc;
                arrPaint[pr][pc].setColor(Color.GRAY);
                System.out.println("Alec now color this to grey, its clicked");
                invalidate();
            }
        } else if (selectedPiece.position.equals(p)) {
            selected = false;
            selectedPiece = null;
            moveFromC = -1;
            moveFromR = -1;
            if (color[pr][pc] == 0) {
                arrPaint[pr][pc].setColor(Color.rgb(236, 217, 121));
            } else {
                arrPaint[pr][pc].setColor(Color.rgb(215, 162, 109));
            }
            for (int i=0;i<validMoves.size();++i) {
                int[] selectedPieceIndex = getIndex(validMoves.get(i));
                System.out.println("Alec trying trying");
                if (color[selectedPieceIndex[0]][selectedPieceIndex[1]] == 0) {
                    System.out.println("Alec trying change 1");
                    arrPaint[selectedPieceIndex[0]][selectedPieceIndex[1]].setColor(Color.rgb(236, 217, 121));
                } else {
                    System.out.println("Alec trying changed 2");
                    arrPaint[selectedPieceIndex[0]][selectedPieceIndex[1]].setColor(Color.rgb(215, 162, 109));
                }
            }

            validMoves = new ArrayList<>();

            System.out.println("Alec now change back to normal block color, its unclicked");
            invalidate();
        } else if(selected == true){

            for (int i=0;i<validMoves.size();++i) {
                int[] selectedPieceIndex = getIndex(validMoves.get(i));
                if (color[selectedPieceIndex[0]][selectedPieceIndex[1]] == 0) {
                    arrPaint[selectedPieceIndex[0]][selectedPieceIndex[1]].setColor(Color.rgb(236, 217, 121));
                } else {
                    arrPaint[selectedPieceIndex[0]][selectedPieceIndex[1]].setColor(Color.rgb(215, 162, 109));
                }
            }

            if(selectedPiece.name.equals("Knight")){
                validMoves = new ArrayList<>();
                legalMoves = selectedPiece.CalculateLegalMoves(allPieces);

                if(legalMoves.contains(p)){
                    for(int hh=0;hh<legalMoves.size();++hh){
                        System.out.println("Alec possible is "+ legalMoves.get(hh));
                    }
                    if(cont){
                        if(allPieces[rs][cs].color.equals("black")){
                            if(allPieces[rs][cs].onlineCodeName.equals("p1b")){
                                mRoot.child("p1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2b")){
                                mRoot.child("p2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3b")){
                                mRoot.child("p3b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4b")){
                                mRoot.child("p4b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5b")){
                                mRoot.child("p5b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6b")){
                                mRoot.child("p6b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7b")){
                                mRoot.child("p7b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8b")){
                                mRoot.child("p8b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1b")){
                                mRoot.child("r1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2b")){
                                mRoot.child("r2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1b")){
                                mRoot.child("k1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2b")){
                                mRoot.child("k2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1b")){
                                mRoot.child("b1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2b")){
                                mRoot.child("b2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qb")){
                                mRoot.child("qb").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kb")){
                                mRoot.child("kb").child("position").setValue("null");
                            }
                        }else{
                            if(allPieces[rs][cs].onlineCodeName.equals("p1w")){
                                mRoot.child("p1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2w")){
                                mRoot.child("p2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3w")){
                                mRoot.child("p3w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4w")){
                                mRoot.child("p4w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5w")){
                                mRoot.child("p5w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6w")){
                                mRoot.child("p6w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7w")){
                                mRoot.child("p7w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8w")){
                                mRoot.child("p8w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1w")){
                                mRoot.child("r1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2w")){
                                mRoot.child("r2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1w")){
                                mRoot.child("k1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2w")){
                                mRoot.child("k2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1w")){
                                mRoot.child("b1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2w")){
                                mRoot.child("b2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qw")){
                                mRoot.child("qw").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kw")){
                                mRoot.child("kw").child("position").setValue("null");
                            }
                        }
                        allPieces[rs][cs].position = "null";
                    }
                    moveToR = pr;
                    moveToC = pc;
                    selected = false;
                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                    selectedPiece.position = p;
                    arrPaint[pr][pc].setColor(Color.GRAY);
                    System.out.println(" to " + selectedPiece.position);
                    System.out.println("Alec this is an onlinecode name "+selectedPiece.onlineCodeName);
                    if(selectedPiece.color.equals("black")){
                        if(selectedPiece.onlineCodeName.equals("k1b")){
                            mRoot.child("k1b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("k1b").child("firstMove").setValue("false");
                            }
                        }else{
                            mRoot.child("k2b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("k2b").child("firstMove").setValue("false");
                            }
                        }
                    }else{
                        if(selectedPiece.onlineCodeName.equals("k1w")){
                            mRoot.child("k1w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("k1w").child("firstMove").setValue("false");
                            }
                        }else{
                            mRoot.child("k2w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("k2w").child("firstMove").setValue("false");
                            }
                        }
                    }
                    invalidate();
                }
            }else if(selectedPiece.name.equals("pawn")){
                validMoves = new ArrayList<>();
                legalMoves = selectedPiece.CalculateLegalMoves(allPieces);

                if(legalMoves.contains(p)){
                    for(int hh=0;hh<legalMoves.size();++hh){
                        System.out.println("Alec possible is "+ legalMoves.get(hh));
                    }
                    if(cont){
                        if(allPieces[rs][cs].color.equals("black")){
                            if(allPieces[rs][cs].onlineCodeName.equals("p1b")){
                                mRoot.child("p1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2b")){
                                mRoot.child("p2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3b")){
                                mRoot.child("p3b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4b")){
                                mRoot.child("p4b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5b")){
                                mRoot.child("p5b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6b")){
                                mRoot.child("p6b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7b")){
                                mRoot.child("p7b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8b")){
                                mRoot.child("p8b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1b")){
                                mRoot.child("r1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2b")){
                                mRoot.child("r2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1b")){
                                mRoot.child("k1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2b")){
                                mRoot.child("k2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1b")){
                                mRoot.child("b1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2b")){
                                mRoot.child("b2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qb")){
                                mRoot.child("qb").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kb")){
                                mRoot.child("kb").child("position").setValue("null");
                            }
                        }else{
                            if(allPieces[rs][cs].onlineCodeName.equals("p1w")){
                                mRoot.child("p1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2w")){
                                mRoot.child("p2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3w")){
                                mRoot.child("p3w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4w")){
                                mRoot.child("p4w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5w")){
                                mRoot.child("p5w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6w")){
                                mRoot.child("p6w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7w")){
                                mRoot.child("p7w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8w")){
                                mRoot.child("p8w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1w")){
                                mRoot.child("r1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2w")){
                                mRoot.child("r2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1w")){
                                mRoot.child("k1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2w")){
                                mRoot.child("k2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1w")){
                                mRoot.child("b1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2w")){
                                mRoot.child("b2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qw")){
                                mRoot.child("qw").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kw")){
                                mRoot.child("kw").child("position").setValue("null");
                            }
                        }
                        allPieces[rs][cs].position = "null";
                    }
                    moveToR = pr;
                    moveToC = pc;
                    selected = false;
                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                    selectedPiece.position = p;
                    arrPaint[pr][pc].setColor(Color.GRAY);
                    System.out.println(" to " + selectedPiece.position);
                    System.out.println("Alec this is an onlinecode name "+selectedPiece.onlineCodeName);
                    if(selectedPiece.color.equals("black")){
                        if(selectedPiece.onlineCodeName.equals("p1b")){
                            mRoot.child("p1b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p1b").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p2b")){
                            mRoot.child("p2b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p2b").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p3b")){
                            mRoot.child("p3b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p3b").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p4b")){
                            mRoot.child("p4b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p4b").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p5b")){
                            mRoot.child("p5b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p5b").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p6b")){
                            mRoot.child("p6b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p6b").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p7b")){
                            mRoot.child("p7b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p7b").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p8b")){
                            mRoot.child("p8b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p8b").child("firstMove").setValue("false");
                            }
                        }
                    }else{
                        if(selectedPiece.onlineCodeName.equals("p1w")){
                            mRoot.child("p1w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p1w").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p2w")){
                            mRoot.child("p2w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p2w").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p3w")){
                            mRoot.child("p3w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p3w").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p4w")){
                            mRoot.child("p4w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p4w").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p5w")){
                            mRoot.child("p5w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p5w").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p6w")){
                            mRoot.child("p6w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p6w").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p7w")){
                            mRoot.child("p7w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p7w").child("firstMove").setValue("false");
                            }
                        }else if(selectedPiece.onlineCodeName.equals("p8w")){
                            mRoot.child("p8w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("p8w").child("firstMove").setValue("false");
                            }
                        }
                    }
                    invalidate();
                }
            }
            else if(selectedPiece.name.equals("rook")){
                validMoves = new ArrayList<>();
                legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                if(legalMoves.contains(p)){
                    for(int hh=0;hh<legalMoves.size();++hh){
                        System.out.println("Alec possible is "+ legalMoves.get(hh));
                    }
                    if(cont){
                        if(allPieces[rs][cs].color.equals("black")){
                            if(allPieces[rs][cs].onlineCodeName.equals("p1b")){
                                mRoot.child("p1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2b")){
                                mRoot.child("p2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3b")){
                                mRoot.child("p3b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4b")){
                                mRoot.child("p4b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5b")){
                                mRoot.child("p5b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6b")){
                                mRoot.child("p6b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7b")){
                                mRoot.child("p7b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8b")){
                                mRoot.child("p8b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1b")){
                                mRoot.child("r1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2b")){
                                mRoot.child("r2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1b")){
                                mRoot.child("k1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2b")){
                                mRoot.child("k2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1b")){
                                mRoot.child("b1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2b")){
                                mRoot.child("b2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qb")){
                                mRoot.child("qb").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kb")){
                                mRoot.child("kb").child("position").setValue("null");
                            }
                        }else{
                            if(allPieces[rs][cs].onlineCodeName.equals("p1w")){
                                mRoot.child("p1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2w")){
                                mRoot.child("p2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3w")){
                                mRoot.child("p3w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4w")){
                                mRoot.child("p4w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5w")){
                                mRoot.child("p5w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6w")){
                                mRoot.child("p6w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7w")){
                                mRoot.child("p7w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8w")){
                                mRoot.child("p8w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1w")){
                                mRoot.child("r1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2w")){
                                mRoot.child("r2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1w")){
                                mRoot.child("k1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2w")){
                                mRoot.child("k2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1w")){
                                mRoot.child("b1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2w")){
                                mRoot.child("b2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qw")){
                                mRoot.child("qw").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kw")){
                                mRoot.child("kw").child("position").setValue("null");
                            }
                        }
                        allPieces[rs][cs].position = "null";
                    }
                    moveToR = pr;
                    moveToC = pc;
                    selected = false;
                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                    selectedPiece.position = p;
                    arrPaint[pr][pc].setColor(Color.GRAY);
                    System.out.println(" to " + selectedPiece.position);
                    System.out.println("Alec this is an onlinecode name "+selectedPiece.onlineCodeName);
                    if(selectedPiece.color.equals("black")){
                        if(selectedPiece.onlineCodeName.equals("r1b")){
                            mRoot.child("r1b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("r1b").child("firstMove").setValue("false");
                            }
                        }else{
                            mRoot.child("r2b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("r2b").child("firstMove").setValue("false");
                            }
                        }
                    }else{
                        if(selectedPiece.onlineCodeName.equals("r1w")){
                            mRoot.child("r1w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("r1w").child("firstMove").setValue("false");
                            }
                        }else{
                            mRoot.child("r2w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("r2w").child("firstMove").setValue("false");
                            }
                        }
                    }
                    invalidate();
                }
            }
            else if(selectedPiece.name.equals("bishop")){
                validMoves = new ArrayList<>();
                legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                if(legalMoves.contains(p)){
                    for(int hh=0;hh<legalMoves.size();++hh){
                        System.out.println("Alec possible is "+ legalMoves.get(hh));
                    }
                    if(cont){
                        if(allPieces[rs][cs].color.equals("black")){
                            if(allPieces[rs][cs].onlineCodeName.equals("p1b")){
                                mRoot.child("p1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2b")){
                                mRoot.child("p2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3b")){
                                mRoot.child("p3b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4b")){
                                mRoot.child("p4b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5b")){
                                mRoot.child("p5b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6b")){
                                mRoot.child("p6b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7b")){
                                mRoot.child("p7b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8b")){
                                mRoot.child("p8b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1b")){
                                mRoot.child("r1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2b")){
                                mRoot.child("r2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1b")){
                                mRoot.child("k1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2b")){
                                mRoot.child("k2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1b")){
                                mRoot.child("b1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2b")){
                                mRoot.child("b2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qb")){
                                mRoot.child("qb").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kb")){
                                mRoot.child("kb").child("position").setValue("null");
                            }
                        }else{
                            if(allPieces[rs][cs].onlineCodeName.equals("p1w")){
                                mRoot.child("p1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2w")){
                                mRoot.child("p2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3w")){
                                mRoot.child("p3w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4w")){
                                mRoot.child("p4w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5w")){
                                mRoot.child("p5w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6w")){
                                mRoot.child("p6w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7w")){
                                mRoot.child("p7w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8w")){
                                mRoot.child("p8w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1w")){
                                mRoot.child("r1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2w")){
                                mRoot.child("r2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1w")){
                                mRoot.child("k1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2w")){
                                mRoot.child("k2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1w")){
                                mRoot.child("b1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2w")){
                                mRoot.child("b2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qw")){
                                mRoot.child("qw").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kw")){
                                mRoot.child("kw").child("position").setValue("null");
                            }
                        }
                        allPieces[rs][cs].position = "null";
                    }
                    moveToR = pr;
                    moveToC = pc;
                    selected = false;
                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                    selectedPiece.position = p;
                    arrPaint[pr][pc].setColor(Color.GRAY);
                    System.out.println(" to " + selectedPiece.position);
                    System.out.println("Alec this is an onlinecode name "+selectedPiece.onlineCodeName);
                    if(selectedPiece.color.equals("black")){
                        if(selectedPiece.onlineCodeName.equals("b1b")){
                            mRoot.child("b1b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("b1b").child("firstMove").setValue("false");
                            }
                        }else{
                            mRoot.child("b2b").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("b2b").child("firstMove").setValue("false");
                            }
                        }
                    }else{
                        if(selectedPiece.onlineCodeName.equals("b1w")){
                            mRoot.child("b1w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("b1w").child("firstMove").setValue("false");
                            }
                        }else{
                            mRoot.child("b2w").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("b2w").child("firstMove").setValue("false");
                            }
                        }
                    }
                    invalidate();
                }
            }
            else if(selectedPiece.name.equals("queen")){
                validMoves = new ArrayList<>();
                legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                if(legalMoves.contains(p)){
                    for(int hh=0;hh<legalMoves.size();++hh){
                        System.out.println("Alec possible is "+ legalMoves.get(hh));
                    }
                    if(cont){
                        if(allPieces[rs][cs].color.equals("black")){
                            if(allPieces[rs][cs].onlineCodeName.equals("p1b")){
                                mRoot.child("p1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2b")){
                                mRoot.child("p2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3b")){
                                mRoot.child("p3b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4b")){
                                mRoot.child("p4b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5b")){
                                mRoot.child("p5b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6b")){
                                mRoot.child("p6b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7b")){
                                mRoot.child("p7b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8b")){
                                mRoot.child("p8b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1b")){
                                mRoot.child("r1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2b")){
                                mRoot.child("r2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1b")){
                                mRoot.child("k1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2b")){
                                mRoot.child("k2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1b")){
                                mRoot.child("b1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2b")){
                                mRoot.child("b2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qb")){
                                mRoot.child("qb").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kb")){
                                mRoot.child("kb").child("position").setValue("null");
                            }
                        }else{
                            if(allPieces[rs][cs].onlineCodeName.equals("p1w")){
                                mRoot.child("p1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2w")){
                                mRoot.child("p2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3w")){
                                mRoot.child("p3w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4w")){
                                mRoot.child("p4w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5w")){
                                mRoot.child("p5w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6w")){
                                mRoot.child("p6w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7w")){
                                mRoot.child("p7w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8w")){
                                mRoot.child("p8w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1w")){
                                mRoot.child("r1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2w")){
                                mRoot.child("r2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1w")){
                                mRoot.child("k1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2w")){
                                mRoot.child("k2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1w")){
                                mRoot.child("b1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2w")){
                                mRoot.child("b2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qw")){
                                mRoot.child("qw").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kw")){
                                mRoot.child("kw").child("position").setValue("null");
                            }
                        }
                        allPieces[rs][cs].position = "null";
                    }
                    moveToR = pr;
                    moveToC = pc;
                    selected = false;
                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                    selectedPiece.position = p;
                    arrPaint[pr][pc].setColor(Color.GRAY);
                    System.out.println(" to " + selectedPiece.position);
                    System.out.println("Alec this is an onlinecode name "+selectedPiece.onlineCodeName);
                    if(selectedPiece.color.equals("black")){
                        if(selectedPiece.onlineCodeName.equals("qb")) {
                            mRoot.child("qb").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("qb").child("firstMove").setValue("false");
                            }
                        }
                    }else{
                        if(selectedPiece.onlineCodeName.equals("qw")){
                            mRoot.child("qw").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("qw").child("firstMove").setValue("false");
                            }
                        }
                    }
                    invalidate();
                }
            }
            else if(selectedPiece.name.equals("king")){
                validMoves = new ArrayList<>();
                legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                if(legalMoves.contains(p)){
                    for(int hh=0;hh<legalMoves.size();++hh){
                        System.out.println("Alec possible is "+ legalMoves.get(hh));
                    }
                    if(cont){
                        if(allPieces[rs][cs].color.equals("black")){
                            if(allPieces[rs][cs].onlineCodeName.equals("p1b")){
                                mRoot.child("p1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2b")){
                                mRoot.child("p2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3b")){
                                mRoot.child("p3b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4b")){
                                mRoot.child("p4b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5b")){
                                mRoot.child("p5b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6b")){
                                mRoot.child("p6b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7b")){
                                mRoot.child("p7b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8b")){
                                mRoot.child("p8b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1b")){
                                mRoot.child("r1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2b")){
                                mRoot.child("r2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1b")){
                                mRoot.child("k1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2b")){
                                mRoot.child("k2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1b")){
                                mRoot.child("b1b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2b")){
                                mRoot.child("b2b").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qb")){
                                mRoot.child("qb").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kb")){
                                mRoot.child("kb").child("position").setValue("null");
                            }
                        }else{
                            if(allPieces[rs][cs].onlineCodeName.equals("p1w")){
                                mRoot.child("p1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p2w")){
                                mRoot.child("p2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p3w")){
                                mRoot.child("p3w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p4w")){
                                mRoot.child("p4w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p5w")){
                                mRoot.child("p5w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p6w")){
                                mRoot.child("p6w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p7w")){
                                mRoot.child("p7w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("p8w")){
                                mRoot.child("p8w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r1w")){
                                mRoot.child("r1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("r2w")){
                                mRoot.child("r2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k1w")){
                                mRoot.child("k1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("k2w")){
                                mRoot.child("k2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b1w")){
                                mRoot.child("b1w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("b2w")){
                                mRoot.child("b2w").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("qw")){
                                mRoot.child("qw").child("position").setValue("null");
                            }else if(allPieces[rs][cs].onlineCodeName.equals("kw")){
                                mRoot.child("kw").child("position").setValue("null");
                            }
                        }
                        allPieces[rs][cs].position = "null";
                    }
                    moveToR = pr;
                    moveToC = pc;
                    selected = false;
                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                    selectedPiece.position = p;
                    arrPaint[pr][pc].setColor(Color.GRAY);
                    System.out.println(" to " + selectedPiece.position);
                    System.out.println("Alec this is an onlinecode name "+selectedPiece.onlineCodeName);
                    if(selectedPiece.color.equals("black")){
                        if(selectedPiece.onlineCodeName.equals("kb")) {
                            mRoot.child("kb").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("kb").child("firstMove").setValue("false");
                            }
                        }
                    }else{
                        if(selectedPiece.onlineCodeName.equals("kw")){
                            mRoot.child("kw").child("position").setValue(p);
                            if(selectedPiece.firstMove){
                                mRoot.child("kw").child("firstMove").setValue("false");
                            }
                        }
                    }
                    invalidate();
                }
            }
//                else {
//                    if(cont){
//                        allPieces[rs][cs].position = "null";
//                    }
//                    moveToR = pr;
//                    moveToC = pc;
//                    selected = false;
//                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
//                    selectedPiece.position = p;
//                    arrPaint[pr][pc].setColor(Color.GRAY);
//                    System.out.println(" to " + selectedPiece.position);
//                    invalidate();
//                }




        }

//        else {
//            if(selected==true){
//
//                if(selectedPiece.name.equals("Knight")){
//                    legalMoves = selectedPiece.CalculateLegalMoves();
//                    if(legalMoves.contains(p)){
//                        moveToR = pr;
//                        moveToC = pc;
//                        selected = false;
//                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
//                        selectedPiece.position = p;
//                        arrPaint[pr][pc].setColor(Color.GRAY);
//                        System.out.println(" to " + selectedPiece.position);
//                        invalidate();
//                    }
//
//                }else if(selectedPiece.name.equals("pawn")){
//                    legalMoves = selectedPiece.CalculateLegalMoves();
//                    System.out.println(legalMoves.size());
//                    if(legalMoves.contains(p)){
//                        moveToR = pr;
//                        moveToC = pc;
//                        selected = false;
//                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
//                        selectedPiece.position = p;
//                        arrPaint[pr][pc].setColor(Color.GRAY);
//                        System.out.println(" to " + selectedPiece.position);
//                        invalidate();
//                    }
//                }
//                else {
//                    moveToR = pr;
//                    moveToC = pc;
//                    selected = false;
//                    System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
//                    selectedPiece.position = p;
//                    arrPaint[pr][pc].setColor(Color.GRAY);
//                    System.out.println(" to " + selectedPiece.position);
//                    invalidate();
//                }
//            }
//        }

    }


    private int[] getIndex(String pos){
//        private float color[][] =   A B C D E F G H
//                                  8{0,1,0,1,0,1,0,1},
//                                  7{1,0,1,0,1,0,1,0},
//                                  6{0,1,0,1,0,1,0,1},
//                                  5{1,0,1,0,1,0,1,0},
//                                  4{0,1,0,1,0,1,0,1},
//                                  3{1,0,1,0,1,0,1,0},
//                                  2{0,1,0,1,0,1,0,1},
//                                  1{1,0,1,0,1,0,1,0};

//                                    0 1 2 3 4 5 6 7
//                                  0{0,1,0,1,0,1,0,1},
//                                  1{1,0,1,0,1,0,1,0},
//                                  2{0,1,0,1,0,1,0,1},
//                                  3{1,0,1,0,1,0,1,0},
//                                  4{0,1,0,1,0,1,0,1},
//                                  5{1,0,1,0,1,0,1,0},
//                                  6{0,1,0,1,0,1,0,1},
//                                  7{1,0,1,0,1,0,1,0};

        String[] posAlpha = {"A8","B8","C8","D8","E8","F8","G8","H8",
                "A7","B7","C7","D7","E7","F7","G7","H7",
                "A6","B6","C6","D6","E6","F6","G6","H6",
                "A5","B5","C5","D5","E5","F5","G5","H5",
                "A4","B4","C4","D4","E4","F4","G4","H4",
                "A3","B3","C3","D3","E3","F3","G3","H3",
                "A2","B2","C2","D2","E2","F2","G2","H2",
                "A1","B1","C1","D1","E1","F1","G1","H1"};

        int[][] posNum = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},
                {1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},
                {2,0},{2,1},{2,2},{2,3},{2,4},{2,5},{2,6},{2,7},
                {3,0},{3,1},{3,2},{3,3},{3,4},{3,5},{3,6},{3,7},
                {4,0},{4,1},{4,2},{4,3},{4,4},{4,5},{4,6},{4,7},
                {5,0},{5,1},{5,2},{5,3},{5,4},{5,5},{5,6},{5,7},
                {6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},
                {7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,6},{7,7}};
        int arr[] = {0,0};

        for(int row=0;row<posAlpha.length;++row){
            if(pos.equals(posAlpha[row])){
                arr = posNum[row];
            }
        }

        return arr;
    }


    private float[] post(String p, android.graphics.Canvas canvas){


        float sideW = (((canvas.getHeight()/3) + (canvas.getHeight()/3))/8)/4;


        float height = ((canvas.getHeight()/3) + (canvas.getHeight()/3))-sideW;


        float sideH = (canvas.getWidth()/8)/4;
        float width = canvas.getWidth()-sideH;

        float w = width/8;
        float h = height/8;
        float[] results = new float[4];

        if(p.equals("A8")){
            results[0] = 0+sideH;
            results[1] = 0;
            results[2] = w+sideH;
            results[3] = h;
            return results;
        }else if(p.equals("B8")){
            results[0] = w+sideH;
            results[1] = 0;
            results[2] = w*2+sideH;
            results[3] = h;
            return results;
        }else if(p.equals("C8")){
            results[0] = w*2+sideH;
            results[1] = 0;
            results[2] = w*3+sideH;
            results[3] = h;
            return results;
        }else if(p.equals("D8")){
            results[0] = w*3+sideH;
            results[1] = 0;
            results[2] = w*4+sideH;
            results[3] = h;
            return results;

        }else if(p.equals("E8")){
            results[0] = w*4+sideH;
            results[1] = 0;
            results[2] = w*5+sideH;
            results[3] = h;
            return results;

        }else if(p.equals("F8")){
            results[0] = w*5+sideH;
            results[1] = 0;
            results[2] = w*6+sideH;
            results[3] = h;
            return results;

        }else if(p.equals("G8")){
            results[0] = w*6+sideH;
            results[1] = 0;
            results[2] = w*7+sideH;
            results[3] = h;
            return results;

        }else if(p.equals("H8")){
            results[0] = w*7+sideH;
            results[1] = 0;
            results[2] = w*8+sideH;
            results[3] = h;
            return results;


        }else if(p.equals("A7")){
            results[0] = 0+sideH;
            results[1] = h;
            results[2] = w+sideH;
            results[3] = h*2;
            return results;


        }else if(p.equals("B7")){
            results[0] = w+sideH;
            results[1] = h;
            results[2] = w*2+sideH;
            results[3] = h*2;
            return results;

        }else if(p.equals("C7")){
            results[0] = w*2+sideH;
            results[1] = h;
            results[2] = w*3+sideH;
            results[3] = h*2;
            return results;

        }else if(p.equals("D7")){
            results[0] = w*3+sideH;
            results[1] = h;
            results[2] = w*4+sideH;
            results[3] = h*2;
            return results;

        }else if(p.equals("E7")){
            results[0] = w*4+sideH;
            results[1] = h;
            results[2] = w*5+sideH;
            results[3] = h*2;
            return results;

        }else if(p.equals("F7")){
            results[0] = w*5+sideH;
            results[1] = h;
            results[2] = w*6+sideH;
            results[3] = h*2;
            return results;
        }else if(p.equals("G7")){
            results[0] = w*6+sideH;
            results[1] = h;
            results[2] = w*7+sideH;
            results[3] = h*2;
            return results;

        }else if(p.equals("H7")){
            results[0] = w*7+sideH;
            results[1] = h;
            results[2] = w*8+sideH;
            results[3] = h*2;
            return results;

        }else if(p.equals("A6")){
            results[0] = 0+sideH;
            results[1] = h*2;
            results[2] = w+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("B6")){
            results[0] = w+sideH;
            results[1] = h*2;
            results[2] = w*2+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("C6")){
            results[0] = w*2+sideH;
            results[1] = h*2;
            results[2] = w*3+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("D6")){
            results[0] = w*3+sideH;
            results[1] = h*2;
            results[2] = w*4+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("E6")){
            results[0] = w*4+sideH;
            results[1] = h*2;
            results[2] = w*5+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("F6")){
            results[0] = w*5+sideH;
            results[1] = h*2;
            results[2] = w*6+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("G6")){
            results[0] = w*6+sideH;
            results[1] = h*2;
            results[2] = w*7+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("H6")){
            results[0] = w*7+sideH;
            results[1] = h*2;
            results[2] = w*8+sideH;
            results[3] = h*3;
            return results;

        }else if(p.equals("A5")){
            results[0] = 0+sideH;
            results[1] = h*3;
            results[2] = w+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("B5")){
            results[0] = w+sideH;
            results[1] = h*3;
            results[2] = w*2+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("C5")){
            results[0] = w*2+sideH;
            results[1] = h*3;
            results[2] = w*3+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("D5")){
            results[0] = w*3+sideH;
            results[1] = h*3;
            results[2] = w*4+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("E5")){
            results[0] = w*4+sideH;
            results[1] = h*3;
            results[2] = w*5+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("F5")){
            results[0] = w*5+sideH;
            results[1] = h*3;
            results[2] = w*6+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("G5")){
            results[0] = w*6+sideH;
            results[1] = h*3;
            results[2] = w*7+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("H5")){
            results[0] = w*7+sideH;
            results[1] = h*3;
            results[2] = w*8+sideH;
            results[3] = h*4;
            return results;

        }else if(p.equals("A4")){
            results[0] = 0+sideH;
            results[1] = h*4;
            results[2] = w+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("B4")){
            results[0] = w+sideH;
            results[1] = h*4;
            results[2] = w*2+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("C4")){
            results[0] = w*2+sideH;
            results[1] = h*4;
            results[2] = w*3+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("D4")){
            results[0] = w*3+sideH;
            results[1] = h*4;
            results[2] = w*4+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("E4")){
            results[0] = w*4+sideH;
            results[1] = h*4;
            results[2] = w*5+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("F4")){
            results[0] = w*5+sideH;
            results[1] = h*4;
            results[2] = w*6+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("G4")){
            results[0] = w*6+sideH;
            results[1] = h*4;
            results[2] = w*7+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("H4")){
            results[0] = w*7+sideH;
            results[1] = h*4;
            results[2] = w*8+sideH;
            results[3] = h*5;
            return results;

        }else if(p.equals("A3")){
            results[0] = 0+sideH;
            results[1] = h*5;
            results[2] = w+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("B3")){
            results[0] = w+sideH;
            results[1] = h*5;
            results[2] = w*2+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("C3")){
            results[0] = w*2+sideH;
            results[1] = h*5;
            results[2] = w*3+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("D3")){
            results[0] = w*3+sideH;
            results[1] = h*5;
            results[2] = w*4+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("E3")){
            results[0] = w*4+sideH;
            results[1] = h*5;
            results[2] = w*5+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("F3")){
            results[0] = w*5+sideH;
            results[1] = h*5;
            results[2] = w*6+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("G3")){
            results[0] = w*6+sideH;
            results[1] = h*5;
            results[2] = w*7+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("H3")){
            results[0] = w*7+sideH;
            results[1] = h*5;
            results[2] = w*8+sideH;
            results[3] = h*6;
            return results;

        }else if(p.equals("A2")){
            results[0] = 0+sideH;
            results[1] = h*6;
            results[2] = w+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("B2")){
            results[0] = w+sideH;
            results[1] = h*6;
            results[2] = w*2+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("C2")){
            results[0] = w*2+sideH;
            results[1] = h*6;
            results[2] = w*3+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("D2")){
            results[0] = w*3+sideH;
            results[1] = h*6;
            results[2] = w*4+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("E2")){
            results[0] = w*4+sideH;
            results[1] = h*6;
            results[2] = w*5+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("F2")){
            results[0] = w*5+sideH;
            results[1] = h*6;
            results[2] = w*6+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("G2")){
            results[0] = w*6+sideH;
            results[1] = h*6;
            results[2] = w*7+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("H2")){
            results[0] = w*7+sideH;
            results[1] = h*6;
            results[2] = w*8+sideH;
            results[3] = h*7;
            return results;

        }else if(p.equals("A1")){
            results[0] = 0+sideH;
            results[1] = h*7;
            results[2] = w+sideH;
            results[3] = h*8;
            return results;

        }else if(p.equals("B1")){
            results[0] = w+sideH;
            results[1] = h*7;
            results[2] = w*2+sideH;
            results[3] = h*8;
            return results;

        }else if(p.equals("C1")){
            results[0] = w*2+sideH;
            results[1] = h*7;
            results[2] = w*3+sideH;
            results[3] = h*8;
            return results;

        }else if(p.equals("D1")){
            results[0] = w*3+sideH;
            results[1] = h*7;
            results[2] = w*4+sideH;
            results[3] = h*8;
            return results;

        }else if(p.equals("E1")){
            results[0] = w*4+sideH;
            results[1] = h*7;
            results[2] = w*5+sideH;
            results[3] = h*8;
            return results;

        }else if(p.equals("F1")){
            results[0] = w*5+sideH;
            results[1] = h*7;
            results[2] = w*6+sideH;
            results[3] = h*8;
            return results;

        }else if(p.equals("G1")){
            results[0] = w*6+sideH;
            results[1] = h*7;
            results[2] = w*7+sideH;
            results[3] = h*8;
            return results;

        }else if(p.equals("H1")){   //H1
            results[0] = w*7+sideH;
            results[1] = h*7;
            results[2] = w*8+sideH;
            results[3] = h*8;
            return results;
        }

        return null;
    }

}
