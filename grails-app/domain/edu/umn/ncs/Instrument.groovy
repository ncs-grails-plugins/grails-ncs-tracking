package edu.umn.ncs

class Instrument implements Serializable {

	static auditable = true

    String name
    String nickName
    Integer daysTillReminder

    Instrument reminderInstrument
    Instrument previousInstrument
    Instrument masterInstrument

    Study study
    boolean reportThisEvent = true
    boolean requiresPrimaryContact = false

    String toString() {
        name
    }

    static constraints = {
        name(maxSize:64)
        nickName(maxSize:24)
        daysTillReminder(nullable:true)
        reminderInstrument(nullable:true)
        previousInstrument(nullable:true)
        masterInstrument(nullable:true)
        study(nullable:true)
        reportThisEvent()
        requiresPrimaryContact()
    }
}
