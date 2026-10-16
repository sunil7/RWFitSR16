package com.tencent.open.log;

import android.util.Log;

/* loaded from: classes2.dex */
public final class e extends Tracer {

    /* renamed from: a, reason: collision with root package name */
    public static final e f12070a = new e();

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i3, Thread thread, long j4, String str, String str2, Throwable th2) {
        if (i3 == 1) {
            Log.v(str, str2, th2);
            return;
        }
        if (i3 == 2) {
            Log.d(str, str2, th2);
            return;
        }
        if (i3 == 4) {
            Log.i(str, str2, th2);
            return;
        }
        if (i3 == 8) {
            Log.w(str, str2, th2);
        } else if (i3 == 16) {
            Log.e(str, str2, th2);
        } else {
            if (i3 != 32) {
                return;
            }
            Log.e(str, str2, th2);
        }
    }
}
