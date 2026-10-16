package com.example.baselibrary.base.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.baselibrary.preseneter.b;
import com.google.android.gms.internal.mlkit_vision_barcode.ce;
import kotlin.a;

/* loaded from: classes.dex */
public abstract class RBaseActivity<P extends b, B> extends AppCompatActivity {

    /* renamed from: y, reason: collision with root package name */
    public final eh.b f7248y = a.b(new oh.a(this) { // from class: com.example.baselibrary.base.activity.RBaseActivity$presenter$2
        final /* synthetic */ RBaseActivity<P, B> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TP; */
        @Override // oh.a
        public final b invoke() {
            return this.this$0.G0();
        }
    });

    /* renamed from: z, reason: collision with root package name */
    public final eh.b f7249z = a.b(new oh.a(this) { // from class: com.example.baselibrary.base.activity.RBaseActivity$binding$2
        final /* synthetic */ RBaseActivity<P, B> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [B, java.lang.Object] */
        @Override // oh.a
        public final B invoke() {
            return this.this$0.J0();
        }
    });

    public abstract b G0();

    public abstract View H0();

    public final b I0() {
        return (b) this.f7248y.getValue();
    }

    public abstract Object J0();

    public abstract void K0();

    public abstract void L0();

    public abstract void M0();

    public abstract void N0();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        M0();
        setContentView(H0());
        ce.a(getWindow());
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        N0();
        L0();
        K0();
    }

    public final void w0(int i3) {
        Toast.makeText(this, i3, 0).show();
    }
}
