package edu.umn.ncs

/** This tracks approvals for instrument versions */
class InstrumentApproval implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

	/** This is the date that this version of the instrument was approved. */
	Date approvalDate
	/** This is the person who approved this version */
	String approvedBy
	/** This is the approval type */
	InstrumentApprovalType approvalType
	/** These are any comments associated with this approval */
	String comments

	/** This is the username of te person who created this record */
    String userCreated
	/** This is the name of the app that created this record */
    String appCreated
	/** On an update, this is the username updating the record. */
    String userUpdated

	/** This is the date that this approval was created */
    Date dateCreated
	/** On an update, this is the date the record was updated */
    Date lastUpdated = null

	/** This is the default string converter for this class.
	This returns: "${approvalType} approval by ${approvedBy} on ${approvalDate}"
	*/
	String toString = {
		"${approvalType} approval by ${approvedBy} on ${approvalDate}"
	}

	/** This belongsTo map ties this class to the InstrumentHistory
	that this class belongs to via the instrumentHistory attribute. */
	static belongsTo = [ instrumentHistory : InstrumentHistory ]

	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>approvedBy</dt>
		<dd>optional (nullable)</dd>
		<dt>comments</dt>
		<dd>optional (nullable)</dd>
		<dt>appCreated</dt>
		<dd>optional (nullable)</dd>
		<dt>lastUpdated</dt>
		<dd>optional (nullable)</dd>
	</dl>
	*/
    static constraints = {
		instrumentHistory()
		approvalDate()
		approvedBy(nullable:true)
		approvalType()
		comments(nullable:true)
		userCreated()
		appCreated()
		userUpdated(nullable:true)
		dateCreated()
		lastUpdated(nullable:true)
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'approvalDate' attribute. */
	static mapping = {
		sort 'approvalDate'
	}
}
