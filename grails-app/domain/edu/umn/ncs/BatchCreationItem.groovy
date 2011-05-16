package edu.umn.ncs

class BatchCreationItem implements Serializable {

	static auditable = true

    Instrument instrument
    InstrumentFormat format
    BatchDirection direction

    // A Better Way...
    BatchCreationItemRelation relation
    Instrument parentInstrument

    // backwards compatability code...
    Instrument getAttachmentOf() {
        if (relation.id == 1) {
            return parentInstrument
        } else {
            return null
        }
    }

    Instrument getChildOf() {
        if (relation.id == 2) {
            return parentInstrument
        } else {
            return null
        }
    }

    Instrument getSisterOf() {
        if (relation.id == 3) {
            return parentInstrument
        } else {
            return null
        }
    }

    static transients = ['attachmentOf', 'childOf', 'sisterOf']
    static belongsTo = [batchCreationConfig : BatchCreationConfig]

    static constraints = {
        instrument()
        format()
        direction()
        relation()
        parentInstrument()
    }
}
