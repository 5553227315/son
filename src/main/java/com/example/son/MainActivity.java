package com.example.son;


import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;



public class MainActivity extends FragmentActivity implements OnClickListener{
    private ZhongFragment zhongFragment;
    private ZuoFragment zuoFragment;
    private YouFragment youFragment;

    private FrameLayout flayout;
    private RadioButton radioButton1,radioButton2,radioButton3;
    FragmentManager fManager;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getSupportFragmentManager();
        initViews();
        FragmentTransaction transaction2 = fManager.beginTransaction();
        hideFragments(transaction2);
        zhongFragment = new ZhongFragment();
        transaction2.add(R.id.content, zhongFragment);
        transaction2.commit();


    }

    public void initViews(){
        radioButton1=findViewById(R.id.btn1);
        radioButton2=findViewById(R.id.btn2);
        radioButton3=findViewById(R.id.btn3);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                setChioceItem(0);
                break;
            case R.id.btn2:
                setChioceItem(1);
                break;
            case R.id.btn3:
                setChioceItem(2);
                break;
        }
    }
    public void setChioceItem(int index)
    {
        FragmentTransaction transaction = fManager.beginTransaction();
        hideFragments(transaction);

        switch (index) {
            case 0:
                if (zuoFragment == null) {
                    // 如果zuoFragment为空，则创建一个并添加到界面上
                    zuoFragment = new ZuoFragment();
                    transaction.add(R.id.content, zuoFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(zuoFragment);
                }
                break;
            case 1:
                if (zhongFragment == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    zhongFragment = new ZhongFragment();
                    transaction.add(R.id.content, zhongFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(zhongFragment);
                }
                break;
            case 2:
                if (youFragment == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    youFragment = new YouFragment();
                    transaction.add(R.id.content, youFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(youFragment);
                }
                break;
        }
        transaction.commit();
        }
    private void hideFragments(FragmentTransaction transaction) {
        if (zuoFragment != null) {
            transaction.hide(zuoFragment);
        }
        if (zhongFragment != null) {
            transaction.hide(zhongFragment);
        }
        if (youFragment != null) {
            transaction.hide(youFragment);
        }
    }



}