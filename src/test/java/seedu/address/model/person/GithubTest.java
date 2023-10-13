package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GithubTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Github(null));
    }

    @Test
    public void equals() {
        Github github = new Github("alexyeoh");
        assertTrue(github.equals(new Github("alexyeoh")));

        assertTrue(github.equals(github));

        assertFalse(github.equals(5.0f));

        assertFalse(github.equals(new Github("zhiwang")));
    }
}
