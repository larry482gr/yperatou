package com.larry.yperatou2;

import com.larry.yperatou2.R;

import android.app.Activity;
import android.content.Intent;

public class MenuActions {
	protected static final boolean applyItemAction(Activity currentActivity, int itemID){
		switch (itemID) {
        case R.id.menu_instructions:
        	currentActivity.setContentView(R.layout.instructions);
            return true;
        case R.id.menu_restart:
        	currentActivity.finish();
            Intent intent = new Intent(currentActivity, StartGame.class);
    	    currentActivity.startActivity(intent);
    	    return true;
        case R.id.menu_quit:
        	currentActivity.finish();
        	System.exit(0);
            return true;
        default:
            return true;
		}
		
	}
}
