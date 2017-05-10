package com.doanchuyennganh.eatio.views.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.doanchuyennganh.eatio.R;
import com.doanchuyennganh.eatio.entity.Fonda;
import com.doanchuyennganh.eatio.entity.FondaGroup;
import com.doanchuyennganh.eatio.presensters.fonda.FondaGroupPresenter;
import com.doanchuyennganh.eatio.presensters.fonda.FondaGroupPresenterImpl;
import com.doanchuyennganh.eatio.views.fonda.CreateFondaActivity;
import com.doanchuyennganh.eatio.views.fonda.FondaGroupView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by TungHo on 05/09/2017.
 */
@EViewGroup(R.layout.custom_spinner)
public class CustomViewInputSpinner  extends LinearLayout  {

    @ViewById(R.id.img_icon)
    ImageView icon;

    @ViewById(R.id.hint_tv)
    TextView hintTv;

    @ViewById(R.id.spinner)
    Spinner spinner;

    String hintText;
    Drawable drawableIcon;

    public CustomViewInputSpinner(Context context) {
        super(context);
    }

    public CustomViewInputSpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs, 0);
    }

    public CustomViewInputSpinner(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomViewInputSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(context, attrs, defStyleAttr);
    }

    @AfterViews
    public void init(){
        icon.setImageDrawable(drawableIcon);
        hintTv.setText(hintText);

    }

    private void initAttrs(Context context, AttributeSet attrs, int defAttr) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomViewInputSpinner_, defAttr, 0);
        try {
            hintText = a.getString(R.styleable.CustomViewInputSpinner__hint);
            drawableIcon = a.getDrawable(R.styleable.CustomViewInputSpinner__ic);
        } finally {
            a.recycle();
        }
    }


    public void setAdapter(ArrayAdapter adapter) {
        spinner.setAdapter(adapter);
    }


    public SpinnerAdapter getAdapter() {
        return spinner.getAdapter();
    }

    public Object getSelectedItem() {
        return spinner.getSelectedItem();
    }

    public int getSelectedIndex() {
        return spinner.getSelectedItemPosition();
    }
}