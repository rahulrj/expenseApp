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
import java.text.DateFormat;
import java.util.Date;

import com.expense.R;

public class debit extends Activity
{
	String recordtodelete;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debit);
        String[] names;
        String[] total;
      
        Bundle extras=getIntent().getExtras();
        names=extras.getStringArray("objectsborrow");
        total=extras.getStringArray("objects2borrow");
        final SQLiteAdapter mySQLiteAdapter;
	    
		   mySQLiteAdapter= new SQLiteAdapter(this);
	
      
              LinearLayout linearlayout1=(LinearLayout)findViewById(R.id.linearlayout1nameborrow);
        LinearLayout linearlayout2=(LinearLayout)findViewById(R.id.linearlayout2totalborrows);
        
        
      final  TextView[] namestext= new TextView[200];
       final  TextView[] totaltext=new TextView[200];
       
       
        for(int i=0;i<names.length;i++)
        {
        	namestext[i]= new TextView(this);
        	namestext[i].setWidth(200);
        	namestext[i].setId(i);
        	namestext[i].setHeight(100);
        	namestext[i].setText(names[i]);
        	totaltext[i]= new TextView(this);
        	totaltext[i].setWidth(200);
        	totaltext[i].setHeight(100);
        	totaltext[i].setText(total[i]);
        	totaltext[i].setId(i+1000);
        	linearlayout2.addView(totaltext[i]);
        	linearlayout1.addView(namestext[i]);
         }
        for( int i=0;i<names.length;i++)
        {
        	final int j=namestext[i].getId();
				
        	  namestext[j].setOnClickListener(new View.OnClickListener() {
         			public void onClick(View v) 
         			{
         				
         				  Intent myIntent = new Intent(debit.this,
         							Detailsborrow.class);
         				  myIntent.putExtra("namesendborrow", namestext[j].getText().toString());
             				System.out.println(namestext[j].getText().toString());
         				debit.this.startActivity(myIntent);
         							
         			}
        	  });
        	    final Dialog confirm=new Dialog(this);
                confirm.setContentView(R.layout.option3);
                
                for( int k=0;k<names.length;k++)
                {
                	final int l=totaltext[i].getId()-1000;
        				
                	  totaltext[l].setOnClickListener(new View.OnClickListener() {
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
        			      mySQLiteAdapter.deletec(recordtodelete);
        					// Cursor cursor = mySQLiteAdapter.queueAll16(recordtodelete);
        				
        							
        			}
        	  }); 
              
            
         }
        
}}
