package edu.umn.ncs

import grails.test.*

class IncentiveTypeTests extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()

        mockDomain(IncentiveType)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testInstantiation() {
		def incentivesTypeInstance = new IncentiveType()

		// validation fails if no name is given
		assertFalse incentivesTypeInstance.validate()

		incentivesTypeInstance.name = 'Test'
		assertTrue incentivesTypeInstance.validate()
    }


	void testStringConverter() {
		def incentivesTypeInstance = new IncentiveType(name:'Testing')

		assert incentivesTypeInstance.toString() == 'Testing'
	}
}
