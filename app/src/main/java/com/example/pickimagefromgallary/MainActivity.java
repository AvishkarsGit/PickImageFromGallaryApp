package com.example.pickimagefromgallary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.provider.*;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button open;
    private static final int GALLARY_REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgview);
        open = findViewById(R.id.btnOpen);

        open.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,GALLARY_REQ_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK){
            if (requestCode == GALLARY_REQ_CODE){
                img.setImageURI(data.getData());
            }
        }
    }
}