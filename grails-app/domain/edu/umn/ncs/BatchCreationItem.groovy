package edu.umn.ncs

/** This class represents an additional item
that needs to be generated with a particular
BatchCreationConfig instance, and any parameters
that are needed to tie it to other instruments in
the bundle. */
class BatchCreationItem implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

	/** This is the ancillary instrument to generate */
    Instrument instrument
	/** This is the format of the ancillary instrument */
    InstrumentFormat format
	/** This is the direction of the ancillary instrument */
    BatchDirection direction

	/** this defines whether this instrument is to be a
	child, sister, or attachment of another instrument
	in the bundle */
    BatchCreationItemRelation relation
	/** this defines what instrument this instrument is to be a
	child, sister, or attachment of another instrument
	in the bundle */
    Instrument parentInstrument

	/** this is the default String converter for this class.
	This simply returns the 'instrument' attribute */
    String toString() { instrument }

    /** This returns the instrument
	that this instrument may be an attachment of */
    Instrument getAttachmentOf() {
        if (relation.id == 1) {
            return parentInstrument
        } else {
            return null
        }
    }

	/** This returns the instrument that this
	instrument may be a child of */
    Instrument getChildOf() {
        if (relation.id == 2) {
            return parentInstrument
        } else {
            return null
        }
    }

	/** This returns the instrument that this
	insturment may be a sister of */
    Instrument getSisterOf() {
        if (relation.id == 3) {
            return parentInstrument
        } else {
            return null
        }
    }

	/** this is the list of transients for this domain class,
	see the get* functions for details */
    static transients = ['attachmentOf', 'childOf', 'sisterOf']

	/** This static belongsTo map associates this
	class with it's parent class, the BatchCreationConfig via
	the batchCreationConfig property */
    static belongsTo = [batchCreationConfig : BatchCreationConfig]

	/** This mapping contains all of the collections
	that are tied to this class via foreign key constriants.
	There are no non-default constrains for this class. */
    static constraints = {
        instrument()
        format()
        direction()
        relation()
        parentInstrument()
    }

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'instrument'
	}
}
