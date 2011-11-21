package edu.umn.ncs

/** This is the bread and butter of the tracking system as
this class represents an item that we want to track.  The id
of this item is the 'tracked item id'. */
class TrackedItem implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

	/** This is the dwelling unit that is tied to this item.
	This, or one of household or person are required. */
    DwellingUnit dwellingUnit
	/** This is the household that is tied to this item.
	This, or one of dwellingUnit or person are required. */
    Household household
	/** This is the person that is tied to this item.
	This, or one of household or dwellingUnit are required. */
    Person person

	/** This class has an optional result, which is tied to
	this class via a 1:1 relationship */
    ItemResult result
	/** This is the optional study year that can be assigned
	to this item */
    Integer studyYear
	/** This item can be set to expire by setting a date in this
	field */
    Date expiration
	/** If this TrackedItem is the child of another trackedItem,
	then the parent TrackedItem should be assigned here. */
    TrackedItem parentItem

	/** This is the optional StreetAddress that this item was
	mailed to */
	StreetAddress streetAddress

	/** This transient returns the id surrounded by '*' 
	characters to make it easier to insert barcodes in 
	documents */
	String getBarcode() { '*' + id.toString() + '*' }

	/** Every TrackedItem belongs to a Batch, and this belongsTo
	static map ties this to the Batch via the 'batch' attribute */
    static belongsTo = [ batch : Batch ]

	/** this list contains all the transient properties used by this
	class.  See the get* functions for details */
	static transients = [ 'barcode' ]

	/** This hasMany map ties the following collections to this
	class as foreign key constraints.
	<dl>
		<dt>comments</dt>
		<dd>TrackedItemComment</dd>
		<dt>incentives</dt>
		<dd>Incentive</dd>
	</dl> */
    static hasMany = [ comments : TrackedItemComment, incentives: Incentive ]

	/** This is a custom validator that requires that at least one of
		person, household or dwellingUnit be non-null */
	static requirePersonUnitOrHouseholdValidator = { val, obj ->
		return ( obj.properties['person']
                    || obj.properties['household']
                    || obj.properties['dwellingUnit'] )
	}

	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>studyYear</dt>
		<dd>optional (nullable)i, minimum value of 0</dd>
		<dt>expiration</dt>
		<dd>optional (nullable)</dd>
		<dt>parentItem</dt>
		<dd>optional (nullable)</dd>
		<dt>streetAddress</dt>
		<dd>optional (nullable)</dd>
		<dt>result</dt>
		<dd>optional (nullable), but unique</dd>
		<dt>dwellingUnit</dt>
		<dt>person</dt>
		<dt>household</dt>
		<dd>optional (nullable)</dd>
	</dl> */
    static constraints = {
        // Possible destinations.  This will increase
        studyYear(nullable:true, min:0)
        expiration(nullable:true)
        parentItem(nullable:true)
		streetAddress(nullable:true)
        result(nullable:true, unique:true)

        dwellingUnit(nullable:true,
            validator: requirePersonUnitOrHouseholdValidator )
        person(nullable:true,
            validator: requirePersonUnitOrHouseholdValidator )
        household(nullable:true,
            validator: requirePersonUnitOrHouseholdValidator )
    }
}
