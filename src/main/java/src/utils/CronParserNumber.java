package src.utils;

import src.Constants.CronSpecialChar.SpecialCharacters;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CronParserNumber extends CronParser {
    public CronParserNumber(int min, int max, String expression, String description) {
        super(min, max, expression, description);
    }

    @Override
    public ArrayList<Integer> resolveExpression() {
        Integer value = Integer.parseInt(this.expression);
        if (min <= value && value <= max) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(value);
            return result;
        }
        return null;
    }
}
