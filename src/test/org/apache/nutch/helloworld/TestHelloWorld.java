package org.apache.nutch.helloworld;

import java.io.*;

import junit.framework.TestCase;
import junit.framework.JUnit4TestAdapter;
import org.junit.*;

public class TestHelloWorld extends TestCase {

  private PrintStream _saved;
  private ByteArrayOutputStream _actual;
  private ByteArrayOutputStream _expected;
  private PrintStream _out;

  @Before public void setUp() {
    _saved = System.out;
    _actual = new ByteArrayOutputStream();
    _expected = new ByteArrayOutputStream();
    System.setOut(new PrintStream(new BufferedOutputStream(_actual)));
    _out = new PrintStream(new BufferedOutputStream(_expected));
  }

  @After public void tearDown() {
    System.setOut(_saved);
  }

  @Test public void testHello() {
    // Expected
    _out.println("Hello World!");
    _out.flush();

    // Actual
    HelloWorld.main(new String[0]);
    System.out.flush();

    // Compare
    assertEquals(_expected.toString(), _actual.toString());
  }

  public static junit.framework.Test suite() {
    return new JUnit4TestAdapter(TestHelloWorld.class);
  }

}
