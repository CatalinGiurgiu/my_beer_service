package guru.framework.my_beer_service.web.mappers;

import guru.framework.my_beer_service.domain.Beer;
import guru.framework.my_beer_service.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTO beerDTO);
}
