package edu.umn.ncs

class InstrumentRevision implements Serializable {

	// Denotes the type of revision
	String name

	String toString() { name }

    static constraints = {
		name()
    }
}
