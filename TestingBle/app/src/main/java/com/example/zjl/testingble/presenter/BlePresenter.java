package com.example.zjl.testingble.presenter;

import com.example.zjl.testingble.contract.BleContract;
import com.jaydenxiao.common.baserx.RxSubscriber;
import com.polidea.rxandroidble.RxBleDeviceServices;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class BlePresenter extends BleContract.blePresenter{
    @Override
    public void getBleDeviceDataRequest() {

    }

    @Override
    public void getBleUUIDWithMac(String macAddress) {
        mRxManage.add(mModel.getBleUUIDWithMac(macAddress).subscribe(new RxSubscriber<RxBleDeviceServices>(mContext,true) {
            @Override
            protected void _onNext(RxBleDeviceServices deviceServices) {
                mView.returnGetBleUUIDWithMac(deviceServices,macAddress);
            }

            @Override
            protected void _onError(String message) {

            }
        }));

    }
}
