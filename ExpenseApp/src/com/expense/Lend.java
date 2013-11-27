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

import com.expense.R;

public class Lend extends Activity
{
	    String recordtodelete;
	   
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lend);
        String[] names;
        String[] total;
      
        Bundle extras=getIntent().getExtras();
        names=extras.getStringArray("objectslend");
        total=extras.getStringArray("objects2lend");
      
              LinearLayout linearlayout1=(LinearLayout)findViewById(R.id.linearlayout1name);
        LinearLayout linearlayout2=(LinearLayout)findViewById(R.id.linearlayout2totallend);
        final SQLiteAdapter mySQLiteAdapter;
	    
		   mySQLiteAdapter= new SQLiteAdapter(this);
		
        
      final  TextView[] namestext= new TextView[200];
       final  TextView[] totaltext=new TextView[200];
       if(names.length<100)
       {
        for(int i=0;i<names.length;i++)
        {
        	namestext[i]= new TextView(this);
        	namestext[i].setWidth(200);
        	namestext[i].setId(i);
        	namestext[i].setHeight(60);
        	namestext[i].setText(names[i]);
        	
        	totaltext[i]= new TextView(this);
        	totaltext[i].setWidth(200);
        	totaltext[i].setHeight(60);
        	totaltext[i].setId(i+1000);
        	totaltext[i].setText(total[i]);
        	linearlayout2.addView(totaltext[i]);
        	linearlayout1.addView(namestext[i]);
         }
        for( int i=0;i<names.length;i++)
        {
        	final int j=namestext[i].getId();
				
        	  namestext[j].setOnClickListener(new View.OnClickListener() {
         			public void onClick(View v) 
         			{
         				
         				  Intent myIntent = new Intent(Lend.this,
         							Details.class);
         				  myIntent.putExtra("namesend", namestext[j].getText().toString());
             				
         				Lend.this.startActivity(myIntent);
         							
         			}
        	  });
         }
        final Dialog confirm=new Dialog(this);
        confirm.setContentView(R.layout.option3);
        
        for( int i=0;i<names.length;i++)
        {
        	final int j=totaltext[i].getId()-1000;
				
        	  totaltext[j].setOnClickListener(new View.OnClickListener() {
         			public void onClick(View v) 
         			{
         				confirm.show();
         		recordtodelete=	namestext[j].getText().toString();	
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
			       System.out.println(recordtodelete);  
			       mySQLiteAdapter.openToRead();
			      mySQLiteAdapter.deletea(recordtodelete);
					// Cursor cursor = mySQLiteAdapter.queueAll16(recordtodelete);
				
							
			}
	  }); 
      
       }
       else
    	   Toast.makeText(getApplicationContext(), "Cannot display more than 100 people", Toast.LENGTH_SHORT).show();
        
        
}}


































