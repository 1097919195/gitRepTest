package com.example.zjl.testingblewithrxjava2.presenter;

import com.example.zjl.testingblewithrxjava2.contract.BleContract;

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.polidea.rxandroidble2.RxBleDeviceServices;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class BlePresenter extends BleContract.blePresenter{
    @Override
    public void getBleDeviceDataRequest() {

    }

    @Override
    public void getBleUUIDWithMac(String macAddress) {
        mRxManage.add(mModel.getBleUUIDWithMac(macAddress)
                .subscribe(deviceServices -> {
                    mView.returnGetBleUUIDWithMac(deviceServices,macAddress);
                },e -> {mView.showErrorTip("connectFail");
                    LogUtils.loge(e.getCause().toString());}));

    }
}
