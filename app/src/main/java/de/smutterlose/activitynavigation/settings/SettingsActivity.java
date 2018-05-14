package de.smutterlose.activitynavigation.settings;

import android.os.Bundle;

import de.smutterlose.activitynavigation.navigation.NavigationActivity;

public class SettingsActivity extends NavigationActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addFragment(SettingsFragment.newInstance());
	}
}
