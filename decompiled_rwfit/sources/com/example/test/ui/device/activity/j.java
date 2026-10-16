package com.example.test.ui.device.activity;

import com.example.test.R$string;

/* loaded from: classes.dex */
public final class j implements t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7867a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomDialActivity f7868b;

    public /* synthetic */ j(CustomDialActivity customDialActivity, int i3) {
        this.f7867a = i3;
        this.f7868b = customDialActivity;
    }

    @Override // t6.a
    public final void v(String data) {
        switch (this.f7867a) {
            case 0:
                kotlin.jvm.internal.e.f(data, "data");
                CustomDialActivity customDialActivity = this.f7868b;
                customDialActivity.T = false;
                int i3 = customDialActivity.Q;
                eh.b bVar = customDialActivity.f7247z;
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (!data.equals(customDialActivity.W0().get(0)) && data.equals(((f6.t) bVar.getValue()).f13331s.getText())) {
                            customDialActivity.w0(R$string.str_up_and_down_same_tips);
                            break;
                        } else {
                            if (data.equals(customDialActivity.W0().get(1))) {
                                ((f6.t) bVar.getValue()).f13329p.setText((CharSequence) customDialActivity.W0().get(1));
                                customDialActivity.T0().setTimeDownType(1);
                            } else if (data.equals(customDialActivity.W0().get(2))) {
                                ((f6.t) bVar.getValue()).f13329p.setText((CharSequence) customDialActivity.W0().get(2));
                                customDialActivity.T0().setTimeDownType(2);
                            } else if (data.equals(customDialActivity.W0().get(3))) {
                                ((f6.t) bVar.getValue()).f13329p.setText((CharSequence) customDialActivity.W0().get(3));
                                customDialActivity.T0().setTimeDownType(4);
                            } else if (data.equals(customDialActivity.W0().get(4))) {
                                ((f6.t) bVar.getValue()).f13329p.setText((CharSequence) customDialActivity.W0().get(4));
                                customDialActivity.T0().setTimeDownType(8);
                            } else {
                                ((f6.t) bVar.getValue()).f13329p.setText((CharSequence) customDialActivity.W0().get(0));
                                customDialActivity.T0().setTimeDownType(0);
                            }
                            ((f6.t) bVar.getValue()).f13321h.setTimeDownType(customDialActivity.T0().getTimeDownType());
                        }
                    }
                } else if (!data.equals(customDialActivity.W0().get(0)) && data.equals(((f6.t) bVar.getValue()).f13329p.getText())) {
                    customDialActivity.w0(R$string.str_up_and_down_same_tips);
                    break;
                } else {
                    if (data.equals(customDialActivity.W0().get(1))) {
                        ((f6.t) bVar.getValue()).f13331s.setText((CharSequence) customDialActivity.W0().get(1));
                        customDialActivity.T0().setTimeUpType(1);
                    } else if (data.equals(customDialActivity.W0().get(2))) {
                        ((f6.t) bVar.getValue()).f13331s.setText((CharSequence) customDialActivity.W0().get(2));
                        customDialActivity.T0().setTimeUpType(2);
                    } else if (data.equals(customDialActivity.W0().get(3))) {
                        ((f6.t) bVar.getValue()).f13331s.setText((CharSequence) customDialActivity.W0().get(3));
                        customDialActivity.T0().setTimeUpType(4);
                    } else if (data.equals(customDialActivity.W0().get(4))) {
                        ((f6.t) bVar.getValue()).f13331s.setText((CharSequence) customDialActivity.W0().get(4));
                        customDialActivity.T0().setTimeUpType(8);
                    } else {
                        ((f6.t) bVar.getValue()).f13331s.setText((CharSequence) customDialActivity.W0().get(0));
                        customDialActivity.T0().setTimeUpType(0);
                    }
                    ((f6.t) bVar.getValue()).f13321h.setTimeUpType(customDialActivity.T0().getTimeUpType());
                }
                customDialActivity.Q = 0;
                break;
            default:
                kotlin.jvm.internal.e.f(data, "data");
                CustomDialActivity customDialActivity2 = this.f7868b;
                int i10 = 0;
                customDialActivity2.T = false;
                if (data.length() != 0 && !data.equals(customDialActivity2.X0().get(0))) {
                    i10 = 1;
                }
                customDialActivity2.b1(i10);
                break;
        }
    }
}
