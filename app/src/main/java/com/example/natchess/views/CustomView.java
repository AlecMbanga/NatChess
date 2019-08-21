package com.example.natchess.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.natchess.Piece;
import com.example.natchess.R;

import java.lang.reflect.Array;

public class CustomView extends View {

    private RectF dst;
    private RectF[][] arrRect;
    private Paint[][] arrPaint;
    private Paint mPaint;
    private Paint paint;
    private Paint paint2;
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
    private Piece[][] allPieces;
    private boolean selected;
    private Piece selectedPiece;
    private boolean move;





    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        InitialiseBoardColors();
        allPieces = new Piece[2][8];
        allPieces[0][0] = new Piece("rook","black","A8");
        allPieces[0][1] = new Piece("night","black","B8");
        allPieces[0][2] = new Piece("bishop","black","Null");
        allPieces[0][3] = new Piece("queen","black","D8");
        allPieces[0][4] = new Piece("king","black","E8");
        allPieces[0][5] = new Piece("bishop","black","F8");
        allPieces[0][6] = new Piece("night","black","G8");
        allPieces[0][7] = new Piece("rook","black","H8");
        allPieces[1][0] = new Piece("pawn","black","A7");
        allPieces[1][1] = new Piece("pawn","black","B7");
        allPieces[1][2] = new Piece("pawn","black","C7");
        allPieces[1][3] = new Piece("pawn","black","D7");
        allPieces[1][4] = new Piece("pawn","black","E7");
        allPieces[1][5] = new Piece("pawn","black","F7");
        allPieces[1][6] = new Piece("pawn","black","G7");
        allPieces[1][7] = new Piece("pawn","black","H7");
        selected = false;
        move = false;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        DrawChessBoard(canvas);

        DrawChessPieces(canvas);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        boolean contains = false;
        int rSelected=0;
        int cSelected=0;
        if(arrRect[0][0].contains(event.getX(),event.getY())){

            for(int r = 0;r<allPieces.length;++r){
                for(int c = 0;c<allPieces[0].length;++c){
                    if(contains) break;
                    if(allPieces[r][c].position.equals("A8")){
                        contains = true;
                        System.out.println("Alec it contains a "+ allPieces[r][c].name);
                        rSelected = r;
                        cSelected = c;
                        //selectedPiece = allPieces[r][c];
                    }
                }
                if(contains) break;
            }

            if(contains==true){
                if(selected==false){
                    selected = true;
                    selectedPiece = allPieces[rSelected][cSelected];
                    arrPaint[0][0].setColor(Color.GRAY);
                    System.out.println("Alec touched this Please try change");
                    invalidate();
                }else{
                    if(selectedPiece.position.equals("A8")) {
                        selected = false;
                        selectedPiece = null;
                        arrPaint[0][0].setColor(Color.rgb(236, 217, 121));
                        System.out.println("Alec touched this Please try change back");
                        invalidate();
                    }
                }

            }
        }else if(arrRect[0][1].contains(event.getX(),event.getY())){
            for(int r = 0;r<allPieces.length;++r){
                for(int c = 0;c<allPieces[0].length;++c){
                    if(contains) break;
                    if(allPieces[r][c].position.equals("B8")){
                        contains = true;
                        System.out.println("Alec it contains a "+ allPieces[r][c].name);
                        rSelected = r;
                        cSelected = c;
                        //selectedPiece = allPieces[r][c];
                    }
                }
                if(contains) break;
            }

            if(contains==true){
                if(selected==false){
                    selected = true;
                    selectedPiece = allPieces[rSelected][cSelected];
                    arrPaint[0][1].setColor(Color.GRAY);
                    System.out.println("Alec touched this Please try change");
                    invalidate();
                }else{
                    if(selectedPiece.position.equals("B8")) {
                        selected = false;
                        selectedPiece = null;
                        arrPaint[0][1].setColor(Color.rgb(215, 162, 109));
                        System.out.println("Alec touched this Please try change back");
                        invalidate();
                    }
                }

            }

        }else if(arrRect[0][2].contains(event.getX(),event.getY())){

            for(int r = 0;r<allPieces.length;++r){
                for(int c = 0;c<allPieces[0].length;++c){
                    if(contains) break;
                    if(allPieces[r][c].position.equals("C8")){
                        contains = true;
                        System.out.println("Alec it contains a "+ allPieces[r][c].name);
                        rSelected = r;
                        cSelected = c;
                        //selectedPiece = allPieces[r][c];
                    }
                }
                if(contains) break;
            }

            if(contains==true){
                if(selected==false){
                    selected = true;
                    selectedPiece = allPieces[rSelected][cSelected];
                    arrPaint[0][2].setColor(Color.GRAY);
                    System.out.println("Alec touched this Please try change");
                    invalidate();
                }else{
                    if(selectedPiece.position.equals("C8")) {
                        selected = false;
                        selectedPiece = null;
                        arrPaint[0][2].setColor(Color.rgb(236, 217, 121));
                        System.out.println("Alec touched this Please try change back");
                        invalidate();
                    }
                }

            }else {
                if(selected==true){
                    selected = false;
                    selectedPiece.position = "C8";
                    arrPaint[0][2].setColor(Color.GRAY);
                    System.out.println("Alec its a move");
                    invalidate();
                }
            }


        }else if(arrRect[0][3].contains(event.getX(),event.getY())){
            if(arrPaint[0][3].getColor()==Color.GRAY){
                arrPaint[0][3].setColor(Color.rgb(215,162,109));

            }else{
                arrPaint[0][3].setColor(Color.GRAY);
            }
            invalidate();
            System.out.println("Alec touched this Please change");

        }else if(arrRect[0][4].contains(event.getX(),event.getY())){
            if(arrPaint[0][4].getColor()==Color.GRAY){
                arrPaint[0][4].setColor(Color.rgb(236,217,121));

            }else{
                arrPaint[0][4].setColor(Color.GRAY);
            }
            invalidate();
            System.out.println("Alec touched this Please change");

        }else if(arrRect[0][5].contains(event.getX(),event.getY())){
            if(arrPaint[0][5].getColor()==Color.GRAY){
                arrPaint[0][5].setColor(Color.rgb(215,162,109));

            }else{
                arrPaint[0][5].setColor(Color.GRAY);
            }
            invalidate();
            System.out.println("Alec touched this Please change");

        }else if(arrRect[0][6].contains(event.getX(),event.getY())){
            if(arrPaint[0][6].getColor()==Color.GRAY){
                arrPaint[0][6].setColor(Color.rgb(236,217,121));

            }else{
                arrPaint[0][6].setColor(Color.GRAY);
            }
            invalidate();
            System.out.println("Alec touched this Please change");

        }else if(arrRect[0][7].contains(event.getX(),event.getY())){
            if(arrPaint[0][7].getColor()==Color.GRAY){
                arrPaint[0][7].setColor(Color.rgb(215,162,109));

            }else{
                arrPaint[0][7].setColor(Color.GRAY);
            }
            invalidate();
            System.out.println("Alec touched this Please change");

        }

        return value;
    }

    private void DrawChessPieces(Canvas canvas){

        Bitmap bpawn = BitmapFactory.decodeResource(getResources(), R.mipmap.pb);
        Bitmap brook = BitmapFactory.decodeResource(getResources(), R.mipmap.rb);
        Bitmap bnight = BitmapFactory.decodeResource(getResources(), R.mipmap.nb);
        Bitmap bbishop = BitmapFactory.decodeResource(getResources(), R.mipmap.bb);
        Bitmap bqueen = BitmapFactory.decodeResource(getResources(), R.mipmap.qb);
        Bitmap bking = BitmapFactory.decodeResource(getResources(), R.mipmap.kb);


        float[] Positionp1 = post(allPieces[1][0].position,canvas);
        p1Scale = new RectF(Positionp1[0],Positionp1[1],Positionp1[2],Positionp1[3]);
        canvas.drawBitmap(bpawn,null,p1Scale,null);

        float[] Positionp2 = post(allPieces[1][1].position,canvas);
        p2Scale = new RectF(Positionp2[0],Positionp2[1],Positionp2[2],Positionp2[3]);
        canvas.drawBitmap(bpawn,null,p2Scale,null);

        float[] Positionp3 = post(allPieces[1][2].position,canvas);
        p3Scale = new RectF(Positionp3[0],Positionp3[1],Positionp3[2],Positionp3[3]);
        canvas.drawBitmap(bpawn,null,p3Scale,null);

        float[] Positionp4 = post(allPieces[1][3].position,canvas);
        p4Scale = new RectF(Positionp4[0],Positionp4[1],Positionp4[2],Positionp4[3]);
        canvas.drawBitmap(bpawn,null,p4Scale,null);

        float[] Positionp5 = post(allPieces[1][4].position,canvas);
        p5Scale = new RectF(Positionp5[0],Positionp5[1],Positionp5[2],Positionp5[3]);
        canvas.drawBitmap(bpawn,null,p5Scale,null);

        float[] Positionp6 = post(allPieces[1][5].position,canvas);
        p6Scale = new RectF(Positionp6[0],Positionp6[1],Positionp6[2],Positionp6[3]);
        canvas.drawBitmap(bpawn,null,p6Scale,null);

        float[] Positionp7 = post(allPieces[1][6].position,canvas);
        p7Scale = new RectF(Positionp7[0],Positionp7[1],Positionp7[2],Positionp7[3]);
        canvas.drawBitmap(bpawn,null,p7Scale,null);

        float[] Positionp8 = post(allPieces[1][7].position,canvas);
        p8Scale = new RectF(Positionp8[0],Positionp8[1],Positionp8[2],Positionp8[3]);
        canvas.drawBitmap(bpawn,null,p8Scale,null);

        float[] Positionr1 = post(allPieces[0][0].position,canvas);
        r1Scale = new RectF(Positionr1[0],Positionr1[1],Positionr1[2],Positionr1[3]);
        canvas.drawBitmap(brook,null,r1Scale,null);

        float[] Positionr2 = post(allPieces[0][7].position,canvas);
        r2Scale = new RectF(Positionr2[0],Positionr2[1],Positionr2[2],Positionr2[3]);
        //canvas.drawBitmap(brook,null,r2Scale,null);

        float[] Positionn1 = post(allPieces[0][1].position,canvas);
        n1Scale = new RectF(Positionn1[0],Positionn1[1],Positionn1[2],Positionn1[3]);
        canvas.drawBitmap(bnight,null,n1Scale,null);

        float[] Positionn2 = post(allPieces[0][6].position,canvas);
        n2Scale = new RectF(Positionn2[0],Positionn2[1],Positionn2[2],Positionn2[3]);
        //canvas.drawBitmap(bnight,null,n2Scale,null);

        float[] Positionb2 = post(allPieces[0][5].position,canvas);
        b2Scale = new RectF(Positionb2[0],Positionb2[1],Positionb2[2],Positionb2[3]);
        //canvas.drawBitmap(bbishop,null,b2Scale,null);

        //float[] Positionb1 = post(allPieces[0][2].position,canvas);
        //b1Scale = new RectF(Positionb1[0],Positionb1[1],Positionb1[2],Positionb1[3]);
        //canvas.drawBitmap(bbishop,null,b1Scale,null);

        float[] Positionq = post(allPieces[0][3].position,canvas);
        qScale = new RectF(Positionq[0],Positionq[1],Positionq[2],Positionq[3]);
        //canvas.drawBitmap(bqueen,null,qScale,null);

        float[] Positionk = post(allPieces[0][4].position,canvas);
        kScale = new RectF(Positionk[0],Positionk[1],Positionk[2],Positionk[3]);
        //canvas.drawBitmap(bking,null,kScale,null);

    }

    private float[] post(String p,Canvas canvas){
        float w = ((float)canvas.getWidth())/8;
        float h = ((float)canvas.getHeight())/8;
        float[] results = new float[4];

        if(p.equals("A8")){
            results[0] = 0;
            results[1] = 0;
            results[2] = w;
            results[3] = h;
            return results;
        }else if(p.equals("B8")){
            results[0] = w;
            results[1] = 0;
            results[2] = w*2;
            results[3] = h;
            return results;
        }else if(p.equals("C8")){
            results[0] = w*2;
            results[1] = 0;
            results[2] = w*3;
            results[3] = h;
            return results;
        }else if(p.equals("D8")){
            results[0] = w*3;
            results[1] = 0;
            results[2] = w*4;
            results[3] = h;
            return results;

        }else if(p.equals("E8")){
            results[0] = w*4;
            results[1] = 0;
            results[2] = w*5;
            results[3] = h;
            return results;

        }else if(p.equals("F8")){
            results[0] = w*5;
            results[1] = 0;
            results[2] = w*6;
            results[3] = h;
            return results;

        }else if(p.equals("G8")){
            results[0] = w*6;
            results[1] = 0;
            results[2] = w*7;
            results[3] = h;
            return results;

        }else if(p.equals("H8")){results[0] = 0;
            results[0] = w*7;
            results[1] = 0;
            results[2] = w*8;
            results[3] = h;
            return results;


        }else if(p.equals("A7")){
            results[0] = 0;
            results[1] = h;
            results[2] = w;
            results[3] = h*2;
            return results;


        }else if(p.equals("B7")){
            results[0] = w;
            results[1] = h;
            results[2] = w*2;
            results[3] = h*2;
            return results;

        }else if(p.equals("C7")){
            results[0] = w*2;
            results[1] = h;
            results[2] = w*3;
            results[3] = h*2;
            return results;

        }else if(p.equals("D7")){
            results[0] = w*3;
            results[1] = h;
            results[2] = w*4;
            results[3] = h*2;
            return results;

        }else if(p.equals("E7")){
            results[0] = w*4;
            results[1] = h;
            results[2] = w*5;
            results[3] = h*2;
            return results;

        }else if(p.equals("F7")){
            results[0] = w*5;
            results[1] = h;
            results[2] = w*6;
            results[3] = h*2;
            return results;
        }else if(p.equals("G7")){
            results[0] = w*6;
            results[1] = h;
            results[2] = w*7;
            results[3] = h*2;
            return results;

        }else if(p.equals("H7")){
            results[0] = w*7;
            results[1] = h;
            results[2] = w*8;
            results[3] = h*2;
            return results;

        }else if(p.equals("A6")){
            results[0] = 0;
            results[1] = h*2;
            results[2] = w;
            results[3] = h*3;
            return results;

        }else if(p.equals("B6")){
            results[0] = w;
            results[1] = h*2;
            results[2] = w*2;
            results[3] = h*3;
            return results;

        }else if(p.equals("C6")){
            results[0] = w*2;
            results[1] = h*2;
            results[2] = w*3;
            results[3] = h*3;
            return results;

        }else if(p.equals("D6")){
            results[0] = w*3;
            results[1] = h*2;
            results[2] = w*4;
            results[3] = h*3;
            return results;

        }else if(p.equals("E6")){
            results[0] = w*4;
            results[1] = h*2;
            results[2] = w*5;
            results[3] = h*3;
            return results;

        }else if(p.equals("F6")){
            results[0] = w*5;
            results[1] = h*2;
            results[2] = w*6;
            results[3] = h*3;
            return results;

        }else if(p.equals("G6")){
            results[0] = w*6;
            results[1] = h*2;
            results[2] = w*7;
            results[3] = h*3;
            return results;

        }else if(p.equals("H6")){
            results[0] = w*7;
            results[1] = h*2;
            results[2] = w*8;
            results[3] = h*3;
            return results;

        }else if(p.equals("A5")){
            results[0] = 0;
            results[1] = h*3;
            results[2] = w;
            results[3] = h*4;
            return results;

        }else if(p.equals("B5")){
            results[0] = w;
            results[1] = h*3;
            results[2] = w*2;
            results[3] = h*4;
            return results;

        }else if(p.equals("C5")){
            results[0] = w*2;
            results[1] = h*3;
            results[2] = w*3;
            results[3] = h*4;
            return results;

        }else if(p.equals("D5")){
            results[0] = w*3;
            results[1] = h*3;
            results[2] = w*4;
            results[3] = h*4;
            return results;

        }else if(p.equals("E5")){
            results[0] = w*4;
            results[1] = h*3;
            results[2] = w*5;
            results[3] = h*4;
            return results;

        }else if(p.equals("F5")){
            results[0] = w*5;
            results[1] = h*3;
            results[2] = w*6;
            results[3] = h*4;
            return results;

        }else if(p.equals("G5")){
            results[0] = w*6;
            results[1] = h*3;
            results[2] = w*7;
            results[3] = h*4;
            return results;

        }else if(p.equals("H5")){
            results[0] = w*7;
            results[1] = h*3;
            results[2] = w*8;
            results[3] = h*4;
            return results;

        }else if(p.equals("A4")){
            results[0] = 0;
            results[1] = h*4;
            results[2] = w;
            results[3] = h*5;
            return results;

        }else if(p.equals("B4")){
            results[0] = w;
            results[1] = h*4;
            results[2] = w*2;
            results[3] = h*5;
            return results;

        }else if(p.equals("C4")){
            results[0] = w*2;
            results[1] = h*4;
            results[2] = w*3;
            results[3] = h*5;
            return results;

        }else if(p.equals("D4")){
            results[0] = w*3;
            results[1] = h*4;
            results[2] = w*4;
            results[3] = h*5;
            return results;

        }else if(p.equals("E4")){
            results[0] = w*4;
            results[1] = h*4;
            results[2] = w*5;
            results[3] = h*5;
            return results;

        }else if(p.equals("F4")){
            results[0] = w*5;
            results[1] = h*4;
            results[2] = w*6;
            results[3] = h*5;
            return results;

        }else if(p.equals("G4")){
            results[0] = w*6;
            results[1] = h*4;
            results[2] = w*7;
            results[3] = h*7;
            return results;

        }else if(p.equals("H4")){
            results[0] = w*7;
            results[1] = h*4;
            results[2] = w*8;
            results[3] = h*5;
            return results;

        }else if(p.equals("A3")){
            results[0] = 0;
            results[1] = h*5;
            results[2] = w;
            results[3] = h*6;
            return results;

        }else if(p.equals("B3")){
            results[0] = w;
            results[1] = h*5;
            results[2] = w*2;
            results[3] = h*6;
            return results;

        }else if(p.equals("C3")){
            results[0] = w*2;
            results[1] = h*5;
            results[2] = w*3;
            results[3] = h*6;
            return results;

        }else if(p.equals("D3")){
            results[0] = w*3;
            results[1] = h*5;
            results[2] = w*4;
            results[3] = h*6;
            return results;

        }else if(p.equals("E3")){
            results[0] = w*4;
            results[1] = h*5;
            results[2] = w*5;
            results[3] = h*6;
            return results;

        }else if(p.equals("F3")){
            results[0] = w*5;
            results[1] = h*5;
            results[2] = w*6;
            results[3] = h*6;
            return results;

        }else if(p.equals("G3")){
            results[0] = w*6;
            results[1] = h*5;
            results[2] = w*7;
            results[3] = h*6;
            return results;

        }else if(p.equals("H3")){
            results[0] = w*7;
            results[1] = h*5;
            results[2] = w*8;
            results[3] = h*6;
            return results;

        }else if(p.equals("A2")){
            results[0] = 0;
            results[1] = h*6;
            results[2] = w;
            results[3] = h*7;
            return results;

        }else if(p.equals("B2")){
            results[0] = w;
            results[1] = h*6;
            results[2] = w*2;
            results[3] = h*7;
            return results;

        }else if(p.equals("C2")){
            results[0] = w*2;
            results[1] = h*6;
            results[2] = w*3;
            results[3] = h*7;
            return results;

        }else if(p.equals("D2")){
            results[0] = w*3;
            results[1] = h*6;
            results[2] = w*4;
            results[3] = h*7;
            return results;

        }else if(p.equals("E2")){
            results[0] = w*4;
            results[1] = h*6;
            results[2] = w*5;
            results[3] = h*7;
            return results;

        }else if(p.equals("F2")){
            results[0] = w*5;
            results[1] = h*6;
            results[2] = w*6;
            results[3] = h*7;
            return results;

        }else if(p.equals("G2")){
            results[0] = w*6;
            results[1] = h*6;
            results[2] = w*7;
            results[3] = h*7;
            return results;

        }else if(p.equals("H2")){
            results[0] = w*7;
            results[1] = h*6;
            results[2] = w*8;
            results[3] = h*7;
            return results;

        }else if(p.equals("A1")){
            results[0] = 0;
            results[1] = h*7;
            results[2] = w;
            results[3] = h*8;
            return results;

        }else if(p.equals("B1")){
            results[0] = w;
            results[1] = h*7;
            results[2] = w*2;
            results[3] = h*8;
            return results;

        }else if(p.equals("C1")){
            results[0] = w*2;
            results[1] = h*7;
            results[2] = w*3;
            results[3] = h*8;
            return results;

        }else if(p.equals("D1")){
            results[0] = w*3;
            results[1] = h*7;
            results[2] = w*4;
            results[3] = h*8;
            return results;

        }else if(p.equals("E1")){
            results[0] = w*4;
            results[1] = h*7;
            results[2] = w*5;
            results[3] = h*8;
            return results;

        }else if(p.equals("F1")){
            results[0] = w*5;
            results[1] = h*7;
            results[2] = w*6;
            results[3] = h*8;
            return results;

        }else if(p.equals("G1")){
            results[0] = w*6;
            results[1] = h*7;
            results[2] = w*7;
            results[3] = h*8;
            return results;

        }else{           //H1
            results[0] = w*7;
            results[1] = h*7;
            results[2] = w*8;
            results[3] = h*8;
            return results;

        }
    }

    private void DrawChessBoard(Canvas canvas){
        arrRect = new RectF[8][8];

        float topAdd = canvas.getHeight()/8;
        float bottomAdd = canvas.getHeight()/8;
        float leftAdd = canvas.getWidth()/8;
        float rightAdd = canvas.getWidth()/8;


        float top = 0;
        float bottom = canvas.getHeight()/8;
        float color[][] = {{0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0}};
        for(int r=0;r<8;++r){
            float right = canvas.getWidth()/8;
            float left = 0;
            for(int c=0;c<8;++c){
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
            bottom+=bottomAdd;
            top+=topAdd;
        }
    }

    private void InitialiseBoardColors(){
        arrPaint = new Paint[8][8];
        float c[][] = {{0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0}};

        for(int row=0;row<8;++row){
            for(int col=0;col<8;++col){
                if(c[row][col]==0){
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

}

