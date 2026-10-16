package androidx.camera.core.impl;

import com.google.android.gms.internal.mlkit_vision_barcode.lc;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f1534a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public final Object f1535b;

    /* renamed from: c, reason: collision with root package name */
    public int f1536c;

    /* renamed from: d, reason: collision with root package name */
    public final f8.f f1537d;
    public final HashMap e;

    /* renamed from: f, reason: collision with root package name */
    public int f1538f;

    public z(f8.f fVar) {
        Object obj = new Object();
        this.f1535b = obj;
        this.e = new HashMap();
        this.f1536c = 1;
        synchronized (obj) {
            this.f1537d = fVar;
            this.f1538f = this.f1536c;
        }
    }

    public static void c(androidx.camera.camera2.internal.i iVar, CameraInternal$State cameraInternal$State) {
        if (lc.b()) {
            lc.c(cameraInternal$State.ordinal(), "CX:State[" + iVar + "]");
        }
    }

    public final y a(String str) {
        HashMap hashMap = this.e;
        for (t.m mVar : hashMap.keySet()) {
            if (str.equals(mVar.getCameraInfo().c())) {
                return (y) hashMap.get(mVar);
            }
        }
        return null;
    }

    public final void b() {
        boolean d5 = com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "CameraStateRegistry");
        StringBuilder sb2 = this.f1534a;
        if (d5) {
            sb2.setLength(0);
            sb2.append("Recalculating open cameras:\n");
            sb2.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            sb2.append("-------------------------------------------------------------------\n");
        }
        int i3 = 0;
        for (Map.Entry entry : this.e.entrySet()) {
            if (com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "CameraStateRegistry")) {
                sb2.append(String.format(Locale.US, "%-45s%-22s\n", ((t.m) entry.getKey()).toString(), ((y) entry.getValue()).f1520a != null ? ((y) entry.getValue()).f1520a.toString() : Constants.APP_VERSION_UNKNOWN));
            }
            CameraInternal$State cameraInternal$State = ((y) entry.getValue()).f1520a;
            if (cameraInternal$State != null && cameraInternal$State.holdsCameraSlot()) {
                i3++;
            }
        }
        if (com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "CameraStateRegistry")) {
            sb2.append("-------------------------------------------------------------------\n");
            Locale locale = Locale.US;
            sb2.append(android.support.v4.media.session.e.g(i3, "Open count: ", this.f1536c, " (Max allowed: ", ")"));
            com.google.android.gms.internal.mlkit_vision_common.a0.a("CameraStateRegistry", sb2.toString());
        }
        this.f1538f = Math.max(this.f1536c - i3, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:4:0x0007, B:6:0x001f, B:8:0x002e, B:11:0x0037, B:13:0x0068, B:15:0x006c, B:17:0x0070, B:23:0x0085, B:25:0x008d, B:28:0x0098, B:31:0x00ac, B:32:0x00af, B:37:0x007e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:4:0x0007, B:6:0x001f, B:8:0x002e, B:11:0x0037, B:13:0x0068, B:15:0x006c, B:17:0x0070, B:23:0x0085, B:25:0x008d, B:28:0x0098, B:31:0x00ac, B:32:0x00af, B:37:0x007e), top: B:3:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(androidx.camera.camera2.internal.i r13) {
        /*
            r12 = this;
            java.lang.String r0 = "tryOpenCamera("
            java.lang.String r1 = " --> "
            java.lang.Object r2 = r12.f1535b
            monitor-enter(r2)
            java.util.HashMap r3 = r12.e     // Catch: java.lang.Throwable -> L66
            java.lang.Object r3 = r3.get(r13)     // Catch: java.lang.Throwable -> L66
            androidx.camera.core.impl.y r3 = (androidx.camera.core.impl.y) r3     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = "Camera must first be registered with registerCamera()"
            com.google.android.gms.internal.mlkit_vision_barcode.pd.e(r3, r4)     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = "CameraStateRegistry"
            r5 = 3
            boolean r4 = com.google.android.gms.internal.mlkit_vision_common.a0.d(r5, r4)     // Catch: java.lang.Throwable -> L66
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L68
            java.lang.StringBuilder r4 = r12.f1534a     // Catch: java.lang.Throwable -> L66
            r4.setLength(r7)     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r4 = r12.f1534a     // Catch: java.lang.Throwable -> L66
            java.util.Locale r8 = java.util.Locale.US     // Catch: java.lang.Throwable -> L66
            int r8 = r12.f1538f     // Catch: java.lang.Throwable -> L66
            androidx.camera.core.impl.CameraInternal$State r9 = r3.f1520a     // Catch: java.lang.Throwable -> L66
            if (r9 == 0) goto L36
            boolean r9 = r9.holdsCameraSlot()     // Catch: java.lang.Throwable -> L66
            if (r9 == 0) goto L36
            r9 = r6
            goto L37
        L36:
            r9 = r7
        L37:
            androidx.camera.core.impl.CameraInternal$State r10 = r3.f1520a     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L66
            r11.append(r13)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = ") [Available Cameras: "
            r11.append(r0)     // Catch: java.lang.Throwable -> L66
            r11.append(r8)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = ", Already Open: "
            r11.append(r0)     // Catch: java.lang.Throwable -> L66
            r11.append(r9)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = " (Previous state: "
            r11.append(r0)     // Catch: java.lang.Throwable -> L66
            r11.append(r10)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = ")]"
            r11.append(r0)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = r11.toString()     // Catch: java.lang.Throwable -> L66
            r4.append(r0)     // Catch: java.lang.Throwable -> L66
            goto L68
        L66:
            r13 = move-exception
            goto Lb1
        L68:
            int r0 = r12.f1538f     // Catch: java.lang.Throwable -> L66
            if (r0 > 0) goto L7e
            androidx.camera.core.impl.CameraInternal$State r0 = r3.f1520a     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L78
            boolean r0 = r0.holdsCameraSlot()     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L78
            r0 = r6
            goto L79
        L78:
            r0 = r7
        L79:
            if (r0 == 0) goto L7c
            goto L7e
        L7c:
            r6 = r7
            goto L85
        L7e:
            androidx.camera.core.impl.CameraInternal$State r0 = androidx.camera.core.impl.CameraInternal$State.OPENING     // Catch: java.lang.Throwable -> L66
            r3.f1520a = r0     // Catch: java.lang.Throwable -> L66
            c(r13, r0)     // Catch: java.lang.Throwable -> L66
        L85:
            java.lang.String r13 = "CameraStateRegistry"
            boolean r13 = com.google.android.gms.internal.mlkit_vision_common.a0.d(r5, r13)     // Catch: java.lang.Throwable -> L66
            if (r13 == 0) goto Laa
            java.lang.StringBuilder r13 = r12.f1534a     // Catch: java.lang.Throwable -> L66
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Throwable -> L66
            if (r6 == 0) goto L96
            java.lang.String r0 = "SUCCESS"
            goto L98
        L96:
            java.lang.String r0 = "FAIL"
        L98:
            java.lang.String r0 = r1.concat(r0)     // Catch: java.lang.Throwable -> L66
            r13.append(r0)     // Catch: java.lang.Throwable -> L66
            java.lang.String r13 = "CameraStateRegistry"
            java.lang.StringBuilder r0 = r12.f1534a     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.mlkit_vision_common.a0.a(r13, r0)     // Catch: java.lang.Throwable -> L66
        Laa:
            if (r6 == 0) goto Laf
            r12.b()     // Catch: java.lang.Throwable -> L66
        Laf:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L66
            return r6
        Lb1:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L66
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.z.d(androidx.camera.camera2.internal.i):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f1535b
            monitor-enter(r0)
            f8.f r1 = r5.f1537d     // Catch: java.lang.Throwable -> Ld
            int r1 = r1.f13516b     // Catch: java.lang.Throwable -> Ld
            r2 = 2
            r3 = 1
            if (r1 == r2) goto Lf
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            return r3
        Ld:
            r6 = move-exception
            goto L55
        Lf:
            androidx.camera.core.impl.y r6 = r5.a(r6)     // Catch: java.lang.Throwable -> Ld
            r1 = 0
            if (r6 == 0) goto L19
            androidx.camera.core.impl.CameraInternal$State r6 = r6.f1520a     // Catch: java.lang.Throwable -> Ld
            goto L1a
        L19:
            r6 = r1
        L1a:
            if (r7 == 0) goto L21
            androidx.camera.core.impl.y r7 = r5.a(r7)     // Catch: java.lang.Throwable -> Ld
            goto L22
        L21:
            r7 = r1
        L22:
            if (r7 == 0) goto L26
            androidx.camera.core.impl.CameraInternal$State r1 = r7.f1520a     // Catch: java.lang.Throwable -> Ld
        L26:
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal$State.OPEN     // Catch: java.lang.Throwable -> Ld
            boolean r2 = r7.equals(r6)     // Catch: java.lang.Throwable -> Ld
            r4 = 0
            if (r2 != 0) goto L3a
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal$State.CONFIGURED     // Catch: java.lang.Throwable -> Ld
            boolean r6 = r2.equals(r6)     // Catch: java.lang.Throwable -> Ld
            if (r6 == 0) goto L38
            goto L3a
        L38:
            r6 = r4
            goto L3b
        L3a:
            r6 = r3
        L3b:
            boolean r7 = r7.equals(r1)     // Catch: java.lang.Throwable -> Ld
            if (r7 != 0) goto L4c
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal$State.CONFIGURED     // Catch: java.lang.Throwable -> Ld
            boolean r7 = r7.equals(r1)     // Catch: java.lang.Throwable -> Ld
            if (r7 == 0) goto L4a
            goto L4c
        L4a:
            r7 = r4
            goto L4d
        L4c:
            r7 = r3
        L4d:
            if (r6 == 0) goto L52
            if (r7 == 0) goto L52
            goto L53
        L52:
            r3 = r4
        L53:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            return r3
        L55:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.z.e(java.lang.String, java.lang.String):boolean");
    }
}
