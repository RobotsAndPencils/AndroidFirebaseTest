package firebase.rnp.test.presentation.common.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import firebase.rnp.test.app.common.App;
import firebase.rnp.test.app.pushnotification.PushNotificationProvider;
import firebase.rnp.test.app.pushnotification.infrastructure.FirebasePushNotificationProvider;
import firebase.rnp.test.app.util.ClipboardManager;

@Module
public class AppModule {
    private final App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Singleton
    @Provides
    App provideApp() {
        return mApp;
    }


    @Provides
    PushNotificationProvider providePushNotificationProvider(FirebasePushNotificationProvider firebasePushNotificationProvider) {
        return firebasePushNotificationProvider;
    }

    @Provides
    FirebasePushNotificationProvider provideFirebasePushNotificationProvider() {
        return new FirebasePushNotificationProvider();
    }

    @Provides
    @Singleton
    ClipboardManager provideClipboardManager() {
        return new ClipboardManager();
    }
}
