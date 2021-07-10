package com.example.mobilelauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chrome
        ImageView chromeIcon = (ImageView) findViewById(R.id.chromeButton);
        chromeIcon.setImageDrawable(getActivityIcon(this, "com.android.chrome", "com.google.android.apps.chrome.Main"));
        chromeIcon.setOnClickListener(new ImageView.OnClickListener() {
            public void onClick(View v) {
                onChromeButtonClick(v);
            }
        });
        ;

        // maps
        ImageView mapsIcon = (ImageView) findViewById(R.id.mapsButton);
        mapsIcon.setImageDrawable(getActivityIcon(this, "com.google.android.apps.maps", "com.google.android.maps.MapsActivity"));
        mapsIcon.setOnClickListener(new ImageView.OnClickListener() {
            public void onClick(View v) {
                onmapsButtonClick(v);
            }
        });
        ;

        // Youtube
        ImageView youtubeIcon = (ImageView) findViewById(R.id.youtubeButton);
        youtubeIcon.setImageDrawable(getActivityIcon(this, "com.google.android.youtube", "com.google.android.youtube.app.honeycomb.Shell$HomeActivity"));
        youtubeIcon.setOnClickListener(new ImageView.OnClickListener() {
            public void onClick(View v) {
                onYoutubeButtonClick(v);
            }
        });
        ;

        // calender
        ImageView calenderIcon = (ImageView) findViewById(R.id.calendarButton);
        //calenderIcon.setImageDrawable(getActivityIcon(this,"com.simplemobiletools.calendar.pro", "com.simplemobiletools.calendar.pro.activities.MainActivity"));
        calenderIcon.setOnClickListener(new ImageView.OnClickListener() {
            public void onClick(View v) {
                onCalendarButtonClick(v);
            }
        });
        ;

        // music player
        ImageView musicIcon = (ImageView) findViewById(R.id.musicButton);
        //calenderIcon.setImageDrawable(getActivityIcon(this,"com.simplemobiletools.calendar.pro", "com.simplemobiletools.calendar.pro.activities.MainActivity"));
        musicIcon.setOnClickListener(new ImageView.OnClickListener() {
            public void onClick(View v) {
                onMusicButtonClick(v);
            }
        });
        ;
    }

    public static Drawable getActivityIcon(Context context, String packageName, String activityName) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);

        return resolveInfo.loadIcon(pm);
    }

    public void onChromeButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
        startActivity(launchIntent);
    }

    public void onmapsButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
        startActivity(launchIntent);
    }

    public void onYoutubeButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
        startActivity(launchIntent);
    }

    public void onCalendarButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.simplemobiletools.calendar.pro.debug");
        startActivity(launchIntent);
    }

    public void onMusicButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.simplemobiletools.musicplayer.debug");
        startActivity(launchIntent);
    }
}