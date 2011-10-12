package edu.umn.ncs

class IncentiveTransactionLog {
	Incentive incentive
	Date transactionDate
	Boolean checkedOut = false
	String checkedOutInToWhom		// i.e. interviewer
	String checkedOutInByWhom		// card scanning person
	Boolean givenToPerson = false

    static constraints = {
    	incentive()
	    transactionDate()
    	checkedOutInToWhom()
    	checkedOutInByWhom()
    	checkedOut(nullable:true)
    	givenToPerson(nullable:true)
    }
}
