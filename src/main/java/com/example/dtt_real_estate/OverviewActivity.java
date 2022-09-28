package com.example.dtt_real_estate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class OverviewActivity extends AppCompatActivity {

    // declaration of variables
    TextView helloWorld;
    ImageView toolbar;
    ImageView homeButton;
    ImageView infoButton;

    String API_KEY = "98bww4ezuzfePCYFxJEWyszbUXc7dxRx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        // views
        helloWorld = findViewById(R.id.tv_hello_world);
        toolbar = findViewById(R.id.iv_toolbar);
        //homeButton = findViewById(R.id.iv_home_button);
        infoButton = findViewById(R.id.iv_info_button);

        // place onClickListener to handle click event on buttons
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call method that handles the switching of activities
                SwitchToAboutPageActivity();
            }
        });


        // instantiate the RequestQueue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://intern.development.d-tt.dev/api/house?key=98bww4ezuzfePCYFxJEWyszbUXc7dxRx";

        // request a string response from the provided url
        // instead of a StringRequest we need to make it a JSONArray request
        // because the data is a list in JSON format
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // display first 500 characters of the response string
                        helloWorld.setText("Response is :" + response);
                        Toast.makeText(OverviewActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                helloWorld.setText("It didn't work!!");
            }
        });

        // add the request to the RequestQueue
        requestQueue.add(request);

    }
    // method that handles the switching of activities
    private void SwitchToAboutPageActivity(){
        Intent switchActivityIntent = new Intent(this, AboutPageActivity.class);
        startActivity(switchActivityIntent);
        finish();
    }
}