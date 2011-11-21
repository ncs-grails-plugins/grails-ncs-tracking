package edu.umn.ncs

import grails.test.*

class TrackedItemTests extends GrailsUnitTestCase {
    Gender male
    StreetAddress myAddress
    Person p
    Country us
    DwellingUnit du
    BatchCreationConfig bcc
    Batch b
    Instrument i
    Study s
    InstrumentFormat inf
    IsInitial ii
    BatchDirection bd
    Date today
    String appName
    String username

    protected void setUp() {
        super.setUp()

        appName = 'test'
        username = 'ajz'
        today = new Date()
        bd = new BatchDirection(name:'outgoing')
        inf = new InstrumentFormat(name:'first class mail', groupName:'mail')
        ii = new IsInitial(name:'initial')

        b = new Batch(format:inf, direction: bd, 
			instrumentDate: today, batchRunBy: username,
			batchRunByWhat: appName, trackingDocumentSent:false)

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

    void testValidation() {

		mockDomain(TrackedItem)
        
        def ti1 = new TrackedItem(person: p, batch: b)

        def ti2 = new TrackedItem(dwellingUnit: du, batch: b)

        def ti3 = new TrackedItem(household: null, batch: b)

        assert ti1.validate()
        assert ti2.validate()
        assert !ti3.validate()

    }
}
