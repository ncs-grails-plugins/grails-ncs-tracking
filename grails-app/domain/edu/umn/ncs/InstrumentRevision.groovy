package edu.umn.ncs

/** This class is used to store the types of 
revisions that can be tracked by the InstrumentHistory
class */
class InstrumentRevision implements Serializable {

	/** This is the name of the type of revision.
	Suggested names are: minor, major, etc... */
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
