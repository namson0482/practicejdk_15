package vunam;
import java.math.BigInteger;

public class WizeLine {
	
	
	static int[] integerAdder_(int[] a, int[] b) {
		
		int pointLoop = a.length >= b.length ? a.length : b.length;
		int maxLength = pointLoop;
		int []result = new int[pointLoop];
		int pointA = a.length - 1;
		int pointB = b.length - 1;
		int memory = 0;
		while(pointLoop > 0) {
			int temp1 = 0, temp2 = 0;
			if(pointA >= 0) {
				temp1 = a[pointA];
				pointA--;
			}
			if(pointB >= 0) {
				temp2 = b[pointB];
				pointB--;
			}
			int temp3 = temp1 + temp2 + memory;
			if(temp3 > 9) {
				String []sTempArray = (temp3 + "").split("");
				memory = Integer.parseInt(sTempArray[0]);
				result[pointLoop - 1] = Integer.parseInt(sTempArray[1]);
			} else {
				
				memory = 0;
				result[pointLoop - 1] = temp3;

			}
			pointLoop--;
		}
		if(memory != 0) {
			int []result_1 = new int[maxLength + 1]	;
			result_1[0] = memory;
			for(int i=0;i<result.length;i++) {
				result_1[i+1] = result[i];
			}
			return result_1;
		}
		return result;
	}

	
	static int[] integerAdder(int[] a, int[] b) {

	    String temp1 = "", temp2 = "";
	    
	    for(int i = 0;i<a.length;i++) {
	        temp1 += a[i];
	    }     
	    
	    for(int i = 0;i<b.length;i++) {
	        temp2 += b[i];
	    }
	    
	    BigInteger tempValue1 = new BigInteger(temp1) ;
	    BigInteger tempValue2 = new BigInteger(temp2);
	    BigInteger tempValue3 = tempValue1.add(tempValue2);
	    
	    String temp3 = tempValue3.toString() + "";
	    String []arrayTemp = temp3.split("");
	    int []result =  new int[arrayTemp.length];
	    for(int i =0;i<arrayTemp.length;i++) {
	        result[i] = Integer.parseInt(arrayTemp[i]); 
	    }
	    
	    return result;
	}
	
	public static void main(String[] args) {
		
//		int []a =  {9, 9, 9, 9, 9, 9, 9, 9, 9,9 ,9 ,9 , 9 , 9 , 9, 9, 9, 9, 9, 9, 9, 9, 9 ,9 ,9, 9, 9, 9, 9, 9,9 , 9,9 , 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
//		int []b = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9 ,9 ,9 , 9 , 9 , 9, 9, 9, 9, 9, 9, 9, 9, 9 ,9 ,9, 9, 9, 9, 9, 9,9 , 9,9 , 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9, 9};
		int []a =  {9, 9, 9};
		int []b = {9, 9, 9};
		
		int []result = integerAdder_(a, b);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]);
		}
		
		//
		System.out.println("");
		System.out.println(a.length);
		System.out.print(result.length);
	}
	
}
