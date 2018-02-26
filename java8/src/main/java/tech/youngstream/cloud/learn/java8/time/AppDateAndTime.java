package tech.youngstream.cloud.learn.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class AppDateAndTime {

    public static void main(String[] args) {
        //1. clock utc 标准时区时间
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);

        System.out.println(date);
        System.out.println(dateFromClock);

        final LocalDateTime dateTime = LocalDateTime.now();
        final LocalDateTime dateTimeFromClock = LocalDateTime.now(clock);

        System.out.println(dateTime);
        System.out.println(dateTimeFromClock);

        //特定时区
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);

        final LocalDateTime from  = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0,0);
        final LocalDateTime to = LocalDateTime.of(2015,Month.APRIL, 16, 23, 59,59);

        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(formatter.format(dateTime));

    }

}
