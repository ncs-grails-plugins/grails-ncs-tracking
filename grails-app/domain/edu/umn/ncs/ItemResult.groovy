package edu.umn.ncs

import org.codehaus.groovy.grails.plugins.orm.auditable.AuditLogEvent

/** This class represents a result, or status applied to
a {@link TrackedItem} instance. */
class ItemResult implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

	/** This is the result being tied to the {@link TrackedItem} */
    Result result
	/** The is the date that the {@link TrackedItem} earned the result it is being assigned. */
    Date receivedDate = new Date()

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

	/** This is the default string converter for this class.
	 It returns "${result} on ${receivedDate}"
	 @see #result
	 @see #receivedDate
	 */
	String toString() {
		"${result} on ${receivedDate}"
	}

	/** This onDelete trigger saves old tracked item information
	to an auditLog instance so that all changes to this class
	are transacted out */
   	def onDelete = { oldMap ->
		def now = new Date()
		
		String oldValue = "Result for ${oldMap.trackedItem?.id} of ${oldMap.result} on ${oldMap.receivedDate}. Created: [on: ${oldMap.dateCreated} by:${oldMap.userCreated}] Updated: [on: ${oldMap.lastUpdated} by: ${oldMap.userUpdated}]"
		
		oldMap.name + ', ' + oldMap.color + ', ' + oldMap.dateBaked
		String className = this.class.toString().replace('class ', '')
		println "${now}\tAudit:DELETE::\t${oldValue}"
		
		def auditLogEventInstance = new AuditLogEvent(className: className, 
			dateCreated: now,
			eventName: 'DELETE',
			lastUpdated: now,
			oldValue: oldValue,
			persistedObjectId: this.id,
			persistedObjectVersion: this.version)
			if ( ! auditLogEventInstance.save() ) {
			auditLogEventInstance.errors.each{
				println "${now}\tError Transacting DELETE:: \t ${it}"
			}
		}
	}

	/** This class belongs to a {@link TrackedItem} instance
	that is linked via the trackedItem attribute , and has a
	1:1 relationship.
	@see #trackedItem */
    static belongsTo = [trackedItem : TrackedItem]

	/** This static defines any non-standard constraints
	placed on attributes with this class.
	<dl>
		<dt>userUpdated</dt>
		<dd>optional (nullable)<dd>
		<dt>lastUpdated</dt>
		<dd>optional (nullable)<dd>
	</dl>
	@see #userCreated
	@see #lastUpdated
	*/
    static constraints = {
        result()
        receivedDate()
        userCreated()
        appCreated()
        dateCreated()
        userUpdated(nullable:true)
        lastUpdated(nullable:true)
    }

	/** This mapping sets the default sort order for
	this class to be sorted by receivedDate. */
	static mapping = { 
		sort 'receivedDate'
	}
}
