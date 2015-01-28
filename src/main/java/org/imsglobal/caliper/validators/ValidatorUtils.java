package org.imsglobal.caliper.validators;

public class ValidatorUtils {

    /**
     * Validate object type equality against a provided class.  Determines if the specified
     * Object is assignment-compatible with the object represented by this Class. This method
     * is the dynamic equivalent of the Java language instanceof operator. The method returns
     * true if the specified Object argument is non-null and can be cast to the reference type
     * represented by this Class object without raising a ClassCastException. It returns false
     * otherwise.
     * @param object
     * @param type
     * @return boolean true/false
     */
    public static boolean isOfType(Object object, Class<?> type) {
        return type.isInstance(object);
    }

    /**
     * Validate startedAtTime
     * @param startedAtTime
     * @return boolean true/false
     */
    public static boolean checkStartedAtTime(long startedAtTime) {
        //TODO refactor if times are changed to ISO-8601 format.
        return startedAtTime > 0;
    }

    /**
     * Validate endedAtTime
     * @param endedAtTime
     * @return boolean true/false
     */
    public static boolean checkEndedAtTime(long endedAtTime) {
        //TODO refactor if times are changed to ISO-8601 format.
        return endedAtTime > 0;
    }

    /**
     * Event endedAtTime is an optional setting.  If both a startedAtTime and endedAtTime are specified
     * check that startedAtTime precedes endedAtTime.  If not return false.
     * @param startedAtTime
     * @param endedAtTime
     * @return boolean true/false.
     */
    public static boolean checkStartEndTimes(long startedAtTime, long endedAtTime) {
        if (checkStartedAtTime(startedAtTime) && checkEndedAtTime(endedAtTime)) {
            return endedAtTime > startedAtTime;
        } else {
            return true;
        }
    }

    /**
     * Validate duration.
     * @param duration
     * @return boolean true/false
     */
    public static boolean checkDuration(String duration) {
        if (duration != null && !(duration.isEmpty())) {
            return true; //TODO add ISO-8601 validation routine to this stubbed out method
        } else {
            return true;
        }
    }
}