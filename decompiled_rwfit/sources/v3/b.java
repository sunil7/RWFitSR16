package v3;

import a2.g;
import java.io.File;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f19150a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f19151b;

    /* renamed from: c, reason: collision with root package name */
    public final File[] f19152c;

    /* renamed from: d, reason: collision with root package name */
    public final File[] f19153d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public g f19154f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f19155g;

    public b(c cVar, String str) {
        this.f19155g = cVar;
        this.f19150a = str;
        int i3 = cVar.f19161g;
        this.f19151b = new long[i3];
        this.f19152c = new File[i3];
        this.f19153d = new File[i3];
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('.');
        int length = sb2.length();
        for (int i10 = 0; i10 < cVar.f19161g; i10++) {
            sb2.append(i10);
            File[] fileArr = this.f19152c;
            String sb3 = sb2.toString();
            File file = cVar.f19156a;
            fileArr[i10] = new File(file, sb3);
            sb2.append(".tmp");
            this.f19153d[i10] = new File(file, sb2.toString());
            sb2.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        for (long j4 : this.f19151b) {
            sb2.append(' ');
            sb2.append(j4);
        }
        return sb2.toString();
    }
}
