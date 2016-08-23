package com.yiniu.weka;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Con Zhang
 * @date 2016年8月23日
 */
public class MathUtil {

	private Integer groupNum;
	private int[] data;

	/**
	 * 
	 * @Description 冒泡排序
	 * @para @param numbers
	 * @return int[]
	 */
	public static float[] bubbleSort(float[] numbers) {
		float temp; // 记录临时中间值
		int size = numbers.length; // 数组大小
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (numbers[i] < numbers[j]) { // 交换两数的位置
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		return numbers;
	}

	/**
	 * @Description 最大值
	 * @para @param numbers
	 * @return float
	 */
	public static float maxValue(float[] numbers) {
		return bubbleSort(numbers)[0];
	}

	/**
	 * @Description 最小值
	 * @para @param numbers
	 * @return float
	 */
	public static float minValue(float[] numbers) {
		return bubbleSort(numbers)[numbers.length - 1];
	}

	/**
	 * 
	 * @Description 对数组进行分组处理
	 * @para @param numbers
	 * @para @param groupNum
	 * @return List<Float[]>
	 */
	public static List<Float[]> divGroups(float[] numbers, int groupNum) {
		List<Float[]> list = new ArrayList<Float[]>();
		float maxValue = maxValue(numbers);
		float minValue = minValue(numbers);
		float temp = (maxValue-minValue)/(groupNum-2);
		list.add(new Float[]{Float.NEGATIVE_INFINITY ,minValue});
		for(int i=0; i < groupNum-2; i++){
			float value = minValue+temp*i;
			list.add(new Float[]{value,value+temp});
		}
		list.add(new Float[]{maxValue,Float.POSITIVE_INFINITY});
		return list;
	}

	public static void main(String[] args) {
		float[] arr = new float[] { 2, 8, 3, 7, 4, 20, 5, 87, 23, 65 };
		MathUtil mathUtil = new MathUtil();
		List<Float[]> list = mathUtil.divGroups(arr, 5);
		for(Float[] f : list){
			System.out.println(f[0]+"---"+f[1]);
		}
	}
}
