package edu.umn.ncs

/** This class provides a recipient for a tracking document that
is generated as part of the merge data source for a batch, if specified
in the configuration */
class TrackingDocumentRecipient implements Serializable {
	/** This is the person the tracking document is to be addressed to */
    Person person
	/** This is the address the tracking document is to be addressed to */
    StreetAddress address

	/** This is the default string converter for the class.
	This just returns the fullName of the person */
    String toString(){
        person.fullName
    }

	/** This mapping sets the default sort order for this class to be 
	sorted by person */
    static mapping = {
		sort 'person'
    }
}
