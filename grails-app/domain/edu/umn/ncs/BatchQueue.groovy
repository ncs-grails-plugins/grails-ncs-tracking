package edu.umn.ncs

/** This class is used to manage a user's print/generation queue for
 printing or reprinting documents in a batch, or one at a time.  This
 is an enhancement to the batch based, or serial number based printing
 methods that don't let you reprint as subset of items, or items from
 multiple batches */
class BatchQueue implements Serializable {
	/** this is the username that this queue belongs to */
    String username

	/** this is the application that created this queue */
    String appCreated
	/** This is the date that this queue was created */
    Date dateCreated = new Date()
	/** This is the date that this queue was last updated */
    Date lastUpdated = null

	/** this static hasMany maps the collection of TrackedItems
	to this class via the 'items' attribute */
    static hasMany  = [ items : TrackedItem ]

	/** This is the default string converter for this class.
		It returns: "BatchQueue(${username},${source})[id=${id}]"
		*/
	String toString() {
		"BatchQueue(${username})[id=${id}]"
	}

	/** there are no non-default constraints for this class */
    static constraints = {
        username()
        appCreated()
        dateCreated()
        lastUpdated()
    }

	/** This static mapping sets the default sort order
	for this class to be by username. */
	static mapping = {
		sort 'username'
	}
}
