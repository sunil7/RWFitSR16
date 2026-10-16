package com.google.android.gms.internal.mlkit_vision_common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes.dex */
public abstract class i6 {
    public static Intent a(AppCompatActivity appCompatActivity) {
        Intent a3 = y0.j.a(appCompatActivity);
        if (a3 != null) {
            return a3;
        }
        try {
            String c9 = c(appCompatActivity, appCompatActivity.getComponentName());
            if (c9 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(appCompatActivity, c9);
            try {
                return c(appCompatActivity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + c9 + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Intent b(AppCompatActivity appCompatActivity, ComponentName componentName) {
        String c9 = c(appCompatActivity, componentName);
        if (c9 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), c9);
        return c(appCompatActivity, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String c(Activity activity, ComponentName componentName) {
        String string;
        ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return activity.getPackageName() + string;
    }
}
