package xa;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;
import eb.h;

/* loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f19821a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShapeableImageView f19822b;

    public a(ShapeableImageView shapeableImageView) {
        this.f19822b = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.f19822b;
        if (shapeableImageView.f10521l == null) {
            return;
        }
        if (shapeableImageView.f10520k == null) {
            shapeableImageView.f10520k = new h(shapeableImageView.f10521l);
        }
        RectF rectF = shapeableImageView.e;
        Rect rect = this.f19821a;
        rectF.round(rect);
        shapeableImageView.f10520k.setBounds(rect);
        shapeableImageView.f10520k.getOutline(outline);
    }
}
