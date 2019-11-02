package com.marveltravel.map.ui.onboard;

import com.marveltravel.map.R;

public enum ViewPagerEnum {
    RED(R.string.red, R.layout.view_red),
    BLUE(R.string.blue, R.layout.view_blue),
    ORANGE(R.string.yellow, R.layout.view_orange),
    YELLOW(R.string.orange,R.layout.view_yellow);

    private int mTitleResId;
    private int mLayoutResId;

    ViewPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
