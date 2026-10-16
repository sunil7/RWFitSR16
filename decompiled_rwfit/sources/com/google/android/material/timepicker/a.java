package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.v;

/* loaded from: classes.dex */
public final class a extends v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChipTextInputComboView f10978a;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.f10978a = chipTextInputComboView;
    }

    @Override // com.google.android.material.internal.v, android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean isEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f10978a;
        Chip chip = chipTextInputComboView.f10952a;
        if (isEmpty) {
            chip.setText(String.format(chipTextInputComboView.getResources().getConfiguration().locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt("00"))));
        } else {
            chip.setText(String.format(chipTextInputComboView.getResources().getConfiguration().locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(String.valueOf(editable)))));
        }
    }
}
