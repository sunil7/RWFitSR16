package com.google.android.material.textfield;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.widget.s2;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$attr;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10887a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f10888b;

    public /* synthetic */ a(m mVar, int i3) {
        this.f10887a = i3;
        this.f10888b = mVar;
    }

    @Override // com.google.android.material.textfield.s
    public final void a(TextInputLayout textInputLayout) {
        m mVar = this.f10888b;
        switch (this.f10887a) {
            case 0:
                EditText editText = textInputLayout.getEditText();
                textInputLayout.setEndIconVisible(editText.hasFocus() && editText.getText().length() > 0);
                textInputLayout.setEndIconCheckable(false);
                e eVar = (e) mVar;
                editText.setOnFocusChangeListener(eVar.e);
                s2 s2Var = eVar.f10895d;
                editText.removeTextChangedListener(s2Var);
                editText.addTextChangedListener(s2Var);
                return;
            case 1:
                EditText editText2 = textInputLayout.getEditText();
                if (!(editText2 instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText2;
                l lVar = (l) mVar;
                int boxBackgroundMode = lVar.f10921a.getBoxBackgroundMode();
                if (boxBackgroundMode == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(lVar.f10917m);
                } else if (boxBackgroundMode == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(lVar.f10916l);
                }
                if (!l.f(autoCompleteTextView)) {
                    TextInputLayout textInputLayout2 = lVar.f10921a;
                    int boxBackgroundMode2 = textInputLayout2.getBoxBackgroundMode();
                    eb.h boxBackground = textInputLayout2.getBoxBackground();
                    int b3 = x.b(R$attr.colorControlHighlight, autoCompleteTextView);
                    int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
                    if (boxBackgroundMode2 == 2) {
                        int b10 = x.b(R$attr.colorSurface, autoCompleteTextView);
                        eb.h hVar = new eb.h(boxBackground.f12505a.f12488a);
                        int d5 = x.d(b3, 0.1f, b10);
                        hVar.l(new ColorStateList(iArr, new int[]{d5, 0}));
                        hVar.setTint(b10);
                        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{d5, b10});
                        eb.h hVar2 = new eb.h(boxBackground.f12505a.f12488a);
                        hVar2.setTint(-1);
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, hVar, hVar2), boxBackground});
                        WeakHashMap weakHashMap = z0.f15748a;
                        h0.q(autoCompleteTextView, layerDrawable);
                    } else if (boxBackgroundMode2 == 1) {
                        int boxBackgroundColor = textInputLayout2.getBoxBackgroundColor();
                        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{x.d(b3, 0.1f, boxBackgroundColor), boxBackgroundColor}), boxBackground, boxBackground);
                        WeakHashMap weakHashMap2 = z0.f15748a;
                        h0.q(autoCompleteTextView, rippleDrawable);
                    }
                }
                autoCompleteTextView.setOnTouchListener(new j(lVar, autoCompleteTextView));
                autoCompleteTextView.setOnFocusChangeListener(lVar.e);
                autoCompleteTextView.setOnDismissListener(new k(lVar));
                autoCompleteTextView.setThreshold(0);
                h hVar3 = lVar.f10909d;
                autoCompleteTextView.removeTextChangedListener(hVar3);
                autoCompleteTextView.addTextChangedListener(hVar3);
                textInputLayout.setEndIconCheckable(true);
                textInputLayout.setErrorIconDrawable((Drawable) null);
                if (autoCompleteTextView.getKeyListener() == null) {
                    CheckableImageButton checkableImageButton = lVar.f10923c;
                    WeakHashMap weakHashMap3 = z0.f15748a;
                    h0.s(checkableImageButton, 2);
                }
                textInputLayout.setTextInputAccessibilityDelegate(lVar.f10910f);
                textInputLayout.setEndIconVisible(true);
                return;
            default:
                EditText editText3 = textInputLayout.getEditText();
                textInputLayout.setEndIconVisible(true);
                textInputLayout.setEndIconCheckable(true);
                p pVar = (p) mVar;
                pVar.f10923c.setChecked(!p.d(pVar));
                h hVar4 = pVar.f10947d;
                editText3.removeTextChangedListener(hVar4);
                editText3.addTextChangedListener(hVar4);
                return;
        }
    }
}
