package com.dh.imagepick.preview;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.p;
import com.dh.imagepick.R;

/* loaded from: classes.dex */
public class b extends p {
    @Override // androidx.fragment.app.p
    public final Dialog W() {
        Dialog dialog = new Dialog(requireActivity(), R.style.Theme_Light_NoTitle_ViewerDialog);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.Animation_Keep);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setGravity(17);
        }
        return dialog;
    }

    public void X() {
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = getView();
        if (view != null) {
            view.setOnKeyListener(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        View view = getView();
        if (view != null) {
            view.requestFocus();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.e.f(view, "view");
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        view.setOnKeyListener(new View.OnKeyListener() { // from class: com.dh.imagepick.preview.a
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i3, KeyEvent keyEvent) {
                b bVar = b.this;
                boolean z5 = keyEvent.getAction() == 1 && i3 == 4;
                Log.i("viewer", "keyCode " + i3 + " event " + keyEvent + " backPressed " + z5);
                if (z5) {
                    bVar.X();
                }
                return z5;
            }
        });
    }
}
