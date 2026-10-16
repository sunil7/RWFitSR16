package com.example.test.ui.mine.activity;

import android.text.Editable;
import com.example.blesdk.bean.function.BtNameBean;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import f6.o0;

/* loaded from: classes.dex */
public final class h implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputActivity f8130a;

    public h(InputActivity inputActivity) {
        this.f8130a = inputActivity;
    }

    @Override // a7.e
    public final void B() {
        Editable text;
        int i3 = InputActivity.H;
        InputActivity inputActivity = this.f8130a;
        Integer S0 = inputActivity.S0();
        eh.b bVar = inputActivity.f7247z;
        if (S0 == null || S0.intValue() != 3) {
            if (!kotlin.jvm.internal.e.a((String) inputActivity.F.getValue(), ((o0) bVar.getValue()).f13161b.getText().toString()) && (text = ((o0) bVar.getValue()).f13161b.getText()) != null && text.length() != 0) {
                yh.d.b().e(new EventBusBeans.TextEditEvent(((o0) bVar.getValue()).f13161b.getText().toString()));
            }
            inputActivity.finish();
            return;
        }
        if (((o0) bVar.getValue()).f13161b.getText().toString().length() > 0) {
            BtNameBean btNameBean = new BtNameBean();
            btNameBean.setBtName(((o0) bVar.getValue()).f13161b.getText().toString());
            btNameBean.setNameLen(((o0) bVar.getValue()).f13161b.getText().toString().length());
            com.example.test.presenter.mine.i iVar = (com.example.test.presenter.mine.i) inputActivity.I0();
            iVar.getClass();
            iVar.f7593b = btNameBean;
            ((XXBaseActivity) ((h7.e) iVar.f7255a)).V();
            if (!r5.b.k().f18054c) {
                x5.b.I0().F0((byte) 22);
                return;
            }
            x5.c b3 = x5.c.b();
            String btName = btNameBean.getBtName();
            kotlin.jvm.internal.e.e(btName, "getBtName(...)");
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getSetNameWCmdJL ".concat(btName));
            byte[] n4 = y5.b.n(btName);
            byte[] bArr = new byte[n4.length + 4];
            bArr[0] = 2;
            bArr[1] = 101;
            bArr[2] = 0;
            bArr[3] = (byte) n4.length;
            System.arraycopy(n4, 0, bArr, 4, n4.length <= 24 ? n4.length : 24);
            b3.g((byte) 22, bArr, new boolean[0]);
        }
    }

    @Override // a7.e
    public final void u0() {
        this.f8130a.onBackPressed();
    }
}
