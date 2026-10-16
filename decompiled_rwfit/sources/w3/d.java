package w3;

import a4.g;
import android.graphics.Bitmap;
import ef.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int[] f19500a;

    /* renamed from: c, reason: collision with root package name */
    public final i f19502c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f19503d;
    public byte[] e;

    /* renamed from: f, reason: collision with root package name */
    public short[] f19504f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f19505g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f19506h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f19507i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f19508j;

    /* renamed from: k, reason: collision with root package name */
    public int f19509k;

    /* renamed from: l, reason: collision with root package name */
    public b f19510l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f19511m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f19512n;

    /* renamed from: o, reason: collision with root package name */
    public int f19513o;

    /* renamed from: p, reason: collision with root package name */
    public final int f19514p;

    /* renamed from: q, reason: collision with root package name */
    public final int f19515q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public Boolean f19516s;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f19501b = new int[256];

    /* renamed from: t, reason: collision with root package name */
    public Bitmap.Config f19517t = Bitmap.Config.ARGB_8888;

    public d(i iVar, b bVar, ByteBuffer byteBuffer, int i3) {
        this.f19502c = iVar;
        this.f19510l = new b();
        synchronized (this) {
            try {
                if (i3 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i3);
                }
                int highestOneBit = Integer.highestOneBit(i3);
                int i10 = 0;
                this.f19513o = 0;
                this.f19510l = bVar;
                this.f19509k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f19503d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f19503d.order(ByteOrder.LITTLE_ENDIAN);
                this.f19512n = false;
                ArrayList arrayList = bVar.e;
                int size = arrayList.size();
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (((a) obj).f19481g == 3) {
                        this.f19512n = true;
                        break;
                    }
                }
                this.f19514p = highestOneBit;
                int i11 = bVar.f19490f;
                this.r = i11 / highestOneBit;
                int i12 = bVar.f19491g;
                this.f19515q = i12 / highestOneBit;
                this.f19507i = (byte[]) ((g) this.f19502c.f12630c).c(byte[].class, i11 * i12);
                this.f19508j = (int[]) ((g) this.f19502c.f12630c).c(int[].class, this.r * this.f19515q);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Bitmap a() {
        Boolean bool = this.f19516s;
        Bitmap a3 = ((a4.b) this.f19502c.f12629b).a(this.r, this.f19515q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f19517t);
        a3.setHasAlpha(true);
        return a3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x0063, B:19:0x0074, B:20:0x0080, B:23:0x0089, B:25:0x008d, B:27:0x0095, B:28:0x00a8, B:32:0x00ac, B:34:0x00b0, B:36:0x00c2, B:38:0x00c6, B:39:0x00ca, B:42:0x0085, B:44:0x00d0, B:46:0x00d8, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x0063, B:19:0x0074, B:20:0x0080, B:23:0x0089, B:25:0x008d, B:27:0x0095, B:28:0x00a8, B:32:0x00ac, B:34:0x00b0, B:36:0x00c2, B:38:0x00c6, B:39:0x00ca, B:42:0x0085, B:44:0x00d0, B:46:0x00d8, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x0063, B:19:0x0074, B:20:0x0080, B:23:0x0089, B:25:0x008d, B:27:0x0095, B:28:0x00a8, B:32:0x00ac, B:34:0x00b0, B:36:0x00c2, B:38:0x00c6, B:39:0x00ca, B:42:0x0085, B:44:0x00d0, B:46:0x00d8, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[Catch: all -> 0x0014, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x0063, B:19:0x0074, B:20:0x0080, B:23:0x0089, B:25:0x008d, B:27:0x0095, B:28:0x00a8, B:32:0x00ac, B:34:0x00b0, B:36:0x00c2, B:38:0x00c6, B:39:0x00ca, B:42:0x0085, B:44:0x00d0, B:46:0x00d8, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x0063, B:19:0x0074, B:20:0x0080, B:23:0x0089, B:25:0x008d, B:27:0x0095, B:28:0x00a8, B:32:0x00ac, B:34:0x00b0, B:36:0x00c2, B:38:0x00c6, B:39:0x00ca, B:42:0x0085, B:44:0x00d0, B:46:0x00d8, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8 A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x0063, B:19:0x0074, B:20:0x0080, B:23:0x0089, B:25:0x008d, B:27:0x0095, B:28:0x00a8, B:32:0x00ac, B:34:0x00b0, B:36:0x00c2, B:38:0x00c6, B:39:0x00ca, B:42:0x0085, B:44:0x00d0, B:46:0x00d8, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.Bitmap b() {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.d.b():android.graphics.Bitmap");
    }

    public final void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f19517t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r4.f19494j == r36.f19482h) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap d(w3.a r36, w3.a r37) {
        /*
            Method dump skipped, instructions count: 1047
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.d.d(w3.a, w3.a):android.graphics.Bitmap");
    }
}
