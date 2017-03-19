package edu.stanford.bmir.protege.web.server.inject;

import dagger.Component;
import edu.stanford.bmir.protege.web.server.WebProtegeConfigurationChecker;
import edu.stanford.bmir.protege.web.server.WebProtegeSessionListener;
import edu.stanford.bmir.protege.web.server.access.AccessManager;
import edu.stanford.bmir.protege.web.server.access.AccessModule;
import edu.stanford.bmir.protege.web.server.app.ApplicationNameProvider;
import edu.stanford.bmir.protege.web.server.app.WebProtegeProperties;
import edu.stanford.bmir.protege.web.server.auth.AuthenticationModule;
import edu.stanford.bmir.protege.web.server.dispatch.ActionHandlersModule;
import edu.stanford.bmir.protege.web.server.init.ConfigurationTasksModule;
import edu.stanford.bmir.protege.web.server.inject.project.ProjectComponent;
import edu.stanford.bmir.protege.web.server.inject.project.ProjectModule;
import edu.stanford.bmir.protege.web.server.mail.MailModule;
import edu.stanford.bmir.protege.web.server.metaproject.MetaProjectModule;
import edu.stanford.bmir.protege.web.server.user.UserDetailsManager;
import edu.stanford.bmir.protege.web.shared.inject.SharedApplicationModule;

import javax.inject.Singleton;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 06/02/15
 */
@Component(modules = {
        ApplicationModule.class,
        SharedApplicationModule.class,
        WebProtegePropertiesModule.class,
        FileSystemConfigurationModule.class,
        ConfigurationTasksModule.class,
        MetaProjectModule.class,
        MailModule.class,
        ActionHandlersModule.class,
        AuthenticationModule.class,
        AccessModule.class,
        DbModule.class,
        RepositoryModule.class,
})
@Singleton
@ApplicationSingleton
public interface ApplicationComponent {

    WebProtegeProperties getWebProtegeProperties();

    WebProtegeConfigurationChecker getWebProtegeConfigurationChecker();

    WebProtegeSessionListener getSessionListener();

    UserDetailsManager getUserDetailsManager();

    ProjectComponent getProjectComponent(ProjectModule module);

    ServletComponent getServletComponent();

    AccessManager getAccessManager();

    ApplicationNameProvider getApplicationNameProvider();
}
