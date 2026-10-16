package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.jb;

/* loaded from: classes.dex */
public final class k extends d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11084a;

    /* renamed from: b, reason: collision with root package name */
    public int f11085b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompactHashMap f11086c;

    public k(CompactHashMap compactHashMap, int i3) {
        this.f11086c = compactHashMap;
        this.f11084a = compactHashMap.keys[i3];
        this.f11085b = i3;
    }

    public final void a() {
        int a3;
        int i3 = this.f11085b;
        Object obj = this.f11084a;
        CompactHashMap compactHashMap = this.f11086c;
        if (i3 == -1 || i3 >= compactHashMap.size() || !jb.a(obj, compactHashMap.keys[this.f11085b])) {
            a3 = compactHashMap.a(obj);
            this.f11085b = a3;
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11084a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        int i3 = this.f11085b;
        if (i3 == -1) {
            return null;
        }
        return this.f11086c.values[i3];
    }

    @Override // com.google.common.collect.d, java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        int i3 = this.f11085b;
        CompactHashMap compactHashMap = this.f11086c;
        if (i3 == -1) {
            compactHashMap.put(this.f11084a, obj);
            return null;
        }
        Object[] objArr = compactHashMap.values;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }
}
