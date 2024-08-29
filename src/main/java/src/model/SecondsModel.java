package src.model;

import src.Constants.CronElementDescription;

public class SecondsModel extends CronElement {
    String expression;

    public SecondsModel(String expression) {
        super(0, 59, CronElementDescription.Description.SECOND.getDescription(), expression);
        this.expression = expression;
    }
}
