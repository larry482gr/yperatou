package com.larry.yperatou2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

	public SQLiteHelper (Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate (SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(SQLiteHelper.class.getName(),
			"Upgrading database from version " + oldVersion + " to "
			+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATS);
		onCreate(db);
	}
  
	public void populateDatabase (SQLiteDatabase database) {
		Cursor allrows  = database.rawQuery("SELECT * FROM "+  TABLE_STATS, null);
		if (allrows.getCount() == 0) {
			try{
	            database.execSQL("INSERT INTO " + TABLE_STATS + "(gamesCompleted, gamesWon) VALUES(0, 0)");
	            database.execSQL("INSERT INTO " + TABLE_STATS + "(gamesCompleted, gamesWon) VALUES(0, 0)");
	            database.execSQL("INSERT INTO " + TABLE_STATS + "(gamesCompleted, gamesWon) VALUES(0, 0)");
	        } catch(Exception e) {
	            
	        }
		}
		database.close();
	}
	
	public void updateWon (SQLiteDatabase database, int id) {
		 try{
	            database.execSQL("UPDATE " + TABLE_STATS + " SET gamesWon = (gamesWon + 1) WHERE id = " + id);
	        } catch(Exception e) {
	        	
	        }
	}
	
	public void updateCompleted (SQLiteDatabase database, int id) {
		 try{
	            database.execSQL("UPDATE " + TABLE_STATS + " SET gamesCompleted = (gamesCompleted + 1) WHERE id = " + id);
	        } catch(Exception e) {
	        	
	        }
	}
	
	public String getStats (SQLiteDatabase database, int id) {
		String stats = null;
		try{
			int gamesCompleted = 0;
			int gamesWon =0;
			Cursor oneRow  = database.rawQuery("SELECT gamesCompleted, gamesWon FROM " + TABLE_STATS + " WHERE id = " + id, null);
			oneRow.moveToFirst();
			
			gamesCompleted = oneRow.getInt(0);
			gamesWon = oneRow.getInt(1);
			stats = Integer.toString(gamesCompleted) + ":" + Integer.toString(gamesWon);
			
			database.close();
		} catch(Exception e) {
			
		}
		
		return stats;
	}
	
	public static final String TABLE_STATS = "stats";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_COMPLETED = "gamesCompleted";
	public static final String COLUMN_WON = "gamesWon";

	static final String DATABASE_NAME = "stats.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "CREATE TABLE IF  NOT EXISTS "
		+ TABLE_STATS + "(" + COLUMN_ID
		+ " integer primary key autoincrement, " + COLUMN_COMPLETED
		+ " integer not null, " + COLUMN_WON
		+ " integer not null);";
}