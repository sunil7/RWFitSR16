package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f extends g implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11166a = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof f) && ((f) obj).f11166a.equals(this.f11166a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f11166a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f11166a.iterator();
    }
}
