package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class a0 extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2513a;

    @Override // androidx.recyclerview.widget.c0
    public int getSpanIndex(int i3, int i10) {
        switch (this.f2513a) {
            case 0:
                return i3 % i10;
            default:
                return super.getSpanIndex(i3, i10);
        }
    }

    @Override // androidx.recyclerview.widget.c0
    public final int getSpanSize(int i3) {
        switch (this.f2513a) {
            case 0:
                return 1;
            default:
                return 2;
        }
    }
}
