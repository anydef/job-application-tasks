package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task.IPv6;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestIPv6Test {

    @Parameterized.Parameters(name = "test({0}: {1} -> {2})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"nothing to reduce", "1111:1111:1111:1111:1111:1111:1111:1111",
                        "1111:1111:1111:1111:1111:1111:1111:1111"},
                {"reduce leading zero", "0001:1111:1111:1111:1111:1111:1111:1111",
                        "1:1111:1111:1111:1111:1111:1111:1111"},
                {"reduce multiple leading zero", "0001:0001:0001:0001:1111:1111:1111:0001",
                        "1:1:1:1:1111:1111:1111:1"},
                {"reduce all zeros", "0000:0000:0000:0000:0000:0000:0000:0000",
                        "0:0:0:0:0:0:0:0"},
        });
    }

    @Parameterized.Parameter(0)
    public String desc;

    @Parameterized.Parameter(1)
    public String input;

    @Parameterized.Parameter(2)
    public String canonical;

    @Test
    public void test_ipv6() {
        String canonicalIPv6 = IPv6.shortIPv6(input);
        assertEquals(desc, this.canonical, canonicalIPv6);
    }
}

