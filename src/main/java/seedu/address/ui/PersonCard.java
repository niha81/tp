package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label gender;
    @FXML
    private Label appointmentDate;
    @FXML
    private Label remark;
    @FXML
    private FlowPane conditions;
    @FXML
    private FlowPane details;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        gender.setText(person.getGender().gender);
        appointmentDate.setText(person.getAppointmentDate().value);
        remark.setText(person.getRemark().value);
        person.getConditionTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> conditions.getChildren().add(new Label(tag.tagName)));
        person.getDetailTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> details.getChildren().add(new Label(tag.tagName)));
    }
}
