package edu.umn.ncs

import grails.test.*

class IncentiveTransactionLogTests extends GrailsUnitTestCase {

	def sampleType
	def sampleIncentive
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
		def logInstance = new IncentiveTransactionLog()

		// validation fails if no name is given
		assertFalse logInstance.validate()

		logInstance.incentive = sampleIncentive
		logInstance.checkedOutInToWhom = 'ajz'
		logInstance.checkedOutInByWhom = 'ajz'

		assertTrue logInstance.validate()
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
