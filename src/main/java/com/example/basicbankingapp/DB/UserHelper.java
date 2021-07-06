package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7820,'JAYAKRISHNA', 'jayakrishnap05789@gmail.com','7243','7386295088', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5672,'BHARATH', 'bharth675@gmail.com','1268','9347715171', 4000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7264,'ROHAN', 'rohan123@gmail.com','8458','9492689187', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1340,'HEMANTH', 'hemanth641@gmail.com','7894','7569924208', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7028,'MADHU', 'madhu417@gmail.com','3884','7013199901', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8497,'NIKHIL', 'nikhil104@gmail.com','9675','9347991363', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3110,'CHAITANYA', 'chaitanya269@gmail.com','1569','8688479491', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'VINEETHA', 'vineetha318@gmail.com','4500','9441831257', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'AKSHITHA', 'akshitha278@gmail.com','6263','9849700705', 10700)");
        db.execSQL("insert into " + TABLE_NAME + " values(2565,'ABHISHEK', 'abhishek108@gmail.com','5698','9347322799', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7954,'AKHIL', 'akhil838@gmail.com','2454','9121525414', 8800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3841,'YASHWANTH', 'yash868@gmail.com','1309','6301600178', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'ANEESH', 'aneesh310@gmail.com','5319','7095654455', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'CHARAN', 'charan170@gmail.com','2170','7382979567', 3600)");
        db.execSQL("insert into " + TABLE_NAME + " values(7280,'ABHIRAM', 'abhiram808@gmail.com','6892','6302043325', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}