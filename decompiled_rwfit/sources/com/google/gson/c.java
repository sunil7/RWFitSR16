package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class c extends k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11158a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f11159b;

    public /* synthetic */ c(k kVar, int i3) {
        this.f11158a = i3;
        this.f11159b = kVar;
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        switch (this.f11158a) {
            case 0:
                return new AtomicLong(((Number) this.f11159b.a(aVar)).longValue());
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.b();
                while (aVar.j()) {
                    arrayList.add(Long.valueOf(((Number) this.f11159b.a(aVar)).longValue()));
                }
                aVar.g();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i3 = 0; i3 < size; i3++) {
                    atomicLongArray.set(i3, ((Long) arrayList.get(i3)).longValue());
                }
                return atomicLongArray;
            default:
                if (aVar.b0() != JsonToken.NULL) {
                    return this.f11159b.a(aVar);
                }
                aVar.X();
                return null;
        }
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        switch (this.f11158a) {
            case 0:
                this.f11159b.b(bVar, Long.valueOf(((AtomicLong) obj).get()));
                break;
            case 1:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                bVar.c();
                int length = atomicLongArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    this.f11159b.b(bVar, Long.valueOf(atomicLongArray.get(i3)));
                }
                bVar.g();
                break;
            default:
                if (obj == null) {
                    bVar.k();
                    break;
                } else {
                    this.f11159b.b(bVar, obj);
                    break;
                }
        }
    }
}
