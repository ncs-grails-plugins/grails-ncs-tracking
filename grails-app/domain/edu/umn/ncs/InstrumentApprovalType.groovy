package edu.umn.ncs

class InstrumentApprovalType implements Serializable {

	String name

	String toString() { name }

    static constraints = {
		name()
    }
}
