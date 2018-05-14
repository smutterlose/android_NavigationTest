package de.smutterlose.activitynavigation.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import de.smutterlose.activitynavigation.R;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

	private NavigationParameter navigationParameter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.navigationParameter = new NavigationParameter(this.getApplicationContext());

		setContentView(R.layout.activity_base);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string
				.navigation_drawer_open,
																 R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);
		Menu menu = navigationView.getMenu();
		for (String menuItemTitle : navigationParameter.menuItems.keySet()) {
			menu.add(menuItemTitle);
		}
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
		getMenuInflater().inflate(R.menu.base, menu);
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

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		// Handle navigation view item clicks here.
		String menuItemTitle = item.getTitle().toString();

		Class<? extends NavigationActivity> activityClass = navigationParameter.menuItems.get(menuItemTitle);
		startNewActivity(activityClass);

		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	private void startNewActivity(Class<? extends NavigationActivity> activityClass) {
		Intent activityIntent = new Intent(this, activityClass);

		startActivity(activityIntent);
		//TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
		//PendingIntent pendingIntent = taskStackBuilder.addNextIntentWithParentStack(activityIntent)
		//											  .getPendingIntent(0, 0);
		//Log.d(this.getClass().getSimpleName(), "Current intent count: " + taskStackBuilder.getIntentCount());
		//try {
		//	pendingIntent.send();
		//} catch (PendingIntent.CanceledException cancelException) {
		//	Log.e(this.getClass().getSimpleName(), "Exception during activity switch", cancelException);
		//}
	}

	protected void addFragment(Fragment fragmentToAdd) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.fl_contentFrame, fragmentToAdd, fragmentToAdd.getClass().getSimpleName());
		fragmentTransaction.disallowAddToBackStack();

		fragmentTransaction.commit();
	}

	protected void replaceFragment(Fragment newFragment, boolean addToBackStack) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fl_contentFrame, newFragment, newFragment.getClass().getSimpleName());
		fragmentTransaction.disallowAddToBackStack();

		fragmentTransaction.commit();
	}
}
