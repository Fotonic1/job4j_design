package ru.job4j.io;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int i = 10;
        short sh = 5;
        boolean b = true;
        double d = 1.45;
        long l = 6465489;
        float f = 10.08465F;
        byte by = 2;
        char c = 'd';
        LOG.debug("int:{}, short:{}, boolean:{}, double:{}, long:{}, float:{}, byte:{}, char:{}.",
                i, sh, b, d, l, f, by, c);
    }
}
