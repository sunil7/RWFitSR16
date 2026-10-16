package com.example.test.ui.view;

import android.os.Message;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class i extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8695a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8696b;

    public /* synthetic */ i(Object obj, int i3) {
        this.f8695a = i3;
        this.f8696b = obj;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        switch (this.f8695a) {
            case 0:
                j jVar = (j) this.f8696b;
                jVar.f8697a.f8475g.addAndGet(1);
                jVar.f8697a.invalidate();
                int i3 = jVar.f8697a.f8475g.get();
                LongClickView longClickView = jVar.f8697a;
                if (i3 * longClickView.f8481m >= longClickView.f8480l * 1000) {
                    longClickView.f8475g.set(0);
                    cancel();
                    jVar.f8697a.invalidate();
                    LongClickView longClickView2 = jVar.f8697a;
                    longClickView2.f8477i = true;
                    if (longClickView2.f8476h != null) {
                        longClickView2.f8475g.set(0);
                        jVar.f8697a.invalidate();
                        jVar.f8697a.f8476h.a();
                        break;
                    }
                }
                break;
            default:
                TimeDownView timeDownView = (TimeDownView) this.f8696b;
                if (timeDownView.f8645c >= timeDownView.f8646d - 1) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    timeDownView.f8649h.sendMessage(obtain);
                    break;
                }
                break;
        }
    }
}
