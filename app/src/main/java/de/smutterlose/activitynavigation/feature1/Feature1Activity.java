package de.smutterlose.activitynavigation.feature1;

import android.net.Uri;
import android.os.Bundle;

import de.smutterlose.activitynavigation.navigation.NavigationActivity;

public class Feature1Activity extends NavigationActivity implements BlueFragment.OnBlueFragmentInteractionListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addFragment(BlueFragment.newInstance());
	}

	@Override
	public void onFragmentInteraction() {

	}
}
