package edu.umn.ncs

/** This class class represents the types of 
instrument approvals available. 
Examples: IRB, OMB, Supervisor */
class InstrumentApprovalType implements Serializable {

	/** This is the name of the instrument approval type */
    String name

	/** this is the default String converter for this class.
	This simply returns the 'name' attribute */
    String toString() {
        name
    }

	/** this constraint limits the name attribute to a maximum of
	16 characters */
    static constraints = {
        name(maxSize:16)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}
