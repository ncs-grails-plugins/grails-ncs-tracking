package edu.umn.ncs

/** This class represents the type of relationships that
can occur between instruments in a bundle */
class BatchCreationItemRelation implements Serializable {

	/** This is the name of the relation */
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
