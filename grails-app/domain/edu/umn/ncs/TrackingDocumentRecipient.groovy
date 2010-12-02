package edu.umn.ncs

class TrackingDocumentRecipient implements Serializable {
    Person person
    StreetAddress address

    String toString(){
        person.fullName
    }

    static constraints = {
    }
}
