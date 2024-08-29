package src.model;

import src.Constants.CronElementDescription;

public class MonthModel extends CronElement {
    String expression;

    public MonthModel(String expression) {
        super(1, 12, CronElementDescription.Description.MONTH.getDescription(), expression);
        this.expression = expression;
    }
}