package com.example.zjl.testingble.model;

import com.example.zjl.testingble.app.AppApplication;
import com.example.zjl.testingble.contract.BleContract;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.polidea.rxandroidble.RxBleClient;
import com.polidea.rxandroidble.RxBleConnection;
import com.polidea.rxandroidble.RxBleDeviceServices;
import com.polidea.rxandroidble.scan.ScanFilter;
import com.polidea.rxandroidble.scan.ScanResult;
import com.polidea.rxandroidble.scan.ScanSettings;

import rx.Observable;

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
    public Observable<RxBleDeviceServices> getBleUUIDWithMac(String macAddress) {
        return rxBleClient.getBleDevice(macAddress)
                .establishConnection(false) //autoConnect flag布尔值：是否直接连接到远程设备（false）或在远程设备变为可用时立即自动连接
                .flatMap(RxBleConnection::discoverServices)
                .first() // Disconnect automatically after discovery
                .compose(RxSchedulers.io_main());
    }
}
