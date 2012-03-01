package edu.umn.ncs

/** This class represents the configuration
settings required to generate batches of item "bundles".
This lets you configure what instruments need to be
 generated when this configuration is used to generate
 a "document bundle".  It lets you assign different
 instruments as children of other instruments. */
class BatchCreationConfig implements Serializable {

	/** This flags this domain instance to audit all updates
	and changes using the auditable plugin. */
	static auditable = true

	/** This is the primary instrument that will be generated
	by this configuration. */
	Instrument instrument
	/** This is the format of the instrument generated by
	this configuration */
	InstrumentFormat format
	/** This is the direction of the instrument generated
	by this configuration */
	BatchDirection direction
	/** This flag marks whether this is the initial 
	instrument type generated by this configuration. */
	IsInitial isInitial
	/** This flag marks whether or not this instrument
	is a resend of this item */
	boolean isResend = false

	/** This is the short name for this configuration
	that is used by the user to select which mailing
	they want to generate */
	String name

	/** This is the default string converter method for
	this class.  It returns the 'name' attribute. */
	String toString() { name }

	/** This is the longer, plain english description 
	of what the config, a.k.a.&nbsp;"Document Bundle" */
	String description

	/** This is the assembly instructions available
	to the person generating the batch.  It can include 
	additional things to put in the batch or the like */
	String extraInstructions

	/** This is the SQL selection query used to choose
	what people, households or dwelling units will get
	the instrument(s) generated by this configuration. */
	String selectionQuery
	/** This flags whether or not the selectionQuery has
	been tested */
	Boolean selectionQueryTested = false
	/** This is optional the query that runs after the the batch
	has been generated to update any datasets that may need 
	updating */
	String postGenerationQuery
	/** This flags whether or not the postGenerationQuery
	has been tested */
	Boolean postGenerationQueryTested = false

	/** useDwellingUnit flags whether or not this mailing
	expects the 'dwelling_unit' column in the seleciton
	criteria, or manual generation requires the use of
	dwelling unit ids */
	Boolean useDwellingUnit = false
	/** useHousehold flags whether or not this mailing
	expects the 'household' column in the seleciton
	criteria, or manual generation requires the use of
	household ids */
	Boolean useHousehold = false
	/** usePerson flags whether or not this mailing
	expects the 'person' column in the seleciton
	criteria, or manual generation requires the use of
	person ids */
	Boolean usePerson = false

	/** This configures a maximum number of items to
	generate for a single run of this configuration */
	int maxPieces = 0

	/** This flags whether or not the mail date is
	automatically filled in when the batch is
	generated. */
	boolean autoSetMailDate = false
	/** If the mail date is automatically set, this
	sets the number of days forward from the generation
	date to set the mail date to */
	int mailDateDaysShift = 0
	/** This flag determines whether or not the user 
	is allowed to choose who the instrument(s) are 
	generated for. */
	boolean manualSelection = false
	/** This flag sets whether or not the 
	selectionQuery is used to choose who the items
	are generated for */
	boolean automaticSelection = true
	/** This flags whether or not items slated for
	generation can be removed from the queue before 
	the batch is generated */
	boolean optionalSelection = false
	
	/** If you assign a reason comment to this 
	instrument, often associated with a generic 
	calling form, you can save it here */
	String defaultReason
	/** If you assign instrucations to this 
	instrument, often associated with a generic 
	calling form, you can save it here */
	String defaultInstructions
	/** If you assign instructions to this instrument, often
	associated with a generic calling form, you can
	save it here */
	String defaultComments
	
	/** this flag determines if users are allowed 
	  run this configuration */
	boolean active = false
	
	/** If this instrument needs a study year
	associated with it, set this to true.
	Doing so will make the document generation
	process require a 'study_year' column in the
	selection criteria, or a study year be entered
	along with the ID for manual generation */
	boolean useStudyYear = false
	/** If the study year is required, then this
	flag determines if the study year should be
	the current study year the subject is in */
	boolean requireCurrentStudyYear = false
	/** This flag determines if the parent item
	  is required for this instrument.  If so, then
	  the document generation process will require
	  that a 'parent_item' column be present
	  in the selection criteria, or a parent item
	  be used when adding subjects via manual
	  generation */
	boolean useParentItem = false
	/** This flag determines if the instrument
	  expires, and if so the document generation
	  process will require a column named 'expiration_date'
	  that will be associated with all items in the batch */
	boolean useExpiration = false

	/** This flag determines if the instrument
	  should be automatically loaded into a work
	  queue in the online call system so that someone
	  can track phone usage. */
	boolean putInOnlineCallSystem = false

	/** This flag determines if manual generation will
	  allow the same person to be in the batch more than
	  one time. */
	boolean allowMultiplePersonPerBatch = false
	
	/** This flag determines if manual generation
	  will allow more than one instrument of this
	  type to be generated per person per year */
	boolean oneBatchEventPerYear = false
	/** This flag determins if manual generation
	  will allow more than one instrument of this
	  type to be generated per parent item.  This
	  flag also requires the use of the useParentItem
	  flag. */
	boolean oneBatchEventParentItem = false
	/** This flag determines if only one instrument
	  of this type can be generated per person. */
	boolean oneBatchEventPerson = false
	
	/** This is only used for manual generation and
	if the useParentItem flag is set; it will automatically
	look up the parentItem to be assigned to the instrument 
	based on the detail of the parent* attributes */
	Instrument parentInstrument
	/** This is only used for manual generation and
	if the useParentItem flag is set; it will automatically
	look up the parentItem to be assigned to the instrument 
	based on the detail of the parent* attributes */
	BatchDirection parentDirection
	/** This is only used for manual generation and
	if the useParentItem flag is set; it will automatically
	look up the parentItem to be assigned to the instrument 
	based on the detail of the parent* attributes */
	InstrumentFormat parentFormat
	/** This is only used for manual generation and
	if the useParentItem flag is set; it will automatically
	look up the parentItem to be assigned to the instrument 
	based on the detail of the parent* attributes */
	IsInitial parentInitial
	/** This is only used for manual generation and
	if the useParentItem flag is set; it will automatically
	look up the parentItem to be assigned to the instrument 
	based on the detail of the parent* attributes */
	Result parentResult
	
	/** If auto-batch-printing is implemented, this
	will determing the number of batch reports that
	will automatically print out */
	int batchReportsToPrint = 1
	
	/** This flag sets whether or not tracking
	document(s) are generated when this configuration 
	is run */
	boolean generateTrackingDocument = true

	/** This mapping contains all of the collections
	that are tied to this class via foreign key constriants.
	<dl>
		<dt>subItems</dt>
		<dd>a colleciton of BatchCreationItem instances</dd>
		<dt>documents</dt>
		<dd>a colleciton of BatchCreationDocument instances</dd>
		<dt>archivedQueries</dt>
		<dd>a colleciton of BatchCreationQueryArchive instances</dd>
		<dt>batches</dt>
		<dd>a colleciton of Batch instances</dd>
		<dt>recipients</dt>
		<dd>a colleciton of TrackingDocumentRecipient instances</dd>
	</dl>
	*/
	static hasMany = [
		subItems : BatchCreationItem,
		documents : BatchCreationDocument,
		archivedQueries : BatchCreationQueryArchive,
		batches: Batch,
		recipients: TrackingDocumentRecipient]


	static transients = [ 'requiredColumns' ]

	def getRequiredColumns() {
		def requiredColumns = [] as Set
		def b = this
		if (b.automaticSelection) {
			if (b.usePerson)        { requiredColumns.add('person') }
			if (b.useHousehold)     { requiredColumns.add('household') }
			if (b.useDwellingUnit)  { requiredColumns.add('dwelling_unit') }
			if (b.useParentItem)    { requiredColumns.add('parent_item') }
			if (b.useExpiration)    { requiredColumns.add('expire_date') }
			if (b.useStudyYear)     { requiredColumns.add('study_year') }

			b.subItems.each { bi ->
				if (bi.optional) {
					requiredColumns.add('skip_' + bi.instrument.nickName)
				}
			}

		}
		requiredColumns
	}


	/** This contains all the contstraints for this domain class.
	Non-default constraints for this class are as follows:
	<dl>
		<dt>name</dt>
		<dd>maximum length of 128 characters</dd>
		<dt>description</dt>
		<dd>maximum length of 8000 characters</dd>
		<dt>extraInstructions</dt>
		<dd>maximum length of 8000 characters</dd>
		<dt>selectionQuery</dt>
		<dd>optional (nullable), maximum length of 8000 characters</dd>
		<dt>postGenerationQuery</dt>
		<dd>optional (nullable), maximum length of 8000 characters</dd>
		<dt>defaultReason</dt>
		<dd>optional (nullable), maximum length of 256 characters</dd>
		<dt>defaultInstructions</dt>
		<dd>optional (nullable), maximum length of 256 characters</dd>
		<dt>defaultComments</dt>
		<dd>optional (nullable), maximum length of 256 characters</dd>
		<dt>parentInstrument</dt>
		<dd>optional (nullable)</dd>
		<dt>parentDirection</dt>
		<dd>optional (nullable)</dd>
		<dt>parentFormat</dt>
		<dd>optional (nullable)</dd>
		<dt>parentInitial</dt>
		<dd>optional (nullable), using range to restrict the ID to 0, 1 or 2</dd>
		<dt>parentResult</dt>
		<dd>optional (nullable)</dd>
	</dl>
	*/
	static constraints = {
		name(maxSize:128)
		description(maxSize:8000)
		extraInstructions(nullable: true, maxSize:8000)
		selectionQuery(nullable: true, maxSize:8000)
		postGenerationQuery(nullable: true, maxSize:8000)
		defaultReason(nullable: true, maxSize:255)
		defaultInstructions(nullable: true, maxSize:255)
		defaultComments(nullable: true, maxSize:255)
		parentInstrument(nullable: true)
		parentDirection(nullable: true)
		parentFormat(nullable: true)
		parentInitial(nullable: true, range:0..2)
		parentResult(nullable: true)
	}

	/** this static mapping sets the default sort order for this
	domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}
