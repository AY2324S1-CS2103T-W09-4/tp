---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# JABPro User Guide

## Product Overview

JobApplicationsBook Pro (JABPro) is a **desktop app for hiring managers of companies to ease the management of applicants, optimized for use via a  Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, JABPro can get your applicant management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />


--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `jabpro.jar` from [here](https://github.com/AY2324S1-CS2103T-W09-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your JabPro.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar jabpro.jar` command to run the application.<br>  
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>  
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it.<br>
   Some example commands you can try:

    * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`: adds an applicant with the specified contact details

    * `remark 1 r/Great attitude, hardworking`: edits the remark of the 1st person on the list to have a remark `Great attitude, hardworking`

    * `search n/John`: Searches for applicants whose names contain the keyword `John`

    * `delete 3` : Deletes the 3rd contact shown in the current list.

    * `set` : sets the applicant status to either of: (Preliminary, Interviewed, Rejected, Offered)

    * `add linkedin 1 alexyeoh`: Adds LinkedIn account to candidate's existing contact information

    * `github Alex Yeoh`: Redirects the user to the Github account of the candidate


1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<box type="tip" seamless>

**Tip:** A person can have any number of tags (including 0)
</box>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Adding a remark to a person: `remark`

Edits a remark to an existing person to the address book

Format: `remark INDEX r/REMARK`

* Edits the remark for the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* The previous remark is not saved, and instead is replaced by the inputted remark. The command does not add to the existing remark
* You can empty out a remark by inputting an empty string

Examples:
*  `remark 1 r/Great attitude, hardworking` Edits the remark of the 1st person on the list to have a remark `Great attitude, hardworking`
*  `remark 1 r/` Empties the remark of the 1st person.

### Viewing a person's details: `view`

Creates a complete view for details of a person in the address book

Format: `view INDEX`

* Shows the complete details of the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* The index used will be the same as the index used in the `list` command.
* Compatible with search and other features that change the order and content of the list.

Examples:
* `view 1` Shows the complete details of the 1st person on the list.

<box type="tip" seamless>

**Tip:** Other operations that affect user's data will trigger a refresh of the view.
These include `add`, `edit`, `set`, `remark`, `addL`, `addG` 


</box>


### Adding Github/LinkedIn username for a user: 'add linkedin/github'

Adds the username for their social profile [LinkedIn/Github] to the existing contact details of users

Format: `addL INDEX u/USERNAME` or `addG INDEX u/USERNAME`

Examples:
* `addG 2 u/MadLamprey`
* `addL 4 u/aditya-misra`

### Opening user LinkedIn or GitHub account: 'linkedin' or 'github'

Redirect user to candidate's LinkedIn or Github account

Format: `linkedin INDEX` or `github INDEX`

Examples:
* `linkedin 1`
* `github 2`

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list so/ATTRIBUTE`

* `so/ATTRIBUTE` is completely **optional**, on default will NOT be sorted.
* As of v1.2, the attributes that are supported are `name` and `email`.
* Attribute is case-insensitive: `list so/NAME` and `list so/name` return the same result.
* The result will be sorted in **ascending** order.
* Note: as of v1.2, the sorting algorithm is case-sensitive, which means it will treat uppercase and 
lowercase letters as distinct. This may result in names being sorted as A B C a b c, rather than A a B b C c.

Examples:
* `list` Shows a list of all persons.
* `list s/name` Show a list of all persons, sorted by name in ascending order.

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
  specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Search job applicants by category: `search`

Finds job applicants whose profiles match the specified categories' keywords. The search categories are: name, status

#### Search job applicants by name

Finds job applicants whose names contain the given keywords.

Format: `search n/KEYWORD [MORE KEYWORDS]`

* Keywords are case-insensitive: `search n/Josh` and `search n/josh` return the same result.
* Keyword has to be a string that does not contain any non-alpha numeric characters.
* The order of the keywords does not matter. e.g. `Josh Peck` will match `Peck Josh`
* Only full words will be matched e.g. `Jo` will not match `Josh`
* Applicants matching at least one keyword will be returned (i.e. `OR` search)
  e.g. `Josh Peck` will return `Josh Gad`, `Josh Job`

Examples:
* `search n/John` returns `john` and `John Doe`
* `search n/david` returns `Alex Yeoh`, `David Li`<br>

#### Search job applicants by status

Finds job applicants whose status match any of the given keywords

Format: `search s/KEYWORD [MORE KEYWORDS]`

* Keywords can only be from the following list: `Pending`, `Interviewed`, `Rejected`, `Offered`
  e.g. `search s/interviewing` will give an error.
* Keywords are case-insensitive: `search s/interviewd` and `search s/INTERVIEWED` return the same result.

Example:
* `search s/interviewed`

#### Notes for advanced users:
* You can combine the name and status search categories (e.g. `search n/Alex s/offered`) in a single search command.
* Each search category can be used at most once in a single search command
  e.g. `search n/Alex n/Adam s/rejected` is not allowed.

Example:
* `search n/Alex Bernice s/interviewed rejected` will output applicants whose:
    * names contain either Alex `or` Bernice
    * `and` status is either interviewed `or` rejected.

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Setting an applicant's status : `set`

Format: `set INDEX STATUS`

Sets the applicant to a specific status ("Preliminary"/ "Interviewed"/ "Rejected"/ "Offered")

* Sets the person at the specified `INDEX` to a specific hiring status.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​
* The status must be a string of exactly "Preliminary", "Interviewed", "Rejected" or "Offered".

Examples:
* `list` followed by `set 2 Interviewed` sets the 2nd person in the address book to "Interviewed".
* `find Betsy` followed by `set 1 Interviewed` sets the status of 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exporting all entries : `export`

Exports the entries into a .csv file

Format: `export`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action                     | Format, Examples
---------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add**                    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Remark**                 | `remark r/REMARK` <br> e.g., `remark 1 r/Great attitude, hardworking`
**View**                   | `view INDEX` <br> e.g., `view 1`
**Add Github/LinkedIn**    | `addL INDEX u/USERNAME` or `addG INDEX u/USERNAME` e.g., `addL 1 u/alex-yeoh`, `addG 2 u/bernicesanders123`
**Open Github/LinkedIn**   | `linkedin INDEX` or `github INDEX` e.g., `linkedin 1`, `github 2`
**Clear**                  | `clear`
**Delete**                 | `delete INDEX`<br> e.g., `delete 3`
**Set**                    | `set INDEX STATUS`<br> e.g., `set 2 Interviewed`
**Edit**                   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find**                   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List**                   | `list s/ATTRIBUTE` <br> e.g. `list s/name`
**Export**                 | `export`
**Help**                   | `help`


