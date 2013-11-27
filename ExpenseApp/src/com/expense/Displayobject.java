package com.expense;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;

public class Displayobject extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayobject);
        String[] date;
        String[] time;
        String[] cost;
        Bundle extras=getIntent().getExtras();
        date=extras.getStringArray("objects");
        cost=extras.getStringArray("objects2");
        time=extras.getStringArray("objects3");
        System.out.println("in the displayobect method");
            //  LinearLayout linearlayout1=(LinearLayout)findViewById(R.id.linearlayout1);
        LinearLayout linearlayout2=(LinearLayout)findViewById(R.id.linearlayout2);
        LinearLayout linearlayout3=(LinearLayout)findViewById(R.id.linearlayout3);
        
      final  TextView[] purposetext= new TextView[200];
       final  TextView[] costtext=new TextView[200];
       final  TextView[] datetext=new TextView[200];
       
        for(int i=0;i<cost.length;i++)
        {
        	System.out.println("11");
        	purposetext[i]= new TextView(this);
        	purposetext[i].setWidth(200);
        	System.out.println("22");
        	purposetext[i].setHeight(100);
        	System.out.println("33");
        	purposetext[i].setText(time[i]);
        	System.out.println("44");
        	System.out.println("55");
        	costtext[i]= new TextView(this);
        	costtext[i].setWidth(200);
        	costtext[i].setHeight(100);
        	costtext[i].setText(cost[i]);
        	System.out.println("55");
        	linearlayout2.addView(purposetext[i]);
        //	linearlayout1.addView(costtext[i]);
        	System.out.println("55");
            datetext[i]= new TextView(this);
        	datetext[i].setWidth(200);
        	datetext[i].setHeight(100);
        	datetext[i].setText(date[i]);
        	linearlayout3.addView(datetext[i]);
        }
        
}}
