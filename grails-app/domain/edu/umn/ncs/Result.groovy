package edu.umn.ncs

class Result implements Serializable {

    String name
    String abbreviation
    InstrumentFormat format

    boolean ineligible = false
    boolean resend = false
    boolean disqualify = false
    boolean refused = false
    boolean valid = false
    boolean photoCopy = false
    boolean requiresPrimaryContact = false
    boolean phoneCall = false
    boolean callSheet = false
	
    static constraints = {
        name(maxSize:50)
        abbreviation(maxSize:5)
        format(nullable:true)
        ineligible()
        resend()
        disqualify()
        refused()
        valid()
        photoCopy()
        requiresPrimaryContact()
        phoneCall()
        callSheet()
    }
}
