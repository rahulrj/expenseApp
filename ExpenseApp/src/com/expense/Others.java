package com.expense;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.database.Cursor;

public class Others extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.others);
        Button credit=(Button)findViewById(R.id.credit);
        Button debit=(Button)findViewById(R.id.debit);
        final EditText entercredit=(EditText)findViewById(R.id.entercredit);
        final EditText enterdebit=(EditText)findViewById(R.id.enterdebit);
        final SQLiteAdapter mySQLiteAdapter;
        mySQLiteAdapter= new SQLiteAdapter(this);

        credit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) 
			
			{
				 String sentercredit=entercredit.getText().toString();
			        
				 mySQLiteAdapter.openToRead();	
				 
				 Cursor cursor = mySQLiteAdapter.queueAll2(sentercredit);
			      startManagingCursor(cursor);
              if(cursor.moveToFirst())
              {
            	  do
            	  {
            	  Log.d("value",cursor.getString(4)+cursor.getString(7));
            	  }while(cursor.moveToNext());
              }
            	
			   mySQLiteAdapter.close(); 
				 
			}
		});
           
        
}}
