# alphabet-cipher

Lewis Carroll published a cipher known as
[The Alphabet Cipher](http://en.wikipedia.org/wiki/The_Alphabet_Cipher)

* The substitution chart is fixed so we can have a 26x26 matrix for the lookup.
* The second step is to create a sort of "padding" function which can append the keyword to itself until it becomes as long as the message. 

### Encoding

* Then we `zip` the padded keyword and message, and lookup the chart for these values using letters from keyword and message as column and rows.
* Lookup function also needs to be designed by us.

### Decoding

The opposite of encoding.

