package com.demo.lianyuchen.materialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.lianyuchen.materialdesign.R;
import com.demo.lianyuchen.materialdesign.utils.AnimUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lianyuchen on 16/8/8.
 */
public class FragmentTwo extends Fragment {
    @BindView(R.id.tv_old)
    TextView tvTextOld;
    @BindView(R.id.tv_new)
    TextView tvNew;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.tv_old)
    public void clickOld() {

        AnimUtils.FlipAnimatorXView(tvTextOld, tvNew, 1000);
//        AnimUtils.FlipOutXView(tvTextOld, 1000);
//        AnimUtils.FlipInXView(tvText, 1000);
    }

    @OnClick(R.id.tv_new)
    public void clickNew() {

        AnimUtils.flipAnimatorXViewGone(tvNew,tvTextOld,1000);
    }
}
