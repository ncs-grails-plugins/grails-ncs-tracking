package edu.umn.ncs

class DataSetType implements Serializable {

    String name
    String code

    String toString() {
        name
    }

    static constraints = {
        name()
        code(maxSize:16)
    }
}
