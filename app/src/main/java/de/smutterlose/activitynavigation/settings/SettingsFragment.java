package de.smutterlose.activitynavigation.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.smutterlose.activitynavigation.R;

public class SettingsFragment extends PreferenceFragmentCompat {

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @return A new instance of fragment SettingsFragment.
	 */
	public static SettingsFragment newInstance() {
		SettingsFragment fragment = new SettingsFragment();
		return fragment;
	}

	@Override
	public void onCreatePreferences(Bundle bundle, String s) {
		addPreferencesFromResource(R.xml.general_settings);
	}

	//@Override
	//public View onCreateView(LayoutInflater inflater,
	//						 @Nullable ViewGroup container,
	//						 @Nullable Bundle savedInstanceState) {
	//	View rootView = super.onCreateView(inflater, container, savedInstanceState);
	//
	//
	//
	//	return rootView;
	//}
}
