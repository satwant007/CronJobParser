package src.model;

import src.Constants.CronElementDescription;

public class MinutesModel extends CronElement {
    String expression;

    public MinutesModel(String expression) {
        super(0, 59, CronElementDescription.Description.MINUTE.getDescription(), expression);
        this.expression = expression;
    }
}

