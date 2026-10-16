package com.example.test.presenter.sport;

import com.example.blesdk.bean.sync.ImperialPaceItemBean;
import com.example.blesdk.bean.sync.MetricPaceItemBean;
import com.example.blesdk.bean.sync.SportHrItemBean;
import com.example.test.ui.sport.activity.SportRecordDetailActivity;
import java.util.List;

/* loaded from: classes.dex */
public final class u extends com.example.baselibrary.preseneter.b {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7632b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7633c;

    public u(SportRecordDetailActivity sportRecordDetailActivity) {
        super(sportRecordDetailActivity);
        this.f7632b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportRecordDetailPresenter$exchangeSportDataCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final s invoke() {
                return new s(u.this);
            }
        });
        this.f7633c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportRecordDetailPresenter$fileTransferCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final t invoke() {
                return new t(u.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d((s) this.f7632b.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.e((t) this.f7633c.getValue());
    }

    public final void k(long j4) {
        com.example.baselibrary.preseneter.b.j(Long.valueOf(j4), new oh.l() { // from class: com.example.test.presenter.sport.SportRecordDetailPresenter$getSportData$1

            public static final class a extends bc.a<List<? extends h6.a>> {
            }

            public static final class b extends bc.a<List<? extends Long>> {
            }

            public static final class c extends bc.a<List<? extends SportHrItemBean>> {
            }

            public static final class d extends bc.a<List<? extends ImperialPaceItemBean>> {
            }

            public static final class e extends bc.a<List<? extends MetricPaceItemBean>> {
            }

            /* JADX WARN: Removed duplicated region for block: B:132:0x03fb  */
            /* JADX WARN: Removed duplicated region for block: B:170:0x028a  */
            /* JADX WARN: Removed duplicated region for block: B:212:0x033d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final h6.b invoke(long r11) {
                /*
                    Method dump skipped, instructions count: 1180
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.sport.SportRecordDetailPresenter$getSportData$1.invoke(long):h6.b");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).longValue());
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportRecordDetailPresenter$getSportData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((h6.b) obj);
                return eh.g.f12633a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:124:0x03e9  */
            /* JADX WARN: Removed duplicated region for block: B:125:0x0347  */
            /* JADX WARN: Removed duplicated region for block: B:131:0x0240  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x01ce  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x023c  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x031e  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x03cd  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x03e0  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(h6.b r22) {
                /*
                    Method dump skipped, instructions count: 2272
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.sport.SportRecordDetailPresenter$getSportData$2.invoke(h6.b):void");
            }
        });
    }
}
