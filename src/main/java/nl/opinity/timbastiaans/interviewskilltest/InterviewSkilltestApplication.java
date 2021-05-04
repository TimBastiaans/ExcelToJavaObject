package nl.opinity.timbastiaans.interviewskilltest;

import com.poiji.bind.Poiji;
import nl.opinity.timbastiaans.interviewskilltest.mo.FootBallPlayersExcel;
import nl.opinity.timbastiaans.interviewskilltest.service.FootballPlayerService;
import nl.opinity.timbastiaans.interviewskilltest.service.IFootballService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.swagger.web.*;

import java.io.File;
import java.util.List;

import static java.util.Collections.singletonList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@SpringBootApplication(scanBasePackages={
		"nl.opinity.timbastiaans.interviewskilltest", "nl.opinity.timbastiaans.interviewskilltest.service"})
public class InterviewSkilltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewSkilltestApplication.class, args);

		File file = new File("/Users/home/Desktop/FootballPlayers.xlsx");
		List<FootBallPlayersExcel> players = Poiji.fromExcel(file, FootBallPlayersExcel.class);
		System.out.println("List of players data: " + players);
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("/anyPath.*"))
				.build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope
				= new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return singletonList(
				new SecurityReference("mykey", authorizationScopes));
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
