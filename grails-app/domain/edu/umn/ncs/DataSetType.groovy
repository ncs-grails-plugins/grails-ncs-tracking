package edu.umn.ncs

/** This class represents all of the date set types
that are available to the merge file creation process.
If you add one here, you should add code to the Document 
generation service as well. */
class DataSetType implements Serializable {

	/** This is the name of the dataset */
    String name
	/** This is the 'code name' of the dataset, the
	 abbreviation */
    String code

	/** this is the closure containing the groovy code
	 that adds the required fields to the dataset. It MUST take
	 a dataSet as a parameter, and return the altered dataset.
	 */
	String closure
	/** This flags whether or not the closure has been tested
	and validated */
	Boolean closureTested = false

	static def validateSqlQuery(String sqlQuery) {
		def passed = true
		if (sqlQuery) {
			if ( ! sqlQuery.contains(':batchId') ) {
				passed = 'missingBatchIdParameter'
			}
		}

		return passed
	}

	static def validateClosure(String closure) {
		def gs = new GroovyShell()
		def emptySet = [ [itemId: 0], [itemId: 1] ]
		def result = []
		def compiledClosure
		def passed = true

		if (closure) {
			// verify that it compiles as valid Groovy Code
			try {
				compiledClosure = gs.evaluate(closure)
			} catch (ex) {
				passed = "compileError"
			}

			// verify we can run it with an emptyset as a parameter
			try {
				result = compiledClosure(emptySet)
			} catch (ex) {
				passed = "noSignatureOfMethod"
			}

			// verify that our output is the same type as input
			try {
				assert result.class ==  emptySet.class
			} catch (ex) {
				passed = "invalidReturnType"
			}

			// verify that we didn't loose rows
			try {
				assert result.size() == emptySet.size()
			} catch (ex) {
				passed = "invalidReturnDataSetSize"
			}
		}

		return passed
	}

	/** this is the field containing the sql query
	 that adds the required fields to the dataset. It MUST take
	 :batchId as a parameter, and return the additional fields.
	 */
	String sqlQuery
	/** This flags whether or not the SQL query has been tested
	and validated */
	Boolean sqlQueryTested = false

	/** this is the default String converter for this class.
	 This simply returns the 'name' attribute */
    String toString() {
        name
    }

	/** This contains all the contstraints for this domain class.
	 Non-default constraints for this class are as follows:
	<dl>
		<dt>code<dt>
		<dd>maximum number of characters is 16<dd>
		<dt>closure</dt>
		<dd>optional (nullable), maximum length is 8000 characters.</dd>
		<dt>sqlQuery</dt>
		<dd>optional (nullable), maximum length is 8000 characters.</dd>
	</dl>
	*/
    static constraints = {
        name()
        code(maxSize:16)
		closure(nullable:true, maxSize: 8000, validator: validateClosure)
		sqlQuery(nullable:true, maxSize: 8000, validator: validateSqlQuery)
    }

	/** this static mapping sets the default sort order for this
	 domain class to be sorted by the 'name' attribute. */
	static mapping = {
		sort 'name'
	}
}
