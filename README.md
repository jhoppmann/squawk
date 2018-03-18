The SQUAWK (Simple & Quick Widgets and Utility Kit) contains some overall useful classes, and some (like the widgets) useful when working with GWT (2.8.0 or greater). For the latter purpose, SQUAWK is a GWT module.

When using SQUAWK, you can build it via Maven and include it in your project (manually or using Maven). If this is used in conjunction with a GWT project, it comes with a Squawk.gwt.xml file that may be inherited as module in any GWT project using

<inherits name="de.jhoppmann.Squawk"/>

All code has been tested in GWT environment.