import src.services.CronParserService;

public class Application {
    public static void main(String[] args) {
        String[] cronExpressions = {
                "* * * * *",         // Every minute
                "15 * * * *",        // Every hour at minute 15
                "30 2 * * *",        // Every day at 2:30 AM
                "0 0 * * 0",         // Every Sunday at midnight
                "0 0 1 * *",         // Every first day of the month at midnight
                "*/5 * * * *",       // Every 5 minutes
                "0 8-10 * * *",      // Every hour at 8, 9, and 10 AM
                "0 0 1 1 *",         // Every year on January 1st at midnight
                "0 12 15 * 5",       // At 12:00 PM on the 15th day of every May
                "0 22 * * 1-5"       // Every weekday (Mon-Fri) at 10:00 PM
        };
        for(String expression: cronExpressions){
            try {
                new CronParserService(expression);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
