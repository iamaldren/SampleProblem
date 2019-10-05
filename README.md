# SampleProblem

This is just a sample problem encountered.

Given int[] A with N size. Remove 2 random index inside the Array, and then compute the sum of the remaining values, when the sum is divisible by 3 return true other wise return false.

N is maximum of 20000
A[N] can have a maximum value up to 50000

## First Solution

Get the first and second index, then remove the indeces from the list, and the compute.

This is working, but not on optimal performance.

## Second Solution (@geocine helped gave the idea)

Instead of removing the indeces, why not just skip them?

Performance improve.
