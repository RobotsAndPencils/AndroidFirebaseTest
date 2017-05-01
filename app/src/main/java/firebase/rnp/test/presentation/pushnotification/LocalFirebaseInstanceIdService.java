package firebase.rnp.test.presentation.pushnotification;

import com.google.firebase.iid.FirebaseInstanceIdService;

import firebase.rnp.test.app.common.App;
import firebase.rnp.test.app.pushnotification.infrastructure.FirebasePushNotificationProvider;
import firebase.rnp.test.presentation.common.dagger.AppComponent;
import timber.log.Timber;

public class LocalFirebaseInstanceIdService extends FirebaseInstanceIdService {

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        AppComponent appComponent = App.get(this).getAppComponent();

        FirebasePushNotificationProvider pushNotificationProvider = appComponent.getFirebasePushNotificationProvider();
        String refreshedToken = pushNotificationProvider.getToken();
        Timber.d("Refreshed Firebase token: %s", refreshedToken);

    }

}
