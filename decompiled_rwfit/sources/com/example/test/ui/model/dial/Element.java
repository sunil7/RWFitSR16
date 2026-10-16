package com.example.test.ui.model.dial;

import java.util.List;

/* loaded from: classes.dex */
public class Element {
    private int compression;
    private List<ImageData> dataList;
    private int fontType;
    private int height;
    private int index;
    private int offset;
    private byte[] rawData;
    private int size;
    private int type;
    private int width;

    /* renamed from: x, reason: collision with root package name */
    private int f8156x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f8157y = 0;
    private byte imageCount = 1;
    private int hasAlpha = 1;
    private byte anchor = 9;
    private int blackTransparent = 0;
    private byte leftOffset = 0;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public byte getAnchor() {
        return this.anchor;
    }

    public int getBlackTransparent() {
        return this.blackTransparent;
    }

    public int getCompression() {
        return this.compression;
    }

    public List<ImageData> getDataList() {
        return this.dataList;
    }

    public int getFontType() {
        return this.fontType;
    }

    public int getHasAlpha() {
        return this.hasAlpha;
    }

    public int getHeight() {
        return this.height;
    }

    public byte getImageCount() {
        return this.imageCount;
    }

    public int getIndex() {
        return this.index;
    }

    public byte getLeftOffset() {
        return this.leftOffset;
    }

    public int getOffset() {
        return this.offset;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public int getSize() {
        return this.size;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.f8156x;
    }

    public int getY() {
        return this.f8157y;
    }

    public void setAnchor(byte b3) {
        this.anchor = b3;
    }

    public void setBlackTransparent(int i3) {
        this.blackTransparent = i3;
    }

    public void setCompression(int i3) {
        this.compression = i3;
    }

    public void setDataList(List<ImageData> list) {
        this.dataList = list;
    }

    public void setFontType(int i3) {
        this.fontType = i3;
    }

    public void setHasAlpha(int i3) {
        this.hasAlpha = i3;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setImageCount(byte b3) {
        this.imageCount = b3;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setLeftOffset(byte b3) {
        this.leftOffset = b3;
    }

    public void setOffset(int i3) {
        this.offset = i3;
    }

    public void setRawData(byte[] bArr) {
        this.rawData = bArr;
    }

    public void setSize(int i3) {
        this.size = i3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public void setX(int i3) {
        this.f8156x = i3;
    }

    public void setY(int i3) {
        this.f8157y = i3;
    }

    public static class ImageData {
        private byte[] data;
        private int size;

        public ImageData(byte[] bArr) {
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSize() {
            return this.size;
        }

        public void setData(byte[] bArr) {
            this.data = bArr;
        }

        public void setSize(int i3) {
            this.size = i3;
        }

        public ImageData(byte[] bArr, int i3) {
            this.data = bArr;
            this.size = i3;
        }
    }
}
