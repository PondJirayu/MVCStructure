package com.example.lp700.mvcstructure.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lp700.mvcstructure.R;

/**
 * Created by lp700 on 12/9/2559.
 */
public class MainFragment extends Fragment {

    int someVar;
    int x, y, z;

    TextView tvHello;

    // สร้าง fragment ขึ้นมาจากคำสั่งนี้เสมอ
    public static MainFragment newInstance(int someVar) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("someVar", someVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        someVar = getArguments().getInt("someVar");
    }

    // Inflate Layout xml
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // findViewById here
        tvHello = (TextView) rootView.findViewById(R.id.tvHello);
    }

    public void setHelloText(String text) {
        tvHello.setText(text);
    }

    // Save State Fragment here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore state here
        }
    }
}
