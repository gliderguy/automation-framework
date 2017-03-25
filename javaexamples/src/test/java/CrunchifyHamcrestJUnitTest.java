import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.IsNull;
import org.junit.Test;

/**
 * @author Crunchify.com
 *
 *         Hamcrest JUnit Tutorials by Crunchify.com 
 *         1. Create JUnit testcases for Java List 
 *         2. Create JUnit testcases for Java Map 
 *         3. Create JUnit testcases for Java Object 
 *         4. Create JUnit testcases for Null Check
 *
 */

public class CrunchifyHamcrestJUnitTest {

    // Testcase-1: JUnit for List
    @Test
    public void crunchifyListJUnitTests() {
        List<String> company = Arrays.asList("Crunchify.com", "Google.com", "Facebook.com");
        List<String> crunchifyCompany = Arrays.asList("Crunchify.com", "Google.com", "Facebook.com");

        log("\n~~~~~~~~~~~JUnit List Check Test~~~~~~~~~~~");

        log("1) assertThat(company, is(crunchifyCompany)) check");
        // A shortcut to the frequently used is(equalTo(x)).
        assertThat(company, is(crunchifyCompany));

        log("2) .hasItems() check");
        assertThat(company, hasItems("Crunchify.com"));

        log("3) .hasSize() check");
        assertThat(company, hasSize(3));

        assertThat(company.size(), is(3));

        log("4) .contains() and .containsInAnyOrder() check");
        assertThat(company, contains("Crunchify.com", "Google.com", "Facebook.com"));
        assertThat(company, containsInAnyOrder("Google.com", "Crunchify.com", "Facebook.com"));

        // FAIL
        // assertThat(company, contains("Google.com", "Crunchify.com", "Facebook.com"));

        log("5) .empty() check");
        assertThat(company, not(IsEmptyCollection.empty()));
        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

    }

    private void log(String crunchifyText) {
        System.out.println(crunchifyText);

    }

    @Test
    public void crunchifyMapJUnitTests() {

        Map<String, String> company = new HashMap<>();
        company.put("C", "Crunchify.com");
        company.put("G", "Google.com");
        company.put("F", "Facebook.com");

        Map<String, String> crunchifyCompany = new HashMap<>();
        crunchifyCompany.put("C", "Crunchify.com");
        crunchifyCompany.put("G", "Google.com");
        crunchifyCompany.put("F", "Facebook.com");

        log("\n~~~~~~~~~~~JUnit Map Check Test - All tests will PASS in our example~~~~~~~~~~~");

        log("1) assertThat(company, is(crunchifyCompany) check");
        assertThat(company, is(crunchifyCompany));

        log("2) assertThat(company.size(), is(3)) check");
        assertThat(company.size(), is(3));

        log("3) .hasEntry() check which creates a matcher for Maps matching at least one entry whose key equals the specified key & value.");
        assertThat(company, IsMapContaining.hasEntry("C", "Crunchify.com"));
        assertThat(company, not(IsMapContaining.hasEntry("G", "Twitter.com")));

        log("4) .hasKey() creates a matcher for Maps matching at least one key that is equal to the specified key.");
        assertThat(company, IsMapContaining.hasKey("F"));

        log("5) .hasValue() creates a matcher for Maps matching at least one key that is equal to the specified value.");
        assertThat(company, IsMapContaining.hasValue("Crunchify.com"));

    }

    @SuppressWarnings("unchecked")
    @Test
    public void crunchifyObjectJUnitTests() {

        List<Company> list = Arrays.asList(new Company("Crunchify", 10), new Company("Google", 30000));

        assertThat(list, hasItems(new Company("Crunchify", 10), new Company("Google", 30000)));
        assertThat(list, containsInAnyOrder(new Company("Google", 30000), new Company("Crunchify", 10)));
        assertThat(list, containsInAnyOrder(hasProperty("name", is("Google")), hasProperty("name", is("Crunchify"))));

        log("\n~~~~~~~~~~~JUnit Object Check Test Completed~~~~~~~~~~~");
    }

    // Create Company Object
    public class Company {

        public Company(String name, int employeeCount) {
            this.name = name;
            this.employeeCount = employeeCount;
        }

        private String name;
        private int employeeCount;

        public int getEmployeeCount() {
            return employeeCount;
        }

        public void setEmployeeCount(int employeeCount) {
            this.employeeCount = employeeCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Test equal, override equals() and hashCode()
        @Override
        public boolean equals(Object c) {
            if (this == c)
                return true;
            if (c == null || getClass() != c.getClass())
                return false;
            Company fruit = (Company) c;
            return employeeCount == fruit.employeeCount && Objects.equals(name, fruit.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, employeeCount);
        }
    }

    @Test
    public void crunchifyNullCheckJUnitTest() {

        // Two ways to check isNull
        assertThat(null, is(nullValue()));
        assertThat(null, is(IsNull.nullValue()));

        // Two ways to check isNotNull
        assertThat("crunchify", is(notNullValue()));
        assertThat("crunchify", is(IsNull.notNullValue()));

        log("\n~~~~~~~~~~~JUnit Null Check Test Completed~~~~~~~~~~~");
    }

}