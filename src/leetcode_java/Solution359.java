package leetcode_java;

import java.util.HashMap;
import java.util.Map;

public class Solution359 {

    private Map<String, Integer> loggerMap;

    /** Initialize your data structure here. */
    public Solution359() {
        loggerMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(loggerMap.containsKey(message)){
            int beforeTime = loggerMap.get(message);
            if(beforeTime+10<=timestamp){
                loggerMap.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }else{
            loggerMap.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Solution359 obj = new Solution359();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */