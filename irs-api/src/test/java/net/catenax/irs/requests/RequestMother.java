package net.catenax.irs.requests;

import com.github.javafaker.Faker;
import net.catenax.irs.dtos.PartsTreeView;
import net.catenax.irs.entities.EntitiesMother;
import net.catenax.irs.entities.PartIdEntityPart;

import static net.catenax.irs.dtos.ValidationConstants.VIN_FIELD_LENGTH;

public class RequestMother {
    /**
     * JavaFaker instance used to generate random data.
     */
    private final Faker faker = new Faker();

    private final EntitiesMother generate = new EntitiesMother();

    public PartsTreeByVinRequest byVin(String vin) {
        return PartsTreeByVinRequest.builder()
                .vin(vin)
                .view(faker.options().option(PartsTreeView.class).name())
                .build();
    }

    public PartsTreeByObjectIdRequest byObjectId(PartIdEntityPart partId) {
        return PartsTreeByObjectIdRequest.builder()
                .oneIDManufacturer(partId.getOneIDManufacturer())
                .objectIDManufacturer(partId.getObjectIDManufacturer())
                .view(faker.options().option(PartsTreeView.class).name())
                .build();
    }

    public PartsTreeByObjectIdRequest byObjectId() {
        return byObjectId(generate.partId());
    }

    public PartsTreeByVinRequest byVin() {
        return byVin(faker.lorem().characters(VIN_FIELD_LENGTH));
    }
}