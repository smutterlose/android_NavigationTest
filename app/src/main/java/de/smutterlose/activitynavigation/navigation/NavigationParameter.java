package de.smutterlose.activitynavigation.navigation;

import android.content.Context;

import java.util.LinkedHashMap;
import java.util.Map;

import de.smutterlose.activitynavigation.R;
import de.smutterlose.activitynavigation.feature1.Feature1Activity;
import de.smutterlose.activitynavigation.feature2.Feature2Activity;
import de.smutterlose.activitynavigation.feature3.Feature3Activity;
import de.smutterlose.activitynavigation.settings.SettingsActivity;

class NavigationParameter {

	Map<String, Class<? extends NavigationActivity>> menuItems;

	NavigationParameter(Context context) {
		menuItems = new LinkedHashMap<>();
		menuItems.put(context.getString(R.string.feature1_menuItemTitle), Feature1Activity.class);
		menuItems.put(context.getString(R.string.feature2_menuItemTitle), Feature2Activity.class);
		menuItems.put(context.getString(R.string.feature3_menuItemTitle), Feature3Activity.class);
		menuItems.put(context.getString(R.string.settings_menuItemTitle), SettingsActivity.class);
	}
}
