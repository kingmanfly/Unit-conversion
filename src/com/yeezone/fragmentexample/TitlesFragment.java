package com.yeezone.fragmentexample;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {

    int mCurCheckPosition = 0;
    int mShownCheckPosition = -1;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState); 
        Resources res = getResources () ; 
        String [] units = res . getStringArray ( R.array.content_index);                         
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                units));
        if (savedInstanceState != null) { 
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
            mShownCheckPosition = savedInstanceState.getInt("shownChoice", -1);
        } 
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE); 
            showDetails(mCurCheckPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curChoice", mCurCheckPosition);
        outState.putInt("shownChoice", mShownCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    /**
     *��ʾlistview item ����
     */
    void showDetails(int index) {
        mCurCheckPosition = index;
            getListView().setItemChecked(index, true);

            if (mShownCheckPosition != mCurCheckPosition) {

                DetailsFragment df = DetailsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.details, df);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                mShownCheckPosition = index;
            }   
    }

}

