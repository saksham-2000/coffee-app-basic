package com.example.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/




/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    int cof_price=5,cof_quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void createOrderSummary(View view) {
        CheckBox checkBox1= findViewById(R.id.whip_check_box);
        CheckBox checkBox2 =findViewById(R.id.chocolate_check_box);
        EditText editText= findViewById(R.id.name_id);
        boolean isTickWhip=checkBox1.isChecked();
        boolean isTickChocolate=checkBox2.isChecked();
      String fin_message="Name: ";
      fin_message+=editText.getText();
      fin_message+="\nAdd Whipped Cream?";
      fin_message+=isTickWhip;
        fin_message+="\nAdd Chocolate?";
        fin_message+=isTickChocolate;
       cof_price=5;
      if(isTickChocolate)cof_price+=2;
      if(isTickWhip)cof_price++;
        int price=cof_quantity *cof_price;
fin_message+="\nPrice per coffee: "+cof_price;
fin_message+="\nTotal: $"+ price;
fin_message+="\nThank You!";
//textView.setText(fin_message);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"});
        intent.setPackage("com.google.android.gm");
        intent.putExtra(Intent.EXTRA_SUBJECT, "My Coffee Order");
        intent.putExtra(Intent.EXTRA_TEXT, fin_message);
        startActivity(intent);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void plusButton(View view) {
if(cof_quantity==10){
    Toast.makeText(this,"Sorry,you cannot order more than 10 cups of coffee at a time!",Toast.LENGTH_SHORT).show();
    return;
}
       // displayPrice(cof_price*cof_quantity);
     cof_quantity++;
     display(cof_quantity);
    }

    public void minusButton(View view) {
        if(cof_quantity==0){
            Toast.makeText(this,"Sorry,you cannot order negative cups of coffee!",Toast.LENGTH_SHORT).show();
            return;
        }
        // displayPrice(cof_price*cof_quantity);
        cof_quantity--;
        display(cof_quantity);
    }


}