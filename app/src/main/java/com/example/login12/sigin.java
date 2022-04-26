package com.example.login12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class sigin extends AppCompatActivity {
    ImageView imageView;
    TextView name;
    Button logOutbtn;

    AccessToken accessToken =AccessToken.getCurrentAccessToken();

    GraphRequest request = GraphRequest.newMeRequest(
            accessToken,
            new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted( JSONObject object,  GraphResponse response) {
                    try {
                        String fullName = object.getString("name");
                        String url =object.getJSONObject("picture").getJSONObject("data").getString("url");
                        name.setText(fullName);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            });





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);


        imageView = findViewById(R.id.imageview);
        name = findViewById(R.id.name);
        logOutbtn = findViewById(R.id.logOutbtn);

        logOutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                startActivity(new Intent(sigin.this,MainActivity.class));
                finish();

            }
        });



    }
}