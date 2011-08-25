package edu.umn.ncs

class GiftCardCheckout {
	Date dateCheckedOut
	String checkedOutToWhom		// i.e. Interviewer
	String checkedInByWhom		// user scanning gift cards

	static belongsTo = [ giftCard: GiftCard ]

    static constraints = {
    }
}
