package com.example.test.ui.main.model;

import com.example.test.ui.testui.b;
import com.example.test.utils.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class HomeEditCardModel extends BaseDataModel {
    public static final int bo = 6;
    public static final int bp = 11;
    public static final int hr = 2;
    public static final int hrv = 5;
    public static final int muslin = 10;
    public static final int pCycle = 9;
    public static final int sleep = 3;
    public static final int sport = 4;
    public static final int step = 1;
    public static final int stress = 7;
    public static final int sugar = 8;
    private HomeBoModel mHomeBoModel;
    private HomeBpModel mHomeBpModel;
    private HomeHrModel mHomeHrModel;
    private HomeHrvModel mHomeHrvModel;
    private HomeMuslinModel mHomeMuslinModel;
    private PhysiologicalCycleModel mHomePCycleModel;
    private HomeSleepModel mHomeSleepModel;
    private HomeSportModel mHomeSportModel;
    private HomeStepModel mHomeStepModel;
    private HomeBSModel mHomeStressModel;
    private HomeSugarModel mHomeSugarModel;

    public HomeEditCardModel() {
        super(14);
    }

    public List<BaseDataModel> getDealList(boolean z5) {
        BaseDataModel objectByType;
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        if (kVar == null) {
            return new ArrayList();
        }
        if (kVar == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        ArrayList p8 = k.f8731b.p();
        if (p8 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = p8.size();
        boolean z6 = false;
        int i3 = 0;
        while (i3 < size) {
            Object obj = p8.get(i3);
            i3++;
            b bVar = (b) obj;
            if (bVar != null) {
                int i10 = bVar.f8259a;
                if (i10 == 9) {
                    z6 = true;
                }
                if (bVar.f8261c != 0 && (objectByType = getObjectByType(i10)) != null) {
                    arrayList.add(objectByType);
                }
            }
        }
        if (z5 && !z6) {
            arrayList.add(this.mHomePCycleModel);
        }
        return arrayList;
    }

    public BaseDataModel getObjectByType(int i3) {
        if (i3 == 1) {
            return this.mHomeStepModel;
        }
        if (i3 == 2) {
            return this.mHomeHrModel;
        }
        if (i3 == 3) {
            return this.mHomeSleepModel;
        }
        if (i3 == 4) {
            return this.mHomeSportModel;
        }
        if (i3 == 5) {
            return this.mHomeHrvModel;
        }
        if (i3 == 6) {
            return this.mHomeBoModel;
        }
        if (i3 == 7) {
            return this.mHomeStressModel;
        }
        if (i3 == 8) {
            return this.mHomeSugarModel;
        }
        if (i3 == 9) {
            return this.mHomePCycleModel;
        }
        if (i3 == 10) {
            return this.mHomeMuslinModel;
        }
        if (i3 == 11) {
            return this.mHomeBpModel;
        }
        return null;
    }

    public HomeEditCardModel(HomeStepModel homeStepModel, HomeHrModel homeHrModel, HomeSleepModel homeSleepModel, HomeSportModel homeSportModel, HomeHrvModel homeHrvModel, HomeBoModel homeBoModel, HomeBSModel homeBSModel, HomeSugarModel homeSugarModel, HomeBpModel homeBpModel, PhysiologicalCycleModel physiologicalCycleModel, HomeMuslinModel homeMuslinModel) {
        this.mHomeStepModel = homeStepModel;
        this.mHomeHrModel = homeHrModel;
        this.mHomeSleepModel = homeSleepModel;
        this.mHomeSportModel = homeSportModel;
        this.mHomeHrvModel = homeHrvModel;
        this.mHomeBoModel = homeBoModel;
        this.mHomeStressModel = homeBSModel;
        this.mHomeSugarModel = homeSugarModel;
        this.mHomePCycleModel = physiologicalCycleModel;
        this.mHomeMuslinModel = homeMuslinModel;
        this.mHomeBpModel = homeBpModel;
    }
}
