package com.imooc.guessmusic.joke.personal.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.guessmusic.joke.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person,container,false);
        return view;
    }

}
