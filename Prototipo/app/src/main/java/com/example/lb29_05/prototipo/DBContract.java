package com.example.lb29_05.prototipo;

import android.provider.BaseColumns;

public final class DBContract {

    private DBContract() {}

    public static class ImageEntry implements BaseColumns {
        public static final String TABLE_NAME = "imagem";
        public static final String COL_IMG_NAME = "nome";
        public static final String COL_IMG_ROTULOS = "nome";
        public static final String COLUMN_NAME_SUBTITLE = "subtitulo";
    }
}