package edu.umn.ncs

/** This class holds the available types for the 
status of a particular version of an instrument as
logged via the InstrumentHistory class */
class InstrumentStatus implements Serializable {
	/** This is the name of the instrument status.
	Suggested names are: draft, pending approval, approved, etc... */
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
