# Basics of floating point numbers

The integer primitives in Java are all fixed point numbers, the "binary point" 
happens to be to the right of the least significant bit. The leftmost bit is the 
sign bit, and each of the bits after that always correspond to the same power of 
two multiplied by 0 or 1.

With floating point numbers, the leftmost bit is still the sign bit. But some of 
the other bits are used for an exponent. The remaining bits represent a fixed 
point number which is multiplied by the power of two indicated by the exponent 
bits.

However many bits a particular floating point number format has, the leftmost 
bit is always for the sign, and there are multiple ways to apportion the other 
bits between the exponent and the mantissa.

After all these years of hardware and software using specific apportionments for 
the 32- and 64-bit formats, it is inadvisable to try to apportion the bits of 
these formats differently than what almost everyone does.

Therefore, the apportionments on the following table should be considered as 
suggestions for all formats other than 32- and 64-bit. The following table omits 
the sign bit column because it's all 1s. It was decided long ago that 32-bit 
floating point is "single" precision, and the other formats are reckoned in 
relation to it.

| JVM type | Term      | Total bits | Exponent bits | Mantissa bits |
|----------|-----------|-----------:|--------------:|--------------:|
| None     | Quarter   |          8 |             4 |             3 |
| None     | Half      |         16 |             5 |            10 |
| `float`  | Single    |         32 |             8 |            23 |
| `double` | Double    |         64 |            11 |            52 |
| None     | Quadruple |        128 |            15 |           112 |
| None     | Octuple   |        256 |            19 |           236 |

On Wikipedia, I saw the formula $4 \log_2(k) - 13$, but I have not been able to 
verify if that comes from some official source. The $k$ stands for the total 
number of bits.

The total number of bits doesn't have to be a power of two, but that certainly 
simplifies the calculation of $\log_2 k$. For example, when Java first came out, 
some physical chips like the Intel 8087 provided 80-bit floating point numbers. 
The formula suggests an 80-bit floating point number ought to have roughly 
12.287712379549447 exponent bits, which in this case we round down to 12, or we 
might decide to round up to 13.

Note that the sign bit applies to the mantissa, not the exponent. Then it would 
seem that the exponent bits can't represent negative numbers. The lowest number 
that can be represented, given $w$ bits for the exponent, would seem to be 0 
(all exponent bits 0), and the greatest would seem to be $2^w - 1$.

But this would mean that the binary point can only be moved to the left, either 
leaving the mantissa unchanged or doubling it, quadrupling it, etc., but never 
halving, quartering, etc.

So the concept of bias was introduced. The **bias** is a number, usually 
negative, that is added to the exponent. For example, if the bias is &minus;510, 
adding that to the unbiased exponent 1 gives the biased exponent &minus;509.

If $w$ is the number of exponent bits, then the bias is almost always chosen to 
be $-(2^{w - 1}) + 1$, so that an unbiased exponent of $2^{w - 1} - 1$ biases to 
0. However, both unbiased exponents 0 and 1 bias to $-(2^{w - 1}) + 2$, as 
unbiased exponent 0 has a special meaning that will be explained later in this 
document. Unbiased exponent $2^w - 1$ also has a special meaning that will also 
be explained later. The following table shows typical biases:

| Precision | Minimum biased | 0 unbiased |
|-----------|---------------:|-----------:|
| Quarter   |       &minus;6 |          7 |
| Half      |      &minus;14 |         15 |
| Single    |     &minus;126 |        127 |
| Double    |    &minus;1022 |       1023 |
| Quadruple |    PLACEHOLDER |  PLACEHOLD |
| Octuple   |    PLACEHOLDER |  PLACEHOLD |

Note that 0 unbiased is also the maximum biased exponent. Technically, the 
maximum available biased exponent is one greater than is shown in this table, 
but given the special meaning of the maximum exponent, the number is moot.

If all the exponent bits are on, but all the mantissa bits are off, the value 
represents positive or negative infinity, according to the sign bit. But if the 
exponent bits are all on and even just one of the mantissa bits is also on, the 
value represents the special quantity Not a Number (NaN). I will elaborate NaN 
more later on in this document.

When the exponent is not the lowest nor the highest, the mantissa bits are 
understood to contain an implied leading 1. Therefore, with typical biases, the 
number 1.0 is represented with the sign bit off, all exponent bits on except the 
highest one, and all the mantissa bits off.

| Precision | Bit pattern of 1.0 in hexadecimal |
|-----------|----------------------------------:|
| Quarter   |                                38 |
| Half      |                             3C 00 |
| Single    |                       3F 80 00 00 |
| Double    |           3F F0 00 00 00 00 00 00 |
| Quadruple |                       PLACEHOLDER |
| Octuple   |                       PLACEHOLDER |

So the most significant bit of the mantissa always represents one half, the next 
most significant bit represents one quarter, and so on and so forth.

If the mantissa bits always have an implied leading 1, there's no way to 
represent 0.0. A number is said to be **normal** or **normalized** if its 
mantissa bits have an implied leading 1. But if the unbiased exponent is 0, the 
number does not have an implied leading 1 and is therefore said to be 
**subnormal**. The biased exponent for unbiased exponent 0 is the same as for 
unbiased exponent 1.

Therefore 0.0 is represented with all bits off. But if the sign bit is on and 
all other bits are off, the number is actually &minus;0.0, which is 
arithmetically equal to 0.0.

Nonzero subnormal numbers vastly complicate floating point arithmetic, 
especially when one operand is subnormal and the other one is not.

## More about NaN

FINISH WRITING

## Floating point arithmetic

FINISH WRITING

### Addition and subtraction

FINISH WRITING

### Multiplication and division

FINISH WRITING

### Roots and logarithms

FINISH WRITING

### Trigonometric operations

FINISH WRITING

## Java and `strictfp`

FINISH WRITING

FINISH WRITING

FINISH WRITING

FINISH WRITING

FINISH WRITING

FINISH WRITING

FINISH WRITING

FINISH WRITING

