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

    public ArrayList<String> CalculateLegalMoves(Piece[][] allPieces){
        if(name.equals("king")){

        }else if(name.equals("queen")){
            return queenMoves(allPieces);

        }else if(name.equals("bishop")){
            return bishopMoves(allPieces);

        }else if(name.equals("rook")){
            return rookMoves(allPieces);

        }else if(name.equals("pawn")){
            return pawnMoves(allPieces);

        }else{
            return KnightMoves(allPieces);
        }
        return null;
    }

    public ArrayList<String> queenMoves(Piece[][] allPieces){
        ArrayList<String> moves = new ArrayList<>();

        ArrayList<String> takenBlocks = new ArrayList<>();
        ArrayList<String> takenBlocksColor = new ArrayList<>();

        for(int r=0;r<allPieces.length;++r){
            for(int c=0;c<allPieces[0].length;++c){
                if(!allPieces[r][c].equals("null")){
                    takenBlocks.add(allPieces[r][c].position);
                    takenBlocksColor.add(allPieces[r][c].color);
                }
            }
        }


        int num = (int)position.charAt(1)-48;
        char alpha = (char)(position.charAt(0));



        //all diagonals moves

        char alphaRemove1 = (char)(position.charAt(0)-1);
        char alphaRemove2 = (char)(position.charAt(0)-2);
        char alphaRemove3 = (char)(position.charAt(0)-3);
        char alphaRemove4 = (char)(position.charAt(0)-4);
        char alphaRemove5 = (char)(position.charAt(0)-5);
        char alphaRemove6 = (char)(position.charAt(0)-6);
        char alphaRemove7 = (char)(position.charAt(0)-7);
        char alphaAdd1 = (char)(position.charAt(0)+1);
        char alphaAdd2 = (char)(position.charAt(0)+2);
        char alphaAdd3 = (char)(position.charAt(0)+3);
        char alphaAdd4 = (char)(position.charAt(0)+4);
        char alphaAdd5 = (char)(position.charAt(0)+5);
        char alphaAdd6 = (char)(position.charAt(0)+6);
        char alphaAdd7 = (char)(position.charAt(0)+7);

        int numRemove1 = num-1;
        int numRemove2 = num-2;
        int numRemove3 = num-3;
        int numRemove4 = num-4;
        int numRemove5 = num-5;
        int numRemove6 = num-6;
        int numRemove7 = num-7;
        int numAdd1 = num+1;
        int numAdd2 = num+2;
        int numAdd3 = num+3;
        int numAdd4 = num+4;
        int numAdd5 = num+5;
        int numAdd6 = num+6;
        int numAdd7 = num+7;

        //up right
        String posibility1 = Character.toString(alphaAdd1) + Integer.toString(numAdd1);
        String posibility2 = Character.toString(alphaAdd2) + Integer.toString(numAdd2);
        String posibility3 = Character.toString(alphaAdd3) + Integer.toString(numAdd3);
        String posibility4 = Character.toString(alphaAdd4) + Integer.toString(numAdd4);
        String posibility5 = Character.toString(alphaAdd5) + Integer.toString(numAdd5);
        String posibility6 = Character.toString(alphaAdd6) + Integer.toString(numAdd6);
        String posibility7 = Character.toString(alphaAdd7) + Integer.toString(numAdd7);

        //up left
        String posibility8  = Character.toString(alphaRemove1) + Integer.toString(numAdd1);
        String posibility9  = Character.toString(alphaRemove2) + Integer.toString(numAdd2);
        String posibility10 = Character.toString(alphaRemove3) + Integer.toString(numAdd3);
        String posibility11 = Character.toString(alphaRemove4) + Integer.toString(numAdd4);
        String posibility12 = Character.toString(alphaRemove5) + Integer.toString(numAdd5);
        String posibility13 = Character.toString(alphaRemove6) + Integer.toString(numAdd6);
        String posibility14 = Character.toString(alphaRemove7) + Integer.toString(numAdd7);

        //down left
        String posibility15 = Character.toString(alphaRemove1) + Integer.toString(numRemove1);
        String posibility16 = Character.toString(alphaRemove2) + Integer.toString(numRemove2);
        String posibility17 = Character.toString(alphaRemove3) + Integer.toString(numRemove3);
        String posibility18 = Character.toString(alphaRemove4) + Integer.toString(numRemove4);
        String posibility19 = Character.toString(alphaRemove5) + Integer.toString(numRemove5);
        String posibility20 = Character.toString(alphaRemove6) + Integer.toString(numRemove6);
        String posibility21 = Character.toString(alphaRemove7) + Integer.toString(numRemove7);

        //down right
        String posibility22 = Character.toString(alphaAdd1) + Integer.toString(numRemove1);
        String posibility23 = Character.toString(alphaAdd2) + Integer.toString(numRemove2);
        String posibility24 = Character.toString(alphaAdd3) + Integer.toString(numRemove3);
        String posibility25 = Character.toString(alphaAdd4) + Integer.toString(numRemove4);
        String posibility26 = Character.toString(alphaAdd5) + Integer.toString(numRemove5);
        String posibility27 = Character.toString(alphaAdd6) + Integer.toString(numRemove6);
        String posibility28 = Character.toString(alphaAdd7) + Integer.toString(numRemove7);

        //UP movements
        if(takenBlocks.contains(posibility1)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility1)).equals("white")){
                moves.add(posibility1);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility1)).equals("black")){
                moves.add(posibility1);
            }
        }else if(takenBlocks.contains(posibility2)){
            moves.add(posibility1);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility2)).equals("white")){
                moves.add(posibility2);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility2)).equals("black")){
                moves.add(posibility2);
            }
        }else if(takenBlocks.contains(posibility3)){
            moves.add(posibility1);
            moves.add(posibility2);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility3)).equals("white")){
                moves.add(posibility3);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility3)).equals("black")){
                moves.add(posibility3);
            }
        }else if(takenBlocks.contains(posibility4)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility4)).equals("white")){
                moves.add(posibility4);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility4)).equals("black")){
                moves.add(posibility4);
            }
        }else if(takenBlocks.contains(posibility5)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            moves.add(posibility4);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility5)).equals("white")){
                moves.add(posibility5);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility5)).equals("black")){
                moves.add(posibility5);
            }
        }else if(takenBlocks.contains(posibility6)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            moves.add(posibility4);
            moves.add(posibility5);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility6)).equals("white")){
                moves.add(posibility6);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility6)).equals("black")){
                moves.add(posibility6);
            }
        }
        else if(takenBlocks.contains(posibility7)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            moves.add(posibility4);
            moves.add(posibility5);
            moves.add(posibility6);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility7)).equals("white")){
                moves.add(posibility7);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility7)).equals("black")){
                moves.add(posibility7);
            }
        }
        else{
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
        }

        //Down Movements
        if(takenBlocks.contains(posibility8)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility8)).equals("white")){
                moves.add(posibility8);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility8)).equals("black")){
                moves.add(posibility8);
            }
        }else if(takenBlocks.contains(posibility9)){
            moves.add(posibility8);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility9)).equals("white")){
                moves.add(posibility9);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility9)).equals("black")){
                moves.add(posibility9);
            }
        }else if(takenBlocks.contains(posibility10)){
            moves.add(posibility8);
            moves.add(posibility9);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility10)).equals("white")){
                moves.add(posibility10);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility10)).equals("black")){
                moves.add(posibility10);
            }
        }else if(takenBlocks.contains(posibility11)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility11)).equals("white")){
                moves.add(posibility11);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility11)).equals("black")){
                moves.add(posibility11);
            }
        }else if(takenBlocks.contains(posibility12)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility12)).equals("white")){
                moves.add(posibility12);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility12)).equals("black")){
                moves.add(posibility12);
            }
        }else if(takenBlocks.contains(posibility13)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            moves.add(posibility12);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility13)).equals("white")){
                moves.add(posibility13);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility13)).equals("black")){
                moves.add(posibility13);
            }
        }
        else if(takenBlocks.contains(posibility14)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            moves.add(posibility12);
            moves.add(posibility13);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility14)).equals("white")){
                moves.add(posibility14);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility14)).equals("black")){
                moves.add(posibility14);
            }
        }
        else{
            if(board.contains(posibility8)){
                moves.add(posibility8);
            }
            if(board.contains(posibility9)){
                moves.add(posibility9);
            }
            if(board.contains(posibility10)){
                moves.add(posibility10);
            }
            if(board.contains(posibility11)){
                moves.add(posibility11);
            }
            if(board.contains(posibility12)){
                moves.add(posibility12);
            }
            if(board.contains(posibility13)){
                moves.add(posibility13);
            }
            if(board.contains(posibility14)){
                moves.add(posibility14);
            }
        }



        ///left movements
        if(takenBlocks.contains(posibility15)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility15)).equals("white")){
                moves.add(posibility15);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility15)).equals("black")){
                moves.add(posibility15);
            }
        }else if(takenBlocks.contains(posibility16)){
            moves.add(posibility15);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility16)).equals("white")){
                moves.add(posibility16);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility16)).equals("black")){
                moves.add(posibility16);
            }
        }else if(takenBlocks.contains(posibility17)){
            moves.add(posibility15);
            moves.add(posibility16);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility17)).equals("white")){
                moves.add(posibility17);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility17)).equals("black")){
                moves.add(posibility17);
            }
        }else if(takenBlocks.contains(posibility18)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility18)).equals("white")){
                moves.add(posibility18);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility18)).equals("black")){
                moves.add(posibility18);
            }
        }else if(takenBlocks.contains(posibility19)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility19)).equals("white")){
                moves.add(posibility19);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility19)).equals("black")){
                moves.add(posibility19);
            }
        }else if(takenBlocks.contains(posibility20)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            moves.add(posibility19);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility20)).equals("white")){
                moves.add(posibility20);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility20)).equals("black")){
                moves.add(posibility20);
            }
        }
        else if(takenBlocks.contains(posibility21)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            moves.add(posibility19);
            moves.add(posibility20);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility21)).equals("white")){
                moves.add(posibility21);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility21)).equals("black")){
                moves.add(posibility21);
            }
        }
        else{
            if(board.contains(posibility15)){
                moves.add(posibility15);
            }
            if(board.contains(posibility16)){
                moves.add(posibility16);
            }
            if(board.contains(posibility17)){
                moves.add(posibility17);
            }
            if(board.contains(posibility18)){
                moves.add(posibility18);
            }
            if(board.contains(posibility19)){
                moves.add(posibility19);
            }
            if(board.contains(posibility20)){
                moves.add(posibility20);
            }
            if(board.contains(posibility21)){
                moves.add(posibility21);
            }
        }

        //Right Movements
        if(takenBlocks.contains(posibility22)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility22)).equals("white")){
                moves.add(posibility22);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility22)).equals("black")){
                moves.add(posibility22);
            }
        }else if(takenBlocks.contains(posibility23)){
            moves.add(posibility22);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility23)).equals("white")){
                moves.add(posibility23);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility23)).equals("black")){
                moves.add(posibility23);
            }
        }else if(takenBlocks.contains(posibility24)){
            moves.add(posibility22);
            moves.add(posibility23);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility24)).equals("white")){
                moves.add(posibility24);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility24)).equals("black")){
                moves.add(posibility24);
            }
        }else if(takenBlocks.contains(posibility25)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility25)).equals("white")){
                moves.add(posibility25);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility25)).equals("black")){
                moves.add(posibility25);
            }
        }else if(takenBlocks.contains(posibility26)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility26)).equals("white")){
                moves.add(posibility26);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility26)).equals("black")){
                moves.add(posibility26);
            }
        }else if(takenBlocks.contains(posibility27)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            moves.add(posibility26);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility27)).equals("white")){
                moves.add(posibility27);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility27)).equals("black")){
                moves.add(posibility27);
            }
        }
        else if(takenBlocks.contains(posibility28)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            moves.add(posibility26);
            moves.add(posibility27);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility28)).equals("white")){
                moves.add(posibility28);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility28)).equals("black")){
                moves.add(posibility28);
            }
        }
        else{
            if(board.contains(posibility22)){
                moves.add(posibility22);
            }
            if(board.contains(posibility23)){
                moves.add(posibility23);
            }
            if(board.contains(posibility24)){
                moves.add(posibility24);
            }
            if(board.contains(posibility25)){
                moves.add(posibility25);
            }
            if(board.contains(posibility26)){
                moves.add(posibility26);
            }
            if(board.contains(posibility27)){
                moves.add(posibility27);
            }
            if(board.contains(posibility28)){
                moves.add(posibility28);
            }
        }


        //end of diagonals



        // start of verticals and horizontals


        char alphaRemove1s = (char)(position.charAt(0)-1);
        char alphaRemove2s = (char)(position.charAt(0)-2);
        char alphaRemove3s = (char)(position.charAt(0)-3);
        char alphaRemove4s = (char)(position.charAt(0)-4);
        char alphaRemove5s = (char)(position.charAt(0)-5);
        char alphaRemove6s = (char)(position.charAt(0)-6);
        char alphaRemove7s = (char)(position.charAt(0)-7);
        char alphaAdd1s = (char)(position.charAt(0)+1);
        char alphaAdd2s = (char)(position.charAt(0)+2);
        char alphaAdd3s = (char)(position.charAt(0)+3);
        char alphaAdd4s = (char)(position.charAt(0)+4);
        char alphaAdd5s = (char)(position.charAt(0)+5);
        char alphaAdd6s = (char)(position.charAt(0)+6);
        char alphaAdd7s = (char)(position.charAt(0)+7);

        int numRemove1s = num-1;
        int numRemove2s = num-2;
        int numRemove3s = num-3;
        int numRemove4s = num-4;
        int numRemove5s = num-5;
        int numRemove6s = num-6;
        int numRemove7s = num-7;
        int numAdd1s = num+1;
        int numAdd2s = num+2;
        int numAdd3s = num+3;
        int numAdd4s = num+4;
        int numAdd5s = num+5;
        int numAdd6s = num+6;
        int numAdd7s = num+7;

        //up
        String posibility1s = Character.toString(alpha) + Integer.toString(numAdd1s);
        String posibility2s = Character.toString(alpha) + Integer.toString(numAdd2s);
        String posibility3s = Character.toString(alpha) + Integer.toString(numAdd3s);
        String posibility4s = Character.toString(alpha) + Integer.toString(numAdd4s);
        String posibility5s = Character.toString(alpha) + Integer.toString(numAdd5s);
        String posibility6s = Character.toString(alpha) + Integer.toString(numAdd6s);
        String posibility7s = Character.toString(alpha) + Integer.toString(numAdd7s);

        //down
        String posibility8s  = Character.toString(alpha) + Integer.toString(numRemove1s);
        String posibility9s  = Character.toString(alpha) + Integer.toString(numRemove2s);
        String posibility10s = Character.toString(alpha) + Integer.toString(numRemove3s);
        String posibility11s = Character.toString(alpha) + Integer.toString(numRemove4s);
        String posibility12s = Character.toString(alpha) + Integer.toString(numRemove5s);
        String posibility13s = Character.toString(alpha) + Integer.toString(numRemove6s);
        String posibility14s = Character.toString(alpha) + Integer.toString(numRemove7s);

        //left
        String posibility15s = Character.toString(alphaRemove1s) + Integer.toString(num);
        String posibility16s = Character.toString(alphaRemove2s) + Integer.toString(num);
        String posibility17s = Character.toString(alphaRemove3s) + Integer.toString(num);
        String posibility18s = Character.toString(alphaRemove4s) + Integer.toString(num);
        String posibility19s = Character.toString(alphaRemove5s) + Integer.toString(num);
        String posibility20s = Character.toString(alphaRemove6s) + Integer.toString(num);
        String posibility21s = Character.toString(alphaRemove7s) + Integer.toString(num);

        //right
        String posibility22s = Character.toString(alphaAdd1s) + Integer.toString(num);
        String posibility23s = Character.toString(alphaAdd2s) + Integer.toString(num);
        String posibility24s = Character.toString(alphaAdd3s) + Integer.toString(num);
        String posibility25s = Character.toString(alphaAdd4s) + Integer.toString(num);
        String posibility26s = Character.toString(alphaAdd5s) + Integer.toString(num);
        String posibility27s = Character.toString(alphaAdd6s) + Integer.toString(num);
        String posibility28s = Character.toString(alphaAdd7s) + Integer.toString(num);


        //UP movements
        if(takenBlocks.contains(posibility1s)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility1s)).equals("white")){
                moves.add(posibility1s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility1s)).equals("black")){
                moves.add(posibility1s);
            }
        }else if(takenBlocks.contains(posibility2s)){
            moves.add(posibility1s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility2s)).equals("white")){
                moves.add(posibility2s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility2s)).equals("black")){
                moves.add(posibility2s);
            }
        }else if(takenBlocks.contains(posibility3s)){
            moves.add(posibility1s);
            moves.add(posibility2s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility3s)).equals("white")){
                moves.add(posibility3s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility3s)).equals("black")){
                moves.add(posibility3s);
            }
        }else if(takenBlocks.contains(posibility4s)){
            moves.add(posibility1s);
            moves.add(posibility2s);
            moves.add(posibility3s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility4s)).equals("white")){
                moves.add(posibility4s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility4s)).equals("black")){
                moves.add(posibility4s);
            }
        }else if(takenBlocks.contains(posibility5s)){
            moves.add(posibility1s);
            moves.add(posibility2s);
            moves.add(posibility3s);
            moves.add(posibility4s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility5s)).equals("white")){
                moves.add(posibility5s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility5s)).equals("black")){
                moves.add(posibility5s);
            }
        }else if(takenBlocks.contains(posibility6s)){
            moves.add(posibility1s);
            moves.add(posibility2s);
            moves.add(posibility3s);
            moves.add(posibility4s);
            moves.add(posibility5s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility6s)).equals("white")){
                moves.add(posibility6s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility6s)).equals("black")){
                moves.add(posibility6s);
            }
        }
        else if(takenBlocks.contains(posibility7s)){
            moves.add(posibility1s);
            moves.add(posibility2s);
            moves.add(posibility3s);
            moves.add(posibility4s);
            moves.add(posibility5s);
            moves.add(posibility6s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility7s)).equals("white")){
                moves.add(posibility7s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility7s)).equals("black")){
                moves.add(posibility7s);
            }
        }
        else{
            if(board.contains(posibility1s)){
                moves.add(posibility1s);
            }
            if(board.contains(posibility2s)){
                moves.add(posibility2s);
            }
            if(board.contains(posibility3s)){
                moves.add(posibility3s);
            }
            if(board.contains(posibility4s)){
                moves.add(posibility4s);
            }
            if(board.contains(posibility5s)){
                moves.add(posibility5s);
            }
            if(board.contains(posibility6s)){
                moves.add(posibility6s);
            }
            if(board.contains(posibility7s)){
                moves.add(posibility7s);
            }
        }

        //Down Movements
        if(takenBlocks.contains(posibility8s)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility8s)).equals("white")){
                moves.add(posibility8s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility8s)).equals("black")){
                moves.add(posibility8s);
            }
        }else if(takenBlocks.contains(posibility9s)){
            moves.add(posibility8s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility9s)).equals("white")){
                moves.add(posibility9s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility9s)).equals("black")){
                moves.add(posibility9s);
            }
        }else if(takenBlocks.contains(posibility10s)){
            moves.add(posibility8s);
            moves.add(posibility9s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility10s)).equals("white")){
                moves.add(posibility10s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility10s)).equals("black")){
                moves.add(posibility10s);
            }
        }else if(takenBlocks.contains(posibility11s)){
            moves.add(posibility8s);
            moves.add(posibility9s);
            moves.add(posibility10s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility11s)).equals("white")){
                moves.add(posibility11s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility11s)).equals("black")){
                moves.add(posibility11s);
            }
        }else if(takenBlocks.contains(posibility12s)){
            moves.add(posibility8s);
            moves.add(posibility9s);
            moves.add(posibility10s);
            moves.add(posibility11s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility12s)).equals("white")){
                moves.add(posibility12s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility12s)).equals("black")){
                moves.add(posibility12s);
            }
        }else if(takenBlocks.contains(posibility13s)){
            moves.add(posibility8s);
            moves.add(posibility9s);
            moves.add(posibility10s);
            moves.add(posibility11s);
            moves.add(posibility12s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility13s)).equals("white")){
                moves.add(posibility13s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility13s)).equals("black")){
                moves.add(posibility13s);
            }
        }
        else if(takenBlocks.contains(posibility14s)){
            moves.add(posibility8s);
            moves.add(posibility9s);
            moves.add(posibility10s);
            moves.add(posibility11s);
            moves.add(posibility12s);
            moves.add(posibility13s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility14s)).equals("white")){
                moves.add(posibility14s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility14s)).equals("black")){
                moves.add(posibility14s);
            }
        }
        else{
            if(board.contains(posibility8s)){
                moves.add(posibility8s);
            }
            if(board.contains(posibility9s)){
                moves.add(posibility9s);
            }
            if(board.contains(posibility10s)){
                moves.add(posibility10s);
            }
            if(board.contains(posibility11s)){
                moves.add(posibility11s);
            }
            if(board.contains(posibility12s)){
                moves.add(posibility12s);
            }
            if(board.contains(posibility13s)){
                moves.add(posibility13s);
            }
            if(board.contains(posibility14s)){
                moves.add(posibility14s);
            }
        }



        ///left movements
        if(takenBlocks.contains(posibility15s)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility15s)).equals("white")){
                moves.add(posibility15s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility15s)).equals("black")){
                moves.add(posibility15s);
            }
        }else if(takenBlocks.contains(posibility16s)){
            moves.add(posibility15s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility16s)).equals("white")){
                moves.add(posibility16s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility16s)).equals("black")){
                moves.add(posibility16s);
            }
        }else if(takenBlocks.contains(posibility17s)){
            moves.add(posibility15s);
            moves.add(posibility16s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility17s)).equals("white")){
                moves.add(posibility17s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility17s)).equals("black")){
                moves.add(posibility17s);
            }
        }else if(takenBlocks.contains(posibility18s)){
            moves.add(posibility15s);
            moves.add(posibility16s);
            moves.add(posibility17s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility18s)).equals("white")){
                moves.add(posibility18s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility18s)).equals("black")){
                moves.add(posibility18s);
            }
        }else if(takenBlocks.contains(posibility19s)){
            moves.add(posibility15s);
            moves.add(posibility16s);
            moves.add(posibility17s);
            moves.add(posibility18s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility19s)).equals("white")){
                moves.add(posibility19s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility19s)).equals("black")){
                moves.add(posibility19s);
            }
        }else if(takenBlocks.contains(posibility20s)){
            moves.add(posibility15s);
            moves.add(posibility16s);
            moves.add(posibility17s);
            moves.add(posibility18s);
            moves.add(posibility19s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility20s)).equals("white")){
                moves.add(posibility20s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility20s)).equals("black")){
                moves.add(posibility20s);
            }
        }
        else if(takenBlocks.contains(posibility21s)){
            moves.add(posibility15s);
            moves.add(posibility16s);
            moves.add(posibility17s);
            moves.add(posibility18s);
            moves.add(posibility19s);
            moves.add(posibility20s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility21s)).equals("white")){
                moves.add(posibility21s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility21s)).equals("black")){
                moves.add(posibility21s);
            }
        }
        else{
            if(board.contains(posibility15s)){
                moves.add(posibility15s);
            }
            if(board.contains(posibility16s)){
                moves.add(posibility16s);
            }
            if(board.contains(posibility17s)){
                moves.add(posibility17s);
            }
            if(board.contains(posibility18s)){
                moves.add(posibility18s);
            }
            if(board.contains(posibility19s)){
                moves.add(posibility19s);
            }
            if(board.contains(posibility20s)){
                moves.add(posibility20s);
            }
            if(board.contains(posibility21s)){
                moves.add(posibility21s);
            }
        }

        //Right Movements
        if(takenBlocks.contains(posibility22s)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility22s)).equals("white")){
                moves.add(posibility22s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility22s)).equals("black")){
                moves.add(posibility22s);
            }
        }else if(takenBlocks.contains(posibility23s)){
            moves.add(posibility22s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility23s)).equals("white")){
                moves.add(posibility23s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility23s)).equals("black")){
                moves.add(posibility23s);
            }
        }else if(takenBlocks.contains(posibility24s)){
            moves.add(posibility22s);
            moves.add(posibility23s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility24s)).equals("white")){
                moves.add(posibility24s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility24s)).equals("black")){
                moves.add(posibility24s);
            }
        }else if(takenBlocks.contains(posibility25s)){
            moves.add(posibility22s);
            moves.add(posibility23s);
            moves.add(posibility24s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility25s)).equals("white")){
                moves.add(posibility25s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility25s)).equals("black")){
                moves.add(posibility25s);
            }
        }else if(takenBlocks.contains(posibility26s)){
            moves.add(posibility22s);
            moves.add(posibility23s);
            moves.add(posibility24s);
            moves.add(posibility25s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility26s)).equals("white")){
                moves.add(posibility26s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility26s)).equals("black")){
                moves.add(posibility26s);
            }
        }else if(takenBlocks.contains(posibility27s)){
            moves.add(posibility22s);
            moves.add(posibility23s);
            moves.add(posibility24s);
            moves.add(posibility25s);
            moves.add(posibility26s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility27s)).equals("white")){
                moves.add(posibility27s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility27s)).equals("black")){
                moves.add(posibility27s);
            }
        }
        else if(takenBlocks.contains(posibility28s)){
            moves.add(posibility22s);
            moves.add(posibility23s);
            moves.add(posibility24s);
            moves.add(posibility25s);
            moves.add(posibility26s);
            moves.add(posibility27s);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility28s)).equals("white")){
                moves.add(posibility28s);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility28s)).equals("black")){
                moves.add(posibility28s);
            }
        }
        else{
            if(board.contains(posibility22s)){
                moves.add(posibility22s);
            }
            if(board.contains(posibility23s)){
                moves.add(posibility23s);
            }
            if(board.contains(posibility24s)){
                moves.add(posibility24s);
            }
            if(board.contains(posibility25s)){
                moves.add(posibility25s);
            }
            if(board.contains(posibility26s)){
                moves.add(posibility26s);
            }
            if(board.contains(posibility27s)){
                moves.add(posibility27s);
            }
            if(board.contains(posibility28s)){
                moves.add(posibility28s);
            }
        }



        // end


        return moves;
    }

    public ArrayList<String> bishopMoves(Piece[][] allPieces){
        ArrayList<String> moves = new ArrayList<>();

        ArrayList<String> takenBlocks = new ArrayList<>();
        ArrayList<String> takenBlocksColor = new ArrayList<>();

        for(int r=0;r<allPieces.length;++r){
            for(int c=0;c<allPieces[0].length;++c){
                if(!allPieces[r][c].equals("null")){
                    takenBlocks.add(allPieces[r][c].position);
                    takenBlocksColor.add(allPieces[r][c].color);
                }
            }
        }


        int num = (int)position.charAt(1)-48;
        char alpha = (char)(position.charAt(0));

        char alphaRemove1 = (char)(position.charAt(0)-1);
        char alphaRemove2 = (char)(position.charAt(0)-2);
        char alphaRemove3 = (char)(position.charAt(0)-3);
        char alphaRemove4 = (char)(position.charAt(0)-4);
        char alphaRemove5 = (char)(position.charAt(0)-5);
        char alphaRemove6 = (char)(position.charAt(0)-6);
        char alphaRemove7 = (char)(position.charAt(0)-7);
        char alphaAdd1 = (char)(position.charAt(0)+1);
        char alphaAdd2 = (char)(position.charAt(0)+2);
        char alphaAdd3 = (char)(position.charAt(0)+3);
        char alphaAdd4 = (char)(position.charAt(0)+4);
        char alphaAdd5 = (char)(position.charAt(0)+5);
        char alphaAdd6 = (char)(position.charAt(0)+6);
        char alphaAdd7 = (char)(position.charAt(0)+7);

        int numRemove1 = num-1;
        int numRemove2 = num-2;
        int numRemove3 = num-3;
        int numRemove4 = num-4;
        int numRemove5 = num-5;
        int numRemove6 = num-6;
        int numRemove7 = num-7;
        int numAdd1 = num+1;
        int numAdd2 = num+2;
        int numAdd3 = num+3;
        int numAdd4 = num+4;
        int numAdd5 = num+5;
        int numAdd6 = num+6;
        int numAdd7 = num+7;

        //up right
        String posibility1 = Character.toString(alphaAdd1) + Integer.toString(numAdd1);
        String posibility2 = Character.toString(alphaAdd2) + Integer.toString(numAdd2);
        String posibility3 = Character.toString(alphaAdd3) + Integer.toString(numAdd3);
        String posibility4 = Character.toString(alphaAdd4) + Integer.toString(numAdd4);
        String posibility5 = Character.toString(alphaAdd5) + Integer.toString(numAdd5);
        String posibility6 = Character.toString(alphaAdd6) + Integer.toString(numAdd6);
        String posibility7 = Character.toString(alphaAdd7) + Integer.toString(numAdd7);

        //up left
        String posibility8  = Character.toString(alphaRemove1) + Integer.toString(numAdd1);
        String posibility9  = Character.toString(alphaRemove2) + Integer.toString(numAdd2);
        String posibility10 = Character.toString(alphaRemove3) + Integer.toString(numAdd3);
        String posibility11 = Character.toString(alphaRemove4) + Integer.toString(numAdd4);
        String posibility12 = Character.toString(alphaRemove5) + Integer.toString(numAdd5);
        String posibility13 = Character.toString(alphaRemove6) + Integer.toString(numAdd6);
        String posibility14 = Character.toString(alphaRemove7) + Integer.toString(numAdd7);

        //down left
        String posibility15 = Character.toString(alphaRemove1) + Integer.toString(numRemove1);
        String posibility16 = Character.toString(alphaRemove2) + Integer.toString(numRemove2);
        String posibility17 = Character.toString(alphaRemove3) + Integer.toString(numRemove3);
        String posibility18 = Character.toString(alphaRemove4) + Integer.toString(numRemove4);
        String posibility19 = Character.toString(alphaRemove5) + Integer.toString(numRemove5);
        String posibility20 = Character.toString(alphaRemove6) + Integer.toString(numRemove6);
        String posibility21 = Character.toString(alphaRemove7) + Integer.toString(numRemove7);

        //down right
        String posibility22 = Character.toString(alphaAdd1) + Integer.toString(numRemove1);
        String posibility23 = Character.toString(alphaAdd2) + Integer.toString(numRemove2);
        String posibility24 = Character.toString(alphaAdd3) + Integer.toString(numRemove3);
        String posibility25 = Character.toString(alphaAdd4) + Integer.toString(numRemove4);
        String posibility26 = Character.toString(alphaAdd5) + Integer.toString(numRemove5);
        String posibility27 = Character.toString(alphaAdd6) + Integer.toString(numRemove6);
        String posibility28 = Character.toString(alphaAdd7) + Integer.toString(numRemove7);

        //UP movements
        if(takenBlocks.contains(posibility1)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility1)).equals("white")){
                moves.add(posibility1);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility1)).equals("black")){
                moves.add(posibility1);
            }
        }else if(takenBlocks.contains(posibility2)){
            moves.add(posibility1);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility2)).equals("white")){
                moves.add(posibility2);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility2)).equals("black")){
                moves.add(posibility2);
            }
        }else if(takenBlocks.contains(posibility3)){
            moves.add(posibility1);
            moves.add(posibility2);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility3)).equals("white")){
                moves.add(posibility3);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility3)).equals("black")){
                moves.add(posibility3);
            }
        }else if(takenBlocks.contains(posibility4)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility4)).equals("white")){
                moves.add(posibility4);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility4)).equals("black")){
                moves.add(posibility4);
            }
        }else if(takenBlocks.contains(posibility5)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            moves.add(posibility4);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility5)).equals("white")){
                moves.add(posibility5);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility5)).equals("black")){
                moves.add(posibility5);
            }
        }else if(takenBlocks.contains(posibility6)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            moves.add(posibility4);
            moves.add(posibility5);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility6)).equals("white")){
                moves.add(posibility6);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility6)).equals("black")){
                moves.add(posibility6);
            }
        }
        else if(takenBlocks.contains(posibility7)){
            moves.add(posibility1);
            moves.add(posibility2);
            moves.add(posibility3);
            moves.add(posibility4);
            moves.add(posibility5);
            moves.add(posibility6);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility7)).equals("white")){
                moves.add(posibility7);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility7)).equals("black")){
                moves.add(posibility7);
            }
        }
        else{
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
        }

        //Down Movements
        if(takenBlocks.contains(posibility8)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility8)).equals("white")){
                moves.add(posibility8);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility8)).equals("black")){
                moves.add(posibility8);
            }
        }else if(takenBlocks.contains(posibility9)){
            moves.add(posibility8);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility9)).equals("white")){
                moves.add(posibility9);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility9)).equals("black")){
                moves.add(posibility9);
            }
        }else if(takenBlocks.contains(posibility10)){
            moves.add(posibility8);
            moves.add(posibility9);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility10)).equals("white")){
                moves.add(posibility10);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility10)).equals("black")){
                moves.add(posibility10);
            }
        }else if(takenBlocks.contains(posibility11)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility11)).equals("white")){
                moves.add(posibility11);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility11)).equals("black")){
                moves.add(posibility11);
            }
        }else if(takenBlocks.contains(posibility12)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility12)).equals("white")){
                moves.add(posibility12);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility12)).equals("black")){
                moves.add(posibility12);
            }
        }else if(takenBlocks.contains(posibility13)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            moves.add(posibility12);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility13)).equals("white")){
                moves.add(posibility13);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility13)).equals("black")){
                moves.add(posibility13);
            }
        }
        else if(takenBlocks.contains(posibility14)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            moves.add(posibility12);
            moves.add(posibility13);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility14)).equals("white")){
                moves.add(posibility14);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility14)).equals("black")){
                moves.add(posibility14);
            }
        }
        else{
            if(board.contains(posibility8)){
                moves.add(posibility8);
            }
            if(board.contains(posibility9)){
                moves.add(posibility9);
            }
            if(board.contains(posibility10)){
                moves.add(posibility10);
            }
            if(board.contains(posibility11)){
                moves.add(posibility11);
            }
            if(board.contains(posibility12)){
                moves.add(posibility12);
            }
            if(board.contains(posibility13)){
                moves.add(posibility13);
            }
            if(board.contains(posibility14)){
                moves.add(posibility14);
            }
        }



        ///left movements
        if(takenBlocks.contains(posibility15)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility15)).equals("white")){
                moves.add(posibility15);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility15)).equals("black")){
                moves.add(posibility15);
            }
        }else if(takenBlocks.contains(posibility16)){
            moves.add(posibility15);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility16)).equals("white")){
                moves.add(posibility16);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility16)).equals("black")){
                moves.add(posibility16);
            }
        }else if(takenBlocks.contains(posibility17)){
            moves.add(posibility15);
            moves.add(posibility16);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility17)).equals("white")){
                moves.add(posibility17);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility17)).equals("black")){
                moves.add(posibility17);
            }
        }else if(takenBlocks.contains(posibility18)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility18)).equals("white")){
                moves.add(posibility18);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility18)).equals("black")){
                moves.add(posibility18);
            }
        }else if(takenBlocks.contains(posibility19)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility19)).equals("white")){
                moves.add(posibility19);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility19)).equals("black")){
                moves.add(posibility19);
            }
        }else if(takenBlocks.contains(posibility20)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            moves.add(posibility19);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility20)).equals("white")){
                moves.add(posibility20);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility20)).equals("black")){
                moves.add(posibility20);
            }
        }
        else if(takenBlocks.contains(posibility21)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            moves.add(posibility19);
            moves.add(posibility20);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility21)).equals("white")){
                moves.add(posibility21);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility21)).equals("black")){
                moves.add(posibility21);
            }
        }
        else{
            if(board.contains(posibility15)){
                moves.add(posibility15);
            }
            if(board.contains(posibility16)){
                moves.add(posibility16);
            }
            if(board.contains(posibility17)){
                moves.add(posibility17);
            }
            if(board.contains(posibility18)){
                moves.add(posibility18);
            }
            if(board.contains(posibility19)){
                moves.add(posibility19);
            }
            if(board.contains(posibility20)){
                moves.add(posibility20);
            }
            if(board.contains(posibility21)){
                moves.add(posibility21);
            }
        }

        //Right Movements
        if(takenBlocks.contains(posibility22)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility22)).equals("white")){
                moves.add(posibility22);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility22)).equals("black")){
                moves.add(posibility22);
            }
        }else if(takenBlocks.contains(posibility23)){
            moves.add(posibility22);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility23)).equals("white")){
                moves.add(posibility23);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility23)).equals("black")){
                moves.add(posibility23);
            }
        }else if(takenBlocks.contains(posibility24)){
            moves.add(posibility22);
            moves.add(posibility23);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility24)).equals("white")){
                moves.add(posibility24);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility24)).equals("black")){
                moves.add(posibility24);
            }
        }else if(takenBlocks.contains(posibility25)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility25)).equals("white")){
                moves.add(posibility25);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility25)).equals("black")){
                moves.add(posibility25);
            }
        }else if(takenBlocks.contains(posibility26)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility26)).equals("white")){
                moves.add(posibility26);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility26)).equals("black")){
                moves.add(posibility26);
            }
        }else if(takenBlocks.contains(posibility27)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            moves.add(posibility26);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility27)).equals("white")){
                moves.add(posibility27);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility27)).equals("black")){
                moves.add(posibility27);
            }
        }
        else if(takenBlocks.contains(posibility28)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            moves.add(posibility26);
            moves.add(posibility27);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility28)).equals("white")){
                moves.add(posibility28);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility28)).equals("black")){
                moves.add(posibility28);
            }
        }
        else{
            if(board.contains(posibility22)){
                moves.add(posibility22);
            }
            if(board.contains(posibility23)){
                moves.add(posibility23);
            }
            if(board.contains(posibility24)){
                moves.add(posibility24);
            }
            if(board.contains(posibility25)){
                moves.add(posibility25);
            }
            if(board.contains(posibility26)){
                moves.add(posibility26);
            }
            if(board.contains(posibility27)){
                moves.add(posibility27);
            }
            if(board.contains(posibility28)){
                moves.add(posibility28);
            }
        }

        return moves;
    }

    public ArrayList<String> rookMoves(Piece[][] allPieces){
        ArrayList<String> moves = new ArrayList<>();

        ArrayList<String> takenBlocks = new ArrayList<>();
        ArrayList<String> takenBlocksColor = new ArrayList<>();

        for(int r=0;r<allPieces.length;++r){
            for(int c=0;c<allPieces[0].length;++c){
                if(!allPieces[r][c].equals("null")){
                    takenBlocks.add(allPieces[r][c].position);
                    takenBlocksColor.add(allPieces[r][c].color);
                }
            }
        }

        int num = (int)position.charAt(1)-48;
        char alpha = (char)(position.charAt(0));

        char alphaRemove1 = (char)(position.charAt(0)-1);
        char alphaRemove2 = (char)(position.charAt(0)-2);
        char alphaRemove3 = (char)(position.charAt(0)-3);
        char alphaRemove4 = (char)(position.charAt(0)-4);
        char alphaRemove5 = (char)(position.charAt(0)-5);
        char alphaRemove6 = (char)(position.charAt(0)-6);
        char alphaRemove7 = (char)(position.charAt(0)-7);
        char alphaAdd1 = (char)(position.charAt(0)+1);
        char alphaAdd2 = (char)(position.charAt(0)+2);
        char alphaAdd3 = (char)(position.charAt(0)+3);
        char alphaAdd4 = (char)(position.charAt(0)+4);
        char alphaAdd5 = (char)(position.charAt(0)+5);
        char alphaAdd6 = (char)(position.charAt(0)+6);
        char alphaAdd7 = (char)(position.charAt(0)+7);

        int numRemove1 = num-1;
        int numRemove2 = num-2;
        int numRemove3 = num-3;
        int numRemove4 = num-4;
        int numRemove5 = num-5;
        int numRemove6 = num-6;
        int numRemove7 = num-7;
        int numAdd1 = num+1;
        int numAdd2 = num+2;
        int numAdd3 = num+3;
        int numAdd4 = num+4;
        int numAdd5 = num+5;
        int numAdd6 = num+6;
        int numAdd7 = num+7;

        //up
        String posibility1 = Character.toString(alpha) + Integer.toString(numAdd1);
        String posibility2 = Character.toString(alpha) + Integer.toString(numAdd2);
        String posibility3 = Character.toString(alpha) + Integer.toString(numAdd3);
        String posibility4 = Character.toString(alpha) + Integer.toString(numAdd4);
        String posibility5 = Character.toString(alpha) + Integer.toString(numAdd5);
        String posibility6 = Character.toString(alpha) + Integer.toString(numAdd6);
        String posibility7 = Character.toString(alpha) + Integer.toString(numAdd7);

        //down
        String posibility8  = Character.toString(alpha) + Integer.toString(numRemove1);
        String posibility9  = Character.toString(alpha) + Integer.toString(numRemove2);
        String posibility10 = Character.toString(alpha) + Integer.toString(numRemove3);
        String posibility11 = Character.toString(alpha) + Integer.toString(numRemove4);
        String posibility12 = Character.toString(alpha) + Integer.toString(numRemove5);
        String posibility13 = Character.toString(alpha) + Integer.toString(numRemove6);
        String posibility14 = Character.toString(alpha) + Integer.toString(numRemove7);

        //left
        String posibility15 = Character.toString(alphaRemove1) + Integer.toString(num);
        String posibility16 = Character.toString(alphaRemove2) + Integer.toString(num);
        String posibility17 = Character.toString(alphaRemove3) + Integer.toString(num);
        String posibility18 = Character.toString(alphaRemove4) + Integer.toString(num);
        String posibility19 = Character.toString(alphaRemove5) + Integer.toString(num);
        String posibility20 = Character.toString(alphaRemove6) + Integer.toString(num);
        String posibility21 = Character.toString(alphaRemove7) + Integer.toString(num);

        //right
        String posibility22 = Character.toString(alphaAdd1) + Integer.toString(num);
        String posibility23 = Character.toString(alphaAdd2) + Integer.toString(num);
        String posibility24 = Character.toString(alphaAdd3) + Integer.toString(num);
        String posibility25 = Character.toString(alphaAdd4) + Integer.toString(num);
        String posibility26 = Character.toString(alphaAdd5) + Integer.toString(num);
        String posibility27 = Character.toString(alphaAdd6) + Integer.toString(num);
        String posibility28 = Character.toString(alphaAdd7) + Integer.toString(num);


            //UP movements
            if(takenBlocks.contains(posibility1)){
                if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility1)).equals("white")){
                    moves.add(posibility1);
                }
                else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility1)).equals("black")){
                    moves.add(posibility1);
                }
            }else if(takenBlocks.contains(posibility2)){
                moves.add(posibility1);
                if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility2)).equals("white")){
                    moves.add(posibility2);
                }
                else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility2)).equals("black")){
                    moves.add(posibility2);
                }
            }else if(takenBlocks.contains(posibility3)){
                moves.add(posibility1);
                moves.add(posibility2);
                if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility3)).equals("white")){
                    moves.add(posibility3);
                }
                else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility3)).equals("black")){
                    moves.add(posibility3);
                }
            }else if(takenBlocks.contains(posibility4)){
                moves.add(posibility1);
                moves.add(posibility2);
                moves.add(posibility3);
                if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility4)).equals("white")){
                    moves.add(posibility4);
                }
                else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility4)).equals("black")){
                    moves.add(posibility4);
                }
            }else if(takenBlocks.contains(posibility5)){
                moves.add(posibility1);
                moves.add(posibility2);
                moves.add(posibility3);
                moves.add(posibility4);
                if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility5)).equals("white")){
                    moves.add(posibility5);
                }
                else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility5)).equals("black")){
                    moves.add(posibility5);
                }
            }else if(takenBlocks.contains(posibility6)){
                moves.add(posibility1);
                moves.add(posibility2);
                moves.add(posibility3);
                moves.add(posibility4);
                moves.add(posibility5);
                if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility6)).equals("white")){
                    moves.add(posibility6);
                }
                else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility6)).equals("black")){
                    moves.add(posibility6);
                }
            }
            else if(takenBlocks.contains(posibility7)){
                moves.add(posibility1);
                moves.add(posibility2);
                moves.add(posibility3);
                moves.add(posibility4);
                moves.add(posibility5);
                moves.add(posibility6);
                if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility7)).equals("white")){
                    moves.add(posibility7);
                }
                else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility7)).equals("black")){
                    moves.add(posibility7);
                }
            }
            else{
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
            }

            //Down Movements
        if(takenBlocks.contains(posibility8)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility8)).equals("white")){
                moves.add(posibility8);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility8)).equals("black")){
                moves.add(posibility8);
            }
        }else if(takenBlocks.contains(posibility9)){
            moves.add(posibility8);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility9)).equals("white")){
                moves.add(posibility9);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility9)).equals("black")){
                moves.add(posibility9);
            }
        }else if(takenBlocks.contains(posibility10)){
            moves.add(posibility8);
            moves.add(posibility9);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility10)).equals("white")){
                moves.add(posibility10);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility10)).equals("black")){
                moves.add(posibility10);
            }
        }else if(takenBlocks.contains(posibility11)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility11)).equals("white")){
                moves.add(posibility11);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility11)).equals("black")){
                moves.add(posibility11);
            }
        }else if(takenBlocks.contains(posibility12)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility12)).equals("white")){
                moves.add(posibility12);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility12)).equals("black")){
                moves.add(posibility12);
            }
        }else if(takenBlocks.contains(posibility13)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            moves.add(posibility12);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility13)).equals("white")){
                moves.add(posibility13);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility13)).equals("black")){
                moves.add(posibility13);
            }
        }
        else if(takenBlocks.contains(posibility14)){
            moves.add(posibility8);
            moves.add(posibility9);
            moves.add(posibility10);
            moves.add(posibility11);
            moves.add(posibility12);
            moves.add(posibility13);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility14)).equals("white")){
                moves.add(posibility14);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility14)).equals("black")){
                moves.add(posibility14);
            }
        }
        else{
            if(board.contains(posibility8)){
                moves.add(posibility8);
            }
            if(board.contains(posibility9)){
                moves.add(posibility9);
            }
            if(board.contains(posibility10)){
                moves.add(posibility10);
            }
            if(board.contains(posibility11)){
                moves.add(posibility11);
            }
            if(board.contains(posibility12)){
                moves.add(posibility12);
            }
            if(board.contains(posibility13)){
                moves.add(posibility13);
            }
            if(board.contains(posibility14)){
                moves.add(posibility14);
            }
        }



        ///left movements
        if(takenBlocks.contains(posibility15)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility15)).equals("white")){
                moves.add(posibility15);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility15)).equals("black")){
                moves.add(posibility15);
            }
        }else if(takenBlocks.contains(posibility16)){
            moves.add(posibility15);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility16)).equals("white")){
                moves.add(posibility16);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility16)).equals("black")){
                moves.add(posibility16);
            }
        }else if(takenBlocks.contains(posibility17)){
            moves.add(posibility15);
            moves.add(posibility16);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility17)).equals("white")){
                moves.add(posibility17);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility17)).equals("black")){
                moves.add(posibility17);
            }
        }else if(takenBlocks.contains(posibility18)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility18)).equals("white")){
                moves.add(posibility18);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility18)).equals("black")){
                moves.add(posibility18);
            }
        }else if(takenBlocks.contains(posibility19)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility19)).equals("white")){
                moves.add(posibility19);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility19)).equals("black")){
                moves.add(posibility19);
            }
        }else if(takenBlocks.contains(posibility20)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            moves.add(posibility19);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility20)).equals("white")){
                moves.add(posibility20);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility20)).equals("black")){
                moves.add(posibility20);
            }
        }
        else if(takenBlocks.contains(posibility21)){
            moves.add(posibility15);
            moves.add(posibility16);
            moves.add(posibility17);
            moves.add(posibility18);
            moves.add(posibility19);
            moves.add(posibility20);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility21)).equals("white")){
                moves.add(posibility21);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility21)).equals("black")){
                moves.add(posibility21);
            }
        }
        else{
            if(board.contains(posibility15)){
                moves.add(posibility15);
            }
            if(board.contains(posibility16)){
                moves.add(posibility16);
            }
            if(board.contains(posibility17)){
                moves.add(posibility17);
            }
            if(board.contains(posibility18)){
                moves.add(posibility18);
            }
            if(board.contains(posibility19)){
                moves.add(posibility19);
            }
            if(board.contains(posibility20)){
                moves.add(posibility20);
            }
            if(board.contains(posibility21)){
                moves.add(posibility21);
            }
        }

        //Right Movements
        if(takenBlocks.contains(posibility22)){
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility22)).equals("white")){
                moves.add(posibility22);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility22)).equals("black")){
                moves.add(posibility22);
            }
        }else if(takenBlocks.contains(posibility23)){
            moves.add(posibility22);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility23)).equals("white")){
                moves.add(posibility23);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility23)).equals("black")){
                moves.add(posibility23);
            }
        }else if(takenBlocks.contains(posibility24)){
            moves.add(posibility22);
            moves.add(posibility23);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility24)).equals("white")){
                moves.add(posibility24);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility24)).equals("black")){
                moves.add(posibility24);
            }
        }else if(takenBlocks.contains(posibility25)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility25)).equals("white")){
                moves.add(posibility25);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility25)).equals("black")){
                moves.add(posibility25);
            }
        }else if(takenBlocks.contains(posibility26)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility26)).equals("white")){
                moves.add(posibility26);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility26)).equals("black")){
                moves.add(posibility26);
            }
        }else if(takenBlocks.contains(posibility27)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            moves.add(posibility26);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility27)).equals("white")){
                moves.add(posibility27);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility27)).equals("black")){
                moves.add(posibility27);
            }
        }
        else if(takenBlocks.contains(posibility28)){
            moves.add(posibility22);
            moves.add(posibility23);
            moves.add(posibility24);
            moves.add(posibility25);
            moves.add(posibility26);
            moves.add(posibility27);
            if(color.equals("black") && takenBlocksColor.get(takenBlocks.indexOf(posibility28)).equals("white")){
                moves.add(posibility28);
            }
            else if(color.equals("white") && takenBlocksColor.get(takenBlocks.indexOf(posibility28)).equals("black")){
                moves.add(posibility28);
            }
        }
        else{
            if(board.contains(posibility22)){
                moves.add(posibility22);
            }
            if(board.contains(posibility23)){
                moves.add(posibility23);
            }
            if(board.contains(posibility24)){
                moves.add(posibility24);
            }
            if(board.contains(posibility25)){
                moves.add(posibility25);
            }
            if(board.contains(posibility26)){
                moves.add(posibility26);
            }
            if(board.contains(posibility27)){
                moves.add(posibility27);
            }
            if(board.contains(posibility28)){
                moves.add(posibility28);
            }
        }



        return moves;
    }

    public ArrayList<String> pawnMoves(Piece[][] allPieces){
        ArrayList<String> moves = new ArrayList<>();

        int num = (int)position.charAt(1)-48;
        char alpha = (char)(position.charAt(0));

        if(color.equals("black")){
            String posibility = Character.toString(alpha) + Integer.toString(num-1);

            char alphaRemove1 = (char)(position.charAt(0)-1);
            char alphaAdd1 = (char)(position.charAt(0)+1);
            String posibility2 = Character.toString(alphaRemove1) + Integer.toString(num-1);
            String posibility3 = Character.toString(alphaAdd1) + Integer.toString(num-1);


            if(board.contains(posibility)){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(hasBlack==false){
                    moves.add(posibility);
                }
            }

            if(board.contains(posibility2)){
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility2) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(hasWhite) {
                    moves.add(posibility2);
                }
            }

            if(board.contains(posibility3)){
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility3) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(hasWhite) {
                    moves.add(posibility3);
                }
            }

        }else {
            String posibility = Character.toString(alpha) + Integer.toString(num+1);

            char alphaRemove1 = (char)(position.charAt(0)-1);
            char alphaAdd1 = (char)(position.charAt(0)+1);
            String posibility2 = Character.toString(alphaRemove1) + Integer.toString(num+1);
            String posibility3 = Character.toString(alphaAdd1) + Integer.toString(num+1);

            if(board.contains(posibility)){
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }

                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(hasWhite==false){
                    moves.add(posibility);
                }
            }

            if(board.contains(posibility2)){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility2) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(hasBlack) {
                    moves.add(posibility2);
                }
            }

            if(board.contains(posibility3)){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility3) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(hasBlack) {
                    moves.add(posibility3);
                }
            }
        }

        return moves;
    }

    public ArrayList<String> KnightMoves(Piece[][] allPieces){
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
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility1) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(hasBlack==false){
                    moves.add(posibility1);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility1) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(hasWhite==false){
                    moves.add(posibility1);
                }
            }
        }
        if(board.contains(posibility2)){
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility2) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(hasBlack==false){
                    moves.add(posibility2);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility2) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(hasWhite==false){
                    moves.add(posibility2);
                }
            }
        }
        if(board.contains(posibility3)){
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility3) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(hasBlack==false){
                    moves.add(posibility3);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility3) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(hasWhite==false){
                    moves.add(posibility3);
                }
            }
        }
        if(board.contains(posibility4)){
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility4) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(hasBlack==false){
                    moves.add(posibility4);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility4) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(hasWhite==false){
                    moves.add(posibility4);
                }
            }
        }
        if(board.contains(posibility5)){
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility5) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(!hasBlack){
                    moves.add(posibility5);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility5) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(!hasWhite){
                    moves.add(posibility5);
                }
            }
        }
        if(board.contains(posibility6)){
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility6) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(!hasBlack){
                    moves.add(posibility6);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility6) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(!hasWhite){
                    moves.add(posibility6);
                }
            }
        }
        if(board.contains(posibility7)){
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility7) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(!hasBlack){
                    moves.add(posibility7);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility7) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(!hasWhite){
                    moves.add(posibility7);
                }
            }
        }
        if(board.contains(posibility8)){
            if(color.equals("black")){
                boolean hasBlack = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility8) && allPieces[r][c].color.equals("black")){
                            hasBlack = true;
                            break;
                        }
                    }
                    if(hasBlack){
                        break;
                    }
                }
                if(!hasBlack){
                    moves.add(posibility8);
                }
            }else{
                boolean hasWhite = false;
                for(int r=0;r<allPieces.length;++r){
                    for(int c=0;c<allPieces[0].length;++c){
                        if(allPieces[r][c].position.equals(posibility8) && allPieces[r][c].color.equals("white")){
                            hasWhite = true;
                            break;
                        }
                    }
                    if(hasWhite){
                        break;
                    }
                }
                if(!hasWhite){
                    moves.add(posibility8);
                }
            }
        }

        return moves;
    }

}
