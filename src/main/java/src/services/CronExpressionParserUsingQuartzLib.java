package src.services;

import org.quartz.CronExpression;

import java.text.ParseException;
import java.util.TimeZone;

public class CronExpressionParserUsingQuartzLib {

    public CronExpressionParserUsingQuartzLib(String cronExpressionInput) throws Exception {

        CronExpression exp = new CronExpression(cronExpressionInput);
        exp.setTimeZone(TimeZone.getTimeZone("UTC"));

        System.out.println("Minute: " + exp.getExpressionSummary());
//        System.out.println("Hour: " + exp.getExpressionSummary().get("Hour"));
//        System.out.println("Day of Month: " + exp.getExpressionSummary().get("Day of Month"));
//        System.out.println("Month: " + exp.getExpressionSummary().get("Month"));
//        System.out.println("Day of Week: " + exp.getExpressionSummary().get("Day of Week"));

    }

}
