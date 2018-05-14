package de.smutterlose.activitynavigation.feature2;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import de.smutterlose.activitynavigation.navigation.NavigationActivity;

public class Feature2Activity extends NavigationActivity implements IOnFeature2FragmentInteraction {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addFragment(OrangeFragment.newInstance());
	}

	@Override
	public void onFragmentInteraction() {

	}

	@Override
	public void changeFragment(Fragment newFragment, boolean addToBackStack) {
		replaceFragment(newFragment, addToBackStack);
	}
}
