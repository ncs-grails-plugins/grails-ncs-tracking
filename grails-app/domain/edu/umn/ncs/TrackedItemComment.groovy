package edu.umn.ncs

class TrackedItemComment extends Comment implements Serializable {
    // general = default comment
    String subject = 'general'
    static belongsTo = [ item : TrackedItem ]
}
