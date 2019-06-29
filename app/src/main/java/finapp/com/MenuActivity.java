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

import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("프로젝트");

        Fragment ProjecFragment = new ProjectFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, ProjecFragment);
        transaction.addToBackStack(null);
        transaction.commit();


        //플로팅 버튼
    //    FloatingActionButton fab = findViewById(R.id.fab);
    //    fab.setOnClickListener(new View.OnClickListener() {
    //        @Override
    //        public void onClick(View view) {
    //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    //                    .setAction("Action", null).show();
    //        }
    //    });

        //네비게이션바
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
            NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        View headView = navigationView.getHeaderView(0);

        TextView tv_kb1=headView.findViewById(R.id.tv_kb1);
        TextView tv_kb2=headView.findViewById(R.id.tv_kb2);
        TextView tv_kbaccount=headView.findViewById(R.id.tv_kbaccount);
        TextView tv_money=headView.findViewById(R.id.tv_money);
        tv_kb1.setText("KB Start 통장 저축 예금");
        tv_kb2.setText("112202-01-012132");
        tv_kbaccount.setText("잔액");
        tv_money.setText("2,430,028원");

        ImageButton imageButton=headView.findViewById(R.id.btn_setting);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                Fragment fragment1;
                fragment1=new NotifiFragment();
                transaction.replace(R.id.container,fragment1);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        /*
        View drawerView;
        drawerView = (View) findViewById(R.id.drawer_layout);
        DrawerLayout dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageButton btn_setting=findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment1;
                fragment1=new NotifiFragment();
                transaction.replace(R.id.container,fragment1);
                transaction.commit();
            }
        });
*/

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

            //화면전환
            //서랍닫기

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
            Fragment fragment2;
            fragment2 = new FinanceManagementFragment();
            transaction.replace(R.id.container, fragment2);
            transaction.commit();
        }  else if(id==R.id.nav_slideshow){
            Fragment fragment3;
            fragment3 = new ReceiptAddFragment1();
            transaction.replace(R.id.container, fragment3);
            transaction.commit();
        }

        return true;
    }
}