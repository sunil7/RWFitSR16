package com.example.test.ui.mine.activity;

import com.example.test.utils.v0;

/* loaded from: classes.dex */
public final class c implements v0, a7.e, a7.f, a7.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8120a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AccountValidateActivity f8121b;

    public /* synthetic */ c(AccountValidateActivity accountValidateActivity, int i3) {
        this.f8120a = i3;
        this.f8121b = accountValidateActivity;
    }

    @Override // a7.e
    public void B() {
    }

    @Override // com.example.test.utils.v0
    public void a() {
        this.f8121b.G = true;
    }

    @Override // com.example.test.utils.v0
    public void b() {
        this.f8121b.G = false;
    }

    @Override // a7.c
    public void c(String str, boolean z5) {
        AccountValidateActivity accountValidateActivity = this.f8121b;
        switch (this.f8120a) {
            case 3:
                int i3 = AccountValidateActivity.I;
                Integer R0 = accountValidateActivity.R0();
                eh.b bVar = accountValidateActivity.f7247z;
                if (R0 != null && R0.intValue() == 3) {
                    ((f6.c) bVar.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar.getValue()).e.getText().length() > 0 && ((f6.c) bVar.getValue()).f12748d.getText().length() > 0);
                } else {
                    ((f6.c) bVar.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar.getValue()).f12753j.getText().length() > 0 && ((f6.c) bVar.getValue()).e.getText().length() > 0 && ((f6.c) bVar.getValue()).f12748d.getText().length() > 0);
                }
                ((f6.c) bVar.getValue()).f12753j.setActionEnable(z5);
                break;
            case 4:
                int i10 = AccountValidateActivity.I;
                Integer R02 = accountValidateActivity.R0();
                if (R02 == null || R02.intValue() != 3) {
                    eh.b bVar2 = accountValidateActivity.f7247z;
                    ((f6.c) bVar2.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar2.getValue()).f12746b.getText().length() > 0 && ((f6.c) bVar2.getValue()).e.getText().length() > 0 && ((f6.c) bVar2.getValue()).f12748d.getText().length() > 0);
                    break;
                }
                break;
            case 5:
                int i11 = AccountValidateActivity.I;
                Integer R03 = accountValidateActivity.R0();
                eh.b bVar3 = accountValidateActivity.f7247z;
                if (R03 == null || R03.intValue() != 3) {
                    ((f6.c) bVar3.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar3.getValue()).f12746b.getText().length() > 0 && ((f6.c) bVar3.getValue()).f12753j.getText().length() > 0 && ((f6.c) bVar3.getValue()).f12748d.getText().length() > 0);
                    break;
                } else {
                    ((f6.c) bVar3.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar3.getValue()).f12746b.getText().length() > 0 && ((f6.c) bVar3.getValue()).f12748d.getText().length() > 0 && ((f6.c) bVar3.getValue()).f12749f.getText().length() > 0);
                    break;
                }
                break;
            case 6:
                int i12 = AccountValidateActivity.I;
                Integer R04 = accountValidateActivity.R0();
                eh.b bVar4 = accountValidateActivity.f7247z;
                if (R04 == null || R04.intValue() != 3) {
                    ((f6.c) bVar4.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar4.getValue()).f12746b.getText().length() > 0 && ((f6.c) bVar4.getValue()).e.getText().length() > 0 && ((f6.c) bVar4.getValue()).f12753j.getText().length() > 0);
                    break;
                } else {
                    ((f6.c) bVar4.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar4.getValue()).f12746b.getText().length() > 0 && ((f6.c) bVar4.getValue()).e.getText().length() > 0 && ((f6.c) bVar4.getValue()).f12749f.getText().length() > 0);
                    break;
                }
                break;
            default:
                int i13 = AccountValidateActivity.I;
                Integer R05 = accountValidateActivity.R0();
                eh.b bVar5 = accountValidateActivity.f7247z;
                if (R05 == null || R05.intValue() != 3) {
                    ((f6.c) bVar5.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar5.getValue()).f12746b.getText().length() > 0 && ((f6.c) bVar5.getValue()).e.getText().length() > 0 && ((f6.c) bVar5.getValue()).f12753j.getText().length() > 0);
                    break;
                } else {
                    ((f6.c) bVar5.getValue()).f12747c.setEnabled(z5 && ((f6.c) bVar5.getValue()).f12746b.getText().length() > 0 && ((f6.c) bVar5.getValue()).e.getText().length() > 0 && ((f6.c) bVar5.getValue()).f12749f.getText().length() > 0);
                    break;
                }
                break;
        }
    }

    @Override // a7.f
    public void j(int i3) {
        int i10 = AccountValidateActivity.I;
        AccountValidateActivity accountValidateActivity = this.f8121b;
        Integer R0 = accountValidateActivity.R0();
        eh.b bVar = accountValidateActivity.f7247z;
        if (R0 != null && R0.intValue() == 1) {
            ((com.example.test.presenter.mine.f) accountValidateActivity.I0()).l(0, ((f6.c) bVar.getValue()).f12746b.getText());
            return;
        }
        if (R0 != null && R0.intValue() == 2) {
            ((com.example.test.presenter.mine.f) accountValidateActivity.I0()).l(3, ((f6.c) bVar.getValue()).f12746b.getText());
            return;
        }
        if (R0 != null && R0.intValue() == 4) {
            ((com.example.test.presenter.mine.f) accountValidateActivity.I0()).l(1, ((f6.c) bVar.getValue()).f12746b.getText());
        } else if (R0 != null && R0.intValue() == 0) {
            ((com.example.test.presenter.mine.f) accountValidateActivity.I0()).l(0, ((f6.c) bVar.getValue()).f12746b.getText());
        }
    }

    @Override // a7.e
    public void u0() {
        this.f8121b.onBackPressed();
    }
}
