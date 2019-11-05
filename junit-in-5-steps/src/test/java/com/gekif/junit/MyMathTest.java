package com.gekif.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyMathTest {

    // MyMath.sum
    // 1,2,3 => 6

    @Test
    public void sum_with3numbers() {
        MyMath myMath = new MyMath();
        assertEquals(6, myMath.sum(new int[]{1, 2, 3}));
    }

    @Test
    public void sum_with1numbers() {
        MyMath myMath = new MyMath();
        assertEquals(3, myMath.sum(new int[]{3}));
    }

}
