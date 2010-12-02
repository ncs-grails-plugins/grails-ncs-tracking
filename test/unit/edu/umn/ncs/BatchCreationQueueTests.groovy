package edu.umn.ncs

import grails.test.*

class BatchCreationQueueTests extends GrailsUnitTestCase {

    Gender male
    StreetAddress myAddress
    Person p
    Country us

    protected void setUp() {
        super.setUp()

        male = new Gender(name:'male')

        us = new Country(name:'United States', abbreviation:'us')

        myAddress = new StreetAddress(address:'3323 Buchanan St NE',
            city:'Minneapolis',
            state:'MN', zipCode:55418, zip4:1449,
            county:'Hennepin', country:us,
            appCreated:'byHand')

        p = new Person(title:'Mr',
            firstName:'Aaron',
            middleName:'James',
            lastName:'Zirbes',
            suffix:null,
            birthDate:new Date(79,11,21),
            gender:male,
            alive:true,
            isRecruitable:false,
            appCreated:'byHand')
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testValidQueueItems() {


        def q1 = new BatchCreationQueue(username:'ajz', 
            person: p)

        assert q1.username == 'ajz'

    }
}
