package com.example.learndrawerlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ImageView leftMenu;
    private ImageView rightMenu;

    private FragmentManager fm;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listView = findViewById(R.id.left_listview);
        drawerLayout = findViewById(R.id.drawerLayout);
        fm = getSupportFragmentManager();

        initData();
        leftMenu = findViewById(R.id.leftmenu);
        leftMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        rightMenu = findViewById(R.id.rightmenu);
        rightMenu.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v){
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });



    }
    private void initData(){
        List<ContentModel> list = new ArrayList<>();
        list.add(new ContentModel(R.drawable.ic_insert_photo_black_24dp, "新闻", 1));
        list.add(new ContentModel(R.drawable.ic_insert_photo_black_24dp, "订阅", 2));
        list.add(new ContentModel(R.drawable.ic_insert_photo_black_24dp, "图片", 3));
        list.add(new ContentModel(R.drawable.ic_ondemand_video_black_24dp, "视频", 4));
        list.add(new ContentModel(R.drawable.ic_insert_photo_black_24dp, "跟帖", 5));
        list.add(new ContentModel(R.drawable.ic_insert_photo_black_24dp, "投票", 6));

        ContentAdapter adapter = new ContentAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FragmentTransaction bt = fm.beginTransaction();
                switch ( position) {
                    case 0:
                        bt.replace(R.id.content, new NewsFragment());
                        break;
                    case 1:
                        bt.replace(R.id.content, new SubscriptionFragment());
                        break;

                    default:
                        bt.replace(R.id.content, new NewsFragment());
                        break;
                }
                bt.commit();
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

    }
}
