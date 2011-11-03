package edu.umn.ncs

/** This is used to tracks study incentives that are given
to people in return for completing study materials. Various
kinds of incentives are: gift cards, taxi vouchers, travel
reimbursement, etc. */
class Incentive {

	/** This lets you tie an incentive to a specific item */
	TrackedItem trackedItem

	/** This flags whether the person accepts the incentive */
	Boolean accepted = true

	/** This is the barcode identifier found on the item.
	  It can be a UPC code, serial number, or gift card
	  barcode. */
	String barcode
	/** This boolean flags whether this incentive is in an
	active status.  This is typically used for gift cards */
	Boolean activated = false
	/** This is the receipt number that the incentive was 
	purchased with if available */
	String receiptNumber
	/** this is the value of the incentive in USD */
	BigDecimal amount
	/** this is the type of incentive.  example types:
	check, gift card, kazoo, pencil */
	IncentiveType type
	/** This is the date the incentive was given to
	the person */
	Date incentiveDate		
	
	/** If the incentive is a reimbursement of sorts, this 
	flags that the payment process has started. */
	Boolean paymentStarted
	/** This flgs that a check has been generated for a
	reimbursement type of incentive */
	Boolean checkGenerated
	/** This is the check number, if applicable for the
	  incentive */
	Boolean checkNumber
	
	/** Indicates the activation status of gift card
	 type incentives */
	Boolean activated = false
	Date dateActivated
	
	/** If this is a check-out-able item (gift card), then
	  this flags whether or not the incentive is checked
	  out */
	Boolean checkedOut = false
	/** If this incentive is checked out, this is to whom
	it is checked out */
	String checkedOutToWhom
	/** If the incentive was checked out, this is the 
	person who did the checking out */
	String checkedOutByWhom
	/** This is the date the item was checked out */
	Date dateCheckedOut

	/** This hasMany map ties this class to the
	collection of IncentiveTransactionLog instances that
	belong to it via the 'transactionLogs' attribute */
	static hasMany = [ transactionLogs : IncentiveTransactionLog ]

	/** This is the date that the record was created */
	Date dateCreated
	/** This is the date the record was last updated */
	Date lastUpdated
	/** This is the username of the person that created
	the record */
	String userCreated
	/** This is the username of the person that last
	updated the record. */
	String userUpdated

	/** This holds any comments associated with this incentive */
	String comments

	/** This is the default string converter for this class.
	It simply returns the 'type' attribute */  
	String toString() { type }
	
	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>trackedItem</dt>
		<dd>optional (nullable)</dd>
		<dt>incentiveDate</dt>
		<dd>optional (nullable)</dd>
		<dt>amount</dt>
		<dd>optional (nullable)</dd>
		<dt>barcode</dt>
		<dd>unique for each 'type', optional (nullable)</dd>
		<dt>receiptNumber</dt>
		<dd>optional (nullable)</dd>
		<dt>paymentStarted</dt>
		<dd>optional (nullable)</dd>
		<dt>checkGenerated</dt>
		<dd>optional (nullable)</dd>
		<dt>checkNumber</dt>
		<dd>optional (nullable)</dd>
		<dt>comments</dt>
		<dd>optional (nullable)</dd>
		<dt>checkedOutToWhom</dt>
		<dd>optional (nullable)</dd>
		<dt>checkedOutByWhom</dt>
		<dd>optional (nullable)</dd>
		<dt>dateCheckedOut</dt>
		<dd>optional (nullable)</dd>
		<dt>dateCreated</dt>
		<dd>optional (nullable)</dd>
		<dt>lastUpdated</dt>
		<dd>optional (nullable)</dd>
		<dt>userCreated</dt>
		<dd>optional (nullable)</dd>
		<dt>userUpdated</dt>
		<dd>optional (nullable)</dd>
	</dl>
	*/
    static constraints = {
    	trackedItem(nullable:true)
		type()
		accepted()
		activated()
		incentiveDate(nullable:true)
    	amount(nullable:true)
    	barcode(unique:'type', nullable:true)
    	receiptNumber(nullable:true)
		activated()
		dateActivated(nullable:true)
		paymentStarted(nullable:true)
        checkGenerated(nullable:true)
        checkNumber(nullable:true)
		comments(nullable:true)
    	checkedOutToWhom(nullable:true)
    	checkedOutByWhom(nullable:true)
    	dateCheckedOut(nullable:true)
    	dateCreated(display:false)
    	lastUpdated(nullable:true, display:false)
    	userCreated(display:false)
    	userUpdated(nullable:true, display:false)
    }

	/** this mapping sets the default sort order
	for this class to be ordered by type, and then
	by barcode */
	mapping = {
		sort type:'asc', barcode:'asc'
	}
}
