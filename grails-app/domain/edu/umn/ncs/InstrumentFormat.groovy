package edu.umn.ncs

class InstrumentFormat implements Serializable {

    String name
    String groupName
	
    String toString() {
        name
    }
	
    static constraints = {
        name(maxSize:20)
        groupName(maxSize:16)
    }
}
