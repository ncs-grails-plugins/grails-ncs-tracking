package edu.umn.ncs

class BatchCreationQueueSource implements Serializable {
    String name

    String toString(){
        name
    }

    static constraints = {
        name(maxSize:16)
    }

}

