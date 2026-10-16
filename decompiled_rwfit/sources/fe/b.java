package fe;

import android.view.View;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.lifecycle.c0;
import com.google.android.gms.internal.mlkit_vision_barcode.zc;
import t.i1;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements c0, je.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f13575a;

    public /* synthetic */ b(d dVar) {
        this.f13575a = dVar;
    }

    public void a(boolean z5) {
        d dVar = this.f13575a;
        View view = dVar.f13587l;
        if (view != null) {
            if (z5) {
                if (view.getVisibility() != 0) {
                    dVar.f13587l.setVisibility(0);
                    dVar.f13587l.setSelected(dVar.a());
                    return;
                }
                return;
            }
            if (view.getVisibility() != 0 || dVar.a()) {
                return;
            }
            dVar.f13587l.setVisibility(4);
            dVar.f13587l.setSelected(false);
        }
    }

    public void b(zc zcVar) {
        d dVar = this.f13575a;
        dVar.getClass();
        if (zcVar instanceof ie.b) {
            ie.b bVar = (ie.b) zcVar;
            LifecycleCamera lifecycleCamera = dVar.f13582g;
            i1 i1Var = lifecycleCamera != null ? (i1) lifecycleCamera.f1546c.f19853q.f1433b.k().d() : null;
            if (i1Var != null) {
                float b3 = i1Var.b() * bVar.f14408a;
                LifecycleCamera lifecycleCamera2 = dVar.f13582g;
                i1 i1Var2 = lifecycleCamera2 != null ? (i1) lifecycleCamera2.f1546c.f19853q.f1433b.k().d() : null;
                if (i1Var2 != null) {
                    dVar.f13582g.f1546c.f19852p.f(Math.max(Math.min(b3, i1Var2.a()), i1Var2.d()));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x004f, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0058, code lost:
    
        throw r8;
     */
    @Override // androidx.lifecycle.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(java.lang.Object r8) {
        /*
            r7 = this;
            fe.d r0 = r7.f13575a
            fe.a r8 = (fe.a) r8
            if (r8 == 0) goto L59
            monitor-enter(r0)
            boolean r1 = r0.f13586k     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto L55
            boolean r1 = r0.f13585j     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto L10
            goto L55
        L10:
            r1 = 1
            r0.f13586k = r1     // Catch: java.lang.Throwable -> L4f
            r1 = 0
            r0.f13585j = r1     // Catch: java.lang.Throwable -> L4f
            je.d r2 = r0.f13591p     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L47
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L4f
            boolean r3 = r2.f15423d     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L29
            android.media.MediaPlayer r3 = r2.f15421b     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L29
            r3.start()     // Catch: java.lang.Throwable -> L27
            goto L29
        L27:
            r8 = move-exception
            goto L45
        L29:
            boolean r3 = r2.e     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L43
            android.os.Vibrator r3 = r2.f15422c     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L43
            boolean r3 = r3.hasVibrator()     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L43
            android.os.Vibrator r3 = r2.f15422c     // Catch: java.lang.Throwable -> L27
            r4 = 100
            r6 = -1
            android.os.VibrationEffect r4 = android.os.VibrationEffect.createOneShot(r4, r6)     // Catch: java.lang.Throwable -> L27
            r3.vibrate(r4)     // Catch: java.lang.Throwable -> L27
        L43:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4f
            goto L47
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            throw r8     // Catch: java.lang.Throwable -> L4f
        L47:
            com.king.camera.scan.BaseCameraScanActivity r2 = r0.f13589n     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L51
            r2.C(r8)     // Catch: java.lang.Throwable -> L4f
            goto L51
        L4f:
            r8 = move-exception
            goto L57
        L51:
            r0.f13586k = r1     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r0)
            return
        L55:
            monitor-exit(r0)
            return
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            throw r8
        L59:
            com.king.camera.scan.BaseCameraScanActivity r8 = r0.f13589n
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.b.i(java.lang.Object):void");
    }
}
