package com.paularagones.dojocodechallenge.Component;

import com.paularagones.dojocodechallenge.Activities.MainActivity;
import com.paularagones.dojocodechallenge.Activities.SecondActivity;
import com.paularagones.dojocodechallenge.Module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mack and Aragones on 10.09.2016.
 */

@Singleton
@Component(modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(MainActivity activity);
    void inject(SecondActivity activity);
}
