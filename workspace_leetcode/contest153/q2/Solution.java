/*
Day of the week
Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.


Example 1:

Input: day = 31, month = 8, year = 2019
Output: "Saturday"
Example 2:

Input: day = 18, month = 7, year = 1999
Output: "Sunday"
Example 3:

Input: day = 15, month = 8, year = 1993
Output: "Sunday"


Constraints:
The given dates are valid dates between the years 1971 and 2100.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;

class Solution {
  public static Map<Integer, String> WEEK_DAYS = new HashMap<Integer, String>();
  static {
    WEEK_DAYS.put(Calendar.SUNDAY, "Sunday");
    WEEK_DAYS.put(Calendar.MONDAY, "Monday");
    WEEK_DAYS.put(Calendar.TUESDAY, "Tuesday");
    WEEK_DAYS.put(Calendar.WEDNESDAY, "Wednesday");
    WEEK_DAYS.put(Calendar.THURSDAY, "Thursday");
    WEEK_DAYS.put(Calendar.FRIDAY, "Friday");
    WEEK_DAYS.put(Calendar.SATURDAY, "Saturday");
  }

  public String dayOfTheWeek(int day, int month, int year) {
    Calendar c = Calendar.getInstance();
    c.set(year, month - 1, day);
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    String dayOfWeekStr = WEEK_DAYS.get(dayOfWeek);

    return dayOfWeekStr;
  }

  public static void test(int day, int month, int year, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.dayOfTheWeek(day, month, year);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test(31, 8, 2019, "Saturday");
    test(18, 7, 1999, "Sunday");
    test(15, 8, 1993, "Sunday");
  }
}
