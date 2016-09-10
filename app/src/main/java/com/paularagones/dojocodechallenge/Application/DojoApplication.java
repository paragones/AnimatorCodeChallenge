package com.paularagones.dojocodechallenge.Application;

import android.app.Application;

import com.paularagones.dojocodechallenge.Component.DaggerServiceComponent;
import com.paularagones.dojocodechallenge.Component.ServiceComponent;

/**
 * Created by Mack and Aragones on 10.09.2016.
 */
public class DojoApplication extends Application {

    ServiceComponent serviceComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        serviceComponent = DaggerServiceComponent.create();
    }

    public ServiceComponent getServiceComponent() {
        return serviceComponent;
    }
}
