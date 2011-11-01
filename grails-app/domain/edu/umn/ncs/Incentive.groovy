package edu.umn.ncs

class Incentive {
	TrackedItem trackedItem
	Boolean accepted = true
	String barcode
	String receiptNumber
	BigDecimal amount
	IncentiveType type		// i.e. Check, Gift Card, Kazoo
	Date incentiveDate		
	
	Boolean paymentStarted
	Boolean checkGenerated
	Boolean checkNumber
	
	Boolean checkedOut = false
	String checkedOutToWhom		// i.e. interviewer
	String checkedOutByWhom		// card scanning person
	Date dateCheckedOut

	Date dateCreated
	Date lastUpdated
	String userCreated
	String userUpdated

	String comments
	// String pva   // obselete

	String toString() { type }
	
    static constraints = {
    	trackedItem(nullable:true)
		type()
		accepted()
		incentiveDate(nullable:true)
    	amount(nullable:true)
    	barcode(unique:true,nullable:true)
    	receiptNumber(nullable:true)
		//pva(nullable:true)
		paymentStarted(nullable:true)
        checkGenerated(nullable:true)
        checkNumber(nullable:true)
		comments(nullable:true)
    	checkedOutToWhom(nullable:true)
    	checkedOutByWhom(nullable:true)
    	dateCheckedOut(nullable:true)
    	dateCreated(display:false)
    	lastUpdated(display:false)
    	userCreated(maxSize:16)
    	userUpdated(maxSize:16)
    }
}
