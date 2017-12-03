package in.ac.amrapali.amrapaliinstitute;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    swipper swipper;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.slidder);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        navigationView=(NavigationView) findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id==R.id.first){

                    Intent intent=new Intent(MainActivity.this,about.class);
                    startActivity(intent);

                }

                return true;
            }
        });


        swipper=new swipper(this);
        viewPager.setAdapter(swipper);

        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        setSupportActionBar(toolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void notice(View view){
        Intent intent=new Intent(MainActivity.this,noticeBoard.class);
        startActivity(intent);

    }
    public void photo(View view){
        Intent intent=new Intent(MainActivity.this,photoGallery.class);
        startActivity(intent);

    }



}
