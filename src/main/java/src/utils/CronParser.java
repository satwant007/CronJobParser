package src.utils;

import java.util.ArrayList;

public abstract class CronParser {
    int min;
    int max;
    String expression;
    String description;

    public CronParser(int min, int max, String expression, String description) {
        this.min = min;
        this.max = max;
        this.expression = expression;
        this.description = description;
    }

    public abstract ArrayList<Integer> resolveExpression();
}
