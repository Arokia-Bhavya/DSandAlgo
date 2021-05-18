package easy;

import org.junit.Assert;
import org.junit.Test;

public class RotateImage {
@Test	
public void example1()
{
	Assert.assertArrayEquals(new int[][] {{3,1},{4,2}}, getRotateImageUsingExtraSpace(new int[][] {{1,2},{3,4}}));	
}

@Test	
public void example2()
{
	Assert.assertArrayEquals(new int[][] {{3,1},{4,2}}, getRotateImageUsingExtraSpace(new int[][] {{1,2},{3,4}}));	
}

private int[][] getRotateImage(int[][] image) {
	
	int n = image[0].length;
	for(int i=0 ; i<n/2 + n%2; i++)
	{
		for(int j=0 ; j<n/2 ; j++)
		{
			int tmp=image[n - 1 - j][i];
			image[n - 1 - j][i] = image[n - 1 - i][n - j - 1];
			image[n - 1 - i][n - j - 1]=image[j][n - 1 - i];
			image[j][n - 1 - i]=image[i][j];
			image[i][j]=tmp;
			
		}

	}
	return image;
}


private int[][] getRotateImageUsingExtraSpace(int[][] image) {
	
	int n = image[0].length;
	int[][] output=new int[n][n];
	for(int i=0 ; i<n/2 + n%2; i++)
	{
		for(int j=0 ; j<n/2 ; j++)
		{			
			output[n - 1 - j][i] = image[n - 1 - i][n - j - 1];
			output[n - 1 - i][n - j - 1]=image[j][n - 1 - i];
			output[j][n - 1 - i]=image[i][j];
			output[i][j]=image[n - 1 - j][i];;
			
		}

	}
	return output;
}

}
