package com.larry.yperatou2;

import java.util.ArrayList;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StartGame extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Show the Up button in the action bar.
		if (android.os.Build.VERSION.SDK_INT > 11) {
			//getActionBar().setHomeButtonEnabled(false);
			//getActionBar().setDisplayHomeAsUpEnabled(false);
		}
		
		@SuppressWarnings("unused")
		InitializeGame newGame = new InitializeGame(); 
		stackCards = new ArrayList<ArrayList<Integer>>();
		setScore();
		getCurrentView();
		
		if (!playerRedYellow)
			checkCpuRedYellow();
		
		linflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		buttons = linflater.inflate(R.layout.buttons, null);
		gameover = linflater.inflate(R.layout.gameover, null);
		
		if (difficulty == 0)
			populateCharacteristicIndexArrayEasy();
		
		dbHelper = new SQLiteHelper(this);
		database = dbHelper.getWritableDatabase();
		dbHelper.populateDatabase(database);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MenuActions.applyItemAction(this, item.getItemId());
	}
	
	public void onBackPressed() {
		System.exit(0);
	}
	
	@SuppressLint("NewApi")
	private void setScore() {
		// DO IT USING IF/ELSE OR... MAKE IT A FULL SCREEN APP(!!!) WITH A TEXT VIEW KEEPING THE SCORE! 
		if (android.os.Build.VERSION.SDK_INT > 11) {
			//getActionBar().setTitle(" Cards:  U " + playerCards.size() + " - " + cpuCards.size() + " CPU");
		}
	}
	
	private void getCurrentView(){
		try {
			LayoutInflater inflator=getLayoutInflater();
			View view=inflator.inflate(playerCards.get(0).get(0), null, true);
			view.startAnimation(AnimationUtils.makeInAnimation(this, true));
			setContentView(view);
			view.setKeepScreenOn(true);
			currentView = view;
			previousView = playerCards.get(0).get(0);
			playerRedYellow = false;
			if (playerCards.get(0).get(1) < 2) {
				playerRedYellow = true;
				cpuTurn = false;
				mHandler.postDelayed(new Runnable(){
					public void run(){
						try {
							toast.cancel();
						} catch (NullPointerException e){
							
						}
						showToast("Click to earn your prize!");
					}
				}, 800);
			}
			
			else if (cpuTurn || cpuCards.get(0).get(1) < 2)
				currentView.setClickable(false);
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	public void showToast(String message) {
		CharSequence text = message;
		
		toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
		
		if (!alreadyOver)
			toast.show();
	}

	@SuppressLint("NewApi")
	public void showButtons(View v){
		try {
			toast.cancel();
			((RelativeLayout) buttons.getParent()).removeAllViews();
		} catch (NullPointerException e){
			
		}
		((RelativeLayout) v).addView(buttons, new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		currentView = v;
		currentView.setClickable(false);
	}
	
	public void compareYear(View v){
		if (!cpuTurn) {
			((RelativeLayout) v.getParent().getParent()).removeView(buttons);
			currentView.setClickable(true);
		}
		
		if (playerCards.get(0).get(1) == 0)
			processPlayerRed(v);
		
		else if (playerCards.get(0).get(1) == 1)
			processPlayerYellow(v);
		
		else if (playerCards.get(0).get(1) < cpuCards.get(0).get(1))
			processWin();
			
		else if (Math.abs(playerCards.get(0).get(1) - cpuCards.get(0).get(1)) < 1)
			processDraw();
		
		else
			processLoss();
	}

	public void compareVelocity(View v){
		if (!cpuTurn) {
			((RelativeLayout) v.getParent().getParent()).removeView(buttons);
			currentView.setClickable(true);
		}
		
		if (playerCards.get(0).get(2) > cpuCards.get(0).get(2))
			processWin();

		else if (Math.abs(playerCards.get(0).get(2) - cpuCards.get(0).get(2)) < 1) 
			processDraw();
		
		else 
			processLoss();
		
	}
	
	public void compareHorsepower(View v){
		if (!cpuTurn) {
			((RelativeLayout) v.getParent().getParent()).removeView(buttons);
			currentView.setClickable(true);
		}
		
		if (playerCards.get(0).get(3) > cpuCards.get(0).get(3)) 
			processWin();
		
		else if (Math.abs(playerCards.get(0).get(3) - cpuCards.get(0).get(3)) < 1) 
			processDraw();
		
		else 
			processLoss();
		
	}
	
	public void compareTorque(View v){
		if (!cpuTurn) {
			((RelativeLayout) v.getParent().getParent()).removeView(buttons);
			currentView.setClickable(true);
		}
		
		if (playerCards.get(0).get(4) > cpuCards.get(0).get(4)) 
			processWin();
		
		else if (Math.abs(playerCards.get(0).get(4) - cpuCards.get(0).get(4)) < 1) 
			processDraw();
		
		else 
			processLoss();
		
	}
	
	public void compareCC(View v){
		if (!cpuTurn) {
			((RelativeLayout) v.getParent().getParent()).removeView(buttons);
			currentView.setClickable(true);
		}
		
		if (playerCards.get(0).get(5) > cpuCards.get(0).get(5)) 
			processWin();
		
		else if (Math.abs(playerCards.get(0).get(5) - cpuCards.get(0).get(5)) < 1) 
			processDraw();
		
		else 
			processLoss();
		
	}
	
	public void compareCylinders(View v){
		if (!cpuTurn) {
			((RelativeLayout) v.getParent().getParent()).removeView(buttons);
			currentView.setClickable(true);
		}
		
		if (playerCards.get(0).get(6) > cpuCards.get(0).get(6)) 
			processWin();
		
		else if (Math.abs(playerCards.get(0).get(6) - cpuCards.get(0).get(6)) < 1) 
			processDraw();
		
		else 
			processLoss();
		
	}
	
	private void processWin(){
		showToast("Oh yeah!\nNice Play.");
		cpuTurn = false;
		if (difficulty != 0 && !characteristicIndexArray.isEmpty())
			characteristicIndexArray.clear();
		
		playerCards.add(cpuCards.get(0));
		try {
			playerCards.addAll(stackCards);
			stackCards.removeAll(stackCards);
		}
		catch (NullPointerException e) {
			
		}
		cpuCards.remove(0);
		currentView.setClickable(true);
		setScore();
		checkCpuRedYellow();
		checkWinLoss();
	}
	
	private void processDraw(){
		showToast("There was a draw\nBoth cards were put in the table.");
		if (difficulty != 0 && !characteristicIndexArray.isEmpty())
			characteristicIndexArray.clear();
		
		stackCards.add(playerCards.get(0));
		stackCards.add(cpuCards.get(0));
		playerCards.remove(0);
		cpuCards.remove(0);
		
		setScore();
		getCurrentView();
		
		if (!playerRedYellow || cpuTurn)
			checkCpuRedYellow();
		
		checkWinLoss();
		if (cpuTurn && !cpuRedYellow && playerCards.size() > 0 && cpuCards.size() > 0)
			cpuTurn();
	}
	
	private void processLoss(){
		showToast("Oops!\nBad luck this time.");
		cpuTurn = true;
		
		cpuCards.add(playerCards.get(0));
		try {
			cpuCards.addAll(stackCards);
			stackCards.removeAll(stackCards);
		}
		catch (NullPointerException e) {
			
		}
		playerCards.remove(0);
		setScore();
		
		// if CurrentView is Yellow or Red Card cpuTurn = false
		getCurrentView();
		
		checkCpuRedYellow();
		checkWinLoss();
		
		if (playerCards.size() > 0 && cpuTurn && !cpuRedYellow)
			cpuTurn();
	}

	private void cpuTurn() {
		switch (difficulty) {
			case 0: cpuPlay();
				break;
			case 1: cpuNormal();
				break;
			case 2: cpuHard();
				break;
			default: cpuNormal();
		}
	}

	private void cpuPlay() {
		i = pickRandomIndex(characteristicIndexArray.size());
		
		cpuCompareMessage();
		pickCharacteristic();
		
	}

	private int pickRandomIndex(int j) {
		Random generator = new Random();
		return characteristicIndexArray.get(generator.nextInt(j));
	}

	private void cpuNormal() {
		if (characteristicIndexArray.isEmpty())
			populateCharacteristicIndexArrayNormal();
		
		cpuPlay();
	}
	
	private void populateCharacteristicIndexArrayEasy() {
		characteristicIndexArray.add(0);
		characteristicIndexArray.add(1);
		characteristicIndexArray.add(2);
		characteristicIndexArray.add(3);
		characteristicIndexArray.add(4);
		characteristicIndexArray.add(5);
	}
	
	private void populateCharacteristicIndexArrayNormal() {
		if (cpuCards.get(0).get(1) < meanValues[0]) {
			characteristicIndexArray.add(0);
		}
				
		for (int j = 1; j < 6; j++) {
			if (cpuCards.get(0).get(j+1) > meanValues[j]) {
				characteristicIndexArray.add(j);
			}
		}
	}

	private void cpuHard() {
		if (characteristicIndexArray.isEmpty())
			populateCharacteristicIndexArrayHard();
		
		cpuPlay();
	}

	private void populateCharacteristicIndexArrayHard() {
		boolean maxValueNotFound = true;
		for (int j = 0; j < 6; j++) {
			if (cpuCards.get(0).get(j+1) == maxValues[j]) {
				characteristicIndexArray.add(j);
				maxValueNotFound = false;
			}
		}
		
		if (maxValueNotFound)
			populateCharacteristicIndexArrayNormal();
	}

	private void cpuCompareMessage() {		
		switch (i) {
			case 0: toastMessage = "CPU compares YEAR\n";
				break;
			case 1: toastMessage = "CPU compares VELOCITY\n";
				break;
			case 2: toastMessage = "CPU compares HORSEPOWER\n";
				break;
			case 3: toastMessage = "CPU compares TORQUE\n";
				break;
			case 4: toastMessage = "CPU compares CC\n";
				break;
			case 5: toastMessage = "CPU compares CYLINDERS\n";
				break;
			default: toastMessage = "CPU compares YEAR\n";
		}
	
		mHandler.postDelayed(new Runnable(){
			public void run(){
				toast.cancel();
				try {
					showToast(toastMessage + cpuCards.get(0).get(i+1) + " against " + playerCards.get(0).get(i+1));
				} catch (IndexOutOfBoundsException e) {
					
				}
			}
		}, 1500);
	}
	
	private void pickCharacteristic() {
		mHandler.postDelayed(new Runnable(){
			public void run(){
				switch (i) {
					case 0: compareYear(currentView);
						break;
					case 1: compareVelocity(currentView);
						break;
					case 2: compareHorsepower(currentView);
						break;
					case 3: compareTorque(currentView);
						break;
					case 4: compareCC(currentView);
						break;
					case 5: compareCylinders(currentView);
						break;
					default: compareYear(currentView);
				}
		    }
		}, 5000);
	}

	public void processPlayerRed(View v) {
		cpuTurn = false;
		toast.cancel();
		
		if (difficulty != 0 && !characteristicIndexArray.isEmpty())
			characteristicIndexArray.clear();
		
		playerCards.add(cpuCards.get(0));
		
		try {
			playerCards.add(cpuCards.get(1));
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			playerCards.addAll(stackCards);
			stackCards.removeAll(stackCards);
		}
		catch (NullPointerException e) {
			
		}
		
		try {
			cpuCards.remove(1);
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		cpuCards.remove(0);
		playerCards.remove(0);
		setScore();
		showToast("Oh yeah!\nYou won 2 cards.");
		getCurrentView();
		checkCpuRedYellow();
		checkWinLoss();
	}
	
	public void processPlayerYellow(View v) {
		cpuTurn = false;
		toast.cancel();
		if (difficulty != 0 && !characteristicIndexArray.isEmpty())
			characteristicIndexArray.clear();
		
		playerCards.add(cpuCards.get(0));
		try {
			playerCards.addAll(stackCards);
			stackCards.removeAll(stackCards);
		}
		catch (NullPointerException e) {
			
		}
		cpuCards.remove(0);
		playerCards.remove(0);
		setScore();
		showToast("Oh yeah!\nYou won 1 card.");
		getCurrentView();
		checkCpuRedYellow();
		checkWinLoss();
	}
	
	private void checkCpuRedYellow() {
		try {
			// Check cpu's card
			if (cpuCards.get(0).get(1) == 0) {
				cpuRedYellow = true;
				mHandler.postDelayed(new Runnable(){
					public void run(){
						try {
							toast.cancel();
						} catch (NullPointerException e) {
							
						}
						showToast("OH NO! Cpu had a red card!!\nYou lost two cards.");
						cpuRedYellow = false;
					}
				}, 1000);
				
				cpuTurn = true;
				currentView.setClickable(false);
				
				mHandler.postDelayed(new Runnable(){
					public void run(){
						cpuCards.add(playerCards.get(0));
						
						try {
							cpuCards.add(playerCards.get(1));
						} catch (IndexOutOfBoundsException e) {
							
						}
						
						try {
							cpuCards.addAll(stackCards);
							stackCards.removeAll(stackCards);
						}
						catch (NullPointerException e) {
							
						}
						
						try {
							playerCards.remove(1);
						} catch (IndexOutOfBoundsException e) {
						
						}
						
						playerCards.remove(0);
						cpuCards.remove(0);
						setScore();
						getCurrentView();	// If current player card is Red or Yellow card --> cpuTurn = false;
						checkWinLoss();
						
						if (alreadyOver)
							return;
						
						if (cpuTurn && cpuCards.get(0).get(1) < 2)
							checkCpuRedYellow();
						
						else if (cpuTurn)
							cpuTurn();
				    }
				}, 3000);
			}
			
			else if (cpuCards.get(0).get(1) == 1) {
				cpuRedYellow = true;
				mHandler.postDelayed(new Runnable(){
					public void run(){
						try {
							toast.cancel();
						} catch (NullPointerException e) {
							
						}
						showToast("OH NO! Cpu had a yellow card!!\nYou lost one card.");
						cpuRedYellow = false;
					}
				}, 1000);
				
				cpuTurn = true;
				currentView.setClickable(false);
				
				mHandler.postDelayed(new Runnable(){
					public void run(){
						cpuCards.add(playerCards.get(0));
						try {
							cpuCards.addAll(stackCards);
							stackCards.removeAll(stackCards);
						}
						catch (NullPointerException e) {
							
						}
						
						playerCards.remove(0);
						cpuCards.remove(0);
						
						setScore();
						getCurrentView();	// If current player card is Red or Yellow card --> cpuTurn = false;
						checkWinLoss();
						
						if (alreadyOver)
							return;

						if (cpuTurn && cpuCards.get(0).get(1) < 2)
							checkCpuRedYellow();
						
						else if (cpuTurn)
							cpuTurn();
				    }
				}, 3000);
			}
		}
		catch (IndexOutOfBoundsException e) {
			return;
		}
	}
	
	private void checkWinLoss() {
		
		if (cpuCards.size() == 0 && !alreadyOver) {
			alreadyOver = true;
			
			database = dbHelper.getWritableDatabase();
			dbHelper.updateWon(database, difficulty+1);
			dbHelper.updateCompleted(database, difficulty+1);
			toast.cancel();
			
			LayoutInflater inflator = getLayoutInflater();
			View view = inflator.inflate(playerCards.get(0).get(0), null, true);
			setContentView(view);
			
			((RelativeLayout) view).addView(gameover, new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			TextView over = (TextView) findViewById(R.id.gameoverLabel);
			over.setText(R.string.win);
			over.setTextColor(Color.GREEN);
			
			gameStatsDifficulty();
			
			String stats = dbHelper.getStats(database, difficulty + 1);
			showStats(stats);			
			
			view.setClickable(false);			
		}
		
		else if (playerCards.size() == 0 && !alreadyOver){
			alreadyOver = true;
			
			database = dbHelper.getWritableDatabase();
			dbHelper.updateCompleted(database, difficulty+1);
			toast.cancel();
			
			LayoutInflater inflator = getLayoutInflater();
			View view = inflator.inflate(cpuCards.get(cpuCards.size()-1).get(0), null, true);
			setContentView(view);
			
			((RelativeLayout) view).addView(gameover, new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			TextView over = (TextView) findViewById(R.id.gameoverLabel);
			over.setText(R.string.lose);
			over.setTextColor(Color.RED);
			
			gameStatsDifficulty();
			
			String stats = dbHelper.getStats(database, difficulty + 1);
			showStats(stats);
			
			view.setClickable(false);
		}
		
	}

	private void gameStatsDifficulty() {
		TextView dif = (TextView) findViewById(R.id.gameStatsDifficulty);
		switch (difficulty) {
			case 0: dif.setText("Easy");
				break;
			case 1: dif.setText("Normal");
				break;
			case 2: dif.setText("Hard");
				break;
		}
		
	}

	private void showStats(String stats) {
		TextView gamesPlayedView = (TextView) findViewById(R.id.gamesPlayed);
		TextView gamesWonView = (TextView) findViewById(R.id.gamesWon);
		TextView winningPercentageView = (TextView) findViewById(R.id.winningPercentage);
		
		int splitIndex = stats.indexOf(":");
				
		int gamesPlayed = Integer.parseInt(stats.substring(0, splitIndex));
		int gamesWon = Integer.parseInt(stats.substring(splitIndex+1));;
		int winPerc = Math.round(((float) gamesWon)/((float) gamesPlayed)*100);
		
		gamesPlayedView.setText("Games Completed: " + gamesPlayed);
		gamesWonView.setText("Games Won: " + gamesWon);
		winningPercentageView.setText("Winning Percentage: " + winPerc + "%");
		
	}
	
	public void hideInstructions(View v){
		setContentView(previousView);
	}
	
	public void newGame(View v){
		this.finish();
		Intent intent = new Intent(this, StartGame.class);
	    this.startActivity(intent);
	}
	
	public void quit(View v){
		this.finish();
	}
	
	private final int[] meanValues = new int[]{1954, 178, 177, 124, 4555, 7};
	private final int[] maxValues = new int[]{1907, 302, 380, 279, 7100, 12};
	
	public static ArrayList<ArrayList<Integer>> playerCards;
	public static ArrayList<ArrayList<Integer>> cpuCards;
	public static int difficulty;
	
	private ArrayList<Integer> characteristicIndexArray = new ArrayList<Integer>();
	
	private ArrayList<ArrayList<Integer>> stackCards;
	private boolean cpuTurn = false;
	private boolean cpuRedYellow = false;
	private boolean playerRedYellow = false;
	private boolean alreadyOver = false;
	
	private int i;
	private int previousView = -1;
	
	private View currentView;
	private View buttons;
	private View gameover;
	private LayoutInflater linflater;
	private Toast toast;
	private String toastMessage = null;
	private Handler mHandler = new Handler();
	
	private SQLiteHelper dbHelper;
	private SQLiteDatabase database;
}
