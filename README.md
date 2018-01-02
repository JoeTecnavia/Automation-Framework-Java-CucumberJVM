Java UI CucumberJVM Framework by Simonkay
==================================
This Framework is provided by me to help you hit the ground running with java, selenium and cucumberJVM BDD based acceptance / end2end GUI tests.  The framework itself has many powerful features which are all outlined below.  I will continue working on this throughout 2018 and I also encourage you to fork it too!

Some powerful features of this framework are:
- Parallel execution using teymers for cucumber JVM
- Browserstack integration [upcoming]
- Aliased random data with step persistence
- GUI based tests written in plain English
- Page Object Design Pattern
- Page Factory Design Pattern with LoadableComponent
- Configurable Drivers & Environments
- Selenium GRID support for local distribution / docker zalenium d
- Headless testing capabilities (chrome)
- Good use of Spring for dependency injection
- Reporting with a beautiful UI which really compliments BDD, I have done the hardwork for you with populating the data
- Logging capabilities per forked process using Log4j

The Stack!
------------
- [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) A static, simple programming language
- [Maven](https://maven.apache.org/download.cgi) Dependency manager, Build manager/executor, Amazing tool! :)
- [Firefox](https://www.mozilla.org/en-US/firefox/new/) (optional)
- [Chromedriver](http://chromedriver.storage.googleapis.com/index.html) (optional)
- [SeleniumGrid](http://www.seleniumhq.org/projects/grid/) (again optional, useful to distribute tests to the hub for node selection)

Key Tools
---------

- [Java](https://docs.oracle.com/javase/7/docs/api/) - Static language
- [Selenium WebDriver](http://www.seleniumhq.org/projects/webdriver/) - Libary for interacting with webpage(s)
- [CucumberJVM](https://cucumber.io/docs/reference/jvm) - A BDD tool for writing acceptance tests in plain English.
- [BrowserStack](https://www.browserstack.com/) - Platform as a service based cross browser/OS test execution.
- [Teymers](https://github.com/temyers/cucumber-jvm-parallel-plugin) - A library used for generating test runners for our forked process execution
- [Parallel_Tests](https://github.com/grosser/parallel_tests) - A gem for parallel threading of cucumber tests.
- [Factory Girl](https://github.com/thoughtbot/factory_girl) - A data template factory for producing test data.
- [Faker](https://github.com/DiUS/java-faker) - A random data generation library ported to java from ruby.
- [Allure](https://github.com/allure-framework/allure-cucumberjvm) - Awesome reporting functionality
- [Spring](https://spring.io/) - Super useful dependency injection
- [Jenkins](https://jenkins-ci.org/) - Used for build management etc

Installing and using
--------------------
From the command line:

1. Download and install maven -> `mvn` in command line should not return unknown command
2. Download and install the java SDK/JDK
3. Clone the project: `https://github.com/symonk/java-selenium-parallel-framework.git`
4. Start running tests using the .bat files in the project directory
5. Modify the code to meet your needs and happy testing!
6. Please contribute/fork if you find it useful!

Available Maven Tasks
--------------------

`regression_chrome` Executes cucumber tests tagged with @regression on the chrome browser.
`regression_firefox` Executes cucumber tests tagged with @regression on the firefox browser.
`smoke_chrome` Executes cucumber tests tagged with @smoke on the chrome browser.
`smoke_firefox` Executes cucumber tests tagged with @smoke on the firefox browser.
-> Add your own! :)

To specify any of the properties for the framework you can use =>
`mvn -Dbrowser=chrome` for example.


Browserstack Configuration
--------------------------

Coming soon! :)
