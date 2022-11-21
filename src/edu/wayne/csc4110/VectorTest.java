package edu.wayne.csc4110;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    Vector A, B;

    @BeforeEach
    void setUp() {
        double[] entriesA = {7.2, 3.0, 4.0};
        double[] entriesB = {3.1, 2.6, 10.2};

        A = new Vector(entriesA);
        B = new Vector(entriesB);
    }

    @org.junit.jupiter.api.Test
    void add() {
        Vector actual = A.add(B);
        double[] values = {10.3, 5.6, 14.2};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void cross() {
        Vector actual = A.cross(B);
        double[] values = {20.2, -61.04, 9.42};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void dot() {
        double actual = A.dot(B);
        double expected = 70.92;

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void get() {
        double actual = A.get(0);
        double expected = 7.2;
        assertEquals(expected,actual);



    }

    @org.junit.jupiter.api.Test
    void getEntries() {
        double[] actual = A.getEntries();
        double[] expected = {7.2,3.0,4.0};
        assertArrayEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void inverseVector() {
        Vector actual = A.inverseVector();
        double[] values = {-7.2,-3.0,-4.0};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void isZero() {
        boolean actual = A.isZero();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void length() {
        int actual = A.length();
        int expected = 3;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void magnitude() {
        double actual = A.magnitude();
        double expected = 8.76;
        double delta = 0.01;
        assertEquals(expected,actual,delta);

    }

    @org.junit.jupiter.api.Test
    void multiply() {
        Vector actual = A.multiply(2.5);
        double[] values = {18,7.5,10};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void normalize() {
        Vector actual = A.normalize();
        double mag = A.magnitude();
        double[] values = {7.2/mag,3/mag,4/mag};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void set() {
        Vector actual = A.set(1,6.8);
        double[] values = {7.2,6.8,4.0};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);

        //second test
        assertThrows(IllegalArgumentException.class,()->A.set(4,8));
    }

    @org.junit.jupiter.api.Test
    void setEntries() {
        double[] values = {5.3,2.9,1.3};
        A.setEntries(values);
        double[] expected_values = {5.3,2.9,1.3};
        Vector expected = new Vector(expected_values);
        Vector actual = A;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Vector actual = A.subtract(B);
        double[] values = {4.1, 0.4, -6.2};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);
    }
}