package edu.wayne.csc4110test;

import edu.wayne.csc4110.Vector;
import edu.wayne.csc4110.VectorAlgebra;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  java.lang.Math;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    Vector A, B;

    @BeforeEach
    void setUp() {
        double[] entriesA = {4.7, 5.0, 5.0}; //ej4755
        double[] entriesB = {3.1, 2.6, 10.2};
        A = new Vector(entriesA);
        B = new Vector(entriesB);


    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void add() {

       Vector result = A.add(B);

    }

    @Test
    void cross() {
    }

    @Test
    void dot() {


    }

    @Test
    void get() {
    }

    @Test
    void getEntries() {
    }

    @Test
    void inverseVector() {
    }

    @Test
    void isZero() {

    }

    @Test
    void length() {
    }

    @Test
    void magnitude() {
    }

    @Test
    void multiply() {
    }

    @Test
    void normalize() {
    }

    @Test
    void set() {

           }

    @Test
    void setEntries() {
    }

    @Test
    void subtract() {

    }
}