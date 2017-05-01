package firebase.rnp.test.app.common;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import firebase.rnp.test.BuildConfig;
import firebase.rnp.test.presentation.common.dagger.AppComponent;
import firebase.rnp.test.presentation.common.dagger.AppModule;
import firebase.rnp.test.presentation.common.dagger.DaggerAppComponent;
import timber.log.Timber;

public class App extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    public AppComponent getAppComponent() {
        return this.appComponent;
    }

}
