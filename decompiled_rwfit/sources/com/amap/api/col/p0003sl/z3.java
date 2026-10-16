package com.amap.api.col.p0003sl;

import android.graphics.Color;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.ae.gmap.style.StyleElement;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.Convert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z3 {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f5539d = {1};

    /* renamed from: a, reason: collision with root package name */
    private int f5540a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f5541b = -1;

    /* renamed from: c, reason: collision with root package name */
    List<v3> f5542c = null;

    private List<v3> b() {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        int i3;
        int i10;
        JSONObject optJSONObject;
        int i11;
        String str;
        String str2;
        int i12;
        String str3;
        String str4;
        JSONObject jSONObject2;
        JSONArray jSONArray4;
        String str5 = "name";
        this.f5542c = new ArrayList();
        try {
            jSONArray = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return this.f5542c;
        }
        int i13 = 0;
        JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
        if (optJSONObject2 == null) {
            return this.f5542c;
        }
        JSONArray names = optJSONObject2.names();
        int length = names.length();
        int i14 = 0;
        while (i14 < length) {
            String optString = names.optString(i14);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString);
            if (optJSONObject3 != null) {
                String optString2 = optJSONObject3.optString(str5);
                if (optJSONObject3.has("styleMap")) {
                    a(optJSONObject3.optJSONArray("styleMap"), optString, (String) null, optString2, this.f5542c);
                } else if (optJSONObject3.has("subType")) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("subType");
                    if (optJSONObject4 != null) {
                        JSONArray names2 = optJSONObject4.names();
                        int length2 = names2.length();
                        int i15 = i13;
                        while (i15 < length2) {
                            int i16 = length2;
                            String optString3 = names2.optString(i15);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString3);
                            if (optJSONObject5 == null) {
                                str3 = str5;
                                jSONArray3 = names2;
                                i3 = i15;
                                i10 = i16;
                                jSONObject = optJSONObject2;
                                jSONArray2 = names;
                            } else {
                                jSONObject = optJSONObject2;
                                String optString4 = optJSONObject5.optString(str5);
                                jSONArray2 = names;
                                if (optJSONObject5.has("styleMap")) {
                                    jSONArray3 = names2;
                                    i3 = i15;
                                    i10 = i16;
                                    a(optJSONObject5.optJSONArray("styleMap"), optString, optString3, optString2 + "-" + optString4, this.f5542c);
                                } else {
                                    jSONArray3 = names2;
                                    String str6 = optString3;
                                    i3 = i15;
                                    i10 = i16;
                                    if (optJSONObject5.has("subType") && (optJSONObject = optJSONObject5.optJSONObject("subType")) != null) {
                                        JSONArray names3 = optJSONObject.names();
                                        int length3 = names3.length();
                                        int i17 = 0;
                                        while (i17 < length3) {
                                            String str7 = optString;
                                            String optString5 = names3.optString(i17);
                                            JSONArray jSONArray5 = names3;
                                            JSONObject optJSONObject6 = optJSONObject.optJSONObject(optString5);
                                            if (optJSONObject6 == null) {
                                                str = str5;
                                                str2 = str6;
                                                i11 = length3;
                                            } else {
                                                i11 = length3;
                                                String optString6 = optJSONObject6.optString(str5);
                                                if (optJSONObject6.has("styleMap")) {
                                                    str = str5;
                                                    str2 = str6;
                                                    i12 = i17;
                                                    optString = str7;
                                                    a(optJSONObject6.optJSONArray("styleMap"), optString, str6 + "-" + optString5, optString2 + "-" + optString4 + "-" + optString6, this.f5542c);
                                                    i17 = i12 + 1;
                                                    str6 = str2;
                                                    names3 = jSONArray5;
                                                    length3 = i11;
                                                    str5 = str;
                                                } else {
                                                    str = str5;
                                                    str2 = str6;
                                                }
                                            }
                                            optString = str7;
                                            i12 = i17;
                                            i17 = i12 + 1;
                                            str6 = str2;
                                            names3 = jSONArray5;
                                            length3 = i11;
                                            str5 = str;
                                        }
                                    }
                                }
                                str3 = str5;
                            }
                            i15 = i3 + 1;
                            optJSONObject2 = jSONObject;
                            names2 = jSONArray3;
                            names = jSONArray2;
                            length2 = i10;
                            str5 = str3;
                        }
                    }
                }
                str4 = str5;
                jSONObject2 = optJSONObject2;
                jSONArray4 = names;
                this.f5542c.add(new v3(20021, f5539d, "roads", "trafficRoadBackgroundColor", null));
                i14++;
                optJSONObject2 = jSONObject2;
                names = jSONArray4;
                str5 = str4;
                i13 = 0;
            }
            str4 = str5;
            jSONObject2 = optJSONObject2;
            jSONArray4 = names;
            i14++;
            optJSONObject2 = jSONObject2;
            names = jSONArray4;
            str5 = str4;
            i13 = 0;
        }
        return this.f5542c;
    }

    public a4 a(byte[] bArr, boolean z5) {
        a4 a4Var = new a4();
        try {
            if (!a(a4Var.c(), bArr)) {
                a(a4Var, bArr, z5);
            }
            a(a4Var);
            a4Var.a();
            return a4Var;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return a4Var;
        }
    }

    public void a(a4 a4Var) {
        if (this.f5541b != -1) {
            Map<Integer, StyleItem> c9 = a4Var.c();
            ArrayList arrayList = (ArrayList) a("roads", "trafficRoadBackgroundColor");
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                v3 v3Var = (v3) obj;
                a(c9, v3Var.f5178d, x3.a("fillColor"), v3Var).value = this.f5541b;
                a(c9, v3Var.f5178d, x3.a("strokeColor"), v3Var).value = this.f5541b;
            }
        }
    }

    private void a(a4 a4Var, byte[] bArr, boolean z5) {
        JSONArray jSONArray;
        int i3;
        w3 a3 = a(bArr);
        if (a3 == null || a3.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a3.a());
            JSONArray names = jSONObject.names();
            for (int i10 = 0; i10 < names.length(); i10++) {
                String string = names.getString(i10);
                if (string == null || !string.trim().equals("sdkTextures")) {
                    if (string != null) {
                        try {
                            if (string.trim().equals("background")) {
                                this.f5540a = a(Const.STR_MART_WELL + jSONObject.optString("background"));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                            return;
                        }
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(string);
                    if (optJSONObject != null) {
                        Map<Integer, StyleItem> c9 = a4Var.c();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("subType");
                        if (optJSONObject2 == null) {
                            a(string, string, c9, optJSONObject, z5);
                        } else {
                            JSONArray names2 = optJSONObject2.names();
                            for (int i11 = 0; i11 < names2.length(); i11++) {
                                String optString = names2.optString(i11);
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString);
                                if (optJSONObject3.has("detailedType")) {
                                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("detailedType");
                                    if (optJSONObject4 != null) {
                                        JSONArray names3 = optJSONObject4.names();
                                        int i12 = 0;
                                        while (i12 < names3.length()) {
                                            int i13 = i12;
                                            String optString2 = names3.optString(i13);
                                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString2);
                                            if (optJSONObject5 == null) {
                                                jSONArray = names3;
                                                i3 = i13;
                                            } else {
                                                jSONArray = names3;
                                                i3 = i13;
                                                a(string, optString2, c9, optJSONObject5, z5);
                                            }
                                            i12 = i3 + 1;
                                            names3 = jSONArray;
                                        }
                                    }
                                } else {
                                    a(string, optString, c9, optJSONObject3, z5);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void a(JSONArray jSONArray, String str, String str2, String str3, List<v3> list) {
        int[] iArr;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("mainkey");
                int[] iArr2 = new int[0];
                JSONArray optJSONArray = optJSONObject.optJSONArray("subkey");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    int[] iArr3 = new int[length2];
                    for (int i10 = 0; i10 < length2; i10++) {
                        iArr3[i10] = optJSONArray.optInt(i10);
                    }
                    iArr = iArr3;
                } else {
                    iArr = iArr2;
                }
                list.add(new v3(optInt, iArr, str, str2, str3));
            }
        }
    }

    private List<v3> a(String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList();
        for (v3 v3Var : this.f5542c) {
            if (v3Var != null) {
                String str4 = v3Var.e;
                if (str4 != null && str4.equals(str2)) {
                    arrayList.add(v3Var);
                } else {
                    String str5 = v3Var.e;
                    if (str5 != null && str5.equals(str) && (str3 = v3Var.f5179f) != null && str3.contains(str2)) {
                        arrayList.add(v3Var);
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z5) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (this.f5542c == null) {
            this.f5542c = b();
        }
        ArrayList arrayList = (ArrayList) a(str, str2);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            int i10 = i3 + 1;
            v3 v3Var = (v3) arrayList.get(i3);
            if (v3Var == null || v3Var.f5177c == -1000) {
                return;
            }
            int i11 = v3Var.f5178d;
            if (!jSONObject.optBoolean("visible", true)) {
                StyleElement a3 = a(map, i11, x3.a("visible"), v3Var);
                a3.textureId = -1;
                a3.visible = 0;
            } else {
                if (!jSONObject.optBoolean("showIcon", true)) {
                    a(map, i11, x3.a("textFillColor"), v3Var).textureId = -1;
                }
                if (!jSONObject.optBoolean("showLabel", true)) {
                    a(map, i11, x3.a("textFillColor"), v3Var).opacity = 0.0f;
                    StyleElement a10 = a(map, i11, x3.a("textStrokeColor"), v3Var);
                    a10.opacity = 0.0f;
                    a10.visible = 0;
                    a10.textureId = -1;
                }
                a(map, jSONObject, "color", "opacity", i11, v3Var);
                a(map, jSONObject, "fillColor", "fillOpacity", i11, v3Var);
                a(map, jSONObject, "strokeColor", "strokeOpacity", i11, v3Var);
                a(map, jSONObject, "textFillColor", "textFillOpacity", i11, v3Var);
                a(map, jSONObject, "textStrokeColor", "textStrokeOpacity", i11, v3Var);
                a(map, jSONObject, "backgroundColor", "backgroundOpacity", i11, v3Var);
                if (z5) {
                    try {
                        int optInt = jSONObject.optInt("textureName", 0);
                        if (optInt != 0) {
                            a(map, i11, x3.a("textureName"), v3Var).textureId = optInt;
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
            i3 = i10;
        }
        arrayList.clear();
    }

    private void a(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i3, v3 v3Var) {
        int a3;
        float f2;
        try {
            String optString = jSONObject.optString(str, null);
            if (TextUtils.isEmpty(optString)) {
                f2 = (float) jSONObject.optDouble(str2, 1.0d);
                a3 = 0;
            } else {
                a3 = a(Const.STR_MART_WELL + optString);
                f2 = 1.0f;
            }
            if (a3 == 0 && f2 == 1.0d) {
                return;
            }
            int a10 = x3.a(str);
            StyleElement a11 = a(map, i3, a10, v3Var);
            a11.value = a3;
            a11.opacity = f2;
            String str3 = v3Var.f5179f;
            if (str3 != null && str3.equals("China")) {
                a(map, i3, a10, v3Var).opacity = 0.0f;
                return;
            }
            String str4 = v3Var.e;
            if (str4 != null && str4.equals("water") && a10 == 3) {
                StyleElement a12 = a(map, i3, 2, v3Var);
                a12.value = a3;
                a12.opacity = f2;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static w3 a(byte[] bArr) {
        String str = null;
        try {
            w3 w3Var = new w3();
            try {
                byte[] bytes = "l".getBytes("utf-8");
                int length = bArr.length;
                int length2 = bytes.length;
                for (int i3 = 0; i3 < length; i3++) {
                    bArr[i3] = (byte) (bytes[i3 % length2] ^ bArr[i3]);
                }
                Convert.getString(bArr, 0, 4);
                Convert.getString(bArr, 4, 32);
                Convert.getString(bArr, 36, 10);
                byte[] subBytes = Convert.getSubBytes(bArr, 46, 16);
                byte[] subBytes2 = Convert.getSubBytes(bArr, 62, 16);
                byte[] subBytes3 = Convert.getSubBytes(bArr, 78, length - 78);
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(subBytes2);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(subBytes, "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    str = new String(cipher.doFinal(subBytes3), "utf-8");
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                w3Var.a(str);
                return w3Var;
            } catch (Throwable th3) {
                th = th3;
                str = w3Var;
                th.printStackTrace();
                return str;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072 A[Catch: all -> 0x0047, JSONException -> 0x00bf, TryCatch #2 {JSONException -> 0x00bf, all -> 0x0047, blocks: (B:3:0x0001, B:4:0x000e, B:6:0x0014, B:11:0x0027, B:13:0x002f, B:15:0x0037, B:18:0x0044, B:19:0x004b, B:25:0x0072, B:30:0x0095, B:33:0x0099, B:36:0x00a7, B:39:0x00af, B:42:0x007a, B:44:0x007f, B:50:0x008e, B:46:0x0088, B:54:0x0055, B:56:0x005a, B:62:0x0069, B:58:0x0063), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> r11, byte[] r12) {
        /*
            r10 = this;
            r1 = 0
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            java.lang.String r2 = "UTF-8"
            r0.<init>(r12, r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            r0 = r1
        Le:
            int r2 = r12.length()     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r0 >= r2) goto Lba
            org.json.JSONObject r5 = r12.optJSONObject(r0)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            java.lang.String r2 = "featureType"
            java.lang.String r2 = r5.optString(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r3 == 0) goto L27
        L24:
            r4 = r11
            goto Lb5
        L27:
            java.lang.String r3 = "background"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r3 == 0) goto L4b
            java.lang.String r2 = "stylers"
            org.json.JSONObject r2 = r5.optJSONObject(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r2 == 0) goto L24
            java.lang.String r3 = "color"
            java.lang.String r2 = r2.optString(r3)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            int r2 = a(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r2 != 0) goto L44
            goto L24
        L44:
            r10.f5540a = r2     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            goto L24
        L47:
            r0 = move-exception
            r11 = r0
            goto Lbc
        L4b:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            r4 = 0
            r6 = -1
            if (r3 == 0) goto L54
            goto L6e
        L54:
            r3 = r1
        L55:
            java.lang.String[] r7 = com.amap.api.col.p0003sl.y3.f5455a     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            int r8 = r7.length     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r3 >= r8) goto L66
            r7 = r7[r3]     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r7 == 0) goto L63
            goto L67
        L63:
            int r3 = r3 + 1
            goto L55
        L66:
            r3 = r6
        L67:
            if (r3 < 0) goto L6e
            java.lang.String[] r7 = com.amap.api.col.p0003sl.y3.f5457c     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            r3 = r7[r3]     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            goto L6f
        L6e:
            r3 = r4
        L6f:
            if (r3 != 0) goto L72
            goto L24
        L72:
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r7 == 0) goto L79
            goto L92
        L79:
            r7 = r1
        L7a:
            java.lang.String[] r8 = com.amap.api.col.p0003sl.y3.f5455a     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            int r9 = r8.length     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r7 >= r9) goto L8b
            r8 = r8[r7]     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            boolean r8 = r8.equals(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r8 == 0) goto L88
            goto L8c
        L88:
            int r7 = r7 + 1
            goto L7a
        L8b:
            r7 = r6
        L8c:
            if (r7 < 0) goto L92
            java.lang.String[][] r2 = com.amap.api.col.p0003sl.y3.f5456b     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            r4 = r2[r7]     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
        L92:
            r7 = r4
            if (r7 == 0) goto L24
            int r2 = r7.length     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r2 != 0) goto L99
            goto L24
        L99:
            java.lang.String r2 = "elementType"
            java.lang.String r2 = r5.optString(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r4 == 0) goto La7
            goto L24
        La7:
            int r8 = com.amap.api.col.p0003sl.x3.a(r2)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
            if (r8 != r6) goto Laf
            goto L24
        Laf:
            r4 = r11
            r6 = r3
            r3 = r10
            r3.a(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L47 org.json.JSONException -> Lbf
        Lb5:
            int r0 = r0 + 1
            r11 = r4
            goto Le
        Lba:
            r11 = 1
            return r11
        Lbc:
            r11.printStackTrace()
        Lbf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.z3.a(java.util.Map, byte[]):boolean");
    }

    private void a(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String[] strArr, int i3) throws JSONException {
        String[] strArr2 = strArr;
        int i10 = 0;
        while (i10 < strArr2.length) {
            String str2 = strArr2[i10];
            if (this.f5542c == null) {
                this.f5542c = b();
            }
            ArrayList arrayList = (ArrayList) a(str, str2);
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                v3 v3Var = (v3) obj;
                int i12 = v3Var.f5178d;
                StyleElement a3 = a(map, i12, i3, v3Var);
                JSONObject optJSONObject = jSONObject.optJSONObject("stylers");
                if (optJSONObject != null) {
                    int a10 = a(optJSONObject.optString("color"));
                    if (a10 != 0) {
                        a3.value = a10;
                        a3.textureId = optJSONObject.optInt("textureName", 0);
                        a3.lineWidth = optJSONObject.optInt("lineWidth", 0);
                        if (i12 >= 30 && i12 <= 38) {
                            a(map, i12, 4, v3Var).opacity = 0.1f;
                        } else {
                            String str3 = v3Var.e;
                            if (str3 != null && str3.equals("water") && i3 == 3) {
                                a(map, i12, 2, v3Var).value = a10;
                            }
                        }
                    }
                }
            }
            i10++;
            strArr2 = strArr;
        }
    }

    private StyleElement a(Map<Integer, StyleItem> map, int i3, int i10, v3 v3Var) {
        StyleItem styleItem = map.get(Integer.valueOf(i3));
        if (styleItem == null) {
            styleItem = new StyleItem(v3Var.f5177c);
            styleItem.mainKey = v3Var.f5175a;
            styleItem.subKey = v3Var.f5176b;
            map.put(Integer.valueOf(i3), styleItem);
        }
        StyleElement styleElement = styleItem.get(i10);
        if (styleElement != null) {
            return styleElement;
        }
        StyleElement styleElement2 = new StyleElement();
        styleElement2.styleElementType = i10;
        styleItem.put(i10, styleElement2);
        return styleElement2;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (!str.startsWith(Const.STR_MART_WELL)) {
                str = Const.STR_MART_WELL.concat(str);
            }
            return Color.parseColor(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int a() {
        return this.f5540a;
    }
}
