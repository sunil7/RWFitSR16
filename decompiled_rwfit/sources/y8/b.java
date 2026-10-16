package y8;

import android.net.Uri;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import i9.g;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f20035c = new b(new a[0]);

    /* renamed from: d, reason: collision with root package name */
    public static final a f20036d;

    /* renamed from: a, reason: collision with root package name */
    public final int f20037a;

    /* renamed from: b, reason: collision with root package name */
    public final a[] f20038b;

    static {
        int max = Math.max(0, 0);
        int[] copyOf = Arrays.copyOf(new int[0], max);
        Arrays.fill(copyOf, 0, max, 0);
        int max2 = Math.max(0, 0);
        long[] copyOf2 = Arrays.copyOf(new long[0], max2);
        Arrays.fill(copyOf2, 0, max2, -9223372036854775807L);
        f20036d = new a(0, copyOf, (Uri[]) Arrays.copyOf(new Uri[0], 0), copyOf2);
    }

    public b(a[] aVarArr) {
        this.f20037a = aVarArr.length;
        this.f20038b = aVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        int i3 = g.f14378a;
        return this.f20037a == bVar.f20037a && Arrays.equals(this.f20038b, bVar.f20038b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f20038b) + (((((this.f20037a * 961) + ((int) 0)) * 31) + ((int) (-9223372036854775807L))) * 961);
    }

    public final String toString() {
        return l0.n("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[", "])");
    }
}
