package com.dh.keeplive.pix;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.dh.keeplive.ext.a;
import com.google.android.gms.internal.mlkit_vision_barcode.bf;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class OnePixActivity extends AppCompatActivity {
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.d("one pix is created");
        overridePendingTransition(0, 0);
        getWindow().setGravity(8388659);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        if (a.f7209a == null) {
            a.f7209a = new WeakReference(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        WeakReference weakReference = a.f7209a;
        if (weakReference != null) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null) {
                activity.finish();
            }
            a.f7209a = null;
        }
        a.d("one pix is destroyed");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (bf.b(this)) {
            finish();
        }
    }
}
