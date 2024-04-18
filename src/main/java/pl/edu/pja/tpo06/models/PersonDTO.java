package pl.edu.pja.tpo06.models;

public class PersonDTO {

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String university;

    private String address;

    private String countryOfOrigin;

    private String jobTitle;

    private String favouriteAnimal;

    public PersonDTO(String firstName, String lastName, String dateOfBirth, String university, String address, String countryOfOrigin, String jobTitle, String favouriteAnimal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.university = university;
        this.address = address;
        this.countryOfOrigin = countryOfOrigin;
        this.jobTitle = jobTitle;
        this.favouriteAnimal = favouriteAnimal;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUniversity() {
        return university;
    }

    public String getAddress() {
        return address;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
    }
}
