package com.example.codingboy.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{


    private int[] res={R.id.image_a,R.id.image_b,R.id.image_c,R.id.image_d,R.id.image_e,R.id.image_f,R.id.image_g ,
            R.id.image_h};
    ArrayList<ImageView> mImageViews=new ArrayList<>();
    private boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<res.length;i++)
        {
            ImageView imageView= (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            mImageViews.add(imageView);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.image_a:
                if (flag) {
                    openImage();
                }else
                {
                    closeImage();
                }
                break;
            default:
                Toast.makeText(MainActivity.this,"clicked"+v.getId(),Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void closeImage() {
        for (int i=1;i<res.length;i++)
        {
            ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(mImageViews.get(i),"translationY",i*150,0F);
            objectAnimator.setDuration(500);
            objectAnimator.setStartDelay(i * 300);

            objectAnimator.start();
            flag=true;
        }

    }

    private void openImage() {
        for (int i=1;i<res.length;i++)
        {
            ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(mImageViews.get(i),"translationY",0F,i*150);
            objectAnimator.setDuration(500);
            objectAnimator.setStartDelay(i * 300);
            objectAnimator.setInterpolator(new BounceInterpolator());
            objectAnimator.start();
            flag=false;
        }

    }
}
