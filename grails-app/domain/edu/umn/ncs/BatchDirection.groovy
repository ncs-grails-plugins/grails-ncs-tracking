package edu.umn.ncs

class BatchDirection implements Serializable {

    String name

    String toString() {
        name
    }

    static constraints = {
        name(maxSize:16)
    }
}
