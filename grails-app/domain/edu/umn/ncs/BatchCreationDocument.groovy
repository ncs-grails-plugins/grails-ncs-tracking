package edu.umn.ncs

/** This class represents a document that needs
to be printed after a configuration run has completed.
This usually represents anything that needs to be 
printed out.  Most of these are instruments as merge
documents, but they can be static forms, or instruction 
sheets */
class BatchCreationDocument implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

    /** This represents the relative location within the 
	SVN or GIT document repository that the document is
	stored.  The web server will use this to offer the user
	a download link for the document by appending it
	to the web server's local verison of the document
	repository */
    String documentLocation

	/** If this document is a merge document, this is the
	name of the merge source file used to put the merge
	data into.  This the name of the CSV file. */
    String mergeSourceFile

	/** Comments can be helpful */
	String comment

	/** The sort order for the merge data.
	This is a map containing the sort parameters for 
	the dataset in the format:
	[column1:asc, column2:desc, column3:asc]  */
	String sortOrder
    
	/** This is the default string converter method for
	this class.  It returns the 'documentLocation' attribute. */
	String toString() { documentLocation }

	/** this static belongsTo map associates this class
	with the parent BatchCreationConfig that it belongs
	to throught the batchCreationConfig attribute */
    static belongsTo = [ batchCreationConfig : BatchCreationConfig ]

	/** this static hasMany map associates this class
	with any number of dataset types used to build the
	merge field if specified.  These are accessible through:
	<dl>
		<dt>dataSets</dt>
		<dd>a collection of DataSetType instances</dd>
	</dl>
	*/
    static hasMany = [ dataSets : DataSetType ]

	/** This static defines any non-standard constraints
	placed on attributes with this class.
	<dl>
		<dt>documentLocation</dt>
		<dd>maximum length of 512 characters<dd>
		<dt>mergeSourceFile</dt>
		<dd>optional (nullable), maximum length of 512 characters<dd>
	</dl> */
    static constraints = {
        documentLocation(maxSize:512)
        mergeSourceFile(nullable:true, maxSize:512)
		comment(nullable:ture, maxSize:2048)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'documentLocation' attribute. */
	static mapping = {
		sort 'documentLocation'
	}
}
