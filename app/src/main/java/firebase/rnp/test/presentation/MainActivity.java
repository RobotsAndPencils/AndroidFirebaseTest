package firebase.rnp.test.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import firebase.rnp.test.R;
import firebase.rnp.test.app.common.App;
import firebase.rnp.test.app.pushnotification.infrastructure.FirebasePushNotificationProvider;
import firebase.rnp.test.app.util.ClipboardManager;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    FirebasePushNotificationProvider firebasePushNotificationProvider;

    @Inject
    ClipboardManager clipboardManager;

    private TextView mTextViewToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewToken = (TextView) findViewById(R.id.text_token);

        App.get(this).getAppComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        handleFirebaseToken();
    }

    private void handleFirebaseToken() {
        final String token = firebasePushNotificationProvider.getToken();

        mTextViewToken.setText(token);

        mTextViewToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                copyToken(token);
            }
        });
    }

    private void copyToken(final String token) {
        boolean clipped = clipboardManager.copyToClipboard(MainActivity.this, "token", token);
        if (clipped) {
            Toast.makeText(MainActivity.this, "Token copied to clipboard!", Toast.LENGTH_SHORT).show();
            Timber.d("Firebase Token is: " + token);
        }
    }

    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
    }
}
