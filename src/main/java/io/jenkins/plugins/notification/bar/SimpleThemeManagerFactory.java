package io.jenkins.plugins.notification.bar;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;

public class SimpleThemeManagerFactory extends ThemeManagerFactory {

    public static final String THEME_JS = "theme.js";
    public static final String THEME_URL_NAME = "theme-simple";

    @Override
    public Theme getTheme() {
        return Theme.builder().withJavascriptUrl(toAssetUrl("theme.js")).build();
    }

    @Extension
    @Symbol("simple")
    public static class DarkThemeManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @NonNull
        @Override
        public String getDisplayName() {
            return "simple";
        }

        @NonNull
        @Override
        public String getThemeId() {
            return "simple";
        }

        @Override
        public String getThemeKey() {
            return "simple";
        }

        @Override
        public boolean isNamespaced() {
            return true;
        }
    }
}
