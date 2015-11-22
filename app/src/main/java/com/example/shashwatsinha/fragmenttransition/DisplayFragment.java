package com.example.shashwatsinha.fragmenttransition;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shashwatsinha on 26/07/15.
 */
public class DisplayFragment extends Fragment {

    CustomTextView tv;

    DisplayFragment newInstance(String str) {
        DisplayFragment df = new DisplayFragment();
        Bundle b = new Bundle();
        b.putSerializable("Text", str);
        df.setArguments(b);
        return df;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle b = getArguments();
        View view = inflater.inflate(R.layout.details_page, container, false);
        tv = (CustomTextView) view.findViewById(R.id.text_box);
        if (b != null) {
            tv.setText(b.getString("Text"));

        } else {
            tv.setText("A");
        }
        return view;

    }

    public CustomTextView getTextView() {
        return tv;
    }

    public void setText(String str) {
        tv.setText(str);
    }


}
