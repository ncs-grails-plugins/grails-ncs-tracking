package edu.umn.ncs

class BatchCreationConfig implements Serializable {

	static auditable = true

    Instrument instrument
    InstrumentFormat format
    BatchDirection direction
    IsInitial isInitial
    boolean isResend = false
    String name

    String selectionQuery
    String postGenerationQuery
    int maxPieces = 0

    boolean autoSetMailDate = false
    int mailDateDaysShift = 0
    boolean manualSelection = false
    boolean automaticSelection = true
    boolean optionalSelection = false
	
    String defaultReason
    String defaultInstructions
    String defaultComments
	
    boolean active = false
	
    boolean useStudyYear = false
    boolean requireCurrentStudyYear = false
    boolean useParentItem = false
    boolean useExpiration = false
    // Not applicable
    boolean putInOnlineCallSystem = false
    boolean allowMultiplePersonPerBatch = false
	
    boolean oneBatchEventPerYear = false
    boolean oneBatchEventParentItem = false
    boolean oneBatchEventPerson = false
	
    Instrument parentInstrument
    BatchDirection parentDirection
    InstrumentFormat parentFormat
    IsInitial parentInitial
	
    int batchReportsToPrint = 1
	
    boolean generateTrackingDocument = true

    static hasMany = [
        subItems : BatchCreationItem,
        documents : BatchCreationDocument,
        archivedQueries : BatchCreationQueryArchive,
        batches: Batch,
        recipients: TrackingDocumentRecipient]

    static constraints = {
        name(maxSize:128)
        selectionQuery(nullable: true, maxSize:8000)
        postGenerationQuery(nullable: true, maxSize:8000)
        defaultReason(nullable: true, maxSize:255)
        defaultInstructions(nullable: true, maxSize:255)
        defaultComments(nullable: true, maxSize:255)
        parentInstrument(nullable: true)
    	parentDirection(nullable: true)
    	parentFormat(nullable: true)
        parentInitial(nullable: true, range:0..1)
    }

}
