package com.expense;

import java.util.ArrayList;
import java.util.List;

import com.expense.ExpenseAppActivity.listener;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;

public class ViewDetails extends Activity
{
	
	 private SpeechRecognizer sr,sr2,sr3,sr4,sr5;
	 String TAG="RAHUL";
	 AlertDialog.Builder alert3,alert4;
	 AlertDialog alert;
	 EditText input,input2;
	 int a,b,c;
	 int f=0;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        Button monthwise=(Button)findViewById(R.id.monthwise);
        Button objectwise=(Button)findViewById(R.id.objectwise);
        Button viewcredit=(Button)findViewById(R.id.viewcredit);
        Button viewdebit=(Button)findViewById(R.id.viewdebit);
       final SQLiteAdapter mySQLiteAdapter;
        mySQLiteAdapter= new SQLiteAdapter(this);
       System.out.println("In View Details");
        a=b=c=0;
sr = SpeechRecognizer.createSpeechRecognizer(this);  
sr2 = SpeechRecognizer.createSpeechRecognizer(this); 
sr3 = SpeechRecognizer.createSpeechRecognizer(this);
sr4 = SpeechRecognizer.createSpeechRecognizer(this);
sr5 = SpeechRecognizer.createSpeechRecognizer(this);
        
        
        sr.setRecognitionListener(new listener()); 
        
        
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
             sr.startListening(intent);
             Log.i("111111","11111111");
        
             final Dialog dialog4;
             dialog4=new Dialog(this);
             dialog4.setContentView(R.layout.enterobject);
            
              objectwise.setOnClickListener(new View.OnClickListener() {
     			public void onClick(View v) 
     			{
     			//	dialog4.show();
     		    
     			   mySQLiteAdapter.openToRead();	
 					 Cursor cursor = mySQLiteAdapter.queueAll17();
 				      startManagingCursor(cursor);
 				      List<String> zoom= new ArrayList<String>();
 				      List<String> zoom2= new ArrayList<String>();
 				     
 	              if(cursor.moveToFirst())
 	              {
 	            	  do
 	            	  {
 	           zoom.add(cursor.getString(0));
 	           zoom2.add(cursor.getString(1));
 	            	  }while(cursor.moveToNext());
 	              }
 	              String[] hello = (String[]) zoom.toArray(new String[0]);
 	              String[] hello2 = (String[]) zoom2.toArray(new String[0]);
 	      
 	         
 				   mySQLiteAdapter.close(); 
 				  Intent myIntent = new Intent(ViewDetails.this,
 							Objects.class);
 				  myIntent.putExtra("objectslend", hello);
 				  myIntent.putExtra("objects2lend", hello2);
 					ViewDetails.this.startActivity(myIntent);
	
     			}
     		});
              
    /*     Button finalise2=(Button) dialog4.findViewById(R.id.finalise2);
         final EditText enterobjecta=(EditText) dialog4.findViewById(R.id.enterobjecta);
         finalise2.setOnClickListener(new View.OnClickListener() {
  			public void onClick(View v) 
  			{
  				dialog4.cancel();
  				int check=0;
  				  String senterobject=enterobjecta.getText().toString();
  				   mySQLiteAdapter.openToRead();	
  					 Cursor cursor = mySQLiteAdapter.queueAll2(senterobject);
  				      startManagingCursor(cursor);
  				      List<String> zoom= new ArrayList<String>();
  				      List<String> zoom2= new ArrayList<String>();
  				      List<String> zoom3= new ArrayList<String>();
  	              if(cursor.moveToFirst())
  	              {
  	            	  check=1;
  	            	  do
  	            	  {
  	           zoom.add(cursor.getString(7));
  	           zoom2.add(cursor.getString(8));
  	           zoom3.add(cursor.getString(9));
  	           
  	            	  }while(cursor.moveToNext());
  	              }
  	              if(check==1)
  	              {
  	              String[] hello = (String[]) zoom.toArray(new String[0]);
  	              String[] hello2 = (String[]) zoom2.toArray(new String[0]);
  	              String[] hello3 = (String[]) zoom3.toArray(new String[0]);
  	         for(String x: hello)
              	 System.out.println("anshul"+x);

  				   mySQLiteAdapter.close(); 
  				  Intent myIntent = new Intent(ViewDetails.this,
  							Displayobject.class);
  				  myIntent.putExtra("objects", hello);
  				  myIntent.putExtra("objects2", hello2);
  				  myIntent.putExtra("objects3", hello3);
  						 
  					ViewDetails.this.startActivity(myIntent);
  	              }
  	              else
  	     Toast.makeText(getApplicationContext(), "No suitable match found", Toast.LENGTH_SHORT).show();
  				           			
  			}
  		});*/

              
              

                   final Dialog dialog3;
             dialog3=new Dialog(this);
             dialog3.setContentView(R.layout.option2);
            
               
  String items[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
         
  final ListView list=(ListView) dialog3.findViewById(R.id.monthdisplay);
	   
	  list.setBackgroundColor(Color.LTGRAY);
  list.setAdapter(new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, items));

  monthwise.setOnClickListener(new View.OnClickListener() {
      			public void onClick(View v) 
      			{
      		dialog3.show();	 		
      			}
             });
  
  final EditText readyear=(EditText) dialog3.findViewById(R.id.readyear);
 
  
  
  list.setOnItemClickListener(new OnItemClickListener() {
      public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
    
     System.out.println("selected"+myItemInt);
     dialog3.cancel();
     
		
	 // String senterobject= (String) (list.getItemAtPosition(myItemInt+1));
	  //System.out.println(senterobject);
	  int senterobject =myItemInt+1;
	   mySQLiteAdapter.openToRead();
	   int year=0;
	   try 
	   {
	 	   year=Integer.parseInt(readyear.getText().toString());
	   }
	   catch(NumberFormatException nFE)
	   {
	 	  Toast.makeText(getApplicationContext(), "Enter proper year", Toast.LENGTH_SHORT).show();
	   }
		 Cursor cursor = mySQLiteAdapter.queueAll14(senterobject, year);
	      startManagingCursor(cursor);
	      List<String> zoom= new ArrayList<String>();
	      List<String> zoom2= new ArrayList<String>();
	     
      if(cursor.moveToFirst())
      {
    	  do
    	  {
   zoom.add(cursor.getString(0));
   zoom2.add(cursor.getString(1));
   
    	  }while(cursor.moveToNext());
      }
      String[] hello = (String[]) zoom.toArray(new String[0]);
      String[] hello2 = (String[]) zoom2.toArray(new String[0]);
    for(String x:hello)
    	System.out.println(x);
	   mySQLiteAdapter.close(); 
	  Intent myIntent = new Intent(ViewDetails.this,
				Displaymonthwise.class);
	  myIntent.putExtra("datemy", hello);
	  myIntent.putExtra("costmy", hello2);
	  myIntent.putExtra("month", senterobject);
	  myIntent.putExtra("year", year);
		
		myIntent.putExtra("displaymonthmy", senterobject);	 
		ViewDetails.this.startActivity(myIntent);

      }
      });
        
             viewdebit.setOnClickListener(new View.OnClickListener() {
      			public void onClick(View v) 
      			{
      				
      				  
      				   mySQLiteAdapter.openToRead();	
      					 Cursor cursor = mySQLiteAdapter.queueAll8();
      				      startManagingCursor(cursor);
      				      List<String> zoom= new ArrayList<String>();
      				      List<String> zoom2= new ArrayList<String>();
      				     
      	              if(cursor.moveToFirst())
      	              {
      	            	  do
      	            	  {
      	           zoom.add(cursor.getString(0));
      	           zoom2.add(cursor.getString(1));
      	            	  }while(cursor.moveToNext());
      	              }
      	              String[] hello = (String[]) zoom.toArray(new String[0]);
      	              String[] hello2 = (String[]) zoom2.toArray(new String[0]);
      	         for(String x: hello)
      	         {
                  	 System.out.println("anshul"+x);
                  	 
      	         }
      	       for(String x: hello2)
    	         {
                	 System.out.println("anshul"+x);
                	 
    	         }
    			
      	         
      				   mySQLiteAdapter.close(); 
      				  Intent myIntent = new Intent(ViewDetails.this,
      							debit.class);
      				  myIntent.putExtra("objectsborrow", hello);
      				  myIntent.putExtra("objects2borrow", hello2);
      					ViewDetails.this.startActivity(myIntent);
      				           			
      			}
      		});

             viewcredit.setOnClickListener(new View.OnClickListener() {
       			public void onClick(View v) 
       			{
       				
       				  
       				   mySQLiteAdapter.openToRead();	
       					 Cursor cursor = mySQLiteAdapter.queueAll7();
       				      startManagingCursor(cursor);
       				      List<String> zoom= new ArrayList<String>();
       				      List<String> zoom2= new ArrayList<String>();
       				     
       	              if(cursor.moveToFirst())
       	              {
       	            	  do
       	            	  {
       	           zoom.add(cursor.getString(0));
       	           zoom2.add(cursor.getString(1));
       	            	  }while(cursor.moveToNext());
       	              }
       	              String[] hello = (String[]) zoom.toArray(new String[0]);
       	              String[] hello2 = (String[]) zoom2.toArray(new String[0]);
       	      
       	         
       				   mySQLiteAdapter.close(); 
       				  Intent myIntent = new Intent(ViewDetails.this,
       							Lend.class);
       				  myIntent.putExtra("objectslend", hello);
       				  myIntent.putExtra("objects2lend", hello2);
       					ViewDetails.this.startActivity(myIntent);
       				           			
       			}
       		});


}
	
	
	
	public void onRestart()
	  {
		  super.onRestart();
		  Log.d(TAG,"In the onRestart() event");
		  
		  
		  sr = SpeechRecognizer.createSpeechRecognizer(this);   
	        
	        
	        sr.setRecognitionListener(new listener());  
	        
	        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

	        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
	             sr.startListening(intent);
	             Log.i("111111","11111111");
	  }
	
	
	 public void onStop()
	  {
		  super.onStop();
		  Log.d(TAG,"In the onStop() eventttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		  sr.stopListening();
		  sr.destroy();
	  }
	 public void onPause()
	  {
		  super.onPause();
		  Log.d(TAG,"In the onPause() eventttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		  sr.stopListening();
		  sr.destroy();
		
	  }


    class listener implements RecognitionListener          
    {
             public void onReadyForSpeech(Bundle params)
             {
                      Log.d(TAG, "onReadyForSpeech");
                     // mText5.setText("hi");
             }
             public void onBeginningOfSpeech()
             {
                      Log.d(TAG, "onBeginningOfSpeech");
                      //mText2.setText("1");
             }
             public void onRmsChanged(float rmsdB)
             {
                      Log.d(TAG, "onRmsChanged");
                      //mText3.setText("2");
             }
             public void onBufferReceived(byte[] buffer)
             {
                      Log.d(TAG, "onBufferReceived");
                      //mText4.setText("3");
             }
             public void onEndOfSpeech()
             {
                      Log.d(TAG, "onEndofSpeech");
             }
             public void onError(int error)
             {
                      Log.d(TAG,  "error " +  error);
                      //add.setText("error " + error);
                      if(error==8)
                      {
                    	  // func();  
                      }
             }
             public void onResults(Bundle results)                   
             {
                      String str = new String();
                     
                      Log.d(TAG, "onResults " + results);
                      ArrayList data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                      final String dat[]=new String[data.size()];
                      for (int i = 0; i < data.size(); i++)
                      {
                     	
                     	 
                                Log.d(TAG, "result " + data.get(i));
                                dat[i]=(String) data.get(i);
                               str += data.get(i);
                      }
                      
                      
                      for(int i=0;i<data.size();i++)
                      {
                    	  if(dat[i].equalsIgnoreCase("day")|| dat[i].equalsIgnoreCase("month")|| dat[i].equalsIgnoreCase("objects"))
                    	  {
                    		  f=1;
                    		  break;
                    	  }
                    	  else
                    	  {
                    		  f=0;
                    	  }
                      }
                      
                      if(f==0)
                      {
                    	  Log.d("rahul","zero");
                    	  func8();
                    	 // view.setText(Integer.toString(f));
                      }
                     
                      
                      for(int i=0;i<dat.length;i++)
                      {
                    	  if(dat[i].equalsIgnoreCase("day"))
                    	  {
                    		  
                    		  func4();
                    		  Log.d("rahul","why");
                    		 
                    		  Log.d("rahul","yes");
                    		  alert3.setView(input);
                    		  input.setHint("enter the date");
                    		  Log.d("rahul","yes1");
                    		  
                    		  func6();
                    	alert3.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    			  public void onClick(DialogInterface arg0, int arg1) {
                    			  
                    				  
                    			  }});
                    	
                    	
                    alert3.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    	       
                    		  public void onClick(DialogInterface arg0, int arg1) {
                    		  
                    			 func();
                    			  // ((DialogInterface) alert3).dismiss();
                    		  }});
              				alert3.show();
              				
              				
              				if(a==1)
                            {
                          	  input.setText(dat[0]);
                          	  a=0;
                            }
              				
              				
              				
                    	  }
                    	  
                    	  else if(dat[i].equalsIgnoreCase("month"))
                    	  {
                    		  func5();
                    		  
                    		  alert4.setView(input2);
                    		  input2.setHint("enter the month");
                    		  
                    		  alert4.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    			  public void onClick(DialogInterface arg0, int arg1) {
                    			  
                    				  
                    			  }});
                    	
                    	
                    alert4.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    	       
                    		  public void onClick(DialogInterface arg0, int arg1) {
                    		  
                    			 // ((DialogInterface) alert3).dismiss();
                    			  func();
                    			  
                    		  }});
              				alert4.show();
              				
              				func7();
              				if(b==1)
              				{
              					input2.setText(dat[0]);
              					b=0;
              				}
              				
                    		  
                    	  }
                    	  
                    	  else if(dat[i].equalsIgnoreCase("object"))
                    	  {
                    		  
                    	  }
                      }
                      
                    
                    	  
                    	  
                    	  
                      
                      
                     
                    // func(dat);
                     // mText.setText("results: "+String.valueOf(data.size()));  
                     /* builder.setTitle("Pick a color");
                 	 
                 	 builder.setItems(dat, new DialogInterface.OnClickListener() {
                 		    public void onClick(DialogInterface dialog, int item) {
                 		        Toast.makeText(getApplicationContext(), dat[item], Toast.LENGTH_SHORT).show();
                 		    }
                		});*/
                 		//AlertDialog alert = builder.create();
                      //add.setText("results: "+str);  
                      //mText2.setText(dat[0]);
             }
             public void onPartialResults(Bundle partialResults)
             {
                      Log.d(TAG, "onPartialResults");
             }
             public void onEvent(int eventType, Bundle params)
             {
                      Log.d(TAG, "onEvent " + eventType);
             }
             
            
   








}
    void func4()
    {
    	alert3 = new AlertDialog.Builder(this);
    	//alert=new AlertDialog(this);
        input = new EditText(this);
    }
    
    void func5()
    {
    	alert4 = new AlertDialog.Builder(this);
    	//alert=new AlertDialog(this);
        input2 = new EditText(this);
    }
    
    void func()
    {
    	 sr2.setRecognitionListener(new listener()); 
         
         
         Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
         intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
         intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

         intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
              sr2.startListening(intent);
              Log.i("111111","11111111");
    }
    
    void func6()
    {
    	a=1;
    	
    	
    	sr3.setRecognitionListener(new listener()); 
        
        
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
             sr3.startListening(intent);
             Log.i("111111","11111111");
    }
    
    void func7()
    {
    	
    	b=1;
    	sr4.setRecognitionListener(new listener()); 
        
        
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
             sr4.startListening(intent);
             Log.i("111111","11111111");
    }
    
    void func8()
    {
sr5.setRecognitionListener(new listener()); 
        
        
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
             sr5.startListening(intent);
             Log.i("111111","11111111");
    }
    
    
    
}
