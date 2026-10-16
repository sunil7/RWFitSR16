package t1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.k;

/* loaded from: classes.dex */
public final class i implements TransformationMethod {

    /* renamed from: a, reason: collision with root package name */
    public final TransformationMethod f18485a;

    public i(TransformationMethod transformationMethod) {
        this.f18485a = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f18485a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || k.a().b() != 1) {
            return charSequence;
        }
        k a3 = k.a();
        a3.getClass();
        return a3.e(charSequence, 0, charSequence.length());
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z5, int i3, Rect rect) {
        TransformationMethod transformationMethod = this.f18485a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z5, i3, rect);
        }
    }
}
