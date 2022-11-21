package edu.wayne.csc4110;
import  java.lang.Math;

/**
 * The Vector class provides basic vector operations for Euclidean vectors
 * represented as arrays of real numbers.
 *
 * All operations between two vectors are designed for vectors of the same
 * length, and no checking is done. For loops are controlled by the length
 * of the first vector, so if the second vector is longer, an Exception may
 * not be thrown as expected.
 */

public class Vector {
    /**
     * entries contains the entries in the vector
     */
    private double[] entries;

    /*
     * threshold for double comparisons
     */
    public static final double THRESHOLD = 0.001;

    /**
     * Constructor makes a copy of the array passed.
     * @param entries an array containing the entries in the vector
     */
    public Vector(double ... entries) {
        this.entries = new double[entries.length];
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = entries[i];
        }
    }

    /**
     * copy constructor copies the entires in vect into v
     * @param u a Vector object
     */
    public Vector(Vector u) {
        this.entries = new double[u.entries.length];

        for (int i = 0; i < u.entries.length; i++) {
            this.entries[i] = u.entries[i];
        }
    }

    /**
     * add method accepts a vector and adds it to the current vector
     * @param u the vector to add onto the calling vector.
     * @return a Vector object whose entries are the element-wise sums
     *    of the calling vector and the argument
     */
    public Vector add(Vector u) {
        return VectorAlgebra.add(this, u);
    }



    /**
     * cross computes the cross product (this x u)
     * @param u the vector to cross the calling vector with
     * @return the cross product this x u
     */
    public Vector cross(Vector u) {
        return VectorAlgebra.cross(this, u);
    }



    /**
     * dot method computes the dot product of the calling vector and
     * the passed vectored.
     * assumes vectors have the same length.
     * @param u a Vector object
     * @return the sum of the products of corresponding elements
     */
    public double dot(Vector u) {
        return VectorAlgebra.dot(this, u);
    }


    /**
     * Returns the entry in the specified position.
     * @param position the position to return
     * @return the value in entries[position]
     */
    public double get(int position) {
        return entries[position];
    }



    /**
     * returns a copy of entries, not a reference to entries.
     * @return a copy of the array entries
     */
    public double[] getEntries() {
        double[] entries = new double[this.entries.length];

        for (int i = 0; i < this.entries.length; i++) {
            entries[i] = this.entries[i];
        }

        return entries;
    }



    /**
     * inverseVector returns the additive inverse of the calling vector.
     * @return a Vector with the signs flipped on all entries
     */
    public Vector inverseVector() {
        return this.multiply(-1);
    }



    /**
     * isZero checks to see if all entries are zero.
     * @return true if all entries are zero, false otherwise
     */
    public boolean isZero() {
        return VectorAlgebra.isZero(this);
    }

    /**
     * length method returns the number of entries in the
     * vector.
     * @return the length of v
     */
    public int length() {
        return entries.length;
    }

    /**
     * magnitude method is a wrapper for pnorm, with p=2
     * @return the magnitude of the vector
     */
    public double magnitude() {
        return VectorAlgebra.magnitude(this);
    }


    /**
     * multiply method accepts a scalar to and multiplies each element of
     * entries by that value.
     * @param scalar the real number to multiply the entries by
     * @return a Vector object whose entries are the element-wise sums
     *    of the calling vector and the argument
     */
    public Vector multiply(double scalar) {
        return VectorAlgebra.multiply(this, scalar);
    }


    /**
     * normalize scales the calling vector by dividing it by its
     * magnitude. if the zero vector is passed, an IllegalArgumentException
     * is thrown.
     * @return a Vector object
     */
    public Vector normalize() {
        return VectorAlgebra.normalize(this);
    }


    /**
     * set method modifies the element at index to equal value.
     * @param index the index we want to modify
     * @param value the new value
     * @return a Vector with the value at index updated
     */
    public Vector set(int index, double value) {
        if (index < 0 || index >= this.length()) {
            throw new IllegalArgumentException("Index is out of range");
        }

        this.entries[index]=value;
        return this;


    }

    /**
     * Sets the values in the entries array.
     * @param entries an array of doubles
     */
    public void setEntries(double[] entries) {
        this.entries = new double[entries.length];

        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = entries[i];
        }
    }

    /**
     * subtract method subtracts the passed Vector from the calling Vector.
     * @param u a Vector object
     * @return a Vector object whose entries are the difference of the
     *         entries in the calling Vector and the respective entries
     *         in v
     */
    public Vector subtract(Vector u) {
        return VectorAlgebra.subtract(this, u);
    }



    /**
     * Return a String containing the vector represented as a row in brackets, e.g.
     * [1.0, 2.2, 3.1, 4.9, 5.7]
     * @return a String representation of the vector
     */
    @Override
    public String toString() {
        String str = "[";
        String sep = ", ";

        for (int i = 0; i < this.entries.length; i++) {
            str += this.entries[i];

            if (i < (this.entries.length - 1)) { // if we're not at the last entry
                str += sep;
            }
        }

        return str + "]";
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Vector)
            return VectorAlgebra.compare(this, (Vector) o);

        return false;

    }
}