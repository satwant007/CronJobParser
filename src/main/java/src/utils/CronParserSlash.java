package src.utils;

import src.Constants.CronElementDescription;
import src.Constants.CronSpecialChar;

import java.util.ArrayList;


public class CronParserSlash extends CronParser {
    public CronParserSlash(int min, int max, String expression, String description) {
        super(min, max, expression, description);
    }

    public ArrayList<Integer> resolveExpression() {
        ArrayList<Integer> result = new ArrayList<>();
        String[] limits = this.expression.split("/");
        if (limits.length != 2) {
            System.out.println("Error100 : Invalid range");
            return null;
        }
        if (limits[0].matches(CronSpecialChar.SpecialCharacters.Number.getRegex()) &&
                limits[1].matches(CronSpecialChar.SpecialCharacters.Number.getRegex())
        ) {
            int start = Integer.parseInt(limits[0]);
            int increment = Integer.parseInt(limits[1]);
            if (increment <= 0 || increment > max) {
                System.out.println("Invalid increment, should be greater than zero and less than the max value. Increment : " + increment);
                return null;
            }
            if (start < min || start > max) {
                System.out.println("Invalid increment, should be greater than zero and less than the max value. Increment : " + increment);
                return null;
            }
            int value = start;
            while (value <= max) {
                result.add(value);
                value += increment;
            }
            return result;
        } else {
            System.out.println("Error101 : Invalid range");
            return null;
        }
    }
}
