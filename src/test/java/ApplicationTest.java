import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Test
    public void validCronExpressionTest(){
        String command = " /usr/bin/find";
        String[] validCronExpressions = {
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
        Application app = new Application();
        for(String cronExpression: validCronExpressions)
        app.parseCronExpression(cronExpression, command);
    }

    @Test
    public void invalidCronExpressionTest(){
        String[] invalidCronExpressions = {
                "*/-5 * abcd * *",         // Invalid: Combination of `*/` and `-` is not allowed
                "5,10-15/* * * * *",    // Invalid: Combination of `,` and `/*` is not valid
                "0 0-23/2,*/3 * * *",   // Invalid: Mixing ranges with steps and lists
                "*/15-30 * * * *",      // Invalid: `*/15-30` is not a valid range step
                "60 * * 15-10 *",           // Invalid: Minute field cannot have `60`
                "0 24 * * *",           // Invalid: Hour field cannot have `24`
                "* * * * 8",            // Invalid: Day of the week field must be within 0-7
                "* * * 13 *",           // Invalid: Month field cannot have `13`
                "0 0 31 2 *",           // Invalid: February does not have 31 days
                "0 0 * * 1-8",          // Invalid: Day of the week range must be within 0-7
        };
        Application app = new Application();
        for(String cronExpression: invalidCronExpressions)
            app.parseCronExpression(cronExpression);
    }
}