package com.expense;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class Displaymonthwise extends Activity
{
	int recordtodelete;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaymonthwise);
        String[] date;
        String[] amount;
        String displaymonthonpage;
        Bundle extras=getIntent().getExtras();
        date=extras.getStringArray("datemy");
        amount=extras.getStringArray("costmy");
        
        
        final int year;
        final int month;
        year=extras.getInt("year");
        month=extras.getInt("month");
        final SQLiteAdapter mySQLiteAdapter;
        mySQLiteAdapter= new SQLiteAdapter(this);
      
       
        displaymonthonpage=extras.getString("displaymonthmy");
        System.out.println("in the displaymonthwise method");
        LinearLayout linearlayout1=(LinearLayout)findViewById(R.id.linearlayout1monthwise);
        LinearLayout linearlayout2=(LinearLayout)findViewById(R.id.linearlayout2monthwise);
     //   LinearLayout linearlayout3=(LinearLayout)findViewById(R.id.linearlayout3daywise);
        TextView displaymonth=(TextView)findViewById(R.id.displaymonth);
        displaymonth.setText(displaymonthonpage);
        System.out.println("111"); 
      final  TextView[] datetext= new TextView[200];
       final  TextView[] amounttext=new TextView[200];
      // final  TextView[] timetext=new TextView[20];
       System.out.println("1111");
       if(date.length==0)
       {
    	   Toast.makeText(getApplicationContext(), "No Expenses this month recorded", Toast.LENGTH_SHORT).show();
       }
        for(int i=0;i<date.length;i++)
        {
        
        	datetext[i]= new TextView(this);
        	datetext[i].setWidth(200);
        	datetext[i].setId(i);
        	System.out.println("22");
        	datetext[i].setHeight(100);
        	System.out.println("33");
        	datetext[i].setText(date[i]);
        	System.out.println("44");
        	System.out.println("55");
        	amounttext[i]= new TextView(this);
        	amounttext[i].setWidth(200);
        	amounttext[i].setHeight(100);
        	amounttext[i].setText(amount[i]);
        	amounttext[i].setId(i+1000);
          //linearlayout3.addView(amounttext[i]);
        	linearlayout2.addView(amounttext[i]);
        	linearlayout1.addView(datetext[i]);
        
        }
        for( int i=0;i<date.length;i++)
        {
        	final int j=datetext[i].getId();
				
        	  datetext[j].setOnClickListener(new View.OnClickListener() {
         			public void onClick(View v) 
         			{
         				
         				  Intent myIntent = new Intent(Displaymonthwise.this,
         							DateDetails.class);
         				  myIntent.putExtra("namesend", datetext[j].getText().toString());
         				 myIntent.putExtra("month", month);
         				  myIntent.putExtra("year", year);
         						
         				Displaymonthwise.this.startActivity(myIntent);
         							
         			}
        	  });
        }
        
        final Dialog confirm=new Dialog(this);
        confirm.setContentView(R.layout.option3);
        
       for( int i=0;i<date.length;i++)
        {
        	final int j=amounttext[i].getId()-1000;
				
        	  amounttext[j].setOnClickListener(new View.OnClickListener() {
         			public void onClick(View v) 
         			{
         				confirm.show();
         		recordtodelete=	Integer.parseInt(datetext[j].getText().toString());	
        				         							
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
			      mySQLiteAdapter.deletee(Integer.toString(recordtodelete),Integer.toString(month),Integer.toString(year));
					// Cursor cursor = mySQLiteAdapter.queueAll16(recordtodelete);
				
							
			}
	  }); 
      
    
        
}}
