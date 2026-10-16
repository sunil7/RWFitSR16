package com.example.test.ui.testui;

import androidx.appcompat.widget.SwitchCompat;
import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.test.presenter.main.u1;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class s0 implements a7.e, t6.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingSleepModeActivity f8311a;

    public /* synthetic */ s0(TRingSleepModeActivity tRingSleepModeActivity) {
        this.f8311a = tRingSleepModeActivity;
    }

    @Override // a7.e
    public void B() {
        int i3 = TRingSleepModeActivity.J;
        TRingSleepModeActivity tRingSleepModeActivity = this.f8311a;
        BrightScreenTimeBean S0 = tRingSleepModeActivity.S0();
        SwitchCompat switchCompat = tRingSleepModeActivity.F;
        S0.setOpen(switchCompat != null ? switchCompat.isChecked() : false);
        u1 u1Var = (u1) tRingSleepModeActivity.I0();
        BrightScreenTimeBean data = tRingSleepModeActivity.S0();
        u1Var.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        u1Var.f7573b = data;
        ((XXBaseActivity) ((g7.a0) u1Var.f7255a)).V();
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -21);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getRingSleepModeWCmd " + data.getTimeSecond());
        byte isOpen = data.isOpen();
        int startHour = data.getStartHour();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -21, new byte[]{2, 8, 0, 10, -1, -1, isOpen, (byte) (startHour & 255), (byte) (data.getStartMin() & 255), (byte) (data.getEndHour() & 255), (byte) (data.getEndMin() & 255)}, new boolean[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r5 == 12) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        if (r5 == 12) goto L25;
     */
    @Override // t6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(int r7, int r8, int r9) {
        /*
            r6 = this;
            com.example.test.ui.testui.TRingSleepModeActivity r0 = r6.f8311a
            boolean r1 = r0.G
            r2 = 1
            r3 = 0
            r4 = 12
            if (r1 == 0) goto L3b
            boolean r1 = android.text.format.DateFormat.is24HourFormat(r0)
            if (r1 == 0) goto L1f
            com.example.blesdk.bean.function.BrightScreenTimeBean r7 = r0.S0()
            r7.setStartHour(r8)
            com.example.blesdk.bean.function.BrightScreenTimeBean r7 = r0.S0()
            r7.setStartMin(r9)
            goto L6b
        L1f:
            com.example.blesdk.bean.function.BrightScreenTimeBean r1 = r0.S0()
            int r5 = r8 + 1
            if (r7 != r2) goto L2c
            if (r5 >= r4) goto L2f
            int r3 = r8 + 13
            goto L30
        L2c:
            if (r5 != r4) goto L2f
            goto L30
        L2f:
            r3 = r5
        L30:
            r1.setStartHour(r3)
            com.example.blesdk.bean.function.BrightScreenTimeBean r7 = r0.S0()
            r7.setStartMin(r9)
            goto L6b
        L3b:
            boolean r1 = android.text.format.DateFormat.is24HourFormat(r0)
            if (r1 == 0) goto L50
            com.example.blesdk.bean.function.BrightScreenTimeBean r7 = r0.S0()
            r7.setEndHour(r8)
            com.example.blesdk.bean.function.BrightScreenTimeBean r7 = r0.S0()
            r7.setEndMin(r9)
            goto L6b
        L50:
            com.example.blesdk.bean.function.BrightScreenTimeBean r1 = r0.S0()
            int r5 = r8 + 1
            if (r7 != r2) goto L5d
            if (r5 >= r4) goto L60
            int r3 = r8 + 13
            goto L61
        L5d:
            if (r5 != r4) goto L60
            goto L61
        L60:
            r3 = r5
        L61:
            r1.setEndHour(r3)
            com.example.blesdk.bean.function.BrightScreenTimeBean r7 = r0.S0()
            r7.setEndMin(r9)
        L6b:
            r0.R0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.s0.h(int, int, int):void");
    }

    @Override // a7.e
    public void u0() {
        this.f8311a.onBackPressed();
    }

    @Override // t6.d
    public void y() {
        this.f8311a.G = false;
    }
}
