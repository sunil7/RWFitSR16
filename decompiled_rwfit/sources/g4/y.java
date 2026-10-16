package g4;

import android.graphics.Bitmap;
import java.io.File;

/* loaded from: classes.dex */
public final class y implements z3.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13865a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13866b;

    public y(byte[] bArr) {
        t4.f.c(bArr, "Argument must not be null");
        this.f13866b = bArr;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void e() {
    }

    @Override // z3.s
    public final int c() {
        switch (this.f13865a) {
            case 0:
                return t4.l.c((Bitmap) this.f13866b);
            case 1:
                return ((byte[]) this.f13866b).length;
            default:
                return 1;
        }
    }

    @Override // z3.s
    public final Class d() {
        switch (this.f13865a) {
            case 0:
                return Bitmap.class;
            case 1:
                return byte[].class;
            default:
                return ((File) this.f13866b).getClass();
        }
    }

    @Override // z3.s
    public final Object get() {
        switch (this.f13865a) {
            case 0:
                return (Bitmap) this.f13866b;
            case 1:
                return (byte[]) this.f13866b;
            default:
                return (File) this.f13866b;
        }
    }

    @Override // z3.s
    public final void recycle() {
        int i3 = this.f13865a;
    }

    public y(File file) {
        t4.f.c(file, "Argument must not be null");
        this.f13866b = file;
    }

    public y(Bitmap bitmap) {
        this.f13866b = bitmap;
    }
}
