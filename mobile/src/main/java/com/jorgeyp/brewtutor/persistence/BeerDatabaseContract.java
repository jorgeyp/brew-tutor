package com.jorgeyp.brewtutor.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * To access database: BeerDatabaseHelper mDbHelper = new BeerDatabaseHelper(getContext());
 *
 * Training: http://developer.android.com/training/basics/data-storage/databases.html
 */
public class BeerDatabaseContract {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Beer.TABLE_NAME + " (" +
                    Beer._ID + " INTEGER PRIMARY KEY," +
                    Beer.COLUMN_NAME_BEER_ID + TEXT_TYPE + COMMA_SEP +
                    Beer.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    Beer.COLUMN_NAME_STYLE + TEXT_TYPE + COMMA_SEP +
                    Beer.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    Beer.COLUMN_NAME_TIME + INT_TYPE + COMMA_SEP +
                    Beer.COLUMN_NAME_ABV + FLOAT_TYPE + COMMA_SEP +
                    Beer.COLUMN_NAME_IBU + FLOAT_TYPE + COMMA_SEP +
                    Beer.COLUMN_NAME_EBC + FLOAT_TYPE + 
            " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Beer.TABLE_NAME;

    // Empty constructor prevents accidental instantiation of the contract class.
    public BeerDatabaseContract() {}

    /**
     * Inner class that defines the table contents.
     */
    public static abstract class Beer implements BaseColumns {
        public static final String TABLE_NAME = "beer";
        public static final String COLUMN_NAME_BEER_ID = "beerid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_STYLE = "style";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_ABV = "abv";
        public static final String COLUMN_NAME_IBU = "ibu";
        public static final String COLUMN_NAME_EBC = "ebc";
    }
}


