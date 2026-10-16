package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    public final Chip f10952a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f10953b;

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f10952a.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f10953b.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z5) {
        Chip chip = this.f10952a;
        chip.setChecked(z5);
        int i3 = z5 ? 0 : 4;
        EditText editText = this.f10953b;
        editText.setVisibility(i3);
        chip.setVisibility(z5 ? 8 : 0);
        if (chip.isChecked()) {
            editText.requestFocus();
            if (TextUtils.isEmpty(editText.getText())) {
                return;
            }
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f10952a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i3, Object obj) {
        this.f10952a.setTag(i3, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f10952a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.f10952a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.f10953b = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a(this));
        editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
    }
}
