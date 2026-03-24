package nl.giejay.android.tv.immich.shared.prefs

import nl.giejay.android.tv.immich.ImmichApplication
import nl.giejay.android.tv.immich.R

enum class AppLanguage(val locale: String?) : EnumWithTitle {
    SYSTEM(null) {
        override fun getTitle(): String =
            ImmichApplication.appContext!!.getString(R.string.language_system)
    },
    EN("en") {
        override fun getTitle(): String =
            ImmichApplication.appContext!!.getString(R.string.language_english)
    },
    ZH_CN("zh-CN") {
        override fun getTitle(): String =
            ImmichApplication.appContext!!.getString(R.string.language_chinese_simplified)
    },
    ZH_TW("zh-TW") {
        override fun getTitle(): String =
            ImmichApplication.appContext!!.getString(R.string.language_chinese_traditional)
    };

    companion object {
        fun valueOfSafe(name: String, default: AppLanguage): AppLanguage {
            return entries.find { it.toString() == name } ?: default
        }
    }
}
