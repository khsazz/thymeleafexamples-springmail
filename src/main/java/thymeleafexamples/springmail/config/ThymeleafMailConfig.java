package thymeleafexamples.springmail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import static thymeleafexamples.springmail.config.SpringWebInitializer.ENCODING;

/**
 * Thymeleaf configuration for mail templates.
 */
@Configuration
public class ThymeleafMailConfig extends WebMvcConfigurerAdapter {

    /**
     * THYMELEAF: Template Engine (Spring4-specific version) for HTML email templates.
     */
	@Bean
    public TemplateEngine htmlTemplateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());
        return templateEngine;
    }
    
    /**
     * THYMELEAF: Template Engine (Spring4-specific version) for TEXT email templates.
     */
	@Bean
    public TemplateEngine textTemplateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(textTemplateResolver());
        return templateEngine;
    }

    /**
     * THYMELEAF: Template Resolver for HTML email templates.
     */
    private TemplateResolver htmlTemplateResolver() {
        TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/mail/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(ENCODING);
        // Template cache is true by default. Set to false if you want 
        // templates to be automatically updated when modified.
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /**
     * THYMELEAF: Template Resolver for HTML email templates.
     */
    private TemplateResolver textTemplateResolver() {
        TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/mail/");
        templateResolver.setSuffix(".txt");
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setCharacterEncoding(ENCODING);
        // Template cache is true by default. Set to false if you want 
        // templates to be automatically updated when modified.
        templateResolver.setCacheable(false);
        return templateResolver;
    }

}