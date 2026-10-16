package org.joda.time.format;

/* loaded from: classes2.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public volatile String[] f17172a;

    public abstract int a(int i3);

    public abstract String[] b();

    public final boolean c(int i3, int i10, String str) {
        int i11;
        String str2;
        if (this.f17172a != null) {
            String[] strArr = this.f17172a;
            int length = strArr.length;
            int i12 = 0;
            while (i12 < length) {
                String str3 = strArr[i12];
                int length2 = str3.length();
                if (i3 < length2) {
                    i11 = i10;
                    str2 = str;
                    if (str2.regionMatches(true, i11, str3, 0, length2)) {
                        return true;
                    }
                } else {
                    i11 = i10;
                    str2 = str;
                }
                if (i3 == length2 && str2.regionMatches(false, i11, str3, 0, length2)) {
                    return true;
                }
                i12++;
                str = str2;
                i10 = i11;
            }
        }
        return false;
    }

    public abstract int d(int i3, String str);

    public abstract void e(StringBuffer stringBuffer, int i3);

    public abstract int f(int i3, String str);
}
