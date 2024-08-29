package src.services;

import src.model.*;

import java.util.ArrayList;

public class CronParserService {
    String expression;
    ArrayList<Integer> seconds;
    ArrayList<Integer> minutes;
    ArrayList<Integer> hours;
    ArrayList<Integer> dayOfMonth;
    ArrayList<Integer> month;
    ArrayList<Integer> dayOfWeek;

    public CronParserService(String exp) {
        this.expression = exp;
        String[] components = exp.split(" ");
        if (components.length == 6) {
            this.seconds = (new SecondsModel(components[0])).getNextOccurrences();
            this.minutes = (new MinutesModel(components[1])).getNextOccurrences();
            this.hours = (new HoursModel(components[2])).getNextOccurrences();
            this.dayOfMonth = (new DayOfMonthModel(components[3])).getNextOccurrences();
            this.month = (new MonthModel(components[4])).getNextOccurrences();
            this.dayOfWeek = (new DayOfWeekModel(components[5])).getNextOccurrences();

            System.out.println("second        " + stringifyResponse(seconds));
        }
        else if(components.length==5){
            this.minutes = (new MinutesModel(components[0])).getNextOccurrences();
            this.hours = (new HoursModel(components[1])).getNextOccurrences();
            this.dayOfMonth = (new DayOfMonthModel(components[2])).getNextOccurrences();
            this.month = (new MonthModel(components[3])).getNextOccurrences();
            this.dayOfWeek = (new DayOfWeekModel(components[4])).getNextOccurrences();
        }
        System.out.println("minutes       " + stringifyResponse(minutes));
        System.out.println("hours         " + stringifyResponse(hours));
        System.out.println("day of month  " + stringifyResponse(dayOfMonth));
        System.out.println("month         " + stringifyResponse(month));
        System.out.println("dayOfWeek     " + stringifyResponse(dayOfWeek));
    }

    private String stringifyResponse(ArrayList<Integer> responseList) {
        StringBuilder sb = new StringBuilder();
        if (responseList == null) {
            return "Invalid cron expression provided!";
        }
        for (Integer resp : responseList) {
            sb.append(resp + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
