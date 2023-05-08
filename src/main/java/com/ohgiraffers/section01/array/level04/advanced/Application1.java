package com.ohgiraffers.section01.array.level04.advanced;

import java.util.Arrays;
import java.util.Random;

public class Application1 {

	public static void main(String[] args) {

		/* 로또번호 생성기
		 * 6칸 짜리 정수 배열을 하나 생성하고
		 * 1부터 45까지의 중복되지 않는 난수를 발생시켜 각 인덱스에 대입한 뒤
		 * 오름차순 정렬하여 출력하세요
		 * */
		int[] lotto = new int[6];
		Random random = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = random.nextInt(45) + 1; // 1부터 45까지의 난수 발생
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) { // 중복되는 값이 있으면 다시 난수 발생
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto); // 오름차순 정렬

		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}

	}

}
