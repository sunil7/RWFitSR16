package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;

/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedTreeMap f11168a = new LinkedTreeMap();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof i) && ((i) obj).f11168a.equals(this.f11168a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f11168a.hashCode();
    }
}
