package com.example.zjl.testingble.app;

import android.content.Context;


import com.example.zjl.testingble.BuildConfig;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.polidea.rxandroidble.RxBleClient;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class AppApplication extends BaseApplication {

    private RxBleClient rxBleClient;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger,注意拷贝的话BuildConfig.LOG_DEBUG一定要是在当前module下的包名，配置文件中判断测适和发行版本
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
        rxBleClient = RxBleClient.create(this);
    }

    public static RxBleClient getRxBleClient(Context context) {
        AppApplication application = ((AppApplication) context.getApplicationContext());
        return application.rxBleClient;
    }
}
