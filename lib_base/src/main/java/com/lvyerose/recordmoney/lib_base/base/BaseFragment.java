package com.lvyerose.recordmoney.lib_base.base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseFragment extends Fragment {
    //参数接收
    private static final String ARGUMENT_KEY_SET = "key_set";
    protected Map<String, String> params;

    protected View parentView;

    public BaseFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BaseFragment.
     */
    public static BaseFragment newInstance(Class cls) {
        return newInstance(cls, null, null);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param keyList 参数名集合.
     * @param params  参数集合.
     * @return A new instance of fragment BaseFragment.
     */
    public static BaseFragment newInstance(Class cls, ArrayList<String> keyList, Map<String, String> params) {
        Object obj = null;
        try {
            obj = cls.newInstance();
            if (!(obj instanceof BaseFragment)) {
                throw new IllegalArgumentException("Not is BaseFragment or Not It's Child!");
            }
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        BaseFragment fragment = (BaseFragment) obj;
        if (keyList != null && keyList.size() > 0) {
            Bundle args = new Bundle();
            args.putSerializable(ARGUMENT_KEY_SET, keyList);
            for (String key : params.keySet()) {
                args.putString(key, params.get(key));
            }
            fragment.setArguments(args);
        }
        return fragment;
    }

    private void getArgumentData() {
        if (getArguments() != null) {
            ArrayList<String> list = (ArrayList<String>) getArguments().getSerializable(ARGUMENT_KEY_SET);
            if (list != null && list.size() > 0) {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < list.size(); i++) {
                    String key = list.get(i);
                    String param = getArguments().getString(key);
                    map.put(key, param);
                }
                params = map;
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArgumentData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        parentView = inflater.inflate(setContentLayout(), container, false);
        onAfterSetView(parentView);
        return parentView;
    }

    /**
     * 设置  设置给Fragment 的布局
     *
     * @return
     */
    protected abstract int setContentLayout();

    /**
     * 在调用 setContentView() 方之后
     */
    protected void onAfterSetView(View parentView) {

    }
}

