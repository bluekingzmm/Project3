/**
 * 
 */
package com.czc.util;

import java.util.Random;

/**
 * @author user12
 * 
 */
public class MyUtil {
	int playpoint=0;//玩家点数
	int brandpoint=0;//庄家点数
	int lefthand=0;//剩余牌数

	public int[] poker() {
		int[] zjh = new int[52];
		int k = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				zjh[k++] = i * 10 + j;
			}
		}
		return zjh;

	}

	public void disp(int Num) {

		if (Num == 1) {
			System.out.print("A");
		} else if (Num > 1 && Num < 11) {
			System.out.print(Num);
		} else if (Num == 11) {
			System.out.print("J");
		} else if (Num == 12) {
			System.out.print("Q");
		} else if (Num == 13) {
			System.out.print("k");
		} else {
		}

	}

	public void pocker(int n) {
		int huase, Num;
		huase = n / 10;
		Num = n % 10;
		if (huase == 1) {
			System.out.print("黑桃");
			disp(Num);
		} else if (huase == 2) {
			System.out.print("红心");
			disp(Num);
		} else if (huase == 3) {
			System.out.print("方块");
			disp(Num);
		} else if (huase == 4) {
			System.out.print("梅花");
			disp(Num);
		} else {

		}

	}
/*
 * 显示牌
 * 无返回值
 * 定义参数 1：扑克  2： 牌数
 */
	public void dispAllPuke(int[] disppocker, int n) {
		int k = 0;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			pocker(disppocker[i]);
			System.out.print("  ");
			k = r.nextInt(200);
			try {
				Thread.sleep(k);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			if ((i + 1) % 12 == 0) {
				System.out.println();
			}
		}

	}

	/*功能洗牌
	 * p,q为随机的牌
	 */
	public int[] washcard(int[] pukeArr, int n) {
		Random r = new Random();
		int p = r.nextInt(n);
		int q = r.nextInt(n);
		int temp = 0;
		for (int j = 1; j <= 3; j++) {
			for (int i = 0; i < 100; i++) {
				if (p != q) {
					temp = pukeArr[p];
					pukeArr[p] = pukeArr[q];
					pukeArr[q] = temp;
				}
			}

			System.out.println("一共洗了" + j + "次");
			dispAllPuke(pukeArr, n);
			for (int i = 0; i < 20; i++) {
				System.out.println("\n\n");
			}
		}
		return pukeArr;
	}
	public  double sumpoint(int n){
		double a=n/10;
		if(a>=1&&a<11){
			return a;
		}else if(a>=11&&a<=13){
			return 0.5;
		}else{
			return 0;
		}
		
	}
	public void disppuke(int[] puke){
		Random r=new Random();
		int k=r.nextInt(52);
		while(true){
			if(puke[k]!=0){ //没用过的牌
			System.out.println("玩家第一张牌");
			
		
			
		}
		}
		
	}

}
