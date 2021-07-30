# Kotlin Protected Types

Unintentionally having personal data making it's way to application's log,  may give a reasonable amount of problems for any company nowadays, and cleaning up all the log messages after the log collection is probably a heavily processing and timing consumption process.

Considering the possible scenarios to avoid personal data from being logged and sent to observability tools, it's feasible to change the data before outputting it to the log appender just by overriding the `toString()` calls from fields with personal data.

Although creating custom wrapper types for primitives and creating your `toString()` implementation solves the personal data logging issue, it's extremely annoying for any developer having to worry about casts everytime an operation has to be performed. But since the release of Kotlin 1.5 it's possible to work with the primitives without actually having to add cast operations everywhere!

## How it works

The `protected-types` library creates wrappers for all Kotlin's primitive types, but it makes use of [inline classes](https://kotlinlang.org/docs/inline-classes.html) to have the smallest impact in performance for operations with the values.

With the [inline classes](https://kotlinlang.org/docs/inline-classes.html) it's possible to work with the wrappers as if they were the real native types but with it's `toString()` methods overloaded.

The [inline classes](https://kotlinlang.org/docs/inline-classes.html) were relased on `Kotlin 1.5.0` and it has being heavily discussed [here](https://github.com/Kotlin/KEEP/issues/237). 

> *Note:* Wasn't implemented all the possibilities discussed on Kotlin's value classes design notes on Kotlin 1.5.0.

## How to use

The library has been designed to have the smallest impact 
