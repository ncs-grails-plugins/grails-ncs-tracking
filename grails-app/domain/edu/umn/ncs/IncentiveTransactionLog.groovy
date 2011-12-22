package edu.umn.ncs

/** This class is used for holding the 
check in/check out logs for an incentive */
class IncentiveTransactionLog {

	/** This is the date of the transaction */
	Date transactionDate = new Date()

	/** This flags whether or not this transaction is 
	for a check out or a check in */
	Boolean checkedOut = false

	/** If this incentive is checked in/out, this is to whom
	it is checked out */
	String checkedOutInToWhom		// i.e. interviewer
	/** If the incentive was checked in/out, this is the 
	person who did the checking out */
	String checkedOutInByWhom		// card scanning person
	/** This flags whether or not the incentive
	was given to a person rather than being
	checked back in */
	Boolean givenToPerson = false

	/** This belongs to map ties this transaction
	log entry to the Incentive that it belongs to
	via the 'incentive' attribute.  */
	static belongsTo = [ incentive: Incentive ]

	/** Comment for the transaction if provided */
	String comment

	/** This is the default string converter for this class.
	It returns "(checked|handed) (out|in) (to|by) ${checkedOutInToWhom} [by ${checkedOutInByWhom] on ${transactionDate}" */  
	String toString() {
		def retval = ""
		if (checkedOut) {
			retval = "checked out to ${checkedOutInToWhom} by ${checkedOutInByWhom}"
		} else if (givenToPerson) {
			retval = "handed out by ${checkedOutInToWhom}"
		} else {
			retval = "checked in to ${checkedOutInToWhom} by ${checkedOutInByWhom}"
		}
		retval += " on " + transactionDate.format('yyyy-MM-dd')

		return retval
	}
	
	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>checkedOut</dt>
		<dd>optional (nullable)</dd>
		<dt>givenToPerson</dt>
		<dd>optional (nullable)</dd>
	</dl>
	*/
    static constraints = {
    	incentive()
	    transactionDate()
    	checkedOutInToWhom()
    	checkedOutInByWhom()
    	checkedOut(nullable:true)
    	givenToPerson(nullable:true)
		comment(nullable:true, maxSize: 1000)
    }

	/** this mapping sets the default sort order
	for this class to be ordered by type, and then
	by barcode */
	static mapping = {
		sort 'transactionDate'
	}
}
