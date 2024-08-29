package src.Constants;

public class CronSpecialChar {
    public enum SpecialCharacters {
        AsteriskWithSlash("^\\*/(\\d{1,2})"),
        Asterisk("*"),
        CommaAndDash("(\\d+-\\d+,)+\\d+-\\d+"),
        Comma(".*[,].*"),
        Dash(".*-.*"),
        Slash(".*[/].*"),
        Question("?"),
        Number("^-?\\d+$");


        private String regex;

        public String getRegex() {
            return regex;
        }

        SpecialCharacters(String s) {
            this.regex = s;
        }
    }
}
