package com.foodenak.android.permissiondelegate

import android.content.Intent

/**
 * Created by kukuh on 11/2/15.
 */
interface PermissionDelegate {

    fun runWithCheck();

    fun onPermissionResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray);

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?);

    fun requestPermission();
}