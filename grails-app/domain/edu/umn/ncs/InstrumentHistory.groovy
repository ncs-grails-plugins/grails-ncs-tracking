package edu.umn.ncs

/** This class tracks the history of document revisions and approvals
and any comments associated with them.  This class seems kind
of superfluous now that we are using SVN to track the production
document repository. */
class InstrumentHistory implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

	/** this is the instrument refered to.  This could possibly
	be a 'belongsTo' attribute. */
	Instrument instrument
	/** this is the version of the instrument revision we are
	logging the change for */
	BigDecimal itemVersion = 1.0

	/** This optionally records the cvs (SVN, Git, etc...) version
	of the document in quesiton if the document is stored
	in a version control system */
	String vcsVersion
	/** this is a flag as to whether the change is to the initial
	or reminder version of the instrument */
	IsInitial isInitial

	/** This logs the type on change being made */
	InstrumentRevision revisionType
	/** This is used to store the status of this 
	version of the document */
	InstrumentStatus status

	/** This is the date that this document goes into production */
	Date startDate = new Date()
	/** This is the date that this document is retired */
	Date endDate = null
	
	/** These are any comments associated with this version of the
	document */
	String comments

	/** This is the default string converter for this class.
		It returns: "${instrument} (${isInitial}), v${version}"
		*/
	String toString() {
		"${instrument} (${isInitial}), v${version}"
	}

	// BEGIN PROVENANCE FIELDS
	/**
	This field is automatically assigned the date that this 
	particular ContactRole instance was created */
	Date        dateCreated = new Date()
	/**
	This field should be assigned the username of the 
	authenticated user that is creating an instance of this class.  */
	String      userCreated = 'unknown'
	/**
	This field should be assigned the name of the application that
   	is creating an instance of this class.  */
	String      appCreated
	/**
	This field should be propogated with the current date and
   	time "new Date()" that an instance of this class is updated.
	Grails will automatically take care of this per section 
	5.5.1 of the Grails 1.3.7 documentation.  */
	Date        lastUpdated
	/**
	This field should be propogated with the username of 
	the authenticated user when an instance of this class is updated.  */
	String      userUpdated
	// END PROVENANCE FIELDS

	static hasMany = [ approvals : InstrumentApproval ]

	/** This static defines any non-standard constraints
	placed on attributes with this class.
	<dl>
		<dt>vcsVersion</dt>
		<dd>optional (nullable)<dd>
		<dt>endDate</dt>
		<dd>optional (nullable)<dd>
		<dt>comments</dt>
		<dd>optional (nullable)<dd>
		<dt>userUpdated</dt>
		<dd>optional (nullable)<dd>
		<dt>lastUpdated</dt>
		<dd>optional (nullable)<dd>
	</dl> */
    static constraints = {
		instrument()
		itemVersion()
		vcsVersion(nullable: true)
		isInitial()
		revisionType()
		startDate()
		endDate(nullable:true)
		status()
		comments(nullable:true)
		userCreated()
		appCreated()
		userUpdated(nullable:true)
		dateCreated()
		lastUpdated(nullable:true)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'instrument' then 'itemVersion' attribute. */
	static mapping = {
		sort instrument:'asc', itemVersion:'asc'
	}
}
