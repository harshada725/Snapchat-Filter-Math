
public class ConvolutionFilter {

	
	 public static void main(String[] args) 
	    {
	        int[][] image = 
	        {
	            {10, 10, 10, 10, 10},
	            {10, 20, 20, 20, 10},
	            {10, 20, 30, 20, 10},
	            {10, 20, 20, 20, 10},
	            {10, 10, 10, 10, 10}
	        };

	        int[][] filter = 
	        {
	            {1, 0, -1},
	            {1, 0, -1},
	            {1, 0, -1}
	        };


	        int[][] result = new int[image.length][image[0].length];

	        for (int i = 1; i < image.length - 1; i++) 
	        {
	            for (int j = 1; j < image[0].length - 1; j++) 
	            {
	                int sum = 0;
	                for (int m = -1; m <= 1; m++) 
	                {
	                    for (int n = -1; n <= 1; n++) 
	                    {
	                        sum += image[i + m][j + n] * filter[m + 1][n + 1];
	                    }
	                }

	                // Clamp to range [0, 255]

	                if (sum < 0) sum = 0;
	                if (sum > 255) sum = 255;

	                result[i][j] = sum;
	            }
	        }

	        System.out.println("Output after applying filter:");
	        for (int[] row : result) 
	        {
	            for (int val : row) 
	            {
	                System.out.print(val + "\t");
	            }
	            System.out.println();
	        }
	    }
	}
