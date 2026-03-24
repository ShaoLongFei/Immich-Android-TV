package nl.giejay.android.tv.immich.shared.util

import android.content.Context
import android.content.res.Configuration
import nl.giejay.android.tv.immich.shared.prefs.AppLanguage
import java.util.Locale

object LocaleHelper {

    fun applyLocale(context: Context, language: AppLanguage): Context {
        val locale = if (language.locale == null) {
            // Follow system locale
            Locale.getDefault()
        } else {
            Locale.forLanguageTag(language.locale)
        }
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }
}
