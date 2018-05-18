package com.example.zjl.testingble.activity;

import android.widget.Button;
import android.widget.TextView;

import com.example.zjl.testingble.R;
import com.example.zjl.testingble.contract.BleContract;
import com.example.zjl.testingble.model.BleModel;
import com.example.zjl.testingble.presenter.BlePresenter;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUtil;
import com.polidea.rxandroidble.RxBleDeviceServices;
import com.polidea.rxandroidble.scan.ScanResult;

import butterknife.BindView;

public class MainActivity extends BaseActivity<BlePresenter,BleModel> implements BleContract.bleView {

    @BindView(R.id.btnBle)
    Button btnBle;
    @BindView(R.id.text1)
    TextView text1;

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
            text1.setText("start...");
            mPresenter.getBleUUIDWithMac("7C:EC:79:E5:B3:B4");

        });
    }

    @Override
    public void returnGetBleDeviceData(ScanResult scanResult) {

    }

    @Override
    public void returnGetBleUUIDWithMac(RxBleDeviceServices deviceServices, String macAddress) {
        text1.setText(macAddress);
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
        text1.setText(msg);
    }
}
