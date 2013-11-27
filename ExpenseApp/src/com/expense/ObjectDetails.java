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
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;


public class ObjectDetails extends Activity
{
	int length;
	String recordtodelete1, recordtodelete2;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.objectdetails);

       LinearLayout linearlayout1=(LinearLayout)findViewById(R.id.linearlayoutdatelendobject);
       LinearLayout linearlayout2=(LinearLayout)findViewById(R.id.linearlayout2moneyindividualobject);
      // LinearLayout linearlayout3=(LinearLayout)findViewById(R.id.linearlayout3purpose);
       
       final  TextView[] datestext= new TextView[200];
       final  TextView[] moneytext=new TextView[200];
     //  final  TextView[] purposetext=new TextView[200];
       Bundle extras=getIntent().getExtras();
       final String names;
       names=extras.getString("namesend");
       System.out.println("the name is"+names);
      int i;
       final SQLiteAdapter mySQLiteAdapter;
       mySQLiteAdapter= new SQLiteAdapter(this);
     
       mySQLiteAdapter.openToRead();	
		 Cursor cursor = mySQLiteAdapter.queueAll19(names);
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
                /*	purposetext[i]= new TextView(this);
                	purposetext[i].setWidth(200);
                	
                	purposetext[i].setHeight(100);
                	purposetext[i].setText(cursor.getString(2));*/
                	
                	moneytext[i]= new TextView(this);
                	moneytext[i].setWidth(200);
                	moneytext[i].setHeight(100);
                	moneytext[i].setId(i+1000);
                	moneytext[i].setText(cursor.getString(1));
                	linearlayout2.addView(moneytext[i]);
                	linearlayout1.addView(datestext[i]);
                	//linearlayout3.addView(purposetext[i]);
              i++;
              length=i;
         	  }while(cursor.moveToNext());
         	  
        	  final Dialog confirm=new Dialog(this);
              confirm.setContentView(R.layout.option3);
              System.out.println("length"+length);
              for( int k=0;k<length;k++)
              {
              	final int j=moneytext[k].getId()-1000;
      				
              	  moneytext[j].setOnClickListener(new View.OnClickListener() {
               			public void onClick(View v) 
               			{
               				System.out.println(moneytext[j].getText().toString());
               				confirm.show();
               		recordtodelete1=	datestext[j].getText().toString();
               		recordtodelete2=	moneytext[j].getText().toString();	
               	     
                    
               		
              /* 				  Intent myIntent = new Intent(Lend.this,
               							Details.class);
               				  myIntent.putExtra("namesend", namestext[j].getText().toString());
                   				
               				Lend.this.startActivity(myIntent);*/
               							
               			}
              	  });
               }
        
             Button ok=(Button) confirm.findViewById(R.id.ok);
             Button cancel=(Button) confirm.findViewById(R.id.cancel);
            cancel.setOnClickListener(new View.OnClickListener() {
      			public void onClick(View v) 
      			{
      				confirm.cancel();
      /* 				  Intent myIntent = new Intent(Lend.this,
      							Details.class);
      				  myIntent.putExtra("namesend", namestext[j].getText().toString());
          				
      				Lend.this.startActivity(myIntent);*/
      							
      			}
      	  }); 
           
            ok.setOnClickListener(new View.OnClickListener() {
      			public void onClick(View v) 
      			{
      				confirm.cancel();
      			    //   System.out.println(recordtodelete);  
      			       mySQLiteAdapter.openToRead();
      			      mySQLiteAdapter.deleteh(recordtodelete1,recordtodelete2,names);
      					// Cursor cursor = mySQLiteAdapter.queueAll16(recordtodelete);
      			      Toast.makeText(getApplicationContext(), "Account updated", Toast.LENGTH_SHORT).show();
      			/*	  Intent myIntent = new Intent(Details.this,
    							Lend.class);
    				 
        				
    				Details.this.startActivity(myIntent);*/
      							
      			}
      	  }); 
        
           }
		  else
			  System.out.println("elements are not there");
       	
	    

        
        
}}
