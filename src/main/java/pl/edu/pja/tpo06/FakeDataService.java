package pl.edu.pja.tpo06;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import pl.edu.pja.tpo06.models.PersonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class FakeDataService {

    Faker faker;

    public List<PersonDTO> generatePeople(
            int number,
            String language,
            boolean needUniversity,
            boolean needAddress,
            boolean needCountry,
            boolean needJobTitle,
            boolean needFavouriteAnimal
    ) {
        faker = new Faker(Locale.forLanguageTag(language));
        List<PersonDTO> people = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            people.add(new PersonDTO(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.date().birthday().toString(),
                    needUniversity ? faker.university().name() : null,
                    needAddress ? faker.address().fullAddress() : null,
                    needCountry ? faker.country().name() : null,
                    needJobTitle ? faker.job().title() : null,
                    needFavouriteAnimal ? faker.animal().name() : null
            ));
        }
        return people;
    }
}
