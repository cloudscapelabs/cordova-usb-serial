package com.cloudscape.usbserial

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

/**
 * Background Handler Activity
 */
@Suppress("HardCodedStringLiteral")
@SuppressLint("LongLogTag", "LogConditional")
class UsbAttachedHandlerActivity : Activity() {
  companion object {
    private const val TAG: String = "USBSERIAL (UsbAttachedHandlerActivity)"
  }

  /**
   * This activity will be started if the user touches a notification that we own.
   * We send it's data off to the push plugin for processing.
   * If needed, we boot up the main activity to kickstart the application.
   *
   * @param savedInstanceState
   *
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Log.v(TAG, "onCreate")
    forceMainActivityReload()
  }

  private fun forceMainActivityReload() {
    /*
     * Forces the main activity to re-launch if it's unloaded.
     */
    val launchIntent = packageManager.getLaunchIntentForPackage(applicationContext.packageName)

    launchIntent?.apply {
      addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
      addFlags(Intent.FLAG_FROM_BACKGROUND)
    }

    startActivity(launchIntent)
  }
}
