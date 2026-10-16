package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes.dex */
public enum FieldNamingPolicy implements a {
    IDENTITY { // from class: com.google.gson.FieldNamingPolicy.1
        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.a
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.google.gson.FieldNamingPolicy.2
        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.a
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.google.gson.FieldNamingPolicy.3
        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.a
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.google.gson.FieldNamingPolicy.4
        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.a
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.google.gson.FieldNamingPolicy.5
        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.a
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: com.google.gson.FieldNamingPolicy.6
        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.a
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    FieldNamingPolicy(AnonymousClass1 anonymousClass1) {
    }

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (Character.isUpperCase(charAt) && sb2.length() != 0) {
                sb2.append(str2);
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        int length = str.length() - 1;
        int i3 = 0;
        while (!Character.isLetter(str.charAt(i3)) && i3 < length) {
            i3++;
        }
        char charAt = str.charAt(i3);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i3 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i3) + upperCase + str.substring(i3 + 1);
    }

    @Override // com.google.gson.a
    public abstract /* synthetic */ String translateName(Field field);
}
