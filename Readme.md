# Devil Logs
============

devillogs.logging; Delivering minimalist and intuitive logging functionality with no dependencies outside the Java Standard Library.

## Authors
* [Koutras, Christopher P.](https://github.com/cpkoutras)
* [Webb, Shaun](https://github.com/shaunwebb20)
* [Yerapothina, Navya Bhargavi](https://github.com/NavyaBhargaviYerapothina)


## Get Started

Classes: 

- Level - provides some means of description and comparison when logging.
    - Levels: MAX, HIGH, MID, LOW
- LogRecord - define how some logging information must be passed to the Logger.Log method.
- LogRecordBuilder - provides an ergonomic way to create a log record.
- Logger - singleton class to facilitate logging.
- Handler - filters and directs LogRecords
- Auditing Package
    - Auditor - party responsible for tracking changes on subject
    - Audit Subject - object on which changes are tracked

## Reporting security issues and bugs

Issues and bugs can be submitted from the [GitHub Issues Page](https://github.com/CCSU-DesignPatterns/publicfinalprojectf22-devil-logs/issues)
