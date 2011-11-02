package edu.umn.ncs

/** This represents an instrument.  Example
of instruments are surveys, letters, forms, 
postcards, labels, vials, etc... */
class Instrument implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

	/** This is the full name for this instrumnet. */
    String name
	/** This is the short version of the name.  This
	is used for branching logic withing selection 
	criterias. */
    String nickName
	/** You can customize your selection criterias
	by setting using this attribute to choose when
	an instrument gets a reminder rather than hard
	coding it into selection criterias. */
    Integer daysTillReminder

	/** If there is a separate reminder instrument
	for this instrument, you can create the association
	here.  This can also be used to customize your
	selection criteria by using this attribute and
	keep any hard-coding of codes out of the query. */
    Instrument reminderInstrument
	/** If there is a previous instrument in the
	subject's sequence of instrument requirements
	for this instrument, you can create the association
	here.  This can also be used to customize your
	selection criteria by using this attribute and
	keep any hard-coding of codes out of the query. */
    Instrument previousInstrument
	/** If this is a sub-instrument of a kind of
	master instrument, you can set this here to 
	help you organize instrument heirarchy here.
	This can also be used to customize your
	selection criteria by using this attribute and
	keep any hard-coding of codes out of the query. */
    Instrument masterInstrument

	/** Associate this instrumnet with the study
	it belongs to. */
    Study study
	/** This flag determines whether generation of
	this instrument shows up in nightly batch reports */
    boolean reportThisEvent = true
	/** This flag tells whether or not a successful
	result deems that contact with the subject occured.
	This is often used to calculate the "last contact
	date" for a study subject. */
    boolean requiresPrimaryContact = false

	/** This is the default string converter method for
	this class.  It returns the 'name' attribute. */
    String toString() {
        name
    }

	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>name</dt>
		<dd>maximum length of 64 characters</dd>
		<dt>nickName</dt>
		<dd>maximum length of 24 characters</dd>
		<dt>daysTillReminder</dt>
		<dd>optional (nullable)</dd>
		<dt>reminderInstrument</dt>
		<dd>optional (nullable)</dd>
		<dt>previousInstrument</dt>
		<dd>optional (nullable)</dd>
		<dt>masterInstrument</dt>
		<dd>optional (nullable)</dd>
		<dt>study</dt>
		<dd>optional (nullable)</dd>
	</dl>
	*/
    static constraints = {
        name(maxSize:64)
        nickName(maxSize:24)
        daysTillReminder(nullable:true)
        reminderInstrument(nullable:true)
        previousInstrument(nullable:true)
        masterInstrument(nullable:true)
        study(nullable:true)
        reportThisEvent()
        requiresPrimaryContact()
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}
