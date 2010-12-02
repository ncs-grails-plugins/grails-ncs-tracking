package edu.umn.ncs

class BatchCreationQueryArchive implements Serializable {

    String selectionQuery
    Date dateCreated = new Date()

    String toString() {
        dateCreated.format('M/d/yyyy h:mm:ss a')
    }

    static belongsTo = [batchCreationConfig : BatchCreationConfig]

    static constraints = {
        selectionQuery(maxSize:8000)
        dateCreated()
    }
}
