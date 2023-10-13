package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.StatusContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "search";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the name keywords (case-insensitive) and (if specified) whose status contain any of the status"
            + "keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " n/alex bernice s/interviewed";

    private final NameContainsKeywordsPredicate namePredicate;
    private final StatusContainsKeywordsPredicate statusPredicate;

    public FindCommand(NameContainsKeywordsPredicate namePredicate, StatusContainsKeywordsPredicate statusPredicate) {
        this.namePredicate = namePredicate;
        this.statusPredicate = statusPredicate;
    }


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(namePredicate);
        if (statusPredicate == null) {
            model.updateFilteredPersonList(statusPredicate);
        }
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindCommand)) {
            return false;
        }

        FindCommand otherFindCommand = (FindCommand) other;
        return namePredicate.equals(otherFindCommand.namePredicate) && statusPredicate.equals(otherFindCommand.statusPredicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name predicate", namePredicate)
                .add("status predicate", statusPredicate)
                .toString();
    }
}
