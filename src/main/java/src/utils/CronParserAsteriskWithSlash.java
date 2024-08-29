package src.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.Constants.CronSpecialChar.SpecialCharacters;


public class CronParserAsteriskWithSlash extends CronParser {

    public CronParserAsteriskWithSlash(int min, int max, String expression, String description) {
        super(min, max, expression, description);
    }

    public ArrayList<Integer> resolveExpression() {
        // */2 => from min to max with increment of 2

        Pattern pattern = Pattern.compile(SpecialCharacters.AsteriskWithSlash.getRegex());
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            try {
                String extract = matcher.group(1);
                int increment = Integer.parseInt(extract);
                if (increment <= 0 || increment > max) {
                    System.out.println("Invalid increment, should be greater than zero and less than the max value. Increment : " + increment);
                    return null;
                }
                ArrayList<Integer> result = new ArrayList<>();
                int value = min;
                while (value <= max) {
                    result.add(value);
                    value += increment;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("The part after '*/' is not a valid number.");
                return null;
            }
        } else {
            System.out.println("Invalid " + this.description + " expression : " + this.expression);
            return null;
        }
    }
}
