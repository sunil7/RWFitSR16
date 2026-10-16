package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: c, reason: collision with root package name */
    public static final f[] f11228c = new f[0];

    /* renamed from: a, reason: collision with root package name */
    public EnumMap f11229a;

    /* renamed from: b, reason: collision with root package name */
    public f[] f11230b;

    @Override // com.google.zxing.f
    public final g a(a aVar, EnumMap enumMap) {
        d(enumMap);
        return c(aVar);
    }

    @Override // com.google.zxing.f
    public final void b() {
        f[] fVarArr = this.f11230b;
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                fVar.b();
            }
        }
    }

    public final g c(a aVar) {
        f[] fVarArr = this.f11230b;
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                try {
                    return fVar.a(aVar, this.f11229a);
                } catch (ReaderException unused) {
                }
            }
            EnumMap enumMap = this.f11229a;
            if (enumMap != null && enumMap.containsKey(DecodeHintType.ALSO_INVERTED)) {
                sc.b a3 = aVar.a();
                int length = a3.f18224d.length;
                for (int i3 = 0; i3 < length; i3++) {
                    int[] iArr = a3.f18224d;
                    iArr[i3] = ~iArr[i3];
                }
                for (f fVar2 : this.f11230b) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    try {
                        return fVar2.a(aVar, this.f11229a);
                    } catch (ReaderException unused2) {
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void d(EnumMap enumMap) {
        this.f11229a = enumMap;
        boolean z5 = enumMap != null && enumMap.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = enumMap == null ? null : (Collection) enumMap.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z6 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z6 && !z5) {
                arrayList.add(new ad.g(enumMap, 0));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new id.a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new vc.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new qc.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new ed.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new yc.a());
            }
            if (z6 && z5) {
                arrayList.add(new ad.g(enumMap, 0));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z5) {
                arrayList.add(new ad.g(enumMap, 0));
            }
            arrayList.add(new id.a());
            arrayList.add(new vc.a());
            arrayList.add(new qc.b());
            arrayList.add(new ed.b());
            arrayList.add(new yc.a());
            if (z5) {
                arrayList.add(new ad.g(enumMap, 0));
            }
        }
        this.f11230b = (f[]) arrayList.toArray(f11228c);
    }
}
