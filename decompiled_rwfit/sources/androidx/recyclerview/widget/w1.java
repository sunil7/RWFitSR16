package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2784a;

    /* renamed from: b, reason: collision with root package name */
    public int f2785b;

    /* renamed from: c, reason: collision with root package name */
    public int f2786c;

    /* renamed from: d, reason: collision with root package name */
    public int f2787d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2788f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2789g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2790h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2791i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2792j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2793k;

    /* renamed from: l, reason: collision with root package name */
    public int f2794l;

    /* renamed from: m, reason: collision with root package name */
    public long f2795m;

    /* renamed from: n, reason: collision with root package name */
    public int f2796n;

    public final void a(int i3) {
        if ((this.f2787d & i3) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i3) + " but it is " + Integer.toBinaryString(this.f2787d));
    }

    public final int b() {
        return this.f2789g ? this.f2785b - this.f2786c : this.e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("State{mTargetPosition=");
        sb2.append(this.f2784a);
        sb2.append(", mData=null, mItemCount=");
        sb2.append(this.e);
        sb2.append(", mIsMeasuring=");
        sb2.append(this.f2791i);
        sb2.append(", mPreviousLayoutItemCount=");
        sb2.append(this.f2785b);
        sb2.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
        sb2.append(this.f2786c);
        sb2.append(", mStructureChanged=");
        sb2.append(this.f2788f);
        sb2.append(", mInPreLayout=");
        sb2.append(this.f2789g);
        sb2.append(", mRunSimpleAnimations=");
        sb2.append(this.f2792j);
        sb2.append(", mRunPredictiveAnimations=");
        return android.support.v4.media.session.e.o(sb2, this.f2793k, '}');
    }
}
