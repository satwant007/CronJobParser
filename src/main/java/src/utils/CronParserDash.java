package src.utils;

import src.Constants.CronSpecialChar;

import java.util.ArrayList;


public class CronParserDash extends CronParser {


    public CronParserDash(int min, int max, String expression, String description) {
        super(min, max, expression, description);
    }

    public ArrayList<Integer> resolveExpression() {
        ArrayList<Integer> result = new ArrayList<>();
        String[] limits = this.expression.split("-");
        if (limits.length != 2) {
            System.out.println("Error100 : Invalid range");
            return null;
        }
        if (limits[0].matches(CronSpecialChar.SpecialCharacters.Number.getRegex()) &&
                limits[1].matches(CronSpecialChar.SpecialCharacters.Number.getRegex())
        ) {
            int lowLimit = Integer.parseInt(limits[0]);
            int highLimit = Integer.parseInt(limits[1]);
            if (this.min <= lowLimit && lowLimit <= highLimit && highLimit < this.max) {
                for (int val = lowLimit; val <= highLimit; val++) {
                    result.add(val);
                }
            } else {
                System.out.println("Error101 : Invalid range");
                return null;
            }
        } else {
            System.out.println("Error101 : Invalid range");
            return null;
        }
        return result;
    }
}
