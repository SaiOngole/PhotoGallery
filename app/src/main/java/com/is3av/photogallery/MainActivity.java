package com.is3av.photogallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.is3av.photogallery.GalleryImageAdapter;
import com.is3av.photogallery.R;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity
{

    ImageView selectedImage;
    private Integer[] mImageIds = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,

    };
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        selectedImage=(ImageView)findViewById(R.id.imageView1);
        gallery.setSpacing(1);
        gallery.setAdapter(new GalleryImageAdapter(this));

        // clicklistener for Gallery
        gallery.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, "Your selected position = " + position, Toast.LENGTH_SHORT).show();
                // show the selected Image
                selectedImage.setImageResource(mImageIds[position]);
            }
        });
    }

}
