package k4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import t4.l;

/* loaded from: classes.dex */
public final class e implements q4.g {

    /* renamed from: a, reason: collision with root package name */
    public final int f15480a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15481b;

    /* renamed from: c, reason: collision with root package name */
    public p4.c f15482c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f15483d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final long f15484f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f15485g;

    public e(Handler handler, int i3, long j4) {
        if (!l.h(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f15480a = Integer.MIN_VALUE;
        this.f15481b = Integer.MIN_VALUE;
        this.f15483d = handler;
        this.e = i3;
        this.f15484f = j4;
    }

    @Override // q4.g
    public final void a(com.bumptech.glide.request.a aVar) {
        aVar.n(this.f15480a, this.f15481b);
    }

    @Override // q4.g
    public final void b(Drawable drawable) {
    }

    @Override // q4.g
    public final void c(com.bumptech.glide.request.a aVar) {
    }

    @Override // q4.g
    public final void d(p4.c cVar) {
        this.f15482c = cVar;
    }

    @Override // q4.g
    public final void e(Drawable drawable) {
    }

    @Override // q4.g
    public final p4.c f() {
        return this.f15482c;
    }

    @Override // q4.g
    public final void g(Drawable drawable) {
        this.f15485g = null;
    }

    @Override // q4.g
    public final void h(Object obj) {
        this.f15485g = (Bitmap) obj;
        Handler handler = this.f15483d;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f15484f);
    }

    @Override // m4.g
    public final void i() {
    }

    @Override // m4.g
    public final void onDestroy() {
    }

    @Override // m4.g
    public final void onStop() {
    }
}
