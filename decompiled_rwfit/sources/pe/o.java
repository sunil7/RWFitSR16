package pe;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Messenger;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.impl.i1;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.drawerlayout.widget.DrawerLayout;
import com.contrarywind.view.WheelView;
import com.example.blesdk.ble.scan.ScanResult;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.yanzhenjie.recyclerview.widget.StickyNestedScrollView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import n.m0;

/* loaded from: classes2.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17579a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17580b;

    public /* synthetic */ o(Object obj, int i3) {
        this.f17579a = i3;
        this.f17580b = obj;
    }

    public boolean equals(Object obj) {
        switch (this.f17579a) {
            case 0:
                return super.equals(obj) || obj == ((c) this.f17580b);
            default:
                return super.equals(obj);
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        View e;
        int width;
        int i3;
        int i10;
        float f2;
        switch (this.f17579a) {
            case 0:
                c cVar = (c) this.f17580b;
                if (cVar.f17558d != 10) {
                    o6.b(cVar, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(cVar.a()), Byte.valueOf(cVar.f17558d));
                    return;
                }
                b bVar = cVar.f17557c;
                bVar.getClass();
                s c9 = p.f17581a.c();
                try {
                    if (c9.a(bVar)) {
                        return;
                    }
                    synchronized (cVar.f17556b) {
                        try {
                            if (cVar.f17558d != 10) {
                                o6.b(cVar, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(cVar.a()), Byte.valueOf(cVar.f17558d));
                            } else {
                                cVar.f17558d = (byte) 11;
                                i1 i1Var = e.f17562a;
                                i1Var.a(bVar);
                                if (!n6.b(bVar.a(), bVar.b(), false, true)) {
                                    m0 m0Var = j.f17574a;
                                    String str = bVar.f17547d;
                                    String str2 = bVar.e;
                                    boolean z5 = bVar.f17549g;
                                    cVar.f17557c.getClass();
                                    boolean n4 = ((r) m0Var.f16254b).n(str, str2, z5);
                                    if (cVar.f17558d == -2) {
                                        o6.b(cVar, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(cVar.a()));
                                        if (n4) {
                                            m0Var.c(cVar.a());
                                        }
                                    } else if (n4) {
                                        c9.b(bVar);
                                    } else if (!c9.a(bVar)) {
                                        MessageSnapshot d5 = cVar.d(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                                        ArrayList arrayList = i1Var.f1421a;
                                        if (arrayList.isEmpty() || !arrayList.contains(bVar)) {
                                            c9.b(bVar);
                                            i1Var.a(bVar);
                                        }
                                        i1Var.i(bVar, d5);
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    e.f17562a.i(bVar, cVar.d(th3));
                    return;
                }
            case 1:
                q1.d dVar = (q1.d) this.f17580b;
                int i11 = dVar.f17734b.f17382o;
                int i12 = dVar.f17733a;
                boolean z6 = i12 == 3;
                DrawerLayout drawerLayout = dVar.f17736d;
                if (z6) {
                    e = drawerLayout.e(3);
                    width = (e != null ? -e.getWidth() : 0) + i11;
                } else {
                    e = drawerLayout.e(5);
                    width = drawerLayout.getWidth() - i11;
                }
                if (e != null) {
                    if (((!z6 || e.getLeft() >= width) && (z6 || e.getLeft() <= width)) || drawerLayout.h(e) != 0) {
                        return;
                    }
                    q1.c cVar2 = (q1.c) e.getLayoutParams();
                    dVar.f17734b.s(e, width, e.getTop());
                    cVar2.f17731c = true;
                    drawerLayout.invalidate();
                    View e10 = drawerLayout.e(i12 == 3 ? 5 : 3);
                    if (e10 != null) {
                        drawerLayout.b(e10);
                    }
                    if (drawerLayout.r) {
                        return;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i13 = 0; i13 < childCount; i13++) {
                        drawerLayout.getChildAt(i13).dispatchTouchEvent(obtain);
                    }
                    obtain.recycle();
                    drawerLayout.r = true;
                    return;
                }
                return;
            case 2:
                ((CountDownLatch) this.f17580b).countDown();
                return;
            case 3:
                StickyNestedScrollView stickyNestedScrollView = (StickyNestedScrollView) this.f17580b;
                View view = stickyNestedScrollView.E;
                if (view != null) {
                    int z8 = stickyNestedScrollView.z(view);
                    View view2 = stickyNestedScrollView.E;
                    stickyNestedScrollView.getClass();
                    int bottom = view2.getBottom();
                    while (view2.getParent() != null && view2.getParent() != stickyNestedScrollView.getChildAt(0)) {
                        view2 = (View) view2.getParent();
                        bottom += view2.getBottom();
                    }
                    stickyNestedScrollView.invalidate(z8, bottom, stickyNestedScrollView.A(stickyNestedScrollView.E), (int) (stickyNestedScrollView.E.getHeight() + stickyNestedScrollView.F + stickyNestedScrollView.getScrollY()));
                }
                stickyNestedScrollView.postDelayed(this, 16L);
                return;
            case 4:
                Carousel carousel = (Carousel) this.f17580b;
                carousel.f1642o.setProgress(0.0f);
                carousel.getClass();
                carousel.getClass();
                int i14 = carousel.f1641n;
                throw null;
            case 5:
                s3.c cVar3 = (s3.c) this.f17580b;
                cVar3.e.r.removeView(cVar3.f18167c);
                cVar3.f18172i = false;
                cVar3.f18169f = false;
                cVar3.getClass();
                return;
            case 6:
                ((od.a) this.f17580b).f16918b.setOnClickListener(null);
                return;
            case 7:
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                synchronized (((t5.a) this.f17580b).f18526a) {
                    try {
                        Iterator it = ((t5.a) this.f17580b).f18536l.values().iterator();
                        while (it.hasNext()) {
                            ScanResult scanResult = (ScanResult) it.next();
                            if (scanResult.h() < elapsedRealtimeNanos - ((t5.a) this.f17580b).f18531g.h()) {
                                it.remove();
                                ((t5.a) this.f17580b).f18533i.post(new n5.a(8, this, scanResult));
                            }
                        }
                        if (!((t5.a) this.f17580b).f18536l.isEmpty()) {
                            t5.a aVar = (t5.a) this.f17580b;
                            aVar.f18533i.postDelayed(this, aVar.f18531g.i());
                        }
                    } finally {
                    }
                }
                return;
            case 8:
                vf.f fVar = ((vf.c) this.f17580b).f19244b.f19247a;
                SurfaceTexture surfaceTexture = fVar.f19249k;
                if (surfaceTexture != null) {
                    surfaceTexture.setOnFrameAvailableListener(null);
                    fVar.f19249k.release();
                    fVar.f19249k = null;
                }
                qf.d dVar2 = fVar.f19250l;
                if (dVar2 != null) {
                    dVar2.b();
                    fVar.f19250l = null;
                    return;
                }
                return;
            case 9:
                vf.j jVar = (vf.j) this.f17580b;
                if (jVar.f19241g == 0 || jVar.f19240f == 0 || (i3 = jVar.e) == 0 || (i10 = jVar.f19239d) == 0) {
                    return;
                }
                wf.a a3 = wf.a.a(i10, i3);
                wf.a a10 = wf.a.a(jVar.f19240f, jVar.f19241g);
                float f10 = 1.0f;
                if (a3.c() >= a10.c()) {
                    f2 = a3.c() / a10.c();
                } else {
                    float c10 = a10.c() / a3.c();
                    f2 = 1.0f;
                    f10 = c10;
                }
                ((TextureView) jVar.f19237b).setScaleX(f10);
                ((TextureView) jVar.f19237b).setScaleY(f2);
                jVar.f19238c = f10 > 1.02f || f2 > 1.02f;
                ef.b bVar2 = vf.a.f19235i;
                bVar2.b(1, "crop:", "applied scaleX=", Float.valueOf(f10));
                bVar2.b(1, "crop:", "applied scaleY=", Float.valueOf(f2));
                return;
            case 10:
                n.l lVar = (n.l) this.f17580b;
                if (((w.b) lVar.f16247d).f19272a.getAndSet(null) != null) {
                    ((Handler) lVar.f16245b).removeCallbacks((w.b) lVar.f16247d);
                    return;
                }
                return;
            case 11:
                ((ob.a) this.f17580b).cancel(true);
                return;
            case 12:
                x.l lVar2 = (x.l) this.f17580b;
                lVar2.f19711b = null;
                lVar2.f19710a = null;
                return;
            case 13:
                y1.a aVar2 = (y1.a) this.f17580b;
                aVar2.f19918f.f2426d.remove(((Messenger) aVar2.f19917d.f16022b).getBinder());
                return;
            case 14:
                WheelView wheelView = (WheelView) this.f17580b;
                wheelView.e.E(wheelView.getCurrentItem());
                return;
            default:
                n.l lVar3 = (n.l) this.f17580b;
                lVar3.getClass();
                while (true) {
                    try {
                        lVar3.f((z3.a) ((ReferenceQueue) lVar3.f16246c).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
        }
    }
}
