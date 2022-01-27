# CS 764 Hw2 Part 1 Hasher

## Basic function
Perform Martyas-Meyer-Oseas hash function on given input as per specifications in homework

## Compilation/Execution

To run with gradle: `./gradlew run --args="{...arguments...}"`

To build and run self-executable jar: `./gradlew jar` and `java -jar build/libs/Hasher-1.0-SNAPSHOT.jar ...arguments...`

## Arguments

Exactly three positional must be provided:  
`./executable ArgumentFormat H_0 InputString`
1. *ArgumentFormat*: ["hex", "ascii"], indicates whether *H_0* and *inputString* should be interpreted as hexadecimal or ascii characters
2. *H_0*: initial hash. Must be one byte long, whether as a single ascii character or two hex digits
3. *InputString*: input to be hashed. no length requirement.
