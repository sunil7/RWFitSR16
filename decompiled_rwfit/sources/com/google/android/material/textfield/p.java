package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* loaded from: classes.dex */
public final class p extends m {

    /* renamed from: d, reason: collision with root package name */
    public final h f10947d;
    public final a e;

    /* renamed from: f, reason: collision with root package name */
    public final b f10948f;

    public p(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f10947d = new h(this, 1);
        int i3 = 2;
        this.e = new a(this, i3);
        this.f10948f = new b(this, i3);
    }

    public static boolean d(p pVar) {
        EditText editText = pVar.f10921a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // com.google.android.material.textfield.m
    public final void a() {
        Drawable b3 = pb.b(this.f10922b, R$drawable.design_password_eye);
        TextInputLayout textInputLayout = this.f10921a;
        textInputLayout.setEndIconDrawable(b3);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        textInputLayout.setEndIconOnClickListener(new androidx.appcompat.app.c(this, 8));
        textInputLayout.addOnEditTextAttachedListener(this.e);
        textInputLayout.addOnEndIconChangedListener(this.f10948f);
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
