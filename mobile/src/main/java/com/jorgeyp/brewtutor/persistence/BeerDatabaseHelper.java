package com.jorgeyp.brewtutor.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jorgeyp.brewtutor.model.Beer;

import java.util.ArrayList;
import java.util.List;

/**
 * NOTE: the database is created only once and stored in the mobile. If this is class is modified,
 * the application data has to be cleared so onCreate will be called again.
 *
 * More info: http://stackoverflow.com/a/7534025/2563749
 */
public class BeerDatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Beer.db";

    public BeerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("create", "creating db");
        db.execSQL(BeerDatabaseContract.SQL_CREATE_ENTRIES);
        insertInitialValues(db);
    }

    private void insertInitialValues(SQLiteDatabase db) {
        Log.d("inserting", "inserting values in db");
        System.out.println("test");
        long newRowId;
        // Initial values insertion, TODO move this to assets. See further info: http://stackoverflow.com/a/6081052/2563749
        ContentValues values = new ContentValues();
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BEER_ID, "0");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_NAME, "Light Lager");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_STYLE, "0");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_ABV, "3.4");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_IBU, "9.4");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_EBC, "5.5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_VOL, "9.3");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TIME, "3600000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TEMP, "65");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_VOL, "27");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_TIME, "4500000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_FERMENTATION_TIME, "604800000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_CONDITIONING_TIME, "32659200000");
        newRowId = db.insert(BeerDatabaseContract.BeerEntry.TABLE_NAME, null, values);
        Log.d("inserted ", Long.toString(newRowId));

        values = new ContentValues();
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BEER_ID, "1");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_NAME, "European Lager");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_STYLE, "0");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_ABV, "4.6");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_IBU, "25.7");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_EBC, "5.6");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_VOL, "14");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TIME, "3600000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TEMP, "65");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_VOL, "27");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_TIME, "4500000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_FERMENTATION_TIME, "604800000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_CONDITIONING_TIME, "32659200000");
        newRowId = db.insert(BeerDatabaseContract.BeerEntry.TABLE_NAME, null, values);
        Log.d("inserted ", Long.toString(newRowId));

        values = new ContentValues();
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BEER_ID, "2");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_NAME, "Spring Beer");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_STYLE, "1");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_ABV, "4.5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_IBU, "34.6");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_EBC, "9.3");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_VOL, "11.25");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TIME, "3600000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TEMP, "65");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_VOL, "27");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_TIME, "4500000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_FERMENTATION_TIME, "604800000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_CONDITIONING_TIME, "32659200000");
        newRowId = db.insert(BeerDatabaseContract.BeerEntry.TABLE_NAME, null, values);
        Log.d("inserted ", Long.toString(newRowId));

        values = new ContentValues();
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BEER_ID, "3");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_NAME, "Premium American Lager");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_STYLE, "0");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_ABV, "5.5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_IBU, "19");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_EBC, "7.4");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_VOL, "13");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TIME, "3600000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TEMP, "65");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_VOL, "27");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_TIME, "4500000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_FERMENTATION_TIME, "604800000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_CONDITIONING_TIME, "32659200000");
        newRowId = db.insert(BeerDatabaseContract.BeerEntry.TABLE_NAME, null, values);
        Log.d("inserted ", Long.toString(newRowId));

        values = new ContentValues();
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BEER_ID, "4");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_NAME, "Test beer");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_STYLE, "2");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_DESCRIPTION, "");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_TIME, "5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_ABV, "5.5");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_IBU, "19");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_EBC, "7.4");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_VOL, "13");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TIME, "10000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_MASH_TEMP, "65");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_VOL, "27");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_BOIL_TIME, "5000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_FERMENTATION_TIME, "20000");
        values.put(BeerDatabaseContract.BeerEntry.COLUMN_NAME_CONDITIONING_TIME, "20000");
        newRowId = db.insert(BeerDatabaseContract.BeerEntry.TABLE_NAME, null, values);
        Log.d("inserted ", Long.toString(newRowId));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(BeerDatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    /*
    ------------------------------------------------------------------------------------------------
    CRUD operations
    ------------------------------------------------------------------------------------------------
    */

    public List<Beer> getAllBeers() {
        List<Beer> beers = new ArrayList<Beer>();

        String query = "SELECT * FROM " + BeerDatabaseContract.BeerEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Beer beer = null;
        if (cursor.moveToFirst()) {
            do {
                beer = new Beer();
                beer.setId(cursor.getInt(1));
                beer.setName(cursor.getString(2));
                beer.setStyle(cursor.getInt(3));
                beer.setDescription(cursor.getString(4));
                beer.setTime(cursor.getInt(5));
                beer.setAbv(cursor.getFloat(6));
                beer.setIbu(cursor.getFloat(7));
                beer.setEbc(cursor.getFloat(8));
                beer.setMashVol(cursor.getFloat(9));
                beer.setMashTime(cursor.getInt(10));
                beer.setMashTemp(cursor.getInt(11));
                beer.setBoilVol(cursor.getInt(12));
                beer.setBoilTime(cursor.getInt(13));
                beer.setFermentationTime(cursor.getLong(14));
                beer.setConditioningTime(cursor.getLong(15));
                beers.add(beer);
            } while (cursor.moveToNext());
        }
        Log.d("getAllBeers()", beers.toString());

        return beers;
    }

    public List<Beer> getAllBeers(int style) {
        List<Beer> beers = new ArrayList<Beer>();

        String query = "SELECT * FROM " + BeerDatabaseContract.BeerEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Beer beer = null;
        if (cursor.moveToFirst()) {
            do {
                beer = new Beer();
                beer.setId(cursor.getInt(1));
                beer.setName(cursor.getString(2));
                beer.setStyle(cursor.getInt(3));
                beer.setDescription(cursor.getString(4));
                beer.setTime(cursor.getInt(5));
                beer.setAbv(cursor.getFloat(6));
                beer.setIbu(cursor.getFloat(7));
                beer.setEbc(cursor.getFloat(8));
                beer.setMashVol(cursor.getFloat(9));
                beer.setMashTime(cursor.getInt(10));
                beer.setMashTemp(cursor.getInt(11));
                beer.setBoilVol(cursor.getInt(12));
                beer.setBoilTime(cursor.getInt(13));
                beer.setFermentationTime(cursor.getLong(14));
                beer.setConditioningTime(cursor.getLong(15));
                if (beer.getStyle() == style)
                    beers.add(beer);
            } while (cursor.moveToNext());
        }
        Log.d("getAllBeers(" + style + ")", beers.toString());

        return beers;
    }
}
