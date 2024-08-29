package src.Constants;

public class CronElementDescription {
    public enum Description {
        DAY_OF_MONTH("day of month"),
        DAY_OF_WEEK("day of week"),
        SECOND("second"),
        MINUTE("minute"),
        HOUR("hour"),
        MONTH("month");

        private String description;

        public String getDescription() {
            return description;
        }

        Description(String d) {
            this.description = d;
        }
    }
}
