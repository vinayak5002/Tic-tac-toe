package com.tic_tac_toe.app;

import java.util.List;

public class DetermineWinner {
    public static int getWinner(int[][] a){
        if(checkWinner(0, a)){
            return 0;
        }
        if(checkWinner(1, a)){
            return 1;
        }
        return -1;
    }
    public static boolean checkWinner(int x, int[][] a){
        if((a[0][0]==x)&&(a[0][1]==x)&&(a[0][2]==x)){
            return true;
        }
        if((a[1][0]==x)&&(a[1][1]==x)&&(a[1][2]==x)){
            return true;
        }
        if((a[2][0]==x)&&(a[2][1]==x)&&(a[2][2]==x)){
            return true;
        }
        if((a[0][0]==x)&&(a[1][0]==x)&&(a[2][0]==x)){
            return true;
        }
        if((a[0][1]==x)&&(a[1][1]==x)&&(a[2][1]==x)){
            return true;
        }
        if((a[0][2]==x)&&(a[1][2]==x)&&(a[2][2]==x)){
            return true;
        }
        if((a[0][0]==x)&&(a[1][1]==x)&&(a[2][2]==x)){
            return true;
        }
        if((a[0][2]==x)&&(a[1][1]==x)&&(a[2][0]==x)){
            return true;
        }
        return false;
    }
}
