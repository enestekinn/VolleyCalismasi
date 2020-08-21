package com.example.volleycalismasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //kisiEkle();
        //kisiGuncelle();
        kisiSil();
    }
    public void kisiEkle(){
        String url = "http://kasimadalan.pe.hu/kisiler/insert_kisiler.php";

        StringRequest istek = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("ERROR",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                params.put("kisi_ad","asd");
                params.put("kisi_tel","32423432");




                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }
    public void kisiGuncelle(){
        String url = "http://kasimadalan.pe.hu/kisiler/update_kisiler.php";

        StringRequest istek = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("ERROR",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                params.put("kisi_id","2");
                params.put("kisi_ad","asd");
                params.put("kisi_tel","32423432");




                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }
    public void kisiSil(){
        String url = "http://kasimadalan.pe.hu/kisiler/delete_kisiler.php";

        StringRequest istek = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("ERROR",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();


                params.put("kisi_id","2");



                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }
}