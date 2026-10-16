package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;

/* loaded from: classes.dex */
public final class v extends q {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9550a;

    /* renamed from: b, reason: collision with root package name */
    public int f9551b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzci f9552c;

    public v(zzci zzciVar, int i3) {
        this.f9552c = zzciVar;
        this.f9550a = zzci.zzg(zzciVar, i3);
        this.f9551b = i3;
    }

    public final void a() {
        int e;
        int i3 = this.f9551b;
        Object obj = this.f9550a;
        zzci zzciVar = this.f9552c;
        if (i3 == -1 || i3 >= zzciVar.size() || !na.a(obj, zzci.zzg(zzciVar, this.f9551b))) {
            e = zzciVar.e(obj);
            this.f9551b = e;
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9550a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzci zzciVar = this.f9552c;
        Map zzl = zzciVar.zzl();
        if (zzl != null) {
            return zzl.get(this.f9550a);
        }
        a();
        int i3 = this.f9551b;
        if (i3 == -1) {
            return null;
        }
        return zzci.zzj(zzciVar, i3);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzci zzciVar = this.f9552c;
        Map zzl = zzciVar.zzl();
        Object obj2 = this.f9550a;
        if (zzl != null) {
            return zzl.put(obj2, obj);
        }
        a();
        int i3 = this.f9551b;
        if (i3 == -1) {
            zzciVar.put(obj2, obj);
            return null;
        }
        Object zzj = zzci.zzj(zzciVar, i3);
        zzci.zzn(zzciVar, this.f9551b, obj);
        return zzj;
    }
}
