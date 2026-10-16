package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* loaded from: classes.dex */
public final class i extends x1 {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f928j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ View f929k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(View view, View view2, int i3) {
        super(view2);
        this.f928j = i3;
        this.f929k = view;
    }

    @Override // androidx.appcompat.widget.x1
    public final h.b0 b() {
        f fVar;
        switch (this.f928j) {
            case 0:
                f fVar2 = ((j) this.f929k).f946d.f970t;
                if (fVar2 == null) {
                    return null;
                }
                return fVar2.a();
            case 1:
                return ((ActivityChooserView) this.f929k).getListPopupWindow();
            default:
                h.b bVar = ((ActionMenuItemView) this.f929k).f583m;
                if (bVar == null || (fVar = ((g) bVar).f901a.f971u) == null) {
                    return null;
                }
                return fVar.a();
        }
    }

    @Override // androidx.appcompat.widget.x1
    public final boolean c() {
        h.b0 b3;
        switch (this.f928j) {
            case 0:
                ((j) this.f929k).f946d.n();
                return true;
            case 1:
                ActivityChooserView activityChooserView = (ActivityChooserView) this.f929k;
                if (activityChooserView.b() || !activityChooserView.f676k) {
                    return true;
                }
                activityChooserView.f667a.getClass();
                throw new IllegalStateException("No data model. Did you call #setDataModel?");
            default:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f929k;
                h.j jVar = actionMenuItemView.f581k;
                return jVar != null && jVar.b(actionMenuItemView.f578h) && (b3 = b()) != null && b3.a();
        }
    }

    @Override // androidx.appcompat.widget.x1
    public boolean d() {
        switch (this.f928j) {
            case 0:
                l lVar = ((j) this.f929k).f946d;
                if (lVar.f972v != null) {
                    return false;
                }
                lVar.d();
                return true;
            case 1:
                ((ActivityChooserView) this.f929k).a();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f928j = 2;
        this.f929k = actionMenuItemView;
    }
}
