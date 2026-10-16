package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.Classify;
import com.amap.api.services.auto.ListData;
import com.amap.api.services.auto.Lqii;
import com.amap.api.services.auto.Meta;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d6 {

    /* renamed from: a, reason: collision with root package name */
    static zb f3898a;

    public static void a(Context context, String str, long j4, boolean z5) {
        try {
            String a3 = a(str, j4, z5);
            if (a3 != null && a3.length() >= 1) {
                if (f3898a == null) {
                    f3898a = new zb(context, "sea", "9.7.4", "O002");
                }
                f3898a.a(a3);
                ac.a(f3898a, context);
            }
        } catch (Throwable th2) {
            a(th2, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static AutoTChargeStationResult b(JSONObject jSONObject) {
        Meta meta;
        AutoTChargeStationResult autoTChargeStationResult = new AutoTChargeStationResult();
        try {
            autoTChargeStationResult.code = jSONObject.optInt("code");
            autoTChargeStationResult.message = jSONObject.optString("message");
            JSONObject optJSONObject = jSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME);
            if (optJSONObject != null) {
                autoTChargeStationResult.classify = a(optJSONObject.optJSONObject("classify"));
                autoTChargeStationResult.listData = c(optJSONObject.optJSONObject("list_data"));
                autoTChargeStationResult.lqii = d(optJSONObject.optJSONObject("lqii"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("meta");
                if (optJSONObject2 == null) {
                    meta = null;
                } else {
                    Meta meta2 = new Meta();
                    meta2.listBizType = optJSONObject2.optString("list_biz_type");
                    meta = meta2;
                }
                autoTChargeStationResult.meta = meta;
                autoTChargeStationResult.originJson = optJSONObject.toString();
                return autoTChargeStationResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoTChargeStationResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ListData c(JSONObject jSONObject) {
        JSONArray jSONArray;
        ListData listData;
        int i3;
        ListData.BasicInfo basicInfo;
        JSONArray jSONArray2;
        int i10;
        int i11;
        ListData listData2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        int i12;
        ListData.PriceChargingPark priceChargingPark;
        JSONArray jSONArray5;
        int i13;
        int i14;
        JSONArray jSONArray6;
        ListData.ChargingInfo chargingInfo;
        ListData.BasicInfo basicInfo2 = null;
        if (jSONObject == null) {
            return null;
        }
        ListData listData3 = new ListData();
        JSONArray optJSONArray = jSONObject.optJSONArray("content");
        ArrayList arrayList = new ArrayList();
        int i15 = 0;
        while (i15 < optJSONArray.length()) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i15);
            if (optJSONObject == null) {
                jSONArray = optJSONArray;
                listData = listData3;
                i3 = i15;
            } else {
                ListData.Content content = new ListData.Content();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME);
                if (optJSONObject2 != null) {
                    ListData.Data data = new ListData.Data();
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("basic_info");
                    if (optJSONObject3 == null) {
                        basicInfo = basicInfo2;
                    } else {
                        basicInfo = new ListData.BasicInfo();
                        basicInfo.adcode = optJSONObject3.optString(Const.JSON_KEY_ADCODE);
                        basicInfo.address = optJSONObject3.optString(Const.JSON_KEY_ADDRESS);
                        basicInfo.averagecost = optJSONObject3.optString("averagecost");
                        basicInfo.buildingStatus = optJSONObject3.optString("building_status");
                        basicInfo.businessArea = optJSONObject3.optString("business_area");
                        basicInfo.childShortname = optJSONObject3.optString("child_shortname");
                        basicInfo.childShortnameEn = optJSONObject3.optString("child_shortname_en");
                        basicInfo.childtype = optJSONObject3.optString("childtype");
                        basicInfo.citycode = optJSONObject3.optString(Const.JSON_KEY_CITYCODE);
                        basicInfo.cname = optJSONObject3.optString("cname");
                        basicInfo.dispName = optJSONObject3.optString("disp_name");
                        basicInfo.distance = optJSONObject3.optString("distance");
                        basicInfo.dname = optJSONObject3.optString("dname");
                        basicInfo.eaddress = optJSONObject3.optString("eaddress");
                        basicInfo.endPoiExtension = optJSONObject3.optString("end_poi_extension");
                        basicInfo.fNona = optJSONObject3.optString("f_nona");
                        basicInfo.hisMark = optJSONObject3.optString("his_mark");
                        basicInfo.hotText = optJSONObject3.optString("hot_text");
                        basicInfo.f5857id = optJSONObject3.optString("id");
                        basicInfo.industry = optJSONObject3.optString("industry");
                        basicInfo.latitude = optJSONObject3.optString("latitude");
                        basicInfo.longitude = optJSONObject3.optString("longitude");
                        basicInfo.name = optJSONObject3.optString("name");
                        basicInfo.category = optJSONObject3.optString("category");
                        ListData.NaviVisited naviVisited = new ListData.NaviVisited();
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("navi_visited");
                        if (optJSONObject4 != null) {
                            naviVisited.randUnionMonthUv = optJSONObject4.optString("rand_union_month_uv");
                        }
                        basicInfo.naviVisited = naviVisited;
                        basicInfo.numSpaceW = optJSONObject3.optString("num_space_w");
                        basicInfo.numSpaceWF = optJSONObject3.optString("num_space_w_f");
                        basicInfo.opentime2 = optJSONObject3.optString("opentime2");
                        basicInfo.opentimeText = optJSONObject3.optString("opentime_text");
                        basicInfo.parent = optJSONObject3.optString("parent");
                        basicInfo.parentName = optJSONObject3.optString("parent_name");
                        basicInfo.picInfo = optJSONObject3.optString("pic_info");
                        basicInfo.rating = optJSONObject3.optString("rating");
                        basicInfo.recommendFlag = optJSONObject3.optString("recommend_flag");
                        basicInfo.reviewTotal = optJSONObject3.optString("review_total");
                        basicInfo.sell = optJSONObject3.optString("sell");
                        ListData.ShortReview shortReview = new ListData.ShortReview();
                        if (optJSONObject3.optJSONObject("short_review") != null) {
                            basicInfo.shortReview = shortReview;
                        }
                        basicInfo.tel = optJSONObject3.optString("tel");
                        basicInfo.towardsAngle = optJSONObject3.optString("towards_angle");
                        basicInfo.typeCode = optJSONObject3.optString("typecode");
                        basicInfo.updateFlag = optJSONObject3.optString("update_flag");
                        basicInfo.xEntr = optJSONObject3.optString("x_entr");
                        basicInfo.yEntr = optJSONObject3.optString("y_entr");
                    }
                    data.basicInfo = basicInfo;
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("charging_info");
                    if (optJSONObject5 == null) {
                        jSONArray = optJSONArray;
                        chargingInfo = basicInfo2;
                        listData = listData3;
                        i3 = i15;
                    } else {
                        ListData.ChargingInfo chargingInfo2 = new ListData.ChargingInfo();
                        chargingInfo2.brandDesc = optJSONObject5.optString("brand_desc");
                        JSONArray optJSONArray2 = optJSONObject5.optJSONArray("charge_info");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            int i16 = 0;
                            while (i16 < optJSONArray2.length()) {
                                JSONObject optJSONObject6 = optJSONArray2.optJSONObject(i16);
                                if (optJSONObject6 == null) {
                                    jSONArray2 = optJSONArray;
                                    i10 = i16;
                                } else {
                                    jSONArray2 = optJSONArray;
                                    ListData.ChargeInfo chargeInfo = new ListData.ChargeInfo();
                                    i10 = i16;
                                    JSONArray optJSONArray3 = optJSONObject6.optJSONArray("plugs_info");
                                    if (optJSONArray3 != null) {
                                        i11 = i15;
                                        ArrayList arrayList3 = new ArrayList();
                                        listData2 = listData3;
                                        jSONArray3 = optJSONArray2;
                                        int i17 = 0;
                                        while (i17 < optJSONArray3.length()) {
                                            JSONObject optJSONObject7 = optJSONArray3.optJSONObject(i17);
                                            if (optJSONObject7 == null) {
                                                jSONArray4 = optJSONArray3;
                                                i12 = i17;
                                            } else {
                                                jSONArray4 = optJSONArray3;
                                                ListData.PlugsInfo plugsInfo = new ListData.PlugsInfo();
                                                i12 = i17;
                                                plugsInfo.brandDesc = optJSONObject7.optString("brand_desc");
                                                plugsInfo.fastcur = optJSONObject7.optString("fastcur");
                                                plugsInfo.fastpower = optJSONObject7.optString("fastpower");
                                                plugsInfo.fastvol = optJSONObject7.optString("fastvol");
                                                arrayList3.add(plugsInfo);
                                            }
                                            i17 = i12 + 1;
                                            optJSONArray3 = jSONArray4;
                                        }
                                        chargeInfo.plugsInfos = arrayList3;
                                        chargeInfo.plugsType = optJSONObject6.optString("plugstype");
                                        arrayList2.add(chargeInfo);
                                        i16 = i10 + 1;
                                        optJSONArray = jSONArray2;
                                        i15 = i11;
                                        optJSONArray2 = jSONArray3;
                                        listData3 = listData2;
                                    }
                                }
                                listData2 = listData3;
                                i11 = i15;
                                jSONArray3 = optJSONArray2;
                                i16 = i10 + 1;
                                optJSONArray = jSONArray2;
                                i15 = i11;
                                optJSONArray2 = jSONArray3;
                                listData3 = listData2;
                            }
                        }
                        jSONArray = optJSONArray;
                        listData = listData3;
                        i3 = i15;
                        chargingInfo2.chargeInfo = arrayList2;
                        chargingInfo2.chargingRatingFlagTerm = optJSONObject5.optString("charging_rating_flag_term");
                        chargingInfo2.creditZhima = optJSONObject5.optString("credit_zhima");
                        chargingInfo2.cscf = optJSONObject5.optString("cscf");
                        chargingInfo2.currentElePrice = optJSONObject5.optString("current_ele_price");
                        chargingInfo2.currentSerPrice = optJSONObject5.optString("current_ser_price");
                        chargingInfo2.deepRightsTag = optJSONObject5.optString("deep_rights_tag");
                        chargingInfo2.latestCharge = optJSONObject5.optString("latest_charge");
                        chargingInfo2.numFast = optJSONObject5.optString("num_fast");
                        chargingInfo2.fastFree = optJSONObject5.optString("fast_free");
                        chargingInfo2.numSlow = optJSONObject5.optString("num_slow");
                        chargingInfo2.slowFree = optJSONObject5.optString("slow_free");
                        chargingInfo2.superTotal = optJSONObject5.optString("super_total");
                        chargingInfo2.superFree = optJSONObject5.optString("super_free");
                        chargingInfo2.parkCategory = optJSONObject5.optString("park_category");
                        chargingInfo2.parkingPriceSummary = optJSONObject5.optString("parkingPriceSummary");
                        JSONArray optJSONArray4 = optJSONObject5.optJSONArray("price_charging_pack");
                        if (optJSONArray4 == null) {
                            priceChargingPark = null;
                        } else {
                            priceChargingPark = new ListData.PriceChargingPark();
                            ArrayList arrayList4 = new ArrayList();
                            int i18 = 0;
                            while (i18 < optJSONArray4.length()) {
                                JSONObject optJSONObject8 = optJSONArray4.optJSONObject(i18);
                                if (optJSONObject8 == null) {
                                    jSONArray5 = optJSONArray4;
                                    i13 = i18;
                                } else {
                                    ListData.Park park = new ListData.Park();
                                    park.srcType = optJSONObject8.optString(Constants.JumpUrlConstants.URL_KEY_SRC);
                                    JSONArray optJSONArray5 = optJSONObject8.optJSONArray("price_charging");
                                    if (optJSONArray5 != null) {
                                        ArrayList arrayList5 = new ArrayList();
                                        jSONArray5 = optJSONArray4;
                                        int i19 = 0;
                                        while (i19 < optJSONArray5.length()) {
                                            JSONObject optJSONObject9 = optJSONArray5.optJSONObject(i19);
                                            if (optJSONObject9 == null) {
                                                i14 = i18;
                                                jSONArray6 = optJSONArray5;
                                            } else {
                                                i14 = i18;
                                                ListData.PriceCharging priceCharging = new ListData.PriceCharging();
                                                jSONArray6 = optJSONArray5;
                                                priceCharging.elePrice = optJSONObject9.optString("ele_price");
                                                priceCharging.serPrice = optJSONObject9.optString("ser_price");
                                                priceCharging.time = optJSONObject9.optString(Const.JSON_KEY_TIME);
                                                priceCharging.updatetime = optJSONObject9.optInt("updatetime");
                                                arrayList5.add(priceCharging);
                                            }
                                            i19++;
                                            i18 = i14;
                                            optJSONArray5 = jSONArray6;
                                        }
                                        i13 = i18;
                                        park.priceChargings = arrayList5;
                                    } else {
                                        jSONArray5 = optJSONArray4;
                                        i13 = i18;
                                    }
                                    arrayList4.add(park);
                                }
                                i18 = i13 + 1;
                                optJSONArray4 = jSONArray5;
                            }
                            priceChargingPark.parks = arrayList4;
                        }
                        chargingInfo2.priceChargingPark = priceChargingPark;
                        chargingInfo2.priceParkingStd = optJSONObject5.optString("price_parking_std");
                        JSONObject optJSONObject10 = optJSONObject5.optJSONObject("iddictionary");
                        chargingInfo = chargingInfo2;
                        if (optJSONObject10 != null) {
                            HashMap<String, String> hashMap = new HashMap<>();
                            Iterator<String> keys = optJSONObject10.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(next, optJSONObject10.optString(next));
                            }
                            chargingInfo2.idDictionary = hashMap;
                            chargingInfo = chargingInfo2;
                        }
                    }
                    data.chargingInfo = chargingInfo;
                    JSONArray optJSONArray6 = optJSONObject2.optJSONArray("labelInfos");
                    ArrayList arrayList6 = new ArrayList();
                    if (optJSONArray6 != null) {
                        for (int i20 = 0; i20 < optJSONArray6.length(); i20++) {
                            JSONObject optJSONObject11 = optJSONArray6.optJSONObject(i20);
                            if (optJSONObject11 != null) {
                                ListData.LabelInfo labelInfo = new ListData.LabelInfo();
                                labelInfo.content = optJSONObject11.optString("content");
                                labelInfo.type = optJSONObject11.optInt("type");
                                labelInfo.subType = optJSONObject11.optInt("subType");
                                arrayList6.add(labelInfo);
                            }
                        }
                    }
                    data.labelInfos = arrayList6;
                    content.data = data;
                } else {
                    jSONArray = optJSONArray;
                    listData = listData3;
                    i3 = i15;
                }
                content.itemType = optJSONObject.optString("item_type");
                arrayList.add(content);
            }
            i15 = i3 + 1;
            optJSONArray = jSONArray;
            listData3 = listData;
            basicInfo2 = null;
        }
        ListData listData4 = listData3;
        listData4.content = arrayList;
        return listData4;
    }

    public static void d(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has(FileDownloadModel.STATUS)) {
                String string = jSONObject.getString(FileDownloadModel.STATUS);
                if (string.equals("1")) {
                    return;
                }
                if (string.equals("0") && !jSONObject.has("infocode")) {
                    throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                }
                int i3 = jSONObject.getInt("infocode");
                if (string.equals("0")) {
                    a(i3, jSONObject.getString("info"));
                }
            }
        } catch (JSONException e) {
            throw e.b(e, "CoreUtil", "paseAuthFailurJson", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static void e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has(FileDownloadModel.STATUS)) {
                if (jSONObject.optInt(FileDownloadModel.STATUS) == 0) {
                    if (!jSONObject.has("infocode")) {
                        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                    }
                    a(jSONObject.getInt("infocode"), jSONObject.getString("info"));
                }
                int optInt = jSONObject.optInt("code");
                if (optInt == 0) {
                    return;
                }
                String optString = jSONObject.optString("message");
                throw new AMapException(optString, 2, optString, Integer.parseInt("1" + optInt));
            }
        } catch (JSONException e) {
            throw e.b(e, "CoreUtil", "paseAuthFailurJson", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static Classify a(JSONObject jSONObject) {
        Classify.ItermData itermData;
        Classify.CheckedValue checkedValue;
        Classify.RetainState retainState = null;
        if (jSONObject == null) {
            return null;
        }
        Classify classify = new Classify();
        JSONObject optJSONObject = jSONObject.optJSONObject("item_data");
        if (optJSONObject == null) {
            itermData = null;
        } else {
            itermData = new Classify.ItermData();
            JSONArray optJSONArray = optJSONObject.optJSONArray("checked_nodes");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                    if (optJSONObject2 != null) {
                        Classify.CheckedNode checkedNode = new Classify.CheckedNode();
                        checkedNode.f5856id = optJSONObject2.optString("id");
                        checkedNode.value = optJSONObject2.optString("value");
                        checkedNode.name = optJSONObject2.optString("name");
                        arrayList.add(checkedNode);
                    }
                }
            }
            itermData.checkedNodes = arrayList;
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("checked_value");
            if (optJSONObject3 == null) {
                checkedValue = null;
            } else {
                checkedValue = new Classify.CheckedValue();
                checkedValue.classifyV2Data = optJSONObject3.optString("classify_v2_data");
                checkedValue.classifyV2Level2Data = optJSONObject3.optString("classify_v2_level2_data");
                checkedValue.classifyV2Level3Data = optJSONObject3.optString("classify_v2_level3_data");
            }
            itermData.checkedValue = checkedValue;
            itermData.datas = a(optJSONObject.optJSONArray(AeUtil.ROOT_DATA_PATH_OLD_NAME));
            itermData.defaultPositionDatas = a(optJSONObject.optJSONArray("default_position_data"));
            itermData.level2Datas = a(optJSONObject.optJSONArray("level2_data"));
        }
        classify.itermData = itermData;
        JSONObject optJSONObject4 = jSONObject.optJSONObject("retain_state");
        if (optJSONObject4 != null) {
            retainState = new Classify.RetainState();
            retainState.classifyBusinessType = optJSONObject4.optString("classify_business_type");
            retainState.classifyConf = optJSONObject4.optString("classify_conf");
            retainState.classifyRetainLevel2 = optJSONObject4.optString("classify_retain_level2");
            retainState.level2All = optJSONObject4.optString("level2_all");
            retainState.newClassifyCityadcode = optJSONObject4.optString("new_classify_cityadcode");
            retainState.newClassifyFlag = optJSONObject4.optString("new_classify_flag");
        }
        classify.retainState = retainState;
        return classify;
    }

    public static Date b(String str) {
        if (str != null && !str.trim().equals("")) {
            try {
                return new SimpleDateFormat("HHmm").parse(str);
            } catch (ParseException e) {
                a(e, "CoreUtil", "parseString2Time");
            }
        }
        return null;
    }

    private static Lqii d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Lqii lqii = new Lqii();
        lqii.categoryBrandRecognitionResult = jSONObject.optString("category_brand_recognition_result");
        lqii.changeQueryTip = jSONObject.optString("change_query_tip");
        lqii.expandRangeTip = jSONObject.optString("change_query_tip");
        lqii.isCurrentCity = jSONObject.optString("is_current_city");
        lqii.isUserCity = jSONObject.optString("is_user_city");
        lqii.queryCateResult = jSONObject.optString("query_cate_result");
        lqii.suggestContent = jSONObject.optString("suggestcontent");
        lqii.targetViewCity = jSONObject.optString("target_view_city");
        lqii.totalhits = jSONObject.optString("totalhits");
        lqii.viewRegion = jSONObject.optString("view_region");
        return lqii;
    }

    private static String a(String str, long j4, boolean z5) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j4 + ",\"Success\":" + z5 + "}";
        } catch (Throwable th2) {
            a(th2, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static List<Classify.Data> a(JSONArray jSONArray) {
        int i3;
        ArrayList arrayList;
        int i10;
        String str;
        JSONArray jSONArray2;
        int i11;
        ArrayList arrayList2;
        JSONObject jSONObject;
        Classify.Data data;
        ArrayList arrayList3;
        JSONArray jSONArray3;
        int i12;
        JSONArray jSONArray4 = jSONArray;
        ArrayList arrayList4 = new ArrayList();
        if (jSONArray4 != null) {
            int i13 = 0;
            while (i13 < jSONArray4.length()) {
                JSONObject optJSONObject = jSONArray4.optJSONObject(i13);
                if (optJSONObject == null) {
                    arrayList = arrayList4;
                    i3 = i13;
                } else {
                    Classify.Data data2 = new Classify.Data();
                    String str2 = "category";
                    JSONArray optJSONArray = optJSONObject.optJSONArray("category");
                    ArrayList arrayList5 = new ArrayList();
                    if (optJSONArray != null) {
                        int i14 = 0;
                        while (i14 < optJSONArray.length()) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i14);
                            if (optJSONObject2 == null) {
                                arrayList2 = arrayList4;
                                i10 = i13;
                                jSONObject = optJSONObject;
                                data = data2;
                                str = str2;
                                jSONArray2 = optJSONArray;
                                arrayList3 = arrayList5;
                                i11 = i14;
                            } else {
                                Classify.DataCategory dataCategory = new Classify.DataCategory();
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray(str2);
                                i10 = i13;
                                ArrayList arrayList6 = new ArrayList();
                                str = str2;
                                jSONArray2 = optJSONArray;
                                i11 = i14;
                                arrayList2 = arrayList4;
                                jSONObject = optJSONObject;
                                data = data2;
                                ArrayList arrayList7 = arrayList5;
                                if (optJSONArray2 != null) {
                                    int i15 = 0;
                                    while (i15 < optJSONArray2.length()) {
                                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i15);
                                        if (optJSONObject3 == null) {
                                            jSONArray3 = optJSONArray2;
                                            i12 = i15;
                                        } else {
                                            jSONArray3 = optJSONArray2;
                                            Classify.Category category = new Classify.Category();
                                            i12 = i15;
                                            category.checked = optJSONObject3.optInt("checked");
                                            category.componentType = optJSONObject3.optString("component_type");
                                            category.defaultValue = optJSONObject3.optInt("default");
                                            category.name = optJSONObject3.optString("name");
                                            category.value = optJSONObject3.optString("value");
                                            category.classifyItemType = optJSONObject3.optString("classify_item_type");
                                            category.img = optJSONObject3.optString(SocialConstants.PARAM_IMG_URL);
                                            category.showType = optJSONObject3.optString("show_type");
                                            category.params = optJSONObject3.optString("params");
                                            arrayList6.add(category);
                                        }
                                        i15 = i12 + 1;
                                        optJSONArray2 = jSONArray3;
                                    }
                                }
                                dataCategory.categories = arrayList6;
                                dataCategory.checked = optJSONObject2.optInt("checked");
                                dataCategory.defaultValue = optJSONObject2.optInt("default");
                                dataCategory.componentType = optJSONObject2.optString("component_type");
                                dataCategory.name = optJSONObject2.optString("name");
                                dataCategory.params = optJSONObject2.optString("params");
                                dataCategory.areaSubwayMark = optJSONObject2.optInt("area_subway_mark");
                                dataCategory.hideTitle = optJSONObject2.optInt("hide_title");
                                dataCategory.maxShowNum = optJSONObject2.optInt("max_show_num");
                                dataCategory.maxShowNumRow = optJSONObject2.optInt("max_show_num_row");
                                dataCategory.multiSelect = optJSONObject2.optInt("multi_select");
                                dataCategory.img = optJSONObject2.optString(SocialConstants.PARAM_IMG_URL);
                                dataCategory.showType = optJSONObject2.optString("show_type");
                                dataCategory.value = optJSONObject2.optString("value");
                                dataCategory.classifyItemType = optJSONObject2.optString("classify_item_type");
                                arrayList3 = arrayList7;
                                arrayList3.add(dataCategory);
                            }
                            i14 = i11 + 1;
                            arrayList5 = arrayList3;
                            i13 = i10;
                            str2 = str;
                            optJSONArray = jSONArray2;
                            arrayList4 = arrayList2;
                            optJSONObject = jSONObject;
                            data2 = data;
                        }
                    }
                    ArrayList arrayList8 = arrayList4;
                    i3 = i13;
                    JSONObject jSONObject2 = optJSONObject;
                    Classify.Data data3 = data2;
                    data3.categories = arrayList5;
                    data3.checked = jSONObject2.optInt("checked");
                    data3.classifyItemType = jSONObject2.optString("classify_item_type");
                    data3.isCancelDefaultSelect = jSONObject2.optInt("is_cancel_default_select");
                    data3.isNoBtn = jSONObject2.optInt("is_no_btn");
                    data3.name = jSONObject2.optString("name");
                    data3.params = jSONObject2.optString("params");
                    data3.separator = jSONObject2.optString("separator");
                    data3.type = jSONObject2.optString("type");
                    data3.useCommonlyUsedConfig = jSONObject2.optInt("use_commonly_used_config");
                    data3.useLocalConfig = jSONObject2.optInt("use_local_config");
                    data3.useRemoteConfig = jSONObject2.optInt("use_remote_config");
                    data3.multiSelect = jSONObject2.optInt("multi_select");
                    arrayList = arrayList8;
                    arrayList.add(data3);
                }
                i13 = i3 + 1;
                arrayList4 = arrayList;
                jSONArray4 = jSONArray;
            }
        }
        return arrayList4;
    }

    public static void a(Context context, String str, boolean z5) {
        try {
            String a3 = a(str, z5);
            if (a3 != null && a3.length() >= 1) {
                zb zbVar = new zb(context, "sea", "9.7.4", "O006");
                zbVar.a(a3);
                ac.a(zbVar, context);
            }
        } catch (Throwable th2) {
            a(th2, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, boolean z5) {
        String str2;
        try {
            int indexOf = str.indexOf("?");
            int length = str.length();
            str2 = "";
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i3 = indexOf + 1;
                str2 = i3 < length ? str.substring(i3) : "";
                str = substring;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z5 + "}";
        } catch (Throwable th2) {
            a(th2, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    private static void a(int i3, String str) throws AMapException, JSONException {
        if (i3 != 0) {
            if (i3 == 22000) {
                throw new AMapException(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST, 2, str);
            }
            if (i3 == 32200) {
                throw new AMapException(AMapException.AMAP_NEARBY_INVALID_USERID, 2, str);
            }
            if (i3 != 32201) {
                switch (i3) {
                    case 10000:
                        return;
                    case 10001:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_KEY, 2, str);
                    case 10002:
                        throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE, 2, str);
                    case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /* 10003 */:
                        throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT, 2, str);
                    case 10004:
                        throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT, 2, str);
                    case 10005:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_IP, 2, str);
                    case 10006:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN, 2, str);
                    case 10007:
                        throw new AMapException("用户签名未通过", 2, str);
                    case 10008:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE, 2, str);
                    case 10009:
                        throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH, 2, str);
                    case 10010:
                        throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT, 2, str);
                    case 10011:
                        throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS, 2, str);
                    case 10012:
                        throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES, 2, str);
                    case 10013:
                        throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED, 2, str);
                    default:
                        switch (i3) {
                            case Const.I_CITY_TILE_LEN /* 20000 */:
                                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 2, str);
                            case 20001:
                                throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS, 2, str);
                            case 20002:
                                throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST, 2, str);
                            case 20003:
                                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 2, str);
                            default:
                                switch (i3) {
                                    case 20800:
                                        throw new AMapException(AMapException.AMAP_ROUTE_OUT_OF_SERVICE, 2, str);
                                    case 20801:
                                        throw new AMapException(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY, 2, str);
                                    case 20802:
                                        throw new AMapException(AMapException.AMAP_ROUTE_FAIL, 2, str);
                                    case 20803:
                                        throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE, 2, str);
                                    default:
                                        switch (i3) {
                                            case Const.I_LOC_JUMP_DELAY /* 30000 */:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR, 2, str);
                                            case 30001:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR, 2, str);
                                            case 30002:
                                                throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT, 2, str);
                                            case 30003:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT, 2, str);
                                            default:
                                                switch (i3) {
                                                    case 32000:
                                                        throw new AMapException(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST, 2, str);
                                                    case 32001:
                                                        throw new AMapException(AMapException.AMAP_ID_NOT_EXIST, 2, str);
                                                    case 32002:
                                                        throw new AMapException(AMapException.AMAP_SERVICE_MAINTENANCE, 2, str);
                                                    default:
                                                        if (!TextUtils.isEmpty(str) && i3 > 0) {
                                                            throw new AMapException(str, 2, str, i3);
                                                        }
                                                        throw new AMapException(str, 2, str);
                                                }
                                        }
                                }
                        }
                }
            }
            throw new AMapException(AMapException.AMAP_NEARBY_KEY_NOT_BIND, 2, str);
        }
    }

    public static Date c(String str) {
        if (str != null && !str.trim().equals("")) {
            try {
                return new SimpleDateFormat("HH:mm").parse(str);
            } catch (ParseException e) {
                a(e, "CoreUtil", "parseTime");
            }
        }
        return null;
    }

    public static double a(double d5) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d5));
    }

    public static String a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        return a(latLonPoint.getLongitude()) + Const.STR_MART_COMMA + a(latLonPoint.getLatitude());
    }

    public static String a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static String a(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < list.size(); i3++) {
            LatLonPoint latLonPoint = list.get(i3);
            if (latLonPoint != null) {
                double a3 = a(latLonPoint.getLongitude());
                double a10 = a(latLonPoint.getLatitude());
                stringBuffer.append(a3);
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(a10);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static void a(Throwable th2, String str, String str2) {
        try {
            ka a3 = ka.a();
            if (a3 != null) {
                a3.b(th2, str, str2);
            }
            th2.printStackTrace();
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static float a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint != null && latLonPoint2 != null) {
            try {
                double longitude = latLonPoint.getLongitude();
                double d5 = longitude * 0.01745329251994329d;
                double latitude = latLonPoint.getLatitude() * 0.01745329251994329d;
                double longitude2 = latLonPoint2.getLongitude() * 0.01745329251994329d;
                double latitude2 = latLonPoint2.getLatitude() * 0.01745329251994329d;
                double sin = Math.sin(d5);
                double sin2 = Math.sin(latitude);
                double cos = Math.cos(d5);
                double cos2 = Math.cos(latitude);
                double sin3 = Math.sin(longitude2);
                double sin4 = Math.sin(latitude2);
                double cos3 = Math.cos(longitude2);
                double cos4 = Math.cos(latitude2);
                double[] dArr = {cos * cos2, cos2 * sin, sin2};
                double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
                double d8 = dArr[0];
                double d10 = dArr2[0];
                double d11 = (d8 - d10) * (d8 - d10);
                double d12 = dArr[1];
                double d13 = dArr2[1];
                double d14 = ((d12 - d13) * (d12 - d13)) + d11;
                double d15 = dArr[2];
                double d16 = dArr2[2];
                return (float) (Math.asin(Math.sqrt(((d15 - d16) * (d15 - d16)) + d14) / 2.0d) * 1.27420015798544E7d);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return 0.0f;
    }

    public static String a(int i3) {
        StringBuilder sb2 = new StringBuilder();
        if ((i3 & 1) != 0) {
            sb2.append("cost,");
        }
        if ((i3 & 2) != 0) {
            sb2.append("tmcs,");
        }
        if ((i3 & 4) != 0) {
            sb2.append("navi,");
        }
        if ((i3 & 8) != 0) {
            sb2.append("cities,");
        }
        if ((i3 & 16) != 0) {
            sb2.append("polyline,");
        }
        if ((i3 & 32) != 0) {
            sb2.append("elec_consume_info,");
        }
        if ((i3 & 64) != 0) {
            sb2.append("charge_station_info,");
        }
        sb2.replace(sb2.length() - 1, sb2.length(), "");
        return sb2.toString();
    }
}
