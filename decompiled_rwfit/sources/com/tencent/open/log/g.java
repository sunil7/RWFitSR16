package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f12073a = new g();

    public final String a(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 4 ? i3 != 8 ? i3 != 16 ? i3 != 32 ? "-" : "A" : "E" : "W" : "I" : "D" : "V";
    }

    public String a(int i3, Thread thread, long j4, String str, String str2, Throwable th2) {
        long j10 = j4 % 1000;
        Time time = new Time();
        time.set(j4);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a(i3));
        sb2.append('/');
        sb2.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb2.append('.');
        if (j10 < 10) {
            sb2.append("00");
        } else if (j10 < 100) {
            sb2.append('0');
        }
        sb2.append(j10);
        sb2.append(" [");
        if (thread == null) {
            sb2.append("N/A");
        } else {
            sb2.append(thread.getName());
        }
        android.support.v4.media.session.e.z(sb2, "][", str, "] ", str2);
        sb2.append('\n');
        if (th2 != null) {
            sb2.append("* Exception : \n");
            sb2.append(Log.getStackTraceString(th2));
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
