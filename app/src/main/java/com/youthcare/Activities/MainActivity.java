package com.youthcare.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.youthcare.Adapters.ActivitiesAdapter;
import com.youthcare.Adapters.FragmentPageAdapter;
import com.youthcare.Adapters.NewsAdapter;
import com.youthcare.Fragments.ActivitiesFragment;
import com.youthcare.Fragments.NewsFragment;
import com.youthcare.Fragments.NotificationFragment;
import com.youthcare.R;
import com.youthcare.models.Post;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // initialize Tab menus
            toolbar = (Toolbar) findViewById(R.id.main_tool_bar);
            setSupportActionBar(toolbar);

            viewPager = (ViewPager) findViewById(R.id.app_pager);
            FragmentPageAdapter pageAdapter = new FragmentPageAdapter(getSupportFragmentManager());
            pageAdapter.addFragment(new NewsFragment(), "News");
            pageAdapter.addFragment(new NotificationFragment(), "Notifications");
            pageAdapter.addFragment(new ActivitiesFragment(), "Activities");
            viewPager.setAdapter(pageAdapter);

            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);

            // Initialize FireBase Auth
            mAuth = FirebaseAuth.getInstance();

        }catch (Exception e){
            System.out.println("hello " + e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Log_Out:
                FirebaseAuth.getInstance().signOut();
                Intent startActivity = new Intent(MainActivity.this, StartActivity.class);
                startActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(startActivity);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
            startActivity(startIntent);
            finish();
        }
    }

}
