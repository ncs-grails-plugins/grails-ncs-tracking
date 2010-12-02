package edu.umn.ncs

class Batch implements Serializable {

    // Paper, email, call?
    InstrumentFormat format
    // Incoming, outgoing?
    BatchDirection direction
    // date the tracking document was returned
    Date trackingReturnDate
    // date the first item was returned
    Date minimumReturnDate
    // date printed on the instrument
    Date instrumentDate
    // date the items were mailed out
    Date mailDate
    // date the batch was sent to U of MN Addressing and Mailing
    Date addressAndMailingDate
    // date sent to UMN Printing Services
    Date printingServicesDate
    // User that created this batch
    String batchRunBy
    // Application that created this batch
    String batchRunByWhat
    // Whether or not a tracking document was mailed
    boolean trackingDocumentSent
    // date this item was updated
    String updatedBy
    // master batch for docgen run
    Batch master

    // this is for read only calculated fields
    static transients = ['primaryBatchInstrument', 'primaryInstrument', 'pieces']

    BatchInstrument getPrimaryBatchInstrument() {
        instruments.find{ it.isPrimary }
    }

    Instrument getPrimaryInstrument() {
        (instruments.find{ it.isPrimary })?.instrument
    }

    Integer getPieces() {
        // this may be wrong eventually due to lazy fetching???
        if (items) {
            return items?.size()
        } else {
            return 0
        }
		
    }

    // configuration used to generate this batch
    static belongsTo = [creationConfig: BatchCreationConfig]

    static hasMany = [instruments: BatchInstrument, items : TrackedItem]
	
    Date dateCreated = new Date()
    Date lastUpdated = null

    static constraints = {
        dateCreated()
        format()
        direction()
        master(nullable:true)
        trackingReturnDate(nullable:true)
        minimumReturnDate(nullable:true)
        instrumentDate(nullable:true)
        mailDate(nullable:true)
        addressAndMailingDate(nullable:true)
        printingServicesDate(nullable:true)
        batchRunBy(maxSize:16)
        batchRunByWhat(maxSize:50)
        trackingDocumentSent()
        updatedBy(nullable:true, maxSize:16)
        creationConfig(nullable:true)
    }
}
