package src.utils;

import src.Constants.CronSpecialChar;

import java.util.ArrayList;


public class CronParserComma extends CronParser {

    public CronParserComma(int min, int max, String expression, String description) {
        super(min, max, expression, description);
    }

    public ArrayList<Integer> resolveExpression() {
        ArrayList<Integer> result = new ArrayList<>();
        String[] extract = this.expression.split(",");
        for (String entry : extract) {
            if (entry.matches(CronSpecialChar.SpecialCharacters.Number.getRegex())) {
                int val = Integer.parseInt(entry);
                if (this.min <= val && val <= this.max) {
                    result.add(val);
                } else {
                    System.out.println("Error101 : Invalid cron expression " + this.expression + " for " + this.description);
                    return null;
                }
            } else {
                System.out.println("Error101 : Invalid cron expression " + this.expression + " for " + this.description);
                return null;
            }
        }
        return result;
    }
}
