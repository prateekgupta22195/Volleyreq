package com.example.root.volleyreq;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.password;

public class MainActivity extends Activity {
    public static EditText name ;
    public static String nameString;
    public static String messages;
    String msg = "Android : ";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String manufacturer = "xiaomi";
//        if(manufacturer.equalsIgnoreCase(android.os.Build.MANUFACTURER)) {
//            //this will open auto start screen where user can enable permission for your app
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
//            startActivity(intent);
//        }
        name = (EditText)findViewById(R.id.inputEmail) ;
        Log.d(msg, "The onCreate() event");
        startService(new Intent(getBaseContext(), Myservice.class));
    }


    public void goButton(View view) {
        Toast.makeText(this, "Cancel pressed", Toast.LENGTH_LONG).show();
        nameString = name.getText().toString();
        Intent intent = new Intent(getBaseContext(), Chat.class);
        startActivity(intent);
    }

}
