package edu.pucmm.grails.domain

class Koffee {

    String name;
    String description

    BigDecimal price

    static constraints = {
        description nullable: true
    }
}
