# Puzzler 2

You are given an array of N items, and a non-negative integer K smaller than N.  
Your job is to rotate the array (in-place) by K items.  So, if the input array 
contains the characters abcdefgh (so N = 8), and K = 3, then at the end of the 
routine the array will contain defghabc.  

This is clearly trivial to do in Θ(N) time using Θ(N) additional space: 
allocate a second buffer of size K; 
copy the first K elements into the buffer; 
shift the remaining N-K items over in the input array; 
and copy the K items back from the buffer to the end of the array.  

The challenge is to do it in Θ(N) time using only Θ(1) additional space.  
Have a go!  

Extra credit for the smallest and most elegant solutions.  
This is an exercise in algorithm design rather than coding, so pseudocode is fine.

