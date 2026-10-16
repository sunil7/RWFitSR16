package t1;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.k;
import com.google.android.gms.internal.mlkit_vision_common.b0;

/* loaded from: classes.dex */
public final class g extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final f f18481a;

    public g(TextView textView) {
        this.f18481a = new f(textView);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return !(k.f2036j != null) ? inputFilterArr : this.f18481a.a(inputFilterArr);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final boolean b() {
        return this.f18481a.f18480c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final void c(boolean z5) {
        if (k.f2036j != null) {
            this.f18481a.c(z5);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final void d(boolean z5) {
        boolean z6 = k.f2036j != null;
        f fVar = this.f18481a;
        if (z6) {
            fVar.d(z5);
        } else {
            fVar.f18480c = z5;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final TransformationMethod e(TransformationMethod transformationMethod) {
        return !(k.f2036j != null) ? transformationMethod : this.f18481a.e(transformationMethod);
    }
}
