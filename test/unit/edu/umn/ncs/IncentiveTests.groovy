package edu.umn.ncs

import grails.test.*

class IncentiveTests extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()

        mockDomain(IncentiveType)
        mockDomain(Incentive)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testInstantiation() {
		def incentiveTypeInstance = new IncentiveType(name:'test')
		def incentiveInstance = new Incentive(type:incentiveTypeInstance)
    }


	void testStringConverter() {
		def incentiveTypeInstance = new IncentiveType(name:'test')
		def incentiveInstance = new Incentive(type:incentiveTypeInstance)

		assert incentiveInstance.toString() == "test"
	}
}
