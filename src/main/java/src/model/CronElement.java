package src.model;

import src.Constants.CronSpecialChar.SpecialCharacters;
import src.utils.*;

import java.util.ArrayList;

public class CronElement {
    public int min;
    public int max;
    public String description;
    public String expression;

    public CronElement(int min, int max, String description, String expression) {
        this.min = min;
        this.max = max;
        this.description = description;
        this.expression = expression.toUpperCase();
    }

    public ArrayList<Integer> getNextOccurrences() {
        System.out.println("Expression " + this.expression + "  for " + this.description);
        if (this.expression.matches(SpecialCharacters.AsteriskWithSlash.getRegex())) {
            CronParserAsteriskWithSlash parser = new CronParserAsteriskWithSlash(
                    this.min, this.max, this.expression, this.description);
            return parser.resolveExpression();
        } else if (this.expression.matches(SpecialCharacters.CommaAndDash.getRegex())) {
            CronParserCommaAndSlash parser = new CronParserCommaAndSlash(
                    this.min, this.max, this.expression, this.description);
            return parser.resolveExpression();
        } else if (this.expression.compareTo(SpecialCharacters.Asterisk.getRegex()) == 0) {
            CronParserAsterisk parser = new CronParserAsterisk(
                    this.min, this.max, this.expression, this.description);
            return parser.resolveExpression();
        } else if (this.expression.matches(SpecialCharacters.Comma.getRegex())) {
            CronParserComma parser = new CronParserComma(
                    this.min, this.max, this.expression, this.description);
            return parser.resolveExpression();
        } else if (this.expression.matches(SpecialCharacters.Dash.getRegex())) {
            CronParserDash parser = new CronParserDash(
                    this.min, this.max, this.expression, this.description);
            return parser.resolveExpression();
        } else if (this.expression.matches(SpecialCharacters.Slash.getRegex())) {
            CronParserSlash parser = new CronParserSlash(
                    this.min, this.max, this.expression, this.description);
            return parser.resolveExpression();
        } else if (this.expression.matches(SpecialCharacters.Number.getRegex())) {
            CronParserNumber parser = new CronParserNumber(
                    this.min, this.max, this.expression, this.description);
            return parser.resolveExpression();
        }
        return null;
    }

}
