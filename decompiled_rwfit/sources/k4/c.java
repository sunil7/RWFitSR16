package k4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends Drawable implements f, Animatable {

    /* renamed from: a, reason: collision with root package name */
    public final b f15470a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15471b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15472c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15473d;

    /* renamed from: f, reason: collision with root package name */
    public int f15474f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15476h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f15477i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f15478j;
    public boolean e = true;

    /* renamed from: g, reason: collision with root package name */
    public final int f15475g = -1;

    public c(b bVar) {
        this.f15470a = bVar;
    }

    public final void a() {
        t4.f.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f15473d);
        h hVar = (h) this.f15470a.f15469b;
        if (hVar.f15486a.f19510l.f19488c == 1) {
            invalidateSelf();
            return;
        }
        if (this.f15471b) {
            return;
        }
        this.f15471b = true;
        if (hVar.f15494j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        ArrayList arrayList = hVar.f15488c;
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (isEmpty && !hVar.f15490f) {
            hVar.f15490f = true;
            hVar.f15494j = false;
            hVar.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f15473d) {
            return;
        }
        if (this.f15476h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f15478j == null) {
                this.f15478j = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f15478j);
            this.f15476h = false;
        }
        h hVar = (h) this.f15470a.f15469b;
        e eVar = hVar.f15493i;
        Bitmap bitmap = eVar != null ? eVar.f15485g : hVar.f15496l;
        if (this.f15478j == null) {
            this.f15478j = new Rect();
        }
        Rect rect = this.f15478j;
        if (this.f15477i == null) {
            this.f15477i = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f15477i);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f15470a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((h) this.f15470a.f15469b).f15500p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((h) this.f15470a.f15469b).f15499o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f15471b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15476h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        if (this.f15477i == null) {
            this.f15477i = new Paint(2);
        }
        this.f15477i.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f15477i == null) {
            this.f15477i = new Paint(2);
        }
        this.f15477i.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z5, boolean z6) {
        t4.f.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f15473d);
        this.e = z5;
        if (!z5) {
            this.f15471b = false;
            h hVar = (h) this.f15470a.f15469b;
            ArrayList arrayList = hVar.f15488c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                hVar.f15490f = false;
            }
        } else if (this.f15472c) {
            a();
        }
        return super.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f15472c = true;
        this.f15474f = 0;
        if (this.e) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f15472c = false;
        this.f15471b = false;
        h hVar = (h) this.f15470a.f15469b;
        ArrayList arrayList = hVar.f15488c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            hVar.f15490f = false;
        }
    }
}
