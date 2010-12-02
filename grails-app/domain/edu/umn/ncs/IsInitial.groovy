package edu.umn.ncs

class IsInitial implements Serializable {
    String name

    String toString() {
        name
    }

    Boolean toBoolean() {
        if (name == 'initial') {
            return true
        } else {
            return false
        }
    }

    static constraints = {
        name(maxSize: 8)
    }
}
