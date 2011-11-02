package edu.umn.ncs

/** This class represents all of the date set types
that are available to the merge file creation process.
If you add one here, you should add code to the Document 
generation service as well. */
class DataSetType implements Serializable {

	/** This is the name of the dataset */
    String name
	/** This is the 'code name' of the dataset, or the
	abbreviation */
    String code

	/** this is the closure containing the groovy code
	that adds the required fields to the dataset. It MUST take
	a dataSet as a parameter, and return the altered dataset. If
	this is not provided, the closure or equivalent must exist
	in the respective service that builds the data source. */
	String closure

	/** this is the default String converter for this class.
	This simply returns the 'name' attribute */
    String toString() {
        name
    }

	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>code<dt>
		<dd>maximum number of characters is 16<dd>
		<dt>closure</dt>
		<dd>optional (nullable), maximum length is 8000 characters.</dd>
	</dl>
	*/
    static constraints = {
        name()
        code(maxSize:16)
		closure(nullable:true, maxSize: 8000)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}
