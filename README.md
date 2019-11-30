# Hackathon-Applitools

Overview:
---------
This project contains the comparison of traditional and Visual AI automation

Architecture:
----------------
The scripts are implemented in Selenium Cucumber BDD construct.

Packages:
-----------

1. features - Contains two feature files, Traditional.feature & VisualAI.feature
2. Pageobjects - pageobjects of demo app
3. Stepdefinitions - implementation of scenario defined in feature file
4. TestRunner -scenario execution using TestNG
5. Utils - Common functions

# API KEY Environmental Variable
Create a Environemental varaible "API_KEY" and place the api key as value

# Command-line Instructions

Prerequisites:
-------------------------
Install the latest version of Java and Maven.

Set the environment variable for Maven & Java_Home

```````````````````````````````````````
git clone <repo link>
````````````````````````````````````````
Navigate to project directory

Compile and run
```````````````````````````````````
mvn clean
mvn install
mvn -Dtest=TestRunner test
`````````````````````````````````````
Note: it will execute the all the scenario in feature file

# Eclipse Instructions

Prerequisites:
-------------------

Install Eclipse, the Maven plugin, and optionally the GitHub plugin.

```````````````````````````````````````
git clone <repo link>
````````````````````````````````````````
import project to Eclipse

Right-click on Test Runner under applitools.testrunner package

Run As > TestNG test
