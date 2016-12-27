/**
 * 
 */
package com.czc.util;

import java.util.Random;
import java.util.Scanner;

/**
 * @author user12
 * 
 */
public class MyUtil {

	String[] savepassword = new String[2]; // 密码
	String[] username = new String[2]; // 用户名
	String newname , newmima;
	Scanner sc = new Scanner(System.in);

	public void login() {
		progress();
		while(true){
		int i = 0;
		savepassword[0] = "blueking";
		savepassword[1] = "oo";
		username[0] = "张明明";
		username[1] = "阳光";
		System.out.println("\n一共有两个用户名供你选择·1：张明明  2：阳光");
		System.out.println("请输入用户名");
		newname = sc.nextLine();
		System.out.println("请输入密码");
		newmima = sc.nextLine();
		if (newname.equals("阳光")) {
			i = 1;
		}
		if (savepassword[i].equals(newmima) && username[i].equals(newname)) {
			System.out.println("登录成功！！");
			Menu();
		} else {
			System.out.println("登录失败！！，请重新开始！");
			continue;
		}
		}
	}

	int time = 3;
	int playerwin = 0, playerlose = 0, bakerwin = 0, bakerlose = 0;
	int lefthand = 0;

	public void progress() {
		
		for (int i = 0; i <= 100; i++) {
			
			for (int n = 0; n <200; n++) {
				System.out.println("");
				
			}  //通过换行达到清屏的功能
		
			for (int j = 0; j < i/2; j++) {
				System.out.print(">");
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //最好不要停留，否则会闪动
			} //输出>,0 0 1 1 2 2 3 3
		
			for(int j1=100;j1>i;j1-=2){
				System.out.print("=");
			} //=号一直递减
			
			System.out.print(i + "%"); //外层循环，输出0%到100%	

			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	
		}
		System.out.println();
		System.out.println("进度加载完毕，即将进入主界面...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	}

	/*
	 * 定义数组poker
	 *               
	 */
	public int[] poker() {
		int[] zjh = new int[52];
		int k = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				zjh[k++] = i + j * 10;
			}
		}
		return zjh;

	}

	/*
	 * 游戏的帮助gamehelp
	 */
	public void gamehelp() {
		System.out.println(
				"从A到10分别以牌面数值为分值,JQK这三张为半点, 大小王剔出不要然后发牌。" + "每家人最少两张，最多五张，牌的张数正确，就比加起来的点数" + "，不超过10点半的前提下点数最大的就为赢家");

	}

	/*
	 * 游戏退出exit
	 */
	public void gameexit() {
		Scanner sc = new Scanner(System.in);
		String choice ;
		System.out.println("请输入你的选择，y或Y则退出，任意键继续");
		choice = sc.next();

		if (choice.equalsIgnoreCase("y")) {// 不区分Y和y
			System.out.println("游戏退出了，欢迎下次再来");
			System.exit(0);

		}
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
		huase = n % 10;
		Num = n / 10;
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
	 * 游戏设置gamesettings 洗牌的次数设定time
	 */
	public void gamesettings() {
		Scanner sc = new Scanner(System.in);
		System.out.println("要洗牌了，请输入洗牌的次数");
		time = sc.nextInt();
		page();

		begin();
	}

	/*
	 * 功能：显示所有牌dispAllPuke 显示牌 无返回值 定义参数 1：存放的牌数 int[] pukeArr 扑克 2： 牌数n
	 */
	public void dispAllPuke(int[] pukeArr, int n) {
		int k = 0;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			pocker(pukeArr[i]);// 注意！
			System.out.print("  ");
			k = r.nextInt(200);
			try { // 牌出现时间的间隔
				Thread.sleep(k);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if ((i + 1) % 12 == 0) {
				System.out.println();
			}
		}

	}

	/*
	 * 功能洗牌定义数组int[] washcard 参数1存放牌，参数2牌数 p,q为随机的牌 返回值存放的数组
	 */
	public int[] washcard(int[] pukeArr, int n) {
		Random r = new Random();
		int p;
		int q;
		int temp;
		for (int j = 0; j < time; j++) {
			for (int i = 0; i < 30; i++) {
				p = r.nextInt(n);
				q = r.nextInt(n);
				if (p != q) { // 从牌数中找出不同的两个牌进行交换
					temp = pukeArr[p];
					pukeArr[p] = pukeArr[q];
					pukeArr[q] = temp;
				}
			}

			System.out.println("一共洗了" + (j + 1) + "次");
			dispAllPuke(pukeArr, n);
			for (int i = 0; i < 20; i++) {
				System.out.println("\n");
			}
		}
		return pukeArr;
	}

	/*
	 * 参数Num 点数sumpoint 返回值changeresult
	 */
	public double sumpoint(int Num) {
		double changeresult = 0;
		if (Num >= 1 && Num < 11) {
			changeresult = Num;
		} else if (Num >= 11) {
			changeresult = 0.5;
		} else {
			changeresult = 0;
		}
		return changeresult;

	}
	/*
	 * 参数1牌数n，参数2result 返回值result 点数的计算
	 */

	public double countpuke(int n, double result) {
		int Num;
		Num = n / 10;
		result = sumpoint(Num);
		return result;
	}
	/*
	 * 参数1存放牌，参数2牌数，参数3剩余牌数lefthand 返回值pukeNum
	 */

	public int sendpukeNum(int[] pukeArr, int n, int lefthand) {
		int index;
		int pukeNum = 0;
		for (index = 0; index < n; index++) {
			if (pukeArr[index] != 0) {
				pukeNum = pukeArr[index];
				lefthand--;
				pukeArr[index] = 0;
				break;
			}

		}
		return pukeNum;
	}

	public void lastresult(double[] result) {
		double playerresult = result[1];
		double bakerresult = result[0];
		if (playerresult >= 11 && bakerresult >= 11) {
			System.out.println("玩家与庄家都爆了，庄家赢了");
			bakerwin++;
			playerlose++;
		} else if (bakerresult >= 11 && playerresult < 11) {
			System.out.println("庄家爆了，玩家赢了");
			playerwin++;
			bakerlose++;
		} else if (bakerresult < 11 && playerresult >= 11) {
			System.out.println("玩家爆了，庄家赢了");
			bakerwin++;
			playerlose++;
		} else {
			if (bakerresult >= playerresult) {
				System.out.println("庄家赢了,玩家输了");
				bakerwin++;
				playerlose++;
			} else {
				System.out.println("玩家赢了，庄家输了");
				playerwin++;
				bakerlose++;
			}
		}

	}

	/*
	 * 功能：发牌定义数组sendpuke，参数1存放的牌，参数2牌数，参数3剩余的牌数 返回值result
	 */
	public double[] sendpuke(int[] pukeArr, int n, int lefthand) {
		Scanner sc = new Scanner(System.in);

		int playerfirstNum = 0, playerthirdNum = 0, bakerthirdNum = 0;
		int playsecondNum = 0, bakerfirstNum = 0, bakersecondNum = 0;
		double[] result = new double[2];// result[0]是庄家结果。result[1]是玩家结果
		String choice ;
		if (lefthand >= 6) { // 剩余牌数大于等于6时才能继续
			System.out.print("庄家第一张牌  ");
			bakerfirstNum = sendpukeNum(pukeArr, n, lefthand);
			pocker(bakerfirstNum);
			result[0] += countpuke(bakerfirstNum, result[0]);

			System.out.print("\t玩家第一张牌  ");
			playerfirstNum = sendpukeNum(pukeArr, n, lefthand);
			pocker(playerfirstNum);
			result[1] += countpuke(playerfirstNum, result[1]);
			System.out.println();

			System.out.print("庄家第二张牌  ");
			bakersecondNum = sendpukeNum(pukeArr, n, lefthand);
			pocker(bakersecondNum);
			result[0] += countpuke(bakersecondNum, result[0]);

			System.out.print("\t玩家第二张牌  ");
			playsecondNum = sendpukeNum(pukeArr, n, lefthand);
			pocker(playsecondNum);
			result[1] += countpuke(playsecondNum, result[1]);
			System.out.println();
			System.out.print("玩家是否要第三张牌，要的话请输入y或Y");
			choice = sc.next();
			if (choice.equalsIgnoreCase("y")) {
				System.out.print("玩家第三张牌   ");
				playerthirdNum = sendpukeNum(pukeArr, n, lefthand);
				pocker(playerthirdNum);
				result[1] += countpuke(playerthirdNum, result[1]);
			}
			if (result[0] <= 6) {
				System.out.println("\n庄家第三张牌");
				bakerthirdNum = sendpukeNum(pukeArr, n, lefthand);
				pocker(bakerthirdNum);
				result[0] += countpuke(bakerthirdNum, result[0]);
			} else {
				System.out.println("\t庄家不要牌");
			}
			System.out.println();
			System.out.println("庄家的点数和" + result[0]);
			System.out.println("玩家的点数和" + result[1]);
		} else {
			System.out.println("剩余的牌数不够玩，请重新洗牌再开始游戏");
		}

		return result;
	}

	// 记录玩家与庄家的输赢次数
	public void compare() {

		System.out.println("玩家一共赢了" + playerwin + "次,一共输了" + playerlose + "次");
		System.out.println("庄家一共赢了" + bakerwin + "次,一共输了" + bakerlose + "次");

	}

	// 功能：主界面
	public int page() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("1:开始游戏\t ");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		try {
			System.out.print("\t2:游戏说明 ");

			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		try {
			System.out.print("\t3:游戏设置 ");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		try {
			System.out.print("\t4:游戏退出 ");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		int page = sc.nextInt();
		return page;

	}

	// 功能：菜单
	public void Menu() {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		int choice = page();
		while (true) {
			switch (choice) {
			case 1:

				begin();
				break;
			case 2:

				gamehelp();
				break;

			case 3:

				gamesettings();
				break;

			case 4:

				gameexit();
				break;

			default:
				System.out.println("请输入数字！！");
				break;
			}
		}

	}

	// 功能：游戏开始
	public void begin() {
		int n = 52;
		Scanner sc = new Scanner(System.in);

		int[] pukeArr = poker();
		washcard(pukeArr, n);
		while(true){
		double[] result = sendpuke(pukeArr, n, 52);
		System.out.println();
		lastresult(result);
		compare();

		System.out.println("是否继续本次牌的游戏\t1:继续\t2:重新洗牌 \t3:是否不想玩了呢");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		if (a==2) {
			gamesettings();
		}
		if(a==3){
			game();
		}
		}
	}

	public void game() {
		Scanner sc = new Scanner(System.in);	
		String choice = " ";
		for (int i = 0; i <= 13; i++) {
			System.out.println("是否结束本局游戏？是请输入Y，任意键返回到菜单");
			choice = sc.next();
			if (choice.equalsIgnoreCase("y")) {
				System.out.println("请下次再来！");
				System.exit(0);
			}
			Menu();
		}
	}
	
}
