package t1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import com.google.android.gms.internal.mlkit_vision_common.b0;

/* loaded from: classes.dex */
public final class f extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f18478a;

    /* renamed from: b, reason: collision with root package name */
    public final d f18479b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18480c = true;

    public f(TextView textView) {
        this.f18478a = textView;
        this.f18479b = new d(textView);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        if (!this.f18480c) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i3 = 0; i3 < inputFilterArr.length; i3++) {
                InputFilter inputFilter = inputFilterArr[i3];
                if (inputFilter instanceof d) {
                    sparseArray.put(i3, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArray.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i12 = 0;
        while (true) {
            d dVar = this.f18479b;
            if (i12 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i12] == dVar) {
                return inputFilterArr;
            }
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final boolean b() {
        return this.f18480c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final void c(boolean z5) {
        if (z5) {
            TextView textView = this.f18478a;
            textView.setTransformationMethod(e(textView.getTransformationMethod()));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final void d(boolean z5) {
        this.f18480c = z5;
        TextView textView = this.f18478a;
        textView.setTransformationMethod(e(textView.getTransformationMethod()));
        textView.setFilters(a(textView.getFilters()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.b0
    public final TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f18480c ? ((transformationMethod instanceof i) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new i(transformationMethod) : transformationMethod instanceof i ? ((i) transformationMethod).f18485a : transformationMethod;
    }
}
