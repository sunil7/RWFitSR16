package com.example.test.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;
import com.google.android.material.R$attr;
import java.util.List;

/* loaded from: classes.dex */
public final class l extends Dialog implements View.OnClickListener {
    public static final /* synthetic */ int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final List f7980a;

    /* renamed from: b, reason: collision with root package name */
    public String f7981b;

    /* renamed from: c, reason: collision with root package name */
    public t6.a f7982c;

    /* renamed from: d, reason: collision with root package name */
    public final s3.d f7983d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, List selectData) {
        super(context, R$style.bottom_dialog);
        kotlin.jvm.internal.e.f(context, "context");
        kotlin.jvm.internal.e.f(selectData, "selectData");
        this.f7980a = selectData;
        this.f7981b = "";
        setContentView(R$layout.dialog_select_single);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R$attr.colorOnPrimary, typedValue, true);
        int i3 = typedValue.data;
        p3.a aVar = new p3.a(getContext(), new af.a(this, 7));
        aVar.f17450a.f17768v = i3;
        Resources resources = getContext().getResources();
        aVar.f17450a.f17769w = resources != null ? resources.getColor(R$color.color_3cfff) : -7829368;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.decor);
        q3.a aVar2 = aVar.f17450a;
        aVar2.r = viewGroup;
        aVar2.f17766t = 0;
        aVar2.f17770x = 1.8f;
        aVar.b(R$layout.view_single_select, new b9.a(11));
        s3.d a3 = aVar.a();
        this.f7983d = a3;
        a3.f(selectData, null, null);
        s3.d dVar = this.f7983d;
        if (dVar != null) {
            dVar.d();
        }
        TextView textView = (TextView) findViewById(R$id.tvCancel);
        TextView textView2 = (TextView) findViewById(R$id.tvSure);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    public final void a(int i3) {
        this.f7981b = (String) this.f7980a.get(i3);
        s3.d dVar = this.f7983d;
        if (dVar != null) {
            dVar.e.f17752d = i3;
            dVar.e();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tvSure;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.a aVar = this.f7982c;
            if (aVar != null) {
                aVar.v(this.f7981b);
                return;
            }
            return;
        }
        int i10 = R$id.tvCancel;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
        }
    }

    public final void setOnDialogDataListener(t6.a onDialogDataListener) {
        kotlin.jvm.internal.e.f(onDialogDataListener, "onDialogDataListener");
        this.f7982c = onDialogDataListener;
    }
}
