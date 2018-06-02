package demograils

import edu.pucmm.grails.domain.Koffee
import grails.gorm.transactions.Transactional

@Transactional
class KoffeeService {

    void createKoffe(String name, String description, BigDecimal price) {
        new Koffee(name: name, description: description, price: price).save(flush: true, failOnError: true)
    }

    int countKoffees() {
        return Koffee.count()
    }


    List<Koffee> allKoffees() {
        return Koffee.findAll()
    }

    void remove(Koffee koffee) {
        koffee.delete(flush: true, failOnError: true)
    }
}
