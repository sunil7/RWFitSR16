package v0;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19112a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f19113b;

    public /* synthetic */ a(int i3, View view) {
        this.f19112a = i3;
        this.f19113b = view;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f19112a) {
            case 0:
                ImageFilterButton imageFilterButton = (ImageFilterButton) this.f19113b;
                outline.setRoundRect(0, 0, imageFilterButton.getWidth(), imageFilterButton.getHeight(), (Math.min(r9, r10) * imageFilterButton.f1774f) / 2.0f);
                break;
            case 1:
                ImageFilterButton imageFilterButton2 = (ImageFilterButton) this.f19113b;
                outline.setRoundRect(0, 0, imageFilterButton2.getWidth(), imageFilterButton2.getHeight(), imageFilterButton2.f1775g);
                break;
            default:
                qa.c cVar = ((Chip) this.f19113b).e;
                if (cVar == null) {
                    outline.setAlpha(0.0f);
                    break;
                } else {
                    cVar.getOutline(outline);
                    break;
                }
        }
    }
}
