package com.gekif.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void test() {
//        assertEquals(1, 1);

        boolean condition = true;
        assertEquals(true, condition);

        assertTrue(condition);
        assertFalse(condition);

//        assertNotNull();
//        assertNull();

//        assertArrayEquals();
    }
}
