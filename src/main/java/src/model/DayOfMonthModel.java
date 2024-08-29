package src.model;

import src.Constants.CronElementDescription.Description;

public class DayOfMonthModel extends CronElement {
    String expression;

    public DayOfMonthModel(String expression) {
        super(1, 31, Description.DAY_OF_MONTH.getDescription(), expression);
        this.expression = expression;
    }
}