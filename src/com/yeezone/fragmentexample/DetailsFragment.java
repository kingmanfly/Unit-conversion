package com.yeezone.fragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    /**     * Create a new instance of DetailsFragment, initialized to     * show the text at 'index'.     */
    public static DetailsFragment newInstance(int index) {
        DetailsFragment f = new DetailsFragment();
        // Supply index input as an argument.        
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        if (container == null) {            
            return null;
        }
        //LayoutInflater inflater1 = getActivity().getLayoutInflater();
        View contentView = new TextView(getActivity());

        
        ScrollView scroller = new ScrollView(getActivity());
        switch(getArguments().getInt("index", 0)){
	        case 0:
	        	contentView = inflater.inflate(R.layout.weight_layout, null);
	        	break;
	        case 1:
	        	break;
	        case 2:
	        	break;
	        default:
		       	contentView = inflater.inflate(R.layout.weight_layout, null); 
        }
        scroller.addView(contentView);
        return scroller;
    }
}