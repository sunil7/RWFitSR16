package com.example.baselibrary.base.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.baselibrary.preseneter.b;
import com.google.android.gms.internal.mlkit_vision_barcode.ce;
import java.util.WeakHashMap;
import kotlin.a;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public abstract class BaseActivity<P extends b, B> extends AppCompatActivity {
    public static final /* synthetic */ int A = 0;

    /* renamed from: y, reason: collision with root package name */
    public final eh.b f7246y = a.b(new oh.a(this) { // from class: com.example.baselibrary.base.activity.BaseActivity$presenter$2
        final /* synthetic */ BaseActivity<P, B> this$0;

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
    public final eh.b f7247z = a.b(new oh.a(this) { // from class: com.example.baselibrary.base.activity.BaseActivity$binding$2
        final /* synthetic */ BaseActivity<P, B> this$0;

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
        return (b) this.f7246y.getValue();
    }

    public abstract Object J0();

    public abstract void K0();

    public void L0(Bundle bundle) {
    }

    public abstract void M0();

    public abstract void N0();

    public abstract void O0();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N0();
        setContentView(H0());
        L0(bundle);
        ce.a(getWindow());
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        View H0 = H0();
        b9.a aVar = new b9.a(1);
        WeakHashMap weakHashMap = z0.f15748a;
        n0.u(H0, aVar);
        O0();
        M0();
        K0();
    }

    public final void w0(int i3) {
        Toast.makeText(this, i3, 0).show();
    }
}
