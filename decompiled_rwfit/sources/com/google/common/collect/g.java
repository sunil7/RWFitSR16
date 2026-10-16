package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class g implements q1 {

    /* renamed from: a, reason: collision with root package name */
    public transient Collection f11067a;

    /* renamed from: b, reason: collision with root package name */
    public transient s1 f11068b;

    /* renamed from: c, reason: collision with root package name */
    public transient Collection f11069c;

    public boolean containsEntry(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(Object obj) {
        Iterator it = asMap().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract s1 createKeys();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q1) {
            return asMap().equals(((q1) obj).asMap());
        }
        return false;
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.q1
    public boolean isEmpty() {
        return size() == 0;
    }

    public s1 keys() {
        s1 s1Var = this.f11068b;
        if (s1Var != null) {
            return s1Var;
        }
        s1 createKeys = createKeys();
        this.f11068b = createKeys;
        return createKeys;
    }

    public String toString() {
        return asMap().toString();
    }
}
