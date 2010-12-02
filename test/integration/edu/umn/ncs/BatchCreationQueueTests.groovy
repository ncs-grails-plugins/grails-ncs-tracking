package edu.umn.ncs

import grails.test.*

/*
 * These test make sure that the BatchCreationQueue has at least a
 * person, or household, or dwelling unit.  If you need to add new
 * enpoints to the trackedItem, you'll need to add new tests here.
 */

class BatchCreationQueueTests extends GrailsUnitTestCase {

    Gender male
    StreetAddress myAddress
    Person p
    Country us
    DwellingUnit du

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

        du = new DwellingUnit(address:myAddress,
                    appCreated:'byHand')
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testValidQueueItems() {


        def q1 = new BatchCreationQueue(username:'ajz', 
            person: p)

        def q2 = new BatchCreationQueue(username:'ajz',
            dwellingUnit: du)

        def q3 = new BatchCreationQueue(username:'ajz',
            household: null)

        assert q1.validate()
        assert q2.validate()
        assert !q3.validate()

    }
}
