package edu.umn.ncs

class GiftCard {
	String code
	String receiptNumber
	BigDecimal amount
	String description
	GiftCardType type		// VISA, Target, etc
	Incentive incentive
		
    static constraints = {
    	incentive(nullable:true)
    	description(nullable:true)
    	amount(nullable:true)
    	receiptNumber(nullable:true)
    	type(nullable:true)
    }
}
