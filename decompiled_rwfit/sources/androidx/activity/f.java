package androidx.activity;

import android.app.Notification;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e0;
import androidx.recyclerview.widget.f1;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.z1;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f361a;

    /* renamed from: b, reason: collision with root package name */
    public final int f362b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f363c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f364d;

    public /* synthetic */ f(Object obj, int i3, Object obj2, int i10) {
        this.f361a = i10;
        this.f363c = obj;
        this.f362b = i3;
        this.f364d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx.activity.result.a aVar;
        androidx.concurrent.futures.b bVar;
        ArrayList arrayList;
        int decrementAndGet;
        switch (this.f361a) {
            case 0:
                Object obj = ((yh.i) this.f364d).f20163a;
                g gVar = (g) this.f363c;
                String str = (String) gVar.f391b.get(Integer.valueOf(this.f362b));
                if (str == null) {
                    return;
                }
                androidx.activity.result.d dVar = (androidx.activity.result.d) gVar.f394f.get(str);
                if (dVar == null || (aVar = dVar.f386a) == null) {
                    gVar.f396h.remove(str);
                    gVar.f395g.put(str, obj);
                    return;
                } else {
                    if (gVar.e.remove(str)) {
                        aVar.b(obj);
                        return;
                    }
                    return;
                }
            case 1:
                ((g) this.f363c).a(this.f362b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f364d));
                return;
            case 2:
                ((TextView) this.f364d).setTypeface((Typeface) this.f363c, this.f362b);
                return;
            case 3:
                j0 j0Var = (j0) this.f363c;
                RecyclerView recyclerView = j0Var.r;
                if (recyclerView == null || !recyclerView.r) {
                    return;
                }
                e0 e0Var = (e0) this.f364d;
                if (e0Var.f2547k) {
                    return;
                }
                z1 z1Var = e0Var.e;
                if (z1Var.getAbsoluteAdapterPosition() != -1) {
                    f1 itemAnimator = j0Var.r.getItemAnimator();
                    if (itemAnimator == null || !itemAnimator.f()) {
                        ArrayList arrayList2 = j0Var.f2623p;
                        int size = arrayList2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            if (((e0) arrayList2.get(i3)).f2548l) {
                            }
                        }
                        j0Var.f2620m.onSwiped(z1Var, this.f362b);
                        return;
                    }
                    j0Var.r.post(this);
                    return;
                }
                return;
            case 4:
                ((BottomSheetBehavior) this.f363c).D(this.f362b, (View) this.f364d);
                return;
            case 5:
                ((r2.g) this.f364d).b(this.f362b, (Intent) this.f363c);
                return;
            case 6:
                Matrix matrix = new Matrix();
                vf.j jVar = (vf.j) this.f363c;
                int i10 = jVar.f19239d;
                float f2 = i10 / 2.0f;
                int i11 = jVar.e;
                float f10 = i11 / 2.0f;
                int i12 = this.f362b;
                if (i12 % 180 != 0) {
                    float f11 = i11 / i10;
                    matrix.postScale(f11, 1.0f / f11, f2, f10);
                }
                matrix.postRotate(i12, f2, f10);
                ((TextureView) jVar.f19237b).setTransform(matrix);
                ((ia.g) this.f364d).a(null);
                return;
            case 7:
                ((SystemForegroundService) this.f363c).e.notify(this.f362b, (Notification) this.f364d);
                return;
            default:
                int i13 = this.f362b;
                ob.a aVar2 = (ob.a) this.f364d;
                x.l lVar = (x.l) this.f363c;
                AtomicInteger atomicInteger = lVar.f19713d;
                ArrayList arrayList3 = lVar.f19711b;
                boolean isDone = lVar.isDone();
                boolean z5 = lVar.f19712c;
                if (isDone || arrayList3 == null) {
                    pd.f("Future was done before all dependencies completed", z5);
                    return;
                }
                try {
                    try {
                        try {
                            try {
                                pd.f("Tried to set value from future which is not done", aVar2.isDone());
                                arrayList3.set(i13, x.i.b(aVar2));
                                decrementAndGet = atomicInteger.decrementAndGet();
                                pd.f("Less than 0 remaining futures", decrementAndGet >= 0);
                            } catch (ExecutionException e) {
                                if (z5) {
                                    lVar.f19714f.b(e.getCause());
                                }
                                int decrementAndGet2 = atomicInteger.decrementAndGet();
                                pd.f("Less than 0 remaining futures", decrementAndGet2 >= 0);
                                if (decrementAndGet2 != 0) {
                                    return;
                                }
                                ArrayList arrayList4 = lVar.f19711b;
                                if (arrayList4 != null) {
                                    bVar = lVar.f19714f;
                                    arrayList = new ArrayList(arrayList4);
                                }
                            }
                        } catch (CancellationException unused) {
                            if (z5) {
                                lVar.cancel(false);
                            }
                            int decrementAndGet3 = atomicInteger.decrementAndGet();
                            pd.f("Less than 0 remaining futures", decrementAndGet3 >= 0);
                            if (decrementAndGet3 != 0) {
                                return;
                            }
                            ArrayList arrayList5 = lVar.f19711b;
                            if (arrayList5 != null) {
                                bVar = lVar.f19714f;
                                arrayList = new ArrayList(arrayList5);
                            }
                        }
                    } catch (Error e10) {
                        lVar.f19714f.b(e10);
                        int decrementAndGet4 = atomicInteger.decrementAndGet();
                        pd.f("Less than 0 remaining futures", decrementAndGet4 >= 0);
                        if (decrementAndGet4 != 0) {
                            return;
                        }
                        ArrayList arrayList6 = lVar.f19711b;
                        if (arrayList6 != null) {
                            bVar = lVar.f19714f;
                            arrayList = new ArrayList(arrayList6);
                        }
                    } catch (RuntimeException e11) {
                        if (z5) {
                            lVar.f19714f.b(e11);
                        }
                        int decrementAndGet5 = atomicInteger.decrementAndGet();
                        pd.f("Less than 0 remaining futures", decrementAndGet5 >= 0);
                        if (decrementAndGet5 != 0) {
                            return;
                        }
                        ArrayList arrayList7 = lVar.f19711b;
                        if (arrayList7 != null) {
                            bVar = lVar.f19714f;
                            arrayList = new ArrayList(arrayList7);
                        }
                    }
                    if (decrementAndGet == 0) {
                        ArrayList arrayList8 = lVar.f19711b;
                        if (arrayList8 != null) {
                            bVar = lVar.f19714f;
                            arrayList = new ArrayList(arrayList8);
                            bVar.a(arrayList);
                            return;
                        }
                        pd.f(null, lVar.isDone());
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    int decrementAndGet6 = atomicInteger.decrementAndGet();
                    pd.f("Less than 0 remaining futures", decrementAndGet6 >= 0);
                    if (decrementAndGet6 == 0) {
                        ArrayList arrayList9 = lVar.f19711b;
                        if (arrayList9 != null) {
                            lVar.f19714f.a(new ArrayList(arrayList9));
                        } else {
                            pd.f(null, lVar.isDone());
                        }
                    }
                    throw th2;
                }
        }
    }

    public /* synthetic */ f(Object obj, Object obj2, int i3, int i10) {
        this.f361a = i10;
        this.f364d = obj;
        this.f363c = obj2;
        this.f362b = i3;
    }

    public /* synthetic */ f(Object obj, Object obj2, int i3, int i10, boolean z5) {
        this.f361a = i10;
        this.f363c = obj;
        this.f364d = obj2;
        this.f362b = i3;
    }
}
