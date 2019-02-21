package io.github.opensanca.arqv.rules.spring.repositoy;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import io.github.opensanca.arqv.constants.Constants;
import org.junit.runner.RunWith;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(
    packages = "",
    importOptions = ImportOption.DontIncludeTests.class
)
public class RepositoriesShouldBeInSpecificPackageRule {

    @ArchTest
    static final ArchRule REPOSITORIES_SHOULD_STAY_ON_REPOSITORY_PACKAGE =
        classes()
            .that()
                .haveNameMatching(".*Repository")
            .should()
                .beInterfaces()
            .andShould()
                .resideInAPackage(Constants.REPOSITORY)
            .as("Repositories should reside in a package '..repository..'");
}
