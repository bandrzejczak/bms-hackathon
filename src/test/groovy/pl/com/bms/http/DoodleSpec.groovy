package pl.com.bms.http

import pl.com.bms.doodle.DoodleInfo
import spock.lang.Specification

class HttpClientSpec extends Specification {

    def "should create"(){
        when:
        def doodle = new DoodleInfo().createDoodle()

        then:
        println(doodle.id)
        println(doodle.adminKey)
    }

}
