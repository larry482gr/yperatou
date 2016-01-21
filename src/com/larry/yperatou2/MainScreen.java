package com.larry.yperatou2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public class MainScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_screen);
		linflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		difficulty = linflater.inflate(R.layout.difficulty, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
		return MenuActions.applyItemAction(this, item.getItemId());
	}
	
	public void onBackPressed() {
		System.exit(0);
	}
	
	public void hideInstructions(View v){
		setContentView(R.layout.main_screen);
	}
	
	public void selectDifficulty(View v) {
		((RelativeLayout) v.getParent()).addView(difficulty, new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		v.setClickable(false);
		play = v;
	}
	
	public void easyGame(View v) {
		((RelativeLayout) v.getParent().getParent()).removeView(difficulty);
		play.setClickable(true);
		StartGame.difficulty = 0;
		startGame();
	}
	
	public void normalGame(View v) {
		((RelativeLayout) v.getParent().getParent()).removeView(difficulty);
		play.setClickable(true);
		StartGame.difficulty = 1;
		startGame();
	}

	public void hardGame(View v) {
		((RelativeLayout) v.getParent().getParent()).removeView(difficulty);
		play.setClickable(true);
		StartGame.difficulty = 2;
		startGame();
	}
	
	public void startGame() {
		Intent intent = new Intent(this, StartGame.class);
	    startActivity(intent);
	}
	
	public static View previousView = null;
	private LayoutInflater linflater;
	private View difficulty;
	private View play;
}
