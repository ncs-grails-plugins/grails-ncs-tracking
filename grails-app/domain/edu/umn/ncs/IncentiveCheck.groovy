package edu.umn.ncs

class IncentiveCheck {
	Incentive incentive
	BigDecimal amount
	Boolean paymentStarted
	Boolean checkGenerated
	Integer checkNumber
	Date checkDate
		
    static constraints = {
    	incentive(nullable:true)    	
    }
}
