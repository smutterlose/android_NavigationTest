package de.smutterlose.activitynavigation.feature2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.smutterlose.activitynavigation.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IOnFeature2FragmentInteraction} interface
 * to handle interaction events.
 * Use the {@link GreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GreenFragment extends Fragment implements View.OnClickListener {

	private IOnFeature2FragmentInteraction mListener;

	public GreenFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @return A new instance of fragment BlueFragment.
	 */
	static GreenFragment newInstance() {
		GreenFragment fragment = new GreenFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_green, container, false);

		Button btnSwitchFragment = rootView.findViewById(R.id.btn_greenFragmentSwitchFragment);
		btnSwitchFragment.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof IOnFeature2FragmentInteraction) {
			mListener = (IOnFeature2FragmentInteraction) context;
		} else {
			throw new RuntimeException(context.toString() + " must implement IOnFeature2FragmentInteraction");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_greenFragmentSwitchFragment:
				mListener.changeFragment(OrangeFragment.newInstance(), false);
		}
	}
}
