package edu.umn.ncs

class Incentive {
	TrackedItem trackedItem
	Boolean accepted = true
	IncentiveType type		// i.e. Check, Gift Card, Kazoo
	Study study
	Date incentiveDate		
	String comments
	// String pva   // obselete
	
	static hasMany = [ giftCards: GiftCard, checks: IncentiveCheck ]

	String toString() { type }
	
    static constraints = {
    	trackedItem(nullable:true)
		type()
		accepted()
		incentiveDate()
		study()
		//pva(nullable:true)
		comments(nullable:true)
    }
}
