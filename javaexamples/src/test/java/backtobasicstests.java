import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

//http://www.baeldung.com/java-8-sort-lambda
public class backtobasicstests {

        @Test //Basic Sort without Lambdas
        public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
            List<Human> humans = Lists.newArrayList(
                    new Human("Sarah", 10),
                    new Human("Jack", 12)

            );

            Collections.sort(humans, new Comparator<Human>() {
                @Override
                public int compare(Human h1, Human h2) {
                    return h1.getName().compareTo(h2.getName());
                }
            });

            Assert.assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
        }

    @Test //Basic Sort with Lambda Support
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(
            new Human("Sarah", 10),
            new Human("Jack", 12)
    );

    humans.sort((Human h1, Human h2)

            -> h1.getName().compareTo(h2.getName()));
    assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test // Basic Sorting with no Type Definitions
    public void givenLambdaShortForm_whenSortingEntitiesByName_thenCorrectlySorted() {

    List<Human> humans = Lists.newArrayList(
            new Human("Sarah", 10),
            new Human("Jack", 12)
    );

    humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
    assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test //Sort using Reference to Static Method
    public void givenInstanceMethod_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12),
                new Human("Adam", 11),
                new Human("Aaron", 22)
        );

        Collections.sort(
                humans, Comparator.comparing(Human::getName));
        assertThat(humans.get(2), equalTo(new Human("Jack", 12)));
        Assert.assertThat(humans.get(1), equalTo(new Human("Adam", 11)));
    }

    @Test //Sort Extracted Comparators
    public void givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(
            new Human("Sarah", 10),
            new Human("Jack", 12)
    );

    humans.sort(Human::compareByNameThenAge);
    Assert.assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test //Reverse Sort
    public void whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(
            new Human("Sarah", 10),
            new Human("Jack", 12)
    );

    Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());
        Assert.assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }

    @Test  //Sort with Multiple Conditions
    public void whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
            List<Human> humans = Lists.newArrayList(
                    new Human("Sarah", 12),
                    new Human("Sarah", 10),
                    new Human("Zack", 12)
            );

            humans.sort((lhs, rhs) -> {
                if (lhs.getName().equals(rhs.getName())) {
                    return lhs.getAge() - rhs.getAge();
                } else {
                    return lhs.getName().compareTo(rhs.getName());
                }
            });
            Assert.assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }

    @Test  //Sort with Multiple Conditions – Composition
    public void
    givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
            List<Human> humans = Lists.newArrayList(
                    new Human("Sarah", 12),
                    new Human("Sarah", 10),
                    new Human("Zack", 12)
            );

            humans.sort(
                    Comparator.comparing(Human::getName).thenComparing(Human::getAge)
            );

            Assert.assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }
 }