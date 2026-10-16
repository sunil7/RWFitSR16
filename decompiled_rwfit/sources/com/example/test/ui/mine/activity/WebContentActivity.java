package com.example.test.ui.mine.activity;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.x2;

/* loaded from: classes.dex */
public final class WebContentActivity extends XXBaseActivity<com.example.test.presenter.device.n, x2> implements p5.a {
    public static final /* synthetic */ int H = 0;
    public WebView E;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.WebContentActivity$titleStr$2
        {
            super(0);
        }

        @Override // oh.a
        public final String invoke() {
            return WebContentActivity.this.getIntent().getStringExtra("title");
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.WebContentActivity$urlStr$2
        {
            super(0);
        }

        @Override // oh.a
        public final String invoke() {
            return WebContentActivity.this.getIntent().getStringExtra("url");
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 15);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((x2) this.f7247z.getValue()).f13448a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_web_content, (ViewGroup) null, false);
        int i3 = R$id.titleView;
        TitleView titleView = (TitleView) he.a(i3, inflate);
        if (titleView != null) {
            i3 = R$id.webContent;
            LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
            if (linearLayout != null) {
                return new x2((LinearLayout) inflate, titleView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((x2) bVar.getValue()).f13449b.setOnTitleListener(new o(this, 9));
        String str = (String) this.F.getValue();
        if (str != null) {
            ((x2) bVar.getValue()).f13449b.setTitle(str);
        }
        this.E = new WebView(this);
        ((x2) bVar.getValue()).f13450c.addView(this.E);
        WebView webView = this.E;
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            String str2 = (String) this.G.getValue();
            if (str2 != null) {
                webView.loadUrl(str2);
            }
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        WebView webView = this.E;
        if (webView != null) {
            ((x2) this.f7247z.getValue()).f13450c.removeView(webView);
            this.E = null;
        }
    }
}
