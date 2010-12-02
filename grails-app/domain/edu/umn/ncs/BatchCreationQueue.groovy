package edu.umn.ncs

class BatchCreationQueue implements Serializable {

    String username

    Person person
    Household household
    DwellingUnit dwellingUnit

    TrackedItem parentItem
    Integer studyYear
    Date expireDate

    BatchCreationQueueSource source

    static constraints = {
        username()
        dwellingUnit(nullable:true,
            validator: { val, obj -> return ( obj.properties['person']
                    || obj.properties['household']
                    || obj.properties['dwellingUnit'] ) })
        person(nullable:true,
            validator: { val, obj -> return ( obj.properties['person']
                    || obj.properties['household']
                    || obj.properties['dwellingUnit'] ) })
        household(nullable:true,
            validator: { val, obj -> return ( obj.properties['person']
                    || obj.properties['household']
                    || obj.properties['dwellingUnit'] ) })
        parentItem(nullable:true)
        studyYear(nullable:true)
        expireDate(nullable:true)
        source(nullable:true)
    }
}
