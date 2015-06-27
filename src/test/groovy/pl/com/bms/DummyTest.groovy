package pl.com.bms

import spock.lang.Specification

class DummyTest extends Specification {

    def "dummy test"() {
        expect:
            1+1 == 2
    }
}
