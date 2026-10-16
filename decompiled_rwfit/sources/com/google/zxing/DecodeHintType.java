package com.google.zxing;

/* loaded from: classes.dex */
public enum DecodeHintType {
    OTHER("OTHER"),
    PURE_BARCODE("PURE_BARCODE"),
    POSSIBLE_FORMATS("POSSIBLE_FORMATS"),
    TRY_HARDER("TRY_HARDER"),
    CHARACTER_SET("CHARACTER_SET"),
    ALLOWED_LENGTHS("ALLOWED_LENGTHS"),
    ASSUME_CODE_39_CHECK_DIGIT("ASSUME_CODE_39_CHECK_DIGIT"),
    ASSUME_GS1("ASSUME_GS1"),
    RETURN_CODABAR_START_END("RETURN_CODABAR_START_END"),
    NEED_RESULT_POINT_CALLBACK("NEED_RESULT_POINT_CALLBACK"),
    ALLOWED_EAN_EXTENSIONS("ALLOWED_EAN_EXTENSIONS"),
    ALSO_INVERTED("ALSO_INVERTED");

    private final Class<?> valueType;

    DecodeHintType(String str) {
        this.valueType = r2;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }
}
