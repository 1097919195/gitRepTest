package com.example.zjl.testingblewithrxjava2.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.scan.ScanResult;

import io.reactivex.Maybe;
import io.reactivex.Observable;


/**
 * Created by Administrator on 2018/5/10 0010.
 */

public interface BleContract {
    interface bleModel extends BaseModel {
        Observable<ScanResult> getBleDeviceData();

        Maybe<RxBleDeviceServices> getBleUUIDWithMac(String macAddress);
    }

    interface bleView extends BaseView {
        void returnGetBleDeviceData(ScanResult scanResult);

        void returnGetBleUUIDWithMac(RxBleDeviceServices deviceServices, String macAddress);
    }

    abstract class blePresenter extends BasePresenter<bleView, bleModel> {
        public abstract void getBleDeviceDataRequest();

        public abstract void getBleUUIDWithMac(String macAddress);
    }
}
