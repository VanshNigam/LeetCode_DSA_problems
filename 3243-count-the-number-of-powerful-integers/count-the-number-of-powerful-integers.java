class Solution {
    private long count(long num, int limit, String suffix) {
        long res = 0;
        String numS = String.valueOf(num);
        // if number has lesser digits than suffix, no combination will be possible
        if (numS.length() < suffix.length()) {
            return 0;
        }
        // if number of digits are same
        // if number is bigger, 1 combination will be possible
        // if number is smaller, no combination will be possible
        if (numS.length() == suffix.length()) {
            if (numS.compareTo(suffix) >= 0) {
                return 1;
            }
            return 0;
        }

        // find length of prefix
        int prefixLen = numS.length() - suffix.length();
        // find suffix in the number
        // it can be considered as valid combination later
        String numSuffix = numS.substring(prefixLen);

        // start iterating on the prefix of the number
        for (int i=0; i<prefixLen; i++) {
            int digit = numS.charAt(i) - '0';
            // number of ways to fill the digits after it will be
            // (0-limit)^(remaining number of digits after it)
            long combinations = (long) Math.pow(limit+1, prefixLen-i-1);
            // if current digit > limit (digit = 5, limit = 4)
            // only possible ways to fill rest of the digits will be
            // (0-limit)*combination
            // because if current digit starts with 5, all digits at this place
            // and next places will be bigger than limit = 4
            // For example, prefix = 58, limit=4
            // All prefix combinations will be 58,59,60.....
            // So count for current digit and exit
            if (digit > limit) {
                return res + (limit+1) * combinations;
            }
            // if current digit <= limit, count and move to next digit
            // count will be (0-digit)*combinations
            // For example, prefix = 32, limit=4
            // All prefix combinations will be 32,33,34.....
            // So count for current digit and move to next digit
            res += digit * combinations;
        }

        // if not exited early, suffix in number will also be valid
        // if it is >= suffix
        if (numSuffix.compareTo(suffix) >= 0) {
            res += 1;
        }

        return res;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        // count from 1 to finish
        // count from 1 to start-1
        // difference of both will be result from start to finish
        return count(finish, limit, s) - count(start-1, limit, s);
    }
}