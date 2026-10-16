package j2;

import android.animation.Animator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.Interpolator;
import android.widget.ListView;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public abstract class f0 implements Cloneable {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f15203u = {2, 1, 3, 4};

    /* renamed from: v, reason: collision with root package name */
    public static final hc.a f15204v = new hc.a(13);

    /* renamed from: w, reason: collision with root package name */
    public static final ThreadLocal f15205w = new ThreadLocal();

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f15215k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f15216l;

    /* renamed from: s, reason: collision with root package name */
    public r f15222s;

    /* renamed from: a, reason: collision with root package name */
    public final String f15206a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    public long f15207b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f15208c = -1;

    /* renamed from: d, reason: collision with root package name */
    public Interpolator f15209d = null;
    public final ArrayList e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f15210f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public v2.h f15211g = new v2.h(6);

    /* renamed from: h, reason: collision with root package name */
    public v2.h f15212h = new v2.h(6);

    /* renamed from: i, reason: collision with root package name */
    public j0 f15213i = null;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f15214j = f15203u;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f15217m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public int f15218n = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15219o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15220p = false;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f15221q = null;
    public ArrayList r = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public hc.a f15223t = f15204v;

    public static void c(v2.h hVar, View view, m0 m0Var) {
        ((m0.b) hVar.f19146a).put(view, m0Var);
        int id2 = view.getId();
        if (id2 >= 0) {
            SparseArray sparseArray = (SparseArray) hVar.f19147b;
            if (sparseArray.indexOfKey(id2) >= 0) {
                sparseArray.put(id2, null);
            } else {
                sparseArray.put(id2, view);
            }
        }
        WeakHashMap weakHashMap = z0.f15748a;
        String k10 = l1.n0.k(view);
        if (k10 != null) {
            m0.b bVar = (m0.b) hVar.f19149d;
            if (bVar.containsKey(k10)) {
                bVar.put(k10, null);
            } else {
                bVar.put(k10, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                m0.e eVar = (m0.e) hVar.f19148c;
                if (eVar.f15895a) {
                    eVar.b();
                }
                if (m0.d.b(eVar.f15896b, eVar.f15898d, itemIdAtPosition) < 0) {
                    l1.h0.r(view, true);
                    eVar.d(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) eVar.c(itemIdAtPosition, null);
                if (view2 != null) {
                    l1.h0.r(view2, false);
                    eVar.d(itemIdAtPosition, null);
                }
            }
        }
    }

    public static m0.b p() {
        ThreadLocal threadLocal = f15205w;
        m0.b bVar = (m0.b) threadLocal.get();
        if (bVar != null) {
            return bVar;
        }
        m0.b bVar2 = new m0.b();
        threadLocal.set(bVar2);
        return bVar2;
    }

    public static boolean u(m0 m0Var, m0 m0Var2, String str) {
        Object obj = m0Var.f15263a.get(str);
        Object obj2 = m0Var2.f15263a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(long j4) {
        this.f15208c = j4;
    }

    public void B(r rVar) {
        this.f15222s = rVar;
    }

    public void C(Interpolator interpolator) {
        this.f15209d = interpolator;
    }

    public void D(hc.a aVar) {
        if (aVar == null) {
            this.f15223t = f15204v;
        } else {
            this.f15223t = aVar;
        }
    }

    public void E() {
    }

    public void F(long j4) {
        this.f15207b = j4;
    }

    public final void G() {
        if (this.f15218n == 0) {
            ArrayList arrayList = this.f15221q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f15221q.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((e0) arrayList2.get(i3)).a(this);
                }
            }
            this.f15220p = false;
        }
        this.f15218n++;
    }

    public String H(String str) {
        StringBuilder t8 = com.google.android.gms.internal.mlkit_vision_barcode.l0.t(str);
        t8.append(getClass().getSimpleName());
        t8.append("@");
        t8.append(Integer.toHexString(hashCode()));
        t8.append(": ");
        String sb2 = t8.toString();
        if (this.f15208c != -1) {
            sb2 = android.support.v4.media.session.e.n(com.google.android.gms.internal.mlkit_vision_barcode.l0.u(sb2, "dur("), this.f15208c, ") ");
        }
        if (this.f15207b != -1) {
            sb2 = android.support.v4.media.session.e.n(com.google.android.gms.internal.mlkit_vision_barcode.l0.u(sb2, "dly("), this.f15207b, ") ");
        }
        if (this.f15209d != null) {
            StringBuilder u10 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u(sb2, "interp(");
            u10.append(this.f15209d);
            u10.append(") ");
            sb2 = u10.toString();
        }
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f15210f;
        if (size <= 0 && arrayList2.size() <= 0) {
            return sb2;
        }
        String l3 = android.support.v4.media.session.e.l(sb2, "tgts(");
        if (arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 > 0) {
                    l3 = android.support.v4.media.session.e.l(l3, ", ");
                }
                StringBuilder t10 = com.google.android.gms.internal.mlkit_vision_barcode.l0.t(l3);
                t10.append(arrayList.get(i3));
                l3 = t10.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                if (i10 > 0) {
                    l3 = android.support.v4.media.session.e.l(l3, ", ");
                }
                StringBuilder t11 = com.google.android.gms.internal.mlkit_vision_barcode.l0.t(l3);
                t11.append(arrayList2.get(i10));
                l3 = t11.toString();
            }
        }
        return android.support.v4.media.session.e.l(l3, ")");
    }

    public void a(e0 e0Var) {
        if (this.f15221q == null) {
            this.f15221q = new ArrayList();
        }
        this.f15221q.add(e0Var);
    }

    public void b(View view) {
        this.f15210f.add(view);
    }

    public void cancel() {
        ArrayList arrayList = this.f15217m;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = this.f15221q;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) this.f15221q.clone();
        int size2 = arrayList3.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((e0) arrayList3.get(i3)).d();
        }
    }

    public abstract void d(m0 m0Var);

    public final void e(View view, boolean z5) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            m0 m0Var = new m0(view);
            if (z5) {
                g(m0Var);
            } else {
                d(m0Var);
            }
            m0Var.f15265c.add(this);
            f(m0Var);
            if (z5) {
                c(this.f15211g, view, m0Var);
            } else {
                c(this.f15212h, view, m0Var);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                e(viewGroup.getChildAt(i3), z5);
            }
        }
    }

    public void f(m0 m0Var) {
    }

    public abstract void g(m0 m0Var);

    public final void h(ViewGroup viewGroup, boolean z5) {
        i(z5);
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f15210f;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z5);
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i3)).intValue());
            if (findViewById != null) {
                m0 m0Var = new m0(findViewById);
                if (z5) {
                    g(m0Var);
                } else {
                    d(m0Var);
                }
                m0Var.f15265c.add(this);
                f(m0Var);
                if (z5) {
                    c(this.f15211g, findViewById, m0Var);
                } else {
                    c(this.f15212h, findViewById, m0Var);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            View view = (View) arrayList2.get(i10);
            m0 m0Var2 = new m0(view);
            if (z5) {
                g(m0Var2);
            } else {
                d(m0Var2);
            }
            m0Var2.f15265c.add(this);
            f(m0Var2);
            if (z5) {
                c(this.f15211g, view, m0Var2);
            } else {
                c(this.f15212h, view, m0Var2);
            }
        }
    }

    public final void i(boolean z5) {
        if (z5) {
            ((m0.b) this.f15211g.f19146a).clear();
            ((SparseArray) this.f15211g.f19147b).clear();
            ((m0.e) this.f15211g.f19148c).a();
        } else {
            ((m0.b) this.f15212h.f19146a).clear();
            ((SparseArray) this.f15212h.f19147b).clear();
            ((m0.e) this.f15212h.f19148c).a();
        }
    }

    @Override // 
    /* renamed from: j */
    public f0 clone() {
        try {
            f0 f0Var = (f0) super.clone();
            f0Var.r = new ArrayList();
            f0Var.f15211g = new v2.h(6);
            f0Var.f15212h = new v2.h(6);
            f0Var.f15215k = null;
            f0Var.f15216l = null;
            return f0Var;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, m0 m0Var, m0 m0Var2) {
        return null;
    }

    public void l(ViewGroup viewGroup, v2.h hVar, v2.h hVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator k10;
        int i3;
        int i10;
        View view;
        m0 m0Var;
        Animator animator;
        m0.b p8 = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            m0 m0Var2 = (m0) arrayList.get(i11);
            m0 m0Var3 = (m0) arrayList2.get(i11);
            m0 m0Var4 = null;
            if (m0Var2 != null && !m0Var2.f15265c.contains(this)) {
                m0Var2 = null;
            }
            if (m0Var3 != null && !m0Var3.f15265c.contains(this)) {
                m0Var3 = null;
            }
            if (!(m0Var2 == null && m0Var3 == null) && ((m0Var2 == null || m0Var3 == null || s(m0Var2, m0Var3)) && (k10 = k(viewGroup, m0Var2, m0Var3)) != null)) {
                String str = this.f15206a;
                if (m0Var3 != null) {
                    String[] q5 = q();
                    view = m0Var3.f15264b;
                    if (q5 != null && q5.length > 0) {
                        m0Var = new m0(view);
                        m0 m0Var5 = (m0) ((m0.b) hVar2.f19146a).getOrDefault(view, null);
                        i3 = size;
                        if (m0Var5 != null) {
                            int i12 = 0;
                            while (i12 < q5.length) {
                                HashMap hashMap = m0Var.f15263a;
                                int i13 = i11;
                                String str2 = q5[i12];
                                hashMap.put(str2, m0Var5.f15263a.get(str2));
                                i12++;
                                i11 = i13;
                            }
                        }
                        i10 = i11;
                        int i14 = p8.f15919c;
                        for (int i15 = 0; i15 < i14; i15++) {
                            d0 d0Var = (d0) p8.getOrDefault((Animator) p8.h(i15), null);
                            if (d0Var.f15192c != null && d0Var.f15190a == view && d0Var.f15191b.equals(str) && d0Var.f15192c.equals(m0Var)) {
                                animator = null;
                                break;
                            }
                        }
                    } else {
                        i3 = size;
                        i10 = i11;
                        m0Var = null;
                    }
                    animator = k10;
                    k10 = animator;
                    m0Var4 = m0Var;
                } else {
                    i3 = size;
                    i10 = i11;
                    view = m0Var2.f15264b;
                }
                if (k10 != null) {
                    p0 p0Var = o0.f15272a;
                    u0 u0Var = new u0(viewGroup);
                    d0 d0Var2 = new d0();
                    d0Var2.f15190a = view;
                    d0Var2.f15191b = str;
                    d0Var2.f15192c = m0Var4;
                    d0Var2.f15193d = u0Var;
                    d0Var2.e = this;
                    p8.put(k10, d0Var2);
                    this.r.add(k10);
                }
            } else {
                i3 = size;
                i10 = i11;
            }
            i11 = i10 + 1;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i16 = 0; i16 < sparseIntArray.size(); i16++) {
                Animator animator2 = (Animator) this.r.get(sparseIntArray.keyAt(i16));
                animator2.setStartDelay(animator2.getStartDelay() + (sparseIntArray.valueAt(i16) - Format.OFFSET_SAMPLE_RELATIVE));
            }
        }
    }

    public final void m() {
        int i3 = this.f15218n - 1;
        this.f15218n = i3;
        if (i3 == 0) {
            ArrayList arrayList = this.f15221q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f15221q.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((e0) arrayList2.get(i10)).e(this);
                }
            }
            for (int i11 = 0; i11 < ((m0.e) this.f15211g.f19148c).e(); i11++) {
                View view = (View) ((m0.e) this.f15211g.f19148c).f(i11);
                if (view != null) {
                    WeakHashMap weakHashMap = z0.f15748a;
                    l1.h0.r(view, false);
                }
            }
            for (int i12 = 0; i12 < ((m0.e) this.f15212h.f19148c).e(); i12++) {
                View view2 = (View) ((m0.e) this.f15212h.f19148c).f(i12);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = z0.f15748a;
                    l1.h0.r(view2, false);
                }
            }
            this.f15220p = true;
        }
    }

    public void n(ViewGroup viewGroup) {
        m0.b p8 = p();
        int i3 = p8.f15919c;
        if (viewGroup == null || i3 == 0) {
            return;
        }
        p0 p0Var = o0.f15272a;
        WindowId windowId = viewGroup.getWindowId();
        m0.b bVar = new m0.b(p8);
        p8.clear();
        for (int i10 = i3 - 1; i10 >= 0; i10--) {
            d0 d0Var = (d0) bVar.l(i10);
            if (d0Var.f15190a != null && d0Var.f15193d.f15305a.equals(windowId)) {
                ((Animator) bVar.h(i10)).end();
            }
        }
    }

    public final m0 o(View view, boolean z5) {
        j0 j0Var = this.f15213i;
        if (j0Var != null) {
            return j0Var.o(view, z5);
        }
        ArrayList arrayList = z5 ? this.f15215k : this.f15216l;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            }
            m0 m0Var = (m0) arrayList.get(i3);
            if (m0Var == null) {
                return null;
            }
            if (m0Var.f15264b == view) {
                break;
            }
            i3++;
        }
        if (i3 >= 0) {
            return (m0) (z5 ? this.f15216l : this.f15215k).get(i3);
        }
        return null;
    }

    public String[] q() {
        return null;
    }

    public final m0 r(View view, boolean z5) {
        j0 j0Var = this.f15213i;
        if (j0Var != null) {
            return j0Var.r(view, z5);
        }
        return (m0) ((m0.b) (z5 ? this.f15211g : this.f15212h).f19146a).getOrDefault(view, null);
    }

    public boolean s(m0 m0Var, m0 m0Var2) {
        if (m0Var != null && m0Var2 != null) {
            String[] q5 = q();
            if (q5 != null) {
                for (String str : q5) {
                    if (u(m0Var, m0Var2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = m0Var.f15263a.keySet().iterator();
                while (it.hasNext()) {
                    if (u(m0Var, m0Var2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id2 = view.getId();
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f15210f;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id2)) || arrayList2.contains(view);
    }

    public final String toString() {
        return H("");
    }

    public void v(ViewGroup viewGroup) {
        if (this.f15220p) {
            return;
        }
        ArrayList arrayList = this.f15217m;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).pause();
        }
        ArrayList arrayList2 = this.f15221q;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) this.f15221q.clone();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((e0) arrayList3.get(i3)).b();
            }
        }
        this.f15219o = true;
    }

    public void w(e0 e0Var) {
        ArrayList arrayList = this.f15221q;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(e0Var);
        if (this.f15221q.size() == 0) {
            this.f15221q = null;
        }
    }

    public void x(View view) {
        this.f15210f.remove(view);
    }

    public void y(View view) {
        if (this.f15219o) {
            if (!this.f15220p) {
                ArrayList arrayList = this.f15217m;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Animator) arrayList.get(size)).resume();
                }
                ArrayList arrayList2 = this.f15221q;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ArrayList arrayList3 = (ArrayList) this.f15221q.clone();
                    int size2 = arrayList3.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((e0) arrayList3.get(i3)).c();
                    }
                }
            }
            this.f15219o = false;
        }
    }

    public void z() {
        G();
        m0.b p8 = p();
        ArrayList arrayList = this.r;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Animator animator = (Animator) obj;
            if (p8.containsKey(animator)) {
                G();
                if (animator != null) {
                    animator.addListener(new c0(0, this, p8));
                    long j4 = this.f15208c;
                    if (j4 >= 0) {
                        animator.setDuration(j4);
                    }
                    long j10 = this.f15207b;
                    if (j10 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j10);
                    }
                    Interpolator interpolator = this.f15209d;
                    if (interpolator != null) {
                        animator.setInterpolator(interpolator);
                    }
                    animator.addListener(new ab.q(this, 7));
                    animator.start();
                }
            }
        }
        this.r.clear();
        m();
    }
}
