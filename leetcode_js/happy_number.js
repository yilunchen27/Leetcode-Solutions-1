/**
 * @param {number} n
 * @return {boolean}
 https://leetcode.com/problems/happy-number/
 
 Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 */
var isHappy = function(n) {
    var map = {}, num;
    while(!map[n]){
        map[n] = true;
        num = 0;
        while(n > 0){
            num += (n%10)*(n%10);
            n = Math.floor(n/10);
        }
        if(num  === 1) return true;
        n = num;
    }
    return false;
};