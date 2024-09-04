import java.util.Scanner;

public class MaxWaterStorage {
    public static int maxWaterStorage(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of heights: ");
        int n = scanner.nextInt();
        int[] heights = new int[n];

        System.out.print("Enter the heights separated by space: ");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        int maxWater = maxWaterStorage(heights);
        System.out.println("Maximum water that can be stored: " + maxWater);

        scanner.close();
    }
}