package edu.umn.ncs

/** This class stores the types of results
that can be assigned to a TrackedItem */
class Result implements Serializable {

	/** This is the name of the result */
    String name
	/** This is the 'code name', or short abbreviation
	for this result.  It is often used for short-hand notations
	and should be unique across all results */
    String abbreviation
	/** This is the format restriction applied to this result, if applicable */
    InstrumentFormat format

	/** This flag is used to turn off results by making them invalid */
    Boolean valid = false

	/** This flag marks whether or not this result makes the individual
	ineligible for the study */
    Boolean ineligible = false
	/** This flag marks whether or not this result means that the
	instrument needs to be resent */
    Boolean resend = false
	/** This flag marks whether or not that this result disqualifies
	  the subject for something */
    Boolean disqualify = false
	/** This flag marks whether or not this result represents a refusal
	on the subject's behalf */
    Boolean refused = false
	/** This flag marks whether or not a photo copy of the instrument
	needs to be made for our records */
    Boolean photoCopy = false
	/** This flag marks whether or not this result means that a 
	successful contact with the primary party was made */
    Boolean requiresPrimaryContact = false
	/** This flag marks whether or not this result can be assigned to
	phone call instruments */
    Boolean phoneCall = false
	/** This flag marks whether or not this result will show up
	as a "Finish Up" result in the call system */
    Boolean callSheet = false

	/** This is the default {@link String} converter for
	this class.
	@return		the name attribute
	@see		#name name
	*/
	String toString() { name }
	
	/** This static defines any non-standard constraints
	placed on attributes with this class.
	<dl>
		<dt>name</dt>
		<dd>maximum length of 50 characters</dd>
		<dt>abbreviation</dt>
		<dd>maximum length of 15 characters<dd>
		<dt>format</dt>
		<dd>optional (nullable)<dd>
	</dl> */
    static constraints = {
        name(maxSize:50)
        abbreviation(unique:true, maxSize:15)
        format(nullable:true)
        ineligible()
        resend()
        disqualify()
        refused()
        valid()
        photoCopy()
        requiresPrimaryContact()
        phoneCall()
        callSheet()
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'instrument' then 'itemVersion' attribute. */
	static mapping = {
		sort 'name'
	}
}
