package com.example.root.volleyreq;

import android.content.Context;
import android.content.Intent;
import android.net.http.RequestQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Handler;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    public static ListView l1;
    android.os.Handler handler ;
    public static List<String> listString;
    String oldMessage = "";
    EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        e2 = (EditText)findViewById(R.id.editText2);
        l1 = (ListView)findViewById(R.id.list);
        handler = new android.os.Handler();
        final Runnable r = new Runnable() {
            public void run() {
                listString = new ArrayList<String>();
                try {
                    JSONArray j = new JSONArray(MainActivity.messages);
                    Log.i("tuna ", MainActivity.messages);
                    Log.i("json array ", j.toString());

                    for(int i = 0;i <j.length();i++) {
                        JSONObject jo = new JSONObject(j.get(i).toString());
                        listString.add(jo.getString("email"));
                    }
                } catch(Exception e) {

                }

                ArrayAdapter<String> adp=new ArrayAdapter<String>
                        (getBaseContext(),R.layout.support_simple_spinner_dropdown_item,listString);
                if(!oldMessage.equals(MainActivity.messages)) {

                    l1.setAdapter(adp);
                    oldMessage = (MainActivity.messages);
                }
                handler.postDelayed(this, 50);
            }
        };

        handler.postDelayed(r, 50);


    }


    public void sendMessage(View view) {
            try {
                String message = URLEncoder.encode(e2.getText().toString(), "utf-8");

                com.android.volley.RequestQueue queue= Volley.newRequestQueue(this) ;
                String url ="http://www.maitlibrary.pe.hu/bikerszz/insert.php?email="
                        +message+"&password="+MainActivity.name;
                Log.i("send", "http://www.maitlibrary.pe.hu/bikerszz/insert.php?email="
                        +e2.getText().toString()+"&password=vipul");
// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                Log.i("hola","Response is: "+ response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("That didn't work!", "not a problem");
                    }
                });
// Add the request to the RequestQueue.
                queue.add(stringRequest);
                e2.setText("");

            }catch(Exception e) {

            }
            }

}
