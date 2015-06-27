package pl.com.bms.doodle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DoodleInfoFactory{

    public static DoodleInfo forTexts(String title, String creator, String creatorEmail, List<String> options){
        return new TextDoodleInfo(title, creator, creatorEmail, options);
    }

    public static DoodleInfo forDates(String title, String creator, String creatorEmail, List<LocalDate> options){
        return new DateDoodleInfo(title, creator, creatorEmail, options);
    }

    public static DoodleInfo forTimes(String title, String creator, String creatorEmail, List<LocalDateTime> options){
        return new TimeDoodleInfo(title, creator, creatorEmail, options);
    }

    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final String TIME_FORMAT = "yyyyMMddHHmm";

    private static class TextDoodleInfo extends DoodleInfo {
        private TextDoodleInfo(String title, String creator, String creatorEmail, List<String> options) {
            super(title, creator, creatorEmail, DoodleType.TEXT, options);
        }
    }

    private static class DateDoodleInfo extends DoodleInfo {
        private DateDoodleInfo(String title, String creator, String creatorEmail, List<LocalDate> options) {
            super(title, creator, creatorEmail, DoodleType.DATES, convertToDates(options));
        }
    }

    private static class TimeDoodleInfo extends DoodleInfo {
        private TimeDoodleInfo(String title, String creator, String creatorEmail, List<LocalDateTime> options) {
            super(title, creator, creatorEmail, DoodleType.DATES, convertToTimes(options));
        }
    }

    private static List<String> convertToDates(List<LocalDate> options) {
        return convert(
                options.stream()
                    .map(LocalDate::atStartOfDay)
                    .collect(Collectors.toList())
                , DATE_FORMAT);
    }

    private static List<String> convertToTimes(List<LocalDateTime> options) {
        return convert(options, TIME_FORMAT);
    }

    private static List<String> convert(List<LocalDateTime> options, String timeFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
        return options.stream()
                .map(formatter::format)
                .collect(Collectors.toList());
    }
}
