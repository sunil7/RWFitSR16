package androidx.emoji2.text;

import android.animation.ValueAnimator;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.material.datepicker.MaterialCalendar;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2032a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2033b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2034c;

    public /* synthetic */ i(int i3, int i10, Object obj) {
        this.f2032a = i10;
        this.f2034c = obj;
        this.f2033b = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jg.a aVar;
        ValueAnimator valueAnimator;
        switch (this.f2032a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f2034c;
                int size = arrayList.size();
                int i3 = 0;
                if (this.f2033b == 1) {
                    while (i3 < size) {
                        ((h) arrayList.get(i3)).b();
                        i3++;
                    }
                    break;
                } else {
                    while (i3 < size) {
                        ((h) arrayList.get(i3)).a();
                        i3++;
                    }
                    break;
                }
            case 1:
                ((androidx.viewpager2.widget.m) this.f2034c).i0(this.f2033b);
                break;
            case 2:
                ((MaterialCalendar) this.f2034c).f10399i.i0(this.f2033b);
                break;
            case 3:
                dg.d dVar = (dg.d) this.f2034c;
                SmartRefreshLayout smartRefreshLayout = dVar.f12395d;
                if (!smartRefreshLayout.N || this.f2033b >= 0) {
                    aVar = null;
                } else {
                    aVar = smartRefreshLayout.f11644c1.e(smartRefreshLayout.f11639b);
                    if (aVar != null) {
                        aVar.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                ab.q qVar = new ab.q(this, 6);
                int i10 = smartRefreshLayout.f11639b;
                if (i10 > 0) {
                    valueAnimator = smartRefreshLayout.f1.k(0);
                } else {
                    if (aVar != null || i10 == 0) {
                        ValueAnimator valueAnimator2 = smartRefreshLayout.f11677q1;
                        if (valueAnimator2 != null) {
                            valueAnimator2.setDuration(0L);
                            smartRefreshLayout.f11677q1.cancel();
                            smartRefreshLayout.f11677q1 = null;
                        }
                        smartRefreshLayout.f1.l(0, false);
                        smartRefreshLayout.f1.w(RefreshState.None);
                    } else if (dVar.f12394c && smartRefreshLayout.H) {
                        int i11 = -smartRefreshLayout.i0;
                        if (i10 >= i11) {
                            smartRefreshLayout.u(RefreshState.None);
                        } else {
                            valueAnimator = smartRefreshLayout.f1.k(i11);
                        }
                    } else {
                        valueAnimator = smartRefreshLayout.f1.k(0);
                    }
                    valueAnimator = null;
                }
                if (valueAnimator == null) {
                    qVar.onAnimationEnd(null);
                    break;
                } else {
                    valueAnimator.addListener(qVar);
                    break;
                }
                break;
            case 4:
                ff.n nVar = (ff.n) this.f2034c;
                CameraState cameraState = nVar.f13648d.e;
                CameraState cameraState2 = CameraState.BIND;
                boolean isAtLeast = cameraState.isAtLeast(cameraState2);
                int i12 = this.f2033b;
                if (!isAtLeast || !nVar.n()) {
                    if (i12 <= 0) {
                        i12 = 35;
                    }
                    nVar.f13654k = i12;
                    if (nVar.f13648d.e.isAtLeast(cameraState2)) {
                        nVar.A();
                        break;
                    }
                } else {
                    nVar.D(i12);
                    break;
                }
                break;
            case 5:
                b1.b bVar = (b1.b) ((y2.f) this.f2034c).f19953b;
                if (bVar != null) {
                    bVar.d(this.f2033b);
                    break;
                }
                break;
            case 6:
                ((o9.n) this.f2034c).f(this.f2033b);
                break;
            case 7:
                Iterator it = ((vf.e) this.f2034c).f19247a.f19251m.iterator();
                while (it.hasNext()) {
                    ((uf.m) it.next()).b(this.f2033b);
                }
                break;
            default:
                ((SystemForegroundService) this.f2034c).e.cancel(this.f2033b);
                break;
        }
    }

    public i(int i3, androidx.viewpager2.widget.m mVar) {
        this.f2032a = 1;
        this.f2033b = i3;
        this.f2034c = mVar;
    }

    public i(List list, int i3, Throwable th2) {
        this.f2032a = 0;
        pd.e(list, "initCallbacks cannot be null");
        this.f2034c = new ArrayList(list);
        this.f2033b = i3;
    }
}
