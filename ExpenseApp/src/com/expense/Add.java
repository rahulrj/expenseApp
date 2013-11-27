package com.expense;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.expense.ExpenseAppActivity.listener;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;

public class Add extends Activity
{
	int i;
	String TAG1="HI THERE";
	ListView modeList;
	String purp,purp1,purp2;
	AlertDialog.Builder builder1,builder2;
	   AlertDialog.Builder alert2,alert3;
	    Button dat,tim;;
	AlertDialog alert;
	Dialog dialog;
	 EditText input,input2;
	 char[] s=new char[20];
	 char[] p=new char[20];
	 EditText namel, amountl, nameb, amountb,purposem,amountm;
	int year,month,date;
	String currentTime, currentDate, currentDateandTime; 
     SQLiteAdapter mySQLiteAdapter;
     final String sharewithpeople[]=new String[10];
     final int rupeeswithpeople[]=new int[10];
     EditText amount;
     int option;
	Button buttonn,sharewith;
	EditText money;
	Button purpose;
	 private SpeechRecognizer sr1,sr2,sr3,sr4,sr5;
	 int a,b,c,d,e,f;
	 int finale;
	 int j=0;
	Button save;
int isshare=0;
	String[] aname,amoney;
	  Dialog dialog2;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        String items[]={"LEND" , "BORROW" , "MUTUAL EXPENSE"};
      //   lends={"NAME","PURPOSE","AMOUNT"};
        Log.d("anshul","1");
        dialog=new Dialog(this);
        dialog.setContentView(R.layout.option);
        dialog.show();
        final ListView list=(ListView) dialog.findViewById(R.id.sampleListView);
      //  mylist=(ListView)findViewById(R.id.multipurpose);
        final LinearLayout mylist=(LinearLayout)findViewById(R.id.multipurpose);
        namel= new EditText(this);
        amountl= new EditText(this);
        namel.setHeight(80);
        namel.setWidth(150);
        namel.setHintTextColor(Color.CYAN);
        nameb= new EditText(this);
        amountb= new EditText(this);
        amountm= new EditText(this);
        purposem= new EditText(this);
        namel.setBackgroundColor(Color.TRANSPARENT);
        namel.setHint("NAME");
        amountl.setBackgroundColor(Color.TRANSPARENT);
        amountl.setHint("AMOUNT");
        nameb.setBackgroundColor(Color.TRANSPARENT);
        nameb.setHint("NAME");
        amountb.setBackgroundColor(Color.TRANSPARENT);
        amountb.setHint("AMOUNT");
        purposem.setBackgroundColor(Color.TRANSPARENT);
        purposem.setHint("PURPOSE");
        amountm.setBackgroundColor(Color.TRANSPARENT);
        amountm.setHint("AMOUNT");
       
        Log.d("anshul","1");
        list.setBackgroundColor(Color.LTGRAY);
        list.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items));
     final   EditText a1 = new EditText(this);
        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
              String selectedFromList = (String) (list.getItemAtPosition(myItemInt));
              Log.d("anshul",selectedFromList);
              dialog.cancel();
              if(selectedFromList=="LEND")
              {
            	  option =1;
            	 mylist.addView(namel);
            	 mylist.addView(amountl);
              }
         
                           if(selectedFromList=="BORROW")
                           {
                        	   option =2;
                        	   mylist.addView(nameb);
                          	 mylist.addView(amountb);  	   
                           }
            
              if(selectedFromList=="MUTUAL EXPENSE")
              {
            	  sharewith.setVisibility(View.VISIBLE);
            	  option=3;
            	  mylist.addView(purposem);
             	 mylist.addView(amountm);
              }
              
            }                 
      });
        Log.d("anshul","1");
        
        
              Log.d("hi there","in on create of add");
        
        for(int i=0;i<20;i++)
        {
        	p[i]=' ';
        		s[i]=' ';
        }
        
        Log.d("dekho",s.toString());
        Log.d("dekhte raho",p.toString());
    
        
        modeList= new ListView(this);
        builder1 = new AlertDialog.Builder(this);
        builder2 = new AlertDialog.Builder(this);
        a=b=c=d=e=f=0;
        
        buttonn=(Button)findViewById(R.id.buttonr);
         Log.d("wait", "see");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdtf = new SimpleDateFormat("yyyy-MM-dd     HH:mm:ss");
        
        System.out.println(sdf);
        Log.d("waited", "seen");
        currentDate = sdf.format(new Date());
       currentTime = stf.format(new Date());
        currentDateandTime=sdtf.format(new Date());
       Date d=new Date();
       System.out.println();
        System.out.println("anshul"+d);
          year=d.getYear();
          month=d.getMonth();
         date=d.getDate();
        
      // dialog=new Dialog(this);
 
        final TextView currenttime=(TextView)findViewById(R.id.currenttime);
        final TextView currentdate=(TextView)findViewById(R.id.currentdate);
        
        final Dialog time =new Dialog(this);
        final Dialog dateshow=new Dialog(this);
       time.setContentView(R.layout.time);
       dateshow.setContentView(R.layout.date);
        final DatePicker datepicker=(DatePicker)dateshow.findViewById(R.id.datePicker1);
        final TimePicker timepicker=(TimePicker)time.findViewById(R.id.timePicker1);
        Button dateok=(Button) dateshow.findViewById(R.id.dateok);
        Button timeok=(Button) time.findViewById(R.id.timeok);
       // datepicker.setVisibility(View.INVISIBLE);
        //timepicker.setVisibility(View.INVISIBLE);
        
        currenttime.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		//timepicker.setVisibility(View.VISIBLE);
				time.show();
		
			}
		});
        currentdate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		//datepicker.setVisibility(View.VISIBLE);
		dateshow.show();
			}
		});
        dateok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		//timepicker.setVisibility(View.VISIBLE);
				  dateshow.cancel();
		        Integer dobYear = datepicker.getYear();
		        System.out.println(dobYear);
		        year=dobYear-1900;
		        Integer dobMonth = datepicker.getMonth()+1;
		        System.out.println(dobMonth);
		        month=dobMonth-1;
		        Integer dobDate = datepicker.getDayOfMonth();
		        System.out.println(dobDate);
		        date=dobDate;
		        StringBuilder sb=new StringBuilder();
		        sb.append(dobYear.toString()).append("-").append(dobMonth.toString()).append("-").append(dobDate.toString());
		        String dobStr=sb.toString();
		        System.out.println("time selected"+dobStr);
		      currentdate.setText(dobStr);
		      currentDate=dobStr;
		
			}
			
		});
        timeok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		//timepicker.setVisibility(View.VISIBLE);
			time.cancel();	  
			  Integer dobYear = timepicker.getCurrentHour();
		        Integer dobMonth = timepicker.getCurrentMinute();
		        StringBuilder sb=new StringBuilder();
		        sb.append(dobYear.toString()).append(":").append(dobMonth.toString()).append(":").append("00");
		        String dobStr=sb.toString();   		      
		currenttime.setText(dobStr);
		currentTime=dobStr;
			}
		});
        currenttime.setText(currentTime);
        currentdate.setText(currentDate);
       save=(Button)findViewById(R.id.save);
       Log.d(TAG1,"here");
       purpose=(Button)findViewById(R.id.purpose);
       money=(EditText)findViewById(R.id.money);
       Log.d(TAG1,"ERE ALSO");
         sharewith=(Button)findViewById(R.id.sharewith);
         sharewith.setVisibility(View.INVISIBLE);
         amount=(EditText)findViewById(R.id.amount);
        final Button addmoney=(Button)findViewById(R.id.addmoney);
    //   dat=(Button)findViewById(R.id.dat);
      // tim=(Button)findViewById(R.id.tim);
      
        mySQLiteAdapter= new SQLiteAdapter(this);
         i=0;
         Log.d("anshul","1"); 
        sr1 = SpeechRecognizer.createSpeechRecognizer(this);   
         
         
         //sr1.setRecognitionListener(new listener()); 
         Log.d(TAG1,"PLEASE");
         
        
        addmoney.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				sharewithpeople[i]=new String();
			sharewithpeople[i]=sharewith.getText().toString();
			System.out.println(sharewithpeople[i]);
			try
			{
			rupeeswithpeople[i]=Integer.parseInt(amount.getText().toString());
			i++;
			}
			catch(NumberFormatException nFE)
			{
			Toast.makeText(getApplicationContext(), "Enter proper money", Toast.LENGTH_SHORT).show();
			}
			}
		});
        
        Log.d(TAG1,"NO");
        
        Log.d("anshul","1");
       buttonn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				String dat1[]=new String[3];
				dat1[0]="rahul";
				dat1[1]="raja";
				dat1[2]="yez";
				func(dat1);
			}
		});
       
       
      
        
        
        
        
       sr3 = SpeechRecognizer.createSpeechRecognizer(this);
       
       
       sr5 = SpeechRecognizer.createSpeechRecognizer(this);
        
      /* currentdate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				
				
				 sr3.setRecognitionListener(new listener()); 
				func5();
				
				//func2();
				func3();
		        

				//alert2.setTitle("Title");
				//alert2.setMessage("Message");

				// Set an EditText view to get user input 
				b=1;
				
				 
				alert2.setView(input);
				alert2.show();
				
				
			}
		});*/
       
       sr4 = SpeechRecognizer.createSpeechRecognizer(this); 
       
       
      /* currenttime.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				
				sr4.setRecognitionListener(new listener()); 
				func22();
		         
				func4();
				
               c=1;
				//alert2.setTitle("Title");
				//alert2.setMessage("Message");

				// Set an EditText view to get user input 
				 
				alert3.setView(input2);
				alert3.show();
				
				
			}
		});*/
       
 
     /*  sharewith.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		        
				e=1;
				sr5.setRecognitionListener(new listener()); 
				
				func23();
				  
		         
		         
		        
				
			}
		});*/
      
      dialog2=new Dialog(this);
      dialog2.setContentView(R.layout.share);
		
       sharewith.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				try
				{
			int l=Integer.parseInt(amountm.getText().toString());
			if("".equalsIgnoreCase(purposem.getText().toString()))
				   Toast.makeText(getApplicationContext(), "Enter the purpose first", Toast.LENGTH_LONG).show();
			else
			{
				isshare=1;
				j=0;
		  dialog2.show();
				}}
				catch(NumberFormatException nFB)
				{
					   Toast.makeText(getApplicationContext(), "Enter proper money", Toast.LENGTH_LONG).show();
						
				}
		}
		});
       
       final LinearLayout name=(LinearLayout)dialog2.findViewById(R.id.name);
       final LinearLayout addmoney2=(LinearLayout)dialog2.findViewById(R.id.sharemoney);
       final EditText e1[]=new EditText[10];
       final EditText e2[]=new EditText[10];
      e1[0]=new EditText(this);
      e2[0]=new EditText(this);
      e1[0].setHeight(40);
      e2[0].setHeight(40);
      e1[0].setWidth(50);
      e2[0].setWidth(60);
      System.out.println("a");
      name.addView(e1[0]);
      System.out.println("b");
      addmoney2.addView(e2[0]);
      System.out.println("c");
       Button addperson=(Button)dialog2.findViewById(R.id.addperson);
       Button finalise=(Button)dialog2.findViewById(R.id.finalise);
       final String nameslist[] = new String[10];
       final String moneylist[]= new String[10];
       
       
       
       
       
       
       
       
       
      addperson.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				nameslist[j]=e1[j].getText().toString();
				moneylist[j]=e2[j].getText().toString();
				System.out.println(moneylist[j]);
				System.out.println("a"+nameslist[j]);
				int l;
				try
				{
				l=Integer.parseInt(moneylist[j]);
				if("".equalsIgnoreCase(nameslist[j]))
	Toast.makeText(getApplicationContext(), "Enter name first",Toast.LENGTH_SHORT).show();
				else
				{
				j++;
				  e1[j]=create();
			      e2[j]=create();
			      e1[j].setHeight(40);
			      e2[j].setHeight(40);
			      e1[j].setWidth(50);
			      e2[j].setWidth(60);
			    
			      name.addView(e1[j]);
			      
			      addmoney2.addView(e2[j]);
				} 
				}
				catch(NumberFormatException nFE)
				{
				Toast.makeText(getApplicationContext(), "Enter proper money first",Toast.LENGTH_SHORT).show();
				}
			}
			
       });
    
      finalise.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				int l;
				
				nameslist[j]=e1[j].getText().toString();
				moneylist[j]=e2[j].getText().toString();
				try
				{
				l=Integer.parseInt(moneylist[j]);
			if("".equalsIgnoreCase(nameslist[j]))
				Toast.makeText(getApplicationContext(), "Enter name first",Toast.LENGTH_SHORT).show();
			else
			{
				System.out.print(Integer.toString(j));
				System.out.println("hello");
				aname=new String[j+1];
				amoney=new String[j+1];
				System.out.println("value of j"+j);
				//System.out.println(aname[0]);
				for(int w=0;w<=j;w++)
				{
					System.out.print("name"+nameslist[w]);
					System.out.print("money"+moneylist[w]);
				aname[w]=nameslist[w];
				amoney[w]=moneylist[w];
				}
			finale=j;
				System.out.println("hello"+finale);
			System.out.println("hello");
				dialog2.dismiss();
				j=0;
			}
				}
				catch(NumberFormatException nFE)
				{
					Toast.makeText(getApplicationContext(), "Enter proper money first",Toast.LENGTH_SHORT).show();
										
				}
			}
			
      });
      
      
       
       sr2 = SpeechRecognizer.createSpeechRecognizer(this); 

       purpose.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				
				
				final CharSequence[] items = {"lend","borrow","Any Other"};

				//AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder2.setTitle("Pick a color");
				builder2.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				        if(item==0)
				        {
				        	purpose.setText("Lend");
				        	alert.dismiss();
				        	a=1;
				        	 sr2.setRecognitionListener(new listener()); 
				        	 func2();
				        	
				        	
				        }
				        else if(item==1)
				        {
				        	purpose.setText("borrow");
				        	alert.dismiss();
				        	a=1;
				        	 sr2.setRecognitionListener(new listener()); 
				        	 func2();
				        }
				        else
				        {
				        	String [] it={"hi","lays 40","anu 30"};
				        	purpose.setText("");
				        	alert.dismiss();
				        	a=1;
				        	 sr2.setRecognitionListener(new listener()); 
				        	 Log.d(TAG1,"no error");
				        	// func(it);
				        	
				        	 func2();
				        	
				        }
				    }
				});
				
				 alert = builder2.create();
				
				alert.show();
			}
		});
        
    
    	
    	Log.d(TAG1,"HELP");

        
        save.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(option==1)
				{
				String ll=amountl.getText().toString();
				int lll;
			try
			{
				lll=Integer.parseInt(ll);
				save();
				
			}
			catch(NumberFormatException nFE)
			{
				Toast.makeText(getApplicationContext(), "Enter proper money", Toast.LENGTH_SHORT).show();
						
			}}
				else	if(option==2)
				{
				String ll=amountb.getText().toString();
				int lll;
			try
			{
				lll=Integer.parseInt(ll);
				save();
				
			}
			catch(NumberFormatException nFE)
			{
				Toast.makeText(getApplicationContext(), "Enter proper money", Toast.LENGTH_SHORT).show();
						
			}}
		
				else	if(option==3)
				{
				System.out.println("in the option 3");
				String ll=amountm.getText().toString();
			
				
				int lll;
			try
			{
				System.out.println(ll);
				
				lll=Integer.parseInt(ll);
				save();
				
			}
			catch(NumberFormatException nFE)
			{
				Toast.makeText(getApplicationContext(), "Enter proper money ", Toast.LENGTH_SHORT).show();
						
			}
			
		
				}
		
				else
				{
					Toast.makeText(getApplicationContext(), "Select proper choice first ", Toast.LENGTH_SHORT).show();
				dialog.show();						
				}
		
			/*if(lll>0 && lll<100000)
				save();
			else
				Toast.makeText(getApplicationContext(), "Enter proper money", Toast.LENGTH_SHORT).show();*/
			}
		});

}
	

	
	 public void onStart()
	  {
		  super.onStart();
		  Log.d(TAG1,"In the onStart() event");
		 
	  }
	
	 public void onResume()
	  {
		  super.onResume();
		  
		  Log.d(TAG1,"In the onResume() event");
	  }
	 public void onStop()
	  {
		  super.onStop();
		  Log.d(TAG1,"In the onStop() event");
		  //sr2.stopListening();
		  sr2.destroy();
		  
		  //sr3.stopListening();
		  sr3.destroy();
		  
		  //sr4.stopListening();
		  sr4.destroy();
		  sr5.destroy();
	  }
	 public void onPause()
	  {
		  super.onPause();
		  Log.d(TAG1,"In the onPause() event");
		  
		 // sr2.stopListening();
		  sr2.destroy();
		  
		  //sr3.stopListening();
		  sr3.destroy();
		  
		  //sr4.stopListening();
		  sr4.destroy();
		  sr5.destroy();
	  }



	  
    class listener implements RecognitionListener          
    {
             public void onReadyForSpeech(Bundle params)
             {
                      Log.d(TAG1, "onReadyForSpeech");
                    save.setText("hi");
             }
             public void onBeginningOfSpeech()
             {
                      Log.d(TAG1, "onBeginningOfSpeech");
                     //purpose.setText("1");
             }
             public void onRmsChanged(float rmsdB)
             {
                      Log.d(TAG1, "onRmsChanged");
                   // money.setText("2");
             }
             public void onBufferReceived(byte[] buffer)
             {
                      Log.d(TAG1, "onBufferReceived");
                      //mText4.setText("3");
             }
             public void onEndOfSpeech()
             {
                      Log.d(TAG1, "onEndofSpeech");
             }
             public void onError(int error)
             {
                      Log.d(TAG1,  "error " +  error);
                      save.setText("error " + error);
             }
             public void onResults(Bundle results)                   
             {
                      String str = new String();
                     
                      Log.d(TAG1, "onResults " + results);
                      ArrayList data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                      final String dat[]=new String[data.size()];
                      for (int i = 0; i < data.size(); i++)
                      {
                     	
                     	 Log.d(TAG1, "result " + data.get(i));
                                
                                dat[i]=(String) data.get(i);
                                str += data.get(i);
                      }
                      
                     
                      
                     
                     
                      
                     
                      Log.d("value of b",Integer.toString(b));
                     if(a==1)
                     {
                    	 Log.d("rahul","here a is 1");
                     
                    	 a=0;
                     func(dat);
                     }
                     else if(b==1)
                     {
                    	 Log.d("rahul","ulu");
                    	input.setText(dat[0]); 
                    	b=0;
                     }
                     
                     else if(c==1)
                     {
                    	 input2.setText(dat[0]);
                    	 c=0;
                    	 
                     }
                     else if(e==1)
                     {
                    	sharewith.setText(dat[0]);
                    	e=0;
                     }
                     // mText.setText("results: "+String.valueOf(data.size()));  
                     /* builder.setTitle("Pick a color");
                 	 
                 	 builder.setItems(dat, new DialogInterface.OnClickListener() {
                 		    public void onClick(DialogInterface dialog, int item) {
                 		        Toast.makeText(getApplicationContext(), dat[item], Toast.LENGTH_SHORT).show();
                 		    }
                 		});*/
                 		//AlertDialog alert = builder.create();
                    save.setText("results: "+str);  
                    
                      //mText2.setText(dat[0]);
             }
             public void onPartialResults(Bundle partialResults)
             {
                      Log.d(TAG1, "onPartialResults");
             }
             public void onEvent(int eventType, Bundle params)
             {
                      Log.d(TAG1, "onEvent " + eventType);
             }
             
            
   
}
    
    
     void func(final String dat[])
    {
    	/* ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,dat);
    	 
   Log.d("rahul","1");
    	 modeList.setAdapter(modeAdapter);
Log.d("rahul","2");
       	builder1.setView(modeList);
       	Log.d("rahul","3");
       dialog = builder1.create();
       

       	dialog.show();*/
    	  
    	// a=0;
    	 AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	 builder.setTitle("Pick a color");
    	 builder.setItems(dat, new DialogInterface.OnClickListener() {
    	     public void onClick(DialogInterface dialog, int item) {
    	         Toast.makeText(getApplicationContext(), dat[item], Toast.LENGTH_SHORT).show();
    	         purp=dat[item];
    	         Log.d("rahul",purp);
    	         for(int i=0;i<purp.length();i++)
    	         {
    	        	 if(Character.isLetter(purp.charAt(i)))
    	        	 {
    	        		 
    	        		 s[i]=purp.charAt(i);
    	        		 Log.d("rahul",s.toString());
    	        	 }
    	        	 
    	        	 else if(Character.isDigit(purp.charAt(i)))
    	        		 
    	        	 {
    	        		 p[i]=purp.charAt(i);
    	        		 Log.d("rahul",p.toString());
    	        		 
    	        		 
    	        	 }
    	        	 else if(Character.isSpace(purp.charAt(i)))
    	        	 {
    	        		 
    	        	 }
    	         }
    	         alert.dismiss();
    	         
    	         String l=new String(s);
    	    	 String m=new String(p);
    	    	 
    	    
    	        
    	     }
    	 });
    	 AlertDialog alert = builder.create();
    	 alert.show();
    	 
    	
    	 
    	 
       	
       	
       	
       	
      
       	
/*alert.setOnDismissListener(new OnDismissListener() {

       	    
			@Override
			public void onDismiss(DialogInterface dialog) {
				// TODO Auto-generated method stub
				
				purpose.setText("rahul raja");
				Log.d(TAG1,"RAHUL RAJA");
				
				
				
			}
       	});*/
       	
       	    }
     
    void func2()
    {
    	Log.d(TAG1,"NO");
    	 Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

	        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
	             sr2.startListening(intent);
	             Log.i("111111","11111111");
    }
    
    
    
    void func22()
    {
    	Log.d(TAG1,"NO");
    	 Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

	        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
	             sr4.startListening(intent);
	             Log.i("111111","11111111");
    }
    
    void func23()
    {
    	Log.d(TAG1,"NO");
    	 Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

	        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
	             sr5.startListening(intent);
	             Log.i("111111","11111111");
    }
    
    
    

void func3()
{
	 alert2 = new AlertDialog.Builder(this);
     input = new EditText(this);
      
}

void func4()
{
	alert3 = new AlertDialog.Builder(this);
    input2 = new EditText(this);
}

void func5()
{
	 
	 Log.d(TAG1,"NO");
	 Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
             sr3.startListening(intent);
             Log.i("111111","11111111");
}


void save()
{
    StringBuilder sb=new StringBuilder();
    sb.append(currentDate).append("    ").append(currentTime);
    currentDateandTime=sb.toString();
		mySQLiteAdapter.openToWrite();
	Log.d("see", "after");
	
	if(option==1)
	{
		if("".equalsIgnoreCase(namel.getText().toString()))
		{
			Toast.makeText(getApplicationContext(), "Enter proper name",Toast.LENGTH_SHORT).show();
		    
		}
		else
		{
			System.out.println(currentTime);
			
			final String nametolend=namel.getText().toString();
			final String moneytolend=amountl.getText().toString();
			 mySQLiteAdapter.insert(year+1900, month+1, date, "lend", Integer.parseInt(moneytolend), nametolend,Integer.parseInt(moneytolend),currentTime,currentDateandTime);
			   mySQLiteAdapter.close();
			   Toast.makeText(getApplicationContext(), "Account updated successfully", Toast.LENGTH_LONG).show();
	namel.setText("");
	amountl.setText("");
	
		}
			
	}
	else if(option==2)
	{
		if("".equalsIgnoreCase(nameb.getText().toString()))
		{
			Toast.makeText(getApplicationContext(), "Enter proper name",Toast.LENGTH_SHORT).show();
		    	
		}
		   else
		   {
			   final String nametoborrow=nameb.getText().toString();
				final String moneytoborrow=amountb.getText().toString();
				 mySQLiteAdapter.insert(year+1900, month+1, date, "borrow", Integer.parseInt(moneytoborrow), nametoborrow,Integer.parseInt(moneytoborrow),currentTime,currentDateandTime);
				   Toast.makeText(getApplicationContext(), "Account updated successfully", Toast.LENGTH_LONG).show();
							   mySQLiteAdapter.close();
							   nameb.setText("");
								amountb.setText("");
														   
							   
				
		   }
			   
	
	}
	else if(option ==3)
	{
		
	
		final String purposems=purposem.getText().toString();
	    final String amountms=amountm.getText().toString();
	    
	    if("".equalsIgnoreCase(purposem.getText().toString()))
	    	Toast.makeText(getApplicationContext(), "Enter proper purpose",Toast.LENGTH_SHORT).show();
	    else
	    {
	    int mine=0;
	    if(isshare==1)
	    {
	    	System.out.println("In share method");
	    	System.out.println(finale);
	    for(int w=0;w<=finale;w++)
	    {
	    	System.out.println(aname[w]);
	    	System.out.println(amoney[w]);
	     mySQLiteAdapter.insert(year+1900, month+1, date, purposems, Integer.parseInt(amountms), aname[w], Integer.parseInt(amoney[w]),currentTime,currentDateandTime);
	    mine=mine+Integer.parseInt(amoney[w]);
	   System.out.println(mine);
	    	
	}
	int mymoneyfinal=    Integer.parseInt(amountms)-mine;
	System.out.println("updating");
	System.out.println(purposems);
	System.out.println(mymoneyfinal);
	if(mymoneyfinal<0)
	{
		Toast.makeText(getApplicationContext(), "Shared amount exceeds your spend amount",Toast.LENGTH_SHORT).show();
 dialog2.show();
	}
	else
	{
	mySQLiteAdapter.insert(year+1900, month+1, date, purposems, Integer.parseInt(amountms), "me", mymoneyfinal,currentTime,currentDateandTime);
	   Toast.makeText(getApplicationContext(), "Account updated successfully", Toast.LENGTH_LONG).show();
	   purposem.setText("");
		amountm.setText("");
	
	
	}
	    }
	    else
	    {
	    	System.out.println("lets check year"+year+"month"+month+"date"+date);
	    	
	    	mySQLiteAdapter.insert(year+1900, month+1, date, purposems, Integer.parseInt(amountms), "me",Integer.parseInt(amountms) ,currentTime,currentDateandTime);
	    	   Toast.makeText(getApplicationContext(), "Account updated successfully", Toast.LENGTH_LONG).show();
	    	   purposem.setText("");
	    		amountm.setText("");
	    		
	    }}
	}
	
}
EditText create ( )
{
	EditText e= new EditText(this);
	return e;
}
}
