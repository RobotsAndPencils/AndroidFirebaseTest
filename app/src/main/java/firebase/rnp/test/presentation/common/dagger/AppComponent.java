package firebase.rnp.test.presentation.common.dagger;


import javax.inject.Singleton;

import dagger.Component;
import firebase.rnp.test.app.common.App;
import firebase.rnp.test.app.pushnotification.infrastructure.FirebasePushNotificationProvider;
import firebase.rnp.test.presentation.MainActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    App getApp();

    void inject(MainActivity mainActivity);

    FirebasePushNotificationProvider getFirebasePushNotificationProvider();

}

