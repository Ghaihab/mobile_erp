package com.example.os;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ERB.db";
    private static final int DATABASE_VERSION = 1;

    ////////////////////////////////////// Employee Table /////////////////////////////////////////
    private static final String TABLE1_NAME = "Employee";
    private static final String COLUMN_E_ID = "eid";
    private static final String COLUMN_SSN = "ssn";
    private static final String COLUMN_SEX = "sex";
    private static final String COLUMN_RATE = "rate";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_ATTENDANCE = "attendance";
    private static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STREET = "street";
    private static final String COLUMN_ZIP_CODE = "zip_code";
    private static final String COLUMN_E_USERNAME = "user_name";
    private static final String COLUMN_E_PASSWORD = "pass_word";

    ////////////////////////////////////// DEPARTMENT Table /////////////////////////////////////////
    private static final String TABLE2_NAME = "Department";
    private static final String COLUMN_D_ID = "did";
    private static final String COLUMN_D_NAME = "d_name";
    private static final String COLUMN_MGR_ID = "mgr_id";

    ////////////////////////////////////// CERTIFICATE Table /////////////////////////////////////////
    private static final String TABLE3_NAME = "Certificate";
    private static final String COLUMN_C_ID = "cid";
    private static final String COLUMN_E_ID_FK = "eid";
    private static final String COLUMN_FILE_NAME = "file_name";
    private static final String COLUMN_FILE_TYPE = "file_type";

    //////////////////////////////////////////////

    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_EMPLOYEE = "CREATE TABLE " + TABLE1_NAME + "("
                + COLUMN_E_ID + " TEXT PRIMARY KEY, "
                + COLUMN_SSN + " TEXT, "
                + COLUMN_SEX + " TEXT, "
                + COLUMN_RATE + " TEXT, "
                + COLUMN_PHONE_NUMBER + " TEXT, "
                + COLUMN_FIRST_NAME + " TEXT, "
                + COLUMN_LAST_NAME + " TEXT, "
                + COLUMN_ATTENDANCE + " TEXT, "
                + COLUMN_DATE_OF_BIRTH + " TEXT, "
                + COLUMN_CITY + " TEXT, "
                + COLUMN_STREET + " TEXT, "
                + COLUMN_ZIP_CODE + " TEXT, "
                + COLUMN_E_USERNAME + " TEXT, "
                + COLUMN_E_PASSWORD + " TEXT "
                + ")";
        /*
        String CREATE_TABLE_DEPARTMENT = "CREATE TABLE " + TABLE2_NAME + "("
                + COLUMN_D_ID + " TEXT PRIMARY KEY, "
                + COLUMN_D_NAME + " TEXT, "
                + COLUMN_MGR_ID + " TEXT, "
                +
                "FOREIGN KEY(COLUMN_MGR_ID) REFERENCES TABLE1_NAME(COLUMN_E_ID) "
                + ")";

        String CREATE_TABLE_CERTIFICATE = "CREATE TABLE " + TABLE3_NAME + "("
                + COLUMN_C_ID + " TEXT PRIMARY KEY,"
                + COLUMN_E_ID_FK + " TEXT,"
                + COLUMN_FILE_NAME + " TEXT,"
                + COLUMN_FILE_TYPE + " TEXT,"
                +
                "FOREIGN KEY(COLUMN_E_ID_FK) REFERENCES TABLE1_NAME(COLUMN_E_ID)"
                + ")";
        */

        db.execSQL(CREATE_TABLE_EMPLOYEE);

        //db.execSQL(CREATE_TABLE_DEPARTMENT);
        //db.execSQL(CREATE_TABLE_CERTIFICATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public String loadHandler() {

        String result = "";

        String query = "Select * FROM " + TABLE1_NAME;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {

            int result_0 = cursor.getInt(0);

            String result_1 = cursor.getString(1);

            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");

        }

        cursor.close();

        db.close();

        return result;

    }

    public void addHandlerEmployee(Employee emp) {

        ContentValues values = new ContentValues();

        values.put(COLUMN_E_ID, emp.getEmployee_id());
        values.put(COLUMN_SSN, emp.getSsn());
        values.put(COLUMN_SEX, emp.getSex());
        values.put(COLUMN_RATE, emp.getRate());
        values.put(COLUMN_PHONE_NUMBER, emp.getPhone_number());
        values.put(COLUMN_FIRST_NAME, emp.getFirst_name());
        values.put(COLUMN_LAST_NAME, emp.getLast_name());
        values.put(COLUMN_ATTENDANCE, emp.getAttendance());
        values.put(COLUMN_DATE_OF_BIRTH, emp.getDate_of_birth());
        values.put(COLUMN_CITY, emp.getCity());
        values.put(COLUMN_STREET, emp.getStreet());
        values.put(COLUMN_ZIP_CODE, emp.getZip_code());
        values.put(COLUMN_E_USERNAME, emp.getUsername());
        values.put(COLUMN_E_PASSWORD, emp.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE1_NAME, null, values);

        db.close();

    }

    public Employee getUser(String username, String password) {

        String query = "Select * FROM " + TABLE1_NAME + " WHERE " + COLUMN_E_USERNAME + " = '" + username + "' " + " AND " + COLUMN_E_PASSWORD + " = '" + password + "'" ;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Employee emp = new Employee();

        if (cursor.moveToFirst()) {

            cursor.moveToFirst();

            emp.setEmployee_id(cursor.getString(0));
            emp.setSsn(cursor.getString(1));
            emp.setSex(cursor.getString(2));
            emp.setRate(cursor.getString(3));
            emp.setPhone_number(cursor.getString(4));
            emp.setFirst_name(cursor.getString(5));
            emp.setLast_name(cursor.getString(6));
            emp.setAttendance(cursor.getString(7));
            emp.setDate_of_birth(cursor.getString(8));
            emp.setCity(cursor.getString(9));
            emp.setStreet(cursor.getString(10));
            emp.setZip_code(cursor.getString(11));
            emp.setUsername(cursor.getString(12));
            emp.setPassword(cursor.getString(13));

            cursor.close();

        } else {

            emp = null;

        }

        db.close();

        return emp;

    }

    public ArrayList<Employee> findHandlerEmployeeByID(String eid) {

        String query = "Select * FROM " + TABLE1_NAME + "WHERE" + COLUMN_E_ID + " = " + "'" + eid + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Employee> empList = new ArrayList<Employee>();

        if (cursor.moveToFirst()) {

            cursor.moveToFirst();

            do {

                Employee emp = new Employee();

                emp.setEmployee_id(cursor.getString(0));
                emp.setSsn(cursor.getString(1));
                emp.setSex(cursor.getString(2));
                emp.setRate(cursor.getString(3));
                emp.setPhone_number(cursor.getString(5));
                emp.setFirst_name(cursor.getString(6));
                emp.setLast_name(cursor.getString(7));
                emp.setAttendance(cursor.getString(8));
                emp.setDate_of_birth(cursor.getString(9));
                emp.setCity(cursor.getString(10));
                emp.setStreet(cursor.getString(11));
                emp.setZip_code(cursor.getString(12));
                emp.setUsername(cursor.getString(13));
                emp.setPassword(cursor.getString(14));

                empList.add(emp);

            } while (cursor.moveToNext());

            cursor.close();

        } else {

            empList = null;

        }

        db.close();

        return empList;

    }

    public boolean deleteAll() {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE1_NAME, null, null) > 0;

    }

    public boolean deleteHandlerEmployeeByID(String eid) {

        boolean result = false;

        String query = "Select * FROM " + TABLE1_NAME + " WHERE " + COLUMN_E_ID + " = '" + eid + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Employee emp = new Employee();

        if (cursor.moveToFirst()) {

            emp.setEmployee_id(cursor.getString(0));
            emp.setSsn(cursor.getString(1));
            emp.setSex(cursor.getString(2));
            emp.setRate(cursor.getString(3));
            emp.setPhone_number(cursor.getString(5));
            emp.setFirst_name(cursor.getString(6));
            emp.setLast_name(cursor.getString(7));
            emp.setAttendance(cursor.getString(8));
            emp.setDate_of_birth(cursor.getString(9));
            emp.setCity(cursor.getString(10));
            emp.setStreet(cursor.getString(11));
            emp.setZip_code(cursor.getString(12));
            emp.setUsername(cursor.getString(13));
            emp.setPassword(cursor.getString(14));

            db.delete(TABLE1_NAME, COLUMN_E_ID + " =? ",
                    new String[]{
                            emp.getEmployee_id()
                    });

            cursor.close();

            result = true;

        }

        db.close();

        return result;

    }

    public boolean updateHandlerByID(String eid, String ssn, String sex, String rate, String did, String pn, String fn, String ln, String attendance, String dob, String city, String street, String zc, String un, String ps) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_E_ID, eid);
        values.put(COLUMN_SSN, ssn);
        values.put(COLUMN_SEX, sex);
        values.put(COLUMN_RATE, rate);
        values.put(COLUMN_PHONE_NUMBER, pn);
        values.put(COLUMN_FIRST_NAME, fn);
        values.put(COLUMN_LAST_NAME, ln);
        values.put(COLUMN_ATTENDANCE, attendance);
        values.put(COLUMN_DATE_OF_BIRTH, dob);
        values.put(COLUMN_CITY, city);
        values.put(COLUMN_STREET, street);
        values.put(COLUMN_ZIP_CODE, zc);
        values.put(COLUMN_E_USERNAME, un);
        values.put(COLUMN_E_PASSWORD, ps);

        return db.update(TABLE1_NAME, values, COLUMN_E_ID + " = " + eid, null) > 0;

    }

}

