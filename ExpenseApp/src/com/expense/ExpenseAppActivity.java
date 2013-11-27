package com.expense;



import android.app.Activity;
import android.app.Dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;




public class ExpenseAppActivity extends Activity {
    /** Called when the activity is first created. */
	 private SpeechRecognizer sr,sr2;
	 Button add;
	 String tag="events";
	 ListView modeList;
	 AlertDialog.Builder builder1;
	 int f;
	 Button view;
	   private static final String TAG = "MyStt3Activity";
	   //AlertDialog.Builder builder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("rahul","in on create event");
        Log.d("rahul","lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
        modeList= new ListView(this);
        builder1 = new AlertDialog.Builder(this);
        SQLiteAdapter mySQLiteAdapter;
        mySQLiteAdapter= new SQLiteAdapter(this);
        mySQLiteAdapter.openToWrite();
        f=0;
        mySQLiteAdapter.close();
        System.out.println("1");
         add=(Button)findViewById(R.id.add);
        System.out.println("2");
         view=(Button)findViewById(R.id.view);
        System.out.println("3");
      //  Button others=(Button)findViewById(R.id.others);
        System.out.println("4");
        
        sr = SpeechRecognizer.createSpeechRecognizer(this);   
        
        
        sr.setRecognitionListener(new listener());  
        
        
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
             sr.startListening(intent);
             Log.i("111111","11111111");
        
       
        
        
    	add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				//sr.cancel();
		
				Intent myIntent = new Intent(ExpenseAppActivity.this,
						Add.class);

				ExpenseAppActivity.this.startActivity(myIntent);

			}
		});

    view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(ExpenseAppActivity.this,
						ViewDetails.class);

				ExpenseAppActivity.this.startActivity(myIntent);

			}
		});
    	
    	/*others.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(ExpenseAppActivity.this,
						Others.class);

				ExpenseAppActivity.this.startActivity(myIntent);

			}
		});*/
    	
    	
        
        
        
      }
    
    public void onStart()
	  {
		  super.onStart();
		  Log.d(tag,"In the onStart() event");
		  
		  
		 
		 
	  }
	
	/* public void onResume()
	  {
		  super.onResume();
		  
		  Log.d(tag,"In the onResume() event");
	  }*/
	 public void onStop()
	  {
		  super.onStop();
		  Log.d(tag,"In the onStop() eventttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		  sr.stopListening();
		  sr.destroy();
	  }
	 public void onPause()
	  {
		  super.onPause();
		  Log.d(tag,"In the onPause() eventttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		  sr.stopListening();
		  sr.destroy();
		
	  }
	  
	  
	 public void onRestart()
	  {
		  super.onRestart();
		  Log.d(tag,"In the onRestart() event");
		  
		  
		  sr = SpeechRecognizer.createSpeechRecognizer(this);   
	        
	        
	        sr.setRecognitionListener(new listener());  
	        
	        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

	        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
	             sr.startListening(intent);
	             Log.i("111111","11111111");
	  }
	 public void onDestroy()
	  {
		  super.onDestroy();
		  Log.d(tag,"In the onDestroy() event");
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
                      add.setText("error " + error);
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
                    	  if(dat[i].equalsIgnoreCase("add")|| dat[i].equalsIgnoreCase("view")|| dat[i].equalsIgnoreCase("others"))
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
                    	  func();
                    	  view.setText(Integer.toString(f));
                      }
                     
                      
                      for(int i=0;i<data.size();i++)
                      {
                    	  if(dat[i].equalsIgnoreCase("add"))
                    	  {
                    		  Intent myIntent = new Intent(ExpenseAppActivity.this,
              						Add.class);

              				ExpenseAppActivity.this.startActivity(myIntent);
              				
                    	  }
                    	  
                    	  else if(dat[i].equalsIgnoreCase("view"))
                    	  {
                    		  Intent myIntent = new Intent(ExpenseAppActivity.this,
              						ViewDetails.class);

              				ExpenseAppActivity.this.startActivity(myIntent);
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
                      add.setText("results: "+str);  
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
    
   /* void func(String dat[])
    {
    	 ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,dat);
    	 
   Log.d("rahul","1");
    	 modeList.setAdapter(modeAdapter);
Log.d("rahul","2");
       	builder1.setView(modeList);
       	Log.d("rahul","3");
       	final Dialog dialog = builder1.create();

       	dialog.show();
    }*/
    
   void func()
    {
    	 sr2 = SpeechRecognizer.createSpeechRecognizer(this);   
         
         
         sr2.setRecognitionListener(new listener());  
         
         Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
         intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
         intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");

         intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
              sr2.startListening(intent);
              Log.i("111111","11111111");
         
    }
    
    
    
}