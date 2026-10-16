package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements l1.y {

    /* renamed from: a, reason: collision with root package name */
    public final w f693a;

    /* renamed from: b, reason: collision with root package name */
    public final x0 f694b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f695c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.core.widget.v f696d;
    public final d0 e;

    /* renamed from: f, reason: collision with root package name */
    public z f697f;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    private z getSuperCaller() {
        if (this.f697f == null) {
            this.f697f = new z(this);
        }
        return this.f697f;
    }

    @Override // l1.y
    public final l1.h a(l1.h hVar) {
        return this.f696d.a(this, hVar);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f693a;
        if (wVar != null) {
            wVar.a();
        }
        x0 x0Var = this.f694b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.google.android.gms.internal.mlkit_common.m.d(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f693a;
        if (wVar != null) {
            return wVar.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f693a;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f694b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f694b.e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f695c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) d0Var.f884c;
        return textClassifier == null ? r0.a((TextView) d0Var.f883b) : textClassifier;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] f2;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f694b.getClass();
        x0.h(editorInfo, onCreateInputConnection, this);
        ca.f.a(editorInfo, onCreateInputConnection, this);
        if (onCreateInputConnection != null && Build.VERSION.SDK_INT <= 30 && (f2 = l1.z0.f(this)) != null) {
            editorInfo.contentMimeTypes = f2;
            onCreateInputConnection = new n1.b(onCreateInputConnection, new af.a(this, 23));
        }
        return this.e.c(onCreateInputConnection, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z5 = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && l1.z0.f(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z5 = e0.a(dragEvent, this, activity);
            }
        }
        if (z5) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i3) {
        l1.e eVar;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31 || l1.z0.f(this) == null || !(i3 == 16908322 || i3 == 16908337)) {
            return super.onTextContextMenuItem(i3);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i10 >= 31) {
                eVar = new com.example.test.ui.device.activity.i0(primaryClip, 1);
            } else {
                l1.f fVar = new l1.f();
                fVar.f15690b = primaryClip;
                fVar.f15691c = 1;
                eVar = fVar;
            }
            eVar.j(i3 == 16908322 ? 0 : 1);
            l1.z0.i(this, eVar.b());
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f693a;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        w wVar = this.f693a;
        if (wVar != null) {
            wVar.o(i3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f694b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f694b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.google.android.gms.internal.mlkit_common.m.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        this.e.d(z5);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        w wVar = this.f693a;
        if (wVar != null) {
            wVar.t(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        w wVar = this.f693a;
        if (wVar != null) {
            wVar.u(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        x0 x0Var = this.f694b;
        x0Var.l(colorStateList);
        x0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        x0 x0Var = this.f694b;
        x0Var.m(mode);
        x0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        x0 x0Var = this.f694b;
        if (x0Var != null) {
            x0Var.g(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f695c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            d0Var.f884c = textClassifier;
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        m3.a(context);
        l3.a(getContext(), this);
        w wVar = new w(this);
        this.f693a = wVar;
        wVar.l(attributeSet, i3);
        x0 x0Var = new x0(this);
        this.f694b = x0Var;
        x0Var.f(attributeSet, i3);
        x0Var.b();
        d0 d0Var = new d0();
        d0Var.f883b = this;
        this.f695c = d0Var;
        this.f696d = new androidx.core.widget.v();
        d0 d0Var2 = new d0(this);
        this.e = d0Var2;
        d0Var2.b(attributeSet, i3);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean isFocusable = super.isFocusable();
        boolean isClickable = super.isClickable();
        boolean isLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener a3 = d0Var2.a(keyListener);
        if (a3 == keyListener) {
            return;
        }
        super.setKeyListener(a3);
        super.setRawInputType(inputType);
        super.setFocusable(isFocusable);
        super.setClickable(isClickable);
        super.setLongClickable(isLongClickable);
    }
}
