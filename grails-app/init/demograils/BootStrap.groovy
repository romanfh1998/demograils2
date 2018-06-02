package demograils

import edu.pucmm.grails.domain.Koffee

class BootStrap {

    def init = { servletContext ->
        new Koffee(name: "Capuchino", price: 50).save(flush: true, failOnError: true)
        new Koffee(name: "Frapuchino", price: 80).save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
