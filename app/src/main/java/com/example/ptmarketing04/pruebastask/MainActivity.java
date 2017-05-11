package com.example.ptmarketing04.pruebastask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private String url,sql;
    private JSONArray jSONArray;
    private Connection conn;
    private PruebaTask pt;
  //  public static String pruebas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tvPruebas);

        url = "http://iesayala.ddns.net/natalia/php.php";
        sql= "Select * from Listas";
        conn = new Connection();

        new PruebaTask(MainActivity.this,conn,jSONArray,url,sql);

        new PruebaTask.ListTask().execute();

        tv.setText(PruebaTask.ListTask.pas);

        Log.e("pruebas:->", PruebaTask.ListTask.pas);


    }
    

}
