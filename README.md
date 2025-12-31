# Floating point library

WORK IN PROGRESS: About to resume work on 16-bit floating point

A library to represent floating point numbers in precisions other than the ones 
available through Java Virtual Machine primitives. Specifically:

* **Quarter precision** &mdash; 8-bit.
* **Half precision** &mdash; 16-bit.
* **Single precision** &mdash; 32-bit, equivalent to `float`.
* **Double precision** &mdash; 64-bit, equivalent to `double`.
* **Quadruple precision** &mdash; 128-bit.
* **Octuple precision** &mdash; 256-bit.

Formats narrower than quarter precision or wider than octuple precision will not 
be provided.

These floating point formats are intended to comply with the IEEE-754 standard, 
subject to the following caveats:

* Two objects representing not a number (NaN) values will be considered equal 
according to `equals()` if they have the same bit pattern.
* Positive zero and negative zero will not be considered equal according to 
`equals()` but they will be considered equal according to 
`arithmeticallyEqual()` and `compareTo()`.

Also, signaling NaNs will be preserved to the extent that they can be kept out 
of Java floating point primitives.

I haven't decided if arithmetic operations will be performed in hardware 
whenever possible, or never performed in hardware, or simply using whatever is 
most convenient. Or maybe I did decide that long ago but never wrote it down 
before.

This project uses TestNG 6 and TestFrame 1.0.

[A document on the basics of floating point numbers](Basics.md) will explain the 
basic concepts.
