import java.util.ArrayDeque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<heights.length; i++) {

            if(stack.peek() >= heights[i])
                // push index on stack
                stack.push(i);

        }
            return 0;
    }
    public static void main(String[] args) {

    }
}
