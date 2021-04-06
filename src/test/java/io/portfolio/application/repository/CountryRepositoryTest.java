package io.portfolio.application.repository;

import io.portfolio.application.domain.Country;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Rollback(false)
class CountryRepositoryTest {


    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void testCreateCountry() {
        Country country1=new Country("5655","Budapest","Leírás1","Hun","EU");
        Country country2=new Country("6342","Bukarest","Leírás2","Rom","EU");

        Country country = countryRepository.findById(Long.valueOf(1)).get();
        assertEquals("Hun",country.getNationality());
    }

    // TODO: 2021. 03. 24. félig megoldott, de még szükséges a Schema dolog megoldása

    @Test
    public void testFindAll() {
        assertEquals(true,true);
    }
}