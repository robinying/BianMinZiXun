package com.yubin.bianminzixun.ui;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yubin.basecommon.utils.BasePreference;
import com.yubin.bianminzixun.R;
import com.yubin.bianminzixun.adapter.WelFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity{

    @BindView(R.id.container)
    ViewPager container;
    @BindView(R.id.image_btn_pre)
    ImageButton imageBtnPre;
    @BindView(R.id.img_indicator_0)
    ImageView imgIndicator0;
    @BindView(R.id.img_indicator_1)
    ImageView imgIndicator1;
    @BindView(R.id.img_indicator_2)
    ImageView imgIndicator2;
    @BindView(R.id.btn_finish)
    AppCompatButton btnFinish;
    @BindView(R.id.image_btn_next)
    ImageButton imageBtnNext;
    @BindView(R.id.welcome_container)
    RelativeLayout welContainer;

    private ImageView[] indicators;
    private int[] bgColors;
    private int currentPosition;

    public static void show(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, WelcomeActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        indicators = new ImageView[]{imgIndicator0, imgIndicator1, imgIndicator2};
        bgColors = new int[]{ContextCompat.getColor(this,R.color.colorPrimary)
                ,ContextCompat.getColor(this,R.color.cyan_500)
                ,ContextCompat.getColor(this,R.color.light_blue_500)
        };
        WelFragmentAdapter welFragmentAdapter = new WelFragmentAdapter(getSupportFragmentManager());
        container.setAdapter(welFragmentAdapter);
        container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int color = (int) new ArgbEvaluator().evaluate(positionOffset, bgColors[position], bgColors[position == 2 ? position  : position+1]);
                container.setBackgroundColor(color);
            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                container.setBackgroundColor(bgColors[position]);
                updateIndicators(position);
                imageBtnPre.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
                imageBtnNext.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                btnFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void updateIndicators(int position) {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(i == position ? R.drawable.ic_indicator_selected : R.drawable.ic_indicator_unselected);
        }
    }

    @OnClick({R.id.image_btn_pre, R.id.image_btn_next,R.id.btn_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_btn_pre:
                currentPosition -= 1;
                container.setCurrentItem(currentPosition);
                break;
            case R.id.image_btn_next:
                currentPosition += 1;
                container.setCurrentItem(currentPosition);
                break;
            case R.id.btn_finish:
                break;
        }
    }
}
