package com.example.centre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentreService {

    @Autowired
    private CentreRepository centreRepo;

   // @Autowired
   // private EvenementRepository evenementRepo;

    public ImplCentreService()
    {
        super();
    }
 //   @Autowired
//    private ModelMapper mapper;
    @Override
    public CentreDto createCentre(CentreDto request) {
        Centre entity = this.centreRepo.save(mapper.map(request, Centre.class));
        return mapper.map(entity, CentreDto.class);
    }

    @Override
    public List<CentreDto> getAll() {
        List<CentreDto> list = this.centreRepo.findAll().stream().map( e -> mapper.map(e, CentreDto.class)).collect(Collectors.toList());
        return list;
    }

    @Override
    public CentreDto deleteCentre(int id) {
        CentreDto centre = this.getById(id);
        this.centreRepo.deleteById(id);
        return centre;
    }

    @Override
    public CentreDto getById(int id) {
        Centre entity = this.centreRepo.findById(id).orElseThrow(() ->
                new NotFoundException("CENTRE_ERR.NOT_FOUND"));
        return mapper.map(entity, CentreDto.class);
    }

    @Override
    public CentreDto updateCentre(int id, CentreDto request) {
        Centre oldEntity = mapper.map(this.getById(id), Centre.class);
        Centre requestEntity = mapper.map(request,Centre.class);

        if (requestEntity.getName() != null)
            oldEntity.setName(requestEntity.getName());

        if (requestEntity.getDescription() != null)
            oldEntity.setDescription(requestEntity.getDescription());

        if (requestEntity.getVille() != null)
            oldEntity.setVille(requestEntity.getVille());


        return mapper.map(this.centreRepo.save(oldEntity), CentreDto.class);
    }

    @Override
    public List<EvenementDto> getEventByCentreId(int id) {
        Centre centre = this.centreRepo.findById(id).orElseThrow( () ->
                new NotFoundException("CENTRE_ERR.NOT_FOUND"));
        List<EvenementDto> listDto = centre.getEvenements().stream().map(e ->
                mapper.map(e, EvenementDto.class)).collect(Collectors.toList());
        return listDto;
    }


}
