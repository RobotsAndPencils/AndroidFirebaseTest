package firebase.rnp.test.app.pushnotification.infrastructure;

import com.google.firebase.iid.FirebaseInstanceId;

import firebase.rnp.test.app.pushnotification.PushNotificationProvider;

public class FirebasePushNotificationProvider implements PushNotificationProvider {

    @Override
    public String getToken() {
        return FirebaseInstanceId.getInstance().getToken();
    }
}
