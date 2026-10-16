package com.example.test.service;

import android.app.Activity;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BloodSugarImpl;
import com.example.database.db.BodyTempImpl;
import com.example.database.db.BreatheImpl;
import com.example.database.db.HrImpl;
import com.example.database.db.HrvImpl;
import com.example.database.db.MuslimCountImpl;
import com.example.database.db.PressureImpl;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.SleepImpl;
import com.example.database.db.SportImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataBloodOxygen;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.DataBodyTemp;
import com.example.database.table.DataBreathe;
import com.example.database.table.DataHeartHrv;
import com.example.database.table.DataHeartRate;
import com.example.database.table.DataMuslimCount;
import com.example.database.table.DataPressure;
import com.example.database.table.DataSleep;
import com.example.database.table.DataSport;
import com.example.database.table.DataStep;
import com.example.database.table.RawDataStep;
import com.example.network.base.HttpModel;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f1 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7702d;
    public final /* synthetic */ g1 e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f7703f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f1(g1 g1Var, List list, Activity activity, com.example.test.utils.w0 w0Var, int i3) {
        super(activity, w0Var);
        this.f7702d = i3;
        this.e = g1Var;
        this.f7703f = list;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7702d) {
            case 0:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBos onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 1:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBps onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 2:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBreathe onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 3:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBt onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 4:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 5:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 6:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadSteps onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 7:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 8:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 9:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadSleeps onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 10:
                g1 g1Var = this.e;
                g1Var.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadSports onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                g1Var.n();
                break;
            case 11:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadSteps onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            default:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7702d) {
            case 0:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBos onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataBloodOxygen> list = this.f7703f;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((DataBloodOxygen) it.next()).setIsUpdate(true);
                }
                BloodOxygenImpl.INSTANCE.saveDatas(list);
                break;
            case 1:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBps onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataBloodPress> list2 = this.f7703f;
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    ((DataBloodPress) it2.next()).setIsUpdate(true);
                }
                BloodPressImpl.INSTANCE.saveDatas(list2);
                break;
            case 2:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBreathe onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataBreathe> list3 = this.f7703f;
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    ((DataBreathe) it3.next()).setIsUpdate(true);
                }
                BreatheImpl.INSTANCE.saveDatas(list3);
                break;
            case 3:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadBt onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataBodyTemp> list4 = this.f7703f;
                Iterator it4 = list4.iterator();
                while (it4.hasNext()) {
                    ((DataBodyTemp) it4.next()).setIsUpdate(true);
                }
                BodyTempImpl.INSTANCE.saveDatas(list4);
                break;
            case 4:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataHeartRate> list5 = this.f7703f;
                Iterator it5 = list5.iterator();
                while (it5.hasNext()) {
                    ((DataHeartRate) it5.next()).setIsUpdate(true);
                }
                HrImpl.INSTANCE.saveDatas(list5);
                break;
            case 5:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataHeartHrv> list6 = this.f7703f;
                Iterator it6 = list6.iterator();
                while (it6.hasNext()) {
                    ((DataHeartHrv) it6.next()).setIsUpdate(true);
                }
                HrvImpl.INSTANCE.saveDatas(list6);
                break;
            case 6:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "uploadSteps onSuccess ->");
                List<? extends RawDataStep> list7 = this.f7703f;
                Iterator it7 = list7.iterator();
                while (it7.hasNext()) {
                    ((RawDataStep) it7.next()).setIsUpdate(true);
                }
                RawStepsImpl.INSTANCE.saveSteps(list7);
                break;
            case 7:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataPressure> list8 = this.f7703f;
                Iterator it8 = list8.iterator();
                while (it8.hasNext()) {
                    ((DataPressure) it8.next()).setIsUpdate(true);
                }
                PressureImpl.INSTANCE.saveDatas(list8);
                break;
            case 8:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataMuslimCount> list9 = this.f7703f;
                Iterator it9 = list9.iterator();
                while (it9.hasNext()) {
                    ((DataMuslimCount) it9.next()).setIsUpdate(true);
                }
                MuslimCountImpl.INSTANCE.saveDatas(list9);
                break;
            case 9:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadSleeps onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataSleep> list10 = this.f7703f;
                Iterator it10 = list10.iterator();
                while (it10.hasNext()) {
                    ((DataSleep) it10.next()).setIsUpdate(true);
                }
                SleepImpl.INSTANCE.saveDatas(list10);
                break;
            case 10:
                g1 g1Var = this.e;
                g1Var.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadSports onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataSport> list11 = this.f7703f;
                Iterator it11 = list11.iterator();
                while (it11.hasNext()) {
                    ((DataSport) it11.next()).setIsUpdate(true);
                }
                SportImpl.INSTANCE.saveDatas(list11);
                g1Var.n();
                break;
            case 11:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", "uploadSteps onSuccess ->");
                List<? extends DataStep> list12 = this.f7703f;
                Iterator it12 = list12.iterator();
                while (it12.hasNext()) {
                    ((DataStep) it12.next()).setIsUpdate(true);
                }
                StepsImpl.INSTANCE.saveSteps(list12);
                break;
            default:
                this.e.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncServerService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("uploadHrs onSuccess ->", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                List<? extends DataBloodSugar> list13 = this.f7703f;
                Iterator it13 = list13.iterator();
                while (it13.hasNext()) {
                    ((DataBloodSugar) it13.next()).setIsUpdate(true);
                }
                BloodSugarImpl.INSTANCE.saveDatas(list13);
                break;
        }
    }
}
