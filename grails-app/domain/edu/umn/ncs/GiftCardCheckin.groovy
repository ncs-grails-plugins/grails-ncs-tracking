package edu.umn.ncs

class GiftCardCheckin {
	Date dateCheckedIn
	String checkedInFromWhom	// i.e. Interviewer
	String checkedInByWhom		// user scanning gift cards
	
	static belongsTo = [ giftCard: GiftCard ]

    static constraints = {
    }
}
