package com.example.jangsir.godutch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GoDutch extends AppCompatActivity {

    String amount;
    EditText totalAmount,persNbr;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_dutch);
        totalAmount = (EditText)findViewById(R.id.editText3);
        persNbr =(EditText) findViewById(R.id.editText4);
        display = (TextView) findViewById(R.id.textView4);

    // Example of a call to a native method
    TextView tv = (TextView) findViewById(R.id.sample_text);
    tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    public void btnCompute(View v){

        Double total = Double.parseDouble(totalAmount.getText().toString());
        Double persons = Double.parseDouble(persNbr.getText().toString());
        Double share = total/persons;
        share = Double.valueOf(Math.round(share*100));
        share = share /100;

        //Toast.makeText(getBaseContext(),"The amount to share is"+share,Toast.LENGTH_SHORT).show();
        display.setText(String.valueOf(share));

    }

}
