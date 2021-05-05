package nl.opinity.timbastiaans.interviewskilltest;

import nl.opinity.timbastiaans.interviewskilltest.service.FootballPlayerService;
import nl.opinity.timbastiaans.interviewskilltest.service.IFootballService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger.web.*;

@SpringBootApplication(scanBasePackages={
		"nl.opinity.timbastiaans.interviewskilltest.controllers", "nl.opinity.timbastiaans.interviewskilltest.service"})
public class InterviewSkilltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewSkilltestApplication.class, args);
	}

	@Bean
	SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder()
				.clientId("test-app-client-id")
				.clientSecret("test-app-client-secret")
				.realm("test-app-realm")
				.appName("test-app")
				.scopeSeparator(",")
				.additionalQueryStringParams(null)
				.useBasicAuthenticationWithAccessCodeGrant(false)
				.enableCsrfSupport(false)
				.build();
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder()
				.deepLinking(true)
				.displayOperationId(false)
				.defaultModelsExpandDepth(1)
				.defaultModelExpandDepth(1)
				.defaultModelRendering(ModelRendering.EXAMPLE)
				.displayRequestDuration(false)
				.docExpansion(DocExpansion.NONE)
				.filter(false)
				.maxDisplayedTags(null)
				.operationsSorter(OperationsSorter.ALPHA)
				.showExtensions(false)
				.showCommonExtensions(false)
				.tagsSorter(TagsSorter.ALPHA)
				.supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
				.validatorUrl(null)
				.build();
	}

	@Bean
	public IFootballService footballPlayerServiceConfiguration(){
		return new FootballPlayerService();
	}

}
