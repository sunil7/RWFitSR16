package com.google.android.gms.internal.mlkit_common;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.Feature;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f9170a = new Object[8];

    /* renamed from: b, reason: collision with root package name */
    public int f9171b = 0;

    /* renamed from: c, reason: collision with root package name */
    public b f9172c;

    public final void a(String str, Feature feature) {
        int i3 = this.f9171b + 1;
        Object[] objArr = this.f9170a;
        int length = objArr.length;
        int i10 = i3 + i3;
        if (i10 > length) {
            if (i10 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i11 = length + (length >> 1) + 1;
            if (i11 < i10) {
                int highestOneBit = Integer.highestOneBit(i10 - 1);
                i11 = highestOneBit + highestOneBit;
            }
            if (i11 < 0) {
                i11 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            }
            this.f9170a = Arrays.copyOf(objArr, i11);
        }
        Object[] objArr2 = this.f9170a;
        int i12 = this.f9171b;
        int i13 = i12 + i12;
        objArr2[i13] = str;
        objArr2[i13 + 1] = feature;
        this.f9171b = i12 + 1;
    }

    public final zzai b() {
        b bVar = this.f9172c;
        if (bVar != null) {
            throw bVar.a();
        }
        zzaq zzg = zzaq.zzg(this.f9171b, this.f9170a, this);
        b bVar2 = this.f9172c;
        if (bVar2 == null) {
            return zzg;
        }
        throw bVar2.a();
    }
}
