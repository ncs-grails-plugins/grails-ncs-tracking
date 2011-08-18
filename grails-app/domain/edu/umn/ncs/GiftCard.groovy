package edu.umn.ncs

class GiftCard {
	String code
	String receiptNumber
	BigDecimal amount
	String description
	GiftCardType type		// VISA, Target, etc
	Incentive incentive
	Boolean checkedOut = false
	String checkedOutTo
	Date checkedOutDate
	Date dateCreated
	Date lastUpdated
	String userCreated
	String userUpdated
		
    static constraints = {
    	code(unique:true)
    	dateCreated(display:false)
    	lastUpdated(display:false)
    	userCreated(maxSize:16)
    	userUpdated(maxSize:16)
    	incentive(nullable:true)
    	description(nullable:true)
    	amount(nullable:true)
    	receiptNumber(nullable:true)
    	type(nullable:true)
    	checkedOutTo(nullable:true)
    	checkedOutDate(nullable:true)
    }
}
