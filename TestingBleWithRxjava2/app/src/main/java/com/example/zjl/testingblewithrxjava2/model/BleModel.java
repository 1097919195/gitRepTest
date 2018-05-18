package com.example.zjl.testingblewithrxjava2.model;


import com.example.zjl.testingblewithrxjava2.app.AppApplication;
import com.example.zjl.testingblewithrxjava2.contract.BleContract;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.scan.ScanResult;


import io.reactivex.Maybe;
import io.reactivex.Observable;


/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class BleModel implements BleContract.bleModel {
    private RxBleClient rxBleClient = AppApplication.getRxBleClient(AppApplication.getAppContext());
    @Override
    public Observable<ScanResult> getBleDeviceData() {
        return null;
    }

    @Override
    public Maybe<RxBleDeviceServices> getBleUUIDWithMac(String macAddress) {
        return rxBleClient.getBleDevice(macAddress)
                .establishConnection(false) //autoConnect flag布尔值：是否直接连接到远程设备（false）或在远程设备变为可用时立即自动连接
                .flatMapSingle(RxBleConnection::discoverServices)
                .firstElement() // Disconnect automatically after discovery
                .compose(RxSchedulers.io_main_maybe());
    }
}
