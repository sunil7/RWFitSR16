package wf;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class a implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f19624c = new HashMap(16);

    /* renamed from: a, reason: collision with root package name */
    public final int f19625a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19626b;

    public a(int i3, int i10) {
        this.f19625a = i3;
        this.f19626b = i10;
    }

    public static a a(int i3, int i10) {
        int i11 = i3;
        int i12 = i10;
        while (i12 != 0) {
            int i13 = i11 % i12;
            i11 = i12;
            i12 = i13;
        }
        if (i11 > 0) {
            i3 /= i11;
        }
        if (i11 > 0) {
            i10 /= i11;
        }
        String str = i3 + ":" + i10;
        HashMap hashMap = f19624c;
        a aVar = (a) hashMap.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(i3, i10);
        hashMap.put(str, aVar2);
        return aVar2;
    }

    public static a b(String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            return a(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    public final float c() {
        return this.f19625a / this.f19626b;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Float.compare(c(), ((a) obj).c());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && c() == ((a) obj).c();
    }

    public final int hashCode() {
        return Float.floatToIntBits(c());
    }

    public final String toString() {
        return this.f19625a + ":" + this.f19626b;
    }
}
