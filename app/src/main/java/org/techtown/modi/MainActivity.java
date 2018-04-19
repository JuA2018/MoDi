package org.techtown.modi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    boolean Pagetrans = false;

    RelativeLayout mainpage;
    LinearLayout menupage;
    Animation layoutleft, layoutright;
    Button login, signup, writediary, diarylist, help, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainpage = (RelativeLayout) findViewById(R.id.mainpage);
        menupage = (LinearLayout) findViewById(R.id.menupage);
        layoutleft = AnimationUtils.loadAnimation(this, R.anim.layoutleft);
        layoutright = AnimationUtils.loadAnimation(this, R.anim.layoutright);

        SlidingAnimationListener listener = new SlidingAnimationListener();
        layoutleft.setAnimationListener(listener);
        layoutright.setAnimationListener(listener);

        ImageButton clickmenu = (ImageButton) findViewById(R.id.clickmenu);
        clickmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menupage.setVisibility(View.VISIBLE);
                menupage.startAnimation(layoutleft);
            }
        });

        ImageButton exit = (ImageButton) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menupage.startAnimation(layoutright);
            }
        });

        writediary = findViewById(R.id.writediary);
        writediary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), diarymanagementActivity.class);
                startActivity(intent);
            }
        });

    }

    class SlidingAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(Pagetrans) {
                menupage.setVisibility(View.INVISIBLE);
                Pagetrans = false;
            }else {
                Pagetrans = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}