package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task.IPv6;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TestGroupReduce {
    @Parameterized.Parameters(name = "test({0}: {1} -> {2})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"nothing to reduce",
                        new char[]{'1', '1', '0', '0'},
                        new char[]{'1', '1', '0', '0'}},
                {"all zeros",
                        new char[]{'0', '0', '0', '0'},
                        new char[]{'0'}},
                {"one char",
                        new char[]{'1',},
                        new char[]{'1'}},
                {"empty",
                        new char[]{},
                        new char[]{}},
        });
    }

    @Parameterized.Parameter(0)
    public String desc;

    @Parameterized.Parameter(1)
    public char[] input;

    @Parameterized.Parameter(2)
    public char[] reduced;


    @Test
    public void reduce_group() {
        char[] res = IPv6.reduce_group(input);
        assertArrayEquals(desc, reduced, res);
    }
}
