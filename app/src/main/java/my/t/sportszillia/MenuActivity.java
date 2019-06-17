package my.t.sportszillia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.SupportActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private HomeFragment homeArgs = new HomeFragment();
    private ViewBookingFragment viewArgs = new ViewBookingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        int adminFlag = Objects.requireNonNull(getIntent().getExtras()).getInt("ADMIN");

        Bundle bundle = new Bundle();
        bundle.putInt("ADMIN", adminFlag);
        homeArgs.setArguments(bundle);

        Bundle bundle2 = new Bundle();
        bundle2.putInt("ADMIN2", adminFlag);
        viewArgs.setArguments(bundle2);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeArgs).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeArgs).commit();
                break;
            case R.id.nav_create_booking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CreateBookingFragment()).commit();
                break;
            case R.id.nav_view_booking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, viewArgs).commit();
                break;
            case R.id.nav_support:
                Toast.makeText(this, "Selected \"Support\"", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(MenuActivity.this, SuppActivity.class));
                break;
            case R.id.nav_logout:
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
