package com.autonavi.base.ae.gmap.bean;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.io.File;
import r5.a;

@JBindingInclude
/* loaded from: classes.dex */
public class InitStorageParam {
    private static final String DIR_NAME = "terrain_dem_files";
    private static final String INIT_STORAGE_DIR = "mapcache";

    @JBindingInclude
    private int maxFileCount;

    @JBindingInclude
    private long maxFileSize;

    @JBindingInclude
    private String path;

    @JBindingInclude
    private int version;

    public static class Holder {
        private static String sPath;

        public static void initPath(String str) {
            File file = new File(str);
            File file2 = new File(file, InitStorageParam.INIT_STORAGE_DIR);
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, InitStorageParam.DIR_NAME);
                if (!file3.exists()) {
                    file3.mkdir();
                }
                sPath = file3.getAbsolutePath();
            }
        }
    }

    private InitStorageParam(int i3, String str, int i10, long j4) {
        this.version = i3;
        this.path = str;
        this.maxFileCount = i10;
        this.maxFileSize = j4;
    }

    @JBindingInclude
    public static InitStorageParam obtain() {
        return new InitStorageParam();
    }

    @JBindingInclude
    public int getMaxFileCount() {
        return this.maxFileCount;
    }

    @JBindingInclude
    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    @JBindingInclude
    public String getPath() {
        return this.path;
    }

    @JBindingInclude
    public int getVersion() {
        return this.version;
    }

    @JBindingInclude
    public void setMaxFileCount(int i3) {
        this.maxFileCount = i3;
    }

    @JBindingInclude
    public void setMaxFileSize(long j4) {
        this.maxFileSize = j4;
    }

    @JBindingInclude
    public void setPath(String str) {
        this.path = str;
    }

    @JBindingInclude
    public void setVersion(int i3) {
        this.version = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("InitStorageParam{version=");
        sb2.append(this.version);
        sb2.append(", maxFileCount=");
        sb2.append(this.maxFileCount);
        sb2.append(", maxFileSize=");
        sb2.append(this.maxFileSize);
        sb2.append(", path='");
        return a.f(sb2, this.path, "'}");
    }

    @JBindingInclude
    public static InitStorageParam obtain(int i3, String str, int i10, long j4) {
        return new InitStorageParam(i3, str, i10, j4);
    }

    private InitStorageParam() {
        this(1, Holder.sPath, 1000, Const.L_GPS_REBOOT_INTERVAL);
    }
}
