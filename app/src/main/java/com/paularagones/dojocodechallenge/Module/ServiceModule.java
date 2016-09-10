package com.paularagones.dojocodechallenge.Module;

import com.paularagones.dojocodechallenge.Services.FirebaseService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mack and Aragones on 10.09.2016.
 */

@Module
public class ServiceModule {

    @Provides
    @Singleton
    FirebaseService provideFirebaseService() {
        return FirebaseService.newInstance();
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }
}
