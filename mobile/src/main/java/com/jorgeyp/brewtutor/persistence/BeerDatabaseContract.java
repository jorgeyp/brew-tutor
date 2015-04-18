package com.jorgeyp.brewtutor.persistence;

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
            "CREATE TABLE " + BeerEntry.TABLE_NAME + " (" +
                    BeerEntry._ID + " INTEGER PRIMARY KEY," +
                    BeerEntry.COLUMN_NAME_BEER_ID + TEXT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_STYLE + INT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_TIME + INT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_ABV + FLOAT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_IBU + FLOAT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_EBC + FLOAT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_MASH_VOL + FLOAT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_MASH_TIME + INT_TYPE + COMMA_SEP +
                    BeerEntry.COLUMN_NAME_MASH_TEMP + INT_TYPE +
            " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BeerEntry.TABLE_NAME;

    // Empty constructor prevents accidental instantiation of the contract class.
    public BeerDatabaseContract() {}

    /**
     * Inner class that defines the table contents.
     */
    public static abstract class BeerEntry implements BaseColumns {
        public static final String TABLE_NAME = "beer";
        public static final String COLUMN_NAME_BEER_ID = "beerid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_STYLE = "style";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_ABV = "abv";
        public static final String COLUMN_NAME_IBU = "ibu";
        public static final String COLUMN_NAME_EBC = "ebc";
        public static final String COLUMN_NAME_MASH_VOL = "mashvol";
        public static final String COLUMN_NAME_MASH_TIME = "mashtime";
        public static final String COLUMN_NAME_MASH_TEMP = "mashtemp";
//        public static final String COLUMN_NAME_GRAINS = "grains";
    }
}


