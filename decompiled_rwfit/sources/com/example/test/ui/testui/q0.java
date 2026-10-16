package com.example.test.ui.testui;

import android.view.KeyEvent;
import android.widget.CompoundButton;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TRingActionItemView;

/* loaded from: classes.dex */
public final /* synthetic */ class q0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8305a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f8306b;

    public /* synthetic */ q0(KeyEvent.Callback callback, int i3) {
        this.f8305a = i3;
        this.f8306b = callback;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton buttonView, boolean z5) {
        a7.d dVar;
        KeyEvent.Callback callback = this.f8306b;
        switch (this.f8305a) {
            case 0:
                int i3 = TRingSleepModeActivity.J;
                TRingSleepModeActivity this$0 = (TRingSleepModeActivity) callback;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(buttonView, "<anonymous parameter 0>");
                a7.d dVar2 = this$0.E;
                if (dVar2 != null) {
                    dVar2.j(z5);
                    break;
                }
                break;
            case 1:
                int i10 = ActionItemView.f8334h;
                ActionItemView this$02 = (ActionItemView) callback;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                kotlin.jvm.internal.e.f(buttonView, "<anonymous parameter 0>");
                a7.d dVar3 = this$02.f8335a;
                if (dVar3 != null) {
                    dVar3.j(z5);
                    break;
                }
                break;
            default:
                int i11 = TRingActionItemView.f8594i;
                TRingActionItemView this$03 = (TRingActionItemView) callback;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                kotlin.jvm.internal.e.f(buttonView, "buttonView");
                if (buttonView.isPressed() && (dVar = this$03.f8595a) != null) {
                    dVar.j(z5);
                    break;
                }
                break;
        }
    }
}
