package com.example.dell.firstpro.WebService;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dell.firstpro.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiActivity extends AppCompatActivity {
    APIhandler apIhandler;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        new myTask().execute();

    }

    public class myTask extends AsyncTask<Void, Void, String> {


        @Override
        protected void onPreExecute() {
            Toast.makeText(getBaseContext(), "onPreExecute", Toast.LENGTH_LONG).show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {

            apIhandler = new APIhandler();
            result = apIhandler.getApi();

            return result;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject root = new JSONObject(s);
                JSONArray Contact = root.getJSONArray("contacts");
                for (int i = 0; i < Contact.length(); i++) {
                    JSONObject obj_contact = Contact.getJSONObject(i);
                    String id = obj_contact.getString("id");
                    String name = obj_contact.getString("name");
                    String email = obj_contact.getString("email");
                    Toast.makeText(getApplicationContext(), id + "\n" + name + "\n" + email, Toast.LENGTH_LONG).show();

                }
            } catch (JSONException e) {
                Log.i("error",e.getMessage());
            }


        }
    }

}



