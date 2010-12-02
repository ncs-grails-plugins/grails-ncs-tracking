package edu.umn.ncs

class InstrumentHistory implements Serializable {

	Instrument instrument
	BigDecimal itemVersion = 1.0
	IsInitial isInitial

	InstrumentRevision revisionType
	InstrumentStatus status

	Date startDate = new Date()
	Date endDate = null
	
	String comments

	String userCreated
        String appCreated
        String userUpdated

        Date dateCreated
        Date lastUpdated = null

	static hasMany = [ approvals : InstrumentApproval ]

    static constraints = {
		instrument()
		itemVersion()
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
}
