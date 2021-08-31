package com.tic_tac_toe.app;

import org.junit.Assert;
import org.junit.Test;

public class DetermineWinnerTest {
    @Test
    public void testWinner(){
        int a[][] = new int[3][3];
        a[0][0] = 0;
        a[0][1] = -1;
        a[0][2] = 1;
        a[1][0] = 1;
        a[1][1] = 0;
        a[1][2] = 1;
        a[2][0] = 0;
        a[2][1] = 1;
        a[2][2] = 0;
        Assert.assertEquals(0, DetermineWinner.getWinner(a));
    }
}
