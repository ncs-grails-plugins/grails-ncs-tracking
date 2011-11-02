package edu.umn.ncs

/** This class represents the different formats
  that instruments are offered in */
class InstrumentFormat implements Serializable {

	/** This is the name of the instrument format*/
    String name

	/** This is used to group instrument formats */
    String groupName
	
	/** this is the default String converter for this class.
	This simply returns the 'name' attribute */
    String toString() {
        name
    }
	
	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>name<dt>
		<dd>maximum number of characters is 20<dd>
		<dt>groupName</dt>
		<dd>maximum number of characters is 16<dd>
	</dl>
	*/
    static constraints = {
        name(maxSize:20)
        groupName(maxSize:16)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}
