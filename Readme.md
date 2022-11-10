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
- Handler - filters and directs LogRecords
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

// Construct the simple Console Handler
var handler = new ConsoleHandler();
// Get the singleton instance of Logger;
var logger = Logger.getInstance();
// add at least one handler
logger.addHandler(new ConsoleHandler());

// start logging. 
logger.log(record);

// logger class stores 100 most recent logged messages
var lastHundred = logger.getRetainedRecords();
for(var retainedRecord: lastHundred) {
    System.out.print(retainedRecord.toString());
}
```

- Auditing Package
    - Auditor - party responsible for tracking changes on subject
    - Audit Subject - object on which changes are tracked

# Prospective Patterns
- Strategy/Template (Serializers)
- Factory

## Reporting security issues and bugs

Issues and bugs can be submitted from the [GitHub Issues Page](https://github.com/CCSU-DesignPatterns/publicfinalprojectf22-devil-logs/issues)
