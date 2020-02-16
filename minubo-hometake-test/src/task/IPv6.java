package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPv6 {

    public static char[] reduce_group(char[] ch) {

        if (ch.length <= 1) {
            return ch;
        }

        if (ch[0] == '0') {
            char[] slice = Arrays.copyOfRange(ch, 1, ch.length);
            return reduce_group(slice);
        }
        return ch;
    }


    public static String shortIPv6(String input) {
        String[] split = input.split(":");
        List<char[]> sb = new ArrayList<>();
        for (String group : split) {
            char[] reducedGroup = reduce_group(group.toCharArray());
            sb.add(reducedGroup);
        }
        return sb.toString();
    }

}
