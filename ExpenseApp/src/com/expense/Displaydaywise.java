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

public class Displaydaywise extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaydaywise);
        String[] purpose;
        String[] time;
        String[] cost;
        String displaydateonpage;
        Bundle extras=getIntent().getExtras();
        purpose=extras.getStringArray("purposedy");
        cost=extras.getStringArray("costdy");
        time=extras.getStringArray("timedy");
        displaydateonpage=extras.getString("displaydatedy");
        System.out.println("in the displaydaywise method");
        LinearLayout linearlayout1=(LinearLayout)findViewById(R.id.linearlayout1daywise);
        LinearLayout linearlayout2=(LinearLayout)findViewById(R.id.linearlayout2daywise);
        LinearLayout linearlayout3=(LinearLayout)findViewById(R.id.linearlayout3daywise);
        TextView displaydate=(TextView)findViewById(R.id.displaydate);
        displaydate.setText(displaydateonpage);
        System.out.println("111"); 
      final  TextView[] purposetext= new TextView[200];
       final  TextView[] costtext=new TextView[200];
       final  TextView[] timetext=new TextView[200];
       System.out.println("1111");
        for(int i=0;i<cost.length;i++)
        {
        	System.out.println("11");
        	purposetext[i]= new TextView(this);
        	purposetext[i].setWidth(200);
        	System.out.println("22");
        	purposetext[i].setHeight(100);
        	System.out.println("33");
        	purposetext[i].setText(purpose[i]);
        	System.out.println("44");
        	System.out.println("55");
        	costtext[i]= new TextView(this);
        	costtext[i].setWidth(200);
        	costtext[i].setHeight(100);
        	costtext[i].setText(cost[i]);
        	
           timetext[i]= new TextView(this);
        	timetext[i].setWidth(200);
        	timetext[i].setHeight(100);
        	timetext[i].setText(time[i]);
        	linearlayout3.addView(costtext[i]);
        	linearlayout2.addView(purposetext[i]);
        	linearlayout1.addView(timetext[i]);
        
        }
        
}}
