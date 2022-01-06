package Algorithm_Challenge_Solutions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Algorithm_Coding_Challenge_Three {
    public static void main(String[] args) {
        Interval[] arr = {new Interval(LocalDateTime.of(LocalDate.of(2021, 12,25), LocalTime.of(7,30)),
                LocalDateTime.of(LocalDate.of(2022,1,6),LocalTime.of(8,20)))};

       System.out.println(Arrays.toString(arr));
    }
    static class Interval{
        private LocalDateTime start;
        private LocalDateTime end;

        public Interval(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public void setStart(LocalDateTime start) {
            this.start = start;
        }

        public LocalDateTime getEnd() {
            return end;
        }

        public void setEnd(LocalDateTime end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval start date value is: " + start +
                    ", and end date value is: " + end;
        }
    }
    public static Interval[] mergeIntervals(Interval[] arr)
    {
        // Test if the given set has at least one interval
        if (arr.length <= 0)
            return null;

        // Create an empty stack of intervals
        Stack<Interval> stack=new Stack<>();

        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return (int) MINUTES.between(i1.getStart(), i2.getStart());
            }
        });

        stack.push(arr[0]);

        for (int i = 1 ; i < arr.length; i++)
        {

            Interval top = stack.peek();

            if (top.getEnd().isBefore(arr[i].getStart()))
                stack.push(arr[i]);


            else if (top.getEnd().isBefore(arr[i].getEnd()))
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }


        System.out.print("The Merged Intervals are: ");
        Interval[] result = new Interval[stack.size()];


        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }
}
