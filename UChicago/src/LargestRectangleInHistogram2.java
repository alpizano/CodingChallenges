import java.util.ArrayList;
import java.util.List;

public class LargestRectangleInHistogram2 {
    int span;
    int minCol;
    List<Integer> maxAreaList;

    public int largestRectangleArea(int[] heights) {
        maxAreaList = new ArrayList<>();


        for(int i=0; i<heights.length; i++) {
            minCol = heights[i];
            span = 1;
            maxAreaList.add(span * minCol);


            for(int j=i+1; j<heights.length; j++) {
                span++;
                if(heights[j] < minCol) {
                    minCol = heights[j];
                }
                if(maxAreaList.get(maxAreaList.size()-1) < span * minCol){
                    maxAreaList.add(span * minCol);
                }
            }
        }

        System.out.println(maxAreaList);

        return maxAreaList.stream().max( (x,y) -> Integer.compare(x,y)).get();
    }

    public static void main(String[] args) {
            LargestRectangleInHistogram2 test = new LargestRectangleInHistogram2();
            test.largestRectangleArea(new int[]{2,1,5,6,2,3});

    }
}
