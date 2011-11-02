package edu.umn.ncs

/** This class represent the name of a source for
a batch creation queue */
class BatchCreationQueueSource implements Serializable {

	/** This is the name of the queue source */
    String name

	/** this is the default String converter for this class.
	This simply returns the 'name' attribute */
    String toString() {
        name
    }

	/** this constraint limits the name attribute to a maximum of
	16 characters */
    static constraints = {
        name(maxSize:16)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}

