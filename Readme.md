# Devil Logs
============

devillogs.logging; Delivering minimalist and intuitive logging functionality with no dependencies outside the Java Standard Library.

## Authors
* [Koutras, Christopher P.](https://github.com/cpkoutras)
* [Webb, Shaun](https://github.com/shaunwebb20)
* [Yerapothina, Navya Bhargavi](https://github.com/NavyaBhargaviYerapothina)


## Get Started

### Logging Package

#### Classes
- Level - provides some means of description and comparison when logging.
    - Levels: MAX, ERROR, WARN, INFO
- LogRecord - define how some logging information must be passed to the Logger.Log method.
- LogRecordBuilder (nested in LogRecord) - provides an ergonomic way to create a log record.
- Handler - filters and directs LogRecords.
- StreamHandler - logs the messages to given outputstream, can be extended to log to any stream
- ConsoleHandler - logs messages to console.
- Filehandler - logs messages to given file.
- Formatter - Formats the LogRecords before logging.
- SimpleFormatter - Default Format for all the LogRecords before logging - provides brief summary of log record.
- XMLFormatter - Formats the LogRecords in XML before logging, handler should be set for XMLFormatter.
- EncryptedHandler - Encrypts the log messages on all handlers before logging, handlers should be decorated with this.
- BaseLogger - abstract class that defines basic functionality and template methods for derived loggers.
- Logger - singleton class that extends BaseLogger and implements hooks to facilitate logging.

#### Quick Examples

```java
// Use the builder with fluent syntax
var lrb = LogRecord.builder()
    .withLevel(Level.MAX)
    .withMessage("cktest message")
    .withSource("cktest source");
// invoke .build to create a LogRecord with Guarenteed Validity
var record = lrb.build();

// Get the singleton instance of Logger;
var logger = Logger.getInstance();

// Construct the simple Console Handler (default log level LOW - logs messages LOW)
var console = new ConsoleHandler();
//log level can be set on the handler using setLevel method - logs messages of given level
console.setLevel(Level.MAX); - now console handler logs messages of Max level
EncryptedHandler enc = new EncryptedHandler(console); //Optional - used to encrypt log messages, can be added on all handlers
// add the decorated handler
logger.addHandler(enc);

// Construct the  file Handler (default log level MAX - logs messages MAX and below)
var file = new FileHandler("logfile.log");
//By default all handlers log in Simple format, to log in XML format setFormatter for the handler
file.setFormatter(new XMLFormatter());
// add the handler
logger.addHandler(file);

//atleast one handler should be added to logger
// start logging. 
logger.log(record); //logs the message based on level and handlers added

// logger class stores 100 most recent logged messages
var lastHundred = logger.getRetainedRecords();
for(var retainedRecord: lastHundred) {
    System.out.print(retainedRecord.toString());
}
```

### Auditing Package

#### Interfaces
- Auditor - party responsible for tracking changes on subject
- Command - defines the interface for Command pattern objects
- Subject - defines the interface for the Subject in the Observer pattern

#### Classes
- AuditSubject - object on which changes are tracked (concrete subject of Observer pattern)
- AuditLogger - implements the Auditor inteface to act as a concrete logging observer for classes inheriting from AuditSubject
	- Memento - nested static class within AuditLogger used to save off state of the subject of the AuditLogger
- PerformanceMonitor - wraps a command pattern object with a stopwatch to monitor the performance of the command execution and logs the duration


## Design Patterns

- Template 
    - BaseLogger.java + Logger.java
- Singleton 
    - Logger.java 
- Builder (SimpleBuilder)
    - LogRecordBuilder nested in LogRecord.java
- Chain of Responsibility (Handler)
    - Handler.java
	- StreamHandler.java
	- ConsoleHandler.java
	- FileHandler.java	
- Strategy (Formatter)
	- Formatter.java
	- SimpleFormatter.java
	- XMLFormatter.java
- Decorator
	- EncryptedHandler.java
- Observer (Auditor and AuditLogger)
    - Auditor.java
    - AuditSubject.java
- Command (Command and PerformanceMonitor)
	- Command.java
	- PerformanceMonitor.java
- Memento
	- AuditLogger.java

# Potential Design Patterns
- Factory
- Mediator
- Facade

## Reporting security issues and bugs

Issues and bugs can be submitted from the [GitHub Issues Page](https://github.com/CCSU-DesignPatterns/publicfinalprojectf22-devil-logs/issues)
