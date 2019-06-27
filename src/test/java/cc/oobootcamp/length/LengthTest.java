package cc.oobootcamp.length;

import cc.oobootcamp.length.Length;
import org.junit.Test;

import static cc.oobootcamp.length.Length.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LengthTest {

    @Test
    public void should_return_LARGER_when_compare_source_to_target_given_source_is_larger() {
        Length sourceLength = new Length(5);
        Length targetLength = new Length(1);

        int result = sourceLength.compareTo(targetLength);

        assertThat(result).isEqualTo(LARGER);
    }

    @Test
    public void should_return_SMALLER_when_compare_source_to_target_given_source_is_smaller() {
        Length sourceLength = new Length(2);
        Length targetLength = new Length(4);

        int result = sourceLength.compareTo(targetLength);

        assertThat(result).isEqualTo(SMALLER);
    }

    @Test
    public void should_return_EQUALS_when_compare_source_to_target_given_length_are_same() {
        Length sourceLength = new Length(100);
        Length targetLength = new Length(100);

        int result = sourceLength.compareTo(targetLength);

        assertThat(result).isEqualTo(EQUALS);
    }
}
