package com.example.test.presenter.sport;

import com.example.blesdk.bean.sync.ImperialPaceItemBean;
import com.example.blesdk.bean.sync.MetricPaceItemBean;
import com.example.test.ui.sport.activity.SportNewRecordDetailActivity;
import java.util.List;

/* loaded from: classes.dex */
public final class o extends com.example.baselibrary.preseneter.b {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7621b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7622c;

    public o(SportNewRecordDetailActivity sportNewRecordDetailActivity) {
        super(sportNewRecordDetailActivity);
        this.f7621b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportNewRecordDetailPresenter$exchangeSportDataCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final m invoke() {
                return new m(o.this);
            }
        });
        this.f7622c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportNewRecordDetailPresenter$fileTransferCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final n invoke() {
                return new n(o.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d((m) this.f7621b.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.e((n) this.f7622c.getValue());
    }

    public final void k(long j4) {
        com.example.baselibrary.preseneter.b.j(Long.valueOf(j4), new oh.l() { // from class: com.example.test.presenter.sport.SportNewRecordDetailPresenter$getSportData$1

            public static final class a extends bc.a<List<? extends h6.a>> {
            }

            public static final class b extends bc.a<List<? extends Long>> {
            }

            public static final class c extends bc.a<List<? extends ImperialPaceItemBean>> {
            }

            public static final class d extends bc.a<List<? extends MetricPaceItemBean>> {
            }

            /* JADX WARN: Removed duplicated region for block: B:136:0x03fb  */
            /* JADX WARN: Removed duplicated region for block: B:173:0x028a  */
            /* JADX WARN: Removed duplicated region for block: B:215:0x033d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final h6.b invoke(long r11) {
                /*
                    Method dump skipped, instructions count: 1247
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.sport.SportNewRecordDetailPresenter$getSportData$1.invoke(long):h6.b");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).longValue());
            }
        }, new oh.l() { // from class: com.example.test.presenter.sport.SportNewRecordDetailPresenter$getSportData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((h6.b) obj);
                return eh.g.f12633a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:105:0x04b0  */
            /* JADX WARN: Removed duplicated region for block: B:107:0x04b7  */
            /* JADX WARN: Removed duplicated region for block: B:110:0x04cc  */
            /* JADX WARN: Removed duplicated region for block: B:112:0x04d6  */
            /* JADX WARN: Removed duplicated region for block: B:114:0x04b3  */
            /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
            /* JADX WARN: Type inference failed for: r1v109 */
            /* JADX WARN: Type inference failed for: r1v20, types: [com.example.blesdk.bean.function.ExchangeSportDataBean] */
            /* JADX WARN: Type inference failed for: r1v40 */
            /* JADX WARN: Type inference failed for: r1v41, types: [android.view.View] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(h6.b r19) {
                /*
                    Method dump skipped, instructions count: 1480
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.sport.SportNewRecordDetailPresenter$getSportData$2.invoke(h6.b):void");
            }
        });
    }
}
