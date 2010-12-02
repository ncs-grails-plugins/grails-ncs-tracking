package edu.umn.ncs

class BatchCreationDocument implements Serializable {

    // This should be a URL format
    String documentLocation
    // This may not make sense in the new version
    String mergeSourceFile
    
    static belongsTo = [ batchCreationConfig : BatchCreationConfig ]

    static hasMany = [ dataSets : DataSetType ]

    static constraints = {
        documentLocation(maxSize:512)
        mergeSourceFile(nullable:true, maxSize:512)
    }
}
