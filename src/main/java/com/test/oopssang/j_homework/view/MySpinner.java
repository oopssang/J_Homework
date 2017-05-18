package com.test.oopssang.j_homework.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by sang on 2017-05-17.
 */

public class MySpinner extends android.support.v7.widget.AppCompatSpinner implements AdapterView.OnItemSelectedListener{
    private String[] items = {"daum", "naver"};
    private int mPosition = 0;

    public MySpinner(Context context) {
        super(context);
    }

    public MySpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MySpinner(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAdapter(Context context) {
        ArrayAdapter<String> list = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, items);
        list.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        this.setOnItemSelectedListener(this);
        this.setAdapter(list);
    }

    public String getSearchMode(){
        return items[mPosition];
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("sang", "MySpinner onItemSelected position : " + position);
        mPosition = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
