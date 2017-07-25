package com.imooc.guessmusic.joke.main.widget;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.facebook.drawee.backends.pipeline.Fresco;
import com.imooc.guessmusic.joke.R;
import com.imooc.guessmusic.joke.circle.widget.CircleFragment;
import com.imooc.guessmusic.joke.imagejoke.widget.ImageJokeFragment;
import com.imooc.guessmusic.joke.personal.widget.PersonFragment;
import com.imooc.guessmusic.joke.textjoke.presenter.TextJokePresenter;
import com.imooc.guessmusic.joke.textjoke.widget.TextJokeFragment;
import com.imooc.guessmusic.joke.views.BarEntity;
import com.imooc.guessmusic.joke.views.BottomTabBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements BottomTabBar.OnSelectListener {


    private BottomTabBar bottomTabBar;
    private List<BarEntity> barsList;
    private FragmentManager manager;
    private HomeFragment homeFragment;
    private TextJokeFragment textJokeFragment;
    private ImageJokeFragment imageJokeFragment;
    private CircleFragment circleFragment;
    private PersonFragment personFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        manager = getSupportFragmentManager();
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        bottomTabBar.setManager(manager);
        bottomTabBar.setOnSelectListener(this);
        barsList = new ArrayList<>();
        barsList.add(new BarEntity("主页", R.drawable.ic_home_select, R.drawable.ic_home_unselect));
        barsList.add(new BarEntity("段子", R.drawable.ic_textjoke_select, R.drawable.ic_textjoke_unselect));
        barsList.add(new BarEntity("趣图", R.drawable.ic_imagejoke_select, R.drawable.ic_imagejoke_unselect));
        barsList.add(new BarEntity("圈子", R.drawable.ic_dt_select, R.drawable.ic_dt_unselect));
        barsList.add(new BarEntity("个人", R.drawable.ic_my_select, R.drawable.ic_my_unselect));
        bottomTabBar.setBars(barsList);
    }

    @Override
    public void onSelect(int position) {
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                bottomTabBar.switchContent(homeFragment);
                break;
            case 1:
                if (textJokeFragment == null) {
                    textJokeFragment = new TextJokeFragment();
                }
                bottomTabBar.switchContent(textJokeFragment);
                break;
            case 2:
                if (imageJokeFragment == null) {
                    imageJokeFragment = new ImageJokeFragment();
                }
                bottomTabBar.switchContent(imageJokeFragment);
                break;
            case 3:
                if (circleFragment == null) {
                    circleFragment = new CircleFragment();
                }
                bottomTabBar.switchContent(circleFragment);
                break;
            case 4:
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                }
                bottomTabBar.switchContent(personFragment);
                break;
            default:
                break;
        }
    }
}
