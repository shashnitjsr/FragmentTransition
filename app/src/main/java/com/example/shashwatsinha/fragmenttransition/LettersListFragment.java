package com.example.shashwatsinha.fragmenttransition;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by shashwatsinha on 26/07/15.
 */
public class LettersListFragment extends ListFragment {

    OnClickLetterist ll;
    String st[] = new String[]{"A", "B", "C", "D"};

    public static LettersListFragment newInstance() {
        LettersListFragment lf = new LettersListFragment();
        return lf;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle onSaveInstanceState) {
        super.onActivityCreated(onSaveInstanceState);
        setListAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, new String[]{"A", "B", "C", "D"}));
        ll = (OnClickLetterist) getActivity();
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {

        ll.onListItemClick(st[position]);
    }

    public interface OnClickLetterist {
        void onListItemClick(String s);
    }
}
