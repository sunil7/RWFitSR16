package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import u8.b;
import ye.e;

/* loaded from: classes2.dex */
public class FileDownloadModel implements Parcelable {
    public static final String CONNECTION_COUNT = "connectionCount";
    public static final Parcelable.Creator<FileDownloadModel> CREATOR = new b(7);
    public static final int DEFAULT_CALLBACK_PROGRESS_TIMES = 100;
    public static final String ERR_MSG = "errMsg";
    public static final String ETAG = "etag";
    public static final String FILENAME = "filename";
    public static final String ID = "_id";
    public static final String PATH = "path";
    public static final String PATH_AS_DIRECTORY = "pathAsDirectory";
    public static final String SOFAR = "sofar";
    public static final String STATUS = "status";
    public static final String TOTAL = "total";
    public static final int TOTAL_VALUE_IN_CHUNKED_RESOURCE = -1;
    public static final String URL = "url";
    private int connectionCount;
    private String eTag;
    private String errMsg;
    private String filename;

    /* renamed from: id, reason: collision with root package name */
    private int f11467id;
    private boolean isLargeFile;
    private String path;
    private boolean pathAsDirectory;
    private final AtomicLong soFar;
    private final AtomicInteger status;
    private long total;
    private String url;

    public FileDownloadModel() {
        this.soFar = new AtomicLong();
        this.status = new AtomicInteger();
    }

    public final void B(String str, boolean z5) {
        this.path = str;
        this.pathAsDirectory = z5;
    }

    public final void C(long j4) {
        this.soFar.set(j4);
    }

    public final void D(byte b3) {
        this.status.set(b3);
    }

    public final void E(long j4) {
        this.isLargeFile = j4 > 2147483647L;
        this.total = j4;
    }

    public final void G(String str) {
        this.url = str;
    }

    public final ContentValues H() {
        String str;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, Integer.valueOf(this.f11467id));
        contentValues.put("url", this.url);
        contentValues.put(PATH, this.path);
        contentValues.put(STATUS, Byte.valueOf(k()));
        contentValues.put(SOFAR, Long.valueOf(this.soFar.get()));
        contentValues.put(TOTAL, Long.valueOf(this.total));
        contentValues.put(ERR_MSG, this.errMsg);
        contentValues.put(ETAG, this.eTag);
        contentValues.put(CONNECTION_COUNT, Integer.valueOf(this.connectionCount));
        contentValues.put(PATH_AS_DIRECTORY, Boolean.valueOf(this.pathAsDirectory));
        if (this.pathAsDirectory && (str = this.filename) != null) {
            contentValues.put(FILENAME, str);
        }
        return contentValues;
    }

    public final int a() {
        return this.connectionCount;
    }

    public final String b() {
        return this.eTag;
    }

    public final String d() {
        return this.filename;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int h() {
        return this.f11467id;
    }

    public final String i() {
        return this.path;
    }

    public final long j() {
        return this.soFar.get();
    }

    public final byte k() {
        return (byte) this.status.get();
    }

    public final String l() {
        String str = this.path;
        boolean z5 = this.pathAsDirectory;
        String str2 = this.filename;
        int i3 = e.f20123a;
        if (str == null) {
            return null;
        }
        if (!z5) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return e.c(str, str2);
    }

    public final String m() {
        if (l() == null) {
            return null;
        }
        String l3 = l();
        Locale locale = Locale.ENGLISH;
        return android.support.v4.media.session.e.l(l3, ".temp");
    }

    public final long n() {
        return this.total;
    }

    public final String o() {
        return this.url;
    }

    public final void p(long j4) {
        this.soFar.addAndGet(j4);
    }

    public final boolean q() {
        return this.total == -1;
    }

    public final boolean r() {
        return this.isLargeFile;
    }

    public final boolean s() {
        return this.pathAsDirectory;
    }

    public final void t() {
        this.connectionCount = 1;
    }

    public final String toString() {
        Object[] objArr = {Integer.valueOf(this.f11467id), this.url, this.path, Integer.valueOf(this.status.get()), this.soFar, Long.valueOf(this.total), this.eTag, super.toString()};
        int i3 = e.f20123a;
        return String.format(Locale.ENGLISH, "id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", objArr);
    }

    public final void u(int i3) {
        this.connectionCount = i3;
    }

    public final void v(String str) {
        this.eTag = str;
    }

    public final void w(String str) {
        this.errMsg = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f11467id);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeByte(this.pathAsDirectory ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.status.get());
        parcel.writeLong(this.soFar.get());
        parcel.writeLong(this.total);
        parcel.writeString(this.errMsg);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.connectionCount);
        parcel.writeByte(this.isLargeFile ? (byte) 1 : (byte) 0);
    }

    public final void x(String str) {
        this.filename = str;
    }

    public final void z(int i3) {
        this.f11467id = i3;
    }

    public FileDownloadModel(Parcel parcel) {
        this.f11467id = parcel.readInt();
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.pathAsDirectory = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.status = new AtomicInteger(parcel.readByte());
        this.soFar = new AtomicLong(parcel.readLong());
        this.total = parcel.readLong();
        this.errMsg = parcel.readString();
        this.eTag = parcel.readString();
        this.connectionCount = parcel.readInt();
        this.isLargeFile = parcel.readByte() != 0;
    }
}
