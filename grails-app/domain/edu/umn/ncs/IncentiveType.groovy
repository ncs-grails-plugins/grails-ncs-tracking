package edu.umn.ncs

/** This represents the types of incentives that can be given out
to people as tracked by the Incentive class */
class IncentiveType {
	/** This is the name of the incentive type.
	Suggested names are: gift card, cash money, kazoo, skateboard, etc... */
    String name

	/** this is the default String converter for this class.
	This simply returns the 'name' attribute */
    String toString() {
        name
    }

	/** there are no non-default constraints for this class */
    static constraints = {
        name()
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}
