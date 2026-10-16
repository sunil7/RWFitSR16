package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class z0 extends y2.f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppCompatTextView f1128c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(AppCompatTextView appCompatTextView) {
        super(appCompatTextView, 3);
        this.f1128c = appCompatTextView;
    }

    @Override // y2.f, androidx.appcompat.widget.y0
    public final void a(int i3) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i3);
    }

    @Override // y2.f, androidx.appcompat.widget.y0
    public final void b(int i3) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i3);
    }
}
