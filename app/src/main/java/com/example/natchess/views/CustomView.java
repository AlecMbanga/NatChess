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
import com.firebase.client.Firebase;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
    private Piece[][] allPieces;
    private boolean selected;
    private Piece selectedPiece;
    private Piece moveFrom;
    private Piece moveTo;
    private boolean move;
    private int moveFromR;
    private int moveFromC;
    private int moveToR;
    private int moveToC;
    private float color[][] = {{0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0}};
    private ArrayList<String> legalMoves;
    private ArrayList<String> validMoves = new ArrayList<>();

    private Firebase mRootRef;

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
        mRootRef = new Firebase("https://natchess-d50b2.firebaseio.com/Test");
        InitialiseBoardColors();
        allPieces = new Piece[4][8];

        //black pieces arrangement
        allPieces[0][0] = new Piece("rook","black","A8");
        allPieces[0][1] = new Piece("Knight","black","B8");
        allPieces[0][2] = new Piece("bishop","black","C8");
        allPieces[0][3] = new Piece("queen","black","D8");
        allPieces[0][4] = new Piece("king","black","E8");
        allPieces[0][5] = new Piece("bishop","black","F8");
        allPieces[0][6] = new Piece("Knight","black","G8");
        allPieces[0][7] = new Piece("rook","black","H8");
        allPieces[1][0] = new Piece("pawn","black","A7");
        allPieces[1][1] = new Piece("pawn","black","B7");
        allPieces[1][2] = new Piece("pawn","black","C7");
        allPieces[1][3] = new Piece("pawn","black","D7");
        allPieces[1][4] = new Piece("pawn","black","E7");
        allPieces[1][5] = new Piece("pawn","black","F7");
        allPieces[1][6] = new Piece("pawn","black","G7");
        allPieces[1][7] = new Piece("pawn","black","H7");

        //white pieces arrangement
        allPieces[3][0] = new Piece("rook","white","A1");
        allPieces[3][1] = new Piece("Knight","white","B1");
        allPieces[3][2] = new Piece("bishop","white","C1");
        allPieces[3][3] = new Piece("queen","white","D1");
        allPieces[3][4] = new Piece("king","white","E1");
        allPieces[3][5] = new Piece("bishop","white","F1");
        allPieces[3][6] = new Piece("Knight","white","G1");
        allPieces[3][7] = new Piece("rook","white","H1");
        allPieces[2][0] = new Piece("pawn","white","A2");
        allPieces[2][1] = new Piece("pawn","white","B2");
        allPieces[2][2] = new Piece("pawn","white","C2");
        allPieces[2][3] = new Piece("pawn","white","D2");
        allPieces[2][4] = new Piece("pawn","white","E2");
        allPieces[2][5] = new Piece("pawn","white","F2");
        allPieces[2][6] = new Piece("pawn","white","G2");
        allPieces[2][7] = new Piece("pawn","white","H2");


        selected = false;
        move = false;
        moveFromC = -1;
        moveFromR = -1;
        moveToC = -1;
        moveToR = -1;

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

        return value;
    }

    public void paintMove(int pr, int pc, String p,int rs, int cs, boolean cont){
        //extracting info of clicked piece

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

        /////
        /////
        ///// posible place to verify which user is playing
        /////
        /////


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
                    legalMoves = selectedPiece.CalculateLegalMoves(allPieces);

                    if(legalMoves.contains(p)){
                        for(int hh=0;hh<legalMoves.size();++hh){
                            System.out.println("Alec possible is "+ legalMoves.get(hh));
                        }
                        if(cont){
                            allPieces[rs][cs].position = "null";
                        }
                        moveToR = pr;
                        moveToC = pc;
                        selected = false;
                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                        selectedPiece.position = p;
                        arrPaint[pr][pc].setColor(Color.GRAY);
                        System.out.println(" to " + selectedPiece.position);
                        invalidate();
                    }
                }else if(selectedPiece.name.equals("pawn")){
                    legalMoves = selectedPiece.CalculateLegalMoves(allPieces);

                    if(legalMoves.contains(p)){
                        for(int hh=0;hh<legalMoves.size();++hh){
                            System.out.println("Alec possible is "+ legalMoves.get(hh));
                        }
                        if(cont){
                            allPieces[rs][cs].position = "null";
                        }
                        moveToR = pr;
                        moveToC = pc;
                        selected = false;
                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                        selectedPiece.position = p;
                        arrPaint[pr][pc].setColor(Color.GRAY);
                        System.out.println(" to " + selectedPiece.position);
                        invalidate();
                    }
                }
                else if(selectedPiece.name.equals("rook")){
                    legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                    if(legalMoves.contains(p)){
                        for(int hh=0;hh<legalMoves.size();++hh){
                            System.out.println("Alec possible is "+ legalMoves.get(hh));
                        }
                        if(cont){
                            allPieces[rs][cs].position = "null";
                        }
                        moveToR = pr;
                        moveToC = pc;
                        selected = false;
                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                        selectedPiece.position = p;
                        arrPaint[pr][pc].setColor(Color.GRAY);
                        System.out.println(" to " + selectedPiece.position);
                        invalidate();
                    }
                }
                else if(selectedPiece.name.equals("bishop")){
                    legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                    if(legalMoves.contains(p)){
                        for(int hh=0;hh<legalMoves.size();++hh){
                            System.out.println("Alec possible is "+ legalMoves.get(hh));
                        }
                        if(cont){
                            allPieces[rs][cs].position = "null";
                        }
                        moveToR = pr;
                        moveToC = pc;
                        selected = false;
                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                        selectedPiece.position = p;
                        arrPaint[pr][pc].setColor(Color.GRAY);
                        System.out.println(" to " + selectedPiece.position);
                        invalidate();
                    }
                }
                else if(selectedPiece.name.equals("queen")){
                    legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                    if(legalMoves.contains(p)){
                        for(int hh=0;hh<legalMoves.size();++hh){
                            System.out.println("Alec possible is "+ legalMoves.get(hh));
                        }
                        if(cont){
                            allPieces[rs][cs].position = "null";
                        }
                        moveToR = pr;
                        moveToC = pc;
                        selected = false;
                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                        selectedPiece.position = p;
                        arrPaint[pr][pc].setColor(Color.GRAY);
                        System.out.println(" to " + selectedPiece.position);
                        invalidate();
                    }
                }
                else if(selectedPiece.name.equals("king")){
                    legalMoves = selectedPiece.CalculateLegalMoves(allPieces);
                    if(legalMoves.contains(p)){
                        for(int hh=0;hh<legalMoves.size();++hh){
                            System.out.println("Alec possible is "+ legalMoves.get(hh));
                        }
                        if(cont){
                            allPieces[rs][cs].position = "null";
                        }
                        moveToR = pr;
                        moveToC = pc;
                        selected = false;
                        System.out.print("Alec this is a move of " + selectedPiece.color + " " + selectedPiece.name + " from " + selectedPiece.position);
                        selectedPiece.position = p;
                        arrPaint[pr][pc].setColor(Color.GRAY);
                        System.out.println(" to " + selectedPiece.position);
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

    private void DrawChessPieces(Canvas canvas){

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


        //draw all black pieces
        float[] Positionp1 = post(allPieces[1][0].position,canvas);
        if(Positionp1 != null){
            p1Scale = new RectF(Positionp1[0],Positionp1[1],Positionp1[2],Positionp1[3]);
            canvas.drawBitmap(bpawn,null,p1Scale,null);
        }


        float[] Positionp2 = post(allPieces[1][1].position,canvas);
        if(Positionp2 != null){
            p2Scale = new RectF(Positionp2[0],Positionp2[1],Positionp2[2],Positionp2[3]);
            canvas.drawBitmap(bpawn,null,p2Scale,null);
        }

        float[] Positionp3 = post(allPieces[1][2].position,canvas);
        if(Positionp3 != null){
            p3Scale = new RectF(Positionp3[0],Positionp3[1],Positionp3[2],Positionp3[3]);
            canvas.drawBitmap(bpawn,null,p3Scale,null);
        }


        float[] Positionp4 = post(allPieces[1][3].position,canvas);
        if(Positionp4!=null){
            p4Scale = new RectF(Positionp4[0],Positionp4[1],Positionp4[2],Positionp4[3]);
            canvas.drawBitmap(bpawn,null,p4Scale,null);
        }

        float[] Positionp5 = post(allPieces[1][4].position,canvas);
        if(Positionp5!=null){
            p5Scale = new RectF(Positionp5[0],Positionp5[1],Positionp5[2],Positionp5[3]);
            canvas.drawBitmap(bpawn,null,p5Scale,null);
        }


        float[] Positionp6 = post(allPieces[1][5].position,canvas);
        if(Positionp6!=null){
            p6Scale = new RectF(Positionp6[0],Positionp6[1],Positionp6[2],Positionp6[3]);
            canvas.drawBitmap(bpawn,null,p6Scale,null);
        }


        float[] Positionp7 = post(allPieces[1][6].position,canvas);
        if(Positionp7!=null){
            p7Scale = new RectF(Positionp7[0],Positionp7[1],Positionp7[2],Positionp7[3]);
            canvas.drawBitmap(bpawn,null,p7Scale,null);
        }


        float[] Positionp8 = post(allPieces[1][7].position,canvas);
        if(Positionp8!=null){
            p8Scale = new RectF(Positionp8[0],Positionp8[1],Positionp8[2],Positionp8[3]);
            canvas.drawBitmap(bpawn,null,p8Scale,null);
        }

        float[] Positionr1 = post(allPieces[0][0].position,canvas);
        if(Positionr1!=null){
            r1Scale = new RectF(Positionr1[0],Positionr1[1],Positionr1[2],Positionr1[3]);
            canvas.drawBitmap(brook,null,r1Scale,null);
        }

        float[] Positionr2 = post(allPieces[0][7].position,canvas);
        if(Positionr2!=null){
            r2Scale = new RectF(Positionr2[0],Positionr2[1],Positionr2[2],Positionr2[3]);
            canvas.drawBitmap(brook,null,r2Scale,null);
        }


        float[] Positionn1 = post(allPieces[0][1].position,canvas);
        if(Positionn1!=null){
            n1Scale = new RectF(Positionn1[0],Positionn1[1],Positionn1[2],Positionn1[3]);
            canvas.drawBitmap(bnight,null,n1Scale,null);
        }

        float[] Positionn2 = post(allPieces[0][6].position,canvas);
        if(Positionn2!=null){
            n2Scale = new RectF(Positionn2[0],Positionn2[1],Positionn2[2],Positionn2[3]);
            canvas.drawBitmap(bnight,null,n2Scale,null);
        }


        float[] Positionb2 = post(allPieces[0][5].position,canvas);
        if(Positionb2!=null){
            b2Scale = new RectF(Positionb2[0],Positionb2[1],Positionb2[2],Positionb2[3]);
            canvas.drawBitmap(bbishop,null,b2Scale,null);
        }


        float[] Positionb1 = post(allPieces[0][2].position,canvas);
        if(Positionb1!=null){
            b1Scale = new RectF(Positionb1[0],Positionb1[1],Positionb1[2],Positionb1[3]);
            canvas.drawBitmap(bbishop,null,b1Scale,null);
        }

        float[] Positionq = post(allPieces[0][3].position,canvas);
        if(Positionq!=null){
            qScale = new RectF(Positionq[0],Positionq[1],Positionq[2],Positionq[3]);
            canvas.drawBitmap(bqueen,null,qScale,null);
        }


        float[] Positionk = post(allPieces[0][4].position,canvas);
        if(Positionk!=null){
            kScale = new RectF(Positionk[0],Positionk[1],Positionk[2],Positionk[3]);
            canvas.drawBitmap(bking,null,kScale,null);
        }





        //draw all white pieces
        float[] Positionp1w = post(allPieces[2][0].position,canvas);
        if(Positionp1w!=null){
            p1wScale = new RectF(Positionp1w[0],Positionp1w[1],Positionp1w[2],Positionp1w[3]);
            canvas.drawBitmap(wpawn,null,p1wScale,null);
        }


        float[] Positionp2w = post(allPieces[2][1].position,canvas);
        if(Positionp2w!=null){
            p2wScale = new RectF(Positionp2w[0],Positionp2w[1],Positionp2w[2],Positionp2w[3]);
            canvas.drawBitmap(wpawn,null,p2wScale,null);

        }

        float[] Positionp3w = post(allPieces[2][2].position,canvas);
        if(Positionp3w!=null){
            p3wScale = new RectF(Positionp3w[0],Positionp3w[1],Positionp3w[2],Positionp3w[3]);
            canvas.drawBitmap(wpawn,null,p3wScale,null);
        }


        float[] Positionp4w = post(allPieces[2][3].position,canvas);
        if(Positionp4w!=null){
            p4wScale = new RectF(Positionp4w[0],Positionp4w[1],Positionp4w[2],Positionp4w[3]);
            canvas.drawBitmap(wpawn,null,p4wScale,null);
        }


        float[] Positionp5w = post(allPieces[2][4].position,canvas);
        if(Positionp5w!=null){
            p5wScale = new RectF(Positionp5w[0],Positionp5w[1],Positionp5w[2],Positionp5w[3]);
            canvas.drawBitmap(wpawn,null,p5wScale,null);
        }

        float[] Positionp6w = post(allPieces[2][5].position,canvas);
        if(Positionp6w!=null){
            p6wScale = new RectF(Positionp6w[0],Positionp6w[1],Positionp6w[2],Positionp6w[3]);
            canvas.drawBitmap(wpawn,null,p6wScale,null);
        }


        float[] Positionp7w = post(allPieces[2][6].position,canvas);
        if(Positionp7w!=null){
            p7wScale = new RectF(Positionp7w[0],Positionp7w[1],Positionp7w[2],Positionp7w[3]);
            canvas.drawBitmap(wpawn,null,p7wScale,null);
        }


        float[] Positionp8w = post(allPieces[2][7].position,canvas);
        if(Positionp8w!=null){
            p8wScale = new RectF(Positionp8w[0],Positionp8w[1],Positionp8w[2],Positionp8w[3]);
            canvas.drawBitmap(wpawn,null,p8wScale,null);
        }


        float[] Positionr1w = post(allPieces[3][0].position,canvas);
        if(Positionr1w!=null){
            r1wScale = new RectF(Positionr1w[0],Positionr1w[1],Positionr1w[2],Positionr1w[3]);
            canvas.drawBitmap(wrook,null,r1wScale,null);
        }


        float[] Positionr2w = post(allPieces[3][7].position,canvas);
        if(Positionr2w!=null){
            r2wScale = new RectF(Positionr2w[0],Positionr2w[1],Positionr2w[2],Positionr2w[3]);
            canvas.drawBitmap(wrook,null,r2wScale,null);
        }


        float[] Positionn1w = post(allPieces[3][1].position,canvas);
        if(Positionn1w!=null){
            n1wScale = new RectF(Positionn1w[0],Positionn1w[1],Positionn1w[2],Positionn1w[3]);
            canvas.drawBitmap(wnight,null,n1wScale,null);
        }


        float[] Positionn2w = post(allPieces[3][6].position,canvas);
        if(Positionn2w!=null){
            n2wScale = new RectF(Positionn2w[0],Positionn2w[1],Positionn2w[2],Positionn2w[3]);
            canvas.drawBitmap(wnight,null,n2wScale,null);
        }


        float[] Positionb2w = post(allPieces[3][5].position,canvas);
        if(Positionb2w!=null){
            b2wScale = new RectF(Positionb2w[0],Positionb2w[1],Positionb2w[2],Positionb2w[3]);
            canvas.drawBitmap(wbishop,null,b2wScale,null);
        }


        float[] Positionb1w = post(allPieces[3][2].position,canvas);
        if(Positionb1w!=null){
            b1wScale = new RectF(Positionb1w[0],Positionb1w[1],Positionb1w[2],Positionb1w[3]);
            canvas.drawBitmap(wbishop,null,b1wScale,null);
        }


        float[] Positionqw = post(allPieces[3][3].position,canvas);
        if(Positionqw!=null){
            qwScale = new RectF(Positionqw[0],Positionqw[1],Positionqw[2],Positionqw[3]);
            canvas.drawBitmap(wqueen,null,qwScale,null);
        }


        float[] Positionkw = post(allPieces[3][4].position,canvas);
        if(Positionkw!=null){
            kwScale = new RectF(Positionkw[0],Positionkw[1],Positionkw[2],Positionkw[3]);
            canvas.drawBitmap(wking,null,kwScale,null);
        }

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
            results[3] = h*5;
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

        }else if(p.equals("H1")){   //H1
            results[0] = w*7;
            results[1] = h*7;
            results[2] = w*8;
            results[3] = h*8;
            return results;
        }

        return null;
    }

    private void DrawChessBoard(Canvas canvas){
        arrRect = new RectF[8][8];

        float topAdd = canvas.getHeight()/8;
        float bottomAdd = canvas.getHeight()/8;
        float leftAdd = canvas.getWidth()/8;
        float rightAdd = canvas.getWidth()/8;


        float top = 0;
        float bottom = canvas.getHeight()/8;

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

