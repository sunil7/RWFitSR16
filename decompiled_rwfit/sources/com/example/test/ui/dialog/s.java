package com.example.test.ui.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.network.bean.DocUrlBean;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.R$style;
import com.example.test.ui.mine.activity.WebContentActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.r1;
import com.tencent.mmkv.MMKV;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class s extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.b f8026a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8027b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8028c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8029d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f8030f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context) {
        super(context, R$style.normalDialog);
        MMKV mmkv;
        kotlin.jvm.internal.e.f(context, "context");
        Window window = getWindow();
        kotlin.jvm.internal.e.c(window);
        window.setBackgroundDrawableResource(R.color.transparent);
        setContentView(R$layout.dialog_user_permission);
        View findViewById = findViewById(R$id.tvCancel);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8029d = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.tvSure);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.e = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.title);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8030f = (TextView) findViewById3;
        TextView textView = this.f8029d;
        DocUrlBean docUrlBean = null;
        if (textView == null) {
            kotlin.jvm.internal.e.m("tvCancelTv");
            throw null;
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.e;
        if (textView2 == null) {
            kotlin.jvm.internal.e.m("tvSureTv");
            throw null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.f8030f;
        if (textView3 == null) {
            kotlin.jvm.internal.e.m("titleTv");
            throw null;
        }
        textView3.setText(getContext().getString(R$string.str_welcome_use, getContext().getString(R$string.app_name)));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null && (mmkv = kVar.f8732a) != null) {
            docUrlBean = (DocUrlBean) mmkv.f("doc_url_info", DocUrlBean.class);
        }
        if (docUrlBean == null) {
            String str = f2.d(getContext()).equals("zh-cn") ? "zh" : "en";
            this.f8027b = String.format("https://www.ruiwo168.com/userProtocol_%s.html", Arrays.copyOf(new Object[]{str}, 1));
            this.f8028c = String.format("https://www.ruiwo168.com/privacyPolicy_%s.html", Arrays.copyOf(new Object[]{str}, 1));
        } else {
            String userProtocolUrl = docUrlBean.getUserProtocolUrl();
            kotlin.jvm.internal.e.e(userProtocolUrl, "getUserProtocolUrl(...)");
            this.f8027b = userProtocolUrl;
            String privacyPolicyUrl = docUrlBean.getPrivacyPolicyUrl();
            kotlin.jvm.internal.e.e(privacyPolicyUrl, "getPrivacyPolicyUrl(...)");
            this.f8028c = privacyPolicyUrl;
        }
        Context context2 = getContext();
        kotlin.jvm.internal.e.e(context2, "getContext(...)");
        oh.a aVar = new oh.a() { // from class: com.example.test.ui.dialog.UserProtocolDialog$initProtocol$spanned$1
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m56invoke();
                return eh.g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m56invoke() {
                int i3 = WebContentActivity.H;
                Context context3 = s.this.getContext();
                kotlin.jvm.internal.e.e(context3, "getContext(...)");
                String string = s.this.getContext().getString(R$string.str_user_protocol);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                String str2 = s.this.f8027b;
                if (str2 != null) {
                    r1.a(context3, string, str2);
                } else {
                    kotlin.jvm.internal.e.m("userPro");
                    throw null;
                }
            }
        };
        oh.a aVar2 = new oh.a() { // from class: com.example.test.ui.dialog.UserProtocolDialog$initProtocol$spanned$2
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m57invoke();
                return eh.g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m57invoke() {
                int i3 = WebContentActivity.H;
                Context context3 = s.this.getContext();
                kotlin.jvm.internal.e.e(context3, "getContext(...)");
                String string = s.this.getContext().getString(R$string.str_privacy_policy);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                String str2 = s.this.f8028c;
                if (str2 != null) {
                    r1.a(context3, string, str2);
                } else {
                    kotlin.jvm.internal.e.m("priPro");
                    throw null;
                }
            }
        };
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context2.getString(R$string.str_please_read));
        String o3 = l0.o("《", context2.getString(R$string.str_user_protocol), "》");
        String o8 = l0.o("《", context2.getString(R$string.str_privacy_policy), "》");
        SpannableStringBuilder a3 = ca.a(context2, context2.getResources().getColor(R$color.colorAccent), o3, aVar);
        SpannableStringBuilder a10 = ca.a(context2, context2.getResources().getColor(R$color.colorAccent), o8, aVar2);
        spannableStringBuilder.append((CharSequence) a3);
        spannableStringBuilder.append((CharSequence) "、");
        spannableStringBuilder.append((CharSequence) a10);
        TextView textView4 = (TextView) findViewById(R$id.tvReadProtocol);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        textView4.setText(spannableStringBuilder);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        t6.b bVar;
        dismiss();
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tvCancel;
        if (valueOf != null && valueOf.intValue() == i3) {
            t6.b bVar2 = this.f8026a;
            if (bVar2 != null) {
                bVar2.onCancel();
                return;
            }
            return;
        }
        int i10 = R$id.tvSure;
        if (valueOf == null || valueOf.intValue() != i10 || (bVar = this.f8026a) == null) {
            return;
        }
        bVar.s();
    }

    public final void setOnDialogListener(t6.b onDialogListener) {
        kotlin.jvm.internal.e.f(onDialogListener, "onDialogListener");
        this.f8026a = onDialogListener;
    }
}
