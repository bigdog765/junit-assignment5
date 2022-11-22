package edu.wayne.csc4110test;

import edu.wayne.csc4110.Vector;
import edu.wayne.csc4110.VectorAlgebra;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    @AfterEach
    void teardown(){
        //Revert changes of A & B
        double[] entriesA = {7.2, 3.0, 4.0};
        double[] entriesB = {3.1, 2.6, 10.2};

        A.setEntries(entriesA);
        B.setEntries(entriesB);
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
        //first test-Vector
        double actual = A.get(0);
        double expected = 7.2;
        assertEquals(expected,actual);

        //second test-VectorAlgebra
        double actual2 = VectorAlgebra.get(A,0);
        double expected2 = 7.2;
        assertEquals(expected2,actual2);
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
        //first test-Vector
        Vector actual = A.set(1,6.8);
        double[] values = {7.2,6.8,4.0};
        Vector expected = new Vector(values);
        assertEquals(expected,actual);

        //second test-Vector
        assertThrows(IllegalArgumentException.class,()->A.set(4,8));

        //third test-VectorAlgebra
        assertThrows(IllegalArgumentException.class,()->VectorAlgebra.set(A,-1,5.5));
        //fourth test-VectorAlgebra
        Vector actual2 = VectorAlgebra.set(A,2,4.8);
        double[] entries = {7.2,6.8,4.8};
        Vector expected2 = new Vector(entries);
        assertEquals(expected2,actual2);
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

    @org.junit.jupiter.api.Test
    void constructorTest(){
        Vector p = new Vector(3.5,2,9,7.7,1.5);
        Vector newP = new Vector(p);
    }
    @org.junit.jupiter.api.Test
    void stringTest(){
        String actual = A.toString();
        String expected = "[7.2, 3.0, 4.0]";
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void equalsTest(){
        String obj = new String();
        boolean actual = A.equals(obj);
        boolean expected = false;
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void comparesTest(){
        boolean actual = VectorAlgebra.compare(A,B);
        boolean expected = false;
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void angleDegTest(){
        double actual = VectorAlgebra.angleDegrees(A,B);
        double expected = 42.49;
        double delta = 0.1;
        assertEquals(expected,actual,delta);
    }
    @org.junit.jupiter.api.Test
    void lengthTest(){
        int actual = VectorAlgebra.length(A);
        int expected = 3;
        assertEquals(expected,actual);

        //second test
        double[] entries = {3.1,4.5};
        Vector C = new Vector(entries);
        assertThrows(IllegalArgumentException.class,()->VectorAlgebra.checkLengths(A,C));
    }
    @org.junit.jupiter.api.Test
    void pnormTest(){
        assertThrows(IllegalArgumentException.class,()->VectorAlgebra.pnorm(A,0));
    }
    @org.junit.jupiter.api.Test
    void crossTest(){
        double[] entriesC = {9.2,5.5};
        double[] entriesD = {3.6,4.5};
        Vector C = new Vector(entriesC);
        Vector D = new Vector(entriesD);
        assertThrows(IllegalArgumentException.class,()->VectorAlgebra.cross(C,D));
        assertThrows(IllegalArgumentException.class,()->VectorAlgebra.cross(A,D));
    }
    @org.junit.jupiter.api.Test
    void zeroTest(){
        double[] entries = {0.0,0.0};
        Vector z = new Vector(entries);
        boolean actual = VectorAlgebra.isZero(z);
        boolean expected = true;
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void identityTest(){
        Vector identity = VectorAlgebra.identityVector(5);
        double[] entries = {0,0,0,0,0};
        Vector expected = new Vector(entries);
        Vector actual = identity;
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void normalizeTest(){
        double[] entries = {0.0,0.0};
        Vector z = new Vector(entries);
        assertThrows(IllegalArgumentException.class,()->VectorAlgebra.normalize(z));
    }
    @org.junit.jupiter.api.Test
    void inverseTest(){
        Vector actual = VectorAlgebra.inverseVector(A);
        double[] entries = {-7.2,-3.0,-4.0};
        Vector expected = new Vector(entries);
        assertEquals(expected,actual);
    }




}