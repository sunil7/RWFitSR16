package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;

/* loaded from: classes.dex */
public abstract class g6 {
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0043 -> B:16:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static o2.e a(byte[] r7) {
        /*
            o2.e r0 = new o2.e
            r0.<init>()
            if (r7 != 0) goto L8
            goto L5f
        L8:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4b
            int r7 = r2.readInt()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
        L17:
            if (r7 <= 0) goto L36
            java.lang.String r3 = r2.readUTF()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            boolean r4 = r2.readBoolean()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            o2.d r5 = new o2.d     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r5.<init>(r3, r4)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            java.util.HashSet r3 = r0.f16708a     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r3.add(r5)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            int r7 = r7 + (-1)
            goto L17
        L32:
            r7 = move-exception
            goto L60
        L34:
            r7 = move-exception
            goto L4f
        L36:
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L3e
        L3a:
            r7 = move-exception
            r7.printStackTrace()
        L3e:
            r1.close()     // Catch: java.io.IOException -> L42
            goto L5f
        L42:
            r7 = move-exception
            r7.printStackTrace()
            goto L5f
        L47:
            r0 = move-exception
            r2 = r7
            r7 = r0
            goto L60
        L4b:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
        L4f:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r7 = move-exception
            r7.printStackTrace()
        L5c:
            r1.close()     // Catch: java.io.IOException -> L42
        L5f:
            return r0
        L60:
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r0 = move-exception
            r0.printStackTrace()
        L6a:
            r1.close()     // Catch: java.io.IOException -> L6e
            goto L72
        L6e:
            r0 = move-exception
            r0.printStackTrace()
        L72:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.g6.a(byte[]):o2.e");
    }

    public static BackoffPolicy b(int i3) {
        if (i3 == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i3 == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "Could not convert ", " to BackoffPolicy"));
    }

    public static NetworkType c(int i3) {
        if (i3 == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i3 == 1) {
            return NetworkType.CONNECTED;
        }
        if (i3 == 2) {
            return NetworkType.UNMETERED;
        }
        if (i3 == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i3 == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT < 30 || i3 != 5) {
            throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "Could not convert ", " to NetworkType"));
        }
        return NetworkType.TEMPORARILY_UNMETERED;
    }

    public static OutOfQuotaPolicy d(int i3) {
        if (i3 == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i3 == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "Could not convert ", " to OutOfQuotaPolicy"));
    }

    public static WorkInfo$State e(int i3) {
        if (i3 == 0) {
            return WorkInfo$State.ENQUEUED;
        }
        if (i3 == 1) {
            return WorkInfo$State.RUNNING;
        }
        if (i3 == 2) {
            return WorkInfo$State.SUCCEEDED;
        }
        if (i3 == 3) {
            return WorkInfo$State.FAILED;
        }
        if (i3 == 4) {
            return WorkInfo$State.BLOCKED;
        }
        if (i3 == 5) {
            return WorkInfo$State.CANCELLED;
        }
        throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "Could not convert ", " to State"));
    }

    public static int f(WorkInfo$State workInfo$State) {
        switch (x2.j.f19767a[workInfo$State.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + workInfo$State + " to int");
        }
    }
}
