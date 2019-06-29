package finapp.com;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     // toolbar.setNavigationIcon(R.drawable.ic_back);
      getSupportActionBar().setTitle("프로젝트");

      Fragment ProjecFragment = new ProjectFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, ProjecFragment);
        transaction.addToBackStack(null);
        transaction.commit();





        //플로팅 버튼
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //네비게이션바
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

      View headView = navigationView.getHeaderView(0);
      TextView textView=headView.findViewById(R.id.textView);
      textView.setText("308302-04048106");
      ImageButton setting_button=headView.findViewById(R.id.btn_setting);
      ImageButton notify_button=headView.findViewById(R.id.btn_notify);

      notify_button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Fragment fragment1 = new NotifiFragment();
              FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
              transaction.add(R.id.container, fragment1);
              transaction.addToBackStack(null);
              transaction.commit();
          }
      });

      //ImageButton imageButton=(ImageButton)findViewById(R.id.imageButton);
      //TextView textView=(TextView)findViewById(R.id.textView);
      //textView.setText("계좌번호");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_home) {
            Toast.makeText(getApplicationContext(), "Asdfasdf", Toast.LENGTH_SHORT).show();
            Fragment fragment1;
            fragment1=new NotifiFragment();
            transaction.replace(R.id.container,fragment1);
            transaction.commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } /*else if (id == R.id.imageButton) {
            Toast.makeText(getApplicationContext(), "Asdfasdf", Toast.LENGTH_SHORT).show();
            Fragment fragment1;
            fragment1=new NotifiFragment();
            transaction.replace(R.id.container,fragment1);
            transaction.commit();
        }*/


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
