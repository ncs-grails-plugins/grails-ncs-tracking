package edu.umn.ncs

/** This class ties a batch to an instrument type, and
contains any extra attributes of that relationship that
are needed to properly represent it. */
class BatchInstrument implements Serializable {

	/** This is the instrument that is being tied
	to the batch */
	Instrument instrument
	/** This is the version of the instrument
	tied to the batch */
	BigDecimal itemVersion = 1.0
	/** This flags whether or not this
	is the primary instrument for this
	batch, as ancillary instruments are considered
	attachments to the batch such as cover letters */
	boolean isPrimary = true
	/** This flags whether or not this instrumnet
	is an initial version, or a reminder version. */
	IsInitial isInitial
	/** This flags whether or not this instrument
	is the original instrument, or a resend of
	an instrument.  Resends are usually requested by 
	the study subject, and are generated because
	a re-print will not suffice. */
	boolean isResend = false

	/** This is the default string converter for 
	this class.  It returns "${batch}:${instrument}" */
	String toString() { "${batch}:${instrument}" }

	/** This static belongsTo map associates this
	class with it's parent class, the Batch via
	the batch property */
	static belongsTo = [batch : Batch]
	
	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'isPrimary'
		instrument unique:'batch'
	}
}
