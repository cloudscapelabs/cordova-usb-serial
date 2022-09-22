package com.cloudscape.usbserial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class UsbAttachedHandlerActivity extends Activity {
    private final String TAG = UsbAttachedHandlerActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG, "onCreate");
        forceMainActivityReload();
    }

    public void forceMainActivityReload() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getApplicationContext().getPackageName());

        if (launchIntent != null) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            launchIntent.addFlags(Intent.FLAG_FROM_BACKGROUND);

            startActivity(launchIntent);
        }

    }
}
