package com.imooc.guessmusic.joke.main.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.imooc.guessmusic.joke.R;


public class HomeFragment extends Fragment {

    private NewTextJokeFragment newTextJokeFragment;
    private NewImageJokeFragment newImageJokeFragment;
    private FragmentManager manager;

    private RadioButton item1;
    private RadioButton item2;
    private RadioGroup group;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        initView(view);
        return view;
    }

    public void initView(View view){
        item1 = (RadioButton) view.findViewById(R.id.item1);
        item2 = (RadioButton) view.findViewById(R.id.item2);
        group = (RadioGroup) view.findViewById(R.id.group);
        manager = getChildFragmentManager();
        newTextJokeFragment = new NewTextJokeFragment();
        switchContent(newTextJokeFragment);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.item1){
                    if(newTextJokeFragment==null){
                        newTextJokeFragment = new NewTextJokeFragment();
                    }
                    switchContent(newTextJokeFragment);
                    item1.setTextColor(ContextCompat.getColor(getActivity(),R.color.colorAccent));
                    item2.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
                }else if(i == R.id.item2){
                    if(newImageJokeFragment==null){
                        newImageJokeFragment = new NewImageJokeFragment();
                    }
                    switchContent(newImageJokeFragment);
                    item1.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
                    item2.setTextColor(ContextCompat.getColor(getActivity(),R.color.colorAccent));
                }
            }
        });
    }

    private Fragment current;

    public void switchContent(Fragment to){
        if(current != to){
            FragmentTransaction transaction = manager.beginTransaction();
            if(current != null){
                transaction.hide(current);
            }
            if(!to.isAdded()){
                transaction.add(R.id.f_content,to).commit();
            }else{
                transaction.show(to).commit();
            }
            current = to;
        }
    }

}
