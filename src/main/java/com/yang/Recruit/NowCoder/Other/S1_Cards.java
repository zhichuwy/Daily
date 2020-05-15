package com.yang.Recruit.NowCoder.Other;

import java.util.Random;

public class S1_Cards {

	class Card {
		public String num;
		public String suit;

		Card(String n, String s) {
			this.num = n;
			this.suit = s;
		}

		public String toString() {
			String str = suit + ":" + num + "  ";
			return str;
		}
	}

	private Card[] cards;

	public void initcard() {
		String num[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String suit[] = { "方块", "梅花", "红桃", "黑桃" };
		cards = new Card[54];
		for (int i = 0; i < 52; i++) {
			cards[i] = new Card(num[i % 13], suit[i / 13]);
		}

		cards[52] = new Card("13", "小王");
		cards[53] = new Card("13", "大王");
	}

	public void xiCards() {
		Random rd = new Random();
		for (int i = 0; i < 54; i++) {
			int j = rd.nextInt(54);
			Card temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}
	}

	public void faCards() {
		for (int i = 0; i < 54; i++) {
			System.out.print(cards[i]);
			if ((i + 1) % 4 == 0) {
				System.out.println("\n");
			}
		}
	}

	public static void main(String[] args) {
		S1_Cards s = new S1_Cards();
		s.initcard();
		s.xiCards();
		s.faCards();
	}
}
