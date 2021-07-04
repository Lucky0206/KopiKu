package com.example.kopiku;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import androidx.appcompat.app.AppCompatActivity;

public class MainAct2 extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void increment(View view){
        if(quantity==100){
            Toast.makeText(this,"Pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1;
        display(quantity);
    }
    public void decrement(View view){
        if (quantity==1){
            Toast.makeText(this,"Pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }

    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.namapesanan);
        String name = nameEditText.getText().toString();
        Log.v("MainActivity","Nama" +name);

        CheckBox espressoCheckbox = (CheckBox) findViewById(R.id.espresso);
        boolean hasespresso = espressoCheckbox.isChecked();
        Log.v("MainActivity","has Espresso" +hasespresso);

        CheckBox americanoCheckbox = (CheckBox) findViewById(R.id.americano);
        boolean hasamericano = americanoCheckbox.isChecked();
        Log.v("MainActivity","has Americano" +hasamericano);

        CheckBox cappucinoCheckbox = (CheckBox) findViewById(R.id.cappucino);
        boolean hascappucino = cappucinoCheckbox.isChecked();
        Log.v("MainActivity","has Cappucino" +hascappucino);

        CheckBox latteCheckbox = (CheckBox) findViewById(R.id.latte);
        boolean haslatte = latteCheckbox.isChecked();
        Log.v("MainActivity","has Latte" +haslatte);

        CheckBox moccachinoCheckbox = (CheckBox) findViewById(R.id.moccachino);
        boolean hasmoccachino = moccachinoCheckbox.isChecked();
        Log.v("MainActivity","has Moccachino" +hasmoccachino);

        CheckBox affogatoCheckbox = (CheckBox) findViewById(R.id.affogato);
        boolean hasaffogato = affogatoCheckbox.isChecked();
        Log.v("MainActivity","has Affogato" +hasaffogato);

        int price = calculateprice(hasespresso,hasamericano,hascappucino,haslatte,hasmoccachino,hasaffogato);
        String pricemessage = createOrderSummary(price,name,hasespresso,hasamericano,hascappucino,haslatte,hasmoccachino,hasaffogato);

        displayMessage(pricemessage);
    }
    private int calculateprice(boolean addespresso, boolean addamericano, boolean addcappucino, boolean addlatte, boolean addmoccachino, boolean addaffogato){
        int harga = 10000;

        if (addespresso){
            harga = harga+1000;
        }

        if (addamericano){
            harga = harga+5000;
        }

        if (addcappucino){
            harga = harga+5000;
        }

        if (addlatte){
            harga = harga+5000;
        }

        if (addmoccachino){
            harga = harga+5000;
        }

        if (addaffogato){
            harga = harga+5000;
        }
        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean addespresso, boolean addamericano, boolean addcappucino, boolean addlatte, boolean addmoccachino, boolean addaffogato){
        String pricemessage=" Atas nama "+name;
        pricemessage+="\n Menambahkan kopi espresso =" +addespresso;
        pricemessage+="\n";
        pricemessage+="\n Menambahkan kopi americano =" +addamericano;
        pricemessage+="\n";
        pricemessage+="\n Menambahkan kopi cappucino =" +addcappucino;
        pricemessage+="\n";
        pricemessage+="\n Menambahkan kopi latte =" +addlatte;
        pricemessage+="\n";
        pricemessage+="\n Menambahkan kopi moccachino =" +addmoccachino;
        pricemessage+="\n";
        pricemessage+="\n Menambahkan kopi affogato =" +addaffogato;
        pricemessage+="\n";
        pricemessage+="\n Jumlah pemesanan =" +quantity;
        pricemessage+="\n";
        pricemessage+="\n Total = Rp " +price;
        pricemessage+="\n";
        pricemessage+="\n Thank you for order:)";
        return pricemessage;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.harga);
        priceTextView.setText(message);
    }

    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.harga);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
