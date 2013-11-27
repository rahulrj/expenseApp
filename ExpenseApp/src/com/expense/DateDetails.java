package com.expense;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;



public class DateDetails extends Activity
{
	int length,recordtodelete;
	String recordtodelete1, recordtodelete2, recordtodelete3;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datedetails);

       LinearLayout linearlayout1=(LinearLayout)findViewById(R.id.linearlayoutdatedisplay);
       LinearLayout linearlayout2=(LinearLayout)findViewById(R.id.linearlayout2moneyindividualdisplay);
       LinearLayout linearlayout3=(LinearLayout)findViewById(R.id.linearlayout2purposeindividualdisplay);
       
       final  TextView[] datestext= new TextView[200];
       final  TextView[] moneytext=new TextView[200];
       final  TextView[] purposetext=new TextView[200];
       
       Bundle extras=getIntent().getExtras();
       final String names;
       names=extras.getString("namesend");
       final int year;
       final int month;
       year=extras.getInt("year");
       month=extras.getInt("month");
       System.out.println(year+"ansh"+month);
      int i;
       final SQLiteAdapter mySQLiteAdapter;
       mySQLiteAdapter= new SQLiteAdapter(this);
     
       mySQLiteAdapter.openToRead();	
		 Cursor cursor = mySQLiteAdapter.queueAll15(names,month,year);
		  if(cursor.moveToFirst())
           {
			  i=0;
			  System.out.println("elements are there");
         	  do
         	  {
         		  	
                	datestext[i]= new TextView(this);
                	datestext[i].setWidth(200);
                	datestext[i].setId(i);
                	datestext[i].setHeight(100);
                	datestext[i].setText(cursor.getString(0));
                	moneytext[i]= new TextView(this);
                	moneytext[i].setWidth(200);
                	moneytext[i].setHeight(100);
                	moneytext[i].setId(i+1000);
                	moneytext[i].setText(cursor.getString(1));
                    
                	purposetext[i]= new TextView(this);
                	
                	purposetext[i].setWidth(200);
                	purposetext[i].setHeight(100);
                
                	purposetext[i].setText(cursor.getString(2));
                	linearlayout3.addView(purposetext[i]);
                    
                	linearlayout2.addView(moneytext[i]);
                	linearlayout1.addView(datestext[i]);
              i++;
              length=i;
         	  }while(cursor.moveToNext());
         	  
         	 final Dialog confirm=new Dialog(this);
             confirm.setContentView(R.layout.option3);
             
            for( int k=0;k<length;k++)
             {
             	final int j=moneytext[k].getId()-1000;
     				
             	  moneytext[j].setOnClickListener(new View.OnClickListener() {
              			public void onClick(View v) 
              			{
              				confirm.show();
              	recordtodelete1=	datestext[j].getText().toString();	
            	recordtodelete2=	moneytext[j].getText().toString();	
            	recordtodelete3=	purposetext[j].getText().toString();	
                				         							
              			}
             	  });
              }
       
            Button ok=(Button) confirm.findViewById(R.id.ok);
            Button cancel=(Button) confirm.findViewById(R.id.cancel);
           cancel.setOnClickListener(new View.OnClickListener() {
     			public void onClick(View v) 
     			{
     				confirm.cancel();
     										
     			}
     	  }); 
          
          ok.setOnClickListener(new View.OnClickListener() {
     			public void onClick(View v) 
     			{
     				confirm.cancel();
     			       System.out.println(recordtodelete);  
     			       mySQLiteAdapter.openToRead();
     			      mySQLiteAdapter.deletef(names,Integer.toString(month),Integer.toString(year), recordtodelete1, recordtodelete2, recordtodelete3);
     					// Cursor cursor = mySQLiteAdapter.queueAll16(recordtodelete);
     				
     							
     			}
     	  }); 

           }
		  else
			  System.out.println("elements are not there");
       	
	    

        
        
}}
