package androidx.fragment.app;

import androidx.lifecycle.Lifecycle$State;

/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2161a;

    /* renamed from: b, reason: collision with root package name */
    public Fragment f2162b;

    /* renamed from: c, reason: collision with root package name */
    public int f2163c;

    /* renamed from: d, reason: collision with root package name */
    public int f2164d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f2165f;

    /* renamed from: g, reason: collision with root package name */
    public Lifecycle$State f2166g;

    /* renamed from: h, reason: collision with root package name */
    public Lifecycle$State f2167h;

    public d1(Fragment fragment, int i3) {
        this.f2161a = i3;
        this.f2162b = fragment;
        Lifecycle$State lifecycle$State = Lifecycle$State.RESUMED;
        this.f2166g = lifecycle$State;
        this.f2167h = lifecycle$State;
    }
}
