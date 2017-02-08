package com.tm.example.mymvptest.presenter;

import com.tm.example.mymvptest.model.FileOperate;
import com.tm.example.mymvptest.model.IGetString;
import com.tm.example.mymvptest.view.IGetStringView;

/**
 * Created by Tian on 2017/2/7.
 */

public class GetStringPresenter {

    private IGetString iGetString;
    private IGetStringView iGetStringView;

    public GetStringPresenter(IGetStringView iGetStringView) {
        this.iGetStringView = iGetStringView;
        iGetString = new FileOperate();
    }

    public void saveName() {
        iGetString.saveName(iGetStringView.getName());
    }

    public void showName() {
        iGetStringView.showName(iGetString.getName());
    }
}
