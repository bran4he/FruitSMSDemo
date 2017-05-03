package com.fruit.sales.test;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.Date;

public class App {

	public static void main(String[] args) {
//		int[] test = new int[]{1,3,4,5,6,7};
//		System.out.println(Arrays.toString(test));

		System.out.println(new Date(10000));
		System.out.println(new DateTime(0).plusHours(1).toDate());
		//Thu Jan 01 08:00:00 CST 1970


	}
}
