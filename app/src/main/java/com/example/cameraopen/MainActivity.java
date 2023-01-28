package com.example.cameraopen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button, gallery;

    public static final int REQUEST_CODE = 100;
    public static final int REQUEST_CODE_GALLERY = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        gallery = findViewById(R.id.gallary);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(Intent.ACTION_PICK);
                inten.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(inten, REQUEST_CODE_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_GALLERY) {
                 imageView.setImageURI(data.getData());
// if you want to open camera you should remove this comments given below and add REQUEST_CODE in above if statement
//                Bitmap bit = (Bitmap) data.getExtras().get("data");
//                imageView.setImageBitmap(bit);
            }

        }


    }

}