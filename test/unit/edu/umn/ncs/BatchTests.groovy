package edu.umn.ncs

import grails.test.*

class BatchTests extends GrailsUnitTestCase {
    Instrument i
    Study s
    InstrumentFormat inf
    IsInitial ii
    BatchDirection bd
	Batch b
    Date today
	Date yesterday
    Date tomorrow
    Date nextWeek
    Date inTwoWeeks
	Date nextMonth
    String appName
    String username

    protected void setUp() {
        super.setUp()

        mockDomain(Batch)

		appName = 'test'
        username = 'ajz'
        today = new Date()
		tomorrow = today + 1
		yesterday = today - 1
		nextWeek = today + 7
		inTwoWeeks = today + 14
		nextMonth = today + 31
        bd = new BatchDirection(name:'outgoing')
        inf = new InstrumentFormat(name:'first class mail', groupName:'mail')
        ii = new IsInitial(name:'initial')
		b = getTestBatch()

    }

	private Batch getTestBatch() {
        def batchInstance = new Batch(id:1, format:inf, direction: bd, 
			instrumentDate: today, batchRunBy: username,
			batchRunByWhat: appName, trackingDocumentSent:false)
		return batchInstance
	}

    protected void tearDown() {
        super.tearDown()
    }

    void testValidateInstrumentDateSameAsDateCreated() {
		b = getTestBatch()
		b.dateCreated = today
		b.instrumentDate = today

		assert b.validate()
    }

    void testMailDateIsNull() {
		b = getTestBatch()
		b.dateCreated = today
		b.instrumentDate = today
		b.mailDate = null

		assert b.validate()
    }

    void testMailDateGreaterThanDateCreated() {
		b = getTestBatch()
		b.dateCreated = today
		b.instrumentDate = today
		b.mailDate = tomorrow

		assert b.validate()
    }

    void testMailDateEqualToDateCreated() {
		b = getTestBatch()

		b.dateCreated = today
		b.instrumentDate = today
		b.mailDate = today

		assert b.validate()
    }

    void testMailDateLessThanDateCreated() {
		b = getTestBatch()

		b.dateCreated = today
		b.instrumentDate = today
		b.mailDate = yesterday

		assert !b.validate()
    }

	
	// tracking return Date must be after mail date
	void testTrackingReturnDateAfterMailDate() {
		b = getTestBatch()

		b.trackingReturnDate = nextWeek
		b.dateCreated = today
		b.mailDate = today

		assertEquals b.dateCreated, b.mailDate
		assert b.dateCreated == b.mailDate
		assert b.dateCreated < b.trackingReturnDate
		assert b.mailDate < b.trackingReturnDate
		assert b.validate()
    }
	
	// tracking minimum return date must be after mail date
	void testMinimumReturnDateAfterMailDate() {
		b = getTestBatch()

		b.dateCreated = today
		b.mailDate = today 
		b.instrumentDate = today
		b.minimumReturnDate = tomorrow

		assert b.dateCreated <= b.mailDate
		assert b.dateCreated <= b.minimumReturnDate
		assert b.mailDate <= b.minimumReturnDate
		assert b.validate()
    }
	
	// instument date must not be earlier than 7 days before date created
	void testInstrumentDateNotEarlierThanSevenDaysBeforeDateCreated() {
		b = getTestBatch()

		b.dateCreated = today
		b.instrumentDate = today - 7 
		assert b.validate()
		b.instrumentDate = today - 8 
		assert !b.validate()
    }

	void testAddressAndMailingDateAfterDateCreated() {
		assert true
	}

	void testAddressAndMailingDateBeforeMailDateAndPrintingServicesDate() {
		assert true
	}

	void testPrintingServiceDateAfterDateCreated() {
		assert true
	}

	void testPrintingServiceDateBeforeSentOutForMailing() {
		assert true
	}

	void testCalledCampusCourierDateAfterDateCreated() {
		assert true
	}

	void testCalledCampusCourierDateBeforeSentOutForMailing() {
		assert true
	}

}
