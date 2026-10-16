package com.example.test.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;
import com.google.android.material.R$attr;
import java.util.List;

/* loaded from: classes.dex */
public final class p extends Dialog implements View.OnClickListener {
    public static final /* synthetic */ int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final List f8007a;

    /* renamed from: b, reason: collision with root package name */
    public String f8008b;

    /* renamed from: c, reason: collision with root package name */
    public t6.a f8009c;

    /* renamed from: d, reason: collision with root package name */
    public final s3.d f8010d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, List selectData) {
        super(context, R$style.bottom_dialog);
        kotlin.jvm.internal.e.f(context, "context");
        kotlin.jvm.internal.e.f(selectData, "selectData");
        this.f8007a = selectData;
        this.f8008b = "";
        setContentView(R$layout.dialog_ring_select_single);
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
        p3.a aVar = new p3.a(getContext(), new af.a(this, 8));
        aVar.f17450a.f17768v = i3;
        Resources resources = getContext().getResources();
        aVar.f17450a.f17769w = resources != null ? resources.getColor(R$color.color_3cfff) : -7829368;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.decor);
        q3.a aVar2 = aVar.f17450a;
        aVar2.r = viewGroup;
        aVar2.f17766t = 0;
        aVar2.f17770x = 1.8f;
        aVar.b(R$layout.view_single_select, new b9.a(12));
        s3.d a3 = aVar.a();
        this.f8010d = a3;
        a3.f(selectData, null, null);
        s3.d dVar = this.f8010d;
        if (dVar != null) {
            dVar.d();
        }
        ImageView imageView = (ImageView) findViewById(R$id.ivCancel);
        ImageView imageView2 = (ImageView) findViewById(R$id.ivOk);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }

    public final void a(int i3) {
        this.f8008b = (String) this.f8007a.get(i3);
        s3.d dVar = this.f8010d;
        if (dVar != null) {
            dVar.e.f17752d = i3;
            dVar.e();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.ivOk;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.a aVar = this.f8009c;
            if (aVar != null) {
                aVar.v(this.f8008b);
                return;
            }
            return;
        }
        int i10 = R$id.ivCancel;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
        }
    }

    public final void setOnDialogDataListener(t6.a onDialogDataListener) {
        kotlin.jvm.internal.e.f(onDialogDataListener, "onDialogDataListener");
        this.f8009c = onDialogDataListener;
    }
}
