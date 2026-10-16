package com.google.android.material.datepicker;

import android.content.Context;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10430a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f10431b;

    public h(j jVar, String str) {
        this.f10431b = jVar;
        this.f10430a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f10431b;
        TextInputLayout textInputLayout = jVar.f10436a;
        SimpleDateFormat simpleDateFormat = jVar.f10437b;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), this.f10430a) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), simpleDateFormat.format(new Date(e0.e().getTimeInMillis()))));
        jVar.a();
    }
}
