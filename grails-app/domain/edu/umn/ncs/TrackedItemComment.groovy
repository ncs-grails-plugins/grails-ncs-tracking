package edu.umn.ncs

/** This class extends the Comment class to allow multiple
comments to be assigned to a TrackedItem instance */
class TrackedItemComment extends Comment implements Serializable {
	/** allows for a comment to have a subject, and sets the default
	subject to be 'general' */
    String subject = 'general'

	/** this overrides the default String converter for
		this class. */
	String toString() { subject + ': ' + text } 

	/** this belongsTo map binds this comment to a
	TrackedItem via the 'item' attribute */
    static belongsTo = [ item : TrackedItem ]
}
