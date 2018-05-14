package de.smutterlose.activitynavigation.feature3;

import android.os.Bundle;

import de.smutterlose.activitynavigation.navigation.NavigationActivity;

public class Feature3Activity extends NavigationActivity implements PurpleFragment.OnPurpleFragmentInteractionListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addFragment(PurpleFragment.newInstance());
	}

	@Override
	public void onFragmentInteraction() {

	}
}
