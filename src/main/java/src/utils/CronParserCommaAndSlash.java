package src.utils;

import src.Constants.CronSpecialChar;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


public class CronParserCommaAndSlash extends CronParser {
    public CronParserCommaAndSlash(int min, int max, String expression, String description) {
        super(min, max, expression, description);
    }

    public ArrayList<Integer> resolveExpression() {
        String[] ranges = this.expression.split(",");
        ArrayList<Integer> result = new ArrayList<>();
        for (String range : ranges) {
            try {
                populateRange(range, result);
            } catch (Exception ex) {
                System.out.println("Invalid cron expression " + this.expression + " provided for " + this.description);
                return null;
            }
        }
        Set<Integer> uniqueSortedNumbersSet = new TreeSet<>(result);
        return new ArrayList<>(uniqueSortedNumbersSet);
    }

    private void populateRange(String range, ArrayList<Integer> result) throws Exception {
        String[] limits = range.split("-");
        if (limits.length != 2) throw new Exception("Error : Invalid range");
        if (limits[0].matches(CronSpecialChar.SpecialCharacters.Number.getRegex()) &&
                limits[1].matches(CronSpecialChar.SpecialCharacters.Number.getRegex())
        ) {
            int lowLimit = Integer.parseInt(limits[0]);
            int highLimit = Integer.parseInt(limits[1]);
            if (this.min <= lowLimit && lowLimit <= highLimit && highLimit < this.max) {
                for (int val = lowLimit; val <= highLimit; val++) {
                    result.add(val);
                }
                return;
            } else {
                throw new Exception("Error101 : Invalid range ");
            }
        } else {
            throw new Exception("Error102 : Invalid range");
        }
    }
}
