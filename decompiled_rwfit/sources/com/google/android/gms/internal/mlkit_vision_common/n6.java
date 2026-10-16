package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;

/* loaded from: classes.dex */
public abstract class n6 {

    /* renamed from: a, reason: collision with root package name */
    public static Context f10047a;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r1 = r3.f11408b.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(int r5, long r6, java.lang.String r8, java.lang.String r9, o4.c r10) {
        /*
            r0 = 0
            if (r9 == 0) goto L6e
            if (r8 == 0) goto L6e
            java.lang.Object r10 = r10.f16733b
            androidx.appcompat.widget.b0 r10 = (androidx.appcompat.widget.b0) r10
            monitor-enter(r10)
            java.lang.Object r1 = r10.f873b     // Catch: java.lang.Throwable -> L44
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L44
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L44
            r2 = r0
        L13:
            if (r2 >= r1) goto L49
            java.lang.Object r3 = r10.f873b     // Catch: java.lang.Throwable -> L44
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L44
            java.lang.Object r3 = r3.valueAt(r2)     // Catch: java.lang.Throwable -> L44
            com.liulishuo.filedownloader.download.d r3 = (com.liulishuo.filedownloader.download.d) r3     // Catch: java.lang.Throwable -> L44
            if (r3 != 0) goto L22
            goto L46
        L22:
            boolean r4 = r3.h()     // Catch: java.lang.Throwable -> L44
            if (r4 == 0) goto L46
            com.liulishuo.filedownloader.model.FileDownloadModel r4 = r3.f11408b     // Catch: java.lang.Throwable -> L44
            int r4 = r4.h()     // Catch: java.lang.Throwable -> L44
            if (r4 == r5) goto L46
            com.liulishuo.filedownloader.model.FileDownloadModel r4 = r3.f11408b     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = r4.m()     // Catch: java.lang.Throwable -> L44
            boolean r4 = r8.equals(r4)     // Catch: java.lang.Throwable -> L44
            if (r4 == 0) goto L46
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r3.f11408b     // Catch: java.lang.Throwable -> L44
            int r1 = r1.h()     // Catch: java.lang.Throwable -> L44
            monitor-exit(r10)
            goto L4b
        L44:
            r5 = move-exception
            goto L6c
        L46:
            int r2 = r2 + 1
            goto L13
        L49:
            monitor-exit(r10)
            r1 = r0
        L4b:
            if (r1 == 0) goto L6e
            ue.e r10 = ue.c.f19065a
            com.liulishuo.filedownloader.exception.PathConflictException r0 = new com.liulishuo.filedownloader.exception.PathConflictException
            r0.<init>(r1, r8, r9)
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 <= 0) goto L61
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot r8 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot
            r8.<init>(r5, r6, r0)
            goto L67
        L61:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot r8 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot
            int r6 = (int) r6
            r8.<init>(r5, r6, r0)
        L67:
            r10.a(r8)
            r5 = 1
            return r5
        L6c:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L44
            throw r5
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.n6.a(int, long, java.lang.String, java.lang.String, o4.c):boolean");
    }

    public static boolean b(int i3, String str, boolean z5, boolean z6) {
        if (z5 || str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        ue.e eVar = ue.c.f19065a;
        long length = file.length();
        eVar.a(length > 2147483647L ? z6 ? new LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i3, length, true) : new LargeMessageSnapshot.CompletedSnapshot(i3, length, true) : z6 ? new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i3, (int) length, true) : new SmallMessageSnapshot.CompletedSnapshot(i3, (int) length, true));
        return true;
    }

    public static boolean c(int i3, FileDownloadModel fileDownloadModel, o4.c cVar, boolean z5) {
        if (!cVar.j(fileDownloadModel)) {
            return false;
        }
        ue.e eVar = ue.c.f19065a;
        long j4 = fileDownloadModel.j();
        long n4 = fileDownloadModel.n();
        eVar.a(n4 > 2147483647L ? z5 ? new LargeMessageSnapshot.WarnFlowDirectlySnapshot(i3, j4, n4) : new LargeMessageSnapshot.WarnMessageSnapshot(i3, j4, n4) : z5 ? new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i3, (int) j4, (int) n4) : new SmallMessageSnapshot.WarnMessageSnapshot(i3, (int) j4, (int) n4));
        return true;
    }
}
