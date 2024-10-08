import src.services.CronParserService;

public class Application {
    public static void main(String[] args) {
        if (args.length != 0) {
            String[] argsSplit = args[0].split(" ");
            String command = argsSplit[argsSplit.length - 1];
            String expression = args[0].substring(0, args[0].length() - command.length());
            CronParserService cron = parseCronExpression(expression, command);
        }
        else{
            parseCronExpression("*/-5 * * * *");
        }
    }

    public static CronParserService parseCronExpression(String cronExpressions, String command) {
        System.out.println("\nExpression : "+cronExpressions);
        return new CronParserService(cronExpressions, command);
    }

    public static CronParserService parseCronExpression(String cronExpressions) {
        String command = "Blank command.";
        System.out.println("\nExpression : "+cronExpressions);
        return new CronParserService(cronExpressions, command);
    }
}
