package com.main.pj;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) {
			
		System.out.println(8 % 10); 
		
//		int []numbers=new int[3];
//		
//		int []random=GenerateRandomNumber(numbers);
//		
//		List <String> array=Arrays.asList("3","4","1");
//		
//		Collections.reverse(array);
//		
//		System.out.println(array);
		
		//print(randarrayom);
		//print(SelectionSort(random));
		//print(BubbleSort(random));
		
	//	BinarySearch(BubbleSort(random),2);
		
	 
		
	}
	
	public static void print(int[] number){
		StringBuilder print =new StringBuilder();
		for(int i=0; i< number.length;i++){
			print.append(number[i] + ",");
		}	
		System.out.println(print);
	}
	
	public static int[] SelectionSort(int []numbers){
		int sort[]=numbers;
		int size=numbers.length;
		for(int i=0;i<size;i++){
			int minimum=i;
			for(int j=i;j<size;j++){	
				if(sort[minimum]>sort[j]){
					System.out.println(sort[minimum] + " > " + sort[j]);
					System.out.println(minimum);
					minimum=j;
				}
			}
			int temp=i;
			i=minimum;
			minimum=temp;
		}
		return sort;
		
	}
	
	public static int[] BubbleSort(int []numbers){
		int sort[]=numbers;
		for(int i=sort.length-1; i > 0;i--){
			for(int j=0; j<i;j++){
				if(sort[j]>sort[j+1]){
					int temp=sort[j];
					sort[j]=sort[j+1];
					sort[j+1]=temp;
				}
			}
		}	
		return sort;
	}
	
	//must be sorted and no duplicates
	public static void BinarySearch(int []array,int value){
		
		int lowIndex=0;
		int highIndex=array.length-1;
	
		while(lowIndex<=highIndex){
			
			int middleIndex=lowIndex + highIndex / 2;
			if(array[middleIndex]<value) lowIndex=middleIndex+1;
			else if (array[middleIndex]>value) highIndex=middleIndex -1;
			else {
				System.out.print("Found value on index " + middleIndex);
				lowIndex=highIndex +1;
			}
			
		}
		
	}
	
	public static int[] GenerateRandomNumber(int [] numbers){
		
		int []randnumber= new int[numbers.length];
		
		for(int i=0; i< numbers.length;i++){
			randnumber[i]=(int) (Math.random()*10);
		}
		return randnumber;
	}
	
	
	public static Date DateRepresentation(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	

}
