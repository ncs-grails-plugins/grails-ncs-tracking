package edu.umn.ncs

class Incentive {
	TrackedItem trackedItem
	BigDecimal amount
	Boolean accepted = true
	IncentiveType type
	 
	Boolean paymentStarted
	Boolean checkGenerated
	Integer checkNumber
	Date checkDate
	String pva
	
	static hasMany = [ giftCard: GiftCard ]
		
	String comments

	String toString() {
		if (amount) {
			"\$${amount} ${type}"
		} else {
			type
		}
	}
	
    static constraints = {
    	trackedItem(nullable:true)
		type()
		amount(nullable:true)
		accepted()
		paymentStarted(nullable:true)
		checkGenerated(nullable:true)
		checkNumber(nullable:true)
		pva(nullable:true)
		giftCard(nullable:true)
		comments(nullable:true)
    }
}
