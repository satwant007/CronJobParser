package src.model;

import src.Constants.CronElementDescription;

public class HoursModel extends CronElement {
    String expression;

    public HoursModel(String expression) {
        super(0, 23, CronElementDescription.Description.HOUR.getDescription(), expression);
        this.expression = expression;
    }
}
