package com.example.root.volleyreq;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;

/**
 * Created by root on 7/5/17.
 */

public class ReceiveMessages {
    Context c ;
    ReceiveMessages (Context z ) {
        c=z;
    }
    public void receive_m () {

        com.android.volley.RequestQueue queue= Volley.newRequestQueue(c) ;
        String url ="http://www.maitlibrary.pe.hu/bikerszz/result.inc.php";
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("hola","Response is: "+ response);
                        MainActivity.messages = response;

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("That didn't work!", "not a problem");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
