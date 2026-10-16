package a4;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class h implements b {

    /* renamed from: j, reason: collision with root package name */
    public static final Bitmap.Config f93j = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    public final l f94a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f95b;

    /* renamed from: c, reason: collision with root package name */
    public final ec.a f96c;

    /* renamed from: d, reason: collision with root package name */
    public final long f97d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public int f98f;

    /* renamed from: g, reason: collision with root package name */
    public int f99g;

    /* renamed from: h, reason: collision with root package name */
    public int f100h;

    /* renamed from: i, reason: collision with root package name */
    public int f101i;

    public h(long j4) {
        l lVar = new l();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f97d = j4;
        this.f94a = lVar;
        this.f95b = unmodifiableSet;
        this.f96c = new ec.a(1);
    }

    @Override // a4.b
    public final Bitmap a(int i3, int i10, Bitmap.Config config) {
        Bitmap c9 = c(i3, i10, config);
        if (c9 != null) {
            return c9;
        }
        if (config == null) {
            config = f93j;
        }
        return Bitmap.createBitmap(i3, i10, config);
    }

    public final void b() {
        Log.v("LruBitmapPool", "Hits=" + this.f98f + ", misses=" + this.f99g + ", puts=" + this.f100h + ", evictions=" + this.f101i + ", currentSize=" + this.e + ", maxSize=" + this.f97d + "\nStrategy=" + this.f94a);
    }

    public final synchronized Bitmap c(int i3, int i10, Bitmap.Config config) {
        Bitmap b3;
        try {
            if (config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            b3 = this.f94a.b(i3, i10, config != null ? config : f93j);
            if (b3 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb2 = new StringBuilder("Missing bitmap=");
                    this.f94a.getClass();
                    sb2.append(l.c(t4.l.b(i3, i10, config), config));
                    Log.d("LruBitmapPool", sb2.toString());
                }
                this.f99g++;
            } else {
                this.f98f++;
                long j4 = this.e;
                this.f94a.getClass();
                this.e = j4 - t4.l.c(b3);
                this.f96c.getClass();
                b3.setHasAlpha(true);
                b3.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb3 = new StringBuilder("Get bitmap=");
                this.f94a.getClass();
                sb3.append(l.c(t4.l.b(i3, i10, config), config));
                Log.v("LruBitmapPool", sb3.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                b();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return b3;
    }

    public final synchronized void d(long j4) {
        while (this.e > j4) {
            try {
                l lVar = this.f94a;
                Bitmap bitmap = (Bitmap) lVar.f111b.H();
                if (bitmap != null) {
                    lVar.a(Integer.valueOf(t4.l.c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        b();
                    }
                    this.e = 0L;
                    return;
                }
                this.f96c.getClass();
                long j10 = this.e;
                this.f94a.getClass();
                this.e = j10 - t4.l.c(bitmap);
                this.f101i++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Evicting bitmap=");
                    this.f94a.getClass();
                    sb2.append(l.c(t4.l.c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb2.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    b();
                }
                bitmap.recycle();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // a4.b
    public final Bitmap f(int i3, int i10, Bitmap.Config config) {
        Bitmap c9 = c(i3, i10, config);
        if (c9 != null) {
            c9.eraseColor(0);
            return c9;
        }
        if (config == null) {
            config = f93j;
        }
        return Bitmap.createBitmap(i3, i10, config);
    }

    @Override // a4.b
    public final synchronized void j(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f94a.getClass();
                if (t4.l.c(bitmap) <= this.f97d && this.f95b.contains(bitmap.getConfig())) {
                    this.f94a.getClass();
                    int c9 = t4.l.c(bitmap);
                    this.f94a.e(bitmap);
                    this.f96c.getClass();
                    this.f100h++;
                    this.e += c9;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder("Put bitmap in pool=");
                        this.f94a.getClass();
                        sb2.append(l.c(t4.l.c(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        b();
                    }
                    d(this.f97d);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb3 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f94a.getClass();
                sb3.append(l.c(t4.l.c(bitmap), bitmap.getConfig()));
                sb3.append(", is mutable: ");
                sb3.append(bitmap.isMutable());
                sb3.append(", is allowed config: ");
                sb3.append(this.f95b.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb3.toString());
            }
            bitmap.recycle();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // a4.b
    public final void k(int i3) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i3);
        }
        if (i3 >= 40 || i3 >= 20) {
            n();
        } else if (i3 >= 20 || i3 == 15) {
            d(this.f97d / 2);
        }
    }

    @Override // a4.b
    public final void n() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        d(0L);
    }
}
