package io.jenkins.plugins.notification.bar;

import static io.jenkins.plugins.notification.bar.SimpleThemeManagerFactory.THEME_JS;
import static io.jenkins.plugins.notification.bar.SimpleThemeManagerFactory.THEME_URL_NAME;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.UnprotectedRootAction;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.ServletException;
import jenkins.model.Jenkins;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

@Extension
@Restricted(NoExternalUse.class)
public class SimpleThemeRootAction implements UnprotectedRootAction {

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return THEME_URL_NAME;
    }

    public void doDynamic(StaplerRequest req, StaplerResponse rsp)
            throws IOException, URISyntaxException, ServletException {
        String jsFile = req.getRestOfPath();
        if (jsFile.startsWith("/")) {
            jsFile = jsFile.substring(1);
        }
        if (!THEME_JS.equals(jsFile) && !(THEME_JS + ".map").equals(jsFile)) {
            rsp.sendError(404);
            return;
        }
        final Plugin plugin = Jenkins.get().getPlugin("notification-bar");
        if (plugin == null) {
            rsp.sendError(404);
            return;
        }
        plugin.doDynamic(req, rsp);
    }
}
