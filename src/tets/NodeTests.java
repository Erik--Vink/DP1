package tets;

import static org.junit.Assert.assertSame;

import com.niekenerik.components.*;
import org.junit.Test;
public class NodeTests {

    @Test
    public void AndTest() {
        // first test
        AND node = new AND();

        assertSame("Output must be -1", -1, node.calculate(1));
        assertSame("Output must be -1", 1, node.calculate(1));


        // second test
        node = new AND();

        assertSame("Output must be -1", -1, node.calculate(0));
        assertSame("Output must be -1", 0, node.calculate(1));
    }

    @Test
    public void INTest() {

        //and test
        IN node = new IN();

        // first test
        assertSame("Output must be 1", 1, node.calculate(1));

        // second test
        node = new IN();
        assertSame("Output must be 0", 0, node.calculate(0));
    }

    @Test
    public void NANDTEST() {
        // first test
        NAND node = new NAND();

        assertSame("Output must be -1", -1, node.calculate(1));
        assertSame("Output must be 0", 0, node.calculate(1));


        // second test
        node = new NAND();

        assertSame("Output must be -1", -1, node.calculate(0));
        assertSame("Output must be 1", 1, node.calculate(1));
    }

    @Test
    public void NORTEST() {
        // first test
        NOR node = new NOR();

        assertSame("Output must be -1", -1, node.calculate(0));
        assertSame("Output must be 1", 1, node.calculate(0));


        // second test
        node = new NOR();

        assertSame("Output must be -1", -1 , node.calculate(1));
        assertSame("Output must be 0", 0, node.calculate(1));
    }

    @Test
    public void NOTTEST() {
        // first test
        NOT node = new NOT();

        assertSame("Output must be -1", 0, node.calculate(1));

        // second test
        node = new NOT();

        assertSame("Output must be -1", 1, node.calculate(0));
    }

    @Test
    public void ORTEST() {
        // first test
        NAND node = new NAND();

        assertSame("Output must be -1", -1, node.calculate(1));
        assertSame("Output must be -1", 0, node.calculate(1));

        // second test
        node = new NAND();

        assertSame("Output must be -1", -1, node.calculate(0));
        assertSame("Output must be -1", 1, node.calculate(1));
    }

    @Test
    public void XORTEST() {
        // first test
        XOR node = new XOR();

        assertSame("Output must be -1", -1, node.calculate(1));
        assertSame("Output must be 0", 0, node.calculate(1));

        // second test
        node = new XOR();

        assertSame("Output must be -1", -1, node.calculate(0));
        assertSame("Output must be 1", 1, node.calculate(1));
    }
}
