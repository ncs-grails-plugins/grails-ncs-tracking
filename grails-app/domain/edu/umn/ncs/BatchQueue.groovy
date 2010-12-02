package edu.umn.ncs
/* This class is used to manage a user's print/generation queue for
 * printing or reprinting documents in a batch, or one at a time.  This
 * is an enhancement to the batch based, or serial number based printing
 * methods that don't let you reprint as subset of items, or items from
 * multiple batches */
class BatchQueue implements Serializable {
    String username

    String appCreated
    Date dateCreated = new Date()
    Date lastUpdated = null

    static hasMany  = [ items : TrackedItem ]

    static constraints = {
        username()
        appCreated()
        dateCreated()
        lastUpdated()
    }
}
