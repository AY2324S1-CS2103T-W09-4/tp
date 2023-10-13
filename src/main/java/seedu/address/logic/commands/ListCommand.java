package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;
import seedu.address.model.person.Person;

import java.util.Comparator;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all persons. "
            + "Parameters: [s/ATTRIBUTE]\n"
            + "Optional: ATTRIBUTE can be 'name' or other attributes for sorting.\n"
            + "Example: " + COMMAND_WORD + " s/name";

    private final Comparator<Person> sortingComparator;


    public ListCommand() {
        // Default constructor for no sorting
        this.sortingComparator = null;
    }

    public ListCommand(Comparator<Person> sortingComparator) {
        this.sortingComparator = sortingComparator;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        if (sortingComparator != null) {
            // If a sorting comparator is provided, sort the list using it
            model.sortPersonList(sortingComparator);
        }

        System.out.println(model.getFilteredPersonList());
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
