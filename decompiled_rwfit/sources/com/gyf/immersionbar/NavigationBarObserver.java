package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class NavigationBarObserver extends ContentObserver {
    private Application mApplication;
    private Boolean mIsRegister;
    private ArrayList<OnNavigationBarListener> mListeners;

    public static class NavigationBarObserverInstance {
        private static final NavigationBarObserver INSTANCE = new NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }

    public static NavigationBarObserver getInstance() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    public void addOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        if (this.mListeners.contains(onNavigationBarListener)) {
            return;
        }
        this.mListeners.add(onNavigationBarListener);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z5) {
        ArrayList<OnNavigationBarListener> arrayList;
        super.onChange(z5);
        Application application = this.mApplication;
        if (application == null || application.getContentResolver() == null || (arrayList = this.mListeners) == null || arrayList.isEmpty()) {
            return;
        }
        int i3 = OSUtils.isMIUI() ? Settings.Global.getInt(this.mApplication.getContentResolver(), "force_fsg_nav_bar", 0) : OSUtils.isEMUI() ? !OSUtils.isEMUI3_x() ? Settings.Global.getInt(this.mApplication.getContentResolver(), "navigationbar_is_min", 0) : Settings.System.getInt(this.mApplication.getContentResolver(), "navigationbar_is_min", 0) : 0;
        ArrayList<OnNavigationBarListener> arrayList2 = this.mListeners;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            OnNavigationBarListener onNavigationBarListener = arrayList2.get(i10);
            i10++;
            OnNavigationBarListener onNavigationBarListener2 = onNavigationBarListener;
            boolean z6 = true;
            if (i3 == 1) {
                z6 = false;
            }
            onNavigationBarListener2.onNavigationBarChange(z6);
        }
    }

    public void register(Application application) {
        this.mApplication = application;
        if (application == null || application.getContentResolver() == null || this.mIsRegister.booleanValue()) {
            return;
        }
        Uri uriFor = OSUtils.isMIUI() ? Settings.Global.getUriFor("force_fsg_nav_bar") : OSUtils.isEMUI() ? !OSUtils.isEMUI3_x() ? Settings.Global.getUriFor("navigationbar_is_min") : Settings.System.getUriFor("navigationbar_is_min") : null;
        if (uriFor != null) {
            this.mApplication.getContentResolver().registerContentObserver(uriFor, true, this);
            this.mIsRegister = Boolean.TRUE;
        }
    }

    public void removeOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        ArrayList<OnNavigationBarListener> arrayList;
        if (onNavigationBarListener == null || (arrayList = this.mListeners) == null) {
            return;
        }
        arrayList.remove(onNavigationBarListener);
    }

    private NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mIsRegister = Boolean.FALSE;
    }
}
