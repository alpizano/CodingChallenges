import java.util.ArrayList;
import java.util.List;

public class LargestRectangleInHistogram2 {
    int span;
    int minCol;
    List<Integer> maxAreaList;

    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;

        maxAreaList = new ArrayList<>();

        for(int i=0; i<heights.length; i++) {
            minCol = heights[i];
            span = 1;
            int maxArea = span * minCol;

            for(int j=i+1; j<heights.length; j++) {
                span++;
                if(heights[j] < minCol) {
                    minCol = heights[j];
                }
                if(maxArea < span * minCol){
                    maxArea = span* minCol;
                }
            }
            maxAreaList.add(maxArea);

        }

        return maxAreaList.stream().max( (x,y) -> Integer.compare(x,y)).get();
    }

    public static void main(String[] args) {
            LargestRectangleInHistogram2 test = new LargestRectangleInHistogram2();
            test.largestRectangleArea(new int[]{2,1,5,6,2,3});

    }
}
