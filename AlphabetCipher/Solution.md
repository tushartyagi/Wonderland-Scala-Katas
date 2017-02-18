# alphabet-cipher

Lewis Carroll published a cipher known as
[The Alphabet Cipher](http://en.wikipedia.org/wiki/The_Alphabet_Cipher)

* The substitution chart is fixed so we can have a 26x26 matrix for the lookup.
* The second step is to create a sort of "padding" function which can append the keyword to itself until it becomes as long as the message. 
  The first approach was using recursion as hammer, which created a not so elegant function -- it was just recursive.
  The second approach was slicing and dicing the string based on its size.

### Encoding

* Then we `zip` the padded keyword and message, and lookup the chart for these values using letters from keyword and message as column and rows.
* Lookup function means that we need to find the character at which the row and column intersect. We can look at it this way: "Translate" the column (like we translate the grids or canvas element in html) back so that the `col` letter becomes the first character, then shift down by `row` and add the two. 

### Decoding

Here we start in the particular column (given by the `key` character) and move right until the `encoded` character is found. Let's call this distance. Adding distance to 'a' will give us the correct letter.

### Deciphering

This is exactly similar to decoding just that we start at a column and move down.

### Unpadding

Unpadding means finding the unique string which we padded before encoding. The solution is to find the occurance of the first letter of the string and split the string around it. This will produce a sequence of strings, now we go through the sequence looking for repetition of the first string; if this is the second element of the sequence, then the first string is complete, otherwise we concatenate all the strings starting from the first one until the one where it is repeated.


