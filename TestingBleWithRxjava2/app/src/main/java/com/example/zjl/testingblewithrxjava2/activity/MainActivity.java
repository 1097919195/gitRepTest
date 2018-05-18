package com.example.zjl.testingblewithrxjava2.activity;


import android.widget.Button;
import android.widget.TextView;

import com.example.zjl.testingblewithrxjava2.R;
import com.example.zjl.testingblewithrxjava2.contract.BleContract;
import com.example.zjl.testingblewithrxjava2.model.BleModel;
import com.example.zjl.testingblewithrxjava2.presenter.BlePresenter;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUtil;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.scan.ScanResult;

import butterknife.BindView;

public class MainActivity extends BaseActivity<BlePresenter,BleModel> implements BleContract.bleView {
    @BindView(R.id.btnBle)
    Button btnBle;
    @BindView(R.id.text2)
    TextView text2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        btnBle.setOnClickListener(v->{
            ToastUtil.showShort("onClick");
            text2.setText("start...");
            mPresenter.getBleUUIDWithMac("7C:EC:79:E5:B3:B4");
        });

    }

    @Override
    public void returnGetBleDeviceData(ScanResult scanResult) {

    }

    @Override
    public void returnGetBleUUIDWithMac(RxBleDeviceServices deviceServices, String macAddress) {
        text2.setText(macAddress);
        ToastUtil.showShort("OK");
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {
        text2.setText(msg);
    }
}
