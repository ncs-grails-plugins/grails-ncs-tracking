package edu.umn.ncs

/** This class is used to queue up a list of documents
to be manually generated for a particular user. */
class BatchCreationQueue implements Serializable {

	/** This is the username that the queue is 
	associated with. */
    String username

	/** This is the person to tie the item to */
    Person person
	/** This is the household to tie the item to */
    Household household
	/** This is the dwellingUnit to tie the item to */
    DwellingUnit dwellingUnit

	/** This is the parent item to tie this to if
	it was required by the configuration. */
    TrackedItem parentItem
	/** This is the study year to tie this to if
	it was required by the configuration. */
    Integer studyYear
	/** This is the expiration date to assign to this to if
	it was required by the configuration. */
    Date expireDate

	/** This is the default string converter for this class.
		It returns: "BatchCreationQueue(${username},${source})[id=${id}]"
		*/
	String toString() {
		"BatchCreationQueue(${username},${source})[id=${id}]"
	}

	/** This is the queue source for this item */
    BatchCreationQueueSource source

	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>dwellingUnit<dt>
		<dt>person<dt>
		<dt>household<dt>
		<dd>one of the three of these is required<dd>
		<dt>parentItem</dt>
		<dd>optional (nullable)</dd>
		<dt>studyYear</dt>
		<dd>optional (nullable)</dd>
		<dt>expireDate</dt>
		<dd>optional (nullable)</dd>
		<dt>source</dt>
		<dd>optional (nullable)</dd>
	</dl>
	*/
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

	static mapping = {
		sort 'person'
	}
}
