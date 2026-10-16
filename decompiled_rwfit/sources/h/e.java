package h;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.h2;
import androidx.appcompat.widget.k2;
import androidx.appcompat.widget.t1;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class e extends s implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int A = R$layout.abc_cascading_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    public final Context f14107b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14108c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14109d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f14110f;

    /* renamed from: n, reason: collision with root package name */
    public View f14118n;

    /* renamed from: o, reason: collision with root package name */
    public View f14119o;

    /* renamed from: p, reason: collision with root package name */
    public int f14120p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14121q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f14122s;

    /* renamed from: t, reason: collision with root package name */
    public int f14123t;

    /* renamed from: v, reason: collision with root package name */
    public boolean f14125v;

    /* renamed from: w, reason: collision with root package name */
    public w f14126w;

    /* renamed from: x, reason: collision with root package name */
    public ViewTreeObserver f14127x;

    /* renamed from: y, reason: collision with root package name */
    public PopupWindow.OnDismissListener f14128y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f14129z;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f14111g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f14112h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final androidx.appcompat.widget.s f14113i = new androidx.appcompat.widget.s(this, 4);

    /* renamed from: j, reason: collision with root package name */
    public final c f14114j = new c(this, 0);

    /* renamed from: k, reason: collision with root package name */
    public final i0 f14115k = new i0(this, 20);

    /* renamed from: l, reason: collision with root package name */
    public int f14116l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f14117m = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14124u = false;

    public e(Context context, View view, int i3, boolean z5) {
        this.f14107b = context;
        this.f14118n = view;
        this.f14109d = i3;
        this.e = z5;
        WeakHashMap weakHashMap = z0.f15748a;
        this.f14120p = l1.i0.d(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f14108c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f14110f = new Handler();
    }

    @Override // h.b0
    public final boolean a() {
        ArrayList arrayList = this.f14112h;
        return arrayList.size() > 0 && ((d) arrayList.get(0)).f14103a.f779z.isShowing();
    }

    @Override // h.x
    public final void b(k kVar, boolean z5) {
        ArrayList arrayList = this.f14112h;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (kVar == ((d) arrayList.get(i3)).f14104b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 < 0) {
            return;
        }
        int i10 = i3 + 1;
        if (i10 < arrayList.size()) {
            ((d) arrayList.get(i10)).f14104b.c(false);
        }
        d dVar = (d) arrayList.remove(i3);
        dVar.f14104b.r(this);
        boolean z6 = this.f14129z;
        k2 k2Var = dVar.f14103a;
        if (z6) {
            h2.b(k2Var.f779z, null);
            k2Var.f779z.setAnimationStyle(0);
        }
        k2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f14120p = ((d) arrayList.get(size2 - 1)).f14105c;
        } else {
            View view = this.f14118n;
            WeakHashMap weakHashMap = z0.f15748a;
            this.f14120p = l1.i0.d(view) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z5) {
                ((d) arrayList.get(0)).f14104b.c(false);
                return;
            }
            return;
        }
        dismiss();
        w wVar = this.f14126w;
        if (wVar != null) {
            wVar.b(kVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f14127x;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f14127x.removeGlobalOnLayoutListener(this.f14113i);
            }
            this.f14127x = null;
        }
        this.f14119o.removeOnAttachStateChangeListener(this.f14114j);
        this.f14128y.onDismiss();
    }

    @Override // h.x
    public final void c(w wVar) {
        this.f14126w = wVar;
    }

    @Override // h.b0
    public final void d() {
        if (a()) {
            return;
        }
        ArrayList arrayList = this.f14111g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            w((k) obj);
        }
        arrayList.clear();
        View view = this.f14118n;
        this.f14119o = view;
        if (view != null) {
            boolean z5 = this.f14127x == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f14127x = viewTreeObserver;
            if (z5) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f14113i);
            }
            this.f14119o.addOnAttachStateChangeListener(this.f14114j);
        }
    }

    @Override // h.b0
    public final void dismiss() {
        ArrayList arrayList = this.f14112h;
        int size = arrayList.size();
        if (size > 0) {
            d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                d dVar = dVarArr[i3];
                if (dVar.f14103a.f779z.isShowing()) {
                    dVar.f14103a.dismiss();
                }
            }
        }
    }

    @Override // h.x
    public final void e(Parcelable parcelable) {
    }

    @Override // h.b0
    public final t1 f() {
        ArrayList arrayList = this.f14112h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) l0.h(1, arrayList)).f14103a.f758c;
    }

    @Override // h.x
    public final void g(boolean z5) {
        ArrayList arrayList = this.f14112h;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ListAdapter adapter = ((d) obj).f14103a.f758c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((h) adapter).notifyDataSetChanged();
        }
    }

    @Override // h.x
    public final boolean i() {
        return false;
    }

    @Override // h.x
    public final Parcelable j() {
        return null;
    }

    @Override // h.x
    public final boolean m(d0 d0Var) {
        ArrayList arrayList = this.f14112h;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            d dVar = (d) obj;
            if (d0Var == dVar.f14104b) {
                dVar.f14103a.f758c.requestFocus();
                return true;
            }
        }
        if (!d0Var.hasVisibleItems()) {
            return false;
        }
        n(d0Var);
        w wVar = this.f14126w;
        if (wVar != null) {
            wVar.c(d0Var);
        }
        return true;
    }

    @Override // h.s
    public final void n(k kVar) {
        kVar.b(this, this.f14107b);
        if (a()) {
            w(kVar);
        } else {
            this.f14111g.add(kVar);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        ArrayList arrayList = this.f14112h;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i3);
            if (!dVar.f14103a.f779z.isShowing()) {
                break;
            } else {
                i3++;
            }
        }
        if (dVar != null) {
            dVar.f14104b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i3 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // h.s
    public final void p(View view) {
        if (this.f14118n != view) {
            this.f14118n = view;
            int i3 = this.f14116l;
            WeakHashMap weakHashMap = z0.f15748a;
            this.f14117m = Gravity.getAbsoluteGravity(i3, l1.i0.d(view));
        }
    }

    @Override // h.s
    public final void q(boolean z5) {
        this.f14124u = z5;
    }

    @Override // h.s
    public final void r(int i3) {
        if (this.f14116l != i3) {
            this.f14116l = i3;
            View view = this.f14118n;
            WeakHashMap weakHashMap = z0.f15748a;
            this.f14117m = Gravity.getAbsoluteGravity(i3, l1.i0.d(view));
        }
    }

    @Override // h.s
    public final void s(int i3) {
        this.f14121q = true;
        this.f14122s = i3;
    }

    @Override // h.s
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f14128y = onDismissListener;
    }

    @Override // h.s
    public final void t(boolean z5) {
        this.f14125v = z5;
    }

    @Override // h.s
    public final void u(int i3) {
        this.r = true;
        this.f14123t = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x013f, code lost:
    
        if (((r8.getWidth() + r9[0]) + r5) > r11.right) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0141, code lost:
    
        r13 = 0;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0144, code lost:
    
        r8 = 1;
        r13 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014a, code lost:
    
        if ((r9[0] - r5) < 0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(h.k r18) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e.w(h.k):void");
    }
}
