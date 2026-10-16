package ia;

import android.hardware.camera2.CameraCharacteristics;
import android.text.TextUtils;
import androidx.camera.camera2.internal.compat.n;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import n.m0;
import t.t;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14392a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14393b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14394c;

    /* renamed from: d, reason: collision with root package name */
    public Object f14395d;

    public k(int i3) {
        this.f14392a = i3;
        switch (i3) {
            case 1:
                this.f14394c = Collections.newSetFromMap(new WeakHashMap());
                this.f14395d = new ArrayList();
                break;
            default:
                this.f14394c = new Object();
                break;
        }
    }

    public static boolean a(t tVar, t tVar2) {
        pd.f("Fully specified range is not actually fully specified.", tVar2.b());
        int i3 = tVar.f18411a;
        int i10 = tVar2.f18411a;
        if (i3 == 2 && i10 == 1) {
            return false;
        }
        if (i3 != 2 && i3 != 0 && i3 != i10) {
            return false;
        }
        int i11 = tVar.f18412b;
        return i11 == 0 || i11 == tVar2.f18412b;
    }

    public static boolean b(t tVar, t tVar2, HashSet hashSet) {
        if (hashSet.contains(tVar2)) {
            return a(tVar, tVar2);
        }
        a0.a("DynamicRangeResolver", "Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  " + tVar + "\nCandidate dynamic range:\n  " + tVar2);
        return false;
    }

    public static t d(t tVar, LinkedHashSet linkedHashSet, HashSet hashSet) {
        if (tVar.f18411a == 1) {
            return null;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            t tVar2 = (t) it.next();
            pd.e(tVar2, "Fully specified DynamicRange cannot be null.");
            pd.f("Fully specified DynamicRange must have fully defined encoding.", tVar2.b());
            if (tVar2.f18411a != 1 && b(tVar, tVar2, hashSet)) {
                return tVar2;
            }
        }
        return null;
    }

    public static void e(HashSet hashSet, t tVar, m0 m0Var) {
        pd.f("Cannot update already-empty constraints.", !hashSet.isEmpty());
        Set c9 = ((o.b) m0Var.f16254b).c(tVar);
        if (c9.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet.retainAll(c9);
        if (hashSet.isEmpty()) {
            throw new IllegalArgumentException("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  " + tVar + "\nConstraints:\n  " + TextUtils.join("\n  ", c9) + "\nExisting constraints:\n  " + TextUtils.join("\n  ", hashSet2));
        }
    }

    public boolean c(p4.c cVar) {
        boolean z5 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = ((Set) this.f14394c).remove(cVar);
        if (!((ArrayList) this.f14395d).remove(cVar) && !remove) {
            z5 = false;
        }
        if (z5) {
            cVar.clear();
        }
        return z5;
    }

    public void f(i iVar) {
        synchronized (this.f14394c) {
            try {
                if (((ArrayDeque) this.f14395d) == null) {
                    this.f14395d = new ArrayDeque();
                }
                ((ArrayDeque) this.f14395d).add(iVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void g(f fVar) {
        i iVar;
        synchronized (this.f14394c) {
            if (((ArrayDeque) this.f14395d) != null && !this.f14393b) {
                this.f14393b = true;
                while (true) {
                    synchronized (this.f14394c) {
                        try {
                            iVar = (i) ((ArrayDeque) this.f14395d).poll();
                            if (iVar == null) {
                                this.f14393b = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    iVar.a(fVar);
                }
            }
        }
    }

    public String toString() {
        switch (this.f14392a) {
            case 1:
                return super.toString() + "{numRequests=" + ((Set) this.f14394c).size() + ", isPaused=" + this.f14393b + "}";
            default:
                return super.toString();
        }
    }

    public k(n nVar) {
        this.f14392a = 2;
        this.f14394c = nVar;
        this.f14395d = m0.A(nVar);
        int[] iArr = (int[]) nVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean z5 = false;
        if (iArr != null) {
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (iArr[i3] == 18) {
                    z5 = true;
                    break;
                }
                i3++;
            }
        }
        this.f14393b = z5;
    }
}
