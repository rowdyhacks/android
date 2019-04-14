package com.example.thetrippingmillennial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Selection = {R.drawable.instagram,R.drawable.food,R.drawable.beer,R.drawable.shopping,R.drawable.culture,R.drawable.events,R.drawable.music,R.drawable.local};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                if(position==0) {
                    Intent intent = new Intent(MainActivity.this, Instagram.class);
                    startActivity(intent);
                }
                else if (position==1) {
                    Intent intent = new Intent(MainActivity.this, Food.class);
                    startActivity(intent);
                }
                else if (position==2) {
                    Intent intent = new Intent(MainActivity.this, Beer.class);
                    startActivity(intent);
                }
                else if (position==3) {
                    Intent intent = new Intent(MainActivity.this, Shopping.class);
                    startActivity(intent);
                }
                else if (position==4) {
                    Intent intent = new Intent(MainActivity.this, Culture.class);
                    startActivity(intent);
                }
                else if (position==5) {
                    Intent intent = new Intent(MainActivity.this, Events.class);
                    startActivity(intent);
                }
                else if (position==6) {
                    Intent intent = new Intent(MainActivity.this, Music.class);
                    startActivity(intent);
                }
                else if (position==7) {
                    Intent intent = new Intent(MainActivity.this, Local.class);
                    startActivity(intent);
                }

                Toast.makeText(getBaseContext(), "Select Activity " + (position + 1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Selection[position]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c) {
            context=c;
        }

        @Override
        public int getCount() {
            return Selection.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Selection[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330, 300));
            return pic;
        }
    }
}
