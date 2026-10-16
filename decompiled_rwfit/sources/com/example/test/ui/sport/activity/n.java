package com.example.test.ui.sport.activity;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class n implements p7.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f8181a;

    public n(long j4) {
        this.f8181a = j4;
    }

    @Override // p7.b
    public final String getFormattedValue(float f2, n7.a aVar) {
        long j4 = (this.f8181a + (((int) f2) * 60)) * 1000;
        try {
            return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(j4, " date translate error ", e.getMessage()));
            return null;
        }
    }
}
