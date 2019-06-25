package cc.oobootcamp.length;

import cc.oobootcamp.length.Length;
import org.junit.Test;

import static cc.oobootcamp.length.Length.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LengthTest {

    @Test
    public void should_return_LARGER_when_compare_source_to_targer_given_source_is_larger() {
        Length sourceLength = new Length(5);
        Length targetLength = new Length(1);

        assertThat(sourceLength.compareTo(targetLength)).isEqualTo(LARGER);
    }

    @Test
    public void should_return_SMALLER_when_compare_source_to_targer_given_source_is_smaller() {
        Length lengthOne = new Length(2);
        Length lengthTwo = new Length(4);

        assertThat(lengthOne.compareTo(lengthTwo)).isEqualTo(SMALLER);
    }

    @Test
    public void should_return_EQUALS_when_compare_source_to_targer_given_value_are_same() {
        Length lengthOne = new Length(100);
        Length lengthTwo = new Length(100);

        assertThat(lengthOne.compareTo(lengthTwo)).isEqualTo(EQUALS);
    }
}
