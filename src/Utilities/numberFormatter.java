package Utilities;

import java.text.DecimalFormat;

public class numberFormatter {
    private static final DecimalFormat df = new DecimalFormat("0.000");

    public static String format(double value) {
        return df.format(value);
    }
}
