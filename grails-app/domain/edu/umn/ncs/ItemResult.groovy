package edu.umn.ncs

import org.codehaus.groovy.grails.plugins.orm.auditable.AuditLogEvent

class ItemResult implements Serializable {

	static auditable = true

    Result result
    Date receivedDate = new Date()

    String userCreated
    String appCreated
    String userUpdated

    Date dateCreated
    Date lastUpdated = null
    
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

    static belongsTo = [trackedItem : TrackedItem]

    static constraints = {
        result()
        receivedDate()
        userCreated()
        appCreated()
        dateCreated()
        userUpdated(nullable:true)
        lastUpdated(nullable:true)
    }
}
