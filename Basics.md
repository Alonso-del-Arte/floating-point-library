# The Basics of Floating Point Numbers

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
the sign bit column because it's all 1s.

| JVM type | Term      | Total bits | Exponent bits | Mantissa bits |
|----------|-----------|-----------:|--------------:|--------------:|
| None     | Quarter   |          8 |             4 |             3 |
| None     | Half      |         16 |             5 |            10 |
| `float`  | Single    |         32 |             8 |            23 |
| `double` | Double    |         64 |            11 |            52 |
| None     | Quadruple |        128 |            15 |           112 |
| None     | Octuple   |        256 |            19 |           236 |

On Wikipedia, I saw the formula $4 \log_2 k - 13$, but I have not been able to 
verify if that comes from some official source.

FINISH WRITING
