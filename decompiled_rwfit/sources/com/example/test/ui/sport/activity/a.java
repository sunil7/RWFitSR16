package com.example.test.ui.sport.activity;

import android.content.Intent;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8158a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportCountDownActivity f8159b;

    public /* synthetic */ a(SportCountDownActivity sportCountDownActivity, int i3) {
        this.f8158a = i3;
        this.f8159b = sportCountDownActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SportCountDownActivity this$0 = this.f8159b;
        switch (this.f8158a) {
            case 0:
                int i3 = SportCountDownActivity.I;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (y5.d.f20005b) {
                    int S0 = this$0.S0();
                    Intent intent = new Intent(this$0, (Class<?>) SportDetailJLActivity.class);
                    intent.putExtra("sport_type", S0);
                    this$0.startActivity(intent);
                } else {
                    int S02 = this$0.S0();
                    Intent intent2 = new Intent(this$0, (Class<?>) SportDetailActivity.class);
                    intent2.putExtra("sport_type", S02);
                    this$0.startActivity(intent2);
                }
                this$0.finish();
                break;
            default:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (y5.d.f20005b) {
                    int i10 = SportDetailJLActivity.M;
                    int i11 = SportCountDownActivity.I;
                    int S03 = this$0.S0();
                    Intent intent3 = new Intent(this$0, (Class<?>) SportDetailJLActivity.class);
                    intent3.putExtra("sport_type", S03);
                    this$0.startActivity(intent3);
                } else {
                    int i12 = SportDetailActivity.M;
                    int i13 = SportCountDownActivity.I;
                    int S04 = this$0.S0();
                    Intent intent4 = new Intent(this$0, (Class<?>) SportDetailActivity.class);
                    intent4.putExtra("sport_type", S04);
                    this$0.startActivity(intent4);
                }
                this$0.finish();
                break;
        }
    }
}
