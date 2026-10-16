package com.amap.api.maps;

import com.amap.api.col.p0003sl.n1;
import com.amap.api.map3d.R;

/* loaded from: classes.dex */
public class AMapException extends Exception {
    public static final String ERROR_LANGUAGE_AUTH = "多语言鉴权失败";
    public static final String ERROR_NOT_ENOUGH_SPACE = "空间不足";
    private static final long serialVersionUID = 5204097757158979179L;
    private String errorMessage;
    public static final String ERROR_IO = n1.a(R.string.O105492_88);
    public static final String ERROR_SOCKET = n1.a(R.string.O105492_89);
    public static final String ERROR_SOCKE_TIME_OUT = n1.a(R.string.O105492_90);
    public static final String ERROR_INVALID_PARAMETER = n1.a(R.string.O105492_91);
    public static final String ERROR_NULL_PARAMETER = n1.a(R.string.O105492_92);
    public static final String ERROR_URL = n1.a(R.string.O105492_93);
    public static final String ERROR_UNKNOW_HOST = n1.a(R.string.O105492_94);
    public static final String ERROR_UNKNOW_SERVICE = n1.a(R.string.O105492_95);
    public static final String ERROR_PROTOCOL = n1.a(R.string.O105492_96);
    public static final String ERROR_CONNECTION = n1.a(R.string.O105492_97);
    public static final String ERROR_UNKNOWN = n1.a(R.string.O105492_98);
    public static final String ERROR_FAILURE_AUTH = n1.a(R.string.O105492_99);
    public static final String ERROR_NOT_AVAILABLE = n1.a(R.string.O105492_101);
    public static final String ERROR_ILLEGAL_VALUE = n1.a(R.string.O105492_102);
    public static final String AMAP_NOT_SUPPORT = n1.a(R.string.O105492_103);
    public static final String ILLEGAL_AMAP_ARGUMENT = n1.a(R.string.O105492_104);
    public static final String ERROR_FAILURE_OVERSEA_AUTH = n1.a(R.string.O105492_105);
    public static final String FEATURE_MVT_NOT_SUPPORT = n1.a(R.string.O105492_06);
    public static final String FEATURE_GLTF_NOT_SUPPORT = n1.a(R.string.O105492_106);
    public static final String FEATURE_TERRAIN_NOT_SUPPORT = n1.a(R.string.O105492_107);
    public static final String ERROR_LIB_NOT_MATCH = n1.a(R.string.O105492_108);
    public static final String ERROR_LIB_NOT_FIND = n1.a(R.string.O105492_109);

    public AMapException(String str) {
        super(str);
        this.errorMessage = str;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public AMapException() {
        this.errorMessage = ERROR_UNKNOWN;
    }
}
