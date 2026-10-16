package com.google.gson.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements com.google.gson.l, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final c f11176c;

    /* renamed from: a, reason: collision with root package name */
    public List f11177a;

    /* renamed from: b, reason: collision with root package name */
    public List f11178b;

    static {
        c cVar = new c();
        List list = Collections.EMPTY_LIST;
        cVar.f11177a = list;
        cVar.f11178b = list;
        f11176c = cVar;
    }

    @Override // com.google.gson.l
    public final com.google.gson.k a(com.google.gson.e eVar, bc.a aVar) {
        boolean z5;
        boolean z6;
        Class cls = aVar.f3203a;
        boolean z8 = !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
        if (z8) {
            z5 = true;
        } else {
            b(true);
            z5 = false;
        }
        if (z8) {
            z6 = true;
        } else {
            b(false);
            z6 = false;
        }
        if (z5 || z6) {
            return new b(this, z6, z5, eVar, aVar);
        }
        return null;
    }

    public final void b(boolean z5) {
        Iterator it = (z5 ? this.f11177a : this.f11178b).iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
    }

    public final Object clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
