package pl.com.bms.doodle

import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

class DoodleSpec extends Specification {

    def "should create doodle for texts"(){
        when:
        def doodle = DoodleInfoFactory.forTexts(
                "Ankieta",
                "Test",
                "test@test.com",
                [
                        "Ananas",
                        "Banan",
                        "Jabłko"
                ]
        ).createDoodle()

        then:
        doodle != null
        doodle.id != null
        println("Created doodle: http://doodle.com/" + doodle.id)
    }

    def "should create doodle for dates"(){
        when:
        def doodle = DoodleInfoFactory.forDates(
                "Ankieta",
                "Test",
                "test@test.com",
                [
                        LocalDate.now(),
                        LocalDate.now().plusDays(1L),
                        LocalDate.now().plusDays(2L)
                ]
        ).createDoodle()

        then:
        doodle != null
        doodle.id != null
        println("Created doodle: http://doodle.com/" + doodle.id)
    }

    def "should create doodle for times"(){
        when:
        def doodle = DoodleInfoFactory.forTimes(
                "Ankieta",
                "Test",
                "test@test.com",
                [
                        LocalDateTime.now(),
                        LocalDateTime.now().plusHours(12L),
                        LocalDateTime.now().plusDays(1L)
                ]
        ).createDoodle()

        then:
        doodle != null
        doodle.id != null
        println("Created doodle: http://doodle.com/" + doodle.id)
    }

}
