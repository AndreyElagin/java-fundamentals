package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Keywords {

    public final static Set<String> KEYWORDS;
    public final static String CHARSET = "UTF-8";
    public final static String CHARSET_16 = "UTF-16";

    static {
        String words = "abstract, continue, for, new, switch, assert, default, goto, "
                + "package, synchronized, boolean, do, if, private, this, break, "
                + "double, implements, protected, throw, byte, else, import, public, "
                + "throws, case, enum, instanceof, return, transient, catch, extends, "
                + "int, short, try, char, final, interface, static, void, class, "
                + "finally, long, strictfp, volatile, const, float, native, super, while ";
        KEYWORDS = new HashSet<>(Arrays.asList(words.split(", ")));
    }

}
