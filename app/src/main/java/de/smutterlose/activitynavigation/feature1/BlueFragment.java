package de.smutterlose.activitynavigation.feature1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.smutterlose.activitynavigation.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnBlueFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlueFragment extends Fragment {

	private OnBlueFragmentInteractionListener mListener;

	public BlueFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @return A new instance of fragment BlueFragment.
	 */
	static BlueFragment newInstance() {
		BlueFragment fragment = new BlueFragment();
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
		return inflater.inflate(R.layout.fragment_blue, container, false);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnBlueFragmentInteractionListener) {
			mListener = (OnBlueFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString() + " must implement OnPurpleFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnBlueFragmentInteractionListener {

		void onFragmentInteraction();
	}
}
