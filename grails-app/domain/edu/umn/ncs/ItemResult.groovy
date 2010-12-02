package edu.umn.ncs

class ItemResult implements Serializable {

    Result result
    Date receivedDate = new Date()

    String userCreated
    String appCreated
    String userUpdated

    Date dateCreated
    Date lastUpdated = null

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
