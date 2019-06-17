package com.lvyerose.recordmoney.lib_base.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView基础适配器的ViewHolder类
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views;
    private Context mContext;
    private View convertView;

    public BaseViewHolder(final View view, Context context) {
        super(view);
        this.views = new SparseArray<>();
        this.convertView = view;
        this.mContext = context;
    }

    public View getConvertView() {
        return convertView;
    }

    public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
