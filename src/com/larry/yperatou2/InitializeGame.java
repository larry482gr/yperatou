package com.larry.yperatou2;

import java.util.ArrayList;
import java.util.Random;

import com.larry.yperatou2.R;

public class InitializeGame{
	public InitializeGame(){
		initializeCards();
		initializePackage();
		populateCards();
	}

	private void initializeCards() {
		// Initialize Card Variables
		red = new ArrayList<Integer>();
		yellow = new ArrayList<Integer>();
		a1 = new ArrayList<Integer>();
		a2 = new ArrayList<Integer>();
		a3 = new ArrayList<Integer>();
		a4 = new ArrayList<Integer>();
		b1 = new ArrayList<Integer>();
		b2 = new ArrayList<Integer>();
		b3 = new ArrayList<Integer>();
		b4 = new ArrayList<Integer>();
		g1 = new ArrayList<Integer>();
		g2 = new ArrayList<Integer>();
		g3 = new ArrayList<Integer>();
		g4 = new ArrayList<Integer>();
		d1 = new ArrayList<Integer>();
		d2 = new ArrayList<Integer>();
		d3 = new ArrayList<Integer>();
		d4 = new ArrayList<Integer>();
		e1 = new ArrayList<Integer>();
		e2 = new ArrayList<Integer>();
		e3 = new ArrayList<Integer>();
		e4 = new ArrayList<Integer>();
		z1 = new ArrayList<Integer>();
		z2 = new ArrayList<Integer>();
		z3 = new ArrayList<Integer>();
		z4 = new ArrayList<Integer>();
		h1 = new ArrayList<Integer>();
		h2 = new ArrayList<Integer>();
		h3 = new ArrayList<Integer>();
		h4 = new ArrayList<Integer>();
		th1 = new ArrayList<Integer>();
		th2 = new ArrayList<Integer>();
		th3 = new ArrayList<Integer>();
		th4 = new ArrayList<Integer>();

		// Fill Cards with Layout and characteristics
		
		// Red Card
		red.add(R.layout.red);
		red.add(0);
		
		// Yellow Card
		yellow.add(R.layout.yellow);
		yellow.add(1);
		
		// A1
		a1.add(R.layout.a1);
		a1.add(1907);
		a1.add(120);
		a1.add(50);
		a1.add(37);
		a1.add(3200);
		a1.add(6);
		
		// A2
		a2.add(R.layout.a2);
		a2.add(1929);
		a2.add(125);
		a2.add(20);
		a2.add(15);
		a2.add(3500);
		a2.add(6);
		
		// A3
		a3.add(R.layout.a3);
		a3.add(1927);
		a3.add(175);
		a3.add(160);
		a3.add(118);
		a3.add(6250);
		a3.add(8);
		
		// A4
		a4.add(R.layout.a4);
		a4.add(1928);
		a4.add(75);
		a4.add(20);
		a4.add(15);
		a4.add(3000);
		a4.add(6);
		
		// B1
		b1.add(R.layout.b1);
		b1.add(1928);
		b1.add(160);
		b1.add(140);
		b1.add(103);
		b1.add(7100);
		b1.add(8);
		
		// B2
		b2.add(R.layout.b2);
		b2.add(1930);
		b2.add(145);
		b2.add(50);
		b2.add(37);
		b2.add(3800);
		b2.add(6);
		
		// B3
		b3.add(R.layout.b3);
		b3.add(1931);
		b3.add(135);
		b3.add(25);
		b3.add(18);
		b3.add(3800);
		b3.add(6);
		
		// B4
		b4.add(R.layout.b4);
		b4.add(1934);
		b4.add(140);
		b4.add(50);
		b4.add(37);
		b4.add(3500);
		b4.add(6);
		
		// G1
		g1.add(R.layout.g1);
		g1.add(1934);
		g1.add(150);
		g1.add(80);
		g1.add(59);
		g1.add(3500);
		g1.add(6);
		
		// G2
		g2.add(R.layout.g2);
		g2.add(1935);
		g2.add(145);
		g2.add(55);
		g2.add(40);
		g2.add(3500);
		g2.add(6);
		
		// G3
		g3.add(R.layout.g3);
		g3.add(1938);
		g3.add(150);
		g3.add(150);
		g3.add(110);
		g3.add(6800);
		g3.add(8);
		
		// G4
		g4.add(R.layout.g4);
		g4.add(1939);
		g4.add(170);
		g4.add(90);
		g4.add(66);
		g4.add(4500);
		g4.add(6);
		
		// D1
		d1.add(R.layout.d1);
		d1.add(1944);
		d1.add(145);
		d1.add(85);
		d1.add(63);
		d1.add(3800);
		d1.add(8);
		
		// D2
		d2.add(R.layout.d2);
		d2.add(1945);
		d2.add(156);
		d2.add(95);
		d2.add(70);
		d2.add(3917);
		d2.add(8);
		
		// D3
		d3.add(R.layout.d3);
		d3.add(1948);
		d3.add(185);
		d3.add(115);
		d3.add(85);
		d3.add(4250);
		d3.add(6);
		
		// D4
		d4.add(R.layout.d4);
		d4.add(1954);
		d4.add(190);
		d4.add(280);
		d4.add(206);
		d4.add(5600);
		d4.add(8);
		
		// E1
		e1.add(R.layout.e1);
		e1.add(1951);
		e1.add(190);
		e1.add(130);
		e1.add(96);
		e1.add(4500);
		e1.add(6);
		
		// E2
		e2.add(R.layout.e2);
		e2.add(1954);
		e2.add(135);
		e2.add(78);
		e2.add(57);
		e2.add(1500);
		e2.add(4);
		
		// E3
		e3.add(R.layout.e3);
		e3.add(1956);
		e3.add(200);
		e3.add(150);
		e3.add(110);
		e3.add(4900);
		e3.add(6);
		
		// E4
		e4.add(R.layout.e4);
		e4.add(1956);
		e4.add(195);
		e4.add(135);
		e4.add(99);
		e4.add(4200);
		e4.add(6);
		
		// Z1
		z1.add(R.layout.z1);
		z1.add(1958);
		z1.add(225);
		z1.add(240);
		z1.add(176);
		z1.add(2998);
		z1.add(8);
		
		// Z2
		z2.add(R.layout.z2);
		z2.add(1978);
		z2.add(200);
		z2.add(320);
		z2.add(235);
		z2.add(5200);
		z2.add(8);
		
		// Z3
		z3.add(R.layout.z3);
		z3.add(1978);
		z3.add(200);
		z3.add(380);
		z3.add(279);
		z3.add(6400);
		z3.add(8);
		
		// Z4
		z4.add(R.layout.z4);
		z4.add(1979);
		z4.add(205);
		z4.add(360);
		z4.add(265);
		z4.add(5600);
		z4.add(8);
		
		// H1
		h1.add(R.layout.h1);
		h1.add(1979);
		h1.add(210);
		h1.add(360);
		h1.add(265);
		h1.add(5600);
		h1.add(8);
		
		// H2
		h2.add(R.layout.h2);
		h2.add(1979);
		h2.add(190);
		h2.add(115);
		h2.add(85);
		h2.add(2000);
		h2.add(4);
		
		// H3
		h3.add(R.layout.h3);
		h3.add(1979);
		h3.add(185);
		h3.add(287);
		h3.add(211);
		h3.add(5343);
		h3.add(12);
		
		// H4
		h4.add(R.layout.h4);
		h4.add(1979);
		h4.add(302);
		h4.add(360);
		h4.add(265);
		h4.add(4942);
		h4.add(12);
		
		// TH1
		th1.add(R.layout.th1);
		th1.add(1979);
		th1.add(204);
		th1.add(340);
		th1.add(250);
		th1.add(6000);
		th1.add(8);
		
		// TH2
		th2.add(R.layout.th2);
		th2.add(1979);
		th2.add(262);
		th2.add(277);
		th2.add(204);
		th2.add(3453);
		th2.add(6);
		
		// TH3
		th3.add(R.layout.th3);
		th3.add(1979);
		th3.add(195);
		th3.add(290);
		th3.add(213);
		th3.add(6400);
		th3.add(8);
		
		// TH4
		th4.add(R.layout.th4);
		th4.add(1979);
		th4.add(210);
		th4.add(240);
		th4.add(176);
		th4.add(6750);
		th4.add(8);
	}
	
	private void initializePackage() {
		cardPackage = new ArrayList<ArrayList<Integer>>();
		cardPackage.add(red);
		cardPackage.add(yellow);
		cardPackage.add(a1);
		cardPackage.add(a2);
		cardPackage.add(a3);
		cardPackage.add(a4);
		cardPackage.add(b1);
		cardPackage.add(b2);
		cardPackage.add(b3);
		cardPackage.add(b4);
		cardPackage.add(g1);
		cardPackage.add(g2);
		cardPackage.add(g3);
		cardPackage.add(g4);
		cardPackage.add(d1);
		cardPackage.add(d2);
		cardPackage.add(d3);
		cardPackage.add(d4);
		cardPackage.add(e1);
		cardPackage.add(e2);
		cardPackage.add(e3);
		cardPackage.add(e4);
		cardPackage.add(z1);
		cardPackage.add(z2);
		cardPackage.add(z3);
		cardPackage.add(z4);
		cardPackage.add(h1);
		cardPackage.add(h2);
		cardPackage.add(h3);
		cardPackage.add(h4);
		cardPackage.add(th1);
		cardPackage.add(th2);
		cardPackage.add(th3);
		cardPackage.add(th4);
	}
	
	private void populateCards() {
		StartGame.playerCards = new ArrayList<ArrayList<Integer>>();
		StartGame.cpuCards = new ArrayList<ArrayList<Integer>>();
		
		Random generator = new Random();
		int j = 0;
		int initialSize = cardPackage.size();
		for (int i = 0; i < initialSize; i++){
			j = generator.nextInt(initialSize-i);
			if (i%2 == 0) {
				StartGame.playerCards.add(cardPackage.get(j));
			}
			else {
				StartGame.cpuCards.add(cardPackage.get(j));
			}
			cardPackage.remove(j);
		}
	}

	private ArrayList<Integer> red;
	private ArrayList<Integer> yellow;
	private ArrayList<Integer> a1;
	private ArrayList<Integer> a2;
	private ArrayList<Integer> a3;
	private ArrayList<Integer> a4;
	private ArrayList<Integer> b1;
	private ArrayList<Integer> b2;
	private ArrayList<Integer> b3;
	private ArrayList<Integer> b4;
	private ArrayList<Integer> g1;
	private ArrayList<Integer> g2;
	private ArrayList<Integer> g3;
	private ArrayList<Integer> g4;
	private ArrayList<Integer> d1;
	private ArrayList<Integer> d2;
	private ArrayList<Integer> d3;
	private ArrayList<Integer> d4;
	private ArrayList<Integer> e1;
	private ArrayList<Integer> e2;
	private ArrayList<Integer> e3;
	private ArrayList<Integer> e4;
	private ArrayList<Integer> z1;
	private ArrayList<Integer> z2;
	private ArrayList<Integer> z3;
	private ArrayList<Integer> z4;
	private ArrayList<Integer> h1;
	private ArrayList<Integer> h2;
	private ArrayList<Integer> h3;
	private ArrayList<Integer> h4;
	private ArrayList<Integer> th1;
	private ArrayList<Integer> th2;
	private ArrayList<Integer> th3;
	private ArrayList<Integer> th4;
	private ArrayList<ArrayList<Integer>> cardPackage;

}
