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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        //kisiSil();
        //tumKisiler();
        kisiAra();
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

                params.put("kisi_ad","Tamam");
                params.put("kisi_tel","1111");




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

    public void tumKisiler() {
        String url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler.php";

        StringRequest istek = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisilerListe = jsonObject.getJSONArray("kisiler");

                    for (int i = 1; i <kisilerListe.length();i++){
                        JSONObject j = kisilerListe.getJSONObject(i);

                        int kisi_id = j.getInt("kisi_id");
                        String kisi_ad = j.getString("kisi_ad");
                        String kisi_tel = j.getString("kisi_tel");

                        System.out.println(kisi_id);
                        System.out.println(kisi_ad);
                        System.out.println(kisi_tel);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(istek);

    }
    public void kisiAra(){
        String url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler_arama.php";

        StringRequest istek = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("ERROR",response);


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisilerListe = jsonObject.getJSONArray("kisiler");

                    for (int i = 1; i <kisilerListe.length();i++){
                        JSONObject j = kisilerListe.getJSONObject(i);

                        int kisi_id = j.getInt("kisi_id");
                        String kisi_ad = j.getString("kisi_ad");
                        String kisi_tel = j.getString("kisi_tel");

                        System.out.println(kisi_id);
                        System.out.println(kisi_ad);
                        System.out.println(kisi_tel);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();


                params.put("kisi_ad","Ne");



                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }


}