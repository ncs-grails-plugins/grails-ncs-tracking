package edu.umn.ncs

class TrackedItem implements Serializable {

	static auditable = true

    DwellingUnit dwellingUnit
    Household household
    Person person

    // Belongs To...
    ItemResult result
    Integer studyYear
    Date expiration
    TrackedItem parentItem

	// Street Address mailed to
	StreetAddress streetAddress

    static belongsTo = [batch : Batch]

    static hasMany = [ comments : TrackedItemComment, incentives: Incentive ]

    static constraints = {
        // Possible destinations.  This will increase
        studyYear(nullable:true, min:0)
        expiration(nullable:true)
        parentItem(nullable:true)
		streetAddress(nullable:true)
        result(nullable:true, unique:true)

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
    }
}
