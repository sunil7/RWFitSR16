package y8;

import android.net.Uri;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f20031a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri[] f20032b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f20033c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f20034d;

    public a(int i3, int[] iArr, Uri[] uriArr, long[] jArr) {
        pc.a(iArr.length == uriArr.length);
        this.f20031a = i3;
        this.f20033c = iArr;
        this.f20032b = uriArr;
        this.f20034d = jArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f20031a == aVar.f20031a && Arrays.equals(this.f20032b, aVar.f20032b) && Arrays.equals(this.f20033c, aVar.f20033c) && Arrays.equals(this.f20034d, aVar.f20034d);
    }

    public final int hashCode() {
        int i3 = (int) 0;
        return (((Arrays.hashCode(this.f20034d) + ((Arrays.hashCode(this.f20033c) + (((((this.f20031a * 31) + i3) * 31) + Arrays.hashCode(this.f20032b)) * 31)) * 31)) * 31) + i3) * 31;
    }
}
