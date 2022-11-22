package edu.wayne.csc4110test;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Suite combining all the tests")
@SelectClasses({edu.wayne.csc4110test.VectorTest.class})
public class VectorSuite {
}