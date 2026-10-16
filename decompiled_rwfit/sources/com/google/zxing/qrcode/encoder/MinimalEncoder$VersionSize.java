package com.google.zxing.qrcode.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum MinimalEncoder$VersionSize {
    SMALL("version 1-9"),
    MEDIUM("version 10-26"),
    LARGE("version 27-40");

    private final String description;

    MinimalEncoder$VersionSize(String str) {
        this.description = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.description;
    }
}
