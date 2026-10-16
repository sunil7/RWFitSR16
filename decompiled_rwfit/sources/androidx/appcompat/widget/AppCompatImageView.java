package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public final w f701a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f702b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f703c;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f701a;
        if (wVar != null) {
            wVar.a();
        }
        b0 b0Var = this.f702b;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f701a;
        if (wVar != null) {
            return wVar.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f701a;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        n3 n3Var;
        b0 b0Var = this.f702b;
        if (b0Var == null || (n3Var = (n3) b0Var.f874c) == null) {
            return null;
        }
        return n3Var.f1004a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        n3 n3Var;
        b0 b0Var = this.f702b;
        if (b0Var == null || (n3Var = (n3) b0Var.f874c) == null) {
            return null;
        }
        return n3Var.f1005b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f702b.f873b).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f701a;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        w wVar = this.f701a;
        if (wVar != null) {
            wVar.o(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        b0 b0Var = this.f702b;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        b0 b0Var = this.f702b;
        if (b0Var != null && drawable != null && !this.f703c) {
            b0Var.f872a = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (b0Var != null) {
            b0Var.b();
            if (this.f703c) {
                return;
            }
            ImageView imageView = (ImageView) b0Var.f873b;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(b0Var.f872a);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i3) {
        super.setImageLevel(i3);
        this.f703c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        b0 b0Var = this.f702b;
        if (b0Var != null) {
            b0Var.f(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        b0 b0Var = this.f702b;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        w wVar = this.f701a;
        if (wVar != null) {
            wVar.t(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        w wVar = this.f701a;
        if (wVar != null) {
            wVar.u(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f702b;
        if (b0Var != null) {
            if (((n3) b0Var.f874c) == null) {
                b0Var.f874c = new n3();
            }
            n3 n3Var = (n3) b0Var.f874c;
            n3Var.f1004a = colorStateList;
            n3Var.f1007d = true;
            b0Var.b();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f702b;
        if (b0Var != null) {
            if (((n3) b0Var.f874c) == null) {
                b0Var.f874c = new n3();
            }
            n3 n3Var = (n3) b0Var.f874c;
            n3Var.f1005b = mode;
            n3Var.f1006c = true;
            b0Var.b();
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        m3.a(context);
        this.f703c = false;
        l3.a(getContext(), this);
        w wVar = new w(this);
        this.f701a = wVar;
        wVar.l(attributeSet, i3);
        b0 b0Var = new b0(this);
        this.f702b = b0Var;
        b0Var.e(attributeSet, i3);
    }
}
