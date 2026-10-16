package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public Random f390a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f391b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f392c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f393d = new HashMap();
    public ArrayList e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final transient HashMap f394f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f395g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f396h = new Bundle();

    public final boolean a(int i3, int i10, Intent intent) {
        a aVar;
        String str = (String) this.f391b.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        d dVar = (d) this.f394f.get(str);
        if (dVar == null || (aVar = dVar.f386a) == null || !this.e.contains(str)) {
            this.f395g.remove(str);
            this.f396h.putParcelable(str, new ActivityResult(i10, intent));
            return true;
        }
        aVar.b(dVar.f387b.c(i10, intent));
        this.e.remove(str);
        return true;
    }

    public abstract void b(int i3, d.a aVar, Object obj);

    public final c c(final String str, s sVar, final d.a aVar, final a aVar2) {
        n lifecycle = sVar.getLifecycle();
        u uVar = (u) lifecycle;
        if (uVar.f2390b.isAtLeast(Lifecycle$State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + sVar + " is attempting to register while current state is " + uVar.f2390b + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        HashMap hashMap = this.f393d;
        e eVar = (e) hashMap.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        q qVar = new q() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.q
            public final void c(s sVar2, Lifecycle$Event lifecycle$Event) {
                boolean equals = Lifecycle$Event.ON_START.equals(lifecycle$Event);
                String str2 = str;
                f fVar = f.this;
                if (!equals) {
                    if (Lifecycle$Event.ON_STOP.equals(lifecycle$Event)) {
                        fVar.f394f.remove(str2);
                        return;
                    } else {
                        if (Lifecycle$Event.ON_DESTROY.equals(lifecycle$Event)) {
                            fVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap hashMap2 = fVar.f394f;
                a aVar3 = aVar2;
                d.a aVar4 = aVar;
                hashMap2.put(str2, new d(aVar4, aVar3));
                HashMap hashMap3 = fVar.f395g;
                if (hashMap3.containsKey(str2)) {
                    Object obj = hashMap3.get(str2);
                    hashMap3.remove(str2);
                    aVar3.b(obj);
                }
                Bundle bundle = fVar.f396h;
                ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str2);
                if (activityResult != null) {
                    bundle.remove(str2);
                    aVar3.b(aVar4.c(activityResult.b(), activityResult.a()));
                }
            }
        };
        eVar.f388a.a(qVar);
        eVar.f389b.add(qVar);
        hashMap.put(str, eVar);
        return new c(this, str, aVar, 0);
    }

    public final c d(String str, d.a aVar, a aVar2) {
        e(str);
        this.f394f.put(str, new d(aVar, aVar2));
        HashMap hashMap = this.f395g;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            aVar2.b(obj);
        }
        Bundle bundle = this.f396h;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            aVar2.b(aVar.c(activityResult.b(), activityResult.a()));
        }
        return new c(this, str, aVar, 1);
    }

    public final void e(String str) {
        HashMap hashMap = this.f392c;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        int nextInt = this.f390a.nextInt(2147418112);
        while (true) {
            int i3 = nextInt + WXMediaMessage.THUMB_LENGTH_LIMIT;
            HashMap hashMap2 = this.f391b;
            if (!hashMap2.containsKey(Integer.valueOf(i3))) {
                hashMap2.put(Integer.valueOf(i3), str);
                hashMap.put(str, Integer.valueOf(i3));
                return;
            }
            nextInt = this.f390a.nextInt(2147418112);
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.e.contains(str) && (num = (Integer) this.f392c.remove(str)) != null) {
            this.f391b.remove(num);
        }
        this.f394f.remove(str);
        HashMap hashMap = this.f395g;
        if (hashMap.containsKey(str)) {
            StringBuilder r = android.support.v4.media.session.e.r("Dropping pending result for request ", str, ": ");
            r.append(hashMap.get(str));
            Log.w("ActivityResultRegistry", r.toString());
            hashMap.remove(str);
        }
        Bundle bundle = this.f396h;
        if (bundle.containsKey(str)) {
            StringBuilder r8 = android.support.v4.media.session.e.r("Dropping pending result for request ", str, ": ");
            r8.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", r8.toString());
            bundle.remove(str);
        }
        HashMap hashMap2 = this.f393d;
        e eVar = (e) hashMap2.get(str);
        if (eVar != null) {
            ArrayList arrayList = eVar.f389b;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                eVar.f388a.b((q) obj);
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }
}
