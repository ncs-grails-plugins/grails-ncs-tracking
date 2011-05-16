package edu.umn.ncs

class InstrumentApproval implements Serializable {

	static auditable = true

	Date approvalDate
	String approvedBy
	InstrumentApprovalType approvalType
	String comments

    String userCreated
    String appCreated
    String userUpdated

    Date dateCreated
    Date lastUpdated = null

	String toString = {
		"${approvalType} approval by ${approvedBy} on ${approvalDate}"
	}

	static belongsTo = [ instrumentHistory : InstrumentHistory ]

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
}
