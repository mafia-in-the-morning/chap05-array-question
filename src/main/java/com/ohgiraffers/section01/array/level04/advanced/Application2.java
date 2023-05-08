package com.ohgiraffers.section01.array.level04.advanced;

import java.util.Random;
import java.util.Scanner;


public class Application2 {

	public static void main(String[] args) {

		/* 숫자 야구게임 만들기
		 * 길이 4의 정수 배열을 만들고 각 인덱스에는 0 ~ 9까지의 중복되지 않는 난수를 저장한다.
		 * 4자리 숫자를 입력받아 스트라이크, 볼 등의 힌트를 주며 4자리 난수 숫자를 맞추는 게임이다.
		 * 숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼 이다.
		 * 예) 9183 으로 난수가 발생하면 9356 입력 시 1S 1B이다.
		 *
		 * 단, 기회는 총 10번이며, 10번 이내에 맞추는 경우 "정답입니다." 출력 후 게임 종료
		 * 10번의 기회가 모두 소진 되면 "10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다." 출력 후 종료
		 *
		 * 또한 4자리의 정수를 입력하지 않은 경우에는 "4자리의 정수를 입력해야 합니다." 출력 후 입력을 다시 받을 수 있되
		 * 횟수는 차감하지 않는다.
		 *
		 * -- 프로그램 예시 (난수 7416 의 경우) --
		 *
		 * 10회 남으셨습니다.
		 * 4자리 숫자를 입력하세요 : 1234
		 * 아쉽네요 0S 2B 입니다.
		 * 9회 남으셨습니다.
		 * 4자리 숫자를 입력하세요 : 5678
		 * 아쉽네요 0S 2B 입니다.
		 * 8회 남으셨습니다.
		 * 4자리 숫자를 입력하세요 : 7416
		 * 정답입니다.
		 * */
		int[] answer= generateAnswer();
		int[] guess = new int[4];
		int strike, ball;
		int count = 0;
		Scanner scanner = new Scanner(System.in);

		while (count < 10) { // 10번의 기회가 있음
			// 4자리 숫자 입력 받기
			System.out.print("4자리 숫자를 입력하세요: ");
			int num = scanner.nextInt();

			if (num < 1000 || num > 9999) { // 4자리의 정수를 입력하지 않은 경우
				System.out.println("4자리의 정수를 입력해야 합니다.");
				continue; // 횟수 차감하지 않고 다시 입력 받음
			}

			// 입력 받은 숫자를 배열에 저장
			for (int i = 3; i >= 0; i--) {
				guess[i] = num % 10;
				num /= 10;
			}
			strike=0;
			ball=0;

			for(int i=0; i<4; i++){
				if(guess[i]==answer[i]){
					strike++;
				}
				else if (contains(answer, guess[i])) { // 숫자는 맞지만 자리는 맞지 않는 경우
					ball++;
				}
			}
			// 결과 출력
			if (strike == 4) { // 정답인 경우
				System.out.println("정답입니다.");
				break;
			} else { // 오답인 경우
				System.out.println(strike + "S " + ball + "B");
				count++;
			}
		}

		if (count == 10) { // 10번의 기회를 모두 소진한 경우
			System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.");
		}
	}

	// 0 ~ 9까지의 중복되지 않는 난수로 이루어진 길이 4의 정수 배열 생성하는 메소드
	public static int[] generateAnswer() {
		int[] arr = new int[4];
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int num;
			do {
				num = random.nextInt(10);
			} while (contains(arr, num));
			arr[i] = num;
		}
		return arr;
	}

	// 배열에 특정 값이 포함되어 있는지 확인하는 메소드
	public static boolean contains(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;


	}

}
