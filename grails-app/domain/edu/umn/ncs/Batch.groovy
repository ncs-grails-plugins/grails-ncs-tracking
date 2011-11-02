package edu.umn.ncs

/**
This class represents a batch of items that are generated in the
system to track a set of items representing individual instruments.
Instruments are typically a letter, survey, notification, postcard
or internal document.
*/
class Batch implements Serializable {

    /** This is the format of the document. 
	Examples are: postal mail, phone call or internal document. */
    InstrumentFormat format
    /** This assigns the direction of the batch of items.
	Examples are: incoming, outgoing or internal */
    BatchDirection direction
    /** If available, this is the date the tracking document was returned. */
    Date trackingReturnDate
    /** If available, this is the date the first item was returned */
    Date minimumReturnDate
    /** This is the date printed on the instrument */
    Date instrumentDate
    /** If mailed, this is the date the items were mailed out */
    Date mailDate
    /** If applicable, this is the date the batch 
	was sent to U of MN Addressing and Mailing */
    Date addressAndMailingDate
    /** If applicable, this is the date sent to UMN Printing Services */
    Date printingServicesDate
	/** If applicable, this is the date called Campus Courier */
    Date calledCampusCourierDate
    /** This is the user that created this batch */
    String batchRunBy
    /** This is the name of the application that created this batch */
    String batchRunByWhat
    /** This flags whether or not a tracking document was mailed */
    boolean trackingDocumentSent
    /** When this is updated, this is the date this item was updated */
    String updatedBy
    /** This references the master batch if this is part of a document bundle. */
    Batch master

    /** this is for read only calculated fields */
    static transients = ['primaryBatchInstrument'
        , 'primaryInstrument'
        , 'pieces'
        , 'subBatches']
	
	/** This returns the primary BatchInstrument instance
	for this batch. */
    BatchInstrument getPrimaryBatchInstrument() {
        instruments.find{ it.isPrimary }
    }

	/** This returns the primary Instrument instance
	for this batch. */
    Instrument getPrimaryInstrument() {
        (instruments.find{ it.isPrimary })?.instrument
    }

	/** This is the default string converter method for
	this class.  It returns "${primaryInstrument} batch # ${id}" */
	String toString() {
		"${primaryInstrument} batch # ${id}".trim()
	}

	/** This returns the number of items in the batch. */
    Integer getPieces() {
        /** this may be wrong eventually due to lazy fetching??? */
        if (items) {
            return items?.size()
        } else {
            return 0
        }
		
    }

	/** This returns all the other batches in this bundle if
	this is the master batch. */
    Batch[] getSubBatches(){
        def c = Batch.createCriteria()
        def batchInstanceList = c.list{
            and {
                master {
                    eq("id", id)
                }
                ne("id", id)
            }
        }
        return batchInstanceList
    }

    /** configuration used to generate this batch.
	This maps the creationConfig variable to the 
	BatchCreationConfig, aka, Bundle that it belongs to. */
    static belongsTo = [creationConfig: BatchCreationConfig]

	/** This is the static map that lists the foreign key contraints.
	<dl>
		<dt>instruments</dt>
		<dd>a colleciton of BatchInstrument instances</dd>
		<dt>items</dt>
		<dd>a colleciton of TrackedItem instances</dd>
	</dl>
	 */
    static hasMany = [instruments: BatchInstrument, items : TrackedItem]
	
	/** This the the date the batch was created. */
    Date dateCreated = new Date()
	/** This is the date the batch was last updated */
    Date lastUpdated = null

	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>master</dt>
		<dd>optional (nullable)</dd>
		<dt>trackingReturnDate</dt>
		<dd>optional (nullable)</dd>
		<dt>minimumReturnDate</dt>
		<dd>optional (nullable)</dd>
		<dt>instrumentDate</dt>
		<dd>optional (nullable)</dd>
		<dt>mailDate</dt>
		<dd>optional (nullable)</dd>
		<dt>addressAndMailingDate</dt>
		<dd>optional (nullable)</dd>
		<dt>printingServicesDate</dt>
		<dd>optional (nullable)</dd>
		<dt>calledCampusCourierDate</dt>
		<dd>optional (nullable)</dd>
		<dt>batchRunBy</dt>
		<dd>maximum length of 16 characters</dd>
		<dt>batchRunByWhat</dt>
		<dd>maximum length of 50 characters</dd>
		<dt>updatedBy</dt>
		<dd>optional (nullable), maximum length of 16 characters</dd>
		<dt>creationConfig</dt>
		<dd>optional (nullable)</dd>
	</dl>
	*/
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
        calledCampusCourierDate(nullable:true)
        batchRunBy(maxSize:16)
        batchRunByWhat(maxSize:50)
        trackingDocumentSent()
        updatedBy(nullable:true, maxSize:16)
        creationConfig(nullable:true)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'dateCreated' attribute. */
	static mapping = {
		sort: 'dateCreated'
	}
}
