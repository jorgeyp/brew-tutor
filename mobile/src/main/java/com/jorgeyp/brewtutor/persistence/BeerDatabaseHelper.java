package com.jorgeyp.brewtutor.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jorge on 15/4/15.
 */
public class BeerDatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Beer.db";

    public BeerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BeerDatabaseContract.SQL_CREATE_ENTRIES);

        long newRowId;
        // Initial values insertion, TODO move this to assets. See further info: http://stackoverflow.com/a/6081052/2563749
        ContentValues values = new ContentValues();
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_BEER_ID, "0");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_NAME, "Light Lager");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_STYLE, "Lager");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_ABV, "3.4");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_IBU, "9.4");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_EBC, "5.5");
        newRowId = db.insert(BeerDatabaseContract.Beer.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_BEER_ID, "1");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_NAME, "European Lager");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_STYLE, "Lager");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_ABV, "4.6");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_IBU, "25.7");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_EBC, "5.6");
        newRowId = db.insert(BeerDatabaseContract.Beer.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_BEER_ID, "2");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_NAME, "Spring Beer");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_STYLE, "Ale");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_ABV, "4.5");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_IBU, "34.6");
        values.put(BeerDatabaseContract.Beer.COLUMN_NAME_EBC, "9.3");
        newRowId = db.insert(BeerDatabaseContract.Beer.TABLE_NAME, null, values);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(BeerDatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
