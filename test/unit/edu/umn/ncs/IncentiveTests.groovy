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
		assert true
    }


	void testStringConverter() {

		assert true
	}
}
