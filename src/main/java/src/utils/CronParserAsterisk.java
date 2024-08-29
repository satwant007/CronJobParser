package src.utils;

import src.Constants.CronSpecialChar.SpecialCharacters;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CronParserAsterisk extends CronParser {
    public CronParserAsterisk(int min, int max, String expression, String description) {
        super(min, max, expression, description);
    }

    public ArrayList<Integer> resolveExpression() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int val = min; val <= max; val++) {
            result.add(val);
        }
        return result;
    }
}
