package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* loaded from: classes.dex */
public final class r extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1029a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActivityChooserView f1030b;

    public /* synthetic */ r(ActivityChooserView activityChooserView, int i3) {
        this.f1029a = i3;
        this.f1030b = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f1029a) {
            case 0:
                super.onChanged();
                this.f1030b.f667a.notifyDataSetChanged();
                return;
            default:
                super.onChanged();
                this.f1030b.f667a.getClass();
                throw null;
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        switch (this.f1029a) {
            case 0:
                super.onInvalidated();
                this.f1030b.f667a.notifyDataSetInvalidated();
                break;
            default:
                super.onInvalidated();
                break;
        }
    }
}
