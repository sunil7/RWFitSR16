package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzci extends AbstractMap implements Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f9705g = new Object();

    /* renamed from: a, reason: collision with root package name */
    public transient Object f9706a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f9707b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f9708c;

    /* renamed from: d, reason: collision with root package name */
    public transient u f9709d;
    public transient u e;

    /* renamed from: f, reason: collision with root package name */
    public transient w f9710f;

    @CheckForNull
    transient int[] zza;

    @CheckForNull
    transient Object[] zzb;

    @CheckForNull
    transient Object[] zzc;

    public zzci() {
        zzp(3);
    }

    public static /* synthetic */ Object zzg(zzci zzciVar, int i3) {
        return zzciVar.b()[i3];
    }

    public static /* synthetic */ Object zzi(zzci zzciVar) {
        Object obj = zzciVar.f9706a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static /* synthetic */ Object zzj(zzci zzciVar, int i3) {
        return zzciVar.c()[i3];
    }

    public static /* synthetic */ void zzn(zzci zzciVar, int i3, Object obj) {
        zzciVar.c()[i3] = obj;
    }

    public final int[] a() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] b() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] c() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        zzo();
        Map zzl = zzl();
        if (zzl != null) {
            this.f9707b = Math.min(Math.max(size(), 3), 1073741823);
            zzl.clear();
            this.f9706a = null;
            this.f9708c = 0;
            return;
        }
        Arrays.fill(b(), 0, this.f9708c, (Object) null);
        Arrays.fill(c(), 0, this.f9708c, (Object) null);
        Object obj = this.f9706a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(a(), 0, this.f9708c, 0);
        this.f9708c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        Map zzl = zzl();
        return zzl != null ? zzl.containsKey(obj) : e(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsValue(obj);
        }
        for (int i3 = 0; i3 < this.f9708c; i3++) {
            if (na.a(obj, c()[i3])) {
                return true;
            }
        }
        return false;
    }

    public final int d() {
        return (1 << (this.f9707b & 31)) - 1;
    }

    public final int e(Object obj) {
        if (zzr()) {
            return -1;
        }
        int a3 = ra.a(obj);
        int d5 = d();
        Object obj2 = this.f9706a;
        Objects.requireNonNull(obj2);
        int b3 = qa.b(a3 & d5, obj2);
        if (b3 != 0) {
            int i3 = ~d5;
            int i10 = a3 & i3;
            do {
                int i11 = b3 - 1;
                int i12 = a()[i11];
                if ((i12 & i3) == i10 && na.a(obj, b()[i11])) {
                    return i11;
                }
                b3 = i12 & d5;
            } while (b3 != 0);
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        u uVar = this.e;
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this, 0);
        this.e = uVar2;
        return uVar2;
    }

    public final int f(int i3, int i10, int i11, int i12) {
        int i13 = i10 - 1;
        Object c9 = qa.c(i10);
        if (i12 != 0) {
            qa.d(i11 & i13, i12 + 1, c9);
        }
        Object obj = this.f9706a;
        Objects.requireNonNull(obj);
        int[] a3 = a();
        for (int i14 = 0; i14 <= i3; i14++) {
            int b3 = qa.b(i14, obj);
            while (b3 != 0) {
                int i15 = b3 - 1;
                int i16 = a3[i15];
                int i17 = ((~i3) & i16) | i14;
                int i18 = i17 & i13;
                int b10 = qa.b(i18, c9);
                qa.d(i18, b3, c9);
                a3[i15] = ((~i13) & i17) | (b10 & i13);
                b3 = i16 & i3;
            }
        }
        this.f9706a = c9;
        this.f9707b = ((32 - Integer.numberOfLeadingZeros(i13)) & 31) | (this.f9707b & (-32));
        return i13;
    }

    public final Object g(Object obj) {
        if (!zzr()) {
            int d5 = d();
            Object obj2 = this.f9706a;
            Objects.requireNonNull(obj2);
            int a3 = qa.a(obj, null, d5, obj2, a(), b(), null);
            if (a3 != -1) {
                Object obj3 = c()[a3];
                zzq(a3, d5);
                this.f9708c--;
                zzo();
                return obj3;
            }
        }
        return f9705g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int e = e(obj);
        if (e == -1) {
            return null;
        }
        return c()[e];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        u uVar = this.f9709d;
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this, 1);
        this.f9709d = uVar2;
        return uVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        int i3;
        if (zzr()) {
            oa.c("Arrays already allocated", zzr());
            int i10 = this.f9707b;
            int max = Math.max(i10 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > highestOneBit && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.f9706a = qa.c(max2);
            this.f9707b = ((32 - Integer.numberOfLeadingZeros(max2 - 1)) & 31) | (this.f9707b & (-32));
            this.zza = new int[i10];
            this.zzb = new Object[i10];
            this.zzc = new Object[i10];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(obj, obj2);
        }
        int[] a3 = a();
        Object[] b3 = b();
        Object[] c9 = c();
        int i11 = this.f9708c;
        int i12 = i11 + 1;
        int a10 = ra.a(obj);
        int d5 = d();
        int i13 = a10 & d5;
        Object obj3 = this.f9706a;
        Objects.requireNonNull(obj3);
        int b10 = qa.b(i13, obj3);
        if (b10 == 0) {
            if (i12 > d5) {
                d5 = f(d5, (d5 + 1) * (d5 < 32 ? 4 : 2), a10, i11);
            } else {
                Object obj4 = this.f9706a;
                Objects.requireNonNull(obj4);
                qa.d(i13, i12, obj4);
            }
            i3 = 1;
        } else {
            int i14 = ~d5;
            int i15 = a10 & i14;
            int i16 = 0;
            while (true) {
                int i17 = b10 - 1;
                int i18 = a3[i17];
                i3 = 1;
                int i19 = i18 & i14;
                if (i19 == i15 && na.a(obj, b3[i17])) {
                    Object obj5 = c9[i17];
                    c9[i17] = obj2;
                    return obj5;
                }
                int i20 = i18 & d5;
                int i21 = i16 + 1;
                if (i20 != 0) {
                    b10 = i20;
                    i16 = i21;
                } else {
                    if (i21 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(d() + 1, 1.0f);
                        int zze = zze();
                        while (zze >= 0) {
                            linkedHashMap.put(b()[zze], c()[zze]);
                            zze = zzf(zze);
                        }
                        this.f9706a = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i12 > d5) {
                        d5 = f(d5, (d5 + 1) * (d5 < 32 ? 4 : 2), a10, i11);
                    } else {
                        a3[i17] = (i12 & d5) | i19;
                    }
                }
            }
        }
        int length = a().length;
        if (i12 > length) {
            int i22 = i3;
            int min = Math.min(1073741823, (Math.max(i22, length >>> 1) + length) | i22);
            if (min != length) {
                this.zza = Arrays.copyOf(a(), min);
                this.zzb = Arrays.copyOf(b(), min);
                this.zzc = Arrays.copyOf(c(), min);
            }
        }
        a()[i11] = (~d5) & a10;
        b()[i11] = obj;
        c()[i11] = obj2;
        this.f9708c = i12;
        zzo();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        Object g10 = g(obj);
        if (g10 == f9705g) {
            return null;
        }
        return g10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map zzl = zzl();
        return zzl != null ? zzl.size() : this.f9708c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        w wVar = this.f9710f;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this, 0);
        this.f9710f = wVar2;
        return wVar2;
    }

    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzf(int i3) {
        int i10 = i3 + 1;
        if (i10 < this.f9708c) {
            return i10;
        }
        return -1;
    }

    @CheckForNull
    public final Map zzl() {
        Object obj = this.f9706a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzo() {
        this.f9707b += 32;
    }

    public final void zzp(int i3) {
        this.f9707b = Math.min(Math.max(i3, 1), 1073741823);
    }

    public final void zzq(int i3, int i10) {
        Object obj = this.f9706a;
        Objects.requireNonNull(obj);
        int[] a3 = a();
        Object[] b3 = b();
        Object[] c9 = c();
        int size = size();
        int i11 = size - 1;
        if (i3 >= i11) {
            b3[i3] = null;
            c9[i3] = null;
            a3[i3] = 0;
            return;
        }
        int i12 = i3 + 1;
        Object obj2 = b3[i11];
        b3[i3] = obj2;
        c9[i3] = c9[i11];
        b3[i11] = null;
        c9[i11] = null;
        a3[i3] = a3[i11];
        a3[i11] = 0;
        int a10 = ra.a(obj2) & i10;
        int b10 = qa.b(a10, obj);
        if (b10 == size) {
            qa.d(a10, i12, obj);
            return;
        }
        while (true) {
            int i13 = b10 - 1;
            int i14 = a3[i13];
            int i15 = i14 & i10;
            if (i15 == size) {
                a3[i13] = (i14 & (~i10)) | (i10 & i12);
                return;
            }
            b10 = i15;
        }
    }

    public final boolean zzr() {
        return this.f9706a == null;
    }

    public zzci(int i3) {
        zzp(12);
    }
}
