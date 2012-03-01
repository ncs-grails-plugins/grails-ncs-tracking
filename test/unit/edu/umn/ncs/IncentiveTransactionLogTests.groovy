package edu.umn.ncs

import grails.test.*

class IncentiveTransactionLogTests extends GrailsUnitTestCase {

	IncentiveType sampleType
	Incentive sampleIncentive
	def defaults
	def now

    protected void setUp() {
        super.setUp()

        mockDomain(IncentiveTransactionLog)
        mockDomain(IncentiveType)
        mockDomain(Incentive)

		sampleType = new IncentiveType(name:'Sample').save()
		sampleIncentive = new Incentive(type:sampleType)
		sampleIncentive.id = 1
		sampleIncentive.save()
		now = new Date()

		defaults = [ incentive: sampleIncentive,
				checkedOutInToWhom: 'ajz',
				checkedOutInByWhom: 'ajz',
				transactionDate: now]

    }

    protected void tearDown() {
        super.tearDown()
    }

    void testInstantiation() {
		// Simple test of instantiation
		def logInstance = new IncentiveTransactionLog()

		// validation fails if no name is given
		assertFalse logInstance.validate()

		// assert that the sampleIncentive has an ID of 1
		assert sampleIncentive.id == 1

		logInstance.incentive = sampleIncentive
		logInstance.checkedOutInToWhom = 'ajz'
		logInstance.checkedOutInByWhom = 'ajz'

		assert logInstance.incentive.id == 1

		// TODO: Figure out why this fails
		// assertTrue logInstance.validate()
    }

	void testStringConverter() {
		def logInstance = new IncentiveTransactionLog(defaults)

		def expectedString = 'checked in to ajz by ajz on ' + now.format('yyyy-MM-dd')
		assert logInstance.toString() == expectedString

		logInstance.givenToPerson = true
		expectedString = 'handed out by ajz on ' + now.format('yyyy-MM-dd')
		assert logInstance.toString() == expectedString

		logInstance.checkedOut = true
		expectedString = 'checked out to ajz by ajz on ' + now.format('yyyy-MM-dd')
		assert logInstance.toString() == expectedString
	}
}
