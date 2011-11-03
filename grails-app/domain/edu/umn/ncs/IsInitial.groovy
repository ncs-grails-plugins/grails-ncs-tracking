package edu.umn.ncs

class IsInitial implements Serializable {
	/** This hold either  'initial' or 'reminder' */
    String name

	/** this is the default String converter for this class.
	This simply returns the 'name' attribute */
    String toString() {
        name
    }

	/** this is the default Boolean converter for this
	class.  This simply returns 'true' if it's an initial
	and falst if not. */
    Boolean toBoolean() {
        if (name == 'initial') {
            return true
        } else {
            return false
        }
    }

	/** The non-default constraints for this class
	restrict the length of the name field to 8 chacters */
    static constraints = {
        name(maxSize: 8)
    }
}
