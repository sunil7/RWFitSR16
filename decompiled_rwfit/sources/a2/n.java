package a2;

/* loaded from: classes.dex */
public final class n extends androidx.recyclerview.widget.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f71d;
    public final /* synthetic */ int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f72f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f73g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f74h;

    public n(m mVar, int i3, m mVar2, int i10, int i11) {
        this.f71d = mVar;
        this.e = i3;
        this.f72f = mVar2;
        this.f73g = i10;
        this.f74h = i11;
    }

    @Override // androidx.recyclerview.widget.c
    public final boolean areContentsTheSame(int i3, int i10) {
        Object obj = this.f71d.get(i3 + this.e);
        m mVar = this.f72f;
        Object obj2 = mVar.get(i10 + mVar.f63a);
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // androidx.recyclerview.widget.c
    public final boolean areItemsTheSame(int i3, int i10) {
        Object obj = this.f71d.get(i3 + this.e);
        m mVar = this.f72f;
        Object obj2 = mVar.get(i10 + mVar.f63a);
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // androidx.recyclerview.widget.c
    public final Object getChangePayload(int i3, int i10) {
        this.f71d.get(i3 + this.e);
        m mVar = this.f72f;
        mVar.get(i10 + mVar.f63a);
        return null;
    }

    @Override // androidx.recyclerview.widget.c
    public final int getNewListSize() {
        return this.f74h;
    }

    @Override // androidx.recyclerview.widget.c
    public final int getOldListSize() {
        return this.f73g;
    }
}
