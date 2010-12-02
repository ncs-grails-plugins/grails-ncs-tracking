package edu.umn.ncs

class BatchInstrument implements Serializable {

	Instrument instrument
	BigDecimal itemVersion = 1.0
	boolean isPrimary = true
	IsInitial isInitial
	boolean isResend = false

	static belongsTo = [batch : Batch]
	
    static constraints = {
    }
}
