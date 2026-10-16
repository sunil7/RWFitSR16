package v0;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterView;

/* loaded from: classes.dex */
public final class b extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19114a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageFilterView f19115b;

    public /* synthetic */ b(ImageFilterView imageFilterView, int i3) {
        this.f19114a = i3;
        this.f19115b = imageFilterView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f19114a) {
            case 0:
                ImageFilterView imageFilterView = this.f19115b;
                outline.setRoundRect(0, 0, imageFilterView.getWidth(), imageFilterView.getHeight(), (Math.min(r9, r10) * imageFilterView.f1791i) / 2.0f);
                break;
            default:
                ImageFilterView imageFilterView2 = this.f19115b;
                outline.setRoundRect(0, 0, imageFilterView2.getWidth(), imageFilterView2.getHeight(), imageFilterView2.f1792j);
                break;
        }
    }
}
