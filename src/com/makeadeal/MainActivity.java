package com.makeadeal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class MainActivity extends Activity {
 
    public static final int SIGNATURE_ACTIVITY = 1;
    EditText et1,et2,et3,et4;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disclaimer();
         et1 = (EditText) findViewById(R.id.title);
         et2 = (EditText) findViewById(R.id.editText1);
         et3 = (EditText) findViewById(R.id.editText2);
         et4 = (EditText) findViewById(R.id.editText3);
        
        Button getSignature = (Button) findViewById(R.id.signature1);
        getSignature.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaptureSignature.class); 
/*//                Bundle b = new Bundle();
//				b.putString("dealer", "1");
//				intent.putExtras(b);
*/                startActivityForResult(intent,SIGNATURE_ACTIVITY);
            }
        });
        
        Button getSignature1 = (Button) findViewById(R.id.signature2);
        getSignature1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaptureSignature2.class);
               /* Bundle b = new Bundle();
				b.putString("dealer", "2");
				intent.putExtras(b);*/
                startActivityForResult(intent,SIGNATURE_ACTIVITY);
            }
        });
        
        Button Deal = (Button) findViewById(R.id.deal);
        Deal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	String title = et1.getText().toString();
            	String name1 = et2.getText().toString();
            	String name2 = et3.getText().toString();
            	String deal = et4.getText().toString();
            	
                Intent intent = new Intent("com.makeadeal.Show");
                Bundle b = new Bundle();
                
				b.putString("title", title);
				b.putString("name1", name1);
				b.putString("name2", name2);
				b.putString("deal", deal);
				
				intent.putExtras(b);
                startActivity(intent);
            }
        }); 
        
    }
    
    public void disclaimer(){


		// TODO Auto-generated method stub
    	LayoutInflater inflater= LayoutInflater.from(this);
    	View vie=inflater.inflate(R.layout.eula, null);
    	
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				MainActivity.this);

		/*final TextView newTV = new TextView(MainActivity.this);
		final ScrollView sv = new ScrollView(MainActivity.this);
		//sv.addView(newTV);
		sv.addView(newTV, 50,50);*/
		
		/*newTV.setInputType(InputType.TYPE_CLASS_NUMBER);
		newTV.setText("");*/
		alertDialogBuilder.setView(vie);
		alertDialogBuilder.setTitle("END USER LICENSE AGREEMENT(EULA)");

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("ACCEPT", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				})
				.setNegativeButton("REJECT",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
								finish();
								System.exit(0);
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();

	
    }
 
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode) {
        case SIGNATURE_ACTIVITY: 
            if (resultCode == RESULT_OK) {
 
                Bundle bundle = data.getExtras();
                String status  = bundle.getString("status");
                if(status.equalsIgnoreCase("done")){
                    Toast toast = Toast.makeText(this, "Signature capture successful!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 105, 50);
                    toast.show();
                }
            }
            break;
        }
 
    }  
 
}