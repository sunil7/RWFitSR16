package androidx.camera.core.impl;

import android.util.Size;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class c1 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1360a;

    public /* synthetic */ c1(int i3) {
        this.f1360a = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1360a) {
            case 0:
                return ((c) obj).f1351a.compareTo(((c) obj2).f1351a);
            case 1:
                g9.k kVar = (g9.k) obj;
                g9.k kVar2 = (g9.k) obj2;
                int compare = Integer.compare(kVar2.f13978b, kVar.f13978b);
                if (compare != 0) {
                    return compare;
                }
                int compareTo = kVar.f13979c.compareTo(kVar2.f13979c);
                return compareTo != 0 ? compareTo : kVar.f13980d.compareTo(kVar2.f13980d);
            case 2:
                g9.k kVar3 = (g9.k) obj;
                g9.k kVar4 = (g9.k) obj2;
                int compare2 = Integer.compare(kVar4.f13977a, kVar3.f13977a);
                if (compare2 != 0) {
                    return compare2;
                }
                int compareTo2 = kVar4.f13979c.compareTo(kVar3.f13979c);
                return compareTo2 != 0 ? compareTo2 : kVar4.f13980d.compareTo(kVar3.f13980d);
            case 3:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    byte b3 = bArr[i3];
                    byte b10 = bArr2[i3];
                    if (b3 != b10) {
                        return b3 - b10;
                    }
                }
                return 0;
            case 4:
                n6.b bVar = (n6.b) obj;
                n6.b bVar2 = (n6.b) obj2;
                if (bVar == null && bVar2 == null) {
                    return 0;
                }
                if (bVar == null) {
                    return 1;
                }
                if (bVar2 == null) {
                    return -1;
                }
                return Long.compare(bVar2.f16385d, bVar.f16385d);
            case 5:
                Size size = (Size) obj;
                Size size2 = (Size) obj2;
                return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
            case 6:
                SlowMotionData.Segment segment = (SlowMotionData.Segment) obj;
                SlowMotionData.Segment segment2 = (SlowMotionData.Segment) obj2;
                return com.google.common.collect.p.f11109a.b(segment.startTimeMs, segment2.startTimeMs).b(segment.endTimeMs, segment2.endTimeMs).a(segment.speedDivisor, segment2.speedDivisor).c();
            default:
                return ((x5.e) obj).f19811a - ((x5.e) obj2).f19811a;
        }
    }
}
