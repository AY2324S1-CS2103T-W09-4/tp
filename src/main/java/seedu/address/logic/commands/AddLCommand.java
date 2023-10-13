package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Adds LinkedIn account to candidate's existing details.
 */
public class AddLCommand extends Command {
    public static final String COMMAND_WORD = "addL";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds LinkedIn to details of a candidate. "
            + "Parameters: " + "[" + COMMAND_WORD + " <USERID> <USERNAME>]...\n"
            + "Example: " + COMMAND_WORD + " 2 alexyeoh";

    public static final String MESSAGE_SUCCESS = "LinkedIn account added for: %1$s";

    private final int targetIndex;

    private final String username;

    /**
     * Creates an AddL command to add LinkedIn.
     * @param targetIndex
     * @param username
     */
    public AddLCommand(int targetIndex, String username) {
        this.targetIndex = targetIndex;
        this.username = username;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult(String.format(MESSAGE_SUCCESS, "PLACEHOLDER"));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("targetIndex", targetIndex).add("username", username).toString();
    }

}
