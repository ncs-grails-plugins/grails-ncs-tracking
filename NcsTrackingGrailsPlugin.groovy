class NcsTrackingGrailsPlugin {
    // the plugin version
    def version = "3.2.6"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [ ncsPeople : "1.0 > *", auditLogging : "0.5.4 > *" ]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/conf/",
            "grails-app/views/error.gsp",
			"lib/"
    ]

    def author = "Aaron J. Zirbes"
    def authorEmail = "ajz@umn.edu"
    def title = "NCS Tracking Domain Classes"
    def description = '''\\
Provides domain classes necessary for tracking generated and incoming items
to study participants, recruitment materials and incentives.
'''

    // URL to the plugin's documentation
    def documentation = "https://ci.ncs.umn.edu/job/ncs-tracking-plugin/javadoc/"

}
