package src.model;

import src.Constants.CronElementDescription;

public class DayOfWeekModel extends CronElement {
    String expression;

    public DayOfWeekModel(String expression) {
        super(0, 6, CronElementDescription.Description.DAY_OF_WEEK.getDescription(), expression);
        this.expression = expression;
    }
}
