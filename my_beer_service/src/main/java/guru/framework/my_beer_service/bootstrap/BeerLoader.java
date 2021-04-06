package guru.framework.my_beer_service.bootstrap;

import guru.framework.my_beer_service.domain.Beer;
import guru.framework.my_beer_service.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Beer1")
                    .beerStyle("IPA")
                    .upc(12635127635L)
                    .minOnHand(12)
                    .price(new BigDecimal("12.99"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Beer2")
                    .beerStyle("Pale Ale")
                    .upc(123123123L)
                    .minOnHand(22)
                    .price(new BigDecimal("10.99"))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
