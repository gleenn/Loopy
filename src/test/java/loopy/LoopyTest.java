package loopy;

import loopy.Loopy.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static loopy.Loopy.node;
import static org.junit.jupiter.api.Assertions.*;

class LoopyTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void detectCyclesTest() {
        assertFalse(Loopy.detectCycles(node("A")));
        assertFalse(Loopy.detectCycles(node("A", node("B"))));
        assertFalse(Loopy.detectCycles(node("A", node("B", node("C")))));

        Node a = node("A");
        Node b = node("B");
        a.next = b;
        b.next = a;

        assertTrue(Loopy.detectCycles(a));
    }
}