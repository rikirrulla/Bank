package com.example.bank.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bank.Model.Connection;
import com.example.bank.Model.Profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApplicationDB  {
    private static final String TAG = "ApplicationDB";
    private Context context;
    private String url = Connection.url;
    public static ArrayList<Profile> profiles = new ArrayList<>();

    public ApplicationDB(Context context){
        this.context = context;
    }

    public ArrayList<Profile> getAllProfiles(){

        StringRequest request = new StringRequest(Request.Method.POST, url+"profile.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //profiles.clear();
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String succes = jsonObject.getString("succes");
                    JSONArray jsonArray = jsonObject.getJSONArray("profile");

                    if (succes.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("profileID");
                            String username = object.getString("username");
                            String password = object.getString("password");
                            String fullname = object.getString("fullname");
                            String city = object.getString("city");
                            String address = object.getString("address");
                            String telephone_number = object.getString("telephone_number");
                            //Log.i(TAG, id+"-"+username);


                            profiles.add(new Profile(Integer.valueOf(id),username,password,fullname,city,address,telephone_number));
                            //   Log.i(TAG, ""+profiles.size());
                            //   Log.i(TAG, ".    "+username);

                        }
                    }
                } catch (JSONException e) {
                    Log.i(TAG, e.getMessage());
                    //  Toast.makeText(applicationContext,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Probleme me rrjetin", Toast.LENGTH_SHORT).show();
                Log.i(TAG, error.getMessage());
                // Toast.makeText(applicationContext,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
        return profiles;
    }

    public void saveNewProfile(final String username, final String password, final String fullname, final String city, final String address, final String nr){
        final ProgressDialog progressDialog = new ProgressDialog(context);
        //      progressDialog.setMessage("Loading...");
//        progressDialog.show();
        final StringRequest request = new StringRequest(Request.Method.POST, Connection.url+"insertProfile.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equalsIgnoreCase("Data Inserted")) {
                    Toast.makeText(context, "U insertuan me sukses", Toast.LENGTH_SHORT).show();
                    //                progressDialog.dismiss();
                } else {
                    Toast.makeText(context, response, Toast.LENGTH_LONG).show();
                    //              progressDialog.dismiss();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                System.out.println(error.getLocalizedMessage());
                System.out.println(error.getMessage());
                System.out.println(error.getCause());

                progressDialog.dismiss();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> stringMap = new HashMap<String, String>();
                stringMap.put("username", username);
                stringMap.put("password", password);
                stringMap.put("fullname", fullname);
                stringMap.put("city", city);
                stringMap.put("address", address);
                stringMap.put("telephone_number", nr);
                return stringMap;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }
}
