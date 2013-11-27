/*package com.expense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {

public static final String MYDATABASE_NAME = "MY_DATABASE2";
public static final String MYDATABASE_TABLE = "MY_TABLE";
public static final int MYDATABASE_VERSION = 1;
public static final String KEY_ID = "_id";
public static final String KEY_YEAR = "year";
public static final String KEY_MONTH = "month";
public static final String KEY_DATE = "date";
public static final String KEY_PURPOSE = "purpose";
public static final String KEY_MONEY = "money";
public static final String KEY_SHAREWITH = "sharewith";
public static final String KEY_AMOUNT = "amount";
public static final String KEY_DATEANDTIME = "dateandtime";


//create table MY_DATABASE (ID integer primary key, Content text not null);
private static final String SCRIPT_CREATE_DATABASE =
"create table " + MYDATABASE_TABLE + " ("
+ KEY_ID + " integer primary key autoincrement, "
+ KEY_YEAR + " integer not null,"+KEY_MONTH+" integer not null, "+KEY_DATE+" integer not null,  "+KEY_PURPOSE+"  varchar(25) ,"+KEY_MONEY+" integer not null, "+KEY_SHAREWITH+" varchar(25), "+KEY_AMOUNT+" integer not null, "+KEY_DATEANDTIME+" varchar(25) not null );";

private SQLiteHelper sqLiteHelper;
private SQLiteDatabase sqLiteDatabase;

private Context context;

public SQLiteAdapter(Context c){
context = c;
}

public SQLiteAdapter openToRead() throws android.database.SQLException {
sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
sqLiteDatabase = sqLiteHelper.getReadableDatabase();
return this;
}

public SQLiteAdapter openToWrite() throws android.database.SQLException {
sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
sqLiteDatabase = sqLiteHelper.getWritableDatabase();
return this;
}

public void close(){
sqLiteHelper.close();
}

public long insert(int year, int month, int date, String purpose, int money,String sharewith
		,int amount,String dateandtime){

ContentValues contentValues = new ContentValues();
contentValues.put(KEY_YEAR, year);
contentValues.put(KEY_MONTH, month);
contentValues.put(KEY_DATE, date);
contentValues.put(KEY_PURPOSE, purpose);
contentValues.put(KEY_MONEY,money);
contentValues.put(KEY_SHAREWITH, sharewith);
contentValues.put(KEY_AMOUNT,amount);
contentValues.put(KEY_DATEANDTIME, dateandtime);
return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
}

public int deleteAll(){
return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
}

public Cursor queueAll(String month){
String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
		KEY_SHAREWITH,KEY_AMOUNT,KEY_DATEANDTIME};
Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
  KEY_MONTH+"=?", new String[]{month} , null, null, null);

return cursor;
}

public Cursor queueAll1(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_DATEANDTIME};
	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_PURPOSE+"=?" +" and "+ KEY_SHAREWITH+"=?", new String[]{object,"me"} , null, null, null);

	return cursor;
	}
public Cursor queueAll2(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_DATEANDTIME};
	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_SHAREWITH+"=?" , new String[]{object} , null, null, null);

	return cursor;
	}



public class SQLiteHelper extends SQLiteOpenHelper {

public SQLiteHelper(Context context, String name,
  CursorFactory factory, int version) {
 super(context, name, factory, version);
}

@Override
public void onCreate(SQLiteDatabase db) {
 // TODO Auto-generated method stub
 db.execSQL(SCRIPT_CREATE_DATABASE);
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 // TODO Auto-generated method stub

}

}

}*/
package com.expense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {

public static final String MYDATABASE_NAME = "MY_DATABASE382";
public static final String MYDATABASE_TABLE = "MY_TABLE";
public static final int MYDATABASE_VERSION = 1;
public static final String KEY_ID = "_id";
public static final String KEY_YEAR = "year";
public static final String KEY_MONTH = "month";
public static final String KEY_DATE = "date";
public static final String KEY_PURPOSE = "purpose";
public static final String KEY_MONEY = "money";
public static final String KEY_SHAREWITH = "sharewith";
public static final String KEY_AMOUNT = "amount";
public static final String KEY_TIME = "time";
public static final String KEY_COMBINEDDATE = "combineddate";



//create table MY_DATABASE (ID integer primary key, Content text not null);
private static final String SCRIPT_CREATE_DATABASE =
"create table " + MYDATABASE_TABLE + " ("
+ KEY_ID + " integer primary key autoincrement, "
+ KEY_YEAR + " integer not null,"+KEY_MONTH+" integer not null, "+KEY_DATE+" integer not null,  "+KEY_PURPOSE+"  varchar(25) ,"+KEY_MONEY+" integer not null, "+KEY_SHAREWITH+" varchar(25), "+KEY_AMOUNT+" integer not null, "+KEY_TIME+" varchar(25) not null , "+KEY_COMBINEDDATE+" varchar(25) not null);";

private SQLiteHelper sqLiteHelper;
private SQLiteDatabase sqLiteDatabase;

private Context context;

public SQLiteAdapter(Context c){
context = c;
}

public SQLiteAdapter openToRead() throws android.database.SQLException {
sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
sqLiteDatabase = sqLiteHelper.getReadableDatabase();
return this;
}

public SQLiteAdapter openToWrite() throws android.database.SQLException {
sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
sqLiteDatabase = sqLiteHelper.getWritableDatabase();
return this;
}

public void close(){
sqLiteHelper.close();
}

public long insert(int year, int month, int date, String purpose, int money,String sharewith
		,int amount,String dateandtime,String combineddate){

ContentValues contentValues = new ContentValues();
contentValues.put(KEY_YEAR, year);
contentValues.put(KEY_MONTH, month);
contentValues.put(KEY_DATE, date);
contentValues.put(KEY_PURPOSE, purpose);
contentValues.put(KEY_MONEY,money);
contentValues.put(KEY_SHAREWITH, sharewith);
contentValues.put(KEY_AMOUNT,amount);
contentValues.put(KEY_TIME, dateandtime);
contentValues.put(KEY_COMBINEDDATE, combineddate);
return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
}

public int deleteAll(){
return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
}

public int deletea(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_SHAREWITH+"=?" +" and "+ KEY_PURPOSE+"=?", new String[]{object,"borrow"});
	}
public int deleteg(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_SHAREWITH+"=?" +" and "+ KEY_PURPOSE+"!=?", new String[]{"me",object});
	}


public int deletec(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_SHAREWITH+"=?" +" and "+ KEY_PURPOSE+"=?", new String[]{object,"borrow"});
	}
public int deleteb(String object1,String object2,String object3,String object4){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_COMBINEDDATE+"=?" +" and "+ KEY_AMOUNT+"=?" +" and "+ KEY_PURPOSE+"=?" +" and "+ KEY_SHAREWITH+"=?"  , new String[]{object1,object2,object3,object4});
	}

public int deleteh(String object1,String object2,String object3){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_COMBINEDDATE+"=?" +" and "+ KEY_AMOUNT+"=?" +" and "+ KEY_PURPOSE+"=?" +" and "+ KEY_SHAREWITH+"=?"  , new String[]{object1,object2,object3,"me"});
	}
public int deleted(String object1,String object2,String object3){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_COMBINEDDATE+"=?" +" and "+ KEY_AMOUNT+"=?" +"  and "+ KEY_SHAREWITH+"=?"  , new String[]{object1,object2,object3});
	}

public int deletee(String object1,String object2,String object3){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_DATE+"=?" +" and "+ KEY_MONTH+"=?" +"  and "+ KEY_YEAR+"=?" +"  and "+ KEY_SHAREWITH+"=?"  , new String[]{object1,object2,object3,"me"});
	}
public int deletef(String object1,String object2,String object3,String object4,String object5,String object6){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};

	return sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_DATE+"=?" +" and "+ KEY_MONTH+"=?" +"  and "+ KEY_YEAR+"=?" +"  and "+ KEY_SHAREWITH+"=?" +"  and "+ KEY_TIME+"=?"+"  and "+ KEY_AMOUNT+"=?"+"  and "+ KEY_PURPOSE+"=?"  , new String[]{object1,object2,object3,"me",object4,object5,object6});
	}




public Cursor queueAll(String month){
String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
		KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
  KEY_MONTH+"=?", new String[]{month} , null, null, null);

return cursor;
}

public Cursor queueAll1(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_PURPOSE+"=?" +" and "+ KEY_SHAREWITH+"=?", new String[]{object,"me"} , null, null, null);

	return cursor;
	}
public Cursor queueAll2(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_PURPOSE+"=?" + " and "+ KEY_SHAREWITH+"=?", new String[]{object,"me"} , null, null, null);

	return cursor;
	}

public Cursor queueAll3(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_TIME+"=?" + " and "+ KEY_SHAREWITH+"=?", new String[]{object,"me"} , null, null, null);

	return cursor;
	}
public Cursor queueAll4(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
/*	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_MONTH+"=?" + " and "+ KEY_SHAREWITH+"=?", new String[]{object,"me"} , null, null, null);*/
	int a=8;
	Cursor cursor=sqLiteDatabase.rawQuery("Select distinct time, sum(amount) from MY_TABLE where sharewith='me'and month="+object+" group by time", null);

	return cursor;
	}

public Cursor queueAll14(int  object, int year){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
/*	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_MONTH+"=?" + " and "+ KEY_SHAREWITH+"=?", new String[]{object,"me"} , null, null, null);*/
	int a=8;
	Cursor cursor=sqLiteDatabase.rawQuery("Select distinct date, sum(amount) from MY_TABLE where sharewith='me'and month="+object+" and year="+year+" group by date", null);

	return cursor;
	}

public Cursor queueAll6(String object){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
	  KEY_SHAREWITH+"=?", new String[]{object} , null, null, null);

	return cursor;
	}

public Cursor queueAll7(){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor=sqLiteDatabase.rawQuery("Select distinct sharewith, sum(amount) from MY_TABLE where sharewith!='me' and purpose!='borrow' group by sharewith", null);

	return cursor;
	}

public Cursor queueAll8(){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor=sqLiteDatabase.rawQuery("Select distinct sharewith, sum(amount) from MY_TABLE where purpose='borrow' group by sharewith", null);

	return cursor;
	}
public Cursor queueAll9(String object){
	
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor=sqLiteDatabase.rawQuery("Select  combineddate, amount, purpose from MY_TABLE  where sharewith='"+object+"' and purpose!='borrow'", null);

	return cursor;
	}

public Cursor queueAll15(String object1,int object2, int object3){
	
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor=sqLiteDatabase.rawQuery("Select  time, amount,purpose from MY_TABLE  where date='"+object1+"' and month='"+object2+"' and year='"+object3+"' and sharewith='me'", null);

	return cursor;
	}


public Cursor queueAll10(String object){
	
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor=sqLiteDatabase.rawQuery("Select  combineddate, amount from MY_TABLE where purpose='borrow' and sharewith='"+object+"'", null);

	return cursor;
	}

public Cursor queueAll16(String object){
	
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	System.out.println(object);
	Cursor cursor=sqLiteDatabase.rawQuery("DELETE FROM MY_TABLE where sharewith='rahul'", null);

	return cursor;
	}

public Cursor queueAll17(){
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor=sqLiteDatabase.rawQuery("Select distinct purpose, sum(amount) from MY_TABLE where sharewith='me' group by purpose", null);

	return cursor;
	}

public Cursor queueAll19(String object){
	
	String[] columns = new String[]{KEY_ID, KEY_YEAR,KEY_MONTH,KEY_DATE,KEY_PURPOSE,KEY_MONEY,
			KEY_SHAREWITH,KEY_AMOUNT,KEY_TIME,KEY_COMBINEDDATE};
	Cursor cursor=sqLiteDatabase.rawQuery("Select  combineddate, amount from MY_TABLE  where purpose='"+object+"' and sharewith='me'", null);

	return cursor;
	}


public class SQLiteHelper extends SQLiteOpenHelper {

public SQLiteHelper(Context context, String name,
  CursorFactory factory, int version) {
 super(context, name, factory, version);
}

@Override
public void onCreate(SQLiteDatabase db) {
 // TODO Auto-generated method stub
 db.execSQL(SCRIPT_CREATE_DATABASE);
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 // TODO Auto-generated method stub

}

}

}