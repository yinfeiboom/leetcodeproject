package Top100Liked;

public class Title11 {

    public int maxArea(int[] height) {
        int maxarea=0;
        for (int i = 0; i <height.length ; i++) {
            for (int j = i+1; j <height.length ; j++) {
                int area=Math.min(height[i],height[j])*(j-i);
                maxarea=Math.max(maxarea,area);
            }
        }
        return maxarea;
    }
}
