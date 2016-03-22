package com.foodenak.android.permissiondelegate

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.support.v4.app.Fragment

/**
 * Created by kukuh on 11/2/15.
 */
open class FragmentPermissionDelegate constructor(
        private val fragment: Fragment,
        private val permissions: Array<String>,
        private val requestCode: Int,
        private val settingRequestCode: Int,
        private val callback: PermissionCallback) : AbstractPermissionDelegate(requestCode, callback) {

    override fun runWithCheck() {
        if (hasSelfPermissions(fragment.context, permissions)) {
            callback.onPermissionGranted();
        } else {
            if (shouldShowRationale(fragment.activity, permissions)) {
                callback.onShowRationale()
            } else {
                fragment.requestPermissions(permissions, requestCode);
            }
        }
    }

    override fun requestPermission() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${fragment.context.packageName}"));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        fragment.startActivityForResult(intent, settingRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (this.settingRequestCode != requestCode) return
        if (hasSelfPermissions(fragment.context, permissions)) {
            callback.onPermissionGranted()
        } else {
            callback.onPermissionDenied()
        }
    }
}
