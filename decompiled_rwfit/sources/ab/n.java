package ab;

import android.media.MediaActionSound;
import androidx.camera.core.impl.y0;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import com.otaliastudios.cameraview.CameraView;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import o2.u;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public Object f194a;

    /* renamed from: b, reason: collision with root package name */
    public Object f195b;

    /* renamed from: c, reason: collision with root package name */
    public Object f196c;

    public n(int i3) {
        this.f195b = new float[i3 * 2];
        this.f196c = new int[i3];
    }

    public static boolean o(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                return set.containsAll(set2);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean s(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public u a() {
        u b3 = b();
        o2.c cVar = ((x2.h) this.f195b).f19757j;
        boolean z5 = cVar.f16705h.f16708a.size() > 0 || cVar.f16702d || cVar.f16700b || cVar.f16701c;
        x2.h hVar = (x2.h) this.f195b;
        if (hVar.f19764q) {
            if (z5) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            if (hVar.f19754g > 0) {
                throw new IllegalArgumentException("Expedited jobs cannot be delayed");
            }
        }
        this.f194a = UUID.randomUUID();
        x2.h hVar2 = (x2.h) this.f195b;
        x2.h hVar3 = new x2.h();
        hVar3.f19750b = WorkInfo$State.ENQUEUED;
        o2.f fVar = o2.f.f16710c;
        hVar3.e = fVar;
        hVar3.f19753f = fVar;
        hVar3.f19757j = o2.c.f16698i;
        hVar3.f19759l = BackoffPolicy.EXPONENTIAL;
        hVar3.f19760m = 30000L;
        hVar3.f19763p = -1L;
        hVar3.r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        hVar3.f19749a = hVar2.f19749a;
        hVar3.f19751c = hVar2.f19751c;
        hVar3.f19750b = hVar2.f19750b;
        hVar3.f19752d = hVar2.f19752d;
        hVar3.e = new o2.f(hVar2.e);
        hVar3.f19753f = new o2.f(hVar2.f19753f);
        hVar3.f19754g = hVar2.f19754g;
        hVar3.f19755h = hVar2.f19755h;
        hVar3.f19756i = hVar2.f19756i;
        o2.c cVar2 = hVar2.f19757j;
        o2.c cVar3 = new o2.c();
        cVar3.f16699a = NetworkType.NOT_REQUIRED;
        cVar3.f16703f = -1L;
        cVar3.f16704g = -1L;
        cVar3.f16705h = new o2.e();
        cVar3.f16700b = cVar2.f16700b;
        cVar3.f16701c = cVar2.f16701c;
        cVar3.f16699a = cVar2.f16699a;
        cVar3.f16702d = cVar2.f16702d;
        cVar3.e = cVar2.e;
        cVar3.f16705h = cVar2.f16705h;
        hVar3.f19757j = cVar3;
        hVar3.f19758k = hVar2.f19758k;
        hVar3.f19759l = hVar2.f19759l;
        hVar3.f19760m = hVar2.f19760m;
        hVar3.f19761n = hVar2.f19761n;
        hVar3.f19762o = hVar2.f19762o;
        hVar3.f19763p = hVar2.f19763p;
        hVar3.f19764q = hVar2.f19764q;
        hVar3.r = hVar2.r;
        this.f195b = hVar3;
        hVar3.f19749a = ((UUID) this.f194a).toString();
        return b3;
    }

    public abstract u b();

    public abstract void c();

    public abstract void d();

    public abstract Object e(int i3, int i10);

    public abstract Map f();

    public abstract int g();

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj, Object obj2);

    public abstract void k(int i3);

    public abstract Object l(int i3, Object obj);

    public void m(boolean z5) {
        boolean z6;
        ff.q qVar = (ff.q) this.f195b;
        if (qVar != null) {
            ef.i iVar = qVar.f13647c;
            CameraView cameraView = (CameraView) iVar.f12630c;
            if (!z5 && (z6 = cameraView.f11542a) && z6) {
                if (cameraView.f11557q == null) {
                    cameraView.f11557q = new MediaActionSound();
                }
                cameraView.f11557q.play(0);
            }
            cameraView.f11550j.post(new ef.h(iVar, 3, (byte) 0));
        }
    }

    public void n() {
        ff.q qVar = (ff.q) this.f195b;
        if (qVar != null) {
            qVar.a((y0) this.f194a, (Exception) this.f196c);
            this.f195b = null;
            this.f194a = null;
        }
    }

    public abstract void p();

    public abstract void q(c cVar);

    public abstract void r();

    public abstract void t();

    public abstract void u();

    public Object[] v(int i3, Object[] objArr) {
        int g10 = g();
        if (objArr.length < g10) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), g10);
        }
        for (int i10 = 0; i10 < g10; i10++) {
            objArr[i10] = e(i10, i3);
        }
        if (objArr.length > g10) {
            objArr[g10] = null;
        }
        return objArr;
    }

    public abstract void w();

    public n(y0 y0Var, ff.q qVar) {
        this.f194a = y0Var;
        this.f195b = qVar;
    }

    public n(Class cls) {
        HashSet hashSet = new HashSet();
        this.f196c = hashSet;
        this.f194a = UUID.randomUUID();
        this.f195b = new x2.h(((UUID) this.f194a).toString(), cls.getName());
        hashSet.add(cls.getName());
    }
}
