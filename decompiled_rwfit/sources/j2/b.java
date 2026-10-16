package j2;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* loaded from: classes.dex */
public final class b extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15182a = 1;

    /* renamed from: b, reason: collision with root package name */
    public Object f15183b;

    public /* synthetic */ b(String str, Class cls) {
        super(cls, str);
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f15182a) {
            case 0:
                ((Drawable) obj).copyBounds((Rect) this.f15183b);
                return new PointF(r0.left, r0.top);
            case 1:
                Matrix matrix = (Matrix) this.f15183b;
                matrix.set(((ImageView) obj).getImageMatrix());
                return matrix;
            default:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                return Float.valueOf(ja.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.F.getColorForState(extendedFloatingActionButton.getDrawableState(), ((wa.a) this.f15183b).f19525b.F.getDefaultColor()))));
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f15182a) {
            case 0:
                Drawable drawable = (Drawable) obj;
                PointF pointF = (PointF) obj2;
                Rect rect = (Rect) this.f15183b;
                drawable.copyBounds(rect);
                rect.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(rect);
                break;
            case 1:
                ((ImageView) obj).setImageMatrix((Matrix) obj2);
                break;
            default:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                Float f2 = (Float) obj2;
                int colorForState = extendedFloatingActionButton.F.getColorForState(extendedFloatingActionButton.getDrawableState(), ((wa.a) this.f15183b).f19525b.F.getDefaultColor());
                ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (ja.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                if (f2.floatValue() != 1.0f) {
                    extendedFloatingActionButton.f(valueOf);
                    break;
                } else {
                    extendedFloatingActionButton.f(extendedFloatingActionButton.F);
                    break;
                }
        }
    }

    public b() {
        super(Matrix.class, "imageMatrixProperty");
        this.f15183b = new Matrix();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(wa.a aVar) {
        super(Float.class, "LABEL_OPACITY_PROPERTY");
        this.f15183b = aVar;
    }
}
