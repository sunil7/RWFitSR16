package com.example.test.service;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;

/* loaded from: classes.dex */
public final class a extends PhoneStateListener {

    /* renamed from: a, reason: collision with root package name */
    public String f7648a;

    /* renamed from: b, reason: collision with root package name */
    public int f7649b;

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i3, String str) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneReceiver CustomPhoneStateListener", "CustomPhoneStateListener state: " + i3 + " incomingNumber: " + str);
        this.f7649b = -1;
        if (i3 == 0) {
            this.f7649b = 2;
        } else if (i3 == 1) {
            this.f7649b = 0;
        } else if (i3 == 2) {
            this.f7649b = 1;
        }
        this.f7648a = str;
        q0.a().b(this.f7649b, str);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneReceiver CustomPhoneStateListener", "CustomPhoneStateListener onServiceStateChanged: " + serviceState);
    }
}
