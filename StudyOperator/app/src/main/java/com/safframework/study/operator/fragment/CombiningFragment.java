package com.safframework.study.operator.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.safframework.injectview.Injector;
import com.safframework.injectview.annotations.InjectView;
import com.safframework.study.operator.R;
import com.safframework.study.operator.app.BaseFragment;
import com.safframework.study.operator.utils.RxUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by tony on 2017/11/10.
 */

public class CombiningFragment extends BaseFragment {

    @InjectView(R.id.text1)
    TextView createView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_combining, container, false);
        Injector.injectInto(this, v);

        initViews();

        return v;
    }

    private void initViews() {
        RxView.clicks(createView)
                .compose(RxUtils.useRxViewTransformer(CombiningFragment.this))
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {

                    }
                });
    }
}