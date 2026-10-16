package ad;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: c, reason: collision with root package name */
    public static final h[] f246c = new h[0];

    /* renamed from: d, reason: collision with root package name */
    public static final k[] f247d = new k[0];

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f248a;

    /* renamed from: b, reason: collision with root package name */
    public final h[] f249b;

    public g(EnumMap enumMap, int i3) {
        this.f248a = i3;
        switch (i3) {
            case 1:
                Collection collection = enumMap == null ? null : (Collection) enumMap.get(DecodeHintType.POSSIBLE_FORMATS);
                ArrayList arrayList = new ArrayList();
                if (collection != null) {
                    if (collection.contains(BarcodeFormat.EAN_13)) {
                        arrayList.add(new e(0));
                    } else if (collection.contains(BarcodeFormat.UPC_A)) {
                        arrayList.add(new e(3));
                    }
                    if (collection.contains(BarcodeFormat.EAN_8)) {
                        arrayList.add(new e(2));
                    }
                    if (collection.contains(BarcodeFormat.UPC_E)) {
                        arrayList.add(new e(1));
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new e(0));
                    arrayList.add(new e(2));
                    arrayList.add(new e(1));
                }
                this.f249b = (k[]) arrayList.toArray(f247d);
                break;
            default:
                Collection collection2 = enumMap == null ? null : (Collection) enumMap.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z5 = (enumMap == null || enumMap.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
                ArrayList arrayList2 = new ArrayList();
                if (collection2 != null) {
                    if (collection2.contains(BarcodeFormat.EAN_13) || collection2.contains(BarcodeFormat.UPC_A) || collection2.contains(BarcodeFormat.EAN_8) || collection2.contains(BarcodeFormat.UPC_E)) {
                        arrayList2.add(new g(enumMap, 1));
                    }
                    if (collection2.contains(BarcodeFormat.CODE_39)) {
                        arrayList2.add(new c(z5));
                    }
                    if (collection2.contains(BarcodeFormat.CODE_93)) {
                        arrayList2.add(new d());
                    }
                    if (collection2.contains(BarcodeFormat.CODE_128)) {
                        arrayList2.add(new b());
                    }
                    if (collection2.contains(BarcodeFormat.ITF)) {
                        arrayList2.add(new f());
                    }
                    if (collection2.contains(BarcodeFormat.CODABAR)) {
                        arrayList2.add(new a());
                    }
                    if (collection2.contains(BarcodeFormat.RSS_14)) {
                        arrayList2.add(new bd.e());
                    }
                    if (collection2.contains(BarcodeFormat.RSS_EXPANDED)) {
                        arrayList2.add(new cd.c());
                    }
                }
                if (arrayList2.isEmpty()) {
                    arrayList2.add(new g(enumMap, 1));
                    arrayList2.add(new c(false));
                    arrayList2.add(new a());
                    arrayList2.add(new d());
                    arrayList2.add(new b());
                    arrayList2.add(new f());
                    arrayList2.add(new bd.e());
                    arrayList2.add(new cd.c());
                }
                this.f249b = (h[]) arrayList2.toArray(f246c);
                break;
        }
    }

    @Override // ad.h, com.google.zxing.f
    public final void b() {
        switch (this.f248a) {
            case 0:
                for (h hVar : this.f249b) {
                    hVar.b();
                }
                break;
            default:
                for (k kVar : (k[]) this.f249b) {
                    kVar.getClass();
                }
                break;
        }
    }

    @Override // ad.h
    public final com.google.zxing.g c(int i3, sc.a aVar, EnumMap enumMap) {
        boolean z5;
        switch (this.f248a) {
            case 0:
                for (h hVar : this.f249b) {
                    try {
                        return hVar.c(i3, aVar, enumMap);
                    } catch (ReaderException unused) {
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            default:
                int[] n4 = k.n(aVar);
                for (k kVar : (k[]) this.f249b) {
                    try {
                        com.google.zxing.g l3 = kVar.l(i3, aVar, n4, enumMap);
                        BarcodeFormat barcodeFormat = l3.f11246d;
                        BarcodeFormat barcodeFormat2 = BarcodeFormat.EAN_13;
                        String str = l3.f11243a;
                        boolean z6 = barcodeFormat == barcodeFormat2 && str.charAt(0) == '0';
                        Collection collection = enumMap == null ? null : (Collection) enumMap.get(DecodeHintType.POSSIBLE_FORMATS);
                        if (collection != null && !collection.contains(BarcodeFormat.UPC_A)) {
                            z5 = false;
                            if (!z6 && z5) {
                                com.google.zxing.g gVar = new com.google.zxing.g(str.substring(1), l3.f11244b, l3.f11245c, BarcodeFormat.UPC_A);
                                gVar.a(l3.e);
                                return gVar;
                            }
                        }
                        z5 = true;
                        return !z6 ? l3 : l3;
                    } catch (ReaderException unused2) {
                    }
                }
                throw NotFoundException.getNotFoundInstance();
        }
    }
}
