package com.redoz.onclass.domain.api.usecase;

import com.redoz.onclass.domain.api.ITechnologyServicePort;
import com.redoz.onclass.domain.exception.NoDataFoundException;
import com.redoz.onclass.domain.exception.TechnologyAlreadyExistsException;
import com.redoz.onclass.domain.model.Technology;
import com.redoz.onclass.domain.spi.ITechnologyPersistencePort;
import com.redoz.onclass.domain.util.DomainConstants;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void saveTechnology(Technology technology) {
        if (technologyPersistencePort.findTechnologyByName(technology.getName()).isPresent()){
            throw new TechnologyAlreadyExistsException(technology.getName());
        }

        technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public List<Technology> findAllTechnologies(int page, int size, boolean isAsc) {
        List<Technology> technologies = technologyPersistencePort.findAllTechnologies(page, size, isAsc);

        if (technologies.isEmpty()){
            throw new NoDataFoundException(DomainConstants.NO_DATA_FOUND_TECHNOLOGY_EXCEPTION_MESSAGE);
        }

        return technologies;
    }
}
