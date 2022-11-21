package edu.wayne.csc4110;
import  java.lang.Math;

public class VectorAlgebra {
    /**
     * add method accepts two vectors and returns their element-wise
     * sum in a new Vector object. Assumes v1 and v2 have the same
     * length.
     * @param u1 a Vector object
     * @param u2 a Vector object
     * @return a Vector objects whose entries are the sums of corresponding
     *         entries in u1 and u2
     */
    public static Vector add(Vector u1, Vector u2) {
        VectorAlgebra.checkLengths(u1, u2);

        double[] sums = new double[u1.length()];

        for (int i = 0; i < sums.length; i++) {
            sums[i] = u1.get(i) + u2.get(i);
        }

        return new Vector(sums);
    }

    /**
     * compares two vectors. returns true if those are equal
     *
     * @param u1 a Vector object
     * @param u2 a Vector object
     * @return True if those are equal else False
     */
    public static boolean compare(Vector u1, Vector u2) {

        if (u1.length()!=u2.length()) return  false;

        for (int i = 0; i < u1.length(); i++) {
            if(! isEqual(u1.get(i), u2.get(i) ))
                return  false;
        }
        return true;
    }

    /**
     * angleDegrees method computes the angle between the two vectors,
     * computed as arccos(u1.dot(u2) / (u1.magnitude() * u2.magnitude())
     * @param u1 a Vector object
     * @param u2 a Vector object
     * @return the angle between u1 and u2 (in radians)
     */
    public static double angleDegrees(Vector u1, Vector u2) {
        VectorAlgebra.checkLengths(u1, u2);
        return VectorAlgebra.angleRadians(u1, u2) * 180 / Math.PI;
    }

    /**
     * angleRadians method computes the angle between the two vectors,
     * computed as arccos(u1.dot(u2) / (u1.magnitude() * u2.magnitude())
     * @param u1 a Vector object
     * @param u2 a Vector object
     * @return the angle between u1 and u2 (in radians)
     */
    public static double angleRadians(Vector u1, Vector u2) {
        VectorAlgebra.checkLengths(u1, u2);
        return Math.acos(VectorAlgebra.dot(u1, u2) / (u1.magnitude() * u2.magnitude()));
    }

    /**
     * length method returns the number of entries in the
     * vector.
     * @param u a Vector object
     * @return the length of u
     */
    public static int length(Vector u) {
        return u.length();
    }

    /**
     * magnitude method is a wrapper for pnorm, with p=2
     * @param u a Vector object
     * @return the magnitude of the vector
     */
    public static double magnitude(Vector u) {
        return VectorAlgebra.pnorm(u, 2);
    }

    /**
     * pnorm accepts a Vector and a value for p and returns the Lp norm
     * (the p-th root of the sum of the p-th power of the absolute value of
     * the enttries
     * @param u a Vector object
     * @param p a real number greater than or equal to 1
     * @return the Lp norm of the vector
     */
    public static double pnorm(Vector u, double p) {
        if (p < 1) {
            throw new IllegalArgumentException("p must be >= 1");
        }

        double sum = 0;

        for (int i = 0; i < u.length(); i++) {
            sum += Math.pow(Math.abs(u.get(i)), p);
        }

        return Math.pow(sum, 1/p);
    }

    /**
     * dot method computes the dot product of two vectors.
     * assumes vectors have the same length.
     * @param u1 a Vector object
     * @param u2 a Vector object
     * @return the sum of the products of corresponding elements
     */
    public static double dot(Vector u1, Vector u2) {
        VectorAlgebra.checkLengths(u1, u2);

        double sum = 0;

        for (int i = 0; i < u1.length(); i++) {
            sum += (u1.get(i) * u2.get(i));
        }

        return sum;
    }


    /**
     * multiply accepts a Vector object and a scalar and returns
     * a Vector whose entries are the entries of the Vector, multiplied
     * by the scalar.
     * @param u a Vector object
     * @param scalar a real number
     * @return the scalar product of the vector and the scalar
     */
    public static Vector multiply(Vector u, double scalar) {
        double[] products = new double[u.length()];

        for (int i = 0; i < products.length; i++) {
            products[i] = scalar * u.get(i);
        }

        return new Vector(products);
    }


    /**
     * checkLengths method accepts two vectors and throws and
     * IllegalArgumentException if they are not the same lengths.
     * @param u1 a Vector object
     * @param u2 a Vector object
     */
    public static void checkLengths(Vector u1, Vector u2) {
        if (u1.length() != u2.length()) {
            throw new IllegalArgumentException("Vectors are different lengths");
        }
    }

    /**
     * cross method takes two vectors of length 3 and returns their
     * cross product. Note that this operation is anticommutative, so
     * cross(a, b) = -cross(b, a)
     * @param a the left vector Vector
     * @param b the right vector Vector
     * @return the cross product a X b
     */
    public static Vector cross(Vector a, Vector b) {
        // check to make sure both vectors are the right length
        if (a.length() != 3) {
            throw new IllegalArgumentException("Invalid vector length (first vector)");
        }
        if (b.length() != 3) {
            throw new IllegalArgumentException("Invalid vector length (second vector)");
        }
        VectorAlgebra.checkLengths(a, b); // just in case

        double[] entries = new double[] {
                a.get(1) * b.get(2) - a.get(2) * b.get(1),
                a.get(2) * b.get(0) - a.get(0) * b.get(2),
                a.get(0) * b.get(1) - a.get(1) * b.get(0)};

        return new Vector(entries);
    }

    /**
     * isZero checks to see if all entries are zero.
     * @param u a Vector object
     * @return true if all entries in u are zero, false otherwise
     */
    public static boolean isZero(Vector u) {
        for (double entry : u.getEntries()) {
            if (Math.abs(entry) > Vector.THRESHOLD) { // if a non-zero entry is found
                return false;
            }
        }

        return true;
    }


    /**
     * identityVector returns an additive identity vector (whose entries are
     * all zeros).
     * @param length the length of the vector
     * @return a vector with all zeros
     */
    public static Vector identityVector(int length) {
        return new Vector(new double[length]);
    }

    /**
     * normalize scales the passed vector by dividing it by its
     * magnitude. if the zero vector is passed, an IllegalArgumentException
     * is thrown.
     * @param u a Vector object
     * @return a Vector object
     */
    public static Vector normalize(Vector u) {
        if (u.isZero()) {
            throw new IllegalArgumentException();
        } else {
            return u.multiply(1.0/u.magnitude());
        }
    }

    /**
     * set method modifies the element at index to equal value.
     * @param u a Vector object
     * @param index the index we want to modify
     * @param value the new value
     * @return a Vector with the value at index updated
     */
    public static Vector set(Vector u, int index, double value) {
        if (index < 0 || index >= u.length()) {
            throw new IllegalArgumentException("Index is out of range");
        }

        u.set(index,value);

        return u;
    }

    /**
     * subtract method returns the difference of two vectors. note
     * that difference is a special case of sum (v1 + (-1)*v2)
     * @param v1 a Vector object
     * @param v2 a Vector object
     * @return a new Vector object whose entries are the differences of
     *         the entries in v1 and v2 (v1 - v2)
     */
    public static Vector subtract(Vector v1, Vector v2) {
        return VectorAlgebra.add(v1, v2.multiply(-1));
    }

    /**
     * inverseVector returns the additive inverse of the vector passed.
     * @param u a Vector
     * @return a Vector whose entries have the signs flipped
     */
    public static Vector inverseVector(Vector u) {
        return VectorAlgebra.multiply(u, -1);
    }

    /**
     * Returns the entry in the specified position.
     * @param u a Vector object
     * @param position the position to return
     * @return the value in u[position]
     */
    public static double get(Vector u, int position) {
        return u.get(position);
    }

    /**
     * Compares two double to check if they are equal
     * @param a first value
     * @param b second value
     * @return true if they are equal
     */
    public  static  boolean isEqual(double a, double b){

        return Math.abs(a - b) < Vector.THRESHOLD;
    }
}
