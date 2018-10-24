# Assignment_1
An attempt at timsort

TimSort runSize 25,000:
arrsize 15,000 - 73 millisec
arrsize 30,000 - 188 millisec
arrsize 50,000 - 195 millisec
arrsize 100,000 - 364 millisec

TimSort runSize 75,000:
arrsize 15,000 - 72 millisec
arrsize 30,000 - 180 millisec
arrsize 50,000 - 90 millisec
arrsize 100,000 - 185 millisec

MergeSort arrSize 50,000:
28 millisec

MergeSort arrSize 100,000:
11 millisec

When I began to write the code I had to decide which sorting method would be best suited for sorting runs. Due to their nature runs are already relatively sorted and also short in comparison to the entire array so I decided that out of all the different sorting algorithms that Insertion sort would work best for me.

After testing the sorting algorithms I found that MergeSort tended to perform better. So I kept testing, changing the run size for TimSort to see what kind of affects it could have on the outcome. However the outcomes remained the same. Although TimSort uses the best aspects of different sorting algorithms to perform well for sorting real world data, the random sets of data that I tested TimSort with proved too unrealistic to show off its potential. I would say that MergeSort is still the better sort overall.