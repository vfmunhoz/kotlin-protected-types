# Kotlin Protected Types

<p align="center">
  <p align="center">
    <img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/vfmunhoz/kotlin-protected-types/Release%20workflow">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/vfmunhoz/kotlin-protected-types">
    <img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/vfmunhoz/kotlin-protected-types">
    <img alt="GitHub stars" src="https://img.shields.io/github/stars/vfmunhoz/kotlin-protected-types">
    <img alt="GitHub" src="https://img.shields.io/github/license/vfmunhoz/kotlin-protected-types">
  </p>
</p>

Unintentionally having personal data making it's way to application's log,  may give a reasonable amount of problems for any company nowadays, and cleaning up all the log messages after the log collection is probably a heavily processing and timing consumption process.

Considering the possible scenarios to avoid personal data from being logged and sent to observability tools, it's feasible to change the data before outputting it to the log appender just by overriding the `toString()` calls from fields with personal data.

Although creating custom wrapper types for primitives and creating your `toString()` implementation solves the personal data logging issue, it's extremely annoying for any developer having to worry about casts everytime an operation has to be performed. But since the release of Kotlin 1.5 it's possible to work with the primitive wrappers without actually having to add cast operations everywhere!

## How it works

The `protected-types` library creates wrappers for all Kotlin's primitive types, but it makes use of [inline classes](https://kotlinlang.org/docs/inline-classes.html) to have the smallest impact in performance for operations with the values.

With the [inline classes](https://kotlinlang.org/docs/inline-classes.html) it's possible to work with the wrappers as if they were the real native types but with it's `toString()` methods overloaded.

The [inline classes](https://kotlinlang.org/docs/inline-classes.html) were relased on `Kotlin 1.5.0` so you won't be able to use it with older Kotlin versions. 

> *Note:* The inline classes are being heavily discussed [here](https://github.com/Kotlin/KEEP/issues/237).

## How to use

The library has been designed to have the smallest impact on your code, most of the time it should be seamless the usage of the `protected-types` on your code.

### Gradle configuration

You should just have the library in your `dependencies` block and the `mavenCentral` repository.

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.vfmunhoz:kotlin-protected-types:1.0.0")
}
```

### Numeric Types

There's a value class wrapper for every integer type available, and the library makes sure the behavior during the computations is the same as [Kotlin's numeric types](https://kotlinlang.org/docs/basic-types.html).

The integer wrappers are:

- ProtectedByte
- ProtectedShort
- ProtectedInt
- ProtectedLong
- ProtectedFloat
- ProtectedDouble

If you try to print a value of any protected numeric type the half of the value will be obfuscated with the `#` and by default characters `-` and `.` will be preserved.

```kotlin
fun main() {
    val protectedInt = -(100.toProtected())
    val protectedDouble = 10.01.toProtected()

    println(protectedInt)
    println(protectedDouble)
}
```

The snippet above will output:

```text
-1##
10.##
```

> *Note:* Although the `-` and `.` are not obfuscated for numeric types the still count as a char in the resulting string.

For each of the types you`re able to perform the same operations as their native types having the same results even if the result of the operation is greater than the type supports.

The library supports operations with native types and protected types in any order, but the result type will always be the type of the first value.

```kotlin
fun main() {
    val nativeInt = 10
    val protectedInt = 11.toProtected()
    
    val anotherNativeInt: Int = nativeInt + protectedInt
    val anotherProtectedInt: ProtectedInt = protectedInt + nativeInt
}
```

> *Note:* For any protected type it's possible to get the original value back accessing the `.value` property.

### String Type

For strings the library doesn't follow the same principle as for numeric wrappers using [inline classes](https://kotlinlang.org/docs/inline-classes.html), this decision has been made considering that up to this moment the support to have functions with the same name as the original value class in use is still in discussion for future releases.

Since we don't have an [inline class](https://kotlinlang.org/docs/inline-classes.html) implementing the wrapper it was possible to add more functionalities to customize the printed value for any protected string.

The simplest use should be the simple conversion to `ProtectedString` wrapper.

```kotlin
fun main() {
    val myString: ProtectedString = "Hello ProtectedTypes!".toProtected()

    println(myString)
}
``` 

The result of this execution should be a partially protected string printed:

```text
Hello Prot***********
```

Note that the default character to obfuscate the value is `*` and the algorithm replaces half of the original value.

It's possible to change the default character and provide a split token if you want to customize the obfuscation.

```kotlin
fun main() {
    val splitToken = " "
    val replaceToken = "#"

    val myString = ProtectedString("Hello ProtectedTypes!", splitToken, replaceToken)

    println(myString)
}
``` 

Now the printed value should be:

```text
He### Protect########
```

It's also possible to set a custom chars list to ignore during the obfuscation.

```kotlin
fun main() {
    val myString = ProtectedString(value = "Hello ProtectedTypes!", ignores = setOf('!'))

    println(myString)
}
``` 

Ignoring the `!` character inside the string the execution produces the following result.

```text
Hello Prot**********!
```

The `equals()`, `hashCode()` and `compareTo()` works delegating the logic to the actual `String` type.

#### ProtectedString concat

It's possible to concat a `ProtectedString` with either another `ProtectedString` or a `String` using the `+` operator.

```kotlin
fun main() {
    val helloString = "Hello ".toProtected()
    val myString = helloString + "ProtectedString!"

    println(myString)
}
```

> *Note:* The custom values for `splitToken`, `replaceToken` and `ignores` from the first `ProtectedString` will be propagated to the concat result.

### Json serialization support

The library supports serialization using [Jackson](https://github.com/FasterXML/jackson) version `2.12` or superior.

```groovy
implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")
```

Since [Jackson](https://github.com/FasterXML/jackson) uses reflection to parse the entities to json, and the `protected-types` don't change the value until it needs, the serialization works smoothly.

```kotlin
data class Person(val name: ProtectedString, val age: ProtectedInt)

fun main() {
    val person = Person("John Doe".toProtected(), 31.toProtected())

    println(jacksonObjectMapper().registerKotlinModule().writeValueAsString(person))
    println()
    println(person)
}
```

```text
{"name":"John Doe","age":31}

Person(name=John****, age=3#)
```