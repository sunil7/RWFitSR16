package androidx.recyclerview.widget;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    public int f2529a;

    /* renamed from: b, reason: collision with root package name */
    public int f2530b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2531c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2532d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f2533f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f2534g;

    public d2(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f2534g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f2529a = -1;
        this.f2530b = Integer.MIN_VALUE;
        this.f2531c = false;
        this.f2532d = false;
        this.e = false;
        int[] iArr = this.f2533f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
