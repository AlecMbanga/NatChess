package com.example.natchess;


import java.util.ArrayList;
import java.util.Arrays;

public class Piece {
    public String name;
    public String color;
    public String position;
    public String status;
    public ArrayList<String> board = new ArrayList<String>(Arrays.asList("A1","B1","C1","D1","E1","F1","G1","H1",
                                                                         "A2","B2","C2","D2","E2","F2","G2","H2",
                                                                         "A3","B3","C3","D3","E3","F3","G3","H3",
                                                                         "A4","B4","C4","D4","E4","F4","G4","H4",
                                                                         "A5","B5","C5","D5","E5","F5","G5","H5",
                                                                         "A6","B6","C6","D6","E6","F6","G6","H6",
                                                                         "A7","B7","C7","D7","E7","F7","G7","H7",
                                                                         "A8","B8","C8","D8","E8","F8","G8","H8"));


    public Piece(String name,String color, String position){
        this.name = name;
        this.color = color;
        this.position = position;
        this.status = "alive";
    }

    public ArrayList<String> CalculateLegalMoves(){
        if(name.equals("king")){

        }else if(name.equals("queen")){

        }else if(name.equals("bishop")){

        }else if(name.equals("rook")){
            return rookMoves();

        }else if(name.equals("pawn")){
            return pawnMoves();

        }else{
            return KnightMoves();
        }
        return null;
    }

    public ArrayList<String> rookMoves(){

        return null;
    }

    public ArrayList<String> pawnMoves(){
        ArrayList<String> moves = new ArrayList<>();

        int num = (int)position.charAt(1)-48;
        char alpha = (char)(position.charAt(0));

        if(color.equals("black")){
            String posibility = Character.toString(alpha) + Integer.toString(num-1);
            if(board.contains(posibility)){
                moves.add(posibility);
            }
        }else {
            String posibility = Character.toString(alpha) + Integer.toString(num+1);
            if(board.contains(posibility)){
                moves.add(posibility);
            }
        }

        return moves;
    }

    public ArrayList<String> KnightMoves(){
        ArrayList<String> moves = new ArrayList<>();

        int num = (int)position.charAt(1)-48;

        char alphaRemove1 = (char)(position.charAt(0)-1);
        char alphaRemove2 = (char)(position.charAt(0)-2);
        char alphaAdd1 = (char)(position.charAt(0)+1);
        char alphaAdd2 = (char)(position.charAt(0)+2);

        int numRemove1 = num+1;
        int numRemove2 = num+2;
        int numAdd1 = num-1;
        int numAdd2 = num-2;

        String posibility1 = Character.toString(alphaAdd1) + Integer.toString(numRemove2);
        String posibility2 = Character.toString(alphaAdd2) + Integer.toString(numRemove1);
        String posibility3 = Character.toString(alphaAdd2) + Integer.toString(numAdd1);
        String posibility4 = Character.toString(alphaAdd1) + Integer.toString(numAdd2);
        String posibility5 = Character.toString(alphaRemove1) + Integer.toString(numAdd2);
        String posibility6 = Character.toString(alphaRemove2) + Integer.toString(numAdd1);
        String posibility7 = Character.toString(alphaRemove2) + Integer.toString(numRemove1);
        String posibility8 = Character.toString(alphaRemove1) + Integer.toString(numRemove2);

        if(board.contains(posibility1)){
            moves.add(posibility1);
        }
        if(board.contains(posibility2)){
            moves.add(posibility2);
        }
        if(board.contains(posibility3)){
            moves.add(posibility3);
        }
        if(board.contains(posibility4)){
            moves.add(posibility4);
        }
        if(board.contains(posibility5)){
            moves.add(posibility5);
        }
        if(board.contains(posibility6)){
            moves.add(posibility6);
        }
        if(board.contains(posibility7)){
            moves.add(posibility7);
        }
        if(board.contains(posibility8)){
            moves.add(posibility8);
        }

        return moves;
    }

}
