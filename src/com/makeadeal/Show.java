package com.makeadeal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

public class Show extends Activity {
	
	String title,name1,name2,deal;
	TextView tv1,tv2,tv3,tv4,tv5,tv6;
	ImageView iv1,iv2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		tv3 = (TextView)findViewById(R.id.textView3);
		tv4 = (TextView)findViewById(R.id.textView4);
		tv5 = (TextView)findViewById(R.id.textView5);
		tv6 = (TextView)findViewById(R.id.textView6);
		iv1 = (ImageView)findViewById(R.id.imageView1);
		iv2 = (ImageView)findViewById(R.id.imageView2);
		
		 Bundle bundle = this.getIntent().getExtras();
	     title = bundle.getString("title");
	     name1 = bundle.getString("name1");
	     name2 = bundle.getString("name2");
	     deal = bundle.getString("deal");
	     
	     tv1.setText("Title - "+title);
	     tv2.setText("Dealer1 - "+name1);
	     tv3.setText("Dealer2 - "+name2);
	     tv4.setText("Your Deal - "+deal);
	     
	     tv5.setText(name1+"'s Signature");
	     tv6.setText(name2+"'s Signature");
	     
	     /*Bitmap bmp1 = BitmapFactory.decodeFile(Environment.getDataDirectory() + "/app_imageDir/name1.png");
	     iv1.setImageBitmap(bmp1);*/
	     try {
	    	 
	    	 ContextWrapper cw = new ContextWrapper(getApplicationContext());
	         
	         File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
	         
	         File f=new File(directory, "name1.png");
	         Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
	         iv1.setImageBitmap(b);
	         
	         File f1=new File(directory, "name2.png");
	         Bitmap b1 = BitmapFactory.decodeStream(new FileInputStream(f1));
	         iv2.setImageBitmap(b1);
	     } 
	     catch (FileNotFoundException e) 
	     {
	         e.printStackTrace();
	     }
/*
	     Bitmap bmp2 = BitmapFactory.decodeFile(Environment.getDataDirectory() + "/app_imageDir/name2.png");
	     iv2.setImageBitmap(bmp2);
	    
*/	     
	}

}
