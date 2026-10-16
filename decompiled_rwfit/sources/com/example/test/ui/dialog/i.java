package com.example.test.ui.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.R$style;

/* loaded from: classes.dex */
public final class i extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.b f7966a;

    /* renamed from: b, reason: collision with root package name */
    public int f7967b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, int i3) {
        super(context, R$style.normalDialog);
        kotlin.jvm.internal.e.f(context, "context");
        this.f7967b = i3;
        Window window = getWindow();
        kotlin.jvm.internal.e.c(window);
        window.setBackgroundDrawableResource(R.color.transparent);
        setContentView(R$layout.dialog_tip_permission);
        ((TextView) findViewById(R$id.tvPermCancel)).setOnClickListener(this);
        ((TextView) findViewById(R$id.tvPermSure)).setOnClickListener(this);
        a();
    }

    public final void a() {
        TextView textView = (TextView) findViewById(R$id.tvPermissionTitle);
        TextView textView2 = (TextView) findViewById(R$id.tvPermissionContent);
        int i3 = this.f7967b;
        if (i3 == 1) {
            textView.setText(getContext().getText(R$string.str_permission_title_photo));
            textView2.setText(getContext().getText(R$string.str_permission_content_photo));
        } else if (i3 == 2) {
            textView.setText(getContext().getText(R$string.str_permission_title_location));
            textView2.setText(getContext().getText(R$string.str_permission_content_location));
        } else if (i3 == 3) {
            textView.setText(getContext().getText(R$string.str_permission_title_location_camera));
            textView2.setText(getContext().getText(R$string.str_permission_content_location_camera));
        }
    }

    public final void b(int i3) {
        this.f7967b = i3;
        a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        t6.b bVar;
        dismiss();
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tvPermCancel;
        if (valueOf != null && valueOf.intValue() == i3) {
            t6.b bVar2 = this.f7966a;
            if (bVar2 != null) {
                bVar2.onCancel();
                return;
            }
            return;
        }
        int i10 = R$id.tvPermSure;
        if (valueOf == null || valueOf.intValue() != i10 || (bVar = this.f7966a) == null) {
            return;
        }
        bVar.s();
    }

    public final void setOnDialogListener(t6.b onDialogListener) {
        kotlin.jvm.internal.e.f(onDialogListener, "onDialogListener");
        this.f7966a = onDialogListener;
    }
}
