package edu.umn.ncs

class BatchCreationItemRelation implements Serializable {
    String name

    String toString() {
        name
    }

    static constraints = {
        name(maxSize:16)
    }
}
