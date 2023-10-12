package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.StatusTypes;

/**
 * Sets the status of a person in the address book.
 */
public class SetCommand extends Command {
    public static final String COMMAND_WORD = "set";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sets the status of a person. " + "Parameters: " + "[" + COMMAND_WORD + " <USERID> <STATUS>]...\n" + "Example: " + COMMAND_WORD + " 5 Interviewed";

    public static final String MESSAGE_SUCCESS = "Status set for: %1$s";

    private final int targetIndex;
    private final StatusTypes newStatus;

    /**
     * Creates a SetCommand to set the status of the person at the specified target index.
     *
     * @param targetIndex The index of the person to set the status.
     * @param newStatus   The new status to set.
     */
    public SetCommand(int targetIndex, StatusTypes newStatus) {
        this.targetIndex = targetIndex;
        this.newStatus = newStatus;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        /*if (!model.hasPersonAtIndex(targetIndex)) {
            throw new CommandException("Invalid index. Please provide a valid person index.");
        }

        Person personToSetStatus = model.getPersonAtIndex(targetIndex);
        Status personStatus = personToSetStatus.getStatus();
        personStatus.setStatusType(newStatus);

        return new CommandResult(String.format(MESSAGE_SUCCESS, personToSetStatus.getName()));*/
        return new CommandResult(String.format(MESSAGE_SUCCESS, "PLACEHOLDER"));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof SetCommand)) {
            return false;
        }

        SetCommand otherSetCommand = (SetCommand) other;
        return targetIndex == otherSetCommand.targetIndex && newStatus.equals(otherSetCommand.newStatus);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("targetIndex", targetIndex).add("newStatus", newStatus).toString();
    }
}
