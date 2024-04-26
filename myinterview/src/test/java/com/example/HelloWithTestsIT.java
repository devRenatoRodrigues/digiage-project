package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import static org.junit.Assert.*;

/**
 * Integration test for the HelloApp program.
 * <p/>
 * An integration test verifies the workings of a complete program, a module, or a set of dependant classes.
 * <p/>
 * This integration test uses system-rules, an extension for JUnit that lets you test System.out and System.exit()
 * etc.:
 * <p/>
 * <a href="http://www.stefan-birkner.de/system-rules">...</a>
 */
public class HelloWithTestsIT {

    @Rule
    public final StandardOutputStreamLog out = new StandardOutputStreamLog();

    @Test
    public void doesItSayHelloTest() {
        String[] args = {"1"};
        HelloApp.main(args);

        String goal = Hello.HELLO + "\n";

        assertEquals(goal, out.getLog());
    }

    @Test
    public void doesItSayHelloTest3() {
        String[] args = {"3"};
        HelloApp.main(args);

        String thrice = Hello.HELLO + "\n" + Hello.HELLO + "\n" + Hello.HELLO + "\n";
        assertEquals(thrice, out.getLog());
    }
}
