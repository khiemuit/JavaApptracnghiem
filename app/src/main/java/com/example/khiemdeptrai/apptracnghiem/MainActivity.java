package com.example.khiemdeptrai.apptracnghiem;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.khiemdeptrai.apptracnghiem.monhoc.DiaLyFragment;
import com.example.khiemdeptrai.apptracnghiem.monhoc.HoaHocFragment;
import com.example.khiemdeptrai.apptracnghiem.monhoc.HomeFragment;
import com.example.khiemdeptrai.apptracnghiem.monhoc.LichSuFragment;
import com.example.khiemdeptrai.apptracnghiem.monhoc.SinhHocFragment;
import com.example.khiemdeptrai.apptracnghiem.monhoc.ToanHocFragment;
import com.example.khiemdeptrai.apptracnghiem.monhoc.VatLyFragment;
import com.example.khiemdeptrai.apptracnghiem.question.DBHelper;
import com.example.khiemdeptrai.apptracnghiem.question.SearchQuesFragment;
import com.example.khiemdeptrai.apptracnghiem.score.ScoreFragment;

import java.io.IOException;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment=new HomeFragment();
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();

        DBHelper db=new DBHelper(this);

        // Phương thức xoa database viết vào hàm MainActivity
//      try {
//            db.deleteDataBase();
//            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
//        }

        try {
            db.createDataBase();
        //Toast.makeText(this, "Coppy thành công", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
            HomeFragment homeFragment=new HomeFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();
        } else if (id == R.id.montoan) {
            ToanHocFragment toanFragment=new ToanHocFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, toanFragment, toanFragment.getTag()).commit();

        } else if (id == R.id.monly) {
            VatLyFragment lyFragment=new VatLyFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, lyFragment, lyFragment.getTag()).commit();


        } else if (id == R.id.monhoa) {
            HoaHocFragment hoaFragment=new HoaHocFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, hoaFragment, hoaFragment.getTag()).commit();

        } else if (id == R.id.monsinh) {
            SinhHocFragment sinhFragment=new SinhHocFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, sinhFragment, sinhFragment.getTag()).commit();

        } else if (id == R.id.monsu) {
            LichSuFragment suFragment=new LichSuFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, suFragment, suFragment.getTag()).commit();

        } else if (id == R.id.mondia) {
            DiaLyFragment diaFragment=new DiaLyFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, diaFragment, diaFragment.getTag()).commit();

        } else if (id == R.id.search) {
            SearchQuesFragment searchQuesFragment= new SearchQuesFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, searchQuesFragment, searchQuesFragment.getTag()).commit();

        } else if (id == R.id.score) {
            ScoreFragment scoreFragment=new ScoreFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, scoreFragment, scoreFragment.getTag()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
